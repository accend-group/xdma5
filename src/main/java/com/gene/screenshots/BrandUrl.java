package com.gene.screenshots.utils;

import com.gene.screenshots.Variables;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Scanner;

import static com.gene.screenshots.utils.Type.*;


public class BrandUrl {

    // testType used to run specific parts in selenium code
    private Type testType;
    private static JSONArray jsonUrls;
    private String domain;
    private static HashMap<String, HashMap<Type, String>> environments = new HashMap<>();

    public static void loadEnvironments(File path){
        try {
            jsonUrls = new JSONArray(new Scanner(path).useDelimiter("\\Z").next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < jsonUrls.length(); ++i) {
            JSONObject domain = jsonUrls.getJSONObject(i);
            HashMap<Type, String> urls = new HashMap<>();
            JSONObject types = domain.getJSONObject("types");
            urls.put(DEV, types.getString("dev"));
            urls.put(PROD, types.getString("prod"));
            urls.put(STAGE, types.getString("stage"));
            urls.put(LOCAL, types.getString("local"));
            environments.put( domain.getString("name"), urls);
        }
    }

    public BrandUrl(String jobType, Type environmentType){
        testType = environmentType;
        domain = environments.get(jobType).get(environmentType);
    }

    public Type getType(){
        return testType;
    }


    @Override
    public String toString(){
        return domain;
    }
}