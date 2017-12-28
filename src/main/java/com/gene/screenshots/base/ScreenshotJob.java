package com.gene.screenshots.base;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.Variables;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.SeleniumHeadless;

import java.io.*;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// What to do with the pdf(s)
public abstract class  ScreenshotJob extends ScreenshotThreads {

    protected SeleniumHeadless screenshotCode;

    public String getJobName(){
        Annotation job = this.getClass().getDeclaredAnnotation(com.gene.screenshots.base.annotations.Job.class);
        return ((Job) job).name();
    }

    // read log create pdf or merge pdfs?
    public void createResult(){
        createThreads(screenshotCode);
    }

    // send pdf(s)?
    public void sendResult(AmazonS3 s3){
        if(SeleniumHeadless.isIfSinglePDF())
            sendPDFtoS3(s3);
        else
            sendZipToS3(s3);
    }

    protected void sendZipToS3(AmazonS3 s3){

        String screenshotScriptName = screenshotCode.getClass().getSimpleName();
        createZip(new String[] {"mobile_" + screenshotScriptName + ".pdf", "/desktop_" + screenshotScriptName + ".pdf"},
                screenshotScriptName,
                savePath + "/zips");

        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("Sending " + getJobName() + " zip file...");

        String filePath = savePath + "/zips/" + screenshotScriptName + ".zip";
        String key =  String.format("%s-%s-%s.zip", getJobName(), Variables.getDomain().getType(), date);
        sendObject(s3, key, filePath);

        System.out.println("zip sent!");
    }

    protected void sendPDFtoS3(AmazonS3 s3) {


        String screenshotScriptName = screenshotCode.getClass().getSimpleName();

        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("Sending " + getJobName() + " pdf file...");

        String filePath = savePath + "/pdfs/" + screenshotScriptName + ".pdf";
        String key = String.format("%s-%s-%s.pdf", getJobName(), Variables.getDomain().getType(), date);
        sendObject(s3, key, filePath);

        System.out.println("pdf sent!");
    }

    private void sendObject(AmazonS3 s3, String key, String filePath){
        try {
            s3.putObject(Variables.getBucketName(), key, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void createZip(String [] files, String zipName, String zipPath) {
        final int BUFFER = 8192;
        String pdfPaths = Variables.getPdfOutputPath();
        (new File(zipPath)).mkdirs();
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipPath + "/" + zipName + ".zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];


            for (int i = 0; i < files.length; i++) {
                FileInputStream fi = new FileInputStream(pdfPaths + "/" + files[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(files[i]);

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
}
