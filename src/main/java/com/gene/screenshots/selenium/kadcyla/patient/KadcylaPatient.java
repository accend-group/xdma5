package com.gene.screenshots.selenium.kadcyla.patient;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
        WebDriver driver = makeDesktopDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                Thread.sleep(1500);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, true, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForDesktopNavigation(driver, action, Integer.toString(i), savePath);
                    driver.navigate().refresh();
                    getScreenshotForShareModal(driver, Integer.toString(i), savePath);
                    driver.navigate().refresh();
                    getScreenshotForThirdPartyModal(driver, Integer.toString(i), savePath, true);
                    driver.navigate().refresh();
                }
                full(driver, true, savePath, Integer.toString(i));
                getScreenshotForPAT(driver, savePath, true);
                getScreenshotForAccordion(driver, Integer.toString(i), savePath, true);
                getScreenshotForSchemaForm(driver, savePath, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }

    private void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) throws InterruptedException {
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

    private void getScreenshotForPAT(WebDriver driver, String savePath, boolean isDesktop) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".gene-component--pat")).size() > 0) {
            clickYesPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat1-yes");

            clickYesPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat2-yes");

            clickNoPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat3-no");

            clickYesPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat4-yes");

            restartPAT(driver);

            clickNoPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat1-no");

            restartPAT(driver);

            clickYesPATButton(driver);
            Thread.sleep(500);
            clickNoPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat2-no");

            restartPAT(driver);

            clickYesPATButton(driver);
            Thread.sleep(500);
            clickYesPATButton(driver);
            Thread.sleep(500);
            clickYesPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat3-yes");

            restartPAT(driver);

            clickYesPATButton(driver);
            Thread.sleep(500);
            clickYesPATButton(driver);
            Thread.sleep(500);
            clickNoPATButton(driver);
            Thread.sleep(500);
            clickNoPATButton(driver);
            Thread.sleep(1500);
            full(driver, isDesktop, savePath, "kadcyla-3.2-pat4-no");
            driver.navigate().refresh();
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {
            List<String> links = getLinksFromSiteMap(driver);

            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                Thread.sleep(1500);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, false, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForMobileNavigation(driver, Integer.toString(i), savePath);
                    driver.navigate().refresh();
                    getScreenshotForThirdPartyModal(driver, Integer.toString(i), savePath, false);
                    driver.navigate().refresh();
                }
                full(driver, false, savePath, Integer.toString(i));
                getScreenshotForPAT(driver, savePath, false);
                getScreenshotForAccordion(driver, Integer.toString(i), savePath, false);
                getScreenshotForSchemaForm(driver, savePath, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
