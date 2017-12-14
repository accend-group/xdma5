package com.gene.screenshots.utils;

import com.gene.screenshots.Variables;


public class  TestUrl {


    private static String domain;

    public TestUrl(final String domain){

        if(domain.equals("local"))
            this.domain = strip();
        else if(domain.equals("dev"))
            this.domain = Variables.isAccessSolutions() ? "https://www.dev-genentech-access.gene.com" : "https://www.dev-kadcyla.gene.com";
        else if(domain.equals("prod"))
            this.domain = Variables.isAccessSolutions() ? "https://www.genentech-access.com" : "https://www.kadcyla.com";
        else if(domain.equals("stage"))
            this.domain = Variables.isAccessSolutions() ? "https://www.stage-genentech-access.gene.com" : "https://www.stage-perjeta.gene.com";
    }

    @Override
    public String toString(){
        return domain;
    }

    public static String strip(){
        if(Variables.isAccessSolutions())
            return "http://localhost:4503/content/accesssolutions-site/en_us";
        return "http://localhost:4503/content/kadcyla/en_us";
    }
}