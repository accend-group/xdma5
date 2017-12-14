package com.gene.screenshots.utils;

import com.gene.screenshots.Variables;

//TODO fix so it doesn't create a new object
public enum  TestUrl {
    LOCAL("local"),
    PROD("prod"),
    DEV("dev"),
    STAGE("stage");

    private String domain;

    private TestUrl(String domain){
        if(domain.equals("local"))
            return;
        if(domain.equals("dev")){
            this.domain = Variables.isAccessSolutions() ? "https://www.dev-genentech-access.gene.com" : "https://www.dev-kadcyla.gene.com";
        }
        if(domain.equals("prod"))
            this.domain = Variables.isAccessSolutions() ? "https://www.genentech-access.com" : "https://www.kadcyla.com";
        if(domain.equals("stage"))
            this.domain = Variables.isAccessSolutions() ? "https://www.stage-genentech-access.gene.com" : "https://www.stage-perjeta.gene.com";

    }

    public String toString(){
        return domain;
    }

    public static String strip(){
        if(Variables.isAccessSolutions())
            return "http://localhost:4503/content/accesssolutions-site/en_us";
        return "http://localhost:4503/content/kadcyla/en_us";
    }
}