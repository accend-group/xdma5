package com.gene.screenshots.selenium.tnkase;

import java.util.LinkedList;
import java.util.List;

import com.gene.screenshots.selenium.ChromeDriverManager;
import groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class Tnkase extends SeleniumHeadless {
    @Override
    public String getSiteMapUrl() {
        return "/sitemap";
    }

    @Override
    public String getSiteMapSelector() {
        return "a.siteMapLinksBold, a.siteMapLinks";
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = super.getLinksFromSiteMap(driver);
        // because sitemap doesn't have everything
        links.add(getSiteMapUrl());
        links.add("/tnkase-search-results");
        links.remove("/unsubscribe");
        return links;
    }

    @Override
    public List<Thread> desktopAutomationTest() {

        List<Thread> desktopThreads = new LinkedList<Thread>();
        WebDriver driver = ChromeDriverManager.requestDriver(true);

        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), true);

        ChromeDriverManager.releaseDriver(driver, true);

        int pageNumber = 0;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            desktopThreads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestDesktopDriver();
                try {
                    Actions actions = new Actions(threadDriver);
                    goToUrl(threadDriver, link);
                    if (threadDriver.getCurrentUrl().endsWith("/") || threadDriver.getCurrentUrl().endsWith("/index.jsp")) {
                        visible(threadDriver, true, currentPageNumber);
                        getScreenshotForDesktopNavigation(threadDriver, actions, currentPageNumber);
                    }
                    full(threadDriver, true, currentPageNumber);
                    getScreenshotForSchemaForm(threadDriver, true, currentPageNumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDesktopDriver(threadDriver);
            }));
        }
        return desktopThreads;
    }

    @Override
    public void getScreenshotForDesktopNavigation(WebDriver driver, Actions actions, int pageIndex) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".navigationText[onmouseover]"));
        for (int i = 0; i < elements.size(); i++) {
            actions.moveToElement(elements.get(i), 5, 5).perform();
            visible(driver, true, pageIndex);
        }
    }

    @Override
    protected void getScreenshotForSchemaForm(WebDriver driver, boolean isDesktop, int pageIndex) {
        if (driver.getCurrentUrl().endsWith("/tnkase-dosing-card")) {
            driver.findElement(By.name("firstname")).sendKeys("TestFirstName");
            driver.findElement(By.name("lastname")).sendKeys("TestLastName");
            driver.findElement(By.name("profession")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector("[name='profession'] option")));
            driver.findElement(By.cssSelector("[name='profession'] option:nth-child(2)")).click();
            driver.findElement(By.name("specialty")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector("[name='specialty'] option")));
            driver.findElement(By.cssSelector("[name='specialty'] option:nth-child(2)")).click();
            driver.findElement(By.name("institution")).sendKeys("Test Institution");
            driver.findElement(By.name("address")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.name("state")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector("[name='state'] option")));
            driver.findElement(By.cssSelector("[name='state'] option:nth-child(2)")).click();
            driver.findElement(By.name("zip")).sendKeys("99999");
            driver.findElement(By.name("area")).sendKeys("800");;
            driver.findElement(By.name("exch")).sendKeys("999");
            driver.findElement(By.name("phone")).sendKeys("9999");
            driver.findElement(By.name("email")).sendKeys("test@genentech.com");
            driver.findElement(By.name("quantity")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector("[name='quantity'] option")));
            driver.findElement(By.cssSelector("[name='quantity'] option:nth-child(2)")).click();
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            waitForPageLoad(driver); // it does a HTML post, so the page will actually reload
            full(driver, isDesktop, pageIndex);
        }
    }

    @Override
    public List<Thread> mobileAutomationTest() {
        // do nothing
        return null;
    }

}
