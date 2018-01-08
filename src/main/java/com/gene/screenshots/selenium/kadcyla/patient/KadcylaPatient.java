package com.gene.screenshots.selenium.kadcyla.patient;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class KadcylaPatient extends SeleniumHeadless {

    @Override
    public String getSiteMapUrl() {
        return "/patient/site-map.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".gene-component--sitemap__item--patient";
    }

    @Override
    public void desktopAutomationTest(String savePath) {
        super.desktopAutomationTest(savePath);
    }

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".gene-template__main .riker")).size() > 0) {
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("primary-phone-number")).sendKeys("999999999");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.className("submit")).click();

            Thread.sleep(1500);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.3-submit");
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        super.mobileAutomationTest(savePath);
    }
}
