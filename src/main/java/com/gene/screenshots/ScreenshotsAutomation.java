package com.gene.screenshots;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.base.ScreenshotThreads;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.google.errorprone.annotations.Var;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;


import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.Semaphore;

import static com.gene.screenshots.EnvironmentType.*;

/**
 * Starts the screenshot process from a jenkins job.
 * All selenium code is expected to support a headless browser
 */

public class ScreenshotsAutomation {

    private static final int THREAD_LIMIT = Variables.getThreadLimit();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Reading Jenkins parameters!");
        Variables.main(args);


        String savePath = Variables.getSavePath();
        String pdfSavePath = Variables.getPdfOutputPath();
        System.out.printf("Screenshot path: %s\nPDF path: %s\n", savePath, pdfSavePath);
        ScreenshotThreads.setSavePath(savePath);
        ScreenshotThreads.setPdfSavePath(pdfSavePath);

        SeleniumHeadless.setChromeSystemProperty(Variables.getChromedriverPath());

        // if merging pdfs or creating desktop/mobile pdfs
        SeleniumHeadless.setIfSinglePDF(Variables.isIfMergePDF());

        // if author are credentials needed
        SeleniumHeadless.isCredentialsRequired(Variables.isCredentialsRequired());

        ScreenshotThreads.setSemaphore(new Semaphore(THREAD_LIMIT, true));

        // search project path for classes with @Job
        Reflections reflections = Reflections.collect();
        Set < Class < ?>> annotated = reflections.getTypesAnnotatedWith(Job.class);
        HashMap<Object, Class<?>> annotationsMap = new HashMap<>();
        for (Class<?> class_ : annotated) {
            Annotation info = class_.getDeclaredAnnotation(Job.class);
            annotationsMap.put(((Job) info).ID(), class_);
            annotationsMap.put(((Job) info).name(), class_);
        }

        // get specified job
        ScreenshotJob screenshotJob = null;
        BrandUrl domain = null;
        try {
            Job job = annotationsMap.get(Variables.getJob()).getDeclaredAnnotation(Job.class);
            Environment environment = annotationsMap.get(Variables.getJob()).getAnnotation(Environment.class);
            if(job != null)
                System.out.println(String.format("Running %s, ID: %d, Info: %s", job.name(), job.ID(), job.info()));
            if(environment != null)
                domain = new BrandUrl(environment, Variables.getEnvironmentType());
            screenshotJob = (ScreenshotJob) annotationsMap.get(Variables.getJob()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        if(domain == null){
            System.out.println("Error: missing Environment annotation!");
            System.exit(1);
        }

        // setting the testing domain (prod, stage, dev, local)
        System.out.println("Running automation at: " + domain);
        SeleniumHeadless.setDomain(domain);

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

        if(Variables.getBucketName() != null && Variables.getAwsSecretKey() != null && Variables.getAwsAccessKey() != null){

            System.out.println("Connecting to S3...");
            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(Variables.getAwsAccessKey(), Variables.getAwsSecretKey())))
                    .withRegion(Variables.getRegion() == null ? Regions.US_EAST_1.getName() : Variables.getRegion())
                    .build();

            // send pdf/zip
            screenshotJob.sendResult(s3);
        }
    }
}
