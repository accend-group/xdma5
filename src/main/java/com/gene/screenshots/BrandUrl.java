package com.gene.screenshots;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import static com.gene.screenshots.EnvironmentType.*;


public class BrandUrl {

    // testType used to run specific parts in selenium code
    private EnvironmentType testType;
    private static JSONArray jsonUrls;

    // the url to use when testing screenshots
    private String domain;

    private static HashMap<String, HashMap<EnvironmentType, String>> environments = new HashMap<>();

    public static void loadEnvironments(File path){
        try {
            jsonUrls = new JSONArray(new Scanner(path).next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < jsonUrls.length(); ++i) {
            JSONObject domain = jsonUrls.getJSONObject(i);
            HashMap<EnvironmentType, String> urls = new HashMap<>();
            JSONObject types = domain.getJSONObject("types");
            urls.put(DEV, types.getString("dev"));
            urls.put(PROD, types.getString("prod"));
            urls.put(STAGE, types.getString("stage"));
            urls.put(LOCAL, types.getString("local"));
            environments.put( domain.getString("name"), urls);
        }
    }

    public BrandUrl(String jobType, EnvironmentType environmentType){
        testType = environmentType;
        domain = environments.get(jobType).get(environmentType);
    }

    public EnvironmentType getType(){
        return testType;
    }


    @Override
    public String toString(){
        return domain;
    }
}