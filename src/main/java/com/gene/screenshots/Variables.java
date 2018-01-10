package com.gene.screenshots;


// used for getting Jenkins parameters

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.io.File;

import static com.gene.screenshots.EnvironmentType.*;

public class Variables {

    private static String chromedriverPath;

    // where main directory is set for creating images in sub directories for each selenium script that needs a pdf
    private static String savePath = "target/screenshots";
    private static String pdfOutputPath = "target/screenshots/pdfs";
    private static String bucketName = null;
    private static String region = null;
    private static String awsSecretKey = null;
    private static String awsAccessKey = null;

    // needed for json url type
    private static Object jobType = null;

    private static EnvironmentType environmentType = LOCAL;

    private static boolean ifMergePDF = true;

    private static boolean validArgument(String param, String arg){
        return arg.contains(param) && arg.indexOf(param) == 0;
    }


    private static String authorUsername = null;
    private static String authorPassword = null;

    public static void main(String[] args) {

        for (String arg : args) {

            if(arg.equals("pdfbreakpoint=false"))
                ifMergePDF = false;

            if(validArgument("environment=", arg)) {
                String url = arg.substring(12, arg.length());
                switch(url){
                    case "dev": environmentType = DEV; break;
                    case "stage" : environmentType = STAGE; break;
                    case "prod" : environmentType = PROD; break;
                    case "author-local" : environmentType = AUTHOR_LOCAL; break;
                    case "author-dev" : environmentType = AUTHOR_DEV; break;
                    case "author-prod" : environmentType = AUTHOR_PROD; break;
                    case "author-stage" : environmentType = AUTHOR_STAGE; break;
                }
            }

            if(validArgument("author-username=", arg))
                authorUsername = arg.substring(13, arg.length());
            if(validArgument("author-password=", arg))
                authorUsername = arg.substring(16, arg.length());

            if(validArgument("aws-accesskey=", arg))
                awsAccessKey = arg.substring(14, arg.length());
            if(validArgument("aws-secretkey=", arg))
                awsSecretKey = arg.substring(14, arg.length());
            if(validArgument("s3-bucket=", arg))
                bucketName = arg.substring(10, arg.length());
            if(validArgument("s3-region=", arg)){
                region = arg.substring(10, arg.length());
                if(region.equals(""))
                    region = null;
            }

            if(validArgument("jobtype=",arg)){
                jobType =  arg.substring(8, arg.length());
            }
        }

        if(jobType == null){
            System.out.println("Error: No job specified!");
            System.exit(1);
        }

        // if ID or name of Job
        try {
            Long ID = Long.parseLong((String) jobType);
            jobType = ID;
        } catch (NumberFormatException e) {}

        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win"))
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver.exe";
        else
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        File dir = new File(savePath);
        dir.mkdirs();
        dir = new File(pdfOutputPath);
        dir.mkdirs();
    }

    public static EnvironmentType getEnvironmentType(){
        return environmentType;
    }

    public static boolean isIfMergePDF() {
        return ifMergePDF;
    }

    public static Object getJob(){
        return jobType;
    }

    public static String getChromedriverPath() {
        return chromedriverPath;
    }

    public static String getPdfOutputPath() {
        return pdfOutputPath;
    }

    public static String getAwsSecretKey() {
        return awsSecretKey;
    }

    public static String getAwsAccessKey() {
        return awsAccessKey;
    }

    public static String getBucketName() {
        return bucketName;
    }

    public static String getSavePath() {
        return savePath;
    }

    public static String getRegion() {
        return region;
    }


    public static String getAuthorUsername() {
        return authorUsername;
    }

    public static String getAuthorPassword() {
        return authorPassword;
    }

}