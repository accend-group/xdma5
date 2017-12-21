package com.gene.screenshots.selenium.accesssolutions.en;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Gazyva extends SeleniumHeadless {

    @Override
    public void desktopAutomationTest(String savePath) {

        // TODO Auto-generated method stub
        WebDriver driver = makeDesktopDriver();
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);
            // ---->> gazyva <<---- // 38 screenshots
            goToUrl(driver, "/patient/brands/gazyva.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-0.0");

            goToUrl(driver, "/patient/brands/gazyva/how-we-help-you.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-tab1");

            driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("How do I enroll?")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1500L);;*/
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1500L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What will we find out?")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1500L);*/
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1500L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What options are there?")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1500L);*/
            full(driver, true, savePath, "accesssolutions-patient-gazyva-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1500L);

            goToUrl(driver, "/patient/brands/gazyva/forms-and-documents.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-2.0-esubmit");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/gazyva/frequently-asked-questions.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab1");

            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab2");

            driver.findElement(By.xpath("//*[@id='accordion_617592650']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab3");

            driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab4");

            driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab5");

            driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab6");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab7");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab8");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab9");

            driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab10");

            driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-3.0-tab11");

            goToUrl(driver, "/patient/brands/gazyva/patient-assistance-tool-page.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-part1");
            jse.executeScript("window.scrollTo(0, 0)");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-part2");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-1-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-1-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-more-info-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-2-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-2-part2");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-3-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-pat-3-part2");

            goToUrl(driver, "/patient/brands/gazyva/search.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-search");

            goToUrl(driver, "/patient/brands/gazyva/site-map.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "accesssolutions-patient-gazyva-sitemap");
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

            // ---->> gazyva <<---- // 38 screenshots
            goToUrl(driver, "/patient/brands/gazyva.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-0.0");

            goToUrl(driver, "/patient/brands/gazyva/how-we-help-you.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-tab1");

            driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF3-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF4-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF1-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF2-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF3-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-GATCF4-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();

            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-step1",  driver.findElement(By.linkText("How do I enroll?")), 1500L);
           /* movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1500L);;*/

            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1500L);
            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What will we find out?")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1500L);*/

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What options are there?")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1500L);*/
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1500L);

            goToUrl(driver, "/patient/brands/gazyva/forms-and-documents.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-2.0");

            goToUrl(driver, "/patient/brands/gazyva/frequently-asked-questions.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab1");

            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab2");

            driver.findElement(By.xpath("//*[@id='accordion_617592650']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab3");

            driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab4");

            driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab5");

            driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab6");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab7");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab8");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab9");

            driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab10");

            driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-3.0-tab11");

            goToUrl(driver, "/patient/brands/gazyva/patient-assistance-tool-page.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat1-no");
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat2-no");
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat3-yes");
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat3-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat4-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-pat4-no");

            goToUrl(driver, "/patient/brands/gazyva/search.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-search");

            goToUrl(driver, "/patient/brands/gazyva/site-map.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "accesssolutions-mobile-patient-gazyva-sitemap");
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

    public static void movecursor1(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        WebElement element;

        jse.executeScript("window.scrollTo(0, 0)");
        element = driver.findElement(By.linkText("FAQs"));
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
