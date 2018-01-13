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
        WebDriver driver = makeDesktopDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                waitForPageLoad(driver);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, true, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForDesktopNavigation(driver, action, savePath);
                    getScreenshotForShareModal(driver, savePath);
                    getScreenshotForThirdPartyModal(driver, savePath, true);
                    getScreenshotForHCPModal(driver, savePath, true);
                }
                full(driver, true, savePath, Integer.toString(i));
                getScreenshotForPAT(driver, savePath, action,true);
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

    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {
            Actions action = new Actions(driver);
            List<String> links = getLinksFromSiteMap(driver);
            //--->start full page screenshot <---//
            for (int i = 0; i < links.size(); i++) {
                driver.get(links.get(i));
                waitForPageLoad(driver);
                if (driver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                    visible(driver, false, savePath, Integer.toString(i) + "-visible");
                    getScreenshotForMobileNavigation(driver, savePath);
                    getScreenshotForHCPModal(driver, savePath, false);
                    getScreenshotForThirdPartyModal(driver, savePath, false);
                }
                full(driver, false, savePath, Integer.toString(i));
                getScreenshotForPAT(driver, savePath, action, false);
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

    public static BrandUrl getDomain() {
        return domain;
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

    protected void getScreenshotForSchemaForm(WebDriver driver, String savePath, boolean isDesktop) {
        return;
    }

    protected List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        goToUrl(driver, getSiteMapUrl());
        waitForPageLoad(driver);
        WebElement container = driver.findElement(By.cssSelector(getSiteMapSelector()));
        List<WebElement> linkElements = container.findElements(By.cssSelector(".gene-component--sitemap__link"));
        for (WebElement element : linkElements) {
            if (!element.getText().equalsIgnoreCase("Search")) {
                links.add(element.getAttribute("href"));
            }
        }
        return links;
    }
}
