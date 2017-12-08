package com.gene.screenshots.selenium.kadcyla.hcp;


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

		driver.manage().window().setSize(new Dimension(1600, 1200));
		//driver.manage().window().maximize();
	
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp.html");
		remove(driver);
		screenshots.full(driver, savePath,"kadcyla-hcp-0.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-1.0");
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla/molecular-structure.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-1.1");
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla/proposed-moa.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-1.2");
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/about-kadcyla/patient-eligibility.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-1.3");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/trial-design.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-2.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/efficacy.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-3.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety-profile.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-4.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/dosing-administration.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-5.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-6.0");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1");
		
		//driver.manage().window().setSize(new Dimension(1612,750));
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat1-yes");
		
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat2-yes");
		
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat3-yes");
		
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat4-yes");
		
		driver.findElement(By.className("start-over")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat1-no");
		
		driver.findElement(By.className("start-over")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
		movecursor(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat2-no");
		
		driver.findElement(By.className("start-over")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat3-no");
		
		driver.findElement(By.className("start-over")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat4-no");
		
		driver.findElement(By.className("start-over")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat5-yes");
		
		driver.findElement(By.className("start-over")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-pat5-no");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-tab1");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,900)");
		driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-tab2");
		
		//driver.manage().window().setSize(new Dimension(1612,780));
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,1200)");
		movecursor(driver);
		driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-tab3");
		
		//driver.manage().window().setSize(new Dimension(1612,750));
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,1300)");
		driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-tab4");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/financial-assistance.html");
		remove(driver);
		jse.executeScript("window.scrollBy(0,1400)");
		driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-6.1-tab5");

		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/resources/downloads.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-6.2");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/contact.html");
		screenshots.full(driver, savePath, "kadcyla-hcp-contact-rep");
		driver.findElement(By.className("gene-component--dropdown")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-contact-rep-provider-type");
		driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-contact-rep-specialty");
		//driver.manage().window().maximize();
		
		//contact-reg - not available since there is captcha
//		driver.findElement(By.className("gene-component--dropdown")).click();	
//		driver.findElement(By.xpath("//li[@data-value='REF']")).click();
//		driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
//		driver.findElement(By.xpath("//li[@data-value='HO']")).click();
//		driver.findElement(By.name("first-name")).sendKeys("Marwin");
//		driver.findElement(By.name("last-name")).sendKeys("Nicolas");
//		driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.name("confirm-email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.name("zip-code-base")).sendKeys("99501");
//		driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
//		driver.findElement(By.name("practice-name")).sendKeys("Accend group");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/register.html");
		screenshots.full(driver, savePath, "kadcyla-hcp-register");	
		driver.findElement(By.xpath("//form/div[5]/div/div/div")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-register-classification");
		driver.findElement(By.xpath("//form/div[5]/div[2]/div/div")).click();
		screenshots.full(driver, savePath, "kadcyla-hcp-register-specialty");
		
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
		screenshots.full(driver, savePath, "kadcyla-hcp-register-signup");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/safety.html");
		screenshots.full(driver, savePath, "kadcyla-hcp-safety");
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/sitemap.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-sitemap");
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp/references.html");
		remove(driver);
		screenshots.full(driver, savePath, "kadcyla-hcp-references");
		
		driver.get("http://localhost:4503/content/kadcyla/en_us/hcp.html");
		screenshots.visible(driver, savePath, "kadcyla-hcp");
		
		element = driver.findElement(By.linkText("About KADCYLA"));
		action.moveToElement(element).build().perform();		
		screenshots.visible(driver, savePath, "kadcyla-hcp-hover-1.0");
		
		element = driver.findElement(By.linkText("Resources"));
		action.moveToElement(element).build().perform();		
		screenshots.visible(driver, savePath, "kadcyla-hcp-hover-6.0");
		
		driver.navigate().refresh();
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
		driver.findElement(By.linkText("www.fda.gov/medwatch")).click();
		jse.executeScript("window.scrollTo(0,0)", "");
		screenshots.visible(driver, savePath, "kadcyla-hcp-link-modal");
		
		driver.quit();
	}
	public static void remove(WebDriver driver) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.className("gene-component--spotlight"));
		js.executeScript("arguments[0].setAttribute('style', 'height:0% !important;')",element);
		
	}
	public static void movecursor(WebDriver driver){
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.name("q"));
		actions.moveToElement(mainMenu);
		actions.click().build().perform();
	}
}
