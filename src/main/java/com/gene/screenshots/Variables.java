package com.gene.screenshots;


// used for getting Jenkins parameters

import java.io.File;

public class Variables {

    private static String chromedriverPath = null;

    // where main directory is set for creating images in sub directories for each selenium script that needs a pdf
    private static String savePath = null;
    private static String pdfName = null;
    private static String pdfOutputPath = null;

    private static String bucketName = null;
    private static String pdfKey = null;
    private static String region = null;
    private static String awsSecretKey = null;
    private static String awsAccessKey = null;

    private static boolean s3 = false;
    private static boolean s3Local = false;
    private static boolean accessSolutions = false;
    private static boolean kadcylaHCP = false;
    private static boolean kadcylaPatient = false;

    private static boolean desktopPDF = false;
    private static boolean mobilePDF = false;
    private static boolean bothPDF = true;

    private enum TestUrl {
        PRODUCTION, DEV, QA, AUTHOR
    }

    // defaults to sequential test run
    private static boolean useTheads = false;
    private static int threadCount = 1;

    public static void main(String[] args) {

        for (String arg : args) {
            if (arg.contains("savepath=") && arg.indexOf("savepath=") == 0) {
                savePath = arg.substring(9, arg.length());
                File dir = new File(savePath);
                dir.mkdirs();
            }
            if (arg.contains("pdfoutput=") && arg.indexOf("pdfoutput=") == 0) {
                pdfOutputPath = arg.substring(10, arg.length());
                if (pdfOutputPath == null || pdfOutputPath.equals(""))
                    pdfOutputPath = null;
                else {
                    File dir = new File(pdfOutputPath);
                    dir.mkdir();
                }
            }
            if (arg.contains("pdfname=") && arg.indexOf("pdfname=") == 0)
                pdfName = arg.substring(8, arg.length());
            if (arg.equals("s3=true"))
                s3 = true;
            if (arg.equals("aws-local=true"))
                s3Local = true;
            if (arg.contains("aws-accesskey=") && arg.indexOf("aws-accesskey=") == 0)
                awsAccessKey = arg.substring(14, arg.length());
            if (arg.contains("aws-secretkey=") && arg.indexOf("aws-secretkey=") == 0)
                awsAccessKey = arg.substring(14, arg.length());
            if (arg.contains("s3-bucket=") && arg.indexOf("s3-bucket=") == 0)
                bucketName = arg.substring(10, arg.length());
            if (arg.contains("s3-pdfkey=") && arg.indexOf("s3-pdfkey=") == 0)
                pdfKey = arg.substring(10, arg.length());
            if (arg.contains("s3-region=") && arg.indexOf("s3-region=") == 0) {
                region = arg.substring(10, arg.length());
                if(region.equals(""))
                    region = null;
            }
            if (arg.equals("access-solutions=true"))
                accessSolutions = true;
            if (arg.equals("kadcyla-hcp=true"))
                kadcylaHCP = true;
            if (arg.equals("kadcyla-patient=true"))
                kadcylaPatient = true;
            if (arg.contains("chromedriver=") && arg.indexOf("chromedriver=") == 0)
                chromedriverPath = arg.substring(13, arg.length());
            if (arg.equals("threads=true"))
                useTheads = true;
            if (arg.contains("threadcount=") && arg.indexOf("threadcount=") == 0) {
                try {
                    threadCount = Integer.parseInt(arg.substring(12, arg.length()));
                } catch (NumberFormatException e) {
                    System.out.println("Warning: invalid/empty thread count, Set to default of 1");
                    threadCount = 1;
                }
                if (threadCount <= 0)
                    System.out.println("Warning: set thread count is less that 1! Using single thread!");
            }
        }
    }

    public static boolean isAccessSolutions() {
        return accessSolutions;
    }

    public static boolean isKadyclaHCP() {
        return kadcylaHCP;
    }

    public static boolean isKadcylaPatient() {
        return kadcylaPatient;
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

    public static String getPdfKey() {
        return pdfKey;
    }

    public static String getSavePath() {
        return savePath;
    }

    public static String getRegion() {
        return region;
    }

    public static boolean isS3() {
        return s3;
    }

    public static boolean isS3Local() {
        return s3Local;
    }

    public static boolean isUseTheads() {
        return useTheads;
    }

    public static int getThreadCount() {
        return threadCount;
    }
}
