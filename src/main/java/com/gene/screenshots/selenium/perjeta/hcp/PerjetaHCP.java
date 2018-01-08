package com.gene.screenshots.selenium.perjeta.hcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.List;

public class PerjetaHCP extends SeleniumHeadless {

    @Override
    public String getSiteMapUrl() {
        return "/hcp/site-map.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".gene-component--sitemap__item--hcp .gene-component--sitemap__list";
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) throws InterruptedException {
        List<String> links = super.getLinksFromSiteMap(driver);
        // because sitemap doesn't have everything
        links.add(getDomain().toString() + "/hcp/breast-cancer/isi.html");
        links.add(getDomain().toString() + "/hcp/site-map.html");
        return links;
    }

    @Override
    public void desktopAutomationTest(String savePath) {
        super.desktopAutomationTest(savePath);
    }

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) throws InterruptedException {
        getScreenshotForContactForm(driver, savePath, isDesktop);
        getScreenshotForRegisterForm(driver, savePath, isDesktop);
    }

    private void getScreenshotForRegisterForm(WebDriver driver,
                                              String savePath,
                                              boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".hcp-reg-riker-form")).size() > 0) {
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-register-classification");
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".specialty .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-register-specialty");

            // register
            driver.findElement(By.cssSelector(".prefix .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".prefix .gene-component--dropdown__menu li")).click();
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__menu li")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown__menu li")).click();
            driver.findElement(By.cssSelector(".specialty .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".specialty .gene-component--dropdown__menu li")).click();
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            Thread.sleep(1000);
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.className("submit")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-register-submit");
        }
    }

    private void getScreenshotForContactForm(WebDriver driver,
                                             String savePath,
                                             boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".hcp-contact-riker-form")).size() > 0) {
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-contact-rep-provider-type");
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".specialty .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-contact-rep-specialty");
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        super.mobileAutomationTest(savePath);
    }
}
