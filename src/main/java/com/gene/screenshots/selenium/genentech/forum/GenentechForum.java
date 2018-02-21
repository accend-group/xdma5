package com.gene.screenshots.selenium.genentech.forum;

import com.gene.screenshots.selenium.ChromeDriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.LinkedList;

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
    public void getScreenshotForCarousels(WebDriver driver, boolean isDesktop, int pageIndex) {
        List<WebElement> carousels = driver.findElements(By.cssSelector(".carousel.slide"));
        for (WebElement carousel : carousels) {
            scrollTo(driver, 0, carousel.getLocation().getY());
            List<WebElement> dots = carousel.findElements(By.cssSelector(".carousel-indicators li"));
            if (dots.size() > 1) { // if the carousel has 0 or 1 item, don't bother trying to click the dots
                for (int j = 1; j < dots.size(); j++) {
                    dots.get(j).click();
                    waitForElementVisible(driver, carousel.findElement(By.cssSelector(".carousel-inner .item:nth-child(" + Integer.toString(j + 1) + ")")));
                    full(driver, isDesktop, pageIndex);
                }
                // reset it back to the first slide before we go and do this to other slides
                dots.get(0).click();
                waitForElementVisible(driver, carousel.findElement(By.cssSelector(".carousel-inner .item:nth-child(1)")));
            }
        }
    }

    @Override
    public void getScreenshotForSchemaForm(WebDriver driver, boolean isDesktop, int pageIndex) {
        getScreenshotForContactForm(driver, isDesktop, pageIndex);
        getScreenshotForRegisterForm(driver, isDesktop, pageIndex);
    }

    private void getScreenshotForRegisterForm(WebDriver driver, boolean isDesktop, int pageIndex) {
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
            full(driver, isDesktop, pageIndex);
        }
    }

    private void getScreenshotForContactForm(WebDriver driver, boolean isDesktop, int pageIndex) {
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
            full(driver, isDesktop, pageIndex);
        }
    }

    @Override
    public void getScreenshotForMobileNavigation(WebDriver driver, int pageIndex) {
        driver.findElement(By.cssSelector(".navbar-toggle")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".navbar-nav")));
        try {
            Thread.sleep(400); // jQuery fadeIn takes 400 ms
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        }
        visible(driver, false, pageIndex);
        List<WebElement> elements = driver.findElements(By.cssSelector(".navbar-collapse .navbar-nav .has-dropdown"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).findElement(By.cssSelector(".dropdown-toggle")).click();
            waitForElementVisible(driver, elements.get(i).findElement(By.cssSelector(".dropdown-menu")));
            scrollTo(driver, 0, 0); // scroll back to the top before taking a screenshot
            visible(driver, false, pageIndex);
        }
        driver.navigate().refresh();
        waitForPageLoad(driver);
    }

    @Override
    public List<Thread> desktopAutomationTest() {
        List<Thread> desktopTheads = new LinkedList<>();
        WebDriver driver = ChromeDriverManager.requestDesktopDriver();

        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), true);

        ChromeDriverManager.releaseDesktopDriver(driver);

        //--->start full page screenshot <---//
        for (int i = 0; i < links.size(); i++) {
            final int pageIndex = i;
            final String link = links.get(i);
            desktopTheads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestDesktopDriver();
                try {
                    Actions action = new Actions(threadDriver);
                    goToUrl(threadDriver, link);
                    waitForIframe(threadDriver);
                    if (threadDriver.findElements(By.cssSelector(".splash-page")).size() > 0) {
                        visible(threadDriver, true, pageIndex);
                        getScreenshotForDesktopNavigation(threadDriver, action, pageIndex);
                        getScreenshotForShareModal(threadDriver, pageIndex);
                    }
                    resetCarousels(threadDriver);
                    full(threadDriver, true, pageIndex);
                    getScreenshotForCarousels(threadDriver, true, pageIndex);
                    getScreenshotForSchemaForm(threadDriver, true, pageIndex);
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for desktop");
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDesktopDriver(threadDriver);
            }));
        }
        return desktopTheads;
    }

    @Override
    public List<Thread> mobileAutomationTest() {
        List<Thread> mobileThreads = new LinkedList<>();
        WebDriver driver = ChromeDriverManager.requestMobileDriver();

        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), false);
        ChromeDriverManager.releaseMobileDriver(driver);
        //--->start full page screenshot <---//
        for (int i = 0; i < links.size(); i++) {
            final int pageIndex = i;
            final String link = links.get(i);
            mobileThreads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestMobileDriver();
                try {
                    goToUrl(threadDriver, link);
                    waitForIframe(threadDriver);
                    if (threadDriver.findElements(By.cssSelector(".splash-page")).size() > 0) {
                        visible(threadDriver, false, pageIndex);
                        getScreenshotForMobileNavigation(threadDriver, pageIndex);
                    }
                    resetCarousels(threadDriver);
                    full(threadDriver, false, pageIndex);
                    getScreenshotForCarousels(threadDriver, false, pageIndex);
                    getScreenshotForSchemaForm(threadDriver, false, pageIndex);
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for mobile");
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseMobileDriver(threadDriver);
            }));
        }
        return mobileThreads;
    }

    public void waitForIframe(WebDriver driver) {
        int size = driver.findElements(By.cssSelector("iframe")).size();
        if (size > 1 || driver.getCurrentUrl().contains("trend-reports.html")) {
            driver.switchTo().frame(0);
            waitForPageLoad(driver);
            waitForElementVisiblyLocated(driver, ".dialog");
            try {
                Thread.sleep(4500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.switchTo().defaultContent();
        }
    }

}
