package com.gene.screenshots;


// used for getting Jenkins parameters

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.io.File;

import static com.gene.screenshots.EnvironmentType.*;

public class Variables {

    private static String chromedriverPath;

    // where main directory is set for creating images in sub directories for each selenium script that needs a pdf
    private static String savePath = "target/screenshots";
    private static String pdfOutputPath = null;
    private static String bucketName = null;
    private static String region = null;
    private static String awsSecretKey = null;
    private static String awsAccessKey = null;


    private static boolean s3Local = false;
>>>>>>> annotation changes, json contains ID of automation job, a JOB_TYPE can be a id or job name

    // needed for json url type
    private static Object jobType = null;

    private static BrandUrl domain = null;


    public static void main(String[] args) {

        EnvironmentType environmentType = LOCAL;

        for (String arg : args) {

            if(arg.equals("pdfbreakpoint=true"))
                SeleniumHeadless.setIfSinglePDF(false);

            if (arg.contains("savepath=") && arg.indexOf("savepath=") == 0) {
                savePath = arg.substring(9, arg.length());
                if(savePath.equals("") || savePath == null)
                    savePath = "target/screenshots";
                File dir = new File(savePath);
                dir.mkdirs();
            }
            if (arg.contains("pdfoutput=") && arg.indexOf("pdfoutput=") == 0) {
                pdfOutputPath = arg.substring(10, arg.length());
                if (pdfOutputPath.equals(""))
                    pdfOutputPath = null;
                else {
                    File dir = new File(pdfOutputPath);
                    dir.mkdirs();
                }
            }

            if(arg.contains("environment=") && arg.indexOf("environment=") == 0) {
                String url = arg.substring(12, arg.length());
                if(url.equals("dev"))
                    environmentType = DEV;
                if(url.equals("stage"))
                    environmentType = STAGE;
                if(url.equals("prod"))
                    environmentType = PROD;
            }

<<<<<<< HEAD
            if(arg.contains("jobtype=") && arg.indexOf("jobtype=") == 0){
                jobType =  arg.substring(8, arg.length());
                switch(jobType){
                    case "Access_Solutions":
                        accessSolutions = true; break;
                    case "Kadcyla_HCP":
                        kadcylaHCP = true; break;
                    case "Kadcyla_Patient":
                        kadcylaPatient = true; break;
                }
            }

            if (arg.equals("s3=true"))
                s3 = true;
=======
            if (arg.equals("aws-local=true"))
                s3Local = true;
>>>>>>> annotation changes, json contains ID of automation job, a JOB_TYPE can be a id or job name
            if (arg.contains("aws-accesskey=") && arg.indexOf("aws-accesskey=") == 0)
                awsAccessKey = arg.substring(14, arg.length());
            if (arg.contains("aws-secretkey=") && arg.indexOf("aws-secretkey=") == 0)
                awsSecretKey = arg.substring(14, arg.length());
            if (arg.contains("s3-bucket=") && arg.indexOf("s3-bucket=") == 0)
                bucketName = arg.substring(10, arg.length());
            if (arg.contains("s3-region=") && arg.indexOf("s3-region=") == 0) {
                region = arg.substring(10, arg.length());
                if(region.equals(""))
                    region = null;
            }

            if(arg.contains("jobtype=") && arg.indexOf("jobtype=") == 0){
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
            domain = new BrandUrl(ID, environmentType);
        } catch (NumberFormatException e) {
            domain = new BrandUrl((String)jobType, environmentType);
        }


        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win"))
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver.exe";
        else
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        if(pdfOutputPath == null){
           pdfOutputPath =  "target/screenshots/pdfs";
            File dir = new File(pdfOutputPath);
            dir.mkdirs();
        }


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

<<<<<<< HEAD
    public static boolean isS3() {
        return s3;
    }

    public static boolean isUseThreads() {
        return useTheads;
    }

    public static int getThreadCount() {
        return threadCount;
=======
    public static boolean isS3Local() {
        return s3Local;
>>>>>>> annotation changes, json contains ID of automation job, a JOB_TYPE can be a id or job name
    }

    public static BrandUrl getDomain(){
        return domain;
    }
}
