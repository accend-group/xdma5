package com.gene.screenshots.selenium.accesssolutions.en;


import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actemra extends SeleniumHeadless {

    @Override
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);

            //---->> actemra <<---- 45 screenshot for actemra
            goToUrl(driver, "/patient/brands/actemra.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-0.0");

            goToUrl(driver, "/patient/brands/actemra/how-we-help-you.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-1.0");

            getScreenshotForAccordion(driver, "accesssolutions-patient-actemra-1.0", savePath, true);

            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");

            //driver.findElement(By.cssSelector("#callout_v2 > p:nth-child(5) > a")).click();
            full(driver, true, savePath, "accesssolutions-patient-actemra-1.0-step1", driver.findElement(By.xpath("//*[@id=\"callout_v2\"]/p[2]/a")), new Long(1000));//driver.findElement(By.linkText("How do I enroll?")), new Long(1000));
            //driver.findElement(By.linkText("How do I enroll?")).click();

            //full(driver, true, savePath, "accesssolutions-patient-actemra-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);;
            jse.executeScript("window.scrollTo(0, 0)");
            //driver.findElement(By.linkText("What will we find out?")).click();
            //Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-1.0-step2", driver.findElement(By.linkText("What will we find out?")), new Long(1000));

            jse.executeScript("window.scrollTo(0, 0)");
            //driver.findElement(By.linkText("What options are there?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-1.0-step3", driver.findElement(By.linkText("What options are there?")), new Long(1000));

            goToUrl(driver, "/patient/brands/actemra/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-2.0-esubmit");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/actemra/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-3.0");

            getScreenshotForAccordion(driver, "accesssolutions-patient-actemra-3.0", savePath, true);

            goToUrl(driver, "/patient/brands/actemra/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-part1");
            jse.executeScript("window.scrollTo(0, 0)");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[5]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-part2");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[7]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-part3");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-1-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-1-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[7]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-2-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-2-part2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[7]/div[2]/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[7]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-3-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-3-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-more-info-1");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-more-info-3");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-4");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[7]/div[2]/button")).click();
            Thread.sleep(1000);
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[6]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-pat-more-info-4");

            goToUrl(driver, "/patient/brands/actemra/search.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-search");

            goToUrl(driver, "/patient/brands/actemra/site-map.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-actemra-site-map");
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
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //---->> actemra_mobile <<---- 45 screenshot for actemra mobile
            goToUrl(driver, "/patient/brands/actemra.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-0.0");

            goToUrl(driver, "/patient/brands/actemra/how-we-help-you.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-1.0");

            getScreenshotForAccordion(driver, "accesssolutions-mobile-patient-actemra-1.0", savePath, false);
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[6]/div/div/div[2]/div/div/div[1]/div/div"));
            jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:50px;')", element);
            //driver.findElement(By.linkText("How do I enroll?")).click();
            jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:0px;')", element);

            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-1.0-step1", driver.findElement(By.xpath("//*[@id=\"callout_v2\"]/p[2]/a")), new Long(1000));//driver.findElement(By.linkText("How do I enroll?")), new Long(1000));

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What will we find out?")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-1.0-step2", driver.findElement(By.linkText("What will we find out?")), new Long(1000));

            jse.executeScript("window.scrollTo(0, 0)");
            //driver.findElement(By.linkText("What options are there?")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-1.0-step3", driver.findElement(By.linkText("What options are there?")), new Long(1000));

            goToUrl(driver, "/patient/brands/actemra/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/actemra/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-3.0");

            getScreenshotForAccordion(driver, "accesssolutions-mobile-patient-actemra-3.0", savePath, false);

            goToUrl(driver, "/patient/brands/actemra/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-part1");
            jse.executeScript("window.scrollTo(0, 0)");


            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[7]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[7]/div[2]/button")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[7]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-3");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-4");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-more-info-1");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-more-info-3");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[6]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-pat-more-info-4");

            goToUrl(driver, "/patient/brands/actemra/search.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-search");

            goToUrl(driver, "/patient/brands/actemra/site-map.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-actemra-site-map");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
