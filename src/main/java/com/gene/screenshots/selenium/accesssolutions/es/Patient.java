package com.gene.screenshots.selenium.accesssolutions.es;

import com.gene.screenshots.Variables;
import com.gene.screenshots.selenium.SeleniumTest;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Patient extends SeleniumTest {

	public void desktopAutomationTest(String savePath) {
		WebDriver driver = makeDesktopDriver();
		try {


			//---->> patient <<---- 12 screenshot for patient homepage
			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient.html");
//		driver.findElement(By.id("select-treatment")).click();
//		Thread.sleep(1000); visible(driver, true, savePath,   "accesssolutions-patient-select-treatment");

			Thread.sleep(1000);
			driver.findElement(By.className("product-popup")).click();
			Thread.sleep(1000); visible(driver, true, savePath, "accesssolutions-patient-product-popup");

			driver.findElement(By.xpath("//*[@id='product-selector']/div/div/div[2]/div/div/ul/li[15]/a")).click();
			Thread.sleep(1000); visible(driver, true, savePath, "accesssolutions-patient-rituxan-popup");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-0.0");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/pan.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-pan");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-pan-popup-1");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-pan-popup-2");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-pan-popup-3");

//		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/home.html");
//		Thread.sleep(1000); full(driver, true, savePath,   "accesssolutions-patient-home");

//		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/home/patient-assistance-tool-page.html");
//		Thread.sleep(1000); full(driver, true, savePath,   "accesssolutions-patient-pat");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/search.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-search");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/biooncology.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-biooncology");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/rheumatology.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-rheumatology");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/contact-us.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-contact-us");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}

	@Override
	public void mobileAutomationTest(String savePath) {
		WebDriver driver = makeMobileDriver();
		try {
			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient.html");
			driver.findElement(By.id("select-treatment")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "accesssolutions-mobile-patient-select-treatment");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient.html");
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();

			Thread.sleep(1000);
			visible(driver, false, savePath, "accesssolutions-mobile-patient-navigation");

			Thread.sleep(1000);
			driver.findElement(By.className("product-popup")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "accesssolutions-mobile-patient-product-popup");

			driver.findElement(By.xpath("//*[@id='product-selector']/div/div/div[2]/div/div/ul/li[15]/a")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "accesssolutions-mobile-patient-rituxan-popup");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-0.0");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/home.html");
			Thread.sleep(500);
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-home");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/home/patient-assistance-tool-page.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-pat");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/search.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-search");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/pan.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-pan");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/biooncology.html");
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-biooncology");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/rheumatology.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-rheumatology");

			driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/contact-us.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "accesssolutions-mobile-patient-contact-us");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}

	public static void movecursor(WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		WebElement element;
		
		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/button"));
		action.moveToElement(element).build().perform();
	}
	public static void movecursorm(WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		WebElement element;
		
		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/button"));
		action.moveToElement(element).build().perform();
	}
}
