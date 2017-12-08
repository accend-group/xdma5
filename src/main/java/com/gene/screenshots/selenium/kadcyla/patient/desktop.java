package com.gene.screenshots.selenium.kadcyla.patient;

import com.gene.screenshots.utils.Screenshots;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class desktop {
    
    private static Screenshots screenshots;
    
    public static void setScreenshots(Screenshots screenshots){
        desktop.screenshots = screenshots;
    }
    
	public static void automation(String savePath) throws InterruptedException{
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-infobars");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu-watchdog");

        WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		WebElement element;

		driver.manage().window().setSize(new Dimension(1600,1200));
		//driver.manage().window().maximize();
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
		screenshots.visible(driver, savePath, "kadcyla-patient");

		element = driver.findElement(By.linkText("KADCYLA and HER2+ Metastatic Breast Cancer"));
		action.moveToElement(element).build().perform();		
		screenshots.visible(driver, savePath, "kadcyla-hover-1.0");
		
		element = driver.findElement(By.linkText("About KADCYLA"));
		action.moveToElement(element).build().perform();		
		screenshots.visible(driver, savePath, "kadcyla-hover-2.0");
		
		element = driver.findElement(By.linkText("Support and Resources"));
		action.moveToElement(element).build().perform();		
		screenshots.visible(driver, savePath, "kadcyla-hover-3.0");

		driver.navigate().refresh();
		jse.executeScript("window.scrollTo(0,1000)", "");
		driver.findElement(By.linkText("http://www.motherpregnancyregistry.com/")).click();
		jse.executeScript("window.scrollTo(0,0)", "");
		screenshots.visible(driver, savePath, "kadcyla-link-modal");
		
//		driver.navigate().refresh();
//		driver.findElement(By.className("genentech-component--button__text")).click();
//		screenshots.visible(driver, savePath, "kadcyla-share-modal");
//		
//		driver.findElement(By.name("fname")).sendKeys("Marwin");
//		driver.findElement(By.name("lname")).sendKeys("Nicolas");
//		driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.xpath("/html/body/section[2]/div[3]/div/div/form/div/div[3]/input")).click();
//		screenshots.visible(driver, savePath, "kadcyla-share-modal-submit");
		
		//		//--->start full page screenshot <---//
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");	
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-0.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-1.0");

		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-1.1");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer/treatment.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-1.2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-2.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/dosing-and-administration.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-2.1");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/benefits-risks.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-2.2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/talk-with-healthcare-team.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-2.3");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-3.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/4HER-patient-support-app.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-3.1");
		
		//driver.manage().window().setSize(new Dimension(1612,750));
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-3.2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat1-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat2-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat3-no");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat4-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat1-no");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat2-no");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
		remove(driver);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-pat3-yes");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
		Thread.sleep(1000);
		movecursor(driver);
		screenshots.full(driver, savePath, "kadcyla-3.2-pat4-no");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
		remove(driver);
		driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-tab1");
		
		driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-tab2");

		driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-tab3");
		
		driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-tab4");

		driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-tab5");
		
		driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();
		screenshots.full(driver, savePath, "kadcyla-3.2-tab6");
		
		//driver.manage().window().maximize();
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/herconnection-support-program.html");
		screenshots.full(driver, savePath, "kadcyla-3.3");
		
		driver.findElement(By.name("first-name")).sendKeys("Marwin");
		driver.findElement(By.name("last-name")).sendKeys("Nicolas");
		driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
		driver.findElement(By.name("confirm-email-address")).sendKeys("marwin@accendgroup.com");
		driver.findElement(By.name("address-line-1")).sendKeys("CA");
		driver.findElement(By.name("address-line-2")).sendKeys("CA");
		driver.findElement(By.name("city")).sendKeys("CA");
		driver.findElement(By.className("gene-component--dropdown")).click();
		driver.findElement(By.xpath("//li[@data-value='AK']")).click();
		driver.findElement(By.name("zip-code-base")).sendKeys("99501");
		driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
		driver.findElement(By.name("verify-age")).click();
		driver.findElement(By.className("submit")).click();
	
		Thread.sleep(1000);
		screenshots.full(driver, savePath, "kadcyla-3.3-submit");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/breast-cancer-support-groups.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-3.4");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/downloads.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-3.5");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/safety.html");
		screenshots.full(driver, savePath, "kadcyla-safety");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/site-map.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-sitemap");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/patient/glossary.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-glossary");	

		driver.quit();
	}
	public static void remove(WebDriver driver) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div/div/div"));
		js.executeScript("arguments[0].setAttribute('style', 'height:0% !important;')",element);
		
	}
	public static void movecursor(WebDriver driver){
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.name("q"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();
	}
}
