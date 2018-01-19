package com.gene.screenshots.selenium.perjeta.patient;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Consumer;


public class PerjetaPatient extends SeleniumHeadless {
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

			goToUrl(driver, "/patient/breast-cancer.html");

			visible(driver, true, savePath, "patient-home");

			action.moveToElement(driver.findElement(By.linkText("PERJETA and HER2+ Breast Cancer"))).build().perform();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-hover-1.0");

			action.moveToElement(driver.findElement(By.linkText("Early Breast Cancer Treatment Before Surgery"))).build().perform();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-hover-2.0");

			action.moveToElement(driver.findElement(By.linkText("Metastatic Breast Cancer Treatment"))).build().perform();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-hover-3.0");

			action.moveToElement(driver.findElement(By.linkText("Support and Resources"))).build().perform();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-hover-4.0");

			// link missing in prod, dev, stage
			/*driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/div[5]/div/a/span")).click();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-share");

			driver.findElement(By.name("fname")).sendKeys("marwin");
			driver.findElement(By.xpath("/html/body/section[2]/div[3]/div/div/form/div/div[3]/input")).click();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-share-error");
			
			driver.findElement(By.name("fname")).sendKeys("marwin");
			driver.findElement(By.name("lname")).sendKeys("nicolas");
			driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
			driver.findElement(By.xpath("/html/body/section[2]/div[3]/div/div/form/div/div[3]/input")).click();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-share-submit");
			*/

			goToUrl(driver, "/patient/breast-cancer.html");

//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			forceClick(driver, "//*[@id=\"safety_reference_cal_647752441\"]/div/div/div/p/a[2]");
//			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-thirdpartysite");

