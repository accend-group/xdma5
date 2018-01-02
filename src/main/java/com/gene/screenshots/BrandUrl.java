package com.gene.screenshots;

import com.gene.screenshots.base.annotations.Environment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.gene.screenshots.EnvironmentType.*;


public class BrandUrl {
    
    // the url to use when testing screenshots
    private String domain;
    private EnvironmentType environmentType; 

    public BrandUrl(Environment environment, EnvironmentType environmentType){
        if(environmentType == LOCAL)
            domain = environment.local();
        if(environmentType == DEV)
            domain = environment.dev();
        if(environmentType == STAGE)
            domain = environment.stage();
        if(environmentType == PROD)
            domain = environment.prod();
        this.environmentType = environmentType;
    }

    public EnvironmentType getType(){
        return environmentType;
    }


    @Override
    public String toString(){
        return domain;
    }
}