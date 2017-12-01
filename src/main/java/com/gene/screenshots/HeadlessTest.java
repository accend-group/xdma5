package com.gene.screenshots;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HeadlessTest {
    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        ChromeOptions options = new ChromeOptions();

        //options.setBinary("/Applications/Google Chrome/Contents/MacOS/Google Chrome");
        options.addArguments("--headless");


        Map<String, Object> mobileMetrics = new HashMap<>();
        mobileMetrics.put("width", 320);
        mobileMetrics.put("height", 720);
        mobileMetrics.put("pixelRatio", 1.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", mobileMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver chromeDriver = new ChromeDriver(options);
        //chromeDriver.manage().window().setSize(new Dimension(320,1200));
        chromeDriver.get("http://www.google.com");


        String imageName = "google_headless_vis";
        TakesScreenshot ts = (TakesScreenshot) chromeDriver;
        File imageFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imageFile, new File((imageName + ".png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        imageName = "google_headless_full";
        Shutterbug.shootPage(chromeDriver, ScrollStrategy.BOTH_DIRECTIONS, 350, true).withName(imageName).save(".");

        chromeDriver.quit();


        System.setProperty("webdriver.gecko.driver", "geckodriver");

        FirefoxBinary firefoxBinary = new FirefoxBinary(new File("~/home/anthony/firefox/firefox"));
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setHeadless(true);
        firefoxOptions.setBinary(firefoxBinary);

        //options.setBinary("/Applications/Google Chrome/Contents/MacOS/Google Chrome");


        WebDriver geckoDriver = new FirefoxDriver(firefoxOptions);
        //geckoDriver.manage().window().setSize(new Dimension(320,1200));
        geckoDriver.get("http://www.mozilla.org");


        imageName = "firefox_headless_vis";
        ts = (TakesScreenshot) geckoDriver;
        imageFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imageFile, new File((imageName + ".png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        imageName = "firefox_headless_full";
        Shutterbug.shootPage(geckoDriver, ScrollStrategy.BOTH_DIRECTIONS, 350, true).withName(imageName).save(".");

        geckoDriver.quit();
    }
}
