package com.gene.screenshots.base;

import com.gene.screenshots.Variables;
import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.SeleniumHeadless;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

// creates 2 thread lists for ScreenshotsAutomation
// 1 is for screenshots and the second is for creating pdfs
// Each Job is required to use SeleniumHeadless classes as the methods use SeleninumHeadless

public abstract class ScreenshotThreads {

    protected static String savePath;

    public static void savePath(String savePath){
        ScreenshotThreads.savePath = savePath;
    }

    public static void setSemaphore(Semaphore limit){
        threadLock = limit;
    }
    private static Semaphore threadLock;


    public List<Thread> getScreenshotThreads() {
        return screenshotThreads;
    }
    public List<Thread> getPdfThreads() {
        return pdfThreads;
    }

    private List<Thread> screenshotThreads = new LinkedList<>();
    private  List<Thread> pdfThreads = new LinkedList<>();


    // mobile, desktop, and pdf threads created
    public void createThreads(SeleniumHeadless test) {

        //TODO if 2 pdfs are needed for mobile/desktop change to add another log
        //Log pdfLog = new Log();
        //test.setLog(pdfLog);
        String testName = test.getClass().getSimpleName();
        Thread[] deskMobThreads = new Thread[]{
                new Thread(() -> {
                    try {
                        threadLock.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(testName + " mobile screenshot automation started!");
                    test.mobileAutomationTest(savePath + "/mobile/" + testName);
                    threadLock.release();
                }),
                new Thread(() -> {
                    try {
                        threadLock.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(testName + " desktop screenshot automation started!");
                    test.desktopAutomationTest(savePath + "/desktop/" + testName);
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
                //threadLock.acquire();
                createPDF(test, testName);
                //threadLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pdfThread.setDaemon(true);
        pdfThreads.add(pdfThread);
    }

    private static void createPDF(SeleniumHeadless test, String pdfName){

        if (savePath == null)
            throw new NullPointerException("Error! null pdf output path!");

        PDFMaker newPdf = new PDFMaker();

        // append mobile screenshots to desktop screenshots for 1 pdf
        LinkedList<String> imageNames = test.getDesktopScreenshots();
        imageNames.addAll(test.getMobileScreenshots());

        try {
            for (String imagePath : imageNames) {
                newPdf.addImg(imagePath);
            }
            newPdf.savePDF(savePath + "/pdfs/" + pdfName + ".pdf");
            newPdf.close();
            System.out.println(pdfName + ".pdf created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
