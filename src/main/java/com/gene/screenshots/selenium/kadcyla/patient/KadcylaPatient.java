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

            goToUrl(driver, "/patient.html");
            Thread.sleep(1500);
            visible(driver, true, savePath, "kadcyla-patient");

            getScreenshotForDesktopNavigation(driver, action, "kadcyla", savePath);

            driver.navigate().refresh();
            getScreenshotForThirdPartyModal(driver, "kadcyla", savePath, true);

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
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-0.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-1.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-1.1");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/treatment.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-1.2");

            goToUrl(driver, "/patient/about-kadcyla.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-2.0");

            goToUrl(driver, "/patient/about-kadcyla/dosing-and-administration.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-2.1");

            goToUrl(driver, "/patient/about-kadcyla/benefits-risks.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-2.2");

            goToUrl(driver, "/patient/about-kadcyla/talk-with-healthcare-team.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-2.3");

            goToUrl(driver, "/patient/support-resources.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.0");

            goToUrl(driver, "/patient/support-resources/4HER-patient-support-app.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.1");

            //driver.manage().window().setSize(new Dimension(1612,750));
            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
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

            getScreenshotForAccordion(driver, "kadcyla-3.2", savePath, true);

            //driver.manage().window().maximize();
            goToUrl(driver, "/patient/support-resources/herconnection-support-program.html");
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.3");


            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
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
            goToUrl(driver, "/patient.html");
            Thread.sleep(1500);
            visible(driver, false, savePath, "kadcyla-mobile-patient");

            getScreenshotForMobileNavigation(driver, "kadcyla", savePath);

            goToUrl(driver, "/patient.html");
            getScreenshotForThirdPartyModal(driver, "kadcyla-mobile", savePath, false);

//		//--->start full page screenshot <---//

            goToUrl(driver, "/patient.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-0.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-1.0");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-1.1");

            goToUrl(driver, "/patient/her2-positive-breast-cancer/treatment.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-1.2");

            goToUrl(driver, "/patient/about-kadcyla.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-2.0");

            goToUrl(driver, "/patient/about-kadcyla/benefits-risks.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-2.2");

            goToUrl(driver, "/patient/about-kadcyla/talk-with-healthcare-team.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-2.3");

            goToUrl(driver, "/patient/support-resources.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.0");

            goToUrl(driver, "/patient/support-resources/4HER-patient-support-app.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.1");

            goToUrl(driver, "/patient/support-resources/herconnection-support-program.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.3");

            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.className("submit")).click();

            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.3-submit");

            goToUrl(driver, "/patient/support-resources/breast-cancer-support-groups.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.4");

            goToUrl(driver, "/patient/support-resources/downloads.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.5");

            goToUrl(driver, "/patient/safety.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-safety");

            goToUrl(driver, "/patient/site-map.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-sitemap");

            goToUrl(driver, "/patient/glossary.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-glossary");

            goToUrl(driver, "/patient/about-kadcyla/dosing-and-administration.html");
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-2.1");

            goToUrl(driver, "/patient/support-resources/financial-resources.html");
            Thread.sleep(1500);
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
            getScreenshotForAccordion(driver, "kadcyla-mobile-3.2", savePath, false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
