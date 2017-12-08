package com.gene.screenshots.selenium.accesssolutions.en;

import com.gene.screenshots.Variables;
import com.gene.screenshots.selenium.kadcyla.patient.desktop;
import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class patient {

    private static Screenshots screenshots;

    public static void setScreenshots(Screenshots screenshots){
        patient.screenshots = screenshots;
    }

	public static void main(String[] args, WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub

        String savePath = Variables.getSavePath() + "/desktop/en/patient";
        
        //---->> patient <<---- 12 screenshot for patient homepage
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
		driver.findElement(By.id("select-treatment")).click();
		screenshots.visible(driver, savePath,   "accesssolutions-patient-select-treatment");
		
		Thread.sleep(1000);
		driver.findElement(By.className("product-popup")).click();
		screenshots.visible(driver, savePath,   "accesssolutions-patient-product-popup");
		
		driver.findElement(By.xpath("//*[@id='product-selector']/div/div/div[2]/div/div/ul/li[16]/a")).click();
		screenshots.visible(driver, savePath,    "accesssolutions-patient-rituxan-popup");
		driver.findElement(By.xpath("//*[@id='sub-indications-selector']/div/div/div[1]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("For US Healthcare Professionals")).click();
		screenshots.visible(driver, savePath,   "accesssolutions-patient-hcp-modal");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
		screenshots.full(driver, savePath,   "accesssolutions-patient-0.0");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/home.html");
		screenshots.full(driver, savePath,   "accesssolutions-patient-home");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/home/patient-assistance-tool-page.html");
		screenshots.full(driver, savePath,   "accesssolutions-patient-pat");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/search.html");
		screenshots.full(driver, savePath,    "accesssolutions-patient-search");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/pan.html");
		screenshots.full(driver, savePath,    "accesssolutions-patient-pan");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/biooncology.html");
		screenshots.full(driver, savePath,    "accesssolutions-patient-biooncology");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/rheumatology.html");
		screenshots.full(driver, savePath,    "accesssolutions-patient-rheumatology");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/contact-us.html");
		screenshots.full(driver, savePath,   "accesssolutions-patient-contact-us");
	}
	public static void patient_mobile(WebDriver driver) throws InterruptedException{
		
		//---->> patient mobile <<---- 13 screenshot for patient homepage mobile

        String savePath = Variables.getSavePath() + "/mobile/en/patient";
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
		driver.findElement(By.id("select-treatment")).click();
		screenshots.visible(driver, savePath,   "accesssolutions-mobile-patient-select-treatment");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div[2]/button")).click();;
		screenshots.visible(driver, savePath,    "accesssolutions-mobile-patient-navigation");
		
		Thread.sleep(1000);
		driver.findElement(By.className("product-popup")).click();
		screenshots.visible(driver, savePath,   "accesssolutions-mobile-patient-product-popup");
		
		driver.findElement(By.xpath("//*[@id='product-selector']/div/div/div[2]/div/div/ul/li[16]/a")).click();
		screenshots.visible(driver, savePath,    "accesssolutions-mobile-patient-rituxan-popup");
		driver.findElement(By.xpath("//*[@id='sub-indications-selector']/div/div/div[1]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("US Healthcare Professionals")).click();
		screenshots.visible(driver, savePath,   "accesssolutions-mobile-patient-hcp-modal");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient.html");
		screenshots.full(driver, savePath,   "accesssolutions-mobile-patient-0.0");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/home.html");
		Thread.sleep(500);
		screenshots.full(driver, savePath,   "accesssolutions-mobile-patient-home");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/home/patient-assistance-tool-page.html");
		screenshots.full(driver, savePath,   "accesssolutions-mobile-patient-pat");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/search.html");
		screenshots.full(driver, savePath,    "accesssolutions-mobile-patient-search");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/pan.html");
		screenshots.full(driver, savePath,    "accesssolutions-mobile-patient-pan");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/biooncology.html");
		movecursor(driver);
		screenshots.full(driver, savePath,    "accesssolutions-mobile-patient-biooncology");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/rheumatology.html");
		screenshots.full(driver, savePath,    "accesssolutions-mobile-patient-rheumatology");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/contact-us.html");
		screenshots.full(driver, savePath,   "accesssolutions-mobile-patient-contact-us");
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
