package com.gene.screenshots.selenium.perjeta.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class PerjetaMain extends SeleniumHeadless {
    @Override
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {

            goToUrl(driver, "/patient.html");
            visible(driver, true, savePath, "patient-home");

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebElement thirdPartyLinks = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
            forceClick(driver, thirdPartyLinks);
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, true, savePath, "patient-thirdpartysite");

            goToUrl(driver, "/patient.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "patient-0.0");

            goToUrl(driver, "/hcp.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "hcp-modal");

            driver.findElement(By.cssSelector(".gene-component--modal--hcp-landing .gene-component--modal__button--confirm")).click();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(500);
            thirdPartyLinks = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
            forceClick(driver, thirdPartyLinks);
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, true, savePath, "hcp-thirdpartysite");

            goToUrl(driver, "/hcp.html");
            driver.findElement(By.cssSelector(".gene-component--modal--hcp-landing .gene-component--modal__button--confirm")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "hcp-home");

            Thread.sleep(1000);
            full(driver, true, savePath, "hcp-1.0");

            getScreenshotForAccordion(driver, "hcp", savePath, true);
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
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            goToUrl(driver, "/patient.html");
            Thread.sleep(1000);
            visible(driver, false, savePath, "patient-home");

            // can't use the getScreenshotForMobileNavigation() method because we hid the "HOME" on the navigation
            driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "patient-navigation");

            goToUrl(driver, "/patient.html");
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(500);
            WebElement thirdPartyLinks = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
            forceClick(driver, thirdPartyLinks);
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, false, savePath, "patient-thirdpartysite");

            goToUrl(driver, "/patient.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "patient-0.0");

            goToUrl(driver, "/hcp.html");
            Thread.sleep(1000);
            visible(driver, false, savePath, "hcp-modal");

            driver.findElement(By.cssSelector(".gene-component--modal--hcp-landing .gene-component--modal__button--confirm")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "hcp-home");

            // can't use the getScreenshotForMobileNavigation() method because we hid the "HOME" on the navigation
            driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "hcp-navigation");

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(500);
            thirdPartyLinks = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
            forceClick(driver, thirdPartyLinks);
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, false, savePath, "hcp-thirdpartysite");

            goToUrl(driver, "/hcp.html");
            driver.findElement(By.cssSelector(".gene-component--modal--hcp-landing .gene-component--modal__button--confirm")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "hcp-1.0");

            getScreenshotForAccordion(driver, "hcp", savePath, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
