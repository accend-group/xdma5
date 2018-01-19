package com.gene.screenshots.selenium.perjeta.main;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;

import java.util.List;


public class PerjetaMain extends SeleniumHeadless {
	public void desktopAutomationTest(String savePath) {

		WebDriver driver = makeDesktopDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			goToUrl(driver, "/patient.html");
			visible(driver, true, savePath, "patient-home");

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			List<WebElement> thirdPartyLinks = driver.findElements(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
			for (WebElement link : thirdPartyLinks)
				if (link.getText().equals("www.fda.gov/medwatch"))
					click(driver, link);
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-thirdpartysite");

			goToUrl(driver, "/patient.html");

			full(driver, true, savePath, "patient-0.0");

			goToUrl(driver, "/hcp.html");

			// wait for fade in modal
			Thread.sleep(500);

			visible(driver, true, savePath, "hcp-modal");

			// click the I am a hcp button on modal
			click(driver, driver.findElement(By.cssSelector("[style='display: block;']  .gene-component--modal__button.gene-component--modal__button--confirm.gene-component--button.gene-component--button--medium")));

			// click scrolled to the element, scrolling back up to the page after clicking
			click(driver, driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])")));
			scrollTo(driver, 0, 0);
			Thread.sleep(1000);
			visible(driver, true, savePath, "hcp-thirdpartysite");

			goToUrl(driver, "/hcp.html");

			// wait for fade in modal
			Thread.sleep(500);

			// click the I am a hcp button on modal
			click(driver, driver.findElement(By.cssSelector("[style='display: block;']  .gene-component--modal__button.gene-component--modal__button--confirm.gene-component--button.gene-component--button--medium")));
			Thread.sleep(1000);
			visible(driver, true, savePath, "hcp-home");

			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-1.0");

			List<WebElement> notOpenTabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open)"));
			for(int i = 2; i < notOpenTabs.size() + 2; ++i){
				click(driver, notOpenTabs.get(i - 2));
				Thread.sleep(1000);
				full(driver, true, savePath, "hcp-" + i +".0");
			}

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
			goToUrl(driver, "/patient.html");
			visible(driver, false, savePath, "patient-home");

			click(driver, driver.findElement(By.cssSelector(".fa.fa-bars.gene-component--header__toggle-icon--menu")));
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-navigation");

			goToUrl(driver, "/patient.html");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(500);
			List<WebElement> thirdPartyLinks = driver.findElements(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
			for (WebElement link : thirdPartyLinks)
				if (link.getText().equals("www.fda.gov/medwatch"))
					forceClick(driver, link);
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-thirdpartysite");

			goToUrl(driver, "/patient.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-0.0");

			goToUrl(driver, "/hcp.html");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-modal");

			// click the I am a hcp button on modal
			click(driver, driver.findElement(By.cssSelector("[style='display: block;']  .gene-component--modal__button.gene-component--modal__button--confirm.gene-component--button.gene-component--button--medium")));
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-home");

			click(driver, driver.findElement(By.cssSelector(".fa.fa-bars.gene-component--header__toggle-icon--menu")));
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-navigation");


			forceClick(driver,driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])")));
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-thirdpartysite");

			goToUrl(driver, "/hcp.html");
			Thread.sleep(500);
			click(driver, driver.findElement(By.cssSelector("[style='display: block;']  .gene-component--modal__button.gene-component--modal__button--confirm.gene-component--button.gene-component--button--medium")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-1.0");

			WebElement openedTab = driver.findElement(By.cssSelector(".gene-component--accordionTabs__item.is-open .gene-component--accordionTabs__header"));
			List<WebElement> closedTabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open) .gene-component--accordionTabs__header"));

			click(driver, openedTab);
			Thread.sleep(500);
			forceClick(driver, closedTabs.get(0));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-2.0");

			forceClick(driver, closedTabs.get(0));
			Thread.sleep(500);
			forceClick(driver, closedTabs.get(1));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-3.0");

			forceClick(driver, closedTabs.get(1));
			Thread.sleep(500);
			forceClick(driver, closedTabs.get(2));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-4.0");

			forceClick(driver, closedTabs.get(2));
			Thread.sleep(500);
			forceClick(driver, closedTabs.get(3));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-5.0");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
			driver.quit();
		}
	}
}
