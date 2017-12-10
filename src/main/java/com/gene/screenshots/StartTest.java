package com.gene.screenshots;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.SeleniumTest;
import com.gene.screenshots.selenium.accesssolutions.en.*;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;
import com.gene.screenshots.utils.Log;

import java.io.*;
import java.util.*;

/**
 *  Starts the screenshot process from a jenkins job.
 *  All selenium code is expected to support a headless browser
 */

public class StartTest {

    private static List<Thread> screenshotThreads = new LinkedList<>();
    private static List<Thread> pdfThreads = new LinkedList<>();
    private static AmazonS3 s3 = null;

    public static void main(String [] args) throws IOException, InterruptedException {

        System.out.println("Starting Jenkins Job!");

        // pass in jenkins parameters, most important being savePath and chromedriverPath
        Variables.main(args);

        final int threadCount = Variables.getThreadCount();
        String chromedriverPath = Variables.getChromedriverPath();
        String savePath = Variables.getSavePath();
        String pdfOutputPath = Variables.getPdfOutputPath();

        System.out.println("Save path is: " + savePath);

        if (chromedriverPath == null) {
            String OS = System.getProperty("os.name").toLowerCase();
            if(OS.contains("win"))
                chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";
            else
                chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver.exe";
        }
        System.out.println("Chromedrive path is: " + chromedriverPath);
        SeleniumTest.setChomeSystemProperty(chromedriverPath);


        KadcylaPatient patientTest = new KadcylaPatient();
        KadcylaHCP hcpTest = new KadcylaHCP();
        List<SeleniumTest> accessSolutionsTest = createAccessSolutionsTestList();

        if (Variables.isAccessSolutions())
            for(SeleniumTest accessTest : accessSolutionsTest)
                createDesktopMobileThreads(accessTest);

        if (Variables.isKadyclaHCP())
            createDesktopMobileThreads(hcpTest);

        if (Variables.isKadcylaPatient())
            createDesktopMobileThreads(patientTest);


        // if sending pdf to s3
        if(Variables.isS3()) {
            System.out.println("Connecting to S3...");
            s3 = AmazonS3ClientBuilder.standard()
                    .withCredentials(Variables.isS3Local() ? new ProfileCredentialsProvider() : new AWSStaticCredentialsProvider(new BasicAWSCredentials(Variables.getAwsAccessKey(), Variables.getAwsSecretKey())))
                    .withRegion(Variables.getRegion() == null ? Regions.US_EAST_1.getName() : Variables.getRegion())
                    .build();
        }

        // start automation job(s)
        //TODO limit number of threads
        if(Variables.isUseTheads()) {
            // concurrent run
            screenshotThreads.addAll(pdfThreads);
            for (Thread thread : screenshotThreads)
                thread.start();
            for (Thread thread : pdfThreads)
                thread.join();
        } else {
            // sequential run
            for(Thread thread : screenshotThreads){
                thread.start();
                thread.join();
            }
            for(Thread thread : pdfThreads){
                thread.start();
                thread.join();
            }
        }
    }

    // english access solutions
    private static List<SeleniumTest> createAccessSolutionsTestList(){
        List<SeleniumTest> result = new LinkedList<>();
        result.add(new Actemra());
        result.add(new Alecensa());
        result.add(new Avastin());
        result.add(new Cotellic());
        result.add(new Erivedge());
        result.add(new Esbriet());
        result.add(new Gazyva());
        result.add(new Hemlibra());
        result.add(new Herceptin());
        result.add(new Kadcyla());
        result.add(new Lucentis());
        result.add(new Ocrevus());
        result.add(new Patient());
        result.add(new Pegasys());
        result.add(new Perjeta());
        result.add(new Pulmozyme());
        result.add(new RituxanGPAMPA());
        result.add(new RituxanNHLCLL());
        result.add(new RituxanRA());
        result.add(new RituxanHycela());
        result.add(new Tarceva());
        result.add(new Tecentriq());
        result.add(new Venclexta());
        result.add(new Xolair());
        result.add(new Zelboraf());
        return result;
    }

    // mobile and desktop threads have to complete before the pdf thread starts
    private static void createDesktopMobileThreads(SeleniumTest test) {

        // if 2 pdfs are needed for mobile/desktop change to add/set 2 logs
        Log pdfLog = new Log();
        test.setLog(pdfLog);
        String testName = test.getClass().getSimpleName();
        Thread[] deskMobThreads = new Thread[]{
                new Thread(() -> {
                    System.out.println(testName + " mobile screenshot automation started!");
                    test.mobileAutomationTest(Variables.getSavePath() + "/mobile/" + testName);
                }),
                new Thread(() -> {
                    System.out.println(testName + " desktop screenshot automation started!");
                    test.desktopAutomationTest(Variables.getSavePath() + "/desktop/" + testName);
                })
        };
        screenshotThreads.add(deskMobThreads[0]);
        screenshotThreads.add(deskMobThreads[1]);
        pdfThreads.add(new Thread(() -> {
            try {
                deskMobThreads[0].join();
                deskMobThreads[1].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            createPDFandSendThread(test, testName, null);
        }));
    }

    private static void createPDFandSendThread(SeleniumTest test, String pdfName, String pdfOutputPath) {

        String savePath = Variables.getSavePath();
        String testName = test.getClass().getSimpleName();
        String logPath = savePath + "/logs/" + testName + ".txt";

        // saveLog merges desktop/mobile into 1 log file
        test.setLogName(testName);
        test.saveLog(savePath + "/logs");

        PDFMaker newPdf = new PDFMaker();
        LinkedList<String> imageNames = new LinkedList<>();
        try {
            File logFile = new File(logPath);
            FileReader reader = new FileReader(logFile);
            BufferedReader buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null)
                imageNames.add(line);
        } catch (IOException e) {
            if (e instanceof FileNotFoundException)
                System.out.println("No log file found at path!");
            else
                System.out.println("Error reading in log file!");
            System.exit(1);
        }

        if(pdfOutputPath == null)
            pdfOutputPath = savePath;
        try {
            for (String imagePath : imageNames) {
                newPdf.addImg(imagePath);
            }
            newPdf.savePDF(pdfOutputPath + "/" + pdfName + ".pdf");
            newPdf.close();
            System.out.println(pdfName + ".pdf created!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if sending pdf to s3
        if (s3 == null)
            return;

        System.out.println("Sending " + pdfName + ".pdf...");
        try {
            s3.putObject(Variables.getBucketName(),
                    Variables.getPdfKey(),
                    new File((pdfOutputPath == null ? "." : pdfOutputPath) + "/" + (pdfName == null ? testName : pdfName) + ".pdf"));
            System.out.println("pdf sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
