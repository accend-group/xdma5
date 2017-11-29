package com.gene.screenshots;

import com.amazonaws.regions.Regions;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.gene.screenshots.selenium.Selenium;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Selenium script
 *
 */
public class SeleniumScript
{
    // used to set the scroll imsafety link to the bottom
    private static String REMOVE_IMSAFETY_SCRIPT;
    static{
        try {
            REMOVE_IMSAFETY_SCRIPT = new Scanner(new File("src/main/java/com/gene/screenshots/javascript/remove_imsafety.js")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void sleep(long mil){
        try{
            Thread.sleep(mil);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {

        // some place postrun can access

        String savePath = "/Users/anthony/Desktop/SeleniumScriptLog/";
        if(args.length > 0)
            savePath = args[0];

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().setSize(new Dimension(1600,1200));

        // save image names
        LinkedList<String> imagesNames = new LinkedList<>();


        // get visible and full page screenshots of google's homepage
        chromeDriver.get("http://www.google.com");
        sleep(500);

        String imageName = "google_homepage_vis";
        TakesScreenshot ts = (TakesScreenshot) chromeDriver;
        File imageFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imageFile, new File((savePath + "/" + imageName + ".png")));
            imagesNames.add(imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageName = "google_homepage_full";
        Shutterbug.shootPage(chromeDriver, ScrollStrategy.BOTH_DIRECTIONS, 350, true).withName(imageName).save(savePath);
        imagesNames.add(imageName);

        // get visible and full page screenshots of perjeta's homepage
        chromeDriver.get("http://www.perjeta.com");
        sleep(500);

        imageName = "perjeta_homepage_vis";
        ts = (TakesScreenshot) chromeDriver;
        imageFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imageFile, new File((savePath + "/" + imageName + ".png")));
            imagesNames.add(imageName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        imageName = "perjeta_homepage_full";
        Shutterbug.shootPage(chromeDriver, ScrollStrategy.BOTH_DIRECTIONS, 350, true).withName(imageName).save(savePath);
        imagesNames.add(imageName);


        // store image names in log file
        try {
            Path file = Paths.get(savePath + "/log.txt");
            Files.write(file, imagesNames, Charset.forName("UTF-8"));
        }catch(IOException e){
            e.printStackTrace();
        }
        chromeDriver.close();
        chromeDriver.quit();
    }

    private static void takeImages(Selenium testBrowser, String imgName){
        testBrowser.saveVisibleScreenshot(imgName);
        testBrowser.runJS(REMOVE_IMSAFETY_SCRIPT);
        testBrowser.saveFullPageScreenshot(imgName);
    }
}
