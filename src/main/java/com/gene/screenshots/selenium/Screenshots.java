package com.gene.screenshots.selenium;

import static com.gene.screenshots.selenium.Constants.DESKTOP_HEIGHT;
import static com.gene.screenshots.selenium.Constants.DESKTOP_WIDTH;
import static com.gene.screenshots.selenium.Constants.MOBILE_HEIGHT;
import static com.gene.screenshots.selenium.Constants.MOBILE_WIDTH;
import static java.lang.Math.toIntExact;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.utils.file.FileUtil;
import com.assertthat.selenium_shutterbug.utils.web.UnableTakeSnapshotException;

/***
 * used Shutterbug https://github.com/assertthat/selenium-shutterbug as starting basis
 * but now instead of scroll and stitch to get a fullscreenshot the main browser window
 * is resized to match the entire site body height for fullscreen pages.
 *
 * If the page height is larger than 16384 pixels then scroll and stitch is applied
 * https://groups.google.com/a/chromium.org/forum/#!msg/headless-dev/DqaAEXyzvR0/XmHJTCawCAAJ
 *
 ***/
public abstract class Screenshots {

    public Screenshots setDesktopSavePath(String desktopSavePath) {
        this.desktopSavePath = desktopSavePath;
        return this;
    }

    public Screenshots setMobileSavePath(String mobileSavePath) {
        this.mobileSavePath = mobileSavePath;
        return this;
    }

    private String desktopSavePath;
    private String mobileSavePath;


    private static int mobileScaleFactor = 1;

    // viewport height limitation in chrome, do not change value!
    // https://groups.google.com/a/chromium.org/forum/#!msg/headless-dev/DqaAEXyzvR0/P9zmTLMvDQAJ
    private final int CHROME_HEIGHT_CAP = 16384;

    // if true desktop and mobile screenshots are created as separate pdfs
    // if false both desktop and mobile are merged as one pdf.
    private static boolean ifSinglePDF = true;

    private LinkedList<String> [] desktopScreenshots;
    private LinkedList<String> [] mobileScreenshots;
    private int [] desktopPageScreenshotCount;
    private int [] mobilePageScreenshotCount;


    // once the number of web pages is known set the page count
    public void setNumberOfPageVisits(int pageCount, boolean isDesktop){
        if(isDesktop) {
            desktopScreenshots = new LinkedList[pageCount];
            for(int i = 0; i < desktopScreenshots.length; ++i)
                desktopScreenshots[i] = new LinkedList<>();
            desktopPageScreenshotCount = new int[pageCount];
        }
        else {
            mobileScreenshots = new LinkedList[pageCount];
            for(int i = 0; i < mobileScreenshots.length; ++i)
                mobileScreenshots[i] = new LinkedList<>();
            mobilePageScreenshotCount = new int[pageCount];
        }
    }
    
    public LinkedList<String> getDesktopScreenshots() {
        if(desktopScreenshots == null)
            return null;
        LinkedList<String> desktopImagePaths = new LinkedList<>();
        for(LinkedList<String> paths : desktopScreenshots)
            desktopImagePaths.addAll(paths);
        return desktopImagePaths;
    }

    public LinkedList<String> getMobileScreenshots() {
        if(mobileScreenshots == null)
            return null;
        LinkedList<String> mobileImagePaths = new LinkedList<>();
        for(LinkedList<String> paths : mobileScreenshots)
            mobileImagePaths.addAll(paths);
        return mobileImagePaths;
    }

    // click element and wait for the css selected element to be visible and wait for set time
    public void full(WebDriver driver, boolean isDesktop, int currentPageIndex, WebElement clickElement, String cssString, long time){
        handleFullScreenType(driver, isDesktop, currentPageIndex, clickElement, time, cssString, null);
    }

    // click element and wait for another element to become visible and wait for the set time
    public void full(WebDriver driver, boolean isDesktop, int currentPageIndex, WebElement clickElement, WebElement waitForDynamicElement, long time){
        handleFullScreenType(driver, isDesktop, currentPageIndex, clickElement, time, null, waitForDynamicElement);
    }

