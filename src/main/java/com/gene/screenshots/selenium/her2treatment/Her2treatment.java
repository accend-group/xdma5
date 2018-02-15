package com.gene.screenshots.selenium.her2treatment;

import java.util.LinkedList;
import java.util.List;

import com.gene.screenshots.selenium.ChromeDriverManager;
import groovy.json.internal.Chr;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.chrome.ChromeDriver;

public class Her2treatment extends SeleniumHeadless{
    @Override
    public String getSiteMapUrl() {
        return "/user-sitemap.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".sitemap .richtext a";
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = super.getLinksFromSiteMap(driver);
        // because sitemap doesn't have everything
        links.add("/safety.html");
        links.add("/her2-positive-breast-cancer-treatments/herceptin/safety.html");
        links.add("/her2-positive-breast-cancer-treatments/perjeta/safety.html");
        links.add("/her2-positive-breast-cancer-treatments/kadcyla/safety.html");
        links.add("/breast-cancer-nurse-resources/safety.html");
        links.add(getSiteMapUrl());
        links.add("/errorpage.html");
        return links;
    }


    @Override
    public List<Thread> desktopAutomationTest() {

        List<Thread> desktopTheads = new LinkedList<>();

        WebDriver driver = ChromeDriverManager.requestDesktopDriver();

        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), true);

        ChromeDriverManager.releaseDesktopDriver(driver);

        int pageNumber = 0;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            desktopTheads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestDesktopDriver();
                try {
                    goToUrl(threadDriver, link);
                    if (threadDriver.findElement(By.tagName("body")).getAttribute("class").contains("home")) {
                        getScreenshotForSafetyTabs(threadDriver, true, currentPageNumber);
                        getScreenshotForThirdPartyModal(threadDriver, true, currentPageNumber);
                        getScreenshotForHCPModal(threadDriver, true, currentPageNumber);
                        getScreenshotForShareModal(threadDriver, currentPageNumber);
                    } else {
                        if (threadDriver.findElements(By.cssSelector(".brand-page")).size() > 0 && !threadDriver.getCurrentUrl().endsWith("safety.html")) {
                            visible(threadDriver, true, currentPageNumber);
                        }
                        full(threadDriver, true, currentPageNumber);
                        getScreenshotForDownloadsFilter(threadDriver, true, currentPageNumber);
                        getScreenshotForSchemaForm(threadDriver, true, currentPageNumber);
                    }
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for desktop");
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDesktopDriver(threadDriver);
            }));
        }
        return desktopTheads;
    }

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        if (driver.findElements(By.cssSelector("#riker-form")).size() > 0) {
            driver.findElement(By.cssSelector("#riker-form .submit")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector("#riker-form .message")));
            full(driver, isDesktop, currentPageIndex);
        }
    }

    private void getScreenshotForDownloadsFilter(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        if (driver.findElements(By.cssSelector(".forms-documents .dropdown")).size() > 0) {
            WebElement dropdownButton = driver.findElement(By.cssSelector(".forms-documents .dropdown button"));
            WebElement dropdownMenu = driver.findElement(By.cssSelector(".forms-documents .dropdown-menu"));
            int y = dropdownButton.getLocation().getY();
            List<WebElement> dropdownItems = driver.findElements(By.cssSelector(".forms-documents .forms-documents-indication"));
            for (int i = 0; i < dropdownItems.size(); i++) {
                WebElement indicationFilter = dropdownItems.get(i);
                scrollTo(driver, 0, y);
                dropdownButton.click();
                waitForElementVisible(driver, dropdownMenu);
                if (i == 0) {
                    full(driver, isDesktop, currentPageIndex);
                }
                indicationFilter.click();
                String filter = indicationFilter.getAttribute("data-indication");
                List<WebElement> indications = driver.findElements(By.cssSelector(".forms-documents-item[data-indication='" + filter +"']"));
                waitForElementVisible(driver, indications.get(0));
                full(driver, isDesktop, currentPageIndex);
                for (int j = 0; j < indications.size(); j++) {
                    List<WebElement> moreInfo = indications.get(j).findElements(By.cssSelector(".more-info"));
                    if (moreInfo.size() > 0) {
                        // resizing the screen seems to turn off the popover. so we have to do the click after the screen is resized
                        full(driver, isDesktop, currentPageIndex, moreInfo.get(0), ".popover", 400);
                    }
                }
            }
        }
    }

    private void getScreenshotForSafetyTabs(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        if (!isDesktop) {
            driver.findElement(By.cssSelector(".spotlight-link-active")).click(); // for mobile devices that has safety spotlights
        }

        List<WebElement> tabs = driver.findElements(By.cssSelector(".tabbed-chart .nav-tabs a"));
        for (int j = 0; j < tabs.size(); j++) {
            if (j != 0) {
                String tabsHref = StringUtils.substringAfterLast(tabs.get(j).getAttribute("href"), "/");
                tabs.get(j).click();
                waitForElementVisible(driver, driver.findElement(By.cssSelector(".tabbed-chart " + tabsHref)));
            }
            if (isDesktop) {
                visible(driver, isDesktop, currentPageIndex);
            }
            full(driver, isDesktop, currentPageIndex);
        }
        if(tabs.size() > 0)
            tabs.get(0).click();
    }

    @Override
    protected void getScreenshotForMobileNavigation(WebDriver driver, int currentPageIndex) {
        driver.findElement(By.cssSelector(".navbar-toggle")).click();
        waitForElementVisiblyLocated(driver, "div.navbar-collapse.in");
        visible(driver, false, currentPageIndex);
        driver.findElement(By.cssSelector(".navbar-toggle")).click();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Thread> mobileAutomationTest() {
        List<Thread> mobileTheads = new LinkedList<>();

        WebDriver driver = ChromeDriverManager.requestMobileDriver();
        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), false);
        ChromeDriverManager.releaseMobileDriver(driver);
        int pageNumber = 0;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            mobileTheads.add(new Thread( ()-> {
                WebDriver threadDriver = ChromeDriverManager.requestMobileDriver();
                try {
                    goToUrl(threadDriver, link);
                    if (threadDriver.findElement(By.tagName("body")).getAttribute("class").contains("home")) {
                        visible(threadDriver, false, currentPageNumber);
                        getScreenshotForMobileNavigation(threadDriver, currentPageNumber);
                        getScreenshotForHCPModal(threadDriver, false, currentPageNumber);
                        getScreenshotForThirdPartyModal(threadDriver, false, currentPageNumber);
                        getScreenshotForSafetyTabs(threadDriver, false, currentPageNumber);
                    } else {
                        if (threadDriver.findElements(By.cssSelector(".brand-page")).size() > 0) {
                            visible(threadDriver, false, currentPageNumber);
                        }
                        full(threadDriver, false, currentPageNumber);
                        getScreenshotForDownloadsFilter(threadDriver, false, currentPageNumber);
                        getScreenshotForSchemaForm(threadDriver, false, currentPageNumber);
                    }
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for mobile");
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseMobileDriver(threadDriver);

            }));
        }
        return mobileTheads;
    }
}
