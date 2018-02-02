package com.gene.screenshots.selenium.perjeta.patient;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
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
			driver.findElement(By.name("to-email-address")).sendKeys("test@gene.com");
			driver.findElement(By.xpath("/html/body/section[2]/div[3]/div/div/form/div/div[3]/input")).click();
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-share-submit");*/


			goToUrl(driver, "/patient/breast-cancer.html");

			forceClick(driver, driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])")));
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-modal-thirdpartysite");

			goToUrl(driver, "/patient/breast-cancer.html");
			setStyle(driver, "display: block;", ".gene-template__modals.exclude-from-glossary");
			setStyle(driver, "display: block;", ".gene-template__modals.exclude-from-glossary .gene-component--modal.gene-component--modal--hcp-interstitial");
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

			action.moveToElement(driver.findElement(By.cssSelector(".question_areyou18yearsofageorolder.disabled"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-part2");

			click(driver, "[data-track-question='q1'][data-track-action='no']");
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat1-part1");

			action.moveToElement(driver.findElement(By.cssSelector("[style='display: block;'] .results-container p:last-child"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat1-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			click(driver, "[data-track-question='q1'][data-track-action='yes']");
			Thread.sleep(1000);
			scrollAndClickAt(driver, driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='no']")));
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat2-part1");

			action.moveToElement(driver.findElement(By.cssSelector("[style='display: block;'] .results-container p:last-child"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat2-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")).click();
			scrollAndClickAt(driver, driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='yes'")));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q3'][data-track-action='no']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q4'][data-track-action='yes']")).click();
			movecursor.accept(driver);
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat3-part1");

			action.moveToElement(driver.findElement(By.cssSelector("[style='display: block;'] .results-container p:last-child"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat3-part2");

			click(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")).click();
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat-q1", driver.findElement(By.cssSelector(".active .more-info")), 1000L);

			click(driver, "[data-track-question='q2'][data-track-action='yes']");
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.2-pat-q2", driver.findElement(By.cssSelector(".active .more-info")), 1000L);

			driver.navigate().refresh();


			List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__title"));
			for(int i = 0; i < tabs.size(); ++i){
				click(driver, tabs.get(i));
				waitForElementToExist(driver, ".is-open");
				// accordion animation
				Thread.sleep(450);
				full(driver, true, savePath, "hcp-6.1-tab" + i);
				click(driver, tabs.get(i));
				Thread.sleep(450);
			}

			goToUrl(driver, "/patient/breast-cancer/support-resources/herconnection.html");

			full(driver, true, savePath, "patient-4.3");

			click(driver, "[name='perjeta-personal-description'][value='early no surgery']");
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.3-earlystage");

			click(driver, "[name='perjeta-personal-description'][value='metastatic']");
			Thread.sleep(1000);
			full(driver, true, savePath, "patient-4.3-metastatic");

			driver.findElement(By.name("first-name")).sendKeys("Test");
			driver.findElement(By.name("last-name")).sendKeys("Test");
			driver.findElement(By.name("email-address")).sendKeys("test@gene.com");
			driver.findElement(By.name("confirm_email-address")).sendKeys("test@gene.com");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			driver.findElement(By.cssSelector(".gene-component--dropdown__select [data-field='state']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-value='AK']")).click();
			driver.findElement(By.name("zip-code-base")).sendKeys("99999");
			driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
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

			driver.findElement(By.cssSelector(".gene-component--header__toggle--navigation")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-navigation");

			List<WebElement> dropDownMenu = driver.findElements(By.cssSelector(".fa.fa-chevron-down.gene-component--navigation__icon"));
			for(int i = 0; i < dropDownMenu.size(); ++i){
				click(driver, dropDownMenu.get(i));
				// move cursor so there's no mouse hover on the elements from the opened tab
				moveMouse(driver, 0, 0);
				Thread.sleep(1000);
				visible(driver, false, savePath, "patient-hover-" + i);
			}



			forceClick(driver, driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])")));
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-modal-thirdpartysite");

			goToUrl(driver, "/patient/breast-cancer.html");
			setStyle(driver, "display: block;", ".gene-template__modals.exclude-from-glossary");
			setStyle(driver, "display: block;", ".gene-template__modals.exclude-from-glossary .gene-component--modal.gene-component--modal--hcp-interstitial");
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-modal-HCP");

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

			scrollAndClickAt(driver, driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='no']")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat1");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			scrollAndClickAt(driver, driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")));
			Thread.sleep(1000);
			scrollAndClickAt(driver, driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='no']")));
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='yes']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q3'][data-track-action='no']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q4'][data-track-action='yes']")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat3");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")).click();
			Thread.sleep(1000);

			List<WebElement> popovers = driver.findElements(By.cssSelector(".more-info"));
			full(driver, false, savePath, "patient-4.2-pat-q1", popovers.get(0), 1000L);

			driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='yes']")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.2-pat-q2", popovers.get(1), 1000L);

			driver.navigate().refresh();

			List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__title"));
			for(int i = 0; i < tabs.size(); ++i){
				click(driver, tabs.get(i));
				waitForElementToExist(driver, ".is-open");
				// accordion animation
				Thread.sleep(450);
				full(driver, false, savePath, "hcp-6.1-tab" + i);
				click(driver, tabs.get(i));
				Thread.sleep(450);
			}

			goToUrl(driver, "/patient/breast-cancer/support-resources/herconnection.html");

			full(driver, false, savePath, "patient-4.3");

			driver.findElement(By.cssSelector("[name='perjeta-personal-description'][value='early no surgery']")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.3-earlystage");

			driver.findElement(By.cssSelector("[name='perjeta-personal-description'][value='metastatic']")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-4.3-metastatic");

			driver.findElement(By.name("first-name")).sendKeys("Test");
			driver.findElement(By.name("last-name")).sendKeys("Test");
			driver.findElement(By.name("email-address")).sendKeys("test@gene.com");
			driver.findElement(By.name("confirm_email-address")).sendKeys("test@gene.com");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			driver.findElement(By.cssSelector(".gene-component--dropdown__select [data-field='state']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("[data-value='AK']"));
			driver.findElement(By.name("zip-code-base")).sendKeys("99999");
			driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
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
