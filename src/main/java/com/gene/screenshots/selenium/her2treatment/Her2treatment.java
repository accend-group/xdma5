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
    public List<Thread> desktopAutomationTest(String savePath) {

        List<Thread> desktopTheads = new LinkedList<>();
        List<String> links = new LinkedList<>();

        WebDriver driver = ChromeDriverManager.requestDesktopDriver();
        try {
            links = getLinksFromSiteMap(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeDriverManager.releaseDesktopDriver(driver);

        int pageNumber = 1;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            desktopTheads.add(new Thread( ()-> {
                WebDriver threadDriver = ChromeDriverManager.requestDesktopDriver();
                try {
                    goToUrl(threadDriver, link);
                    if (threadDriver.findElement(By.tagName("body")).getAttribute("class").contains("home")) {
                        getScreenshotForSafetyTabs(threadDriver, savePath, Integer.toString(currentPageNumber), true);
                        threadDriver.navigate().refresh();
                        waitForPageLoad(threadDriver);
                        getScreenshotForThirdPartyModal(threadDriver, savePath, true);
                        getScreenshotForHCPModal(threadDriver, savePath, true);
                        getScreenshotForShareModal(threadDriver, savePath);
                    } else {
                        if (threadDriver.findElements(By.cssSelector(".brand-page")).size() > 0 && !threadDriver.getCurrentUrl().endsWith("safety.html")) {
                            visible(threadDriver, true, savePath, Integer.toString(currentPageNumber) + "-visible");
                        }
                        full(threadDriver, true, savePath, Integer.toString(currentPageNumber));
                        getScreenshotForDownloadsFilter(threadDriver, savePath, true);
                        getScreenshotForSchemaForm(threadDriver, savePath, true);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDesktopDriver(threadDriver);
            }));
        }
        return desktopTheads;
	}

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) {
        if (driver.findElements(By.cssSelector("#riker-form")).size() > 0) {
            driver.findElement(By.cssSelector("#riker-form .submit")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector("#riker-form .message")));
            full(driver, isDesktop, savePath, "her2treatment-genentech-nurse-educator-error-msg");
        }
    }

    private void getScreenshotForDownloadsFilter(WebDriver driver, String savePath, boolean isDesktop) {
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
                    full(driver, isDesktop, savePath, "her2treatment-3.0-dropdown");
                }
                indicationFilter.click();
                String filter = indicationFilter.getAttribute("data-indication");
                List<WebElement> indications = driver.findElements(By.cssSelector(".forms-documents-item[data-indication='" + filter +"']"));
                waitForElementVisible(driver, indications.get(0));
                full(driver, isDesktop, savePath, "her2treatment-3.0-dropdown-" + Integer.toString(i + 1));
                for (int j = 0; j < indications.size(); j++) {
                    List<WebElement> moreInfo = indications.get(j).findElements(By.cssSelector(".more-info"));
                    if (moreInfo.size() > 0) {
                        // resizing the screen seems to turn off the popover. so we have to do the click after the screen is resized
                        full(driver, isDesktop, savePath, "her2treatment-3.0-dropdown-" + Integer.toString(i + 1) +"-" + Integer.toString(j + 1), moreInfo.get(0), new Long(1000));
                    }
                }
            }
        }
    }

    private void getScreenshotForSafetyTabs(WebDriver driver, String savePath, String prefix, boolean isDesktop) {
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
                visible(driver, isDesktop, savePath, prefix + "-visible-" + Integer.toString(j));
            }
            int currentYPos = getCurrentScrollY(driver);
            scrollTo(driver, 0, currentYPos + 1); // scrolling or resizing the window will forcibly get the new document height.
            full(driver, isDesktop, savePath, prefix + "-full-" + Integer.toString(j));
            scrollTo(driver, 0, currentYPos);
        }
    }

    @Override
    protected void getScreenshotForMobileNavigation(WebDriver driver, String savePath) {
        driver.findElement(By.cssSelector(".navbar-toggle")).click();
        visible(driver, false, savePath, "mobile-navigation");
        driver.navigate().refresh();
        waitForPageLoad(driver);
    }

    @Override
    public List<Thread> mobileAutomationTest(String savePath) {
        List<Thread> mobileTheads = new LinkedList<>();
        List<String> links = new LinkedList<>();

        WebDriver driver = ChromeDriverManager.requestMobileDriver();
        try {
            links = getLinksFromSiteMap(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeDriverManager.releaseMobileDriver(driver);
        int pageNumber = 1;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            mobileTheads.add(new Thread( ()-> {
                WebDriver threadDriver = ChromeDriverManager.requestMobileDriver();
                try {
                    goToUrl(threadDriver, link);
                    if (threadDriver.findElement(By.tagName("body")).getAttribute("class").contains("home")) {
                        visible(threadDriver, false, savePath, Integer.toString(currentPageNumber));
                        getScreenshotForMobileNavigation(threadDriver, savePath);
                        getScreenshotForHCPModal(threadDriver, savePath, false);
                        getScreenshotForThirdPartyModal(threadDriver, savePath, false);
                        getScreenshotForSafetyTabs(threadDriver, savePath, Integer.toString(currentPageNumber), false);
                        threadDriver.navigate().refresh();
                        waitForPageLoad(threadDriver);
                    } else {
                        if (threadDriver.findElements(By.cssSelector(".brand-page")).size() > 0) {
                            visible(threadDriver, false, savePath, Integer.toString(currentPageNumber) + "-visible");
                        }
                        full(threadDriver, false, savePath, Integer.toString(currentPageNumber));
                        getScreenshotForDownloadsFilter(threadDriver, savePath, false);
                        getScreenshotForSchemaForm(threadDriver, savePath, false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseMobileDriver(threadDriver);

            }));
        }
        return mobileTheads;
    }
}
