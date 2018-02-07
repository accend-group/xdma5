package com.gene.screenshots.selenium.accesssolutions.custom;

import com.gene.screenshots.selenium.ChromeDriverManager;
import com.gene.screenshots.selenium.accesssolutions.AccessSolutionsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Patient extends AccessSolutionsBase {

    @Override
    public String getSiteMapUrl() {
        return null;
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        links.add("/patient.html");
        // the pages are gone
        //links.add("/patient/home.html");
        //links.add("/patient/home/patient-assistance-tool-page.html");
        links.add("/patient/search.html");
        links.add("/patient/pan.html");
        links.add("/patient/biooncology.html");
        links.add("/patient/rheumatology.html");
        links.add("/patient/contact-us.html");
        return links;
    }

    private void visibleScreensOfModals(WebDriver driver, boolean ifDesktop, int pageCount) {
        if (!driver.getCurrentUrl().contains("/patient.html"))
            return;

        driver.findElement(By.id("select-treatment")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector("#select-treatment + .dropdown-menu")));

        // drop down menu
        visible(driver, ifDesktop, pageCount);

        //setStyle(driver, "display: block;", "#product-selector");
        List<WebElement> selectModal = driver.findElements(By.cssSelector(".product-popup"));
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
