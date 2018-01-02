package com.gene.screenshots;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.gene.screenshots.EnvironmentType.*;


public class BrandUrl {

    // testType used to run specific parts in selenium code
    private EnvironmentType testType;
    private static JSONArray jsonUrls;

    // the url to use when testing screenshots
    private String domain;

    private static HashMap<Object, HashMap<EnvironmentType, String>> environments = new HashMap<>();

    public static void addEnvironments(Object jobType, HashMap<EnvironmentType, String> urlsMap){
        environments.put(jobType, urlsMap);
    }

    public static void loadEnvironments(File path){
        try {
            jsonUrls = new JSONArray(new Scanner(path).useDelimiter("\\Z").next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(NoSuchElementException j){
            System.out.println("Warning: json file is incorrect");
            return;
        }
        for(int i = 0; i < jsonUrls.length(); ++i) {
            JSONObject domain = jsonUrls.getJSONObject(i);
            HashMap<EnvironmentType, String> urls = new HashMap<>();
            JSONObject types = domain.getJSONObject("types");
            urls.put(DEV, types.getString("dev"));
            urls.put(PROD, types.getString("prod"));
            urls.put(STAGE, types.getString("stage"));
            urls.put(LOCAL, types.getString("local"));
            environments.put(domain.getString("name"), urls);
            environments.put(domain.getLong("id"), urls);
        }
    }

    public BrandUrl(Object jobType, EnvironmentType environmentType){
        testType = environmentType;

        // In case job type is not found from the json data
        try {
            domain = environments.get(jobType).get(environmentType);
        } catch (Exception e) {
            System.out.println("Error! Job " + jobType + " not recognized");
            System.exit(1);
        }
    }

    public EnvironmentType getType(){
        return testType;
    }


    @Override
    public String toString(){
        return domain;
    }
}