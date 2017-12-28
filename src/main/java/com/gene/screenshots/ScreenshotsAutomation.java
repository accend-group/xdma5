package com.gene.screenshots;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.base.ScreenshotThreads;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.reflections.Reflections;


import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * Starts the screenshot process from a jenkins job.
 * All selenium code is expected to support a headless browser
 */

public class ScreenshotsAutomation {

    private static final int THREAD_LIMIT = 2;

    public static void main(String[] args) throws InterruptedException {

        // load in json for urls
        BrandUrl.loadEnvironments(new File("environments.json"));

        System.out.println("Reading Jenkins parameters!");
        Variables.main(args);


        String savePath = Variables.getSavePath();
        System.out.println("Save path is: " + savePath);
        ScreenshotThreads.savePath(savePath);

        SeleniumHeadless.setChromeSystemProperty(Variables.getChromedriverPath());

        // if merging pdfs or creating desktop/mobile pdfs
        SeleniumHeadless.setIfSinglePDF(!Variables.isIfMergePDF());

        ScreenshotThreads.setSemaphore(new Semaphore(THREAD_LIMIT, true));

        // search project path for classes with @Job
        Reflections reflections = new Reflections("com.gene.screenshots.jobs");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Job.class);
        HashMap<Object, Class<?>> annotationsMap = new HashMap<>();
        for (Class<?> class_ : annotated) {
            Annotation info = class_.getDeclaredAnnotation(Job.class);
            annotationsMap.put(((Job) info).ID(), class_);
            annotationsMap.put(((Job) info).name(), class_);
        }

        // get specified job
        ScreenshotJob screenshotJob = null;
        try {
            Job job = annotationsMap.get(Variables.getJob()).getDeclaredAnnotation(Job.class);
            if(job != null)
                System.out.println(String.format("Running %s, ID: %d, Info: %s", job.name(), job.ID(), job.info()));
            screenshotJob = (ScreenshotJob) annotationsMap.get(Variables.getJob()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        // setting the testing domain (prod, stage, dev, local)
        System.out.println("Running automation at: " + Variables.getDomain());
        SeleniumHeadless.setDomain(Variables.getDomain());

        if (screenshotJob == null){
            System.out.println("Error! invalid Job ID or Job name");
            System.exit(1);
        }

        // create worker threads that generate the pdf results
        screenshotJob.createResult();

        // get threads
        final List<Thread> screenshotThreads = screenshotJob.getScreenshotThreads();
        final List<Thread> pdfThreads = screenshotJob.getPdfThreads();

        // concurrent run, run all threads by appending pdf threads to screenshot threads
        screenshotThreads.addAll(pdfThreads);
        for (Thread thread : screenshotThreads)
            thread.start();
        // wait for pdfs to be completed
        for (Thread thread : pdfThreads)
            thread.join();


        System.out.println("Connecting to S3...");
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(Variables.getAwsAccessKey(), Variables.getAwsSecretKey())))
                .withRegion(Variables.getRegion() == null ? Regions.US_EAST_1.getName() : Variables.getRegion())
                .build();

        // send pdf/zip
        screenshotJob.sendResult(s3);
    }
}