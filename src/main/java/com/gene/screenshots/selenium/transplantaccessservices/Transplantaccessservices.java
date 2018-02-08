package com.gene.screenshots.selenium.transplantaccessservices;

import com.gene.screenshots.selenium.ChromeDriverManager;
import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.ArrayList;
import java.util.List;

public class Transplantaccessservices extends SeleniumHeadless {

    public String getSiteMapUrl(){
        return "/site-map";
    }

    public String getSiteMapSelector(){
        return "#mainContent a:not([href*='.pdf']):not([href*='.doc']):not([href*='mygtasconnection.com']):not([href*='gene.com']):not([href*='#'])";
    }

    public List<Thread> desktopAutomationTest() {

        WebDriver driver = ChromeDriverManager.requestDesktopDriver();
        List<String> links = getLinksFromSiteMap(driver);
        setNumberOfPageVisits(links.size(), true);
        ChromeDriverManager.releaseDesktopDriver(driver);

        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < links.size(); ++i) {
            final int currentPageIndex = i;
            final String currentPage = links.get(i);
            threads.add(new Thread(() -> {
                WebDriver threadDriver = ChromeDriverManager.requestDesktopDriver();
                    goToUrl(threadDriver, currentPage);
                    full(threadDriver, true, currentPageIndex);
                ChromeDriverManager.releaseDesktopDriver(threadDriver);
            }));
        }
        return threads;
    }

    public List<Thread> mobileAutomationTest(){
        return null;
    }
}
