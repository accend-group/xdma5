package com.gene.screenshots.selenium.kadcyla.hcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class KadcylaHCP extends SeleniumHeadless {

    @Override
    public String getSiteMapUrl() {
        return "/hcp/sitemap.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".gene-component--sitemap__item--hcp";
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

    private void getScreenshotForContactForm(WebDriver driver, String savePath, boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".hcp-contact-riker-form")).size() > 0) {
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "kadcyla-hcp-contact-rep-provider-type");
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".specialty .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "kadcyla-hcp-contact-rep-specialty");
            // driver.manage().window().maximize();

            // contact-reg - not available since there is captcha
            // driver.findElement(By.className("gene-component--dropdown")).click();
            // driver.findElement(By.xpath("//li[@data-value='REF']")).click();
            // driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
            // driver.findElement(By.xpath("//li[@data-value='HO']")).click();
            // driver.findElement(By.name("first-name")).sendKeys("Marwin");
            // driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            // driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            // driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            // driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            // driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
            // driver.findElement(By.name("practice-name")).sendKeys("Accend group");
        }
    }

    private void getScreenshotForRegisterForm(WebDriver driver, String savePath, boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".hcp-reg-riker-form")).size() > 0) {
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "kadcyla-hcp-register-classification");
            driver.findElement(By.cssSelector(".provider-type .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".specialty .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "kadcyla-hcp-register-specialty");

            //register
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='MR']")).click();
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.xpath("//form/div[4]/div[2]/div/div")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.xpath("//form/div[5]/div/div/div")).click();
            driver.findElement(By.xpath("//li[@data-value='CC']")).click();
            driver.findElement(By.xpath("//form/div[5]/div[2]/div/div")).click();
            driver.findElement(By.xpath("//li[@data-value='HO']")).click();
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.className("submit")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "kadcyla-hcp-register-signup");
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        super.mobileAutomationTest(savePath);
    }
}
