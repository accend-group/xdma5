package com.gene.screenshots.utils;


import com.assertthat.selenium_shutterbug.utils.file.FileUtil;
import com.assertthat.selenium_shutterbug.utils.web.UnableTakeSnapshotException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import static com.gene.screenshots.Constants.*;
import static java.lang.Math.toIntExact;

// used Shutterbug as starting basis but now instead of scroll and stitch to get a fullscreenshot the main browser window is resized to match the
// entire site body height for fullscreen pages.
public class Screenshots {

    private Log log;
    private LinkedList<String> desktopScreenshots = new LinkedList<>();
    private LinkedList<String> mobileScreenshots = new LinkedList<>();


    public void setLog(Log log){
        this.log = log;
    }

    public void setLogName(String logName){
        log.setLogName(logName);
    }

    // append mobile screenshots to desktopscreenshots for output log
    public void saveLog(String savePath){
        desktopScreenshots.addAll(mobileScreenshots);
        log.setList(desktopScreenshots);
        log.save(savePath);
    }

    public void full(WebDriver driver, boolean ifDesktop, String path, String screenshotName) throws InterruptedException{
        fullScreenshot(driver, ifDesktop, path, screenshotName);
        File outputImg = new File(path + "/" + screenshotName + ".png");
        if(ifDesktop)
            desktopScreenshots.add(outputImg.getAbsolutePath());
        else
            mobileScreenshots.add(outputImg.getAbsolutePath());
    }

    public void visible(WebDriver driver, boolean ifDesktop, String path, String screenshotName) {
        try {
            TakesScreenshot ts =(TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File outputImg = new File( path + "/" + screenshotName+".png");
            FileUtils.copyFile(source, outputImg);
            if(ifDesktop)
                desktopScreenshots.add(outputImg.getAbsolutePath());
            else
                mobileScreenshots.add(outputImg.getAbsolutePath());
        }
        catch (Exception e) {
            System.out.println("Exception while taking visible part screenshot" + e.getMessage());
        }
    }

    protected int getDocWidth(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.max(document.body.scrollWidth, document.body.offsetWidth, document.documentElement.clientWidth, document.documentElement.scrollWidth, document.documentElement.offsetWidth);");
        return toIntExact(result);
    }

    protected int getDocHeight(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.max(document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);");
        return toIntExact(result);
    }

    protected int getCurrentScrollX(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.round(Math.max(document.documentElement.scrollLeft, document.body.scrollLeft));");
        return toIntExact(result);
    }

    protected int getCurrentScrollY(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result =  (Long) jse.executeScript("return Math.round(Math.max(document.documentElement.scrollTop, document.body.scrollTop));");
        return toIntExact(result);
    }

    protected void scrollTo(WebDriver driver, int x, int y){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }


    // full site body screenshot
    // need to store current scroll position
    protected void fullScreenshot(WebDriver driver, boolean ifDesktop, String location, String fileName){

        int xPos = getCurrentScrollX(driver);
        int yPos = getCurrentScrollY(driver);

        File screenshotFile = new File(location);
        if(!screenshotFile.exists()) {
            screenshotFile.mkdirs();
        }
        File outputImg = new File( location + "/" + fileName + ".png");

        if(ifDesktop) {
            FileUtil.writeImage(takeScreenshotEntirePage(driver,DESKTOP_WIDTH), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        }
        else {
            FileUtil.writeImage(takeScreenshotEntirePage(driver,MOBILE_WIDTH), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, MOBILE_HEIGHT));
        }

        // scroll to the previous position before resize
        scrollTo(driver, xPos, yPos);

    }

    // viewport screenshot
    //  ===================== SHUTTERBUG code modified =====================================
    private BufferedImage takeScreenshot(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            return ImageIO.read(srcFile);
        } catch (IOException e) {
            throw new UnableTakeSnapshotException(e);
        } finally {
            // add this to clean up leaving this file in the temporary directory forever...
            if (srcFile.exists()) {
                srcFile.delete();
            }
        }
    }

    // resize entire window to fit entire body of webpage
    //  ===================== SHUTTERBUG code modified =====================================
    private BufferedImage takeScreenshotEntirePage(WebDriver driver, int width) {

        int _docWidth = width;//getDocWidth(driver);
        int _docHeight = getDocHeight(driver);

        //System.out.println("WIDTH: " + _docWidth + " SYS WIDTH: " + driver.manage().window().getSize().width);
        driver.manage().window().setSize(new Dimension(_docWidth, _docHeight));

        return takeScreenshot(driver);
    }
}
