package com.gene.screenshots;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.en.*;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;
import com.gene.screenshots.utils.Log;

import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;

import static com.gene.screenshots.utils.Type.PROD;

/**
 * Starts the screenshot process from a jenkins job.
 * All selenium code is expected to support a headless browser
 */

public class StartTest {

    private static List<Thread> screenshotThreads = new LinkedList<>();
    private static List<Thread> pdfThreads = new LinkedList<>();
    private static AmazonS3 s3 = null;

    private static Semaphore threadLock;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Reading Jenkins parameters!");

        // pass in jenkins parameters
        Variables.main(args);

        System.out.println("Thread count: " + Variables.getThreadCount());

        threadLock = new Semaphore(Variables.getThreadCount(), true);

        String chromedriverPath = Variables.getChromedriverPath();
        String savePath = Variables.getSavePath();

        System.out.println("Save path is: " + savePath);

        if (chromedriverPath == null) {
            String OS = System.getProperty("os.name").toLowerCase();
            if (OS.contains("win"))
                chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver.exe";
            else
                chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";
        }
        System.out.println("Chromedrive path is: " + chromedriverPath);
        System.out.println("Testing at: " + Variables.getDomain());

        // setting the testing domain (prod, stage, dev, local)
        SeleniumHeadless.setDomain(Variables.getDomain());

        SeleniumHeadless.setChromeSystemProperty(chromedriverPath);


        KadcylaPatient patientTest = new KadcylaPatient();
        KadcylaHCP hcpTest = new KadcylaHCP();
        List<SeleniumHeadless> accessSolutionsTest = createAccessSolutionsTestList();

        if (Variables.isAccessSolutions())
            for (SeleniumHeadless accessTest : accessSolutionsTest)
                createThreads(accessTest);

        if (Variables.isKadyclaHCP())
            createThreads(hcpTest);

        if (Variables.isKadcylaPatient())
            createThreads(patientTest);

        // if sending pdf to s3
        if (Variables.isS3()) {
            System.out.println("Connecting to S3...");
            s3 = AmazonS3ClientBuilder.standard()
                    .withCredentials(Variables.isS3Local() ? new ProfileCredentialsProvider() : new AWSStaticCredentialsProvider(new BasicAWSCredentials(Variables.getAwsAccessKey(), Variables.getAwsSecretKey())))
                    .withRegion(Variables.getRegion() == null ? Regions.US_EAST_1.getName() : Variables.getRegion())
                    .build();
        }

        // start automation job(s)
        if (Variables.isUseThreads()) {
            // concurrent run
            screenshotThreads.addAll(pdfThreads);
            for (Thread thread : screenshotThreads)
                thread.start();
            for (Thread thread : pdfThreads)
                thread.join();
        } else {
            // sequential run
            for (Thread thread : screenshotThreads) {
                thread.start();
                thread.join();
            }
            for (Thread thread : pdfThreads) {
                thread.start();
                thread.join();
            }
        }
    }

    // english access solutions
    private static List<SeleniumHeadless> createAccessSolutionsTestList() {
        List<SeleniumHeadless> result = new LinkedList<>();
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
        if(Variables.getDomain().getType() != PROD)
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

    // mobile, desktop, and pdf threads created
    private static void createThreads(SeleniumHeadless test) {

        //TODO if 2 pdfs are needed for mobile/desktop change to add another log
        Log pdfLog = new Log();
        test.setLog(pdfLog);
        String testName = test.getClass().getSimpleName();
        Thread[] deskMobThreads = new Thread[]{
                new Thread(() -> {
                    if (Variables.isUseThreads()) {
                        try {
                            threadLock.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(testName + " mobile screenshot automation started!");
                    test.mobileAutomationTest(Variables.getSavePath() + "/mobile/" + testName);
                    threadLock.release();
                }),
                new Thread(() -> {
                    if (Variables.isUseThreads()) {
                        try {
                            threadLock.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(testName + " desktop screenshot automation started!");
                    test.desktopAutomationTest(Variables.getSavePath() + "/desktop/" + testName);
                    threadLock.release();
                })
        };
        deskMobThreads[0].setDaemon(true);
        deskMobThreads[1].setDaemon(true);
        screenshotThreads.add(deskMobThreads[0]);
        screenshotThreads.add(deskMobThreads[1]);

        Thread pdfThread = new Thread(() -> {
            try {
                // wait for the threads to finish to read in the log file
                deskMobThreads[0].join();
                deskMobThreads[1].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            createPDFandSendThread(test, testName, Variables.getPdfOutputPath());
        });
        pdfThread.setDaemon(true);
        pdfThreads.add(pdfThread);
    }

    private static void createPDFandSendThread(SeleniumHeadless test, String pdfName, String pdfOutputPath) {

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

        if (pdfOutputPath == null)
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
