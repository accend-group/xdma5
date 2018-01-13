package com.gene.screenshots.selenium.kadcyla.hcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class KadcylaHCP extends SeleniumHeadless {

    @Override
    public String getSiteMapUrl() {
        return "/hcp/sitemap.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".gene-component--sitemap__item--hcp .gene-component--sitemap__link";
    }

    @Override
    public void desktopAutomationTest(String savePath) {
        super.desktopAutomationTest(savePath);
    }

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) {
        getScreenshotForContactForm(driver, savePath, isDesktop);
        getScreenshotForRegisterForm(driver, savePath, isDesktop);
    }

    private void getScreenshotForContactForm(WebDriver driver, String savePath, boolean isDesktop) {
        if (driver.findElements(By.cssSelector(".hcp-contact-riker-form")).size() > 0) {
            WebElement providerType = driver.findElement(By.cssSelector(".provider-type"));
            providerType.findElement(By.cssSelector(".gene-component--dropdown__select")).click();
            WebElement providerMenu = providerType.findElement(By.cssSelector(".gene-component--dropdown__menu"));
            waitForElementVisible(driver, providerMenu);
            full(driver, isDesktop, savePath, "kadcyla-hcp-contact-rep-provider-type");
            providerType.click();
            waitForElementNotVisible(driver, providerMenu);
            WebElement specialty = driver.findElement(By.cssSelector(".specialty"));
            specialty.findElement(By.cssSelector(".gene-component--dropdown__select")).click();
            waitForElementVisible(driver, specialty.findElement(By.cssSelector(".gene-component--dropdown__menu")));
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

    private void getScreenshotForRegisterForm(WebDriver driver, String savePath, boolean isDesktop) {
        if (driver.findElements(By.cssSelector(".hcp-reg-riker-form")).size() > 0) {
            WebElement providerType = driver.findElement(By.cssSelector(".provider-type"));
            providerType.findElement(By.cssSelector(".gene-component--dropdown__select")).click();
            WebElement providerMenu = providerType.findElement(By.cssSelector(".gene-component--dropdown__menu"));
            waitForElementVisible(driver, providerMenu);
            full(driver, isDesktop, savePath, "kadcyla-hcp-register-classification");
            providerType.click();
            waitForElementNotVisible(driver, providerMenu);
            WebElement specialty = driver.findElement(By.cssSelector(".specialty"));
            specialty.findElement(By.cssSelector(".gene-component--dropdown__select")).click();
            WebElement specialtyMenu = specialty.findElement(By.cssSelector(".gene-component--dropdown__menu"));
            waitForElementVisible(driver, specialtyMenu);
            full(driver, isDesktop, savePath, "kadcyla-hcp-register-specialty");

            //register
            driver.findElement(By.cssSelector(".prefix .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".prefix .gene-component--dropdown__menu li[data-value='MR']")).click();
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__select")).click();
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__menu li[data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            providerType.click();
            waitForElementVisible(driver, providerMenu);
            providerMenu.findElement(By.cssSelector("li[data-value='CC']")).click();
            specialty.click();
            waitForElementVisible(driver, specialtyMenu);
            specialty.findElement(By.cssSelector(".gene-component--dropdown__menu li[data-value='HO']")).click();
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.cssSelector(".hcp-reg-riker-form .submit")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-template__container--form-thanks")));
            full(driver, isDesktop, savePath, "kadcyla-hcp-register-signup");
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        super.mobileAutomationTest(savePath);
    }
}
