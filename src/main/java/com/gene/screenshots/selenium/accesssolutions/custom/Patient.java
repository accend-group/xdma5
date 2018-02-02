package com.gene.screenshots.selenium.accesssolutions.custom;

import com.gene.screenshots.selenium.ChromeDriverManager;
import com.gene.screenshots.selenium.accesssolutions.AccessSolutionsBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Patient extends AccessSolutionsBase {

    @Override
    public String getSiteMapUrl() {
        return null;
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        links.add("/patient.html");
        // the pages are gone
        //links.add("/patient/home.html");
        //links.add("/patient/home/patient-assistance-tool-page.html");
        links.add("/patient/search.html");
        links.add("/patient/pan.html");
        links.add("/patient/biooncology.html");
        links.add("/patient/rheumatology.html");
        links.add("/patient/contact-us.html");
        return links;
    }

    private void visibleScreensOfModals(WebDriver driver, boolean ifDesktop, String savePath) {
        if (!driver.getCurrentUrl().contains("/patient.html"))
            return;

        driver.findElement(By.id("select-treatment")).click();
        waitForElementVisible(driver, ".dropdown.open");
        visible(driver, ifDesktop, savePath, "accesssolutions-patient-select-treatment");


        setStyle(driver, "display: block;", "#product-selector");
        visible(driver, ifDesktop, savePath, "accesssolutions-patient-product-popup");
        setStyle(driver, "display: none;", "#product-selector");

        setStyle(driver, "display: block;", "#sub-indications-selector");
        setStyle(driver, "display: block;", "#sub-indications-selector .sub-indication-list");
        visible(driver, ifDesktop, savePath, "accesssolutions-patient-rituxan-popup");
        setStyle(driver, "display: none;", "#sub-indications-selector");
        setStyle(driver, "display: none;", "#sub-indications-selector .sub-indication-list");

        List<WebElement> hcpModalLink = driver.findElements(By.cssSelector("[href*='/hcp.html']"));
        if(hcpModalLink.size() > 0){

        forceClick(driver, hcpModalLink.get(0));
        waitForElementVisible(driver, "[class='hcp-modal modal fade in']");
        // wait for fade in animation to complete
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        visible(driver, ifDesktop, savePath, "accesssolutions-patient-hcp-modal");
        }
        driver.navigate().refresh();
        waitForPageLoad(driver);
    }


    // small number of pages and events per page so using single thread
    @Override
    public List<Thread> createScreenCaptureThreads(String savePath, boolean isDesktop){
        List<Thread> threads = new LinkedList<>();
        threads.add(new Thread(() -> {
            WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
            try {
                List<String> links = getLinksFromSiteMap(driver);
                int pageNumber = 1;
                for (String currentPage : links) {
                    goToUrl(driver, currentPage);
                    full(driver, isDesktop, savePath, String.valueOf(pageNumber++));
                    visibleScreensOfModals(driver, isDesktop, savePath);
                }
            } catch (Exception e) {
                System.out.println("Issue at " + driver.getCurrentUrl() + " for " + (isDesktop ? "desktop" : "mobile"));
                e.printStackTrace();
            }
            ChromeDriverManager.releaseDriver(driver, isDesktop);
        }));
        return threads;
    }

}
