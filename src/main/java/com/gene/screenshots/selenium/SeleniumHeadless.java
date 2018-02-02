package com.gene.screenshots.selenium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.LogManager;

import org.apache.commons.lang3.StringUtils;
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

    protected String pdfName = this.getClass().getSimpleName();

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
    
    private List<Thread> createScreenCaptureThreads(String savePath, boolean isDesktop){
        List<String> links = new LinkedList<String>();
        List<Thread> threads = new LinkedList<Thread>();
        WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
        try {
            links = getLinksFromSiteMap(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeDriverManager.releaseDriver(driver, isDesktop);
        int pageNumber = 1;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            threads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestDriver(isDesktop);
                try {
                    Actions action = new Actions(threadDriver);
                    goToUrl(threadDriver, link);
                    if (threadDriver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                        visible(threadDriver, isDesktop, savePath, Integer.toString(currentPageNumber) + "-visible");
                        if(isDesktop)
                            getScreenshotForDesktopNavigation(threadDriver, action, savePath);
                        else
                            getScreenshotForMobileNavigation(threadDriver, savePath);
                        getScreenshotForShareModal(threadDriver, savePath);
                        getScreenshotForThirdPartyModal(threadDriver, savePath, isDesktop);
                        getScreenshotForHCPModal(threadDriver, savePath, isDesktop);
                    }
                    full(threadDriver, isDesktop, savePath, Integer.toString(currentPageNumber));
                    getScreenshotForPAT(threadDriver, savePath, action, isDesktop);
                    getScreenshotForCarousels(threadDriver, Integer.toString(currentPageNumber), savePath, isDesktop);
                    getScreenshotForTabs(threadDriver, Integer.toString(currentPageNumber), savePath, isDesktop);
                    getScreenshotForAccordion(threadDriver, Integer.toString(currentPageNumber), savePath, isDesktop);
                    getScreenshotForSchemaForm(threadDriver, savePath, isDesktop);
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for " + (isDesktop ? "desktop" : "mobile"));
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDriver(threadDriver, isDesktop);
            }));
        }
        return threads;
    }

    public List<Thread> desktopAutomationTest(String savePath) {
       return createScreenCaptureThreads(savePath, true);
    }

    public List<Thread> mobileAutomationTest(String savePath) {
       return createScreenCaptureThreads(savePath, false);
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
    protected static void goToUrl(WebDriver driver, String partialUrl) {
        driver.get(domain.toString() + partialUrl + (credentialsRequired ? "?wcmmode=disabled" : ""));
        waitForPageLoad(driver);
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
        List<WebElement> linkElements = driver.findElements(By.cssSelector(getSiteMapSelector()));
        for (WebElement element : linkElements) {
            if (!element.getText().equalsIgnoreCase("Search")) {
                links.add(StringUtils.replace(element.getAttribute("href"), domain.toString(), ""));
            }
        }
        return links;
    }

    public void setPdfName(String name){
        pdfName = name;
    }
    public String getPdfName(){
        return pdfName;
    }


}
