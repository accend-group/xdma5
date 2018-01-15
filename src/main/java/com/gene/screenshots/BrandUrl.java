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

        switch(environmentType) {
            case LOCAL: domain = environment.local(); break;
            case DEV: domain = environment.dev(); break;
            case STAGE: domain = environment.stage(); break;
            case PROD: domain = environment.prod(); break;
            case AUTHOR_LOCAL: domain = environment.authorlocal(); break;
            case AUTHOR_DEV: domain = environment.authordev(); break;
            case AUTHOR_STAGE: domain = environment.authorstage(); break;
            case AUTHOR_PROD: domain = environment.authorprod(); break;
        }

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