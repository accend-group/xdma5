package com.gene.screenshots.selenium.accesssolutions.en;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Patient extends SeleniumHeadless {

    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();

        try {
            //---->> patient <<---- 12 screenshot for patient homepage
            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
            driver.findElement(By.id("select-treatment")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "accesssolutions-patient-select-treatment");

            Thread.sleep(1000);
            driver.findElement(By.className("product-popup")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "accesssolutions-patient-product-popup");

            driver.findElement(By.xpath("//*[@id='product-selector']/div/div/div[2]/div/div/ul/li[16]/a")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "accesssolutions-patient-rituxan-popup");
            driver.findElement(By.xpath("//*[@id='sub-indications-selector']/div/div/div[1]/button")).click();

            Thread.sleep(1000);
            driver.findElement(By.linkText("For US Healthcare Professionals")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "accesssolutions-patient-hcp-modal");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-0.0");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/home.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-home");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/home/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pat");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/search.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-search");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/pan.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pan");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/biooncology.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-biooncology");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/rheumatology.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-rheumatology");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/contact-us.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-contact-us");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }


    public void mobileAutomationTest(String savePath) {

        WebDriver driver = makeMobileDriver();
        try {
            //---->> patient mobile <<---- 13 screenshot for patient homepage mobile


            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
            driver.findElement(By.id("select-treatment")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "accesssolutions-mobile-patient-select-treatment");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();
            ;
            Thread.sleep(1000);
            visible(driver, false, savePath, "accesssolutions-mobile-patient-navigation");

            Thread.sleep(1000);
            driver.findElement(By.className("product-popup")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "accesssolutions-mobile-patient-product-popup");

            driver.findElement(By.xpath("//*[@id='product-selector']/div/div/div[2]/div/div/ul/li[16]/a")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "accesssolutions-mobile-patient-rituxan-popup");
            driver.findElement(By.xpath("//*[@id='sub-indications-selector']/div/div/div[1]/button")).click();

            Thread.sleep(1000);
            driver.findElement(By.linkText("US Healthcare Professionals")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "accesssolutions-mobile-patient-hcp-modal");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-0.0");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/home.html");
            Thread.sleep(500);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-home");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/home/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pat");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/search.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-search");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/pan.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pan");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/biooncology.html");
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-biooncology");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/rheumatology.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-rheumatology");

            goToUrl(driver, "http://localhost:4503/content/accesssolutions-site/en_us/patient/contact-us.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-contact-us");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }

    public static void movecursor(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        WebElement element;

        jse.executeScript("window.scrollTo(0, 0)");
        element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/button"));
        action.moveToElement(element).build().perform();
    }

    public static void movecursorm(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        WebElement element;

        jse.executeScript("window.scrollTo(0, 0)");
        element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/button"));
        action.moveToElement(element).build().perform();
    }
}
