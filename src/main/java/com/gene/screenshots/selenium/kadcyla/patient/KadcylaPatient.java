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
        return ".gene-component--sitemap__item--patient .gene-component--sitemap__link";
    }



    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, boolean isDesktop, int pageIndex) {
        if (driver.findElements(By.cssSelector(".gene-template__main .riker")).size() > 0) {
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__menu li[data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.cssSelector(".riker .submit")).click();

            waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-template__container--form-thanks")));
            full(driver, isDesktop, pageIndex);
        }
    }


}
