package com.gene.screenshots.selenium.accesssolutions.perjeta;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.gene.screenshots.pdf.PDFMaker;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;

import static com.gene.screenshots.selenium.Constants.CHROME_HEIGHT_CAP;
import static com.gene.screenshots.selenium.Constants.MOBILE_WIDTH;

public class Perjeta extends SeleniumHeadless{

    public static void main(String [] args){

        new Perjeta().mobileAutomationTest("");
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = null;
        try {
            driver = makeMobileDriver();
            driver.get("http://www.perjeta.com");//"https://dev-perjeta.gene.com/");
            Thread.sleep(1000);
            forceClick(driver, "/html/body/section[2]/div[4]/div/footer/a[2]");

            Thread.sleep(1000);
            full(driver, false, "perjeta", "Patient_Eligibility");
            forceClick(driver, "/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[1]/header");

            Thread.sleep(1000);
            forceClick(driver, "/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header");
            full(driver, false, "perjeta", "Design_Trail");
            forceClick(driver, "/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header");

            Thread.sleep(1000);
            forceClick(driver, ("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header"));
            full(driver, false, "perjeta", "Efficacy_data");
            forceClick(driver, "/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header");

            Thread.sleep(1000);
            forceClick(driver, ("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header"));
            full(driver, false, "perjeta", "Safety_profile");
            forceClick(driver, "/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header");

            Thread.sleep(1000);
            forceClick(driver, "/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[5]/header");
            full(driver, false, "perjeta", "Dosing");

            driver.get("https://en.wikipedia.org/wiki/Star_Wars");
            Thread.sleep(1000);
            full(driver, false, "perjeta", "starwars_mine");


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(driver != null)
                driver.quit();
        }

    }
}
