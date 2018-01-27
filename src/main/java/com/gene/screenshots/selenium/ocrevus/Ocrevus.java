package com.gene.screenshots.selenium.ocrevus;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Ocrevus extends SeleniumHeadless {


    public List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        // because sitemap doesn't exist
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
            driver.findElement(By.cssSelector("[href='https://www.accessdata.fda.gov/scripts/cder/pmc/index.cfm']")).click();
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
    public void desktopAutomationTest(String savePath){
        WebDriver driver = makeDesktopDriver();
        try{
            int pageCount = 0;
            List<String> links = getLinksFromSiteMap(driver);
            for(String link : links) {
                goToUrl(driver, link);
                waitForPageLoad(driver);
                modals(driver, true, savePath);
                full(driver, true, savePath, String.valueOf(pageCount++));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        try {
            int pageCount = 0;
            List<String> links = getLinksFromSiteMap(driver);
            for (String link : links) {
                goToUrl(driver, link);
                waitForPageLoad(driver);
                modals(driver, false, savePath);
                full(driver, false, savePath, String.valueOf(pageCount++));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
