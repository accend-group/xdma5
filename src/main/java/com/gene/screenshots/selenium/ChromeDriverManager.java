package com.gene.screenshots.selenium;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

// Manages chrome driver access for desktop and mobile driver requests
// creates the desktop and mobile drivers
public class ChromeDriverManager {
    private static ConcurrentLinkedQueue<WebDriver> freeMobileDrivers = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<WebDriver> freeDesktopDrivers = new ConcurrentLinkedQueue<>();

    private static Semaphore desktopThreadLock;
    private static Semaphore mobileThreadLock;

    public ChromeDriverManager(int threadLimit){
        int desktopThreadsLimit = 1, mobileThreadsLimit = 1;
        if(threadLimit > 2){
            desktopThreadsLimit = threadLimit / 2;
            mobileThreadsLimit = threadLimit % 2 + desktopThreadsLimit;
        }
        desktopThreadLock = new Semaphore(desktopThreadsLimit, true);
        mobileThreadLock = new Semaphore(mobileThreadsLimit, true);
        for(int i = 0; i < desktopThreadsLimit; ++i)
            freeDesktopDrivers.add(SeleniumHeadless.makeDesktopDriver());
        for(int i = 0; i < mobileThreadsLimit; ++i)
            freeMobileDrivers.add(SeleniumHeadless.makeMobileDriver());
    }

    public static void killAll(){
        freeDesktopDrivers.iterator().forEachRemaining( x -> {x.quit();} );
        freeMobileDrivers.iterator().forEachRemaining( x -> {x.quit();} );
    }

    public static WebDriver requestDriver(boolean isDesktop){
        return isDesktop ? requestDesktopDriver() : requestMobileDriver();
    }

    public static void releaseDriver(WebDriver driver, boolean isDesktop){
        if(isDesktop)
            ChromeDriverManager.releaseDesktopDriver(driver);
        else
            ChromeDriverManager.releaseMobileDriver(driver);
    }

    public static WebDriver requestDesktopDriver(){
        try{
            desktopThreadLock.acquire();
            return freeDesktopDrivers.poll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void releaseDesktopDriver(WebDriver driver){
        freeDesktopDrivers.add(driver);
        desktopThreadLock.release();
    }

    public static WebDriver requestMobileDriver(){
        try{
            mobileThreadLock.acquire();
            return freeMobileDrivers.poll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void releaseMobileDriver(WebDriver driver){
        freeMobileDrivers.add(driver);
        mobileThreadLock.release();
    }
}