    // click element and wait for the set time
    public void full(WebDriver driver, boolean ifDesktop, int currentPageIndex, WebElement clickElement, long time)  {
        handleFullScreenType(driver, ifDesktop, currentPageIndex, clickElement, time, null, null);
    }

    // regular fullscreen
    public void full(WebDriver driver, boolean ifDesktop, int currentPageIndex)  {
        handleFullScreenType(driver, ifDesktop, currentPageIndex, null, 0L, null, null);
    }

    private void handleFullScreenType(WebDriver driver, boolean ifDesktop, int currentPageIndex, WebElement clickElement, Long time, String cssString, WebElement waitForDynamicElement){
        int pageCount = ifDesktop ? desktopPageScreenshotCount[currentPageIndex]++ :mobilePageScreenshotCount[currentPageIndex]++;
        String screenshotName = String.format("%s-%s", currentPageIndex, pageCount);
        String path = ifDesktop ? desktopSavePath : mobileSavePath;
        fullScreenshot(driver, ifDesktop, screenshotName, clickElement, time, cssString, waitForDynamicElement);
        File outputImg = new File(path + "/" + screenshotName + ".png");
        if (ifDesktop)
            desktopScreenshots[currentPageIndex].add(outputImg.getAbsolutePath());
        else
            mobileScreenshots[currentPageIndex].add(outputImg.getAbsolutePath());
    }


