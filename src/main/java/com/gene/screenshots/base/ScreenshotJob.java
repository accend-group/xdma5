package com.gene.screenshots.base;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.Variables;
import com.gene.screenshots.selenium.SeleniumHeadless;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

// What to do with the pdf(s)
public abstract class  ScreenshotJob extends ScreenshotThreads {

    protected SeleniumHeadless screenshotTest;


    // read log create pdf or merge pdfs?
    public void createResult(){
        createThreads(screenshotTest);
    }

    // send pdf(s)?
    public void sendResult(AmazonS3 s3){
        sendPDFtoS3(s3);
    }

    private void sendPDFtoS3(AmazonS3 s3) {

        String testName = screenshotTest.getClass().getSimpleName();
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("Sending " + testName + ".pdf...");
        try {
            s3.putObject(Variables.getBucketName(),
                    String.format("%s-%s-%s.pdf", testName, Variables.getDomain().getType(), date),
                    new File((savePath == null ? Variables.getPdfOutputPath() : savePath + "/pdfs") + "/" + testName + ".pdf"));
            System.out.println("pdf sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
