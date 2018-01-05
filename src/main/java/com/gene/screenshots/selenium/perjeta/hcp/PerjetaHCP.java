package com.gene.screenshots.selenium.perjeta.hcp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();

        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);

            // --->start full page screenshot <---//
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

    private void scrollToPATFootnote(WebDriver driver,
                                     Actions action) {
        action.moveToElement(driver.findElement(By.cssSelector(".result[style='display: block;'] p:last-child"))).build().perform();
    }

    private void getScreenshotForPAT(WebDriver driver,
                                     String savePath,
                                     Actions action,
                                     boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".gene-component--pat")).size() > 0) {
            clickNoPATButton(driver);
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-6.1-pat1-part1");

            if (isDesktop) {
                scrollToPATFootnote(driver, action);
                Thread.sleep(1000);
                full(driver, isDesktop, savePath, "hcp-6.1-pat1-part2");
            }

            restartPAT(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            clickNoPATButton(driver);
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-6.1-pat2-part1");

            if (isDesktop) {
                scrollToPATFootnote(driver, action);
                Thread.sleep(1000);
                full(driver, isDesktop, savePath, "hcp-6.1-pat2-part2");
            }

            restartPAT(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            clickNoPATButton(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);

            full(driver, isDesktop, savePath, "hcp-6.1-pat3-part1");

            if (isDesktop) {
                scrollToPATFootnote(driver, action);
                Thread.sleep(1000);
                full(driver, isDesktop, savePath, "hcp-6.1-pat3-part2");
            }

            restartPAT(driver);
            Thread.sleep(1000);
            clickNoPATButton(driver);
            Thread.sleep(1000);
            updatePATResponse(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "hcp-6.1-q1", driver.findElement(By.cssSelector(".more-info")),
                    new Long(1000));

            restartPAT(driver);
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);

            // --->start full page screenshot <---//
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
                getScreenshotForPAT(driver, savePath, action, false);
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
