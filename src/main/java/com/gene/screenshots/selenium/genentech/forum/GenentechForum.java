package com.gene.screenshots.selenium.genentech.forum;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class GenentechForum extends SeleniumHeadless {

    @Override
    public String getSiteMapUrl() {
        return "/sitemap.html";
    }

    @Override
    public String getSiteMapSelector() {
        return ".main-content .sitemap a, .main-content .richtext a";
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = super.getLinksFromSiteMap(driver);
        // because sitemap page doesn't have everything
        links.add(getSiteMapUrl());
        // because we don't want to go to genentech's unsubscribe page
        links.remove("/unsubscribe-from-genentech-forum-site-updates.html");
        return links;
    }

    @Override
    public void getScreenshotForCarousels(WebDriver driver, String prefix, String savePath, boolean isDesktop) {
        List<WebElement> carousels = driver.findElements(By.cssSelector(".carousel.slide"));
        for (int i = 0; i < carousels.size(); i++) {
            WebElement carousel = carousels.get(i);
            scrollTo(driver, 0, carousel.getLocation().getY());
            List<WebElement> dots = carousel.findElements(By.cssSelector(".carousel-indicators li"));
            if (dots.size() > 1) { // if the carousel has 0 or 1 item, don't bother trying to click the dots
                for (int j = 1; j < dots.size(); j++) {
                    dots.get(j).click();
                    waitForElementVisible(driver, carousel.findElement(By.cssSelector(".carousel-inner .item:nth-child(" + Integer.toString(j + 1) + ")")));
                    full(driver, isDesktop, savePath, prefix + "-carousel-comp" + Integer.toString(i + 1) + "-slide" + Integer.toString(j + 1));
                }
                // reset it back to the first slide before we go and do this to other slides
                dots.get(0).click();
                waitForElementVisible(driver, carousel.findElement(By.cssSelector(".carousel-inner .item:nth-child(1)")));
            }
        }
    }

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) {
        getScreenshotForContactForm(driver, savePath, isDesktop);
        getScreenshotForRegisterForm(driver, savePath, isDesktop);
    }

    private void getScreenshotForRegisterForm(WebDriver driver,
                                              String savePath,
                                              boolean isDesktop) {
        if (driver.findElements(By.cssSelector("#managed-care-reg-form")).size() > 0) {
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("title")).sendKeys("Test Title");
            driver.findElement(By.name("organization")).sendKeys("Test Company");
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("email-address")).sendKeys("test@gene.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@gene.com");
            driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
            driver.findElement(By.cssSelector(".managed-care-form .submit")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector(".thank-you-message .richtext")));
            full(driver, isDesktop, savePath, "genentech-forum-register-submit");
        }
    }

    private void getScreenshotForContactForm(WebDriver driver,
                                             String savePath,
                                             boolean isDesktop) {
        if (driver.findElements(By.cssSelector("#cam-riker-form")).size() > 0) {
            driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
            driver.findElement(By.name("last-name")).sendKeys("TestLastName");
            driver.findElement(By.name("title")).sendKeys("Test Title");
            driver.findElement(By.name("organization")).sendKeys("Test Company Name");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.cssSelector("[data-toggle='dropdown'][data-field='state']")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector(".dropdown-menu[data-field='state']")));
            driver.findElement(By.cssSelector(".dropdown-menu[data-field='state'] li")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99999");
            driver.findElement(By.name("email-address")).sendKeys("test@gene.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("test@gene.com");
            driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
            driver.findElement(By.name("my-request")).click();
            driver.findElement(By.cssSelector("#cam-riker-form .submit")).click();
            waitForElementVisible(driver, driver.findElement(By.cssSelector(".thank-you-message .richtext")));
            full(driver, isDesktop, savePath, "genentech-forum-contact-submit");
        }
    }

    @Override
    public void getScreenshotForMobileNavigation(WebDriver driver, String savePath) {
        driver.findElement(By.cssSelector(".navbar-toggle")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".navbar-nav")));
        try {
            Thread.sleep(400); // jQuery fadeIn takes 400 ms
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        }
        visible(driver, false, savePath, "mobile-navigation");
        List<WebElement> elements = driver.findElements(By.cssSelector(".navbar-collapse .navbar-nav .has-dropdown"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).findElement(By.cssSelector(".dropdown-toggle")).click();
            waitForElementVisible(driver, elements.get(i).findElement(By.cssSelector(".dropdown-menu")));
            scrollTo(driver, 0, 0); // scroll back to the top before taking a screenshot
            visible(driver, false, savePath, "mobile-hover-" + Integer.toString(i + 1));
        }
        driver.navigate().refresh();
        waitForPageLoad(driver);
    }

    @Override
    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                goToUrl(driver, links.get(i));
                if (driver.findElements(By.cssSelector(".splash-page")).size() > 0) {
                    visible(driver, true, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForDesktopNavigation(driver, action, savePath);
                    getScreenshotForShareModal(driver, savePath);
                }
                full(driver, true, savePath, Integer.toString(i));
                getScreenshotForCarousels(driver, Integer.toString(i), savePath, true);
                getScreenshotForSchemaForm(driver, savePath, true);
            }
        } finally {
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                goToUrl(driver, links.get(i));
                if (driver.findElements(By.cssSelector(".splash-page")).size() > 0) {
                    visible(driver, false, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForMobileNavigation(driver, savePath);
                }
                full(driver, false, savePath, Integer.toString(i));
                getScreenshotForCarousels(driver, Integer.toString(i), savePath, false);
                getScreenshotForSchemaForm(driver, savePath, false);
            }
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
