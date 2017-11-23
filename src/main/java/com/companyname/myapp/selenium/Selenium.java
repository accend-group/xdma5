package com.companyname.myapp.selenium;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


//webdriver wrapper class, currently set to chrome webdriver
public class Selenium {

    private static final boolean IS_FIREFOX = false;

    private int [] browserDimensions = new int[2];
    private WebDriver driver;
    private Actions userAction;
    public JavascriptExecutor jse;
    private boolean isMobile = false;
    private boolean browserRunning = false;

    private boolean isRemote = false;
    private String remoteServerURL;

    // used for drag and drop
    private String source, destination;
    private Boolean replayOn = false, dragAndDropEnabled = false;
    private final String dragAndDropScript = "window.__recordUtils_getElementByXpath=function(e){return document.evaluate(e,document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue},window.__recordUtils_getXPath=function(e){for(var n=[];e&&e.nodeType==Node.ELEMENT_NODE;e=e.parentNode){for(var o=0,i=!1,l=e.previousSibling;l;l=l.previousSibling)l.nodeType!=Node.DOCUMENT_TYPE_NODE&&l.nodeName==e.nodeName&&++o;for(l=e.nextSibling;l&&!i;l=l.nextSibling)l.nodeName==e.nodeName&&(i=!0);var t=(e.prefix?e.prefix+\":\":\"\")+e.localName,r=o||i?\"[\"+(o+1)+\"]\":\"\";n.splice(0,0,t+r)}return n.length?\"/\"+n.join(\"/\"):null};" + "/**\n" +
            " * Drag and drop\n" +
            " */\n" +
            "// https://github.com/andywer/drag-mock\n" +
            "!function t(e,r,n){function a(i,u){if(!r[i]){if(!e[i]){var s=\"function\"==typeof require&&require;if(!u&&s)return s(i,!0);if(o)return o(i,!0);var c=new Error(\"Cannot find module '\"+i+\"'\");throw c.code=\"MODULE_NOT_FOUND\",c}var f=r[i]={exports:{}};e[i][0].call(f.exports,function(t){var r=e[i][1][t];return a(r?r:t)},f,f.exports,t,e,r,n)}return r[i].exports}for(var o=\"function\"==typeof require&&require,i=0;i<n.length;i++)a(n[i]);return a}({1:[function(t,e,r){var n=t(\"./src/index.js\");\"function\"==typeof define&&define(\"dragMock\",function(){return n}),window.dragMock=n},{\"./src/index.js\":5}],2:[function(t,e,r){function n(t,e){var r=t.indexOf(e);r>=0&&t.splice(r,1)}var a=function(){this.dataByFormat={},this.dropEffect=\"none\",this.effectAllowed=\"all\",this.files=[],this.types=[]};a.prototype.clearData=function(t){t?(delete this.dataByFormat[t],n(this.types,t)):(this.dataByFormat={},this.types=[])},a.prototype.getData=function(t){return this.dataByFormat[t]},a.prototype.setData=function(t,e){return this.dataByFormat[t]=e,this.types.indexOf(t)<0&&this.types.push(t),!0},a.prototype.setDragImage=function(){},e.exports=a},{}],3:[function(t,e,r){function n(){}function a(t,e,r){if(\"function\"==typeof e&&(r=e,e=null),!t||\"object\"!=typeof t)throw new Error(\"Expected first parameter to be a targetElement. Instead got: \"+t);return{targetElement:t,eventProperties:e||{},configCallback:r||n}}function o(t,e,r){e&&(e.length<2?r&&e(t):e(t,t.type))}function i(t,e,r,n,a,i){e.forEach(function(e){var s=u.createEvent(e,a,n),c=e===r;o(s,i,c),t.dispatchEvent(s)})}var u=t(\"./eventFactory\"),s=t(\"./DataTransfer\"),c=function(){this.lastDragSource=null,this.lastDataTransfer=null,this.pendingActionsQueue=[]};c.prototype._queue=function(t){this.pendingActionsQueue.push(t),1===this.pendingActionsQueue.length&&this._queueExecuteNext()},c.prototype._queueExecuteNext=function(){if(0!==this.pendingActionsQueue.length){var t=this,e=this.pendingActionsQueue[0],r=function(){t.pendingActionsQueue.shift(),t._queueExecuteNext()};0===e.length?(e.call(this),r()):e.call(this,r)}},c.prototype.dragStart=function(t,e,r){var n=a(t,e,r),o=[\"mousedown\",\"dragstart\",\"drag\"],u=new s;return this._queue(function(){i(n.targetElement,o,\"drag\",u,n.eventProperties,n.configCallback),this.lastDragSource=t,this.lastDataTransfer=u}),this},c.prototype.dragEnter=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseover\",\"dragenter\"];return this._queue(function(){i(n.targetElement,o,\"dragenter\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.dragOver=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseover\",\"dragover\"];return this._queue(function(){i(n.targetElement,o,\"drag\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.dragLeave=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseover\",\"dragleave\"];return this._queue(function(){i(n.targetElement,o,\"dragleave\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.drop=function(t,e,r){var n=a(t,e,r),o=[\"mousemove\",\"mouseup\",\"drop\"],u=[\"dragend\"];return this._queue(function(){i(n.targetElement,o,\"drop\",this.lastDataTransfer,n.eventProperties,n.configCallback),this.lastDragSource&&i(this.lastDragSource,u,\"drop\",this.lastDataTransfer,n.eventProperties,n.configCallback)}),this},c.prototype.then=function(t){return this._queue(function(){t.call(this)}),this},c.prototype.delay=function(t){return this._queue(function(e){window.setTimeout(e,t)}),this},e.exports=c},{\"./DataTransfer\":2,\"./eventFactory\":4}],4:[function(t,e,r){function n(t,e){for(var r in e)e.hasOwnProperty(r)&&(t[r]=e[r]);return t}function a(t,e,r){\"DragEvent\"===e&&(e=\"CustomEvent\");var a=window[e],o={view:window,bubbles:!0,cancelable:!0};n(o,r);var i=new a(t,o);return n(i,r),i}function o(t,e,r){var a;switch(e){case\"MouseEvent\":a=document.createEvent(\"MouseEvent\"),a.initEvent(t,!0,!0);break;default:a=document.createEvent(\"CustomEvent\"),a.initCustomEvent(t,!0,!0,0)}return r&&n(a,r),a}function i(t,e,r){try{return a(t,e,r)}catch(n){return o(t,e,r)}}var u=t(\"./DataTransfer\"),s=[\"drag\",\"dragstart\",\"dragenter\",\"dragover\",\"dragend\",\"drop\",\"dragleave\"],c={createEvent:function(t,e,r){var n=\"CustomEvent\";t.match(/^mouse/)&&(n=\"MouseEvent\");var a=i(t,n,e);return s.indexOf(t)>-1&&(a.dataTransfer=r||new u),a}};e.exports=c},{\"./DataTransfer\":2}],5:[function(t,e,r){function n(t,e,r){return t[e].apply(t,r)}var a=t(\"./DragDropAction\"),o={dragStart:function(t,e,r){return n(new a,\"dragStart\",arguments)},dragEnter:function(t,e,r){return n(new a,\"dragEnter\",arguments)},dragOver:function(t,e,r){return n(new a,\"dragOver\",arguments)},dragLeave:function(t,e,r){return n(new a,\"dragLeave\",arguments)},drop:function(t,e,r){return n(new a,\"drop\",arguments)},delay:function(t,e,r){return n(new a,\"delay\",arguments)},DataTransfer:t(\"./DataTransfer\"),DragDropAction:t(\"./DragDropAction\"),eventFactory:t(\"./eventFactory\")};e.exports=o},{\"./DataTransfer\":2,\"./DragDropAction\":3,\"./eventFactory\":4}]},{},[1]);\n" +
            "\n";

