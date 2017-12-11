package com.gene.screenshots;

import com.gene.screenshots.selenium.SeleniumHeadless;
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
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        for(int i = 0; i < 1; ++i) {


            // System.setProperty("webdriver.chrome.args", "--disable-logging");
            //System.setProperty("webdriver.chrome.silentOutput", "true");
            WebDriver driver = makeMobileDriver();
            try {
                driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety.html");///http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
                driver.findElement(By.className("cheese")).click();
                System.out.println("x: " + getCurrentScrollX(driver) + " y: " + getCurrentScrollY(driver));

                scrollTo(driver, 0, 500);
                visible(driver, false, ".", "mobileTestVisible");
                System.out.println("x: " + getCurrentScrollX(driver) + " y: " + getCurrentScrollY(driver));


                full(driver, false, ".", "mobileTestFull");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                driver.close();
                driver.quit();
            }

        }
    }

    public static void main(String [] args){
        new QuickHeadless().start();
    }
}
