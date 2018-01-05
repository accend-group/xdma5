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

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
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
import com.gene.screenshots.pdf.Log;

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

    private static int mobileScaleFactor = 1;

    // viewport height limitation in chrome, do not change value!
    // https://groups.google.com/a/chromium.org/forum/#!msg/headless-dev/DqaAEXyzvR0/P9zmTLMvDQAJ
    private final int CHROME_HEIGHT_CAP = 16384;

    // if true desktop and mobile screenshots are created as separate pdfs
    // if false both desktop and mobile are merged as one pdf.
    private static boolean ifSinglePDF = true;

    private Log log;
    private LinkedList<String> desktopScreenshots = new LinkedList<>();
    private LinkedList<String> mobileScreenshots = new LinkedList<>();


    public LinkedList<String> getDesktopScreenshots() {
        return desktopScreenshots;
    }

    public LinkedList<String> getMobileScreenshots() {
        return mobileScreenshots;
    }


    public void setLog(Log log) {
        this.log = log;
    }

    public void setLogName(String logName) {
        log.setLogName(logName);
    }

    // append mobile screenshots to desktopscreenshots for output log
    public void saveLog(String savePath) {
        desktopScreenshots.addAll(mobileScreenshots);
        log.setList(desktopScreenshots);
        log.save(savePath);
    }

    public void full(WebDriver driver, boolean ifDesktop, String path, String screenshotName)  {
        fullScreenshot(driver, ifDesktop, path, screenshotName, null, 0L);
        File outputImg = new File(path + "/" + screenshotName + ".png");
        if (ifDesktop)
            desktopScreenshots.add(outputImg.getAbsolutePath());
        else
            mobileScreenshots.add(outputImg.getAbsolutePath());
    }

    // click element before after resizing window
    public void full(WebDriver driver, boolean ifDesktop, String path, String screenshotName, WebElement e, Long time){
        fullScreenshot(driver, ifDesktop, path, screenshotName, e, time);
        File outputImg = new File(path + "/" + screenshotName + ".png");
        if (ifDesktop)
            desktopScreenshots.add(outputImg.getAbsolutePath());
        else
            mobileScreenshots.add(outputImg.getAbsolutePath());
    }

    public void visible(WebDriver driver, boolean ifDesktop, String path, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File outputImg = new File(path + "/" + screenshotName + ".png");
            FileUtils.copyFile(source, outputImg);
            if (ifDesktop)
                desktopScreenshots.add(outputImg.getAbsolutePath());
            else
                mobileScreenshots.add(outputImg.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Exception while taking visible part screenshot" + e.getMessage());
        }
    }

    // uses javascript to click the element, even if its not visible
    public static void forceClick(WebDriver driver, String xpath){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
    }

    public static void forceClick(WebDriver driver, WebElement e){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
    }

    protected int getDocWidth(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return Math.max(document.body.scrollWidth, document.body.offsetWidth, document.documentElement.clientWidth, document.documentElement.scrollWidth, document.documentElement.offsetWidth);");
        return Math.toIntExact(result);
    }

    protected int getDocHeight(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        long result = (Long) jse.executeScript("return document.body.scrollHeight");
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

    protected void scrollBy(WebDriver driver, int x, int y) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
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
    protected void fullScreenshot(WebDriver driver, boolean ifDesktop, String location, String fileName, WebElement element, long time) {

        int xPos = getCurrentScrollX(driver);
        int yPos = getCurrentScrollY(driver);

        File screenshotFile = new File(location);
        if (!screenshotFile.exists()) {
            screenshotFile.mkdirs();
        }
        File outputImg = new File(location + "/" + fileName + ".png");

        if (ifDesktop) {
            FileUtil.writeImage(takeScreenshotEntirePage(driver, true, element, time), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        } else {
            FileUtil.writeImage(takeScreenshotEntirePage(driver, false, element, time), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, MOBILE_HEIGHT));
        }

        // scroll to the previous position before resize
        scrollTo(driver, xPos, yPos);
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


    // create tab and wait for tab to be available
    private void createTab(WebDriver driver, String url){
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", url);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public static void waitForPageLoad(WebDriver driver){
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private BufferedImage takeScreenshotEntirePage(WebDriver driver, boolean isDesktop, WebElement e, long sleepTime) {

        int scaleFactor = isDesktop ? 1 : getMobileScaleFactor();

        int _docWidth = isDesktop ? DESKTOP_WIDTH : MOBILE_WIDTH;
        int _docHeight = getDocHeight(driver);

        // resize if using scroll-stitch method
        if(_docHeight > CHROME_HEIGHT_CAP) {
            driver.manage().window().setSize(new Dimension(_docWidth, CHROME_HEIGHT_CAP));
        }
        else
            driver.manage().window().setSize(new Dimension(_docWidth, _docHeight));

        //click item after resizing window
        _docHeight = clickAfterResizedWindow(driver, e, sleepTime);

        // scroll-stitch
        if(_docHeight > CHROME_HEIGHT_CAP || scaleFactor > 1){

            int viewport = CHROME_HEIGHT_CAP;

            // scaled display misses content when sized to the chrome cap, the driver struggles to capture large resolution images
            if(scaleFactor > 1) {
                viewport = 2000; // larger values tend to not capture as much
                driver.manage().window().setSize(new Dimension(_docWidth, viewport));
                _docHeight = clickAfterResizedWindow(driver, e, sleepTime);
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
                    clickAfterResizedWindow(driver, e, sleepTime);
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

    private int clickAfterResizedWindow(WebDriver driver, WebElement e, long sleepTime) {
        if (e != null) {
            try {
                Actions builder = new Actions(driver);
                builder.moveToElement(e, 5, 5).click().build().perform();
            } catch (Exception ex) {
                forceClick(driver, e);
            }
            try {
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
        String curr = driver.getCurrentUrl();
        String[] arr = curr.split("/");
        if (arr[3].equals("patient")) {
            if (isDesktop) {
                driver.findElement(By.cssSelector(".gene-component--header__audience .gene-component--audience__item--hcp .gene-component--audience__link")).click();
            } else {
                driver.findElement(By.cssSelector(".gene-component--header__navigation .gene-component--audience__item--hcp .gene-component--audience__link")).click();
            }
            Thread.sleep(1000);
            visible(driver, isDesktop, savePath, prefix + "-modal-HCP");
        }
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
