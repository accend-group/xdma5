package com.gene.screenshots.selenium;

import com.gene.screenshots.BrandUrl;
import com.gene.screenshots.Variables;
import com.gene.screenshots.authentication.AuthorAuthenticationException;
import com.gene.screenshots.authentication.AuthorCredentials;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static com.gene.screenshots.selenium.Constants.*;


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
        driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        if(credentialsRequired)
            authenticate(driver);
        return driver;
    }

    public static WebDriver makeMobileDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("window-size=" + MOBILE_WIDTH + "," + MOBILE_HEIGHT);
        options.addArguments("--use-mobile-user-agent=true");
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--force-device-scale-factor=1");
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
        try {
            e.click();
        }catch (Exception ex){
            forceClick(driver, e);
        }
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

}
