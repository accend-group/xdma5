package com.gene.screenshots;

import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.en.Avastin;
import com.gene.screenshots.selenium.accesssolutions.en.Gazyva;
import com.gene.screenshots.selenium.accesssolutions.en.Xolair;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickHeadless extends SeleniumHeadless {



    private static final Logger[] pin;
    static {
        pin = new Logger[]{
                Logger.getLogger("com.gargoylesoftware.htmlunit"),
                Logger.getLogger("org.apache.commons.httpclient"),
                Logger.getLogger("org.openqa.selenium.remote.ProtocolHandshake")
        };

        for (Logger l : pin) {
            l.setLevel(Level.OFF);
        }
    }

    public void start(){
        String chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.contains("win"))
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver.exe";
        else
            chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        //System.setProperty("webdriver.chrome.logfile", "chromedriver.log");

        SeleniumHeadless.setChromeSystemProperty(chromedriverPath);
        SeleniumHeadless test = new Xolair();
        test.desktopAutomationTest("TEST_PATH/desktop");
        test.mobileAutomationTest("TEST_PATH/mobile");
    }

    public static void main(String [] args){
        new QuickHeadless().start();
    }
}
