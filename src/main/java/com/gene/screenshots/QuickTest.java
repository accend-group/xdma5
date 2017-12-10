package com.gene.screenshots;

import com.gene.screenshots.selenium.SeleniumTest;
import org.openqa.selenium.WebDriver;

public class QuickTest extends SeleniumTest{

    public void start(){
        String chromedriverPath = "node_modules/chromedriver/lib/chromedriver/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        WebDriver driver = makeDesktopDriver();
        try {
        driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety.html");///http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
        System.out.println("x: " + getCurrentScrollX(driver) + " y: "+ getCurrentScrollY(driver));

        scrollTo(driver,0, 500);
        visible(driver, false, ".", "mobileTestVisible");
        System.out.println("x: " + getCurrentScrollX(driver) + " y: "+ getCurrentScrollY(driver));


            full(driver, false, "." , "mobileTestFull");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close(); driver.quit();
    }

    public static void main(String [] args){
        new QuickTest().start();
    }
}
