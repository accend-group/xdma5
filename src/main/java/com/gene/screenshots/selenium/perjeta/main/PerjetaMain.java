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
            getScreenshots(driver, js, savePath, true);
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
            getScreenshots(driver, js, savePath, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }

    private void getScreenshots(WebDriver driver, JavascriptExecutor js, String savePath, boolean isDesktop) throws InterruptedException {
        goToUrl(driver, "/patient.html");
        waitForPageLoad(driver);
        visible(driver, isDesktop, savePath, "patient-home");

        if (!isDesktop) {
            showMobileNavigation(driver);
            visible(driver, false, savePath, "patient-navigation");
        }

        goToUrl(driver, "/patient.html");
        showThirdPartyModal(driver, js);
        visible(driver, isDesktop, savePath, "patient-thirdpartysite");

        goToUrl(driver, "/patient.html");
        waitForPageLoad(driver);
        full(driver, isDesktop, savePath, "patient-0.0");

        goToUrl(driver, "/hcp.html");
        waitForPageLoad(driver);
        visible(driver, isDesktop, savePath, "hcp-modal");

        closeInterstitialModal(driver);
        visible(driver, isDesktop, savePath, "hcp-home");

        if (!isDesktop) {
            showMobileNavigation(driver);
            visible(driver, false, savePath, "hcp-navigation");
        }

        showThirdPartyModal(driver, js);
        visible(driver, isDesktop, savePath, "hcp-thirdpartysite");

        goToUrl(driver, "/hcp.html");
        waitForPageLoad(driver);
        closeInterstitialModal(driver);
        full(driver, isDesktop, savePath, "hcp-1.0");

        getScreenshotForAccordion(driver, "hcp", savePath, isDesktop);
    }

    private void closeInterstitialModal(WebDriver driver) throws InterruptedException {
        driver.findElement(By.cssSelector(".gene-component--modal--hcp-landing .gene-component--modal__button--confirm")).click();
        waitForElementNotVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--interstitial")));
        Thread.sleep(400); // jQuery fadeIn slowly fades the modal out
    }

    // can't use the getScreenshotForMobileNavigation() method because we hid the "HOME" on the navigation
    private void showMobileNavigation(WebDriver driver) throws InterruptedException {
        driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--header__navigation")));
        Thread.sleep(400); // jQuery fadeIn takes 400 ms
    }

    private void showThirdPartyModal(WebDriver driver, JavascriptExecutor js) throws InterruptedException {
        waitForPageLoad(driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(500);
        WebElement thirdPartyLinks = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
        forceClick(driver, thirdPartyLinks); // actions.moveToElement().click().build().perform() seems to fail on clicking
        js.executeScript("window.scrollTo(0, 0)");
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--third-party")));
        Thread.sleep(400); // jQuery fadeIn slowly lows the modal in 
    }
}
