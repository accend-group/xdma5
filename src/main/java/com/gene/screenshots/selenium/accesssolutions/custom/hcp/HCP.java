package com.gene.screenshots.selenium.accesssolutions.custom.hcp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gene.screenshots.selenium.ChromeDriverManager;
import com.gene.screenshots.selenium.accesssolutions.AccessSolutionsBase;

public class HCP extends AccessSolutionsBase{
	 @Override
	    public List<String> getLinksFromSiteMap(WebDriver driver) {
	        List<String> links = new ArrayList<String>();
	        links.add("/hcp.html");
	        links.add("/hcp/learn-about-our-services.html");
	        links.add("/hcp/biooncology.html");
	        links.add("/hcp/rheumatology.html");
	        return links;
	 }
	 
	 private void visibleScreensOfModals(WebDriver driver, boolean ifDesktop, int pageCount) {
        if (!driver.getCurrentUrl().contains("/hcp.html"))
            return;

        driver.findElement(By.id("select-treatment")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector("#select-treatment + .dropdown-menu")));

        // drop down menu
        visible(driver, ifDesktop, pageCount);

        List<WebElement> selectModal = driver.findElements(By.cssSelector(".sticky-footer .product-popup"));
        for (WebElement modalLink : selectModal)
            if (modalLink.isDisplayed()) {
                modalLink.click();
                break;
            }
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".product-selector")));
        // wait for fade in animation to complete
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // brand selection modal
        visible(driver, ifDesktop, pageCount);

        List<WebElement> rituxanLinks = driver.findElements(By.cssSelector("[href*='rituxan.html']"));
        for (WebElement rituxanLink : rituxanLinks) {
            if (rituxanLink.isDisplayed()) {
                rituxanLink.click();
                break;
            }
        }
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".sub-indication-selector.modal")));
        // wait for fade in animation to complete
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // rituxan modal selection
        visible(driver, ifDesktop, pageCount);

        driver.navigate().refresh();
        waitForPageLoad(driver);

        // only get the hcp modal for patient.html
        if(!ifDesktop) {
            driver.findElement(By.cssSelector(".navbar-toggle")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector(".dynamicnav.header")));
        }
        getScreenshotForHCPModal(driver, ifDesktop, 0);

    }


    // small number of pages and events per page so using single thread
    @Override
    public List<Thread> createScreenCaptureThreads(boolean isDesktop){
        List<Thread> threads = new LinkedList<>();
        threads.add(new Thread(() -> {
            WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
            try {
                List<String> links = getLinksFromSiteMap(driver);
                setNumberOfPageVisits(1, isDesktop);
                for (String currentPage : links) {
                    goToUrl(driver, currentPage);
                    full(driver, isDesktop, 0);
                    visibleScreensOfModals(driver, isDesktop, 0);
                }
            } catch (Exception e) {
                System.out.println("Issue at " + driver.getCurrentUrl() + " for " + (isDesktop ? "desktop" : "mobile"));
                e.printStackTrace();
            }
            ChromeDriverManager.releaseDriver(driver, isDesktop);
        }));
        return threads;
    }
}
