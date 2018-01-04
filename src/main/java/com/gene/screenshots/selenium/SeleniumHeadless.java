package com.gene.screenshots.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.BrandUrl;
import com.gene.screenshots.Variables;
import com.gene.screenshots.authentication.AuthorAuthenticationException;
import com.gene.screenshots.authentication.AuthorCredentials;

/**
 * Abstract class for screenshot automation code
 * Create another class that extends SeleniumHeadless
 * each class represents a selenium code that produces screenshots for mobile and desktop.
 * each screenshot is saved in a log file that is used to create a PDF.
 * The mobile and desktop automated test functions must quit the driver at the end.
 */

public abstract class SeleniumHeadless extends Screenshots {

    protected static BrandUrl domain;

    // window.scrollBy(X, Y);
    // https://stackoverflow.com/a/4403822
    private static String SCROLL_TO_ELEMENT_FROM_XPATH = "document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView(); ";

    // TODO optimize mobiledriver/desktop with limited thread count?
    protected WebDriver desktopDriver;
    protected WebDriver mobileDriver;

    private static boolean credentialsRequired = false;

    // suppress selenium console log
    static {
        LogManager.getLogManager().reset();
    }

    public static void setChromeSystemProperty(String chromedriverPath) {
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
    }

    private static void authenticate(WebDriver driver) {
        try {
            AuthorCredentials credentials = new AuthorCredentials(Variables.getAuthorUsername(), Variables.getAuthorPassword(), domain.toString());
            driver.get(credentials.getHost() + "/libs/cq/core/content/login.html");
            for(org.apache.http.cookie.Cookie cookie : credentials.getCookies()) {
                driver.manage().addCookie(new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getPath(), cookie.getExpiryDate(), cookie.isSecure()));
            }
        } catch (AuthorAuthenticationException e) {
            e.printStackTrace();
            driver.quit();
        }
    }

    public static WebDriver makeDesktopDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-infobars");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--hide-scrollbars");
        ChromeDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingAnyFreePort().withSilent(true).build(), options);
        driver.manage().window().setSize(new Dimension(Constants.DESKTOP_WIDTH, Constants.DESKTOP_HEIGHT));
        if(credentialsRequired)
            authenticate(driver);
        return driver;
    }

    public static WebDriver makeMobileDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=" + Constants.MOBILE_WIDTH + "," + Constants.MOBILE_HEIGHT);
        options.addArguments("--use-mobile-user-agent=true");
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--force-device-scale-factor=" + getMobileScaleFactor());
        options.addArguments("--hide-scrollbars");
        WebDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingAnyFreePort().withSilent(true).build(), options);
        if(credentialsRequired)
            authenticate(driver);
        return driver;
    }

    public void desktopAutomationTest(String savePath) {
        desktopDriver = makeDesktopDriver();
    }


    public void mobileAutomationTest(String savePath) {
        mobileDriver = makeMobileDriver();
    }


    // scrolls to the element and clicks it
    protected static void scrollAndClickAt(WebDriver driver, String xpath) {
        WebElement e = driver.findElement(By.xpath(xpath));
        scrollAndClickAt(driver, e);
    }


    protected static void scrollAndClickAt(WebDriver driver, WebElement e) {
        scrollToElement(driver, e);
        e.click();
    }

    protected static void scrollToElement(WebDriver driver, WebElement e) {

        ((JavascriptExecutor) driver).executeScript(SCROLL_TO_ELEMENT_FROM_XPATH, getXPath(driver, e));
    }

    protected static void scrollToElement(WebDriver driver, String xpath) {
        ((JavascriptExecutor) driver).executeScript(SCROLL_TO_ELEMENT_FROM_XPATH, xpath);
    }


    protected static String getXPath(WebDriver driver, WebElement e) {
        String jscript = "function getPathTo(node) {" +
                "  var stack = [];" +
                "  while(node.parentNode !== null) {" +
                "    stack.unshift(node.tagName);" +
                "    node = node.parentNode;" +
                "  }" +
                "  return stack.join('/');" +
                "}" +
                "return getPathTo(arguments[0]);";
        return (String) ((JavascriptExecutor) driver).executeScript(jscript, e);
    }

    public static void isCredentialsRequired(boolean ifCredentials){
        credentialsRequired = ifCredentials;
    }

    public static void setDomain(BrandUrl url){
        domain = url;
    }

    // redirect a partial url to the correct domain
    protected static void goToUrl(WebDriver driver, String partialUrl){
        driver.get(domain.toString() + partialUrl + (credentialsRequired ? "?wcmmode=disabled" : ""));
    }

    public void killDesktop(){
        desktopDriver.quit();
    }

    public void killMobile(){
        mobileDriver.quit();
    }

    protected String getSiteMapUrl() {
        return "";
    }

    protected String getSiteMapSelector() {
        return "";
    }

    protected List<String> getLinksFromSiteMap(WebDriver driver) throws InterruptedException {
        List<String> links = new ArrayList<String>();
        goToUrl(driver, getSiteMapUrl());
        Thread.sleep(1000);
        WebElement container = driver.findElement(By.cssSelector(getSiteMapSelector()));
        List<WebElement> linkElements = container.findElements(By.cssSelector(".gene-component--sitemap__link"));
        for (WebElement element : linkElements) {
            if (!element.getText().equalsIgnoreCase("Search")) {
                links.add(element.getAttribute("href"));
            }
        }
        return links;
    }

    protected void getScreenshotForDesktopNavigation(WebDriver driver, Actions action, String prefixName, String savePath) throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.cssSelector(".gene-component--navigation__tab--parent .gene-component--navigation__link--tab"));
        for (int i = 0; i < elements.size(); i++) {
            action.moveToElement(elements.get(i)).build().perform();
            Thread.sleep(1000);
            String screenshotName = prefixName +"-hover-" + Integer.toString(i + 1) + ".0";
            visible(driver, true, savePath, screenshotName);
        }
    }

    protected void getScreenshotForMobileNavigation(WebDriver driver, String prefixName, String savePath) throws InterruptedException {
        driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
        Thread.sleep(1000);
        visible(driver, false, savePath, prefixName + "-navigation");
        List<WebElement> elements = driver.findElements(By.cssSelector(".gene-component--navigation__icon--tab"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            Thread.sleep(1000);
            String screenshotName = prefixName +"-mobile-hover-" + Integer.toString(i + 1) + ".0";
            visible(driver, false, savePath, screenshotName);
            elements.get(i).click(); // collapse the current menu before going to the next one. So then the cursor won't hover over a submenu item.
        }
    }

    protected void getScreenshotForAccordion(WebDriver driver, String prefixName, String savePath, boolean isDesktop) throws InterruptedException {
        List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open) .gene-component--accordionTabs__header, .panel-heading"));
        if (tabs.size() > 0) {
            int y = tabs.get(0).getLocation().getY();
            scrollTo(driver, 0, y);
            for (int i = 0; i < tabs.size(); i++) {
                tabs.get(i).click();
                Thread.sleep(1000);
                String screenshotName = prefixName +"-tab" + Integer.toString(i + 1);
                full(driver, isDesktop, savePath, screenshotName);
                tabs.get(i).click(); //collapse the current one
                Thread.sleep(1000);
            }
        }
    }

    protected void getScreenshotForShareModal(WebDriver driver, String prefix, String savePath) throws InterruptedException {
        if (driver.findElements(By.cssSelector(".genentech-component--button--share")).size() > 0) {
            driver.findElement(By.cssSelector(".genentech-component--button--share")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, prefix + "-modal-share");
            driver.findElement(By.name("fname")).sendKeys("First Name");
            driver.findElement(By.cssSelector(".gene-component--modal__button--confirm")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, prefix + "-modal-share-error");
            driver.findElement(By.name("lname")).sendKeys("Last Name");
            driver.findElement(By.name("to-email-address")).sendKeys("test@genentech.com");
            driver.findElement(By.cssSelector(".gene-component--modal__button--confirm")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, prefix + "-modal-share-submit");
        }
    }

    protected void getScreenshotForHCPModal(WebDriver driver, String prefix, String savePath, boolean isDesktop) throws InterruptedException {
        if (isDesktop) {
            driver.findElement(By.cssSelector(".gene-component--header__audience .gene-component--audience__item--hcp .gene-component--audience__link")).click();
        } else {
            driver.findElement(By.cssSelector(".gene-component--header__navigation .gene-component--audience__item--hcp .gene-component--audience__link")).click();
        }
        Thread.sleep(1000);
        visible(driver, isDesktop, savePath, prefix + "-modal-HCP");
    }

    protected void getScreenshotForThirdPartyModal(WebDriver driver, String prefix, String savePath, boolean isDesktop) throws InterruptedException {
        WebElement thirdPartyLink = driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
        int y = thirdPartyLink.getLocation().getY();
        scrollTo(driver, 0, y);
        Thread.sleep(500);
        thirdPartyLink.click();
        if (isDesktop) {
            scrollTo(driver, 0, 0);
        }
        Thread.sleep(1000);
        String name = prefix + "-link-modal";
        visible(driver, isDesktop, savePath, name);
    }

    protected void clickYesPATButton(WebDriver driver) throws InterruptedException {
        clickPATButton(driver, ".assistance-tool .active:not(.disabled) .yes");
    }

    protected void clickNoPATButton(WebDriver driver) throws InterruptedException {
        clickPATButton(driver, ".assistance-tool .active:not(.disabled) .no");
    }

    protected void updatePATResponse(WebDriver driver) throws InterruptedException {
        clickPATButton(driver, ".update-response");
    }

    protected void restartPAT(WebDriver driver) throws InterruptedException {
        clickPATButton(driver, ".start-over");
    }

    private void clickPATButton(WebDriver driver, String selector) throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector(selector));
        int y = button.getLocation().getY();
        scrollTo(driver, 0, y);
        Thread.sleep(1000);
        button.click();
    }
}