			goToUrl(driver, "/patient/breast-cancer.html");
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[1]/ul/li[1]/a/span")).click();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-HCP");

			goToUrl(driver, "/patient/breast-cancer.html");

			full(driver, true, savePath, "patient-0.0");

			goToUrl(driver, "/patient/breast-cancer/about.html");

			full(driver, true, savePath, "patient-1.0");

			goToUrl(driver, "/patient/breast-cancer/about/HER2-positive-breast-cancer.html");

			full(driver, true, savePath, "patient-1.1");

			goToUrl(driver, "/patient/breast-cancer/about/targeted-treatment.html");

			full(driver, true, savePath, "patient-1.2");

			goToUrl(driver, "/patient/breast-cancer/about/perjeta.html");

			full(driver, true, savePath, "patient-1.3");

			goToUrl(driver, "/patient/breast-cancer/early.html");

			full(driver, true, savePath, "patient-2.0");

			goToUrl(driver, "/patient/breast-cancer/early/treatment-before-surgery.html");

			full(driver, true, savePath, "patient-2.1");

			goToUrl(driver, "/patient/breast-cancer/early/how-treatment-is-given.html");

			full(driver, true, savePath, "patient-2.2");

			goToUrl(driver, "/patient/breast-cancer/early/why-perjeta.html");

			full(driver, true, savePath, "patient-2.3");

			goToUrl(driver, "/patient/breast-cancer/early/talking-with-your-doctor.html");

			full(driver, true, savePath, "patient-2.4");

			goToUrl(driver, "/patient/breast-cancer/metastatic.html");

			full(driver, true, savePath, "patient-3.0");

			goToUrl(driver, "/patient/breast-cancer/metastatic/how-treatment-is-given.html");

			full(driver, true, savePath, "patient-3.1");

			goToUrl(driver, "/patient/breast-cancer/metastatic/why-perjeta.html");

			full(driver, true, savePath, "patient-3.2");

			goToUrl(driver, "/patient/breast-cancer/metastatic/talking-with-your-team.html");

			full(driver, true, savePath, "patient-3.3");

			goToUrl(driver, "/patient/breast-cancer/support-resources.html");

			full(driver, true, savePath, "patient-4.0");

			goToUrl(driver, "/patient/breast-cancer/support-resources/4HER-patient-support-app.html");

			full(driver, true, savePath, "patient-4.1");

			goToUrl(driver, "/patient/breast-cancer/support-resources/financial-resources.html");

			full(driver, true, savePath, "patient-4.2-part1");

			action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-part2");

			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat1-part1");

			action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[4]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat1-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")));
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat2-part1");

			action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[3]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat2-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
			movecursor.accept(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat3-part1");

			action.moveToElement(driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[2]/div/p[6]"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat3-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat-q1", driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")), new Long(1000));

			forceClick(driver, "/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]");
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat-q2", driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")), new Long(1000));

			driver.navigate().refresh();
			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[1]/header/h1")));
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-tab1");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[1]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-tab2");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[2]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-tab3");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[3]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-tab4");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[4]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[5]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-tab5");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[5]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[6]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-tab6");

			goToUrl(driver, "/patient/breast-cancer/support-resources/herconnection.html");

			full(driver, true, savePath, "patient-4.3");

			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[2]/ol/li[1]/input")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.3-earlystage");

			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[2]/ol/li[2]/input")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.3-metastatic");

			driver.findElement(By.name("first-name")).sendKeys("marwin");
			driver.findElement(By.name("last-name")).sendKeys("nicolas");
			driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
			driver.findElement(By.name("confirm-email-address")).sendKeys("marwin@accendgroup.com");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[7]/div[2]/div[1]/div/div")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[7]/div[2]/div[1]/div/ul/li[1]")).click();
			driver.findElement(By.name("zip-code-base")).sendKeys("95126");
			driver.findElement(By.name("primary-phone-number")).sendKeys("4084069201");
			driver.findElement(By.name("verify-age")).click();
			driver.findElement(By.className("submit")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.3-submit");

			goToUrl(driver, "/patient/breast-cancer/support-resources/support-groups.html");

			full(driver, true, savePath, "patient-4.4");

			goToUrl(driver, "/patient/breast-cancer/support-resources/download.html");

			full(driver, true, savePath, "patient-4.5");

			goToUrl(driver, "/patient/site-map.html");

			full(driver, true, savePath, "patient-sitemap");

			goToUrl(driver, "/patient/breast-cancer/glossary.html");

			full(driver, true, savePath, "patient-glossary");

			goToUrl(driver, "/patient/breast-cancer/safety.html");

			full(driver, true, savePath, "patient-safety");
		} catch (Exception e) {
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
			goToUrl(driver, "/patient/breast-cancer.html");

			visible(driver, false, savePath, "patient-home");

			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-navigation");

			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/div/div[2]/div/ul/li[1]/a/i")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-hover-1.0");

			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/div/div[2]/div/ul/li[2]/a/i")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-hover-2.0");

			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/div/div[2]/div/ul/li[3]/a/i")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-hover-3.0");

			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/div/div[2]/div/ul/li[4]/a/i")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-hover-4.0");

			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/nav/div/div[1]/ul/li[1]/a/span")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-modal-HCP");

			goToUrl(driver, "/patient/breast-cancer.html");

