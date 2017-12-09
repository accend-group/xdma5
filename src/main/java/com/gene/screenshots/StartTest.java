package com.gene.screenshots;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.accesssolutions.en.*;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;
import com.gene.screenshots.utils.Log;
import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 *  Starts the screenshot process from a jenkins job.
 */

public class StartTest {

    public static void main(String [] args) throws IOException, InterruptedException {

        System.out.println("Starting Jenkins Job!");

        // pass in jenkins parameters, most important being savePath and chromedriverPath
        Variables.main(args);


        final int threadCount = Variables.getThreadCount();
        String chromedriverPath = Variables.getChromedriverPath();
        String savePath = Variables.getSavePath();
        String pdfOutputPath = Variables.getPdfOutputPath();

        System.out.println("Save path is: " + savePath);

        if (chromedriverPath == null)
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        LinkedList<Thread> threads = new LinkedList<>();

        KadcylaPatient patientTest = new KadcylaPatient();
        KadcylaHCP hcpTest = new KadcylaHCP();

        if (Variables.isAccessSolutions()) {

        }

        if (Variables.isKadyclaHCP()) {
            // if 2 pdfs are needed for mobile/desktop change to add/set 2 logs
            Log pdfLog = new Log();
            hcpTest.setLog(pdfLog);

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Kadcyla HCP desktop screenshot automation started!");
                    hcpTest.desktopAutomationTest(Variables.getSavePath() + "/desktop/kadcylaHCP");
                }
            }));
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Kadcyla HCP mobile screenshot automation started!");
                    hcpTest.mobileAutomationTest(Variables.getSavePath() + "/mobile/kadcylaHCP");
                }
            }));
        }

        if (Variables.isKadcylaPatient()) {
            Log pdfLog = new Log();
            patientTest.setLog(pdfLog);
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Kadcyla Patient desktop screenshot automation started!");
                    patientTest.desktopAutomationTest(Variables.getSavePath() + "/desktop/kadcylaPatient");
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Kadcyla Patient mobile screenshot automation started!");
                    patientTest.mobileAutomationTest(Variables.getSavePath() + "/mobile/kadcylaPatient");
                }
            }));
        }

        // start automation job(s)
        //TODO limit number of threads
        if(Variables.isUseTheads()) {
            // concurrent run
            int startedThreads = 0;
            for (Thread thread : threads)
                thread.start();
            for (Thread thread : threads)
                thread.join();

        } else {
            // sequential run
            for(Thread thread : threads){
                thread.start();
                thread.join();
            }
        }

        // read logs and create pdfs
        if(Variables.isKadcylaPatient()) {
            patientTest.setLogName("kadcyla_patient");
            patientTest.saveLog(savePath);
            createPDFandSend(savePath + "/kadcyla_patient.txt", "kadcyla_patient", null);
        }

        if(Variables.isKadyclaHCP()) {
            hcpTest.setLogName("kadcyla_hcp");
            hcpTest.saveLog(savePath);
            createPDFandSend(savePath + "/kadcyla_hcp.txt", "kadcyla_hcp", null);
        }
    }

    private static void createPDFandSend(String logPath, String pdfName, String pdfOutputPath){

        PDFMaker newPdf = new PDFMaker();
        LinkedList<String> imageNames = new LinkedList<>();

        // read in images from log
        if(logPath == null) {
            System.out.println("No log path set!");
            System.exit(1);
        }
        System.out.println(logPath);
        try {
            File logFile = new File(logPath);
            FileReader reader = new FileReader(logFile);
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
            pdfOutputPath = ".";
        try {
            for(String imagePath : imageNames){
                newPdf.addImg(imagePath);
            }
            newPdf.savePDF(pdfOutputPath + "/" + pdfName + ".pdf");
            newPdf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if sending pdf to s3
        if(!Variables.isS3())
            return;

        System.out.println("Connecting to S3...");
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(Variables.isS3Local() ? new ProfileCredentialsProvider() : new AWSStaticCredentialsProvider(new BasicAWSCredentials(Variables.getAwsAccessKey(), Variables.getAwsSecretKey())))
                .withRegion(Variables.getRegion() == null ? Regions.US_EAST_1.getName() : Variables.getRegion())
                .build();

        System.out.println("Sending pdf...");
        try {
            s3.putObject(Variables.getBucketName(), Variables.getPdfKey(), new File(pdfOutputPath + "/" + pdfName + ".pdf"));
            System.out.println("pdf sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
