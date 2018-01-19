package com.gene.screenshots.selenium.her2treatment;

import org.openqa.selenium.*;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.List;

import static com.gene.screenshots.selenium.Constants.*;

public class Her2treatment extends SeleniumHeadless{
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {

            goToUrl(driver, "/index.html");
            visible(driver, true, savePath, "her2treatment-visible-0.0-herceptin");
            
            click(driver, driver.findElement(By.linkText("PERJETA®")));
            visible(driver, true, savePath, "her2treatment-visible-0.0-perjeta");
            
            click(driver, driver.findElement(By.linkText("KADCYLA®")));
            visible(driver, true, savePath, "her2treatment-visible-0.0-kadcyla");
            
            goToUrl(driver, "/index.html");
            full(driver, true, savePath, "her2treatment-0.0-herceptin");
            	
            full(driver, true, savePath, "her2treatment-0.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));
            
            full(driver, true, savePath, "her2treatment-0.0-kadcyla", driver.findElement(By.linkText("KADCYLA®")), new Long(1000));

            driver.navigate().refresh();
            waitForPageLoad(driver);
            click(driver, driver.findElement(By.linkText("http://www.fda.gov/medwatch")));
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-link-thirdparty-modal");
            
            driver.navigate().refresh();
            waitForPageLoad(driver);
            click(driver, driver.findElement(By.linkText("Resources for Nurses")));
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-3.0-modal");
            
            driver.navigate().refresh();
            waitForPageLoad(driver);
            click(driver, driver.findElement(By.className("share-a-page-button")));
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-share-modal");
            
            click(driver, driver.findElement(By.cssSelector("#share-a-page-riker-form > div.modal-footer > div > input")));
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-share-modal-submit-missing");
            
            driver.findElement(By.name("fname")).sendKeys("marwin");;
            driver.findElement(By.name("lname")).sendKeys("nicolas");;
            driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
            click(driver, driver.findElement(By.cssSelector("#share-a-page-riker-form > div.modal-footer > div > input")));
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-share-modal-submit");
            
            goToUrl(driver, "/safety.html");
            full(driver, true, savePath, "her2treatment-0.0-safety-herceptin");
            
            scrollAndClickAt(driver, driver.findElement(By.linkText("PERJETA®")));
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-0.0-safety-perjeta");
            
            click(driver, driver.findElement(By.linkText("KADCYLA®")));
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-0.0-safety-kadcyla");
            
            goToUrl(driver, "/what-is-her2-positive-breast-cancer.html");
            full(driver, true, savePath, "her2treatment-1.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin.html");
            visible(driver, true, savePath, "her2treatment-visible-2.0-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta.html");
            visible(driver, true, savePath, "her2treatment-visible-2.0-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla.html");
            visible(driver, true, savePath, "her2treatment-visible-2.0-kadcyla");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments.html");
            full(driver, true, savePath, "her2treatment-2.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin.html");
            full(driver, true, savePath, "her2treatment-2.0-herceptin");

            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin/safety.html");
            full(driver, true, savePath, "her2treatment-2.0-safety-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta.html");
            full(driver, true, savePath, "her2treatment-2.0-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta/safety.html");
            full(driver, true, savePath, "her2treatment-2.0-safety-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla.html");
            full(driver, true, savePath, "her2treatment-2.0-kadcyla");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla/safety.html");
            full(driver, true, savePath, "her2treatment-2.0-safety-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            visible(driver, true, savePath, "her2treatment-visible-3.0-herceptin");
            
            click(driver, driver.findElement(By.linkText("PERJETA®")));
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-3.0-perjeta");
            
            click(driver, driver.findElement(By.linkText("KADCYLA®")));
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-3.0-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            full(driver, true, savePath, "her2treatment-3.0-herceptin");
            
            full(driver, true, savePath, "her2treatment-3.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));
            
            full(driver, true, savePath, "her2treatment-3.0-kadcyla", driver.findElement(By.linkText("KADCYLA®")), new Long(1000));
            
            goToUrl(driver, "/breast-cancer-nurse-resources/safety.html");
            full(driver, true, savePath, "her2treatment-3.0-safety-herceptin");
            
            click(driver, driver.findElement(By.linkText("PERJETA®")));
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-safety-perjeta");
            
            click(driver, driver.findElement(By.linkText("KADCYLA®")));
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-safety-kadcyla");

            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            click(driver, driver.findElement(By.cssSelector("[data-toggle='dropdown']")));
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown");

            getMenuPopovers(driver, true, savePath);
            
            goToUrl(driver, "/breast-cancer-nurse-resources/contact-a-genentech-nurse-educator.html");
            full(driver, true, savePath, "her2treatment-genentech-nurse-educator");
            
            click(driver, driver.findElement(By.cssSelector(".controls .submit")));
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-genentech-nurse-educator-error-msg");
            
            goToUrl(driver, "/her2-positive-breast-cancer-glossary.html");
            full(driver, true, savePath, "her2treatment-glossary");
            
            goToUrl(driver, "/user-sitemap.html");
            full(driver, true, savePath, "her2treatment-sitemap");
            
            goToUrl(driver, "/breast-cancer-treatment-prescribing-information.html");
            full(driver, true, savePath, "her2treatment-prescribing-info");
            
            goToUrl(driver, "/errorpage.html");
            full(driver, true, savePath, "her2treatment-errorpage");

		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
	}
	@Override
	public void mobileAutomationTest(String savePath) {

	    WebDriver driver = makeMobileDriver();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
        try {

            goToUrl(driver, "/index.html");
            visible(driver, false, savePath,  "her2treatment-mobile-home");
            
            click(driver, driver.findElement(By.cssSelector(".navbar-toggle")));
            visible(driver, false, savePath,  "her2treatment-mobile-menu");
            
            click(driver, driver.findElement(By.cssSelector("a[href*='breast-cancer-nurse']")));
            Thread.sleep(1000);
            visible(driver, false, savePath, "her2treatment-mobile-3.0-modal");
            
            driver.navigate().refresh();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            waitForPageLoad(driver);
            click(driver, driver.findElement(By.linkText("http://www.fda.gov/medwatch")));
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, false, savePath,  "her2treatment-mobile-link-thirdparty-modal");
            
            driver.navigate().refresh();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-herceptin");
            	
            full(driver, false, savePath, "her2treatment-mobile-0.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));

            forceClick(driver, driver.findElement(By.linkText("KADCYLA®")));
            scrollTo(driver, 0, 0);
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-kadcyla");

            goToUrl(driver, "/safety.html");
            full(driver, false, savePath, "her2treatment-mobile-0.0-safety-herceptin");
            
            scrollAndClickAt(driver, driver.findElement(By.linkText("PERJETA®")));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-safety-perjeta");
            
            click(driver, driver.findElement(By.linkText("KADCYLA®")));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-safety-kadcyla");
            
            goToUrl(driver, "/what-is-her2-positive-breast-cancer.html");
            full(driver, false, savePath, "her2treatment-mobile-1.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin/safety.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-safety-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta/safety.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-safety-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-kadcyla");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla/safety.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-safety-kadcyla");

            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            forceClick(driver, driver.findElement(By.linkText("HERCEPTIN®")));
            scrollTo(driver,0, getDocHeight(driver));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-herceptin");

            // issues with dynamic content and scrolling increases page height
            driver.navigate().refresh();
            waitForPageLoad(driver);
            forceClick(driver, driver.findElement(By.linkText("KADCYLA®")));
            scrollTo(driver,0, getDocHeight(driver));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-kadcyla");

            driver.navigate().refresh();
            waitForPageLoad(driver);
            forceClick(driver, driver.findElement(By.linkText("PERJETA®")));
            scrollTo(driver,0, getDocHeight(driver));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-perjeta");


            goToUrl(driver, "/breast-cancer-nurse-resources/safety.html");
            full(driver, false, savePath, "her2treatment-mobile-3.0-safety-herceptin");
            
            scrollAndClickAt(driver, driver.findElement(By.linkText("PERJETA®")));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-safety-perjeta");
            
            click(driver, driver.findElement(By.linkText("KADCYLA®")));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-safety-kadcyla");
            

            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            click(driver, driver.findElement(By.cssSelector("[data-toggle='dropdown']")));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown");

            getMenuPopovers(driver, false, savePath);
            
            goToUrl(driver, "/breast-cancer-nurse-resources/contact-a-genentech-nurse-educator.html");
            full(driver, false, savePath, "her2treatment-mobile-genentech-nurse-educator");
            
            click(driver, driver.findElement(By.cssSelector(".controls .submit")));
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-genentech-nurse-educator-error-msg");
            
            goToUrl(driver, "/her2-positive-breast-cancer-glossary.html");
            full(driver, false, savePath, "her2treatment-mobile-glossary");
            
            goToUrl(driver, "/user-sitemap.html");
            full(driver, false, savePath, "her2treatment-mobile-sitemap");
            
            goToUrl(driver, "/breast-cancer-treatment-prescribing-information.html");
            full(driver, false, savePath, "her2treatment-mobile-prescribing-info");
            
            goToUrl(driver, "/errorpage.html");
            full(driver, false, savePath, "her2treatment-mobile-errorpage");
		
		}catch (Exception e) {
		    e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
	}

	private void getMenuPopovers(WebDriver driver, boolean ifDesktop, String savePath){
        // click menu option
        List<WebElement> menuOptions = driver.findElements(By.cssSelector(".forms-documents-indication:not([data-indication='Show all'])"));
        List<WebElement> popovers = driver.findElements(By.cssSelector("[data-toggle='popover']"));

        int height = ifDesktop ? DESKTOP_HEIGHT : MOBILE_HEIGHT;
        int width = ifDesktop ? DESKTOP_WIDTH : MOBILE_WIDTH;
        for(int i = 0; i < menuOptions.size(); ++i) {
            // get all popover div content from reach menu option
            click(driver, menuOptions.get(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            full(driver, ifDesktop, savePath, "her2treatment-3.0-dropdown-" + i);
            for(int x = 0, index = 0; x < popovers.size(); ++x)
                if(popovers.get(x).isDisplayed()) {
                    driver.manage().window().setSize(new Dimension(width, getDocHeight(driver)));
                    click(driver, popovers.get(x));
                    waitForElementToExist(driver, "popover");
                    visible(driver, ifDesktop, savePath, String.format("her2treatment-3.0-dropdown-%d-%d", i, index++));
                    driver.manage().window().setSize(new Dimension(width, height));
                }
        }

    }
}
