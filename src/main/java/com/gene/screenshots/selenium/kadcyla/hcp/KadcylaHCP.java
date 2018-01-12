package com.gene.screenshots.selenium.kadcyla.hcp;


import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.gene.screenshots.selenium.Constants.MOBILE_WIDTH;

public class KadcylaHCP extends SeleniumHeadless {


    @Override
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions action = new Actions(driver);
            WebElement element;

            goToUrl(driver, "/hcp.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-0.0");

            goToUrl(driver, "/hcp/about-kadcyla.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-1.0");
            goToUrl(driver, "/hcp/about-kadcyla/molecular-structure.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-1.1");
            goToUrl(driver, "/hcp/about-kadcyla/proposed-moa.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-1.2");
            goToUrl(driver, "/hcp/about-kadcyla/patient-eligibility.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-1.3");

            goToUrl(driver, "/hcp/trial-design.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-2.0");

            goToUrl(driver, "/hcp/efficacy.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-3.0");

            goToUrl(driver, "/hcp/safety-profile.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-4.0");

            goToUrl(driver, "/hcp/dosing-administration.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-5.0");

            goToUrl(driver, "/hcp/resources.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.0");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1");

            //driver.manage().window().setSize(new Dimension(1612,750));
            jse.executeScript("window.scrollTo(0, 0)");

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat1-yes");

            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat2-yes");

            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat3-yes");

            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat4-yes");

            driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat1-no");

            driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            movecursor(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat2-no");

            scrollAndClickAt(driver,  driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat3-no");

            driver.findElement(By.className("start-over")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();


            //scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button");
            WebElement e = driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button"));//.click();


            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat4-no");

            driver.findElement(By.className("start-over")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat5-yes");

            driver.findElement(By.className("start-over")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-pat5-no");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,700)");
            driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-tab1");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,900)");
            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-tab2");

            //driver.manage().window().setSize(new Dimension(1612,780));
            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,1200)");
            movecursor(driver);
            scrollAndClickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q3")));
            //driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-tab3");

            //driver.manage().window().setSize(new Dimension(1612,750));
            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,1300)");
            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-tab4");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,1400)");
            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.1-tab5");

            goToUrl(driver, "/hcp/resources/downloads.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-6.2");

