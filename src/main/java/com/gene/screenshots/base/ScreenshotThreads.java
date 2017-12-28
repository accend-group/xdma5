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

    protected static String savePath = null;
    protected static String pdfSavePath = null;

    public static void setSavePath(String savePath){
        ScreenshotThreads.savePath = savePath;
    }
    public static void setPdfSavePath(String pdfPath){
        ScreenshotThreads.pdfSavePath = pdfPath;
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

        String screenshotScriptName = test.getClass().getSimpleName();
        Thread[] deskMobThreads = new Thread[]{
                new Thread(() -> {
                    try {
                        threadLock.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(screenshotScriptName + " mobile screenshot automation started!");
                    test.mobileAutomationTest(savePath + "/mobile/" + screenshotScriptName);
                    threadLock.release();
                }),
                new Thread(() -> {
                    try {
                        threadLock.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(screenshotScriptName + " desktop screenshot automation started!");
                    test.desktopAutomationTest(savePath + "/desktop/" + screenshotScriptName);
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
                createPDFS(test, screenshotScriptName);
                //threadLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        pdfThread.setDaemon(true);
        pdfThreads.add(pdfThread);
    }

    private static void createPDFS(SeleniumHeadless test, String pdfName){

        if (savePath == null)
            throw new NullPointerException("Error! null pdf output path!");

        if(SeleniumHeadless.isIfSinglePDF()) {
            // append mobile screenshots to desktop screenshots for 1 pdf
            LinkedList<String> imageNames = test.getDesktopScreenshots();
            imageNames.addAll(test.getMobileScreenshots());

            makePDF(new PDFMaker(), imageNames, pdfName);
        } else {
            makePDF(new PDFMaker(), test.getDesktopScreenshots(), "desktop_" + pdfName);
            makePDF(new PDFMaker(), test.getMobileScreenshots(), "mobile_" + pdfName);
        }
    }

    private static void makePDF(PDFMaker pdf,List<String> imagePaths, String pdfName){
        try {
            for (String imagePath : imagePaths) {
                pdf.addImg(imagePath);
            }
            pdf.savePDF(pdfSavePath + "/" + pdfName + ".pdf");
            pdf.close();
            System.out.println(pdfName + ".pdf created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
