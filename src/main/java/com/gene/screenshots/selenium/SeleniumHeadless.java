package com.gene.screenshots.selenium;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.LogManager;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.BlacklistEntry;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
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
    private static boolean credentialsRequired = false;

    public static BrowserMobProxy proxy;

    // suppress selenium console log
    static {

        proxy = new BrowserMobProxyServer();
        List<BlacklistEntry> allowed = new ArrayList<>();
        allowed.add(new BlacklistEntry("^.*iperceptions.*", 404));
        proxy.setBlacklist(allowed);

            proxy.start(8080);

        try {
            System.out.println(proxy.getPort() + " " + proxy.getClientBindAddress() + " " + InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


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
        //options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("window-size=" + Constants.DESKTOP_WIDTH + "," + Constants.DESKTOP_HEIGHT);
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-infobars");
        options.addArguments("--force-device-scale-factor=1");
        options.addArguments("--hide-scrollbars");
        options.addArguments("--proxy-server=localhost:" + proxy.getPort());
        ChromeDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingAnyFreePort().withSilent(true).build(), options);
        if(credentialsRequired)
            authenticate(driver);
        return driver;
    }

    public static WebDriver makeMobileDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("window-size=" + Constants.MOBILE_WIDTH + "," + Constants.MOBILE_HEIGHT);
        options.addArguments("--use-mobile-user-agent=true");
        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--force-device-scale-factor=" + getMobileScaleFactor());
        options.addArguments("--hide-scrollbars");
        options.addArguments("--proxy-server=localhost:" + proxy.getPort());
        WebDriver driver = new ChromeDriver(new ChromeDriverService.Builder().usingAnyFreePort().withSilent(true).build(), options);
        if(credentialsRequired)
            authenticate(driver);
        return driver;
    }
    
    public List<Thread> createScreenCaptureThreads(boolean isDesktop) {

        List<Thread> threads = new LinkedList<Thread>();
        WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);

        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), isDesktop);

        ChromeDriverManager.releaseDriver(driver, isDesktop);
        int pageNumber = 0;
        for (String link : links) {
            final int currentPageNumber = pageNumber++;
            threads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestDriver(isDesktop);
                try {
                    Actions action = new Actions(threadDriver);
                    goToUrl(threadDriver, link);
                    /*removeOpinionModal(driver);
                    if (threadDriver.findElements(By.cssSelector(".gene-template--home")).size() > 0) {
                        visible(threadDriver, isDesktop, currentPageNumber);
                        if (isDesktop) {
                            getScreenshotForDesktopNavigation(threadDriver, action, currentPageNumber);
                            getScreenshotForShareModal(threadDriver, currentPageNumber);
                        } else {
                            getScreenshotForMobileNavigation(threadDriver, currentPageNumber);
                        }
                        getScreenshotForThirdPartyModal(threadDriver, isDesktop, currentPageNumber);
                        getScreenshotForHCPModal(threadDriver, isDesktop, currentPageNumber);
                    }*/;
                    full(threadDriver, isDesktop, currentPageNumber);
                    /*getScreenshotForPAT(threadDriver, action, isDesktop, currentPageNumber);
                    getScreenshotForCarousels(threadDriver, isDesktop, currentPageNumber);
                    getScreenshotForTabs(threadDriver, isDesktop, currentPageNumber);
                    getScreenshotForAccordion(threadDriver, isDesktop, currentPageNumber);
                    getScreenshotForSchemaForm(threadDriver, isDesktop, currentPageNumber);*/
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for " + (isDesktop ? "desktop" : "mobile"));
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDriver(threadDriver, isDesktop);
            }));
        }
        return threads;
    }

    public List<Thread> desktopAutomationTest() {
       return createScreenCaptureThreads(true);
    }

    public List<Thread> mobileAutomationTest() {
       return createScreenCaptureThreads(false);
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

    protected String getSiteMapUrl() {
        return "";
    }

    protected String getSiteMapSelector() {
        return "";
    }

    protected void getScreenshotForSchemaForm(WebDriver driver, boolean isDesktop, int currentPageNumber) {
        return;
    }

    protected List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        goToUrl(driver, getSiteMapUrl());
        List<WebElement> linkElements = driver.findElements(By.cssSelector(getSiteMapSelector()));

        for (WebElement element : linkElements) {
            if (!element.getText().equalsIgnoreCase("Search") && StringUtils.startsWith(element.getAttribute("href"), domain.toString())) {
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
