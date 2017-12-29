package com.gene.screenshots.selenium.accesssolutions.es;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Pulmozyme extends SeleniumHeadless {

    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);


            //---->> pulmozyme <<---- 42 screenshot for pulmozyme
            goToUrl(driver, "/patient/brands/pulmozyme.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-0.0");

            goToUrl(driver, "/patient/brands/pulmozyme/how-we-help-you.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-1.0");

            getScreenshotForAccordion(driver, "accesssolutions-patient-pulmozyme-1.0", savePath, true);

            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�C�mo me inscribo?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-1.0-step1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� averiguaremos?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-1.0-step2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� opciones hay?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-1.0-step3");

            goToUrl(driver, "/patient/brands/pulmozyme/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-2.0-esubmit");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/pulmozyme/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-3.0");

            getScreenshotForAccordion(driver, "accesssolutions-patient-pulmozyme-3.0", savePath, true);

            goToUrl(driver, "/patient/brands/pulmozyme/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-part2");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[6]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-part3");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-1-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-1-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-more-info-1");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-2-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-2-part2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[5]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[6]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-3-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-pat-3-part2");

            goToUrl(driver, "/patient/brands/pulmozyme/search.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-search");

            goToUrl(driver, "/patient/brands/pulmozyme/site-map.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-pulmozyme-sitemap");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {

            // TODO Auto-generated method stub
            JavascriptExecutor jse = (JavascriptExecutor) driver;


            //---->> pulmozyme <<---- 42 screenshot for pulmozyme
            goToUrl(driver, "/patient/brands/pulmozyme.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-0.0");

            goToUrl(driver, "/patient/brands/pulmozyme/how-we-help-you.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-1.0");

            getScreenshotForAccordion(driver, "accesssolutions-mobile-patient-pulmozyme-1.0", savePath, true);

            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
//		WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[6]/div/div/div[2]/div/div/div[1]/div/div"));
//		jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:50px;')",element);
            driver.findElement(By.linkText("�C�mo me inscribo?")).click();
//		jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:0px;')",element);
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-1.0-step1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� averiguaremos?")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-1.0-step2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� opciones hay?")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-1.0-step3");

            goToUrl(driver, "/patient/brands/pulmozyme/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/pulmozyme/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-3.0");

            getScreenshotForAccordion(driver, "accesssolutions-mobile-patient-pulmozyme-1.0", savePath, false);

            goToUrl(driver, "/patient/brands/pulmozyme/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-pat");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-pat-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-pat-more-info-1");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-pat-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[5]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[6]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-pat-3");

            goToUrl(driver, "/patient/brands/pulmozyme/search.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-search");

            goToUrl(driver, "/patient/brands/pulmozyme/site-map.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-pulmozyme-sitemap");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
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
