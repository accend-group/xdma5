package com.gene.screenshots.selenium.accesssolutions.es;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Kadcyla extends SeleniumHeadless {

    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions actions = new Actions(driver);


            //---->> kadcyla <<---- 28 screenshot for kadcyla
            goToUrl(driver, "/patient/brands/kadcyla.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-0.0");

            goToUrl(driver, "/patient/brands/kadcyla/how-we-help-you.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0-tab1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0-GATCF-2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�C�mo me inscribo?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0-step1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� averiguaremos?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0-step2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� opciones hay?")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-1.0-step3");

            goToUrl(driver, "/patient/brands/kadcyla/forms-and-documents.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-2.0-esubmit");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/kadcyla/frequently-asked-questions.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_519706794']/div/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab3");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab4");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab5");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab6");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab7");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab8");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab9");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
            movecursor1(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab10");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-3.0-tab11");

            goToUrl(driver, "/patient/brands/kadcyla/patient-assistance-tool-page.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-part2");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-1-part1");

            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-1-part2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-more-info-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-2-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-2-part2");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-3-part1");

            jse.executeScript("window.scrollTo(0, 0)");
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-pat-3-part2");

            goToUrl(driver, "/patient/brands/kadcyla/search.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-search");

            goToUrl(driver, "/patient/brands/kadcyla/site-map.html");
            full(driver, true, savePath, "accesssolutions-patient-kadcyla-sitemap");
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

            JavascriptExecutor jse = (JavascriptExecutor) driver;


            //---->> kadcyla <<---- 28 screenshot for kadcyla
            goToUrl(driver, "/patient/brands/kadcyla.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-0.0");

            goToUrl(driver, "/patient/brands/kadcyla/how-we-help-you.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0");

            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0-tab1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0-GATCF-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0-GATCF-2");

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
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0-step1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� averiguaremos?")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0-step2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.linkText("�Qu� Opciones Hay?")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-1.0-step3");

            goToUrl(driver, "/patient/brands/kadcyla/forms-and-documents.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-2.0");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-2.0-more-info-1");

            driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-2.0-more-info-2");

            goToUrl(driver, "/patient/brands/kadcyla/frequently-asked-questions.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab2");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_519706794']/div/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab3");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab4");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab5");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab6");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab7");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab8");

            driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab9");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab10");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
            movecursorm(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-3.0-tab11");

            goToUrl(driver, "/patient/brands/kadcyla/patient-assistance-tool-page.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-pat");
            jse.executeScript("window.scrollTo(0, 0)");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-pat-1");
            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.className("start-over")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-pat-more-info-1");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-pat-2");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-pat-more-info-2");

            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
            driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-pat-3");

            goToUrl(driver, "/patient/brands/kadcyla/search.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-search");

            goToUrl(driver, "/patient/brands/kadcyla/site-map.html");
            full(driver, false, savePath, "accesssolutions-mobile-patient-kadcyla-sitemap");
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
        element = driver.findElement(By.linkText("Preguntas Frecuentes"));
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
