package com.gene.screenshots.selenium.accesssolutions.es;

import com.gene.screenshots.Variables;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;
import com.gene.screenshots.utils.Screenshots;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class es_gazyva {

    private static Screenshots screenshots;

    public static void setScreenshots(Screenshots screenshots){
        es_gazyva.screenshots = screenshots;
    }

	public static void main(String[] args, WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
        String savePath = Variables.getSavePath() + "/desktop/es/gazyva";

        JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions actions = new Actions(driver);
		
		// ---->> gazyva <<---- // 38 screenshots
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-0.0");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/how-we-help-you.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-1.0");
		
		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-1.0-tab1");
		
		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-1.0-tab2");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-1.0-GATCF-1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-1.0-GATCF-2");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.linkText("�C�mo me inscribo?")).click();
		screenshots.full(driver, true, savePath,  "accesssolutions-patient-gazyva-1.0-step1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.linkText("�Qu� averiguaremos?")).click();
		screenshots.full(driver, true, savePath,  "accesssolutions-patient-gazyva-1.0-step2");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.linkText("�Qu� opciones hay?")).click();
		screenshots.full(driver, true, savePath,  "accesssolutions-patient-gazyva-1.0-step3");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/forms-and-documents.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-2.0");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-2.0-esubmit");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-2.0-more-info-1");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-2.0-more-info-2");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/frequently-asked-questions.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0");
		
		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab1");
		
		driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab2");
		
		driver.findElement(By.xpath("//*[@id='accordion_617592650']/div[1]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab3");
		
		driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab4");
		
		driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab5");
		
		driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab6");
		
		driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab7");
		
		driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
		movecursor1(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab8");
	
		driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
		movecursor1(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab9");
		
		driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
		movecursor1(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab10");
		
		driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
		movecursor(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-3.0-tab11");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/patient-assistance-tool-page.html");
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-part1");
		jse.executeScript("window.scrollTo(0, 0)");
		
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
		Thread.sleep(1000);
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-part2");
		jse.executeScript("window.scrollTo(0, 0)");
		
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-1-part1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
		Thread.sleep(1000);
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-1-part2");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-more-info-1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-2-part1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-2-part2");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-more-info-2");
		
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-3-part1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
		Thread.sleep(1000);
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-pat-3-part2");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/search.html");
		screenshots.full(driver, true, savePath,   "accesssolutions-patient-gazyva-search");
		
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/site-map.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-patient-gazyva-sitemap");
		
	}
	public static void gazyva_mobile(WebDriver driver) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        String savePath = Variables.getSavePath() + "/mobile/es/gazyva";

        // ---->> gazyva <<---- // 38 screenshots
		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-0.0");

		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/how-we-help-you.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-1.0");

		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-1.0-tab1");

		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-1.0-tab2");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accordion']/div[2]/div[1]")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-1.0-GATCF-1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-1.0-GATCF-2");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		jse.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[5]/div/div/div[2]/div/div/div[1]/div"));
//		jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:50px;')",element);
		driver.findElement(By.linkText("�C�mo me inscribo?")).click();
//		jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:0px;')",element);
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-1.0-step1");

		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.linkText("�Qu� averiguaremos?")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-1.0-step2");

		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.linkText("�Qu� Opciones Hay?")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-1.0-step3");

		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/forms-and-documents.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-2.0");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-2.0-more-info-1");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-2.0-more-info-2");

		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/frequently-asked-questions.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0");

		driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab1");

		driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab2");

		driver.findElement(By.xpath("//*[@id='accordion_617592650']/div[1]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab3");

		driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab4");

		driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab5");

		driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab6");

		driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab7");

		driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab8");

		driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab9");

		driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab10");

		driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
		movecursorm(driver);
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-3.0-tab11");

		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/patient-assistance-tool-page.html");
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-pat");
		jse.executeScript("window.scrollTo(0, 0)");

		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-pat-1");
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.className("start-over")).click();
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-pat-more-info-1");
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-pat-2");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();
		
		jse.executeScript("window.scrollTo(0, 0)");
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-pat-more-info-2");
		
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
		driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-pat-3");

		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/search.html");
		screenshots.full(driver, true, savePath,   "accesssolutions-mobile-patient-gazyva-search");

		driver.get("http://localhost:4503/content/accesssolutions-site/es/patient/brands/gazyva/site-map.html");
		screenshots.full(driver, true, savePath,    "accesssolutions-mobile-patient-gazyva-sitemap");
	}
	public static void movecursor(WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		WebElement element;
		
		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.name("q"));
		action.moveToElement(element).build().perform();
	}
	public static void movecursor1(WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);
		WebElement element;
		
		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.linkText("Preguntas Frecuentes"));
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
