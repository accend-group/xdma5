package com.gene.screenshots;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.pdf.PDFMaker;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;


/** Creates a pdf from png images. Each page takes the dimension size of the image.
 *
 * Arguments are:
 *
 * logPath="log.txt path" - where the images and log path are saved at. log file must be named log.txt
 * pdfOutput="pdf output path" - where the pdf saved. 
 *
 * (optional)
 * pdfName="name of pdf" - default is postRun.pdf
 *
 * --------------------------------------------------------------------------------------
 *
 * If storing the pdf to a S3 server all 3 arguments below must be given and credentials must be set
 * s3="true" - if storing pdf at s3 server
 * s3-bucket="bucket name where pdf will be stored"
 * s3-pdfKey="key for storing pdf"
 *
 * (optional)
 * s3-region="region location" - default is us-east-1
 *
 * Either local or both credentials must be set
 * aws-local - uses aws credentials stored in user's credential file.
 * aws-accesskey="access key"
 * aws-secretakey="secret access key"
 *
 * --------------------------------------------------------------------------------------
 */

public class PostRun {

    public static void main(String [] args){

        if(args.length == 0) {
            System.out.println("No log path set!");
            System.exit(1);
        }

        String logPath = null;
        String pdfOutputPath = null;
        String pdfName = "postRun.pdf";

        String awsAccessKey = null;
        String awsSecretAccessKey = null;

        String bucketName = null;
        String pdfKey = null;
        String region = null;

        PDFMaker newPdf = new PDFMaker();
        LinkedList<String> imageNames = new LinkedList<>();

        boolean ifS3 = false;
        boolean awsLocalCredentials = false;

        for(String arg : args) {

            if(arg.contains("logPath="))
                logPath = arg.substring(8, arg.length());

            if(arg.contains("pdfOutput="))
                pdfOutputPath = arg.substring(10, arg.length());


            if(arg.contains("pdfName="))
                pdfName = arg.substring(8, arg.length());

            if(arg.contains("s3=true") || arg.contains("s3=\"true\""))
                ifS3 = true;

            if(arg.contains("aws-local"))
                awsLocalCredentials = true;

            if(arg.contains("aws-accesskey="))
                awsAccessKey = arg.substring(14, arg.length());

            if(arg.contains("aws-secretkey="))
                awsSecretAccessKey = arg.substring(14, arg.length());

            if(arg.contains("s3-bucket="))
                bucketName = arg.substring(10, arg.length());

            if(arg.contains("s3-petKey="))
                pdfKey = arg.substring(10, arg.length());

            if(arg.contains("s3-region="))
                region = arg.substring(10, arg.length());

        }

        // read in images from log
        if(logPath == null) {
            System.out.println("No log path set!");
            System.exit(1);
        }
        System.out.println(logPath);
        try {
            File logFile = new File(logPath);
            FileReader reader = new FileReader(logFile + "/log.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while((line = buffer.readLine()) != null)
                imageNames.add(line);
        } catch (IOException e) {
            //e.printStackTrace();
            if (e instanceof FileNotFoundException)
                System.out.println("No log file found at path!");
            else
                System.out.println("Error reading in log file!");
            System.exit(1);
        }


        // create pdf from images
        if(pdfOutputPath == null)
            pdfOutputPath = logPath;
        try {
            for(String imageName : imageNames){
                newPdf.addImg(logPath + "/" + imageName + ".png");
            }
            newPdf.savePDF(pdfOutputPath + "/" + pdfName);
            newPdf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!ifS3)
            return;

        //String bucketPDF = "pdf-screenshot-test";

        System.out.println("Connecting to S3...");
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(awsLocalCredentials ? new ProfileCredentialsProvider() : new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretAccessKey)))
                .withRegion(region == null ? Regions.US_EAST_1.getName() : region)
                .build();
        
        System.out.println("Sending pdf...");
        try {
            s3.putObject(bucketName, pdfKey, new File(pdfOutputPath + "/" + pdfName));
            System.out.println("pdf sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