    public void visible(WebDriver driver, boolean ifDesktop, int currentPageIndex) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            int pageCount = ifDesktop ? desktopPageScreenshotCount[currentPageIndex]++ :mobilePageScreenshotCount[currentPageIndex]++;
            String screenshotName = String.format("%s-%s", currentPageIndex, pageCount);
            String path = ifDesktop ? desktopSavePath : mobileSavePath;
            File outputImg = new File(path + "/" + screenshotName + ".png");
            FileUtils.copyFile(source, outputImg);
            if (ifDesktop)
                desktopScreenshots[currentPageIndex].add(outputImg.getAbsolutePath());
            else
                mobileScreenshots[currentPageIndex].add(outputImg.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Exception while taking visible part screenshot" + e.getMessage());
        }
    }

    protected int getDocWidth(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.max(document.body.scrollWidth, document.body.offsetWidth, document.documentElement.clientWidth, document.documentElement.scrollWidth, document.documentElement.offsetWidth);");
        return Math.toIntExact(result);
    }

    protected int getDocHeight(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.max(document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);");
        return toIntExact(result);
    }

    protected int getCurrentScrollX(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.round(Math.max(document.documentElement.scrollLeft, document.body.scrollLeft));");
        return toIntExact(result);
    }

    protected int getCurrentScrollY(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.round(Math.max(document.documentElement.scrollTop, document.body.scrollTop));");
        return toIntExact(result);
    }

    protected void scrollTo(WebDriver driver, int x, int y) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
    }


    public static boolean isIfSinglePDF() {
        return ifSinglePDF;
    }

    public static void setIfSinglePDF(boolean ifSinglePDF) {
        Screenshots.ifSinglePDF = ifSinglePDF;
    }

    // full site body screenshot
    // need to store current scroll position
    // click item after resizing window
    protected void fullScreenshot(WebDriver driver, boolean ifDesktop, String fileName, WebElement clickElement, long time, String cssString, WebElement dynamicElement) {

        int xPos = getCurrentScrollX(driver);
        int yPos = getCurrentScrollY(driver);
        String location = ifDesktop ? desktopSavePath : mobileSavePath;
        File screenshotFile = new File(location);
        if (!screenshotFile.exists()) {
            screenshotFile.mkdirs();
        }
        File outputImg = new File(location + "/" + fileName + ".png");

        scrollTo(driver, 0, 0);

        if (ifDesktop) {
            FileUtil.writeImage(takeScreenshotEntirePage(driver, true, clickElement, time, cssString, dynamicElement), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        } else {
            FileUtil.writeImage(takeScreenshotEntirePage(driver, false, clickElement, time, cssString, dynamicElement), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, MOBILE_HEIGHT));
        }

        // scroll to the previous position before resize
        scrollTo(driver, xPos, yPos);
        try {
            Thread.sleep(500); // wait to make sure the scroll finished
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // viewport screenshot
    //  ===================== SHUTTERBUG code modified =====================================
    private BufferedImage takeScreenshot(WebDriver driver) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            return ImageIO.read(srcFile);
        } catch (IOException e) {
            throw new UnableTakeSnapshotException(e);
        } finally {
            // add this to clean up leaving this file in the temporary directory forever...
            if (srcFile.exists()) {
                srcFile.delete();
            }
        }
    }


    public static void waitForPageLoad(WebDriver driver){
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private BufferedImage takeScreenshotEntirePage(WebDriver driver, boolean isDesktop, WebElement clickElement, long sleepTime, String cssString, WebElement dynamicContent) {

        int scaleFactor = isDesktop ? 1 : getMobileScaleFactor();

        int _docWidth = isDesktop ? DESKTOP_WIDTH : MOBILE_WIDTH;
        scrollTo(driver, 0, getCurrentScrollY(driver) + 1); // scroll in case the doc height is not correct
        try {
            Thread.sleep(350);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        int _docHeight = getDocHeight(driver);

        // resize if using scroll-stitch method
        if(_docHeight > CHROME_HEIGHT_CAP) {
            driver.manage().window().setSize(new Dimension(_docWidth, CHROME_HEIGHT_CAP));
        }
        else
            driver.manage().window().setSize(new Dimension(_docWidth, _docHeight));

        //click item after resizing window
        _docHeight = clickAfterResizedWindow(driver, clickElement, sleepTime, cssString, dynamicContent);

        // scroll-stitch
        if(_docHeight > CHROME_HEIGHT_CAP || scaleFactor > 1){

            int viewport = CHROME_HEIGHT_CAP;

            // scaled display misses content when sized to the chrome cap, the driver struggles to capture large resolution images
            if(scaleFactor > 1) {
                viewport = 2000; // larger values tend to not capture as much
                driver.manage().window().setSize(new Dimension(_docWidth, viewport));
                _docHeight = clickAfterResizedWindow(driver, clickElement, sleepTime, cssString, dynamicContent);
            }
            removeSafety(driver, isDesktop);

            // ===================== SHUTTERBUG code modified =====================================
            scrollTo(driver, 0, 0);
            _docHeight = getDocHeight(driver);
            BufferedImage finalImage = new BufferedImage(_docWidth * scaleFactor, _docHeight * scaleFactor, BufferedImage.TYPE_INT_ARGB);
            Graphics2D scrollPicsSticthed = finalImage.createGraphics();
            int leftover = (int) Math.ceil((((double) _docHeight) / viewport));
            int lastImageHeight = _docHeight < viewport ? _docHeight : _docHeight % viewport;
            int previousHeights = 0;
            BufferedImage viewPortImg = null;
            for(int i = 0; i < leftover; ++i){
                if(i == leftover - 1 && lastImageHeight != 0) {
                    driver.manage().window().setSize(new Dimension(_docWidth, lastImageHeight));
                    removeSafety(driver, isDesktop);
                    clickAfterResizedWindow(driver, clickElement, sleepTime, cssString, dynamicContent);
                }
                scrollTo(driver, 0, i * viewport);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                if(i != 0)
                    previousHeights += viewPortImg.getHeight();
                viewPortImg = takeScreenshot(driver);
                scrollPicsSticthed.drawImage(viewPortImg, 0, previousHeights, null);
            }
            scrollPicsSticthed.dispose();
            return finalImage;
            // ===================== SHUTTERBUG code modified =====================================
        }

        // else take entire window size for fullpage screenshot
        return takeScreenshot(driver);
    }

    private int clickAfterResizedWindow(WebDriver driver, WebElement e, long sleepTime, String cssString, WebElement dynamicContent) {
        if (e != null) {
            try {
                scrollTo(driver, 0, e.getLocation().y);
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            Actions builder = new Actions(driver);
            builder.moveToElement(e, 5, 5).click().build().perform();
            try {
                if(cssString != null && !cssString.isEmpty())
                    waitForElementVisiblyLocated(driver, cssString);
                else if(dynamicContent != null)
                    waitForElementVisible(driver, dynamicContent);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        } else
            // wait for page to be resized correctly, elements may appear differently if taking screenshot instantly
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        return getDocHeight(driver);
    }

    // imsafety needs to be disabled when mobile screenshots are scaled
    private static final String REMOVE_SAFETY = "arguments[0].style='position: relative; bottom: auto;'; arguments[0].classList.remove('is-active'); $(window).unbind('scroll'); var seeMore = document.getElementsByClassName('spotlight-link-active'); if(seeMore.length > 0) seeMore[0].style='display:none;'; var backToTop = document.getElementsByClassName('spotlight-link-inactive'); if(backToTop.length > 0) backToTop[0].style='display:inline;';";

    // when scaled the viewport size is reduced from the chrome cap because the scaled driver struggles capture everything
    // when resizing the browser the safety is enabled again
    private void removeSafety(WebDriver driver, boolean isDesktop){
        if(isDesktop)
            return;
        java.util.List<WebElement> safety = driver.findElements(By.cssSelector(".gene-component--spotlight.is-active"));
        if(safety.size()  > 0) {
            ((JavascriptExecutor) driver).executeScript(REMOVE_SAFETY, safety.get(0));
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".gene-component--spotlight"))));
                Thread.sleep(1000); // wait for the animation
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static int getMobileScaleFactor() {
        return mobileScaleFactor;
    }

    public static void setMobileScaleFactor(boolean isScaled){
        if(isScaled)
            mobileScaleFactor = 2;
    }

    public void removeIPerceptionModal(WebDriver driver){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(driver.findElements(By.cssSelector("img[usemap='#IPEMap']")).size() > 0)
            ((JavascriptExecutor) driver).executeScript("clWin();");
        List<WebElement> modal = driver.findElements(By.cssSelector("div[id^='IPE']"));
        if(modal.size() > 0)
            ((JavascriptExecutor) driver).executeScript("arguments[0].style = 'display: none !important;'", modal.get(0));
    }

    protected void waitForElementVisiblyLocated(WebDriver driver, String cssString) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(cssString))));
    }

    public void waitForElementVisible(WebDriver driver, WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForElementNotVisible(WebDriver driver, WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.invisibilityOf(e));
    }


    protected void getScreenshotForDesktopNavigation(WebDriver driver, Actions action, int currentPageIndex) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".gene-component--navigation__tab--parent, .navbar-nav .has-dropdown"));
        for (WebElement e : elements) {
            action.moveToElement(e.findElement(By.cssSelector(".gene-component--navigation__link--tab, .dropdown-toggle"))).build().perform();
            waitForElementVisible(driver, e.findElement(By.cssSelector(".gene-component--navigation__list, .dropdown-menu")));
            visible(driver, true, currentPageIndex);
        }
    }

    protected void getScreenshotForMobileNavigation(WebDriver driver, int currentPageIndex) {
        driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--header__navigation")));
        try {
            Thread.sleep(400); // jQuery fadeIn takes 400 ms
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        }
        visible(driver, false, currentPageIndex);
        List<WebElement> elements = driver.findElements(By.cssSelector(".gene-component--navigation__tab--parent"));
        for (WebElement e : elements) {
            e.findElement(By.cssSelector(".gene-component--navigation__icon--tab")).click();
            waitForElementVisible(driver, e.findElement(By.cssSelector(".gene-component--navigation__list")));
            visible(driver, false, currentPageIndex);
            e.findElement(By.cssSelector(".gene-component--navigation__icon--tab")).click(); // collapse the current menu before going to the next one. So then the cursor won't hover over a submenu item.
        }

        driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--close")).click();
        try {
            Thread.sleep(400); // jQuery fadeIn takes 400 ms
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        }
    }

    protected void getScreenshotForAccordion(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs--accordiontype .gene-component--accordionTabs__item .gene-component--accordionTabs__header, .panel-heading"));
        for (WebElement tab : tabs) {
            scrollTo(driver, 0, tab.getLocation().getY());
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            tab.click();

            waitForElementVisible(driver, tab.findElement(By.xpath("following-sibling::*[1]"))); // use xpath to get sibling. can't seem to do it with css selector
            scrollTo(driver, 0, 0); // scroll to the top to avoid the natural scrolling coming from the component and to force the recalculation of the height of the page.
            try {
                Thread.sleep(500); // sleep so that we have enough time for the scrolling to finish
            } catch (InterruptedException e) {
                // failed to sleep :(
                e.printStackTrace();
            }
            full(driver, isDesktop, currentPageIndex);
            scrollTo(driver, 0, tab.getLocation().getY());
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
            tab.click(); //collapse the current one

            waitForElementNotVisible(driver, tab.findElement(By.xpath("following-sibling::*[1]")));
        }
    }

    protected void getScreenshotForTabs(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        List<WebElement> tabComponents = driver.findElements(By.cssSelector(".gene-component--accordionTabs--tabstype"));
        for (int j = 0; j < tabComponents.size(); j++) {
            List<WebElement> tabs = tabComponents.get(j).findElements(By.cssSelector(".gene-component--accordionTabs__item .gene-component--accordionTabs__header"));
            if (tabs.size() > 1) {
                if (!isDesktop) {
                    scrollTo(driver, 0, tabs.get(0).getLocation().getY());
                    tabs.get(0).click(); // collapse the first tab on mobile
                    waitForElementNotVisible(driver, tabs.get(0).findElement(By.xpath("following-sibling::*[1]")));
                }
                for (int i = 1; i < tabs.size(); i++) {
                    scrollTo(driver, 0, tabs.get(i).getLocation().getY());
                    tabs.get(i).click();
                    waitForElementVisible(driver, tabs.get(i).findElement(By.xpath("following-sibling::*[1]"))); // use xpath to get sibling. can't seem to do it with css selector
                    scrollTo(driver, 0, getCurrentScrollY(driver) + 1); // scroll down a pixel so the height gets recalculated before we get the doc height.
                    full(driver, isDesktop, currentPageIndex);
                    if (!isDesktop) {
                        tabs.get(i).click(); //collapse the current one
                        waitForElementNotVisible(driver, tabs.get(i).findElement(By.xpath("following-sibling::*[1]")));
                    }
                }
                scrollTo(driver, 0, tabs.get(0).getLocation().getY());
                tabs.get(0).click(); // expand the first tab on mobile again
                waitForElementVisible(driver, tabs.get(0).findElement(By.xpath("following-sibling::*[1]")));
            }
        }
    }

    protected void getScreenshotForShareModal(WebDriver driver, int currentPageIndex) {
        List<WebElement> shareModalButton = driver.findElements(By.cssSelector(".genentech-component--button--share, .share-a-page-button"));
        if(shareModalButton.size() > 0) {
            shareModalButton.get(0).click();
            WebElement modal = driver.findElement(By.cssSelector(".gene-component--modal--share-via-email, .share-a-page-modal"));
            waitForElementVisible(driver, modal);
            try {
                Thread.sleep(400); // jQuery fadeIn slowly lows the modal in 
            } catch (InterruptedException e) {
                // failed to sleep :(
                e.printStackTrace();
            } 
            visible(driver, true, currentPageIndex);
            modal.findElement(By.name("fname")).sendKeys("First");
            modal.findElement(By.cssSelector("input[type='submit']")).click();
            waitForElementVisible(driver, modal.findElement(By.cssSelector(".to-email-address .message")));
            visible(driver, true, currentPageIndex);
            modal.findElement(By.name("lname")).sendKeys("Last");
            modal.findElement(By.name("to-email-address")).sendKeys("test@gene.com");
            modal.findElement(By.cssSelector("input[type='submit']")).click();
            waitForElementVisible(driver, modal.findElement(By.cssSelector(".gene-component--modal__success, .share-thank-you-message")));
            visible(driver, true, currentPageIndex);

            driver.findElement(By.cssSelector(".share-a-page-modal button.close")).click();
            waitForElementNotVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal__success, .share-thank-you-message")));
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void getScreenshotForHCPModal(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        StringBuffer sb = new StringBuffer();
        boolean isHcp = false;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<Object> hcpUrls = (List<Object>) js.executeScript("return window.hcpUrls;");
        if (hcpUrls.size() > 0) {
            for (Object url : hcpUrls) {
                if (url instanceof String) {
                    if (StringUtils.contains(driver.getCurrentUrl(), url + ".html")) {
                        isHcp = true;
                        break;
                    }
                    sb.append("a[href='").append(url).append(".html'],");
                } else if (url instanceof Map) {
                    String link = (String) ((Map<?, ?>) url).get("hcplink");
                    if (StringUtils.contains(driver.getCurrentUrl(), link + ".html")) {
                        isHcp = true;
                        break;
                    }
                    sb.append("a[href='").append(link).append(".html'],");
                }
            }
            if (isHcp) {
                return; // if the current site is hcp, don't even run this code.
            }
            sb.deleteCharAt(sb.length() - 1); // trim the last comma if it is NOT a hcp site

            boolean clicked = false;
            List<WebElement> links = driver.findElements(By.cssSelector(sb.toString()));
            for (WebElement link : links) {
                if (link.isDisplayed()) {
                    link.click();
                    clicked = true;
                    break;
                } else if ((!isDesktop) && link.findElement(By.xpath("../../..")).getAttribute("class").contains("gene-component--header__nav-section--audience")) {
                    driver.findElement(By.cssSelector(".gene-component--header__toggle-icon--menu")).click();
                    waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--header__navigation")));
                    try {
                        Thread.sleep(400); // jQuery fadeIn takes 400 ms
                    } catch (InterruptedException e) {
                        // failed to sleep :(
                        e.printStackTrace();
                    }
                    link.click();
                    clicked = true;
                    break;
                }
            }
            if (clicked) {
                scrollTo(driver, 0, 0);
                waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--hcp-interstitial, .hcp-modal")));
                try {
                    Thread.sleep(400); // jQuery fadeIn slowly lows the modal in 
                } catch (InterruptedException e) {
                    // failed to sleep
                    e.printStackTrace();
                } 
                visible(driver, isDesktop, currentPageIndex);
                List<WebElement> closeButtons = driver.findElements(By.cssSelector(".hcp-modal button.close, .gene-component--modal--hcp-interstitial .gene-component--modal__close"));
                for(WebElement closeButton : closeButtons)
                    if(closeButton.isDisplayed()){
                        closeButton.click();
                        waitForElementNotVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--hcp-interstitial, .hcp-modal")));
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }
    }

    protected void getScreenshotForThirdPartyModal(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        StringBuffer sb = new StringBuffer();
        sb.append(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<Object> geneUrls = (List<Object>) js.executeScript("return window.geneUrls;");
        if (geneUrls.size() > 0) {
            for (Object url : geneUrls) {
                if (url instanceof String) {
                    sb.append(":not([href*='").append(url).append("'])");
                } else if (url instanceof Map) {
                    sb.append(":not([href*='").append(((Map<?, ?>) url).get("externallink")).append("'])");
                }
            }
        }
        WebElement thirdPartyLink = driver.findElement(By.cssSelector(sb.toString()));
        int y = thirdPartyLink.getLocation().getY();
        scrollTo(driver, 0, y);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thirdPartyLink.click();

        scrollTo(driver, 0, 0);
        waitForElementVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--third-party, .external-modal")));
        try {
            Thread.sleep(400); // jQuery fadeIn slowly lows the modal in 
        } catch (InterruptedException e) {
            // failed to sleep :(
            e.printStackTrace();
        }
        visible(driver, isDesktop, currentPageIndex);
        List<WebElement> closeButtons = driver.findElements(By.cssSelector(".gene-component--modal--third-party .gene-component--modal__close, .external-modal button.close"));
        for(WebElement closeButton : closeButtons)
            if(closeButton.isDisplayed()){
                closeButton.click();
                waitForElementNotVisible(driver, driver.findElement(By.cssSelector(".gene-component--modal--third-party, .external-modal")));
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    protected void getScreenshotForCarousels(WebDriver driver, boolean isDesktop, int currentPageIndex) {
        List<WebElement> carousels = driver.findElements(By.cssSelector(".gene-component--hero-carousel"));
        for (WebElement carousel : carousels) {
            scrollTo(driver, 0, carousel.getLocation().getY());
            List<WebElement> dots = carousel.findElements(By.cssSelector(".dot"));
            if (dots.size() > 1) { // if the carousel has 0 or 1 item, don't bother trying to click the dots
                for (int j = 1; j < dots.size(); j++) {
                    dots.get(j).click();
                    waitForElementVisible(driver, carousel.findElement(By.cssSelector(".gene-component--hero-carousel__cell--" + Integer.toString(j + 1))));
                    full(driver, isDesktop, currentPageIndex);
                }
                // reset it back to the first slide before we go and do this to other slides
                dots.get(0).click();
                waitForElementVisible(driver, carousel.findElement(By.cssSelector(".gene-component--hero-carousel__cell--1")));
            }
        }
    }

    protected void getScreenshotForPAT(WebDriver driver, Actions action, boolean isDesktop, int currentPageIndex) {
        if (driver.findElements(By.cssSelector(".access-solutions")).size() > 0) {
            List<WebElement> questions = driver.findElements(By.cssSelector(".questions li"));
            if (driver.findElement(By.cssSelector(".questions")).getSize().getHeight() > driver.findElement(By.cssSelector(".assistance-tool")).getSize().getHeight()){
                for (int i = 2; i < questions.size(); i += 2) {
                    action.moveToElement(questions.get(i == questions.size() - 1 ? i : i + 1)).build().perform();
                    waitForElementVisible(driver, questions.get(i == questions.size() - 1 ? i : i + 1));
                    full(driver, isDesktop, currentPageIndex);
                }
            }

            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: none;')", driver.findElement(By.cssSelector(".assistance-tool .main")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: inline-block;')", driver.findElement(By.cssSelector(".footer .start-over")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: inline-block;')", driver.findElement(By.cssSelector(".footer .update-response")));
            List<WebElement> results = driver.findElements(By.cssSelector(".assistance-tool .result"));
            for (WebElement result : results) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: block;')", result);
                waitForElementVisible(driver, result);
                WebElement container = result.findElement(By.cssSelector(".results-container"));
                int scrollHeight = toIntExact((Long) ((JavascriptExecutor) driver).executeScript("return arguments[0].scrollHeight;", container));
                int visibleHeight = toIntExact((Long) ((JavascriptExecutor) driver).executeScript("return arguments[0].getBoundingClientRect().height;", container));
                full(driver, isDesktop, currentPageIndex);
                if (scrollHeight > visibleHeight) {
                    WebElement legal = driver.findElement(By.cssSelector(".result[style='display: block;'] p:last-child"));
                    action.moveToElement(legal).build().perform();
                    waitForElementVisible(driver, legal);
                    full(driver, isDesktop, currentPageIndex);
                }
                ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: none;')", result);
            }

            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: block;')", driver.findElement(By.cssSelector(".assistance-tool .main")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: none;')", driver.findElement(By.cssSelector(".footer .start-over")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: none;')", driver.findElement(By.cssSelector(".footer .update-response")));
            for (int j = 0; j < questions.size(); j++) {
                WebElement question = questions.get(j); 
                String clazzName = question.getAttribute("class");
                clazzName = clazzName.replaceAll("(active|disabled)", "active");
                ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('class', '" + clazzName + "')", question);
                action.moveToElement(questions.get(j == questions.size() - 1 ? j : j + 1)).build().perform();
                waitForElementVisible(driver, questions.get(j == questions.size() - 1 ? j : j + 1));
                List<WebElement> moreInfo = question.findElements(By.cssSelector(".more-info"));
                if (moreInfo.size() > 0) {
                    full(driver, isDesktop, currentPageIndex, moreInfo.get(0), ".popover", 400L);
                }
                List<WebElement> options = driver.findElements(By.cssSelector(".assistance-tool .active:not(.disabled) button[data-action^='question_']"));
                if (options.size() > 0) {
                    String buttonClazzName = options.get(0).getAttribute("class");
                    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('class', '" + buttonClazzName + " active')", options.get(0));
                }
                clazzName = question.getAttribute("class");
                clazzName = clazzName.replaceAll("(active)", "disabled");
                ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('class', '" + clazzName + "')", question);
                if (j == 0) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: inline-block;')", driver.findElement(By.cssSelector(".footer .start-over")));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'display: inline-block;')", driver.findElement(By.cssSelector(".footer .update-response")));
                }
            }
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.cssSelector(".start-over")));
        }
    }
}
