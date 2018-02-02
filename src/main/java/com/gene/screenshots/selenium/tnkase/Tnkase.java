package com.gene.screenshots.selenium.tnkase;

import java.util.List;

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
        links.remove("https://www.gene.com/contact-us");
        links.remove("https://www.tnkase.com/unsubscribe");
        return links;
    }

    @Override
    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
	
        try {
            List<String> links = getLinksFromSiteMap(driver);
            Actions actions = new Actions(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                goToUrl(driver, links.get(i));
                if (driver.getCurrentUrl().endsWith("/") || driver.getCurrentUrl().endsWith("/index.jsp")) {
                    visible(driver, true, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForDesktopNavigation(driver, actions, savePath);
                }
                full(driver, true, savePath, Integer.toString(i));
                getScreenshotForSchemaForm(driver, savePath, true);
            }
        } finally {
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void getScreenshotForDesktopNavigation(WebDriver driver, Actions actions, String savePath) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".navigationText[onmouseover]"));
        for (int i = 0; i < elements.size(); i++) {
            actions.moveToElement(elements.get(i), 5, 5).perform();
            visible(driver, true, savePath, "hover" + Integer.toString(i + 1));
        }
    }

    @Override
    protected void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) {
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
            full(driver, isDesktop, savePath, "tnkase-dosing-card-submit");
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        // do nothing
    }
}
