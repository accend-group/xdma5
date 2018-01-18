package com.gene.screenshots.selenium.her2treatment;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gene.screenshots.selenium.SeleniumHeadless;

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
        links.add(getDomain().toString() + "/safety.html");
        links.add(getDomain().toString() + "/her2-positive-breast-cancer-treatments/herceptin/safety.html");
        links.add(getDomain().toString() + "/her2-positive-breast-cancer-treatments/perjeta/safety.html");
        links.add(getDomain().toString() + "/her2-positive-breast-cancer-treatments/kadcyla/safety.html");
        links.add(getDomain().toString() + "/breast-cancer-nurse-resources/safety.html");
        links.add(getDomain().toString() + getSiteMapUrl());
        links.add(getDomain().toString() + "/errorpage.html");
        return links;
    }

    @Override
    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();

        try {
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                waitForPageLoad(driver);
                if (driver.findElement(By.tagName("body")).getAttribute("class").contains("home")) {
                    getScreenshotForSafetyTabs(driver, savePath, Integer.toString(i), true);
                    driver.navigate().refresh();
                    waitForPageLoad(driver);
                    getScreenshotForThirdPartyModal(driver, savePath, true);
                    getScreenshotForHCPModal(driver, savePath, true);
                    getScreenshotForShareModal(driver, savePath);
                } else {
                    if (driver.findElements(By.cssSelector(".brand-page")).size() > 0 && !driver.getCurrentUrl().endsWith("safety.html")) {
                        visible(driver, true, savePath, Integer.toString(i) + "-visible");
                    }
                    full(driver, true, savePath, Integer.toString(i));
                    getScreenshotForDownloadsFilter(driver, savePath, true);
                    getScreenshotForSchemaForm(driver, savePath, true);
                }
            }
        } finally {
            driver.close();
            driver.quit();
        }
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
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                waitForPageLoad(driver);
                if (driver.findElement(By.tagName("body")).getAttribute("class").contains("home")) {
                    visible(driver, false, savePath, Integer.toString(i));
                    getScreenshotForMobileNavigation(driver, savePath);
                    getScreenshotForHCPModal(driver, savePath, false);
                    getScreenshotForThirdPartyModal(driver, savePath, false);
                    getScreenshotForSafetyTabs(driver, savePath, Integer.toString(i), false);
                    driver.navigate().refresh();
                    waitForPageLoad(driver);
                } else {
                    if (driver.findElements(By.cssSelector(".brand-page")).size() > 0) {
                        visible(driver, false, savePath, Integer.toString(i) + "-visible");
                    }
                    full(driver, false, savePath, Integer.toString(i));
                    getScreenshotForDownloadsFilter(driver, savePath, false);
                    getScreenshotForSchemaForm(driver, savePath, false);
                }
            }
        } finally {
            driver.close();
            driver.quit();
        }
	}
}
