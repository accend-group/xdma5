package com.companyname.myapp;


import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.companyname.myapp.pdf.PDFMaker;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PostRun {

    public static void main(String [] args){


        // create pdf from mobile/desktop images
        PDFMaker mobilePDF = new PDFMaker();
        PDFMaker desktopPDF = new PDFMaker();

        File visMobile = new File(System.getProperty("user.dir") + "/" + "screenshots/visible/mobile");
        File fullMobile = new File(System.getProperty("user.dir") + "/" + "screenshots/entirePage/mobile");
        File visDesktop = new File(System.getProperty("user.dir") + "/" + "screenshots/visible/desktop");
        File fullDesktop  = new File(System.getProperty("user.dir") + "/" + "screenshots/entirePage/desktop");

        File [][] images = new File[4][];

        //TODO filter lists to only include numbered png files
        // mobile image paths
        images[0] = visMobile.listFiles();
        images[1] = fullMobile.listFiles();
        
        // desktop image paths
        images[2] = visDesktop.listFiles();
        images[3] = fullDesktop.listFiles();


        // reverse file lists from descending to ascending order
        for(int x = 0; x < 4; ++x) {
            if(images[x] == null)
                continue;
            for (int i = 0; i < images[x].length / 2; ++i) {
                File t = images[x][i];
                images[x][i] = images[x][images[x].length - 1 - i];
                images[x][images[x].length - 1 - i] = t;
            }
        }

        // assuming image[0] length is the same as image[1]
        try {
            if (images[0] != null && images[1] != null) {
                for (int i = 0; i < images[0].length; ++i) {
                    // add visible image
                    mobilePDF.addImg(images[0][i]);

                    // add desktop image after visible image
                    mobilePDF.addImg(images[1][i]);
                }
                mobilePDF.savePDF("mobile.pdf");
            }

            if (images[2] != null && images[3] != null) {
                for (int i = 0; i < images[2].length; ++i) {
                    // add visible image
                    desktopPDF.addImg(images[2][i]);

                    // add desktop image after visible image
                    desktopPDF.addImg(images[3][i]);
                }
                desktopPDF.savePDF("desktop.pdf");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String bucketPDF = "pdf-screenshot-test";

        // send pdf to s3 server
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())//new EnvironmentVariableCredentialsProvider())
                .withRegion(Regions.US_EAST_1)
                .build();

        //if(!s3.doesBucketExist(bucketPDF))
          //  s3.createBucket(bucketPDF);
        try {
            if(images[0] != null && images[1] != null)
                s3.putObject(bucketPDF, "perjeta_mobile", new File("mobile.pdf"));
            if(images[2] != null && images[3] != null)
                s3.putObject(bucketPDF, "perjeta_desktop", new File("desktop.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
