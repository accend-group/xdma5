package com.gene.screenshots.utils;

import com.gene.screenshots.Variables;

import static com.gene.screenshots.utils.Type.*;


public class TestUrl {

    // testType used to run specific parts in selenium code
    private Type testType;

    private String domain;

    public TestUrl(Type type){

        if(type == LOCAL)
            domain = strip();
        if(type == DEV)
            domain = Variables.isAccessSolutions() ? "https://dev-genentech-access.gene.com" : "https://dev-kadcyla.gene.com";
        if(type == PROD)
            domain = Variables.isAccessSolutions() ? "https://www.genentech-access.com" : "https://www.kadcyla.com";
        if(type == STAGE)
            domain = Variables.isAccessSolutions() ? "https://stage-genentech-access.gene.com" : "https://stage-perjeta.gene.com";
        testType = type;
    }

    public Type getType(){
        return testType;
    }


    @Override
    public String toString(){
        return domain;
    }

    // strip either kadcyla or access solutions urls found in Selenium code
    public  String strip(){
        if(Variables.isAccessSolutions())
            return "http://localhost:4503/content/accesssolutions-site/en_us";
        return "http://localhost:4503/content/kadcyla/en_us";
    }
}