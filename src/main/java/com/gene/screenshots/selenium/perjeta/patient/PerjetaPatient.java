
package com.gene.screenshots.selenium.perjeta.patient;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class PerjetaPatient extends SeleniumHeadless {

    @Override
    public String getSiteMapUrl() {
        return "/patient/site-map.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".gene-component--sitemap__item--patient .gene-component--sitemap__list";
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
        if (driver.findElements(By.cssSelector(".patient-reg-riker-form")).size() > 0) {
            driver.findElement(By.cssSelector(".perjeta-personal-description input[value='early no surgery']")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "patient-4.3-earlystage");

            driver.findElement(By.cssSelector(".perjeta-personal-description input[value='metastatic']")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "patient-4.3-metastatic");

            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__select")).click();
            Thread.sleep(1000);
            driver.findElement(By.cssSelector(".state .gene-component--dropdown__menu li[data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.cssSelector(".submit")).click();
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "patient-4.3-submit");
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
            full(driver, isDesktop, savePath, "patient-4.2-part2");

            if (isDesktop) {
                scrollToPATFootnote(driver, action);
                Thread.sleep(1000);
                full(driver, isDesktop, savePath, "patient-4.2-pat1-part2");
            }

            restartPAT(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            clickNoPATButton(driver);
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "patient-4.2-pat2-part1");

            if (isDesktop) {
                scrollToPATFootnote(driver, action);
                Thread.sleep(1000);
                full(driver, isDesktop, savePath, "patient-4.2-pat2-part2");
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
            full(driver, isDesktop, savePath, "patient-4.2-pat3-part1");

            if (isDesktop) {
                scrollToPATFootnote(driver, action);
                Thread.sleep(1000);
                full(driver, isDesktop, savePath, "patient-4.2-pat3-part2");
            }

            restartPAT(driver);
            Thread.sleep(1000);
            clickYesPATButton(driver);
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "patient-4.2-pat-q1", driver.findElement(By.cssSelector(".assistance-tool .active:not(.disabled) .more-info")), new Long(1000));
            clickYesPATButton(driver);
            Thread.sleep(1000);
            full(driver, isDesktop, savePath, "patient-4.2-pat-q2", driver.findElement(By.cssSelector(".assistance-tool .active:not(.disabled) .more-info")), new Long(1000));
            driver.navigate().refresh();
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
