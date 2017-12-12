package com.gene.screenshots.selenium.accesssolutions.en;


import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Alecensa extends SeleniumHeadless {

	@Override
	public void desktopAutomationTest(String savePath) {

		WebDriver driver = makeDesktopDriver();
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			Actions actions = new Actions(driver);

			// ---->> alecensa <<---- 38 screenshot for alecensa
			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-0-0");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/how-we-help-you.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/how-we-help-you.html");
			driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0-tab1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0-GATCF-1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.className("start-over")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0-GATCF-2");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.className("start-over")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.linkText("How do I enroll?")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0-step1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.linkText("What will we find out?")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0-step2");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.linkText("What options are there?")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-1.0-step3");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/forms-and-documents.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-2.0");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-2.0-esubmit");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-2.0-more-info-1");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-2.0-more-info-2");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/frequently-asked-questions.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab1");

			driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
			movecursor(driver);
			driver.manage().window().setSize(new Dimension(1621, 780));
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab2");

			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id='accordion_1918003580']/div[1]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab3");

			driver.findElement(By.xpath("//*[@id='accordion_1918003580']/div[2]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab4");

			driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab5");

			driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab6");

			driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab7");

			driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab8");

			driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
			movecursor1(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab9");

			driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
			movecursor1(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab10");

			driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
			movecursor1(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab11");

			driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
			movecursor(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-3.0-tab12");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/patient-assistance-tool-page.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-part1");
			jse.executeScript("window.scrollTo(0, 0)");

			actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
			Thread.sleep(1000);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-part2");
			jse.executeScript("window.scrollTo(0, 0)");

			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-1-part1");

			jse.executeScript("window.scrollTo(0, 0)");
			actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-1-part2");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.className("start-over")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-more-info-1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-2-part1");

			jse.executeScript("window.scrollTo(0, 0)");
			actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-2-part2");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-more-info-2");

			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-3-part1");

			jse.executeScript("window.scrollTo(0, 0)");
			actions.moveToElement(driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-pat-3-part2");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/search.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-search");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/site-map.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-patient-alecensa-sitemap");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close(); driver.quit();
		}
	}

	public void mobileAutomationTest(String savePath) {

		WebDriver driver = makeMobileDriver();
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			// ---->> alecensa <<---- 38 screenshot for alecensa
			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa0-0");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/how-we-help-you.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/how-we-help-you.html");
			driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0-tab1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[1]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0-GATCF-1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.className("start-over")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0-GATCF-2");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.className("start-over")).click();
			jse.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[6]/div/div/div[2]/div/div/div[1]/div/div"));
			jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:50px;')", element);
			driver.findElement(By.linkText("How do I enroll?")).click();
			jse.executeScript("arguments[0].setAttribute('style', 'padding-bottom:0px;')", element);
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0-step1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.linkText("What will we find out?")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0-step2");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.linkText("What options are there?")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-1.0-step3");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/forms-and-documents.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-2.0");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-2.0-more-info-1");

			driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-2.0-more-info-2");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/frequently-asked-questions.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accordion']/div/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab1");

			driver.findElement(By.xpath("//*[@id='accordion_0']/div/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab2");

			driver.findElement(By.xpath("//*[@id='accordion_1918003580']/div[1]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab3");

			driver.findElement(By.xpath("//*[@id='accordion_1918003580']/div[2]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab4");

			driver.findElement(By.xpath("//*[@id='accordion_2']/div[1]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab5");

			driver.findElement(By.xpath("//*[@id='accordion_2']/div[2]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab6");

			driver.findElement(By.xpath("//*[@id='accordion_2']/div[3]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab7");

			driver.findElement(By.xpath("//*[@id='accordion_3']/div[1]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab8");

			driver.findElement(By.xpath("//*[@id='accordion_3']/div[2]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab9");

			driver.findElement(By.xpath("//*[@id='accordion_3']/div[3]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab10");

			driver.findElement(By.xpath("//*[@id='accordion_4']/div[1]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab11");

			driver.findElement(By.xpath("//*[@id='accordion_4']/div[2]/div[1]")).click();
			movecursorm(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-3.0-tab12");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/patient-assistance-tool-page.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-pat");
			jse.executeScript("window.scrollTo(0, 0)");

			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-pat1-no");
			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.className("start-over")).click();

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-pat-more-info-1");

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-pat-2");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[5]/div[2]/button")).click();

			jse.executeScript("window.scrollTo(0, 0)");
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-pat-more-info-2");

			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			driver.findElement(By.xpath("//*[@id='accesssolutionsembed']/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-pat-3");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/search.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-search");

			driver.get("http://localhost:4503/content/accesssolutions-site/en_us/patient/brands/alecensa/site-map.html");
			Thread.sleep(1000);
			full(driver, true, savePath, "accesssolutions-mobile-patient-alecensa-sitemap");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close(); driver.quit();
		}
	}

	public void movecursor(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement element;

		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.name("q"));
		action.moveToElement(element).build().perform();
	}

	public void movecursor1(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement element;

		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.linkText("FAQs"));
		action.moveToElement(element).build().perform();
	}

	public void movecursorm(WebDriver driver) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement element;

		jse.executeScript("window.scrollTo(0, 0)");
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/button"));
		action.moveToElement(element).build().perform();
	}
}
