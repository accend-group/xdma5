package com.gene.screenshots.selenium.kadcyla.patient;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.function.Consumer;

import static com.gene.screenshots.Constants.MOBILE_WIDTH;

public class KadcylaPatient extends SeleniumHeadless {

    @Override
    public void desktopAutomationTest(String savePath) {

        WebDriver driver = makeDesktopDriver();

        try {
            Consumer<WebDriver> movecursor = (d) -> {
                Actions actions = new Actions(d);
                WebElement mainMenu = d.findElement(By.name("q"));
                actions.moveToElement(mainMenu);
                actions.click().build().perform();
            };

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Actions action = new Actions(driver);
            WebElement element;

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-patient");

            element = driver.findElement(By.linkText("KADCYLA and HER2+ Metastatic Breast Cancer"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hover-1.0");

            element = driver.findElement(By.linkText("About KADCYLA"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hover-2.0");

            element = driver.findElement(By.linkText("Support and Resources"));
            action.moveToElement(element).build().perform();
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-hover-3.0");

            driver.navigate().refresh();
            jse.executeScript("window.scrollTo(0,1000)", "");
            driver.findElement(By.linkText("http://www.motherpregnancyregistry.com/")).click();
            jse.executeScript("window.scrollTo(0,0)", "");
            Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-link-modal");

//		driver.navigate().refresh();
//		driver.findElement(By.className("genentech-component--button__text")).click();
//		Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-share-modal");
//
//		driver.findElement(By.name("fname")).sendKeys("Marwin");
//		driver.findElement(By.name("lname")).sendKeys("Nicolas");
//		driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
//		driver.findElement(By.xpath("/html/body/section[2]/div[3]/div/div/form/div/div[3]/input")).click();
//		Thread.sleep(1000);
            visible(driver, true, savePath, "kadcyla-share-modal-submit");

            //		//--->start full page screenshot <---//

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-0.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-1.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-1.1");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer/treatment.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-1.2");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-2.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/dosing-and-administration.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-2.1");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/benefits-risks.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-2.2");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/talk-with-healthcare-team.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-2.3");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/4HER-patient-support-app.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.1");

            //driver.manage().window().setSize(new Dimension(1612,750));
            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat1-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat2-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat3-no");

            jse.executeScript("window.scrollTo(0, 0)");

            clickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat4-yes");

            //jse.executeScript("window.scrollTo(0, 0)");

            clickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat1-no");

            //jse.executeScript("window.scrollTo(0, 0)");

            clickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat2-no");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat3-yes");

            jse.executeScript("window.scrollTo(0, 0)");
            clickAt(driver, driver.findElement(By.className("start-over")));//.click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            //scrollTo(driver, 0,500);
            clickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();

            driver.manage().window().setSize(new Dimension(MOBILE_WIDTH, getDocHeight(driver)));
            clickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            movecursor.accept(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-pat4-no");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);

            clickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));
            //driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-tab1");
            driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-tab2");
            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-tab3");
            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-tab4");
            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-tab5");
            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.2-tab6");
            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();


            //driver.manage().window().maximize();
            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/herconnection-support-program.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.3");

            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("confirm-email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.className("submit")).click();

            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.3-submit");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/breast-cancer-support-groups.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.4");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/downloads.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-3.5");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/safety.html");
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-safety");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/site-map.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-sitemap");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/glossary.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, true, savePath, "kadcyla-glossary");
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

        Consumer<WebDriver> movemouse = (d) -> {
            Actions action = new Actions(d);
            WebElement element;
            element = d.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div[2]/div[1]/a[2]/i[1]"));
            action.moveToElement(element).build().perform();
        };

        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //driver.manage().window().maximize();

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-mobile-patient");

            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("gene-component--navigation__icon--tab")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-mobile-hover-1.0");

            driver.navigate().refresh();
            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//nav/div/div[2]/div/ul/li[2]/a/i")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-mobile-hover-2.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
            driver.findElement(By.className("gene-component--header__toggle-icon--menu")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//nav/div/div[2]/div/ul/li[3]/a/i")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-mobile-hover-3.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
            jse.executeScript("window.scrollBy(0,3500)", "");
            driver.findElement(By.linkText("http://www.motherpregnancyregistry.com/")).click();
            Thread.sleep(1000);
            visible(driver, false, savePath, "kadcyla-mobile-link-modal");

//		//--->start full page screenshot <---//

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-0.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-1.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer/what-is-her2-positive.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-1.1");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/her2-positive-breast-cancer/treatment.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-1.2");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-2.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/benefits-risks.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-2.2");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/talk-with-healthcare-team.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-2.3");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.0");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/4HER-patient-support-app.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.1");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/herconnection-support-program.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.3");

            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("confirm-email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("address-line-1")).sendKeys("CA");
            driver.findElement(By.name("address-line-2")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("gene-component--dropdown")).click();
            driver.findElement(By.xpath("//li[@data-value='AK']")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("primary-phone-number")).sendKeys("(02) 243-51-02");
            driver.findElement(By.name("verify-age")).click();
            driver.findElement(By.className("submit")).click();

            Thread.sleep(1000);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.3-submit");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/breast-cancer-support-groups.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.4");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/downloads.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.5");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/safety.html");
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-safety");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/site-map.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-sitemap");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/glossary.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-glossary");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/about-kadcyla/dosing-and-administration.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-2.1");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);

            clickAt(driver, "/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]");
            //WebElement e = driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[2]/div[1]/ul/li[1]/div[2]/fieldset/button[1]"));
            //e.click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat1-yes");
            //jse.executeScript("window.scrollTo(0, 0)");

            clickAt(driver, "//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button");
            //driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat2-yes");
            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat3-no");
            //jse.executeScript("window.scrollTo(0, 0)");
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat4-yes");
            //jse.executeScript("window.scrollTo(0, 0)");

            clickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat1-no");

            //jse.executeScript("window.scrollTo(0, 0)");
            clickAt(driver, driver.findElement(By.className("start-over")));
            //driver.findElement(By.className("start-over")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat2-no");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat3-yes");

            //jse.executeScript("window.scrollTo(0, 0)");
            //driver.findElement(By.className("start-over")).click();
            clickAt(driver, driver.findElement(By.className("start-over")));
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[2]/div[2]/fieldset/button")).click();
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[3]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//main/section[2]/div/div/div/div/div[2]/div/ul/li[4]/div[2]/fieldset/button[2]")).click();
            Thread.sleep(1000);
            movemouse.accept(driver);
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-pat4-no");

            driver.get("http://localhost:4503/content/kadcyla/en_us/patient/support-resources/financial-resources.html");
            remove(driver);
            clickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));
            //driver.findElement(By.className("gene-component--accordionTabs__item--q1")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab1");
            clickAt(driver, driver.findElement(By.className("gene-component--accordionTabs__item--q1")));


            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab2");
            driver.findElement(By.className("gene-component--accordionTabs__item--q2")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab3");
            driver.findElement(By.className("gene-component--accordionTabs__item--q3")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab4");
            driver.findElement(By.className("gene-component--accordionTabs__item--q4")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab5");
            driver.findElement(By.className("gene-component--accordionTabs__item--q5")).click();


            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();
            Thread.sleep(1000);
            full(driver, false, savePath, "kadcyla-mobile-3.2-tab6");
            driver.findElement(By.className("gene-component--accordionTabs__item--q6")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }


    private void remove(WebDriver driver) {
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("/html/body/section[1]/div[2]/div/div/div"));
        js.executeScript("arguments[0].setAttribute('style', 'height:0% !important;')", element);*/
    }
}
