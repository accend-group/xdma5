package com.gene.screenshots.selenium.perjeta.hcp;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.List;
import java.util.function.Consumer;

import static com.gene.screenshots.selenium.Constants.DESKTOP_WIDTH;
import static com.gene.screenshots.selenium.Constants.MOBILE_WIDTH;

public class PerjetaHCP extends SeleniumHeadless{
	public void desktopAutomationTest(String savePath) {

		WebDriver driver = makeDesktopDriver();
		try {

			Actions action = new Actions(driver);

			goToUrl(driver, "/hcp/breast-cancer.html");
			visible(driver, true, savePath, "hcp-home");

			action.moveToElement(driver.findElement(By.linkText("Resources"))).build().perform();
			visible(driver, true, savePath, "hcp-hover-6.0");

			forceClick(driver, driver.findElement(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])")));

			Thread.sleep(1000);
			visible(driver, true, savePath, "hcp-modal-thirdpartysite");

			driver.navigate().refresh();
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-0.0");

			goToUrl(driver, "/hcp/breast-cancer/about-perjeta.html");
			full(driver, true, savePath, "hcp-1.0");

			goToUrl(driver, "/hcp/breast-cancer/trial-designs.html");
			full(driver, true, savePath, "hcp-2.0-tab1");

			click(driver, driver.findElement(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open)")));
			full(driver, true, savePath, "hcp-2.0-tab2");

			goToUrl(driver, "/hcp/breast-cancer/efficacy.html");
			full(driver, true, savePath, "hcp-3.0-tab1");

			click(driver, driver.findElement(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open)")));
			full(driver, true, savePath, "hcp-3.0-tab2");

			goToUrl(driver, "/hcp/breast-cancer/safety-profiles.html");
			full(driver, true, savePath, "hcp-4.0-tab1");

			click(driver, driver.findElement(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open)")));
			full(driver, true, savePath, "hcp-4.0-tab2");

			goToUrl(driver, "/hcp/breast-cancer/dosing-admin.html");
			full(driver, true, savePath, "hcp-5.0-tab1");

			click(driver, driver.findElement(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open)")));
			full(driver, true, savePath, "hcp-5.0-tab2");

			goToUrl(driver, "/hcp/breast-cancer/resources.html");
			full(driver, true, savePath, "hcp-6.0");

			goToUrl(driver, "/hcp/breast-cancer/resources/financial-assistance.html");
			full(driver, true, savePath, "hcp-6.1-part1");

			scrollToElement(driver, driver.findElement(By.cssSelector("[data-track-question='q3'][data-track-action='yes']")));
			Thread.sleep(1500);
			full(driver, true, savePath, "hcp-6.1-part2");

			scrollToElement(driver, driver.findElement(By.cssSelector("[data-track-question='q5'][data-track-action='yes']")));
			Thread.sleep(1500);
			full(driver, true, savePath, "hcp-6.1-part3");

			click(driver, driver.findElement(By.cssSelector("[data-track-action='no'][data-track-question='q1']")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-pat1-part1");

			action.moveToElement(driver.findElement(By.cssSelector("[data-track-result='result_gatcf'] div :nth-child(6)"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-pat1-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			click(driver, "[data-track-question='q1'][data-track-action='yes']");
			Thread.sleep(1000);
			click(driver, "[data-track-question='q2'][data-track-action='yes']");
			Thread.sleep(1000);
			click(driver, "[data-track-question='q3'][data-track-action='yes']");
			Thread.sleep(1000);
			click(driver, "[data-track-question='q4'][data-track-action='no']");
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-pat2-part1");

			action.moveToElement(driver.findElement(By.cssSelector("[style='display: block;'] div :nth-child(6)"))).build().perform();
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-pat2-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			click(driver, "[data-track-question='q1'][data-track-action='yes']");
			Thread.sleep(1000);
			click(driver, "[data-track-question='q2'][data-track-action='yes']");
			Thread.sleep(1000);
			click(driver, "[data-track-question='q3'][data-track-action='no']");
			Thread.sleep(1000);
			click(driver, "[data-track-question='q5'][data-track-action='yes']");
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-pat3-part1");

            action.moveToElement(driver.findElement(By.cssSelector("[style='display: block;'] div :nth-child(6)"))).build().perform();
            Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-pat3-part2");

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			click(driver, "[data-track-question='q1'][data-track-action='yes']");
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-6.1-q1", driver.findElement(By.className("more-info")), 1000L);

			scrollAndClickAt(driver, driver.findElement(By.className("start-over")));
			Thread.sleep(1000);


			List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__title"));
			for(int i = 0; i < tabs.size(); ++i){
				click(driver, tabs.get(i));
				Thread.sleep(1000);
				full(driver, true, savePath, "hcp-6.1-tab" + i);
				click(driver, tabs.get(i));
			}


			goToUrl(driver, "/hcp/breast-cancer/resources/downloads.html");
			full(driver, true, savePath, "hcp-6.2");

			goToUrl(driver, "/hcp/breast-cancer/contact.html");
			full(driver, true, savePath, "hcp-contact-rep");

			// resize to capture the drop down menu content
			driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, getDocHeight(driver)));
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='specialty']")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-contact-rep-provider");

			driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, getDocHeight(driver)));
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='specialty']")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-contact-rep-specialty");

			goToUrl(driver, "/hcp/breast-cancer/register.html");
			full(driver, true, savePath, "hcp-register");

			driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, getDocHeight(driver)));
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='provider-type']")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-register-classification");

			driver.manage().window().setSize(new Dimension(DESKTOP_WIDTH, getDocHeight(driver)));
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='specialty']")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-register-specialty");


			forceClick(driver, driver.findElement(By.cssSelector("[data-field='name-prefix']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='DR']")));
			Thread.sleep(1000);
			driver.findElement(By.name("first-name")).sendKeys("marwin");
			driver.findElement(By.name("last-name")).sendKeys("nicolas");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='state']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='AK']")));
			driver.findElement(By.name("zip-code-base")).sendKeys("99501");
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='provider-type']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='CC']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='specialty']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='HO']")));
			driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
			Thread.sleep(1000);
			driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
			forceClick(driver, driver.findElement(By.className("submit")));
			Thread.sleep(1000);
			full(driver, true, savePath, "hcp-register-submit");

			goToUrl(driver, "/hcp/breast-cancer/isi.html");
			full(driver, true, savePath, "hcp-safety");

			goToUrl(driver, "/hcp/site-map.html");
			full(driver, true, savePath, "hcp-sitemap");

			goToUrl(driver, "/hcp/breast-cancer/references.html");
			full(driver, true, savePath, "hcp-references");

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



			goToUrl(driver, "/hcp/breast-cancer.html");
			visible(driver, false, savePath, "hcp-home");
			
			click(driver, driver.findElement(By.cssSelector(".fa.fa-bars.gene-component--header__toggle-icon--menu")));
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-navigation");
			
			click(driver, ".fa.fa-chevron-down.gene-component--navigation__icon");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-hover-6.0");
			

			click(driver, ".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-modal-thirdpartysite");
			
			goToUrl(driver, "/hcp/breast-cancer.html");

			full(driver, false, savePath, "hcp-0.0");
			
			goToUrl(driver, "/hcp/breast-cancer/about-perjeta.html");
			full(driver, false, savePath, "hcp-1.0");
			
			goToUrl(driver, "/hcp/breast-cancer/trial-designs.html");
			full(driver, false, savePath, "hcp-2.0-tab1");

			click(driver, ".gene-component--accordionTabs__item.is-open .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			click(driver, ".gene-component--accordionTabs__item--tab2 .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-2.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/efficacy.html");
			full(driver, false, savePath, "hcp-3.0-tab1");

			click(driver, ".gene-component--accordionTabs__item.is-open .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			click(driver, ".gene-component--accordionTabs__item--tab2 .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			scrollTo(driver, 0, getDocHeight(driver));
			full(driver, false, savePath, "hcp-3.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/safety-profiles.html");
			full(driver, false, savePath, "hcp-4.0-tab1");

			click(driver, ".gene-component--accordionTabs__item.is-open .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			click(driver, ".gene-component--accordionTabs__item--tab2 .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-4.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/dosing-admin.html");
			full(driver, false, savePath, "hcp-5.0-tab1");

			click(driver, ".gene-component--accordionTabs__item.is-open .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			click(driver, ".gene-component--accordionTabs__item--tab2 .gene-component--accordionTabs__header");
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-5.0-tab2");
			
			goToUrl(driver, "/hcp/breast-cancer/resources.html");
			full(driver, false, savePath, "hcp-6.0");
			
			goToUrl(driver, "/hcp/breast-cancer/resources/financial-assistance.html");
			full(driver, false, savePath, "hcp-6.1");
			
			scrollAndClickAt(driver,driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='no']")));
			Thread.sleep(1500);
			full(driver, false, savePath, "hcp-6.1-pat1");
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
            Thread.sleep(1000);
            forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")));
            Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='yes']")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q3'][data-track-action='yes']")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q4'][data-track-action='no']")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-pat2");
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q2'][data-track-action='yes']")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q3'][data-track-action='no']")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q3'][data-track-action='yes']")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-pat3");
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);
			scrollAndClickAt(driver,driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='no']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-action='update-response'][style='display: inline-block;']")));
			Thread.sleep(1000);
			forceClick(driver, driver.findElement(By.cssSelector("[data-track-question='q1'][data-track-action='yes']")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-6.1-q1", driver.findElement(By.className("more-info")), new Long(1000));
			
			scrollAndClickAt(driver,driver.findElement(By.className("start-over")));
			Thread.sleep(1000);

			List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__title"));
			for(int i = 0; i < tabs.size(); ++i){
				click(driver, tabs.get(i));
				Thread.sleep(1000);
				full(driver, false, savePath, "hcp-6.1-tab" + i);
				click(driver, tabs.get(i));
			}
			
			goToUrl(driver, "/hcp/breast-cancer/resources/downloads.html");
			full(driver, false, savePath, "hcp-6.2");
			
			goToUrl(driver, "/hcp/breast-cancer/contact.html");
			full(driver, false, savePath, "hcp-contact-rep");

			// resize to capture the drop down menu content
			driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
			driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[3]/form/div[1]/div[1]/div/div")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-contact-rep-provider");

			
			driver.navigate().refresh();
			waitForPageLoad(driver);
			driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
			click(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[3]/form/div[1]/div[2]/div/div")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-contact-rep-specialty");
			
			goToUrl(driver, "/hcp/breast-cancer/register.html");
			full(driver, false, savePath, "hcp-register");

			driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
			click(driver, driver.findElement(By.xpath("/html/body/main/section[2]/div[2]/div[1]/div[4]/form/div[5]/div[1]/div/div")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register-classification");
			
			driver.navigate().refresh();
			waitForPageLoad(driver);
			driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
			click(driver, driver.findElement(By.cssSelector("[data-field='specialty']")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register-specialty");

			forceClick(driver, driver.findElement(By.cssSelector("[data-field='name-prefix']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='DR']")));
			driver.findElement(By.name("first-name")).sendKeys("marwin");
			driver.findElement(By.name("last-name")).sendKeys("nicolas");
			driver.findElement(By.name("address-line-1")).sendKeys("CA");
			driver.findElement(By.name("address-line-2")).sendKeys("CA");
			driver.findElement(By.name("city")).sendKeys("CA");
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='state']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='AK']")));
			driver.findElement(By.name("zip-code-base")).sendKeys("99501");
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='provider-type']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='CC']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-field='specialty']")));
			forceClick(driver, driver.findElement(By.cssSelector("[data-value='HO']")));
			driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
			Thread.sleep(1000);
			driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
			forceClick(driver, driver.findElement(By.className("submit")));
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-register-submit");
			
			goToUrl(driver, "/hcp/breast-cancer/isi.html");
			full(driver, false, savePath, "hcp-safety");
			
			goToUrl(driver, "/hcp/site-map.html");
			full(driver, false, savePath, "hcp-sitemap");
			
			goToUrl(driver, "/hcp/breast-cancer/references.html");
			full(driver, false, savePath, "hcp-references");

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
	 }
}
