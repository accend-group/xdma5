package com.gene.screenshots;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.accesssolutions.Accesssolution;
import com.gene.screenshots.selenium.accesssolutions.desktop_en;
import com.gene.screenshots.selenium.accesssolutions.desktop_es;
import com.gene.screenshots.selenium.accesssolutions.en.*;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;
import com.gene.screenshots.selenium.kadcyla.patient.desktop;
import com.gene.screenshots.selenium.kadcyla.patient.mobile;
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

    private static WebDriver createMobileDriver() {
        Map<String, Object> mobile = new HashMap<>();
        mobile.put("width", 320);
        mobile.put("height", 720);
        mobile.put("pixelRatio", 1.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", mobile);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        return new ChromeDriver(chromeOptions);
    }

    private static WebDriver createDesktopDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //chromeOptions.addArguments("--disable-gpu");
        options.addArguments("--disable-gpu-watchdog");
        //options.addArguments("--window-size=1200,1200");
        WebDriver desktopDriver = new ChromeDriver(options);
        desktopDriver.manage().window().setSize(new Dimension(1200, 1200));
        return desktopDriver;
    }

    public static void main(String [] args) throws IOException, InterruptedException {

        // pass in jenkins parameters
        Variables.main(args);

        System.out.println("Starting test!");

        String chromedriverPath = Variables.getChromedriverPath();
        String savePath = Variables.getSavePath();

        System.out.println("Save path is: " + savePath);

        if (chromedriverPath == null)
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromedriverPath);


        // TODO make kadcyla jobs as threads, linkedlist of threads
        //Thread [] threads = new Thread[25];
        LinkedList<Thread> threads = new LinkedList<>();

        if (Variables.isAccessSolutions()) {

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();

                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        patient.setScreenshots(screenshots);
                        patient.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();


                        WebDriver mobileDriver = createMobileDriver();
                        patient.patient_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_patient");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_patient.txt", "access_solutions_patient", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        actemra.setScreenshots(screenshots);
                        actemra.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();


                        WebDriver mobileDriver = createMobileDriver();
                        actemra.actemra_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_actemra");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_actemra.txt", "access_solutions_actemra", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        alecensa.setScreenshots(screenshots);
                        alecensa.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        alecensa.alecensa_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_alecensa");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_alecensa.txt", "access_solutions_alecensa", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        avastin.setScreenshots(screenshots);
                        avastin.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        avastin.avastin_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_avastin");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_avastin.txt", "access_solutions_avastin", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        cotellic.setScreenshots(screenshots);
                        cotellic.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        cotellic.cotellic_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_cotellic");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_cotellic.txt", "access_solutions_cotellic", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        WebDriver mobileDriver = createMobileDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        erivedge.setScreenshots(screenshots);
                        erivedge.main(null, desktopDriver);            // |	12 	 |	 13   |
                        erivedge.erivedge_mobile(mobileDriver);

                        desktopDriver.quit();
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_erivedge");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_erivedge.txt", "access_solutions_erivedge", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        esbriet.setScreenshots(screenshots);
                        esbriet.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        esbriet.esbriet_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_esbriet");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_esbriet.txt", "access_solutions_esbriet", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        gazyva.setScreenshots(screenshots);
                        gazyva.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        gazyva.gazyva_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_gazyva");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_gazyva.txt", "access_solutions_gazyva", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        hemlibra.setScreenshots(screenshots);
                        hemlibra.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        hemlibra.helimbra_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_hemlibra");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_hemlibra.txt", "access_solutions_hemlibra", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        herceptin.setScreenshots(screenshots);
                        herceptin.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        herceptin.herceptin_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_herceptin");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_herceptin.txt", "access_solutions_herceptin", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        kadcyla.setScreenshots(screenshots);
                        kadcyla.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        kadcyla.kadcyla_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_kadcyla");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_kadcyla.txt", "access_solutions_kadcyla", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        lucentis.setScreenshots(screenshots);
                        lucentis.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        lucentis.lucentis_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_lucentis");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_lucentis.txt", "access_solutions_lucentis", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        ocrevus.setScreenshots(screenshots);
                        ocrevus.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        ocrevus.ocrevus_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_ocrevus");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_ocrevus.txt", "access_solutions_ocrevus", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        pegasys.setScreenshots(screenshots);
                        pegasys.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        pegasys.pegasys_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_pegasys");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_pegasys.txt", "access_solutions_pegasys", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        perjeta.setScreenshots(screenshots);
                        perjeta.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        perjeta.perjeta_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_perjeta");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_perjeta.txt", "access_solutions_perjeta", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        pulmozyme.setScreenshots(screenshots);
                        pulmozyme.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        pulmozyme.pulmozyme_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_pulmozyme");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_pulmozyme.txt", "access_solutions_pulmozyme", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        rituxan_ra.setScreenshots(screenshots);
                        rituxan_ra.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        rituxan_ra.rituxan_ra_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_rituxan_ra");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_rituxan_ra.txt", "access_solutions_rituxan_ra", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        rituxan_gpampa.setScreenshots(screenshots);
                        rituxan_gpampa.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        rituxan_gpampa.rituxan_gpampa_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_rituxan_gpampa");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_rituxan_gpampa.txt", "access_solutions_rituxan_gpampa", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        rituxan_nhl_cll.setScreenshots(screenshots);
                        rituxan_nhl_cll.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        rituxan_nhl_cll.rituxan_nhl_cll_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_rituxan_nhl_cll");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_rituxan_nhl_cll.txt", "access_solutions_rituxan_nhl_cll", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        rituxanhycela.setScreenshots(screenshots);
                        rituxanhycela.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();


                        WebDriver mobileDriver = createMobileDriver();
                        rituxanhycela.rituxanhycela_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_rituxanhycela");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_rituxanhycela.txt", "access_solutions_rituxanhycela", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        tarceva.setScreenshots(screenshots);
                        tarceva.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        tarceva.tarceva_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_tarceva");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_tarceva.txt", "access_solutions_tarceva", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        tecentriq.setScreenshots(screenshots);
                        tecentriq.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        tecentriq.tecentriq_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_tecentriq");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_tecentriq.txt", "access_solutions_tecentriq", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        venclexta.setScreenshots(screenshots);
                        venclexta.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        venclexta.venclexta_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_venclexta");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_venclexta.txt", "access_solutions_venclexta", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        xolair.setScreenshots(screenshots);
                        xolair.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        xolair.xolair_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_xolair");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_xolair.txt", "access_solutions_xolair", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Log patientLog = new Log();
                        WebDriver desktopDriver = createDesktopDriver();
                        Screenshots screenshots = new Screenshots();
                        screenshots.setLog(patientLog);

                        // both desktop and mobile set to take screenshots
                        zelboraf.setScreenshots(screenshots);
                        zelboraf.main(null, desktopDriver);            // |	12 	 |	 13   |
                        desktopDriver.quit();

                        WebDriver mobileDriver = createMobileDriver();
                        zelboraf.zelboraf_mobile(mobileDriver);
                        mobileDriver.quit();

                        patientLog.setLogName("access_solutions_zelboraf");
                        patientLog.save(savePath);
                        createPDFandSend(savePath + "/access_solutions_zelboraf.txt", "access_solutions_zelboraf", null);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));


        }
        if (Variables.isKadyclaHCP()) {

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Kadcyla HCP screenshot automation started!");

                    // the log is the list of images a pdf will contain.
                    Log pdfLog = new Log();

                    // setting the screenshots with a log makes sure every screenshot function call adds an image path to the log.
                    Screenshots screenshots = new Screenshots();
                    screenshots.setLog(pdfLog);

                    KadcylaHCP.setScreenshots(screenshots);
                    try {
                        KadcylaHCP.main(null);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    pdfLog.setLogName("kadcyla_hcp");
                    pdfLog.save(savePath);

                    // creates pdf and sends the pdf to a s3 service
                    createPDFandSend(savePath + "/kadcyla_hcp.txt", "kadcyla_hcp", null);
                }
            }));
        }
        if (Variables.isKadcylaPatient()) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Kadcyla Patient screenshot automation started!");

                    Log pdfLog = new Log();
                    Screenshots screenshots = new Screenshots();
                    screenshots.setLog(pdfLog);

                    KadcylaPatient.setScreenshots(screenshots);
                    try {
                        KadcylaPatient.main(null);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    pdfLog.setLogName("kadcyla_patient");
                    pdfLog.save(savePath);

                    createPDFandSend(savePath + "/kadcyla_patient.txt", "kadcyla_patient", null);
                }
            }));
        }

        if (Variables.isUseTheads()) {
            for (Thread thread : threads)
                thread.start();
            for (Thread thread : threads)
                thread.join();
        } else {
            for (Thread thread : threads) {
                thread.start();
                thread.join();
            }
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
