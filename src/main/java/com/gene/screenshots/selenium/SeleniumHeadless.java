package com.gene.screenshots.selenium;

import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.gene.screenshots.Constants.*;

/** Abstract class for screenshot automation code
 *  Create another class that extends SeleniumHeadless
 *  each class represents a selenium test that produces screenshots.
 *  each screenshot is saved in a log file that is used to create a PDF.
 *  The mobile and desktop automated test functions must quit the driver at the end.
 */

public abstract class SeleniumHeadless extends Screenshots {

    // TODO optimize mobiledriver/desktop with limited thread count?
    protected WebDriver desktopDriver;
    protected WebDriver mobileDriver;

    // suppress selenium console log
    static {
        final Logger[] pin;
        pin = new Logger[]{
                Logger.getLogger("com.gargoylesoftware.htmlunit"),
                Logger.getLogger("org.apache.commons.httpclient"),
                Logger.getLogger("org.openqa.selenium.remote.ProtocolHandshake")
        };
        for (Logger l : pin) {
            l.setLevel(Level.OFF);
        }
    }

    public static void setChromeSystemProperty(String chromedriverPath){
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
    }

    public static WebDriver makeDesktopDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //options.addArguments("window-size="+ DESKTOP_WIDTH + "," + DESKTOP_HEIGHT);
        //options.addArguments("--disable-gpu-watchdog");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-infobars");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--hide-scrollbars");
        WebDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingAnyFreePort().withSilent(true).build(), options);
        driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        return driver;
    }

    public static WebDriver makeMobileDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size="+ MOBILE_WIDTH + "," + MOBILE_HEIGHT);
        options.addArguments("--use-mobile-user-agent=true");
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--hide-scrollbars");
        return new ChromeDriver(new ChromeDriverService.Builder().usingAnyFreePort().withSilent(true).build(), options);
    }

    public void desktopAutomationTest(String savePath){
        desktopDriver = makeDesktopDriver();
    }


    public void mobileAutomationTest(String savePath) {
        mobileDriver = makeMobileDriver();
    }
}