    static{
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        //System.setProperty("webdriver.gecko.driver", "geckodriver");
    }

    private static String URLtoFileName(String url) {
        return url.replaceAll("http://", "").replaceAll("https://", "").replaceAll("/", ".");
    }

    public Selenium(){}
    public Selenium(int width, int height){
        browserDimensions[0] = width;
        browserDimensions[1] = height;
    }

    public void setRemoteServer(String url){
        remoteServerURL = url;
        isRemote = true;
    }

    // start local browser if isRemote is false it creates a local browser session else it connects to a remote selenium server
    public void start(boolean ifMobile){
        browserRunning = true;
        this.isMobile = ifMobile;
        if(ifMobile) {
            browserDimensions[0] = 320;
            browserDimensions[1] = 720;
            // firefox mobile
            if(IS_FIREFOX){
                if(isRemote){
                    try {
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        driver = new RemoteWebDriver(new URL(remoteServerURL), capabilities);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                } else {
                    driver = new FirefoxDriver();
                }
                driver.manage().window().setSize(new Dimension(browserDimensions[0], browserDimensions[1]));
            } else { // chrome mobile

                // setup mobile chrome driver
                Map<String, Object> mobileMetrics = new HashMap<>();
                mobileMetrics.put("width", browserDimensions[0]);
                mobileMetrics.put("height", browserDimensions[1]);
                mobileMetrics.put("pixelRatio", 1.0);
                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", mobileMetrics);
                mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("mobileEmulation", mobileEmulation);

                if(isRemote){
                    try {
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                        driver = new RemoteWebDriver(new URL(remoteServerURL), capabilities);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                } else {
                    driver = new ChromeDriver(options);
                }
            }
        }else{
            browserDimensions[0] = 1600;
            browserDimensions[1] = 1200;
            // firefox desktop
            if(IS_FIREFOX){
                if(isRemote){
                    try {
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        driver = new RemoteWebDriver(new URL(remoteServerURL), capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    driver = new FirefoxDriver();
                }
            } else { // chrome desktop
                if (isRemote) {
                    try {
                        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                        driver = new RemoteWebDriver(new URL(remoteServerURL), capabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else
                    driver = new ChromeDriver();
            }
            driver.manage().window().setSize(new Dimension(browserDimensions[0], browserDimensions[1]));
        }
        userAction = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }


    // TODO fix, not working as intended
    public WebElement getElementFromPoint(int x, int y){

        try {
            return (WebElement) jse.executeScript("return document.elementFromPoint(arguments[0] - window.scrollX, arguments[1] - window.scrollY);", x, y);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void scroll(WebElement element, int scrollX, int scrollY){
        jse.executeScript("if(!arguments[0]) window.scroll(arguments[1], arguments[2]); else{ var element = arguments[0]; element.scrollLeft = arguments[1]; element.scrollTop = arguments[2]; console.log(element);}",
               element, scrollX, scrollY);
    }


    // not working?
    public void scroll(int elementX, int elementY, int scrollX, int scrollY){
        jse.executeScript("if(arguments[0] == -1 && arguments[1] == -1) window.scroll(arguments[2], arguments[3]); else{ var element = document.elementFromPoint(arguments[0], arguments[1]); element.scrollLeft = arguments[2]; element.scrollTop = arguments[3]; console.log(element);}",
                elementX, elementY, scrollX, scrollY);
    }

    public void get(String url){
        driver.get(url);

    }

    public void click(){
        userAction.click().perform();
    }

    public void doubleClick(){
        userAction.doubleClick().build().perform();
    }


    // x,y being the viewport coordinates
    public void mouseMoveTo(int x, int y){
        // uses head tag for (0,0) starting point
        // x,y being offset values for moveToElement relative to head tag which is (0,0)
        if(IS_FIREFOX)
            userAction.moveToElement(((FirefoxDriver)driver).findElementByXPath("/html/head"),x, y).build().perform();
        else
            userAction.moveToElement(((ChromeDriver)driver).findElementByXPath("/html/head"),x, y).build().perform();
    }

    public void typeKeys(String input){
        userAction.sendKeys(input).perform();
    }

    private String correctImgNameFormat(String imgName){
        if(imgName == null) {
            String url = driver.getCurrentUrl();
            System.out.println(url);
            imgName = URLtoFileName(url);
            imgName = imgName.replaceAll("[\\*\\/\\|\\?><:\"]","");
            imgName = imgName.charAt(imgName.length() - 1) == '.' ? imgName.substring(0, imgName.length() - 1) : imgName;
        }
        return imgName;
    }

    public BufferedImage getFullPageScreenshot(){
        return Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,400, true).getImage();
    }

    public void saveFullPageScreenshot(String imgName){
        imgName = correctImgNameFormat(imgName);
        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,400, true)
                .withName(imgName)
                .save(isMobile ? "screenshots/entirePage/mobile/" : "screenshots/entirePage/desktop/");
    }

    public BufferedImage getVisibleScreenshot(){
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            return ImageIO.read(new ByteArrayInputStream(ts.getScreenshotAs(OutputType.BYTES)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveVisibleScreenshot(String imgName){
        try {
            // give it time to load the page
            new WebDriverWait(driver, 10).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            //Thread.sleep(500);
            if(imgName == null) {
                String url = driver.getCurrentUrl();
                System.out.println(url);
                imgName = URLtoFileName(url).replaceAll("[\\*\\/\\|\\?><:\"]","");;
            }
            String path = isMobile ? "screenshots/visible/mobile/" : "screenshots/visible/desktop/";
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File((path + imgName + ".png").replace("..", ".")));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void waitFor(long mil){
        driver.manage().timeouts().implicitlyWait(mil, TimeUnit.MILLISECONDS);
    }

    public Object runJS(String script){
        return jse.executeScript(script);
    }

    public void stop(){
        browserRunning = false;
        isRemote = false;
        if(driver != null) {
           // driver.close();
            driver.quit();
        }
    }

    // hold mouse click button at current mouse position
    public void mouseClickAndHold(){
        userAction.clickAndHold().build().perform();
    }

    public void mouseHoldAndMove(int x, int y){
        if(IS_FIREFOX)
            userAction.moveToElement(((FirefoxDriver)driver).findElementByXPath("/html/head"),x, y);
        else
            userAction.moveToElement(((ChromeDriver)driver).findElementByXPath("/html/head"),x, y);
    }

    public void setReplay(boolean isReplay){
        replayOn = isReplay;
        if(!replayOn)
            dragAndDropEnabled = false;
    }

    public void addDragSource(String source){
        this.source = source;
    }

    public void addDragDestination(String dest){
        this.destination = dest;
        //System.out.println(source.getAttribute("draggable") + " " + destination.getAttribute("draggable"));
        if(!dragAndDropEnabled) {
            jse.executeScript(dragAndDropScript);
        }
        jse.executeScript("var source = window.__recordUtils_getElementByXpath(arguments[0]); var dest = window.__recordUtils_getElementByXpath(arguments[1]); dragMock.dragStart(source).drop(dest);", source, destination);

        //userAction.dragAndDrop(source, destination).build().perform();
    }

    /*public void dragAndDrop(){
        userAction.dragAndDropBy(driver.findElement(By.xpath("")), )
    }*/

    public void mouseUp(){
        userAction.build().perform();
        userAction.release().build().perform();
    }



    public void setSize(int width, int height){
        browserDimensions[0] = width;
        browserDimensions[1] = height;
    }

    public boolean isBrowserRunning(){
        return browserRunning;
    }

    public void refreshCurrentPage(){
        driver.navigate().refresh();
        runJS("window.scroll(0,0);");
        //driver.get(driver.getCurrentUrl());
    }

    public WebDriver getDriver(){
        return driver;
    }

    public JavascriptExecutor getJse() {
        return jse;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
}
