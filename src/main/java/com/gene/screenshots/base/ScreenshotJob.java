package com.gene.screenshots.base;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.Variables;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.SeleniumHeadless;


import java.io.*;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// What to do with the pdf(s)
// provides functions to zip results (single pdf or multiple pdfs)

public abstract class ScreenshotJob extends ScreenshotThreads {


    private static List<SeleniumHeadless> screenshotCodes;

    protected static void setScript(SeleniumHeadless script){
        if(screenshotCodes == null)
            screenshotCodes = new LinkedList<>();
        screenshotCodes.add(script);
    }

    protected static void setScripts(List<SeleniumHeadless> scripts){
        screenshotCodes = scripts;
    }

    public String getJobName(){
        Annotation job = this.getClass().getDeclaredAnnotation(Job.class);
        return ((Job) job).name();
    }

    // create screenshot and pdf thread workers
    public void createResult(){
        if(screenshotCodes == null) {
            System.out.println("Error: no screenshots set for Job!");
            return;
        }
        for(SeleniumHeadless script : screenshotCodes)
            createThreads(script);
    }

    // send pdf/zip
    public void sendResult(AmazonS3 s3){
        if(screenshotCodes == null) {
            System.out.println("Error: no screenshots set for Job!");
            return;
        }
        // single script job and single pdf
        if(screenshotCodes.size() == 1 && SeleniumHeadless.isIfSinglePDF())
            sendPDFtoS3(s3);
        // multiple scripts and/or single/separated pdfs
        else
            sendZipToS3(s3);
    }

    /***
     *  Sends zip file to S3
     *  if zipping up only pdfs from a single selenium script screenshotCode must not be null
     *  if zipping multiple selenium scripts screenshotCodes must not be null
     */
    protected void sendZipToS3(AmazonS3 s3) {

        String zipPath = savePath + "/zips";
        String zipName = getJobName();

        ArrayList<String> pdfNames = new ArrayList();

        int expectedPDFs = screenshotCodes.size();
        for (int i = 0; i < expectedPDFs; i++) {
            if (SeleniumHeadless.isIfSinglePDF()) {
                String filePath = screenshotCodes.get(i).getClass().getSimpleName() + ".pdf";
                if (ifFileExisits(filePath))
                    pdfNames.add(filePath);
            } else {
                String desktopPath = "desktop_" + screenshotCodes.get(i).getClass().getSimpleName() + ".pdf";
                String mobilePath = "mobile_" + screenshotCodes.get(i).getClass().getSimpleName() + ".pdf";
                if (ifFileExisits(desktopPath))
                    pdfNames.add(desktopPath);
                if (ifFileExisits(mobilePath))
                    pdfNames.add(mobilePath);
            }
        }

        createZip(pdfNames, zipName, zipPath);

        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("Sending " + zipName + " zip file...");
        String filePath = zipPath + "/" + zipName + ".zip";
        String key =  String.format("%s-%s-%s.zip", zipName, Variables.getEnvironmentType(), date);
        sendObject(s3, key, filePath);
        System.out.println("zip sent!");
    }

    // screenshotCodes must only contain one script
    protected void sendPDFtoS3(AmazonS3 s3) {
        String screenshotScriptName = screenshotCodes.get(0).getClass().getSimpleName();
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("Sending " + getJobName() + " pdf file...");
        String filePath = pdfSavePath + "/" + screenshotScriptName + ".pdf";
        String key = String.format("%s-%s-%s.pdf", getJobName(), Variables.getEnvironmentType(), date);
        sendObject(s3, key, filePath);
        System.out.println("pdf sent!");
    }

    protected static void sendObject(AmazonS3 s3, String key, String filePath){
       try {
            s3.putObject(Variables.getBucketName(), key, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
       }
    }

    protected static void createZip(ArrayList<String> files, String zipName, String zipPath) {
        final int BUFFER = 8192;
        String pdfPaths = Variables.getPdfOutputPath();
        (new File(zipPath)).mkdirs();
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipPath + "/" + zipName + ".zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];


            for (int i = 0; i < files.size(); i++) {
                FileInputStream fi = new FileInputStream(pdfPaths + "/" + files.get(i));
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(files.get(i));

                out.putNextEntry(entry);
                int count;
                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean ifFileExisits(String filePath){
        return Files.exists(Paths.get(pdfSavePath + "/" + filePath));
    }
}
