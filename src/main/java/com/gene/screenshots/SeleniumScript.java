package com.gene.screenshots;

import com.amazonaws.regions.Regions;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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



        String chromeDriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";
        if(args.length > 1)
            chromeDriverPath = args[1];

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);


        // setup mobile chrome driver
        /*Map<String, Object> mobileMetrics = new HashMap<>();
        mobileMetrics.put("width", 320);
        mobileMetrics.put("height", 720);
        mobileMetrics.put("pixelRatio", 1.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", mobileMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        */
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //options.addArguments("--disable-gpu");
        options.addArguments("--disable-gpu-watchdog");
        //options.addArguments("--window-size=1200,1200");
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().window().setSize(new Dimension(1200, 1200));

        // desktop option
        //chromeDriver.manage().window().setSize(new Dimension(1600,1200));

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
}
