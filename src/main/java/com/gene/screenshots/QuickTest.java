package com.gene.screenshots;

import com.gene.screenshots.selenium.SeleniumTest;
import org.openqa.selenium.WebDriver;

public class QuickTest extends SeleniumTest{

    public void start(){
        String chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        WebDriver driver = mobileDriver();
        driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety.html");///http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");

        try {
            full(driver, false, "." , "mobileTest");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public static void main(String [] args){
        new QuickTest().start();
    }
}
