package com.gene.screenshots.base;

import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.SeleniumHeadless;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


// creates 2 thread lists for capturing screenshots and generate pdfs
public abstract class ScreenshotThreads {

    protected static String savePath = null;
    protected static String pdfSavePath = null;

    public static void setSavePath(String savePath){
        ScreenshotThreads.savePath = savePath;
    }
    public static void setPdfSavePath(String pdfPath){
        ScreenshotThreads.pdfSavePath = pdfPath;
    }


    public ConcurrentLinkedQueue<Thread> getScreenshotThreads() {
        return screenshotThreads;
    }
    public ConcurrentLinkedQueue<Thread> getPdfThreads() {
        return pdfThreads;
    }

    // multiple scripts may be adding their own threads
    private ConcurrentLinkedQueue<Thread> screenshotThreads = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<Thread> pdfThreads = new ConcurrentLinkedQueue<>();

    // mobile, desktop, and pdf threads created
    public void createThreads(SeleniumHeadless test) {

        String screenshotScriptName = test.getPdfName();
        List<Thread> currentThreadsFromTest = new LinkedList<Thread>();
        test.setDesktopSavePath(savePath + "/desktop/" + screenshotScriptName);
        test.setMobileSavePath(savePath + "/mobile/" + screenshotScriptName);
        List<Thread> desktopThreads = test.desktopAutomationTest();
        List<Thread> mobileThreads = test.mobileAutomationTest();
        if(desktopThreads != null)
            currentThreadsFromTest.addAll(desktopThreads);
        if(mobileThreads != null)
            currentThreadsFromTest.addAll(mobileThreads);

        currentThreadsFromTest.iterator().forEachRemaining(x -> { x.setDaemon(true); });

        screenshotThreads.addAll(currentThreadsFromTest);

        Thread pdfThread = new Thread(() -> {
            try {
                // wait for the test's threads to finish in order to read in the images
                currentThreadsFromTest.iterator().forEachRemaining(x -> {
                    try {
                        x.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                createPDFS(test, screenshotScriptName);
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
            List<String> imageNames = new ArrayList<>();
            if(test.getDesktopScreenshots() != null)
                imageNames.addAll(test.getDesktopScreenshots());
            if(test.getMobileScreenshots() != null)
                imageNames.addAll(test.getMobileScreenshots());
            Collections.sort(imageNames, new AlphanumComparator());
            makePDF(new PDFMaker(), imageNames, pdfName);
        } else {
            if(test.getDesktopScreenshots() != null) {
                List<String> desktopImages = new ArrayList<>();
                desktopImages.addAll(test.getDesktopScreenshots());
                Collections.sort(desktopImages, new AlphanumComparator());
                makePDF(new PDFMaker(), desktopImages, "desktop_" + pdfName);
            }
            if(test.getMobileScreenshots() != null) {
                List<String> mobileImages = new ArrayList<>();
                mobileImages.addAll(test.getMobileScreenshots());
                Collections.sort(mobileImages, new AlphanumComparator());
                makePDF(new PDFMaker(), mobileImages, "mobile_" + pdfName);
            }
        }
    }

    private static void makePDF(PDFMaker pdf, List<String> imagePaths, String pdfName){
        if(imagePaths.size() == 0)
            return;
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
