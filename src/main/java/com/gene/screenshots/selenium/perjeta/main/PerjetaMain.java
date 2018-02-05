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

    private List<Thread> createThreads(boolean isDesktop){
        setNumberOfPageVisits(1, isDesktop); // single thread
        List<Thread> thread = new LinkedList<>();
        thread.add(new Thread( ()-> {
            WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                getScreenshots(driver, js, isDesktop, 0);
            } finally {
                ChromeDriverManager.releaseDriver(driver, isDesktop);
            }
        }));
        return thread;
    }

    @Override
    public List<Thread> desktopAutomationTest() {
        return createThreads(true);
    }

    @Override
    public List<Thread> mobileAutomationTest() {
        return createThreads(false);
    }

    private void getScreenshots(WebDriver driver, JavascriptExecutor js, boolean isDesktop, int pageIndex) {
        goToUrl(driver, "/patient.html");
        visible(driver, isDesktop, pageIndex);

        if (!isDesktop) {
            showMobileNavigation(driver);
            visible(driver, false, pageIndex);
        }

        goToUrl(driver, "/patient.html");
        showThirdPartyModal(driver, js);
        visible(driver, isDesktop, pageIndex);

        goToUrl(driver, "/patient.html");
        full(driver, isDesktop, pageIndex);

        goToUrl(driver, "/hcp.html");
        visible(driver, isDesktop, pageIndex);

        closeInterstitialModal(driver);
        visible(driver, isDesktop, pageIndex);

        if (!isDesktop) {
            showMobileNavigation(driver);
            visible(driver, false, pageIndex);
        }

        showThirdPartyModal(driver, js);
        visible(driver, isDesktop, pageIndex);

        goToUrl(driver, "/hcp.html");
        closeInterstitialModal(driver);
        full(driver, isDesktop, pageIndex);

        getScreenshotForTabs(driver, isDesktop, pageIndex);
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
