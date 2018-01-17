package com.gene.screenshots.selenium;



import com.assertthat.selenium_shutterbug.utils.file.FileUtil;
import com.assertthat.selenium_shutterbug.utils.web.UnableTakeSnapshotException;
import com.gene.screenshots.pdf.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import static com.gene.screenshots.selenium.Constants.*;
import static java.lang.Math.toIntExact;

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
        return toIntExact(result);
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
            FileUtil.writeImage(takeScreenshotEntirePage(driver, DESKTOP_WIDTH, element, time), "PNG", outputImg);
            driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
        } else {
            FileUtil.writeImage(takeScreenshotEntirePage(driver, MOBILE_WIDTH, element, time), "PNG", outputImg);
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

    private BufferedImage takeScreenshotEntirePage(WebDriver driver, int width, WebElement e, long sleepTime) {

        int _docWidth = width;//getDocWidth(driver);
        int _docHeight = getDocHeight(driver);

        // create tab and visit current url to get the correct browser max height
        if(_docHeight > CHROME_HEIGHT_CAP) {
            String currentUrl = driver.getCurrentUrl();
            createTab(driver, currentUrl);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.manage().window().setSize(new Dimension(_docWidth, CHROME_HEIGHT_CAP));
            driver.get(currentUrl);

            // wait for page to load on new tab
            waitForPageLoad(driver);
            int otherHeight = getDocHeight(driver);

            // in the case the previous tab had dynamically height changing events the new tab doesn't have
            if(otherHeight > _docHeight)
                _docHeight = otherHeight;
            driver.close();

            driver.switchTo().window(tabs.get(0));
            driver.manage().window().setSize(new Dimension(_docWidth, CHROME_HEIGHT_CAP));
        }
        else
            driver.manage().window().setSize(new Dimension(_docWidth, _docHeight));


        //click item after resizing window
        if(e != null) {
            try {
                Actions builder = new Actions(driver);
                builder.moveToElement(e, 5,5).click().build().perform();
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

        // scroll-stitch
        if(_docHeight > CHROME_HEIGHT_CAP){
            // ===================== SHUTTERBUG code modified =====================================
            scrollTo(driver, 0, 0);
            BufferedImage finalImage = new BufferedImage(_docWidth, _docHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D scrollPicsSticthed = finalImage.createGraphics();
            int leftover = (int) Math.ceil(((double) getDocHeight(driver)) / CHROME_HEIGHT_CAP);
            for(int i = 0; i < leftover; ++i){
                scrollTo(driver, 0, i * CHROME_HEIGHT_CAP);
                try {
                    Thread.sleep(350);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                BufferedImage viewPortImg = takeScreenshot(driver);
                scrollPicsSticthed.drawImage(viewPortImg, 0, getCurrentScrollY(driver), null);
            }
            scrollPicsSticthed.dispose();
            return finalImage;
            // ===================== SHUTTERBUG code modified =====================================
        }

        // else take entire window size for fullpage screenshot
        return takeScreenshot(driver);
    }
}
