package com.gene.screenshots.selenium.perjeta.main;

import com.gene.screenshots.selenium.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.LinkedList;
import java.util.List;

public class PerjetaMain extends SeleniumHeadless {

    private List<Thread> createThreads(String savePath, boolean isDesktop){
        List<Thread> thread = new LinkedList<>();
        thread.add(new Thread( ()-> {
            WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                getScreenshots(driver, js, savePath, isDesktop);
            } finally {
                ChromeDriverManager.releaseDriver(driver, isDesktop);
            }
        }));
        return thread;
    }

    @Override
    public List<Thread> desktopAutomationTest(String savePath) {
        return createThreads(savePath, true);
    }

    @Override
    public List<Thread> mobileAutomationTest(String savePath) {
        return createThreads(savePath, false);
    }

    private void getScreenshots(WebDriver driver, JavascriptExecutor js, String savePath, boolean isDesktop) {
        goToUrl(driver, "/patient.html");
        visible(driver, isDesktop, savePath, "patient-home");

        if (!isDesktop) {
            showMobileNavigation(driver);
            visible(driver, false, savePath, "patient-navigation");
        }

        goToUrl(driver, "/patient.html");
        showThirdPartyModal(driver, js);
        visible(driver, isDesktop, savePath, "patient-thirdpartysite");

        goToUrl(driver, "/patient.html");
        full(driver, isDesktop, savePath, "patient-0.0");

        goToUrl(driver, "/hcp.html");
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
        closeInterstitialModal(driver);
        full(driver, isDesktop, savePath, "hcp-1.0");

        getScreenshotForTabs(driver, "hcp", savePath, isDesktop);
    }

    private void closeInterstitialModal(WebDriver driver) {
        driver.findElement(By.cssSelector(".gene-component--modal--hcp-landing .gene-component--modal__button--confirm")).click();
        waitForElementNotVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--interstitial")));
        try {
            Thread.sleep(400); // jQuery fadeIn slowly fades the modal out
        } catch (InterruptedException e) {
            // failed to sleep
            e.printStackTrace();
        } 
    }

    // can't use the getScreenshotForMobileNavigation() method because we hid the "HOME" on the navigation
    private void showMobileNavigation(WebDriver driver) {
        driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--header__navigation")));
        try {
            Thread.sleep(400); // jQuery fadeIn takes 400 ms
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        } 
    }

    private void showThirdPartyModal(WebDriver driver, JavascriptExecutor js) {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // failed to sleep
            e.printStackTrace();
        }
        WebElement thirdPartyLinks = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
        forceClick(driver, thirdPartyLinks); // actions.moveToElement().click().build().perform() seems to fail on clicking
        js.executeScript("window.scrollTo(0, 0)");
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--third-party")));
        try {
            Thread.sleep(400); // jQuery fadeIn slowly lows the modal in 
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        } 
    }
}
