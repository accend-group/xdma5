package com.gene.screenshots.selenium.her2treatment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class Her2treatment extends SeleniumHeadless{
    public void desktopAutomationTest(String savePath) {
		
        WebDriver driver = makeDesktopDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
		
        try {
		
            goToUrl(driver, "/index.html");
            visible(driver, true, savePath, "her2treatment-visible-0.0-herceptin");
            
            driver.findElement(By.linkText("PERJETA®")).click();
            visible(driver, true, savePath, "her2treatment-visible-0.0-perjeta");
            
            driver.findElement(By.linkText("KADCYLA®")).click();
            visible(driver, true, savePath, "her2treatment-visible-0.0-kadcyla");
            
            goToUrl(driver, "/index.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-0.0-herceptin");
            	
            full(driver, true, savePath, "her2treatment-0.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));
            
            full(driver, true, savePath, "her2treatment-0.0-kadcyla", driver.findElement(By.linkText("KADCYLA®")), new Long(1000));

            driver.navigate().refresh();
            Thread.sleep(1000);
            forceClick(driver, driver.findElement(By.linkText("http://www.fda.gov/medwatch")));
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-link-thirdparty-modal");
            
            driver.navigate().refresh();
            driver.findElement(By.linkText("Resources for Nurses")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-3.0-modal");
            
            driver.navigate().refresh();
            driver.findElement(By.className("share-a-page-button")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-share-modal");
            
            driver.findElement(By.cssSelector("#share-a-page-riker-form > div.modal-footer > div > input")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-share-modal-submit-missing");
            
            driver.findElement(By.name("fname")).sendKeys("marwin");;
            driver.findElement(By.name("lname")).sendKeys("nicolas");;
            driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.cssSelector("#share-a-page-riker-form > div.modal-footer > div > input")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-share-modal-submit");
            
            goToUrl(driver, "/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-0.0-safety-herceptin");
            
            driver.findElement(By.linkText("PERJETA®")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-0.0-safety-perjeta");
            
            driver.findElement(By.linkText("KADCYLA®")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-0.0-safety-kadcyla");
            
            goToUrl(driver, "/what-is-her2-positive-breast-cancer.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-1.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-2.0-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-2.0-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-2.0-kadcyla");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0-safety-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0-safety-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0-kadcyla");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-2.0-safety-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-3.0-herceptin");
            
            driver.findElement(By.linkText("PERJETA®")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-3.0-perjeta");
            
            driver.findElement(By.linkText("KADCYLA®")).click();
            Thread.sleep(1000);
            visible(driver, true, savePath, "her2treatment-visible-3.0-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-herceptin");
            
            full(driver, true, savePath, "her2treatment-3.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));
            
            full(driver, true, savePath, "her2treatment-3.0-kadcyla", driver.findElement(By.linkText("KADCYLA®")), new Long(1000));
            
            goToUrl(driver, "/breast-cancer-nurse-resources/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-safety-herceptin");
            
            driver.findElement(By.linkText("PERJETA®")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-safety-perjeta");
            
            driver.findElement(By.linkText("KADCYLA®")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-safety-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            Thread.sleep(1000);
            forceClick(driver, "/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown");
            
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[1]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-1");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-1-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[3]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-1-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[4]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");	
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[2]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-2");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-2-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[5]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[3]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-3");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-3-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[6]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[4]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-4");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-4-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[7]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[5]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-5");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-5-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[8]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-5-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[9]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            Thread.sleep(1000);
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[6]");
            full(driver, true, savePath, "her2treatment-3.0-dropdown-6");
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[7]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-7");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-7-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[11]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-7-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[12]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[8]");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-3.0-dropdown-8");
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-8-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[13]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-8-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[14]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-8-3", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[15]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-8-4", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[16]/div[1]/a")), new Long(2000));
            
            full(driver, true, savePath, "her2treatment-3.0-dropdown-8-5", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[17]/div[1]/a")), new Long(2000));
            
            goToUrl(driver, "/breast-cancer-nurse-resources/contact-a-genentech-nurse-educator.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-genentech-nurse-educator");
            
            driver.findElement(By.xpath("//*[@id='riker-form']/div[13]/input")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-genentech-nurse-educator-error-msg");
            
            goToUrl(driver, "/her2-positive-breast-cancer-glossary.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-glossary");
            
            goToUrl(driver, "/user-sitemap.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-sitemap");
            
            goToUrl(driver, "/breast-cancer-treatment-prescribing-information.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-prescribing-info");
            
            goToUrl(driver, "/errorpage.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "her2treatment-errorpage");

		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
	}
	@Override
	public void mobileAutomationTest(String savePath) {
		
	    WebDriver driver = makeMobileDriver();
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
        try {
			
            goToUrl(driver, "/index.html");
            visible(driver, false, savePath,  "her2treatment-mobile-home");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/button")).click();
            visible(driver, false, savePath,  "her2treatment-mobile-menu");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[3]/a")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "her2treatment-mobile-3.0-modal");
            
            driver.navigate().refresh();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(1000);
            driver.findElement(By.linkText("http://www.fda.gov/medwatch")).click();
            js.executeScript("window.scrollTo(0, 0)");
            Thread.sleep(1000);
            visible(driver, false, savePath,  "her2treatment-mobile-link-thirdparty-modal");
            
            driver.navigate().refresh();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-herceptin");
            	
            full(driver, false, savePath, "her2treatment-mobile-0.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));
            
            full(driver, false, savePath, "her2treatment-mobile-0.0-kadcyla", driver.findElement(By.linkText("KADCYLA®")), new Long(1000));
            
            goToUrl(driver, "/safety.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-safety-herceptin");
            
            driver.findElement(By.linkText("PERJETA®")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-safety-perjeta");
            
            driver.findElement(By.linkText("KADCYLA®")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-0.0-safety-kadcyla");
            
            goToUrl(driver, "/what-is-her2-positive-breast-cancer.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-1.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-2.0");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-2.0-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/herceptin/safety.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-2.0-safety-herceptin");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-2.0-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/perjeta/safety.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-2.0-safety-perjeta");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-2.0-kadcyla");
            
            goToUrl(driver, "/her2-positive-breast-cancer-treatments/kadcyla/safety.html");
            full(driver, false, savePath, "her2treatment-mobile-2.0-safety-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-herceptin");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-perjeta", driver.findElement(By.linkText("PERJETA®")), new Long(1000));
    
            full(driver, false, savePath, "her2treatment-mobile-3.0-kadcyla", driver.findElement(By.linkText("KADCYLA®")), new Long(1000));
       
            goToUrl(driver, "/breast-cancer-nurse-resources/safety.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-safety-herceptin");
            
            driver.findElement(By.linkText("PERJETA®")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-safety-perjeta");
            
            driver.findElement(By.linkText("KADCYLA®")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-safety-kadcyla");
            
            goToUrl(driver, "/breast-cancer-nurse-resources.html");
            Thread.sleep(1000);
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown");
            
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[1]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-1");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-1-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[3]/div[1]/a")), new Long(2000));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-1-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[4]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");	
            Thread.sleep(1000);
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[2]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-2");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-2-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[5]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[3]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-3");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-3-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[6]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[4]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-4");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-4-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[7]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[5]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-5");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-5-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[8]/div[1]/a")), new Long(2000));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-5-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[9]/div[1]/a")), new Long(2000));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            Thread.sleep(1000);
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[6]");
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-6");
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[7]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-7");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-7-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[11]/div[1]/a")), new Long(1500));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-7-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[12]/div[1]/a")), new Long(1500));
            
            driver.navigate().refresh();
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/button");
            forceClick(driver,"/html/body/div[3]/div/div/div[2]/div[4]/div/div[1]/div/div/ul/li[8]");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-8");
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-8-1", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[13]/div[1]/a")), new Long(1500));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-8-2", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[14]/div[1]/a")), new Long(1500));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-8-3", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[15]/div[1]/a")), new Long(1500));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-8-4", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[16]/div[1]/a")), new Long(1500));
            
            full(driver, false, savePath, "her2treatment-mobile-3.0-dropdown-8-5", driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[4]/div/div[17]/div[1]/a")), new Long(1500));
            
            goToUrl(driver, "/breast-cancer-nurse-resources/contact-a-genentech-nurse-educator.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-genentech-nurse-educator");
            
            driver.findElement(By.xpath("//*[@id='riker-form']/div[13]/input")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-genentech-nurse-educator-error-msg");
            
            goToUrl(driver, "/her2-positive-breast-cancer-glossary.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-glossary");
            
            goToUrl(driver, "/user-sitemap.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-sitemap");
            
            goToUrl(driver, "/breast-cancer-treatment-prescribing-information.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-prescribing-info");
            
            goToUrl(driver, "/errorpage.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "her2treatment-mobile-errorpage");
		
		}catch (Exception e) {
		    e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
	}
}
