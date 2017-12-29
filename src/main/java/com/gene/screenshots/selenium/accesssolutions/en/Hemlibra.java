package com.gene.screenshots.selenium.accesssolutions.en;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hemlibra extends SeleniumHeadless {

    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);
            // ---->> hemlibra <<---- // 37 screenshots
            goToUrl(driver, "/patient/brands/hemlibra.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-0.0");

            goToUrl(driver, "/patient/brands/hemlibra/how-we-help-you.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0");

            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("How do I enroll?")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);;*/
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What will we find out?")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1000L);*/
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1000L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What options are there?")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1000L);*/
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1000L);

            goToUrl(driver, "/patient/brands/hemlibra/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-2.0-esubmit");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/hemlibra/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-3.0");

            getScreenshotForAccordion(driver, "accesssolutions-patient-hemlibra-3.0", savePath, true);

            goToUrl(driver, "/patient/brands/hemlibra/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-part1");
            jse.executeScript("window.scrollTo(0, 0)");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-part2");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-1-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-1-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-more-info-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-2");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-3-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-pat-3-part2");

            goToUrl(driver, "/patient/brands/hemlibra/search.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-search");

            goToUrl(driver, "/patient/brands/hemlibra/site-map.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-hemlibra-sitemap");
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

            // TODO Auto-generated method stub

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            // ---->> hemlibra <<---- // 37 screenshots
            goToUrl(driver, "/patient/brands/hemlibra.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-0.0");

            goToUrl(driver, "/patient/brands/hemlibra/how-we-help-you.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF3-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF4-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF1-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF2-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF3-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-GATCF4-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[5]/div/div/div[2]/div/div/div[1]/div"));
            jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:50px;')", element);
            /*driver.findElement(By.linkText("How do I enroll?")).click();
            jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:0px;')", element);
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);;*/
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What will we find out?")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1000L);*/
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1000L);


            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What options are there?")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1000L);*/
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1000L);


            goToUrl(driver, "/patient/brands/hemlibra/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-2.0");

            goToUrl(driver, "/patient/brands/hemlibra/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-3.0");

            getScreenshotForAccordion(driver, "accesssolutions-mobile-patient-hemlibra-3.0", savePath, false);

            goToUrl(driver, "/patient/brands/hemlibra/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat1-no");
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat2-no");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat3-yes");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat3-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat4-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-pat4-no");

            goToUrl(driver, "/patient/brands/hemlibra/search.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-search");

            goToUrl(driver, "/patient/brands/hemlibra/site-map.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-hemlibra-sitemap");
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
        element = driver.findElement(By.name("q"));
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