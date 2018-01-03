package com.gene.screenshots.selenium.kadcyla.patient;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.function.Consumer;

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
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions action = new Actions(driver);

            List<String> links = getLinksFromSiteMap(driver);

            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                Thread.sleep(1500);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, true, savePath, "kadcyla-patient");

                    getScreenshotForDesktopNavigation(driver, action, "kadcyla", savePath);

                    driver.navigate().refresh();
                    getScreenshotForThirdPartyModal(driver, "kadcyla", savePath, true);
                    driver.navigate().refresh();
                }
                full(driver, true, savePath, Integer.toString(i));
                getScreenshotForDesktopPAT(savePath, driver, jse);
                getScreenshotForAccordion(driver, "kadcyla-3.2", savePath, true);
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

    private void getScreenshotForDesktopPAT(String savePath,
                                     WebDriver driver,
                                     JavascriptExecutor jse) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".gene-component--pat")).size() > 0) {
            Consumer<WebDriver> movecursor = (d) -> {
                Actions actions = new Actions(d);
                WebElement mainMenu = d.findElement(By.name("q"));
                actions.moveToElement(mainMenu);
                actions.click().build().perform();
            };
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat3-no");

            jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat4-yes");

            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat1-no");

            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat2-no");

            driver.navigate().refresh();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat3-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));//.click();
            forceClick(driver, driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")));
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            //scrollTo(driver, 0,500);
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();

            Thread.sleep(1000);
            forceClick(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            movecursor.accept(driver);
            Thread.sleep(1500);
            full(driver, true, savePath, "kadcyla-3.2-pat4-no");
            driver.navigate().refresh();
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {

        WebDriver driver = makeMobileDriver();

        try {
            List<String> links = getLinksFromSiteMap(driver);

            //      //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                Thread.sleep(1500);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, false, savePath, "kadcyla-mobile-patient");
                    getScreenshotForMobileNavigation(driver, "kadcyla", savePath);
                    driver.navigate().refresh();
                    getScreenshotForThirdPartyModal(driver, "kadcyla-mobile", savePath, false);
                    driver.navigate().refresh();
                }
                full(driver, false, savePath, Integer.toString(i));
                getScreenshotForMobilePAT(savePath, driver);
                getScreenshotForAccordion(driver, "kadcyla-3.2", savePath, false);
                getScreenshotForSchemaForm(driver, savePath, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }

    private void getScreenshotForMobilePAT(String savePath,
                                           WebDriver driver) throws InterruptedException {

        if (driver.findElements(By.cssSelector(".gene-component--pat")).size() > 0) {
            Consumer<WebDriver> movemouse = (d) -> {
                Actions action = new Actions(d);
                WebElement element;
                element = d.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/div[1]/a[2]/i[1]"));
                action.moveToElement(element).build().perform();
            };
            scrollAndClickAt(driver, "/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]");
            //WebElement e = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]"));
            //e.click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat1-yes");
            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat2-yes");
            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat3-no");
            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat4-yes");
            //jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat1-no");

            //jse.executeScript("window.scrollTo(0, 0)");
            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat2-no");

            driver.navigate().refresh();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat3-yes");

            //jse.executeScript("window.scrollTo(0, 0)");
            //driver.findElement(By.className("start-over")).click();
            scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1500);
            movemouse.accept(driver);
            Thread.sleep(1500);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat4-no");
            driver.navigate().refresh();
        }
    }
}