//				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			forceClick(driver, "//*[@id=\"safety_reference_cal_647752441\"]/div/div/div/p/a[2]");
//				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-modal-thirdpartysite");

			goToUrl(driver, "/patient/breast-cancer.html");
			full(driver, false, savePath, "patient-0.0");

			goToUrl(driver, "/patient/breast-cancer/about.html");

			full(driver, false, savePath, "patient-1.0");

			goToUrl(driver, "/patient/breast-cancer/about/HER2-positive-breast-cancer.html");

			full(driver, false, savePath, "patient-1.1");

			goToUrl(driver, "/patient/breast-cancer/about/targeted-treatment.html");

			full(driver, false, savePath, "patient-1.2");

			goToUrl(driver, "/patient/breast-cancer/about/perjeta.html");

			full(driver, false, savePath, "patient-1.3");

			goToUrl(driver, "/patient/breast-cancer/early.html");

			full(driver, false, savePath, "patient-2.0");

			goToUrl(driver, "/patient/breast-cancer/early/treatment-before-surgery.html");

			full(driver, false, savePath, "patient-2.1");

			goToUrl(driver, "/patient/breast-cancer/early/how-treatment-is-given.html");

			full(driver, false, savePath, "patient-2.2");

			goToUrl(driver, "/patient/breast-cancer/early/why-perjeta.html");

			full(driver, false, savePath, "patient-2.3");

			goToUrl(driver, "/patient/breast-cancer/early/talking-with-your-doctor.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-2.4");

			goToUrl(driver, "/patient/breast-cancer/metastatic.html");

			full(driver, false, savePath, "patient-3.0");

			goToUrl(driver, "/patient/breast-cancer/metastatic/how-treatment-is-given.html");

			full(driver, false, savePath, "patient-3.1");

			goToUrl(driver, "/patient/breast-cancer/metastatic/why-perjeta.html");

			full(driver, false, savePath, "patient-3.2");

			goToUrl(driver, "/patient/breast-cancer/metastatic/talking-with-your-team.html");

			full(driver, false, savePath, "patient-3.3");

			goToUrl(driver, "/patient/breast-cancer/support-resources.html");

			full(driver, false, savePath, "patient-4.0");

			goToUrl(driver, "/patient/breast-cancer/support-resources/4HER-patient-support-app.html");

			full(driver, false, savePath, "patient-4.1");

			goToUrl(driver, "/patient/breast-cancer/support-resources/financial-resources.html");

			full(driver, false, savePath, "patient-4.2");

			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[2]")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat1");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")));
			Thread.sleep(1000);
			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[2]")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[2]/fieldset/button[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[4]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat3");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat-q1", driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[1]/a")), new Long(1000));

			driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/div[2]/fieldset/button[1]")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat-q2", driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[3]/div[1]/a")), new Long(1000));

			driver.navigate().refresh();
			scrollAndClickAt(driver, driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[1]/header/h1")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-tab1");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[1]/header/h1")).click();
			click(driver, driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[2]/header/h1")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-tab2");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[2]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-tab3");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[3]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-tab4");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[4]/header/h1")).click();
			click(driver, driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[5]/header/h1")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-tab5");

			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[5]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[5]/div/div[2]/div/div[2]/section[6]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-tab6");

			goToUrl(driver, "/patient/breast-cancer/support-resources/herconnection.html");

			full(driver, false, savePath, "patient-4.3");

			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[2]/ol/li[1]/input")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.3-earlystage");

			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[2]/ol/li[2]/input")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.3-metastatic");

			driver.findElement(By.name("first-name")).sendKeys("marwin");
			driver.findElement(By.name("last-name")).sendKeys("nicolas");
			driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
			driver.findElement(By.name("confirm-email-address")).sendKeys("marwin@accendgroup.com");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[7]/div[2]/div[1]/div/div")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[6]/form/div[7]/div[2]/div[1]/div/ul/li[1]")).click();
			driver.findElement(By.name("zip-code-base")).sendKeys("95126");
			driver.findElement(By.name("primary-phone-number")).sendKeys("4084069201");
			driver.findElement(By.name("verify-age")).click();
			driver.findElement(By.className("submit")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.3-submit");

			goToUrl(driver, "/patient/breast-cancer/support-resources/support-groups.html");

			full(driver, false, savePath, "patient-4.4");

			goToUrl(driver, "/patient/breast-cancer/support-resources/download.html");
			full(driver, false, savePath, "patient-4.5");

			goToUrl(driver, "/patient/site-map.html");
			full(driver, false, savePath, "patient-sitemap");

			goToUrl(driver, "/patient/breast-cancer/glossary.html");
			full(driver, false, savePath, "patient-glossary");

			goToUrl(driver, "/patient/breast-cancer/safety.html");
			full(driver, false, savePath, "patient-safety");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}
}
