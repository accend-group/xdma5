package com.companyname.myapp;


import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.companyname.myapp.pdf.PDFMaker;

import java.io.File;
import java.io.IOException;

public class PostRun {

    public static void main(String [] args){


        // create pdf from mobile site images
        PDFMaker mobilePDF = new PDFMaker();
        PDFMaker desktopPDF = new PDFMaker();

        File visMobile = new File(System.getProperty("user.dir") + "/" + "screenshots/visible/mobile");
        File fullMobile = new File(System.getProperty("user.dir") + "/" + "screenshots/entirePage/mobile");
        File visDesktop = new File(System.getProperty("user.dir") + "/" + "screenshots/visible/desktop");
        File fullDesktop  = new File(System.getProperty("user.dir") + "/" + "screenshots/entirePage/desktop");

        File [][] images = new File[4][];
        
        // mobile image paths
        images[0] = visMobile.listFiles();
        images[1] = fullMobile.listFiles();
        
        // desktop image paths
        images[2] = visDesktop.listFiles();
        images[3] = fullDesktop.listFiles();


        // reverse file lists from descending to ascending
        for(int x = 0; x < 4; ++x) {
            if(images[x] == null)
                continue;
            for (int i = 0; i < images[x].length / 2; ++i) {
                File t = images[x][i];
                images[x][i] = images[i][images[i].length - 1 - i];
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
                desktopPDF.savePDF("mobile.pdf");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        // sed pdf to s3 server

        //BasicAWSCredentials credentials = new BasicAWSCredentials("123", "abc");
        //AmazonS3 s3 = new AmazonS3Client(credentials);

        /*AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withPathStyleAccessEnabled(true)
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4568","us-west-1"))
                .build();
        s3.setS3ClientOptions(new S3ClientOptions().withPathStyleAccess(true));
        s3.setEndpoint("http://localhost:4568");//AmazonS3ClientBuilder.standard().withCredentials().withRegion().build();

        //s3.deleteObject("jenkins.test.pdf", "mobileKey");
        //ObjectListing list = s3.listObjects("jenkins-pdf");
        //for()

        if(!s3.doesBucketExist("jenkins.test.pdf"))
            s3.createBucket("jenkins.test.pdf");
        try {
            s3.putObject("jenkins.test.pdf", "mobileKey",new File("perjetaMobile.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