            goToUrl(driver, "/hcp/contact.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-contact-rep");
            driver.findElement(By.className("gene-component--dropdown")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-contact-rep-provider-type");
            driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-contact-rep-specialty");
            //driver.manage().window().maximize();

            //contact-reg - not available since there is captcha
//		driver.findElement(By.className("gene-component--dropdown")).click();	
//		driver.findElement(By.xpath("//li[@data-value='REF']")).click();
//		driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
//		driver.findElement(By.xpath("//li[@data-value='HO']")).click();
//		driver.findElement(By.name("first-name")).sendKeys("Marwin");
//		driver.findElement(By.name("last-name")).sendKeys("Nicolas");
//		driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.name("zip-code-base")).sendKeys("99501");
//		driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
//		driver.findElement(By.name("practice-name")).sendKeys("Accend group");

            goToUrl(driver, "/hcp/register.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-register");
            driver.findElement(By.xpath("//form/div[5]/div/div/div")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-register-classification");
            driver.findElement(By.xpath("//form/div[5]/div[2]/div/div")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-register-specialty");

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
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-register-signup");

            goToUrl(driver, "/hcp/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-safety");
            goToUrl(driver, "/hcp/sitemap.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-sitemap");
            goToUrl(driver, "/hcp/references.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-hcp-references");

            goToUrl(driver, "/hcp.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hcp");

            element = driver.findElement(By.linkText("About KADCYLA"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hcp-hover-1.0");

            element = driver.findElement(By.linkText("Resources"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hcp-hover-6.0");

            driver.navigate().refresh();
            waitForPageLoad(driver);
            jse.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
            waitForPageLoad(driver);


            List<WebElement> thirdPartyLinks = driver.findElements(By.cssSelector(".gene-template__safety a[href^='http']:not([href*='gene.com']):not([href*='racopay.com']):not([href*='genentech-access.com'])"));
            for(WebElement link : thirdPartyLinks)
                if(link.getText().equals("www.fda.gov/medwatch"))
                    forceClick(driver,link);
            jse.executeScript("window.scrollTo(0,0)", "");
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hcp-link-modal");

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
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            goToUrl(driver, "/hcp.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-0.0");

            goToUrl(driver, "/hcp/about-kadcyla.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-1.0");

            goToUrl(driver, "/hcp/about-kadcyla/molecular-structure.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-1.1");

            goToUrl(driver, "/hcp/about-kadcyla/proposed-moa.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-1.2");

            goToUrl(driver, "/hcp/about-kadcyla/patient-eligibility.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-1.3");

            goToUrl(driver, "/hcp/trial-design.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-2.0");

            goToUrl(driver, "/hcp/efficacy.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-3.0");

            goToUrl(driver, "/hcp/safety-profile.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-4.0");

            goToUrl(driver, "/hcp/dosing-administration.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-5.0");

            goToUrl(driver, "/hcp/resources.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.0");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1");

            ///jse.executeScript("window.scrollTo(0, 0)");
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat1-yes");

            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat2-yes");

            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat3-yes");

            //jse.executeScript("window.scrollTo(0, 0)");

            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat4-yes");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat2-no");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat3-no");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();

            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat5-yes");

            // --- >> button hover error << --- //
            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat1-no");

            // --- >> error button << --- //
            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();

            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat4-no");

            // --- >> error button << --- //
            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);

            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);

            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
            scrollAndClickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[5]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-pat5-no");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,900)", "");

            scrollAndClickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));
            //driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-tab1");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-tab2");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,1200)", "");
            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-tab3");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,1300)", "");
            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-tab4");

            goToUrl(driver, "/hcp/resources/financial-assistance.html");
            remove(driver);
            jse.executeScript("window.scrollBy(0,1400)", "");
            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.1-tab5");

            goToUrl(driver, "/hcp/resources/downloads.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-6.2");

            goToUrl(driver, "/hcp/contact.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-contact-rep");

            driver.findElement(By.className("gene-component--dropdown")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-contact-rep-provider-type");
            driver.navigate().refresh();
            driver.findElement(By.xpath("//form/div/div[2]/div/div")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-contact-rep-specialty");

            goToUrl(driver, "/hcp/register.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-register");
            driver.findElement(By.xpath("//form/div[5]/div/div/div")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-register-classification");
            driver.navigate().refresh();
            driver.findElement(By.xpath("//form/div[5]/div[2]/div/div")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-register-specialty");

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
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-register-signup");

            goToUrl(driver, "/hcp/safety.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-safety");
            goToUrl(driver, "/hcp/sitemap.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-sitemap");

            goToUrl(driver, "/hcp/references.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-hcp-mobile-references");

            goToUrl(driver, "/hcp.html");
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-hcp-mobile");

            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("gene-component--navigation__icon--tab")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-hcp-mobile-hover-1.0");

            driver.navigate().refresh();
            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//nav/div/div[2]/div/ul/li[6]/a/i")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-hcp-mobile-hover-6.0");

            driver.navigate().refresh();

            jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
            scrollAndClickAt(driver, driver.findElement(By.linkText("www.fda.gov/medwatch")));
            //driver.findElement(By.linkText("www.fda.gov/medwatch")).click();
            jse.executeScript("window.scrollTo(0,0)", "");
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-hcp-mobile-link-modal");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }


    public static void remove(WebDriver driver) throws InterruptedException {

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.className("gene-component--spotlight"));
        js.executeScript("arguments[0].setAttribute('style', 'height:0% !important;')",element);*/

    }

    public static void movecursor(WebDriver driver) {
        Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.name("q"));
        actions.moveToElement(mainMenu);
        actions.click().build().perform();
    }
}
