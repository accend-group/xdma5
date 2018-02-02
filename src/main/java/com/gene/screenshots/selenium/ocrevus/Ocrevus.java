package com.gene.screenshots.selenium.ocrevus;

import com.gene.screenshots.selenium.ChromeDriverManager;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ocrevus extends SeleniumHeadless {
    // sitemap doesn't exist
    @Override
    public String getSiteMapUrl() {
        return null;
    }

    @Override
    public String getSiteMapSelector() {
        return null;
    }

    @Override
    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        links.add( "/index.html");
        links.add("/ocrelizumab-safety-resources.html");
        links.add("/faq.html");
        links.add("/glossary.html");
        return links;
    }

    // handles the hcp and third party modal from the index page
    private void modals(WebDriver driver, boolean isDesktop, String savePath){
        if(driver.getCurrentUrl().contains("index.html")) {

            // wait for modal
            waitForElementVisible(driver, ".gene-component--modal.gene-component--modal--interstitial.is-active");
            // wait for fade in animation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            visible(driver, isDesktop, savePath, "hcp_modal");

            // close hcp modal
            driver.findElement(By.cssSelector("[style='display: block;'] .gene-component--modal__button.gene-component--modal__button--confirm")).click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // click third party modal
            driver.findElement(By.cssSelector("[href*='fda.gov']:not(.gene-component--button)")).click();
            waitForElementVisible(driver,".gene-component--modal.gene-component--modal--third-party.is-active");
            // wait for animation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            visible(driver, isDesktop, savePath, "third_party_link");

            // remove hcp modal
            driver.navigate().refresh();
            waitForPageLoad(driver);
            waitForElementVisible(driver, ".gene-component--modal.gene-component--modal--interstitial.is-active");
            // fade in
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(By.cssSelector("[style='display: block;'] .gene-component--modal__button.gene-component--modal__button--confirm")).click();
            // fade out
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Thread> createScreenCaptureThreads(String savePath, boolean isDesktop){
        List<Thread> threads = new LinkedList<>();
        threads.add(new Thread( ()-> {
            WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
            try {
                int pageCount = 0;
                List<String> links = getLinksFromSiteMap(driver);
                for (String link : links) {
                    goToUrl(driver, link);
                    modals(driver, isDesktop, savePath);
                    full(driver, isDesktop, savePath, String.valueOf(pageCount++));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ChromeDriverManager.releaseDriver(driver, isDesktop);
        }));
        return threads;
    }
}
