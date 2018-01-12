package com.gene.screenshots.selenium.perjeta.hcp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.function.Consumer;

public class PerjetaHCP extends SeleniumHeadless{
	public void desktopAutomationTest(String savePath) {
		
		WebDriver driver = makeDesktopDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try {
			 Consumer<WebDriver> movecursor = (d) -> {
	                Actions actions = new Actions(d);
	                WebElement mainMenu = d.findElement(By.name("q"));
	                actions.moveToElement(mainMenu);
	                actions.click().build().perform();
	            };

            Actions action = new Actions(driver);
            
			goToUrl(driver, "/hcp/breast-cancer.html");
			Thread.sleep(1000);
			visible(driver, true, savePath,  "hcp-home");
			
			action.moveToElement(driver.findElement(By.linkText("Resources"))).build().perform();
			visible(driver, true, savePath,  "hcp-hover-6.0");
			
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			forceClick(driver,"//*[@id=\"safety_reference_cal_1181551378\"]/div/div/div/p[1]/a[2]");
//			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, true, savePath,  "hcp-modal-thirdpartysite");
			
			driver.navigate().refresh();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-0.0");
			
			goToUrl(driver, "/hcp/breast-cancer/about-perjeta.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-1.0");
			
			goToUrl(driver, "/hcp/breast-cancer/trial-designs.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-2.0-tab1");
			
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-2.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/efficacy.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-3.0-tab1");
			
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-3.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/safety-profiles.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-4.0-tab1");
			
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-4.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/dosing-admin.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-5.0-tab1");
			
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-5.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/resources.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.0");
			
			goToUrl(driver, "/hcp/breast-cancer/resources/financial-assistance.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-part1");
			
            action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]"))).build().perform();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-part2");
			
