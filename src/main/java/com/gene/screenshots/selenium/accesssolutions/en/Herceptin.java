package com.gene.screenshots.selenium.accesssolutions.en;

import com.amazonaws.services.dynamodbv2.xspec.B;
import com.gene.screenshots.Variables;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.gene.screenshots.selenium.Constants.MOBILE_WIDTH;
import static com.gene.screenshots.EnvironmentType.PROD;

public class Herceptin extends SeleniumHeadless {

    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
        try {
            // TODO Auto-generated method stub
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);


            //---->> herceptin <<---- 29 screenshot for herceptin
            goToUrl(driver, "/patient/brands/herceptin.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-0.0");

            goToUrl(driver, "/patient/brands/herceptin/how-we-help-you.html");
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-tab1");

            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-tab2");
            jse.executeScript("window.scrollTo(0, 0)");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");

            String textFromLink;
            if(Variables.getDomain().getType() == PROD)
                textFromLink = "Learn more about how to enroll";
                //driver.findElement(By.linkText("Learn more about how to enroll")).click();
            else // dev, stage, local has this text
                textFromLink = "How do I enroll?";
                //driver.findElement(By.linkText("How do I enroll?")).click();
            //full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);;*/
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-step1", driver.findElement(By.linkText(textFromLink)), 1000L);

            //jse.executeScript("window.scrollTo(0, 0)");
            if(Variables.getDomain().getType() == PROD)
                textFromLink = "What we find out";
                //driver.findElement(By.linkText("What we find out")).click();
            else  // dev, stage, local has this text
                textFromLink = "What will we find out?";
                //driver.findElement(By.linkText("What will we find out?")).click();
            //Thread.sleep(1000);
            //full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-step2", driver.findElement(By.linkText("What will we find out?")), 1000L);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-step2", driver.findElement(By.linkText(textFromLink)), 1000L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What options are there?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1000L);*/
            full(driver, true, savePath, "accesssolutions-patient-herceptin-1.0-step3", driver.findElement(By.linkText("What options are there?")), 1000L);

            goToUrl(driver, "/patient/brands/herceptin/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-2.0-esubmit");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/herceptin/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_1321572214']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab3");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab4");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab5");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab6");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab7");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab8");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab9");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab10");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-3.0-tab11");

            goToUrl(driver, "/patient/brands/herceptin/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-part2");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-1-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-1-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-more-info-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-2-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-2-part2");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            forceClick(driver, "//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]");
            //driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-3-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-pat-3-part2");

            goToUrl(driver, "/patient/brands/herceptin/search.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-search");

            goToUrl(driver, "/patient/brands/herceptin/site-map.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-herceptin-site-map");
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


            //---->> herceptin <<---- 29 screenshot for herceptin
            goToUrl(driver, "/patient/brands/herceptin.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-0.0");

            goToUrl(driver, "/patient/brands/herceptin/how-we-help-you.html");
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-tab1");

            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF3-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF4-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF1-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF2-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF3-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-GATCF4-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[6]/div/div/div[2]/div/div/div[1]/div/div"));
            jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:50px;')", element);

            String textFromLink;
            if(Variables.getDomain().getType() == PROD)
                textFromLink = "Learn more about how to enroll";
                //driver.findElement(By.linkText("Learn more about how to enroll")).click();
            else // dev, stage, local has this text
                textFromLink = "How do I enroll?";
                //driver.findElement(By.linkText("How do I enroll?")).click();

            /*jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:0px;')", element);
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-step1", driver.findElement(By.linkText("How do I enroll?")), 1000L);;*/
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-step1", driver.findElement(By.linkText(textFromLink)), 1000L);

            //jse.executeScript("window.scrollTo(0, 0)");
            //driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));

            if(Variables.getDomain().getType() == PROD) {
                textFromLink = "What we find out";
                /*Actions actions = new Actions(driver);
                element = driver.findElement(By.linkText("What we find out"));
                actions.moveToElement(element).click().perform();*/
            }
            else // dev, stage, local has this text
                textFromLink = "What will we find out?";
                //scrollAndClickAt(driver, driver.findElement(By.linkText("What will we find out?")));
            //driver.findElement(By.linkText("What we find out")).click();
            //Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-step2", driver.findElement(By.linkText(textFromLink)), 1000L);

            /*jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("What options are there?")).click();
            Thread.sleep(1000);*/
            textFromLink = "What options are there?";
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-1.0-step3", driver.findElement(By.linkText(textFromLink)), 1000L);

            goToUrl(driver, "/patient/brands/herceptin/forms-and-documents.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-2.0");

            goToUrl(driver, "/patient/brands/herceptin/frequently-asked-questions.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_1321572214']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab3");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab4");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab5");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab6");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab7");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab8");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab9");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab10");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-3.0-tab11");

            goToUrl(driver, "/patient/brands/herceptin/patient-assistance-tool-page.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat1-no");
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat2-no");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat3-yes");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat3-no");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat4-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-pat4-no");

            goToUrl(driver, "/patient/brands/herceptin/search.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-search");

            goToUrl(driver, "/patient/brands/herceptin/site-map.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-herceptin-site-map");
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
