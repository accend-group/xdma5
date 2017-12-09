package com.gene.screenshots.selenium;

import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.gene.screenshots.Constants.*;

/** Abstract class for screenshot automation code
 *  Create another class that extends SeleniumTest
 *  each class represents a selenium test that produces screenshots.
 *  each screenshot is saved in a log file that is used to create a PDF.
 *  The mobile and desktop automated test functions must quit the driver at the end.
 */

public abstract class SeleniumTest extends Screenshots {


    public static WebDriver desktopDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //options.addArguments("window-size="+ DESKTOP_WIDTH + "," + DESKTOP_HEIGHT);

        //options.addArguments("--disable-gpu-watchdog");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--hide-scrollbars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));

        return driver;
    }

    public static WebDriver mobileDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size="+ MOBILE_WIDTH + "," + MOBILE_HEIGHT);
        options.addArguments("--use-mobile-user-agent=true");
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--hide-scrollbars");
        return new ChromeDriver(options);

        /*Map<String, Object> mobile = new HashMap<>();
        mobile.put("width", MOBILE_WIDTH);
        mobile.put("height", MOBILE_HEIGHT);
        mobile.put("pixelRatio", 1.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", mobile);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--hide-scrollbars");
        return new ChromeDriver(chromeOptions);*/
    }

    public void desktopAutomationTest(String savePath){
    }


    public void mobileAutomationTest(String savePath) {
    }
}