            action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[5]/div[2]/fieldset/button[1]"))).build().perform();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-part3");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-pat1-part1");
			
            action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-pat1-part2");
            
            scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-pat2-part1");
			
            action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-pat2-part2");
			
            scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[5]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			movecursor.accept(driver);
            full(driver, true, savePath, "hcp-6.1-pat3-part1");
			
            action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			movecursor.accept(driver);
            full(driver, true, savePath, "hcp-6.1-pat3-part2");
            
            scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[5]/div[2]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-q1", driver.findElement(By.className("more-info")), new Long(1000));
			
            scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
            Thread.sleep(1000);
            scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[1]/header/h1")));
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-tab1");
			
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[1]/header/h1")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-tab2");
			
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-tab3");
			
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-tab4");
			
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[5]/header/h1")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.1-tab5");
			
			goToUrl(driver, "/hcp/breast-cancer/resources/downloads.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-6.2");
			
			goToUrl(driver, "/hcp/breast-cancer/contact.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-contact-rep");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[3]/form/div[1]/div[1]/div/div")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-contact-rep-provider");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[3]/form/div[1]/div[2]/div/div")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-contact-rep-specialty");
			  
			goToUrl(driver, "/hcp/breast-cancer/register.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-register");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/div")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-register-classification");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[2]/div/div")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-register-specialty");
			

	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[1]/div/div/div")).click();
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[1]/div/div/ul/li[1]")).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.name("first-name")).sendKeys("marwin");
	    		driver.findElement(By.name("last-name")).sendKeys("nicolas");
	    		driver.findElement(By.name("address-line-1")).sendKeys("CA");
	    		driver.findElement(By.name("address-line-2")).sendKeys("CA");
	    		driver.findElement(By.name("city")).sendKeys("CA");
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[4]/div[2]/div[1]/div/div")).click();
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[4]/div[2]/div[1]/div/ul/li[1]")).click();
	    		driver.findElement(By.name("zip-code-base")).sendKeys("99501");
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/div")).click();
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/ul/li[1]")).click();
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[2]/div/div")).click();
	    		driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[2]/div/ul/li[1]")).click();
	    		driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
	    		Thread.sleep(1000);
            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
          	driver.findElement(By.className("submit")).click();
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-register-submit");
			
			goToUrl(driver, "/hcp/breast-cancer/isi.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-safety");
			
			goToUrl(driver, "/hcp/site-map.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-sitemap");
			
			goToUrl(driver, "/hcp/breast-cancer/references.html");
			Thread.sleep(1000);
            full(driver, true, savePath, "hcp-references");
		
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
	        	
			goToUrl(driver, "/hcp/breast-cancer.html");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-home");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]/i[1]")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-navigation");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/div/div[2]/div/ul/li[6]/a/i")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-hover-6.0");
			
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			forceClick(driver,"//*[@id=\"safety_reference_cal_1181551378\"]/div/div/div/p[1]/a[2]");
//			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-modal-thirdpartysite");
			
			goToUrl(driver, "/hcp/breast-cancer.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-0.0");
			
			goToUrl(driver, "/hcp/breast-cancer/about-perjeta.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-1.0");
			
			goToUrl(driver, "/hcp/breast-cancer/trial-designs.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-2.0-tab1");
			
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[1]/header/h1")));
			Thread.sleep(1000);
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-2.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/efficacy.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-3.0-tab1");
			
			js.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[1]/header/h1")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-3.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/safety-profiles.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-4.0-tab1");
			
			js.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[1]/header/h1")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-4.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/dosing-admin.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-5.0-tab1");
			
			js.executeScript("window.scrollTo(0, 0)");
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[1]/header/h1")));
			Thread.sleep(1000);
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section/div[1]/div[3]/div/div[2]/section[2]/header/h1")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-5.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/resources.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.0");
			
			goToUrl(driver, "/hcp/breast-cancer/resources/financial-assistance.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1");
			
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")));
			Thread.sleep(1500);
			full(driver, false, savePath, "hcp-6.1-pat1");
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
            Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			forceClick(driver, "/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[2]");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-pat2");
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			forceClick(driver, "/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[5]/div[2]/fieldset/button[1]");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-pat3");
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")));
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[5]/div[2]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-q1", driver.findElement(By.className("more-info")), new Long(1000));
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[1]/header/h1")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-tab1");
			
			scrollAndClickAt(driver,driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[1]/header/h1")));
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-tab2");
			
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[2]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-tab3");
			
			forceClick(driver, "/html/body/main/section[5]/div/div/div/div[2]/section[3]/header/h1");
			forceClick(driver, "/html/body/main/section[5]/div/div/div/div[2]/section[4]/header/h1");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-tab4");
			
			forceClick(driver, "/html/body/main/section[5]/div/div/div/div[2]/section[4]/header/h1");
			forceClick(driver, "/html/body/main/section[5]/div/div/div/div[2]/section[5]/header/h1");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-tab5");
			
			goToUrl(driver, "/hcp/breast-cancer/resources/downloads.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.2");
			
			goToUrl(driver, "/hcp/breast-cancer/contact.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-contact-rep");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[3]/form/div[1]/div[1]/div/div")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-contact-rep-provider");
			
			driver.navigate().refresh();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[3]/form/div[1]/div[2]/div/div")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-contact-rep-specialty");
			
			goToUrl(driver, "/hcp/breast-cancer/register.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/div")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register-classification");
			
			driver.navigate().refresh();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[2]/div/div")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register-specialty");
			
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[1]/div/div/div")).click();
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[1]/div/div/ul/li[1]")).click();
			driver.findElement(By.name("first-name")).sendKeys("marwin");
			driver.findElement(By.name("last-name")).sendKeys("nicolas");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[4]/div[2]/div[1]/div/div")).click();
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[4]/div[2]/div[1]/div/ul/li[1]")).click();
			driver.findElement(By.name("zip-code-base")).sendKeys("99501");
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/div")).click();
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/ul/li[1]")).click();
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[2]/div/div")).click();
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[2]/div/ul/li[1]")).click();
			driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
			Thread.sleep(1000);
             driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
           	driver.findElement(By.className("submit")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register-submit");
			
			goToUrl(driver, "/hcp/breast-cancer/isi.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-safety");
			
			goToUrl(driver, "/hcp/site-map.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-sitemap");
			
			goToUrl(driver, "/hcp/breast-cancer/references.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-references");

        	
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
	 }
}
