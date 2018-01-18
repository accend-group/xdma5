package com.gene.screenshots.selenium.kadcyla.patient;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Consumer;

public class KadcylaPatient extends SeleniumHeadless {

    @Override
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();

        try {
            Consumer<WebDriver> movecursor = (d) -> {
                Actions actions = new Actions(d);
                WebElement mainMenu = d.findElement(By.name("q"));
                actions.moveToElement(mainMenu);
                actions.click().build().perform();
            };

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions action = new Actions(driver);
            WebElement element;

            goToUrl(driver, "/patient.html");
            
            visible(driver, true, savePath, "kadcyla-patient");

            element = driver.findElement(By.linkText("KADCYLA and HER2+ Metastatic Breast Cancer"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1500);
            visible(driver, true, savePath, "kadcyla-hover-1.0");

            element = driver.findElement(By.linkText("About KADCYLA"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1500);
            visible(driver, true, savePath, "kadcyla-hover-2.0");

            element = driver.findElement(By.linkText("Support and Resources"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1500);
            visible(driver, true, savePath, "kadcyla-hover-3.0");

            driver.navigate().refresh();
            jse.executeScript("window.scrollTo(0,1000)", "");
            forceClick(driver, driver.findElement(By.linkText("http://www.motherpregnancyregistry.com/")));
            jse.executeScript("window.scrollTo(0,0)", "");
            Thread.sleep(1500);
            visible(driver, true, savePath, "kadcyla-link-modal");

//		driver.navigate().refresh();
//		driver.findElement(By.className("genentech-component--button__text")).click();
//		Thread.sleep(1500);
//            visible(driver, true, savePath, "kadcyla-share-modal");
//
//		driver.findElement(By.name("fname")).sendKeys("Marwin");
//		driver.findElement(By.name("lname")).sendKeys("Nicolas");
//		driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.xpath("/html/body/section[2]/div[3]/div/div/form/div/div[3]/input")).click();
//		Thread.sleep(1500);
//            visible(driver, true, savePath, "kadcyla-share-modal-submit");

            //		//--->start full page screenshot <---//

            goToUrl(driver, "/patient.html");
            
            full(driver, true, savePath, "kadcyla-0.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer.html");
            
            full(driver, true, savePath, "kadcyla-1.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
            
            full(driver, true, savePath, "kadcyla-1.1");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/treatment.html");
            
            full(driver, true, savePath, "kadcyla-1.2");

            goToUrl(driver, "/patient/about-kadcyla.html");
            
            full(driver, true, savePath, "kadcyla-2.0");

            goToUrl(driver, "/patient/about-kadcyla/dosing-and-administration.html");
            
            full(driver, true, savePath, "kadcyla-2.1");

            goToUrl(driver, "/patient/about-kadcyla/benefits-risks.html");
            
            full(driver, true, savePath, "kadcyla-2.2");

            goToUrl(driver, "/patient/about-kadcyla/talk-with-healthcare-team.html");
            
            full(driver, true, savePath, "kadcyla-2.3");

            goToUrl(driver, "/patient/support-resources.html");
            
            full(driver, true, savePath, "kadcyla-3.0");

            goToUrl(driver, "/patient/support-resources/4HER-patient-support-app.html");
            
            full(driver, true, savePath, "kadcyla-3.1");

            //driver.manage().window().setSize(new Dimension(1612,750));
            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            
            full(driver, true, savePath, "kadcyla-3.2");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            full(driver, true, savePath, "kadcyla-3.2-pat1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat3-no");

            jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat4-yes");

            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat1-no");

            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat2-no");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat3-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));//.click();
            forceClick(driver, driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")));
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            //scrollTo(driver, 0,500);
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();

            forceClick(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            movecursor.accept(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat4-no");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            

            scrollAndClickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));
            //driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-tab1");
            driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-tab2");
            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-tab3");
            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-tab4");
            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-tab5");
            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-tab6");
            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();


            //driver.manage().window().maximize();
            goToUrl(driver, "/patient/support-resources/herconnection-support-program.html");
            
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.3");

            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");

            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.className("submit")).click();

            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.3-submit");

            goToUrl(driver, "/patient/support-resources/breast-cancer-support-groups.html");
            
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.4");

            goToUrl(driver, "/patient/support-resources/downloads.html");
            
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.5");

            goToUrl(driver, "/patient/safety.html");
            
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-safety");

            goToUrl(driver, "/patient/site-map.html");
            
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-sitemap");

            goToUrl(driver, "/patient/glossary.html");
            
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-glossary");
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

        Consumer<WebDriver> movemouse = (d) -> {
            Actions action = new Actions(d);
            WebElement element;
            element = d.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/div[1]/a[2]/i[1]"));
            action.moveToElement(element).build().perform();
        };

        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //driver.manage().window().maximize();

            goToUrl(driver, "/patient.html");
            visible(driver, false, savePath, "kadcyla-mobile-patient");

            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1500);
            driver.findElement(By.className("gene-component--navigation__icon--tab")).click();
            Thread.sleep(1500);
            visible(driver, false, savePath, "kadcyla-mobile-hover-1.0");

            driver.navigate().refresh();
            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//nav/div/div[2]/div/ul/li[2]/a/i")).click();
            Thread.sleep(1500);
            visible(driver, false, savePath, "kadcyla-mobile-hover-2.0");

            goToUrl(driver, "/patient.html");
            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//nav/div/div[2]/div/ul/li[3]/a/i")).click();
            Thread.sleep(1500);
            visible(driver, false, savePath, "kadcyla-mobile-hover-3.0");

            goToUrl(driver, "/patient.html");
            jse.executeScript("window.scrollBy(0,3500)", "");
            driver.findElement(By.linkText("http://www.motherpregnancyregistry.com/")).click();
            jse.executeScript("window.scrollTo(0,0)", "");
            Thread.sleep(1500);
            visible(driver, false, savePath, "kadcyla-mobile-link-modal");

//		//--->start full page screenshot <---//

            goToUrl(driver, "/patient.html");
            
            full(driver, false, savePath, "kadcyla-mobile-0.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer.html");
            
            full(driver, false, savePath, "kadcyla-mobile-1.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
            
            full(driver, false, savePath, "kadcyla-mobile-1.1");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/treatment.html");
            
            full(driver, false, savePath, "kadcyla-mobile-1.2");

            goToUrl(driver, "/patient/about-kadcyla.html");
            
            full(driver, false, savePath, "kadcyla-mobile-2.0");

            goToUrl(driver, "/patient/about-kadcyla/benefits-risks.html");
            
            full(driver, false, savePath, "kadcyla-mobile-2.2");

            goToUrl(driver, "/patient/about-kadcyla/talk-with-healthcare-team.html");
            
            full(driver, false, savePath, "kadcyla-mobile-2.3");

            goToUrl(driver, "/patient/support-resources.html");
            
            full(driver, false, savePath, "kadcyla-mobile-3.0");

            goToUrl(driver, "/patient/support-resources/4HER-patient-support-app.html");
            
            full(driver, false, savePath, "kadcyla-mobile-3.1");

            goToUrl(driver, "/patient/support-resources/herconnection-support-program.html");
            full(driver, false, savePath, "kadcyla-mobile-3.3");

            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");

            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.className("submit")).click();

            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.3-submit");

            goToUrl(driver, "/patient/support-resources/breast-cancer-support-groups.html");
            
            full(driver, false, savePath, "kadcyla-mobile-3.4");

            goToUrl(driver, "/patient/support-resources/downloads.html");
            full(driver, false, savePath, "kadcyla-mobile-3.5");

            goToUrl(driver, "/patient/safety.html");
            full(driver, false, savePath, "kadcyla-mobile-safety");

            goToUrl(driver, "/patient/site-map.html");
            full(driver, false, savePath, "kadcyla-mobile-sitemap");

            goToUrl(driver, "/patient/glossary.html");
            full(driver, false, savePath, "kadcyla-mobile-glossary");

            goToUrl(driver, "/patient/about-kadcyla/dosing-and-administration.html");
            full(driver, false, savePath, "kadcyla-mobile-2.1");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            full(driver, false, savePath, "kadcyla-mobile-3.2");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");

            scrollAndClickAt(driver, "/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]");
            //WebElement e = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]"));
            //e.click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat1-yes");
            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat2-yes");
            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat3-no");
            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat4-yes");
            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat1-no");

            //jse.executeScript("window.scrollTo(0, 0)");
            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat2-no");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat3-yes");

            //jse.executeScript("window.scrollTo(0, 0)");
            //driver.findElement(By.className("start-over")).click();
            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            movemouse.accept(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat4-no");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            scrollAndClickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));
            //driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab1");
            scrollAndClickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));


            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab2");
            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab3");
            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab4");
            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab5");
            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab6");
            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
