package com.gene.screenshots.selenium.kadcyla.hcp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
        WebDriver driver = makeDesktopDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);

            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                Thread.sleep(1000);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, true, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForDesktopNavigation(driver, action, Integer.toString(i), savePath);
                    driver.navigate().refresh();
                    getScreenshotForShareModal(driver, Integer.toString(i), savePath);
                    driver.navigate().refresh();
                    getScreenshotForThirdPartyModal(driver, Integer.toString(i), savePath, true);
                    driver.navigate().refresh();
                    getScreenshotForHCPModal(driver, Integer.toString(i), savePath, true);
                    driver.navigate().refresh();
                }
                full(driver, true, savePath, Integer.toString(i));
                getScreenshotForPAT(driver, savePath, action, true);
                getScreenshotForAccordion(driver, Integer.toString(i), savePath, true);
                getScreenshotForContactForm(driver, savePath, true);
                getScreenshotForRegisterForm(driver, savePath, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
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

        WebDriver driver = makeMobileDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);

            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                Thread.sleep(1000);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, false, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForMobileNavigation(driver, Integer.toString(i), savePath);
                    getScreenshotForHCPModal(driver, Integer.toString(i), savePath, false);
                    driver.navigate().refresh();
                    getScreenshotForThirdPartyModal(driver, Integer.toString(i), savePath, false);
                    driver.navigate().refresh();
                }
                full(driver, false, savePath, Integer.toString(i));
                getScreenshotForPAT(driver, savePath, action,false);
                getScreenshotForAccordion(driver, Integer.toString(i), savePath, false);
                getScreenshotForContactForm(driver, savePath, false);
                getScreenshotForRegisterForm(driver, savePath, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
