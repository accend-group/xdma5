package com.gene.screenshots.selenium.kadcyla.hcp;

import java.util.HashMap;
import java.util.Map;

import com.gene.screenshots.selenium.kadcyla.patient.desktop;
import com.gene.screenshots.utils.Screenshots;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mobile {

    private static Screenshots screenshots;

    public static void setScreenshots(Screenshots screenshots){
        mobile.screenshots = screenshots;
    }
    
	public static void automation(String savePath) throws InterruptedException{
		Map<String, Object> mobile = new HashMap<>();
		mobile.put("width", 320);
		mobile.put("height", 720);
		mobile.put("pixelRatio", 1.0);

		Map<String, Object> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceMetrics", mobile);
		mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

		ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");

		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		WebDriver driver = new ChromeDriver(chromeOptions);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        

		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp.html");
		remove(driver);
		screenshots.full(driver, savePath,"kadcyla-hcp-mobile-0.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-1.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla/molecular-structure.html");
		remove(driver);		
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-1.1");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla/proposed-moa.html");
		remove(driver);
        screenshots.full(driver, savePath,"kadcyla-hcp-mobile-1.2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla/patient-eligibility.html");
		remove(driver);
        screenshots.full(driver, savePath,"kadcyla-hcp-mobile-1.3");

		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/trial-design.html");
		remove(driver);
        screenshots.full(driver, savePath,"kadcyla-hcp-mobile-2.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/efficacy.html");
		remove(driver);
        screenshots.full(driver, savePath,"kadcyla-hcp-mobile-3.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety-profile.html");
		remove(driver);
        screenshots.full(driver, savePath,"kadcyla-hcp-mobile-4.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/dosing-administration.html");
		remove(driver);
        screenshots.full(driver, savePath, "kadcyla-hcp-mobile-5.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources.html");
		remove(driver);
        screenshots.full(driver, savePath,"kadcyla-hcp-mobile-6.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat1-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat2-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat3-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat4-yes");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat2-no");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat3-no");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat5-yes");

		// --- >> button hover error << --- //
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat1-no");
		
		// --- >> error button << --- //
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat4-no");
		
		// --- >> error button << --- //
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-pat5-no");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,900)", "");
		driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-tab1");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-tab2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,1200)", "");
		driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-tab3");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,1300)", "");
		driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-tab4");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,1400)", "");
		driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.1-tab5");

		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/downloads.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-6.2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/contact.html");
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-contact-rep");
		
		driver.findElement(By.className("gene-component--dropdown")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-contact-rep-provider-type");
		driver.navigate().refresh();
		driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-contact-rep-specialty");
			
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/register.html");
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-register");	
		driver.findElement(By.xpath("//form/div[5]/div/div/div")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-register-classification");	
		driver.navigate().refresh();
		driver.findElement(By.xpath("//form/div[5]/div[2]/div/div")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-register-specialty");
		
		//register
		driver.findElement(By.className("gene-component--dropdown")).click();	
		driver.findElement(By.xpath("//li[@data-value='MR']")).click();
		driver.findElement(By.name("first-name")).sendKeys("Marwin");
		driver.findElement(By.name("last-name")).sendKeys("Nicolas");
		driver.findElement(By.name("address-line-1")).sendKeys("CA");
		driver.findElement(By.name("address-line-2")).sendKeys("CA");
		driver.findElement(By.name("city")).sendKeys("CA");
		driver.findElement(By.xpath("//form/div[4]/div[2]/div/div")).click();
		driver.findElement(By.xpath("//li[@data-value='AK']")).click();
		driver.findElement(By.name("zip-code-base")).sendKeys("99501");
		driver.findElement(By.xpath("//form/div[5]/div/div/div")).click();
		driver.findElement(By.xpath("//li[@data-value='CC']")).click();
		driver.findElement(By.xpath("//form/div[5]/div[2]/div/div")).click();
		driver.findElement(By.xpath("//li[@data-value='HO']")).click();
		driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
		driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
		driver.findElement(By.className("submit")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-register-signup");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety.html");
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-safety");
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/sitemap.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-sitemap");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/references.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-mobile-references");

		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp.html");
		screenshots.visible(driver, savePath, "kadcyla-hcp-mobile");
		
		driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("gene-component--navigation__icon--tab")).click();
		screenshots.visible(driver, savePath, "kadcyla-hcp-mobile-hover-1.0");
		
		driver.navigate().refresh();
		driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//nav/div/div[2]/div/ul/li[6]/a/i")).click();
        screenshots.visible(driver, savePath, "kadcyla-hcp-mobile-hover-6.0");
        System.out.println("start");
		driver.navigate().refresh();
		System.out.println("done");
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		driver.findElement(By.linkText("www.fda.gov/medwatch")).click();
		jse.executeScript("window.scrollTo(0,0)", "");
        screenshots.visible(driver ,savePath, "kadcyla-hcp-mobile-link-modal");

        driver.quit();
	}
	public static void remove(WebDriver driver) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.className("gene-component--spotlight"));
		js.executeScript("arguments[0].setAttribute('style', 'height:0% !important;')",element);
		
	}
}
