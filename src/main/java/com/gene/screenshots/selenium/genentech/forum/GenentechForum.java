package com.gene.screenshots.selenium.genentech.forum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class GenentechForum extends SeleniumHeadless{
    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
        
        try {
            Actions action = new Actions(driver);
            
            goToUrl(driver, ".html");
            visible(driver, true, savePath, "genetech-forum");
            
            action.moveToElement(driver.findElement(By.linkText("TREND REPORTS"))).build().perform();
            visible(driver, true, savePath, "genetech-forum-hover-1.0");
            
            action.moveToElement(driver.findElement(By.linkText("PROGRAMS & TOOLS"))).build().perform();
            visible(driver, true, savePath, "genetech-forum-hover-2.0");
            
            action.moveToElement(driver.findElement(By.linkText("PEER INSIGHTS"))).build().perform();
            visible(driver, true, savePath, "genetech-forum-hover-3.0");
            
            driver.findElement(By.className("share-a-page-button")).click();
            Thread.sleep(500);
            visible(driver, true, savePath, "genentech-forum-share-modal");
            
            driver.findElement(By.name("fname")).sendKeys("Marwin");
            driver.findElement(By.name("lname")).sendKeys("Nicolas");
            driver.findElement(By.name("to-email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.xpath("//*[@id=\"share-a-page-riker-form\"]/div[2]/div/input")).click();
            Thread.sleep(1500);
            visible(driver, true, savePath, "genentech-forum-share-modal-submit");
            
            driver.navigate().refresh();
            full(driver, true, savePath, "genentech-forum-0.0-slide1");
            
            driver.findElement(By.className("right")).click();
            full(driver, true, savePath, "genentech-forum-0.0-slide2");
            
            driver.findElement(By.className("right")).click();
            full(driver, true, savePath, "genentech-forum-0.0-slide3");
              
            goToUrl(driver, "/trend-reports.html");
            full(driver, true, savePath, "genentech-forum-1.0");
            
            goToUrl(driver, "/trend-reports/oncology.html");
            full(driver, true, savePath, "genentech-forum-1.1");
            
            goToUrl(driver, "/trend-reports/respiratory.html");
            full(driver, true, savePath, "genentech-forum-1.2");
            
            goToUrl(driver, "/trend-reports/quality.html");
            full(driver, true, savePath, "genentech-forum-1.3");
            
            goToUrl(driver, "/programs-tools.html");
            full(driver, true, savePath, "genentech-forum-2.0");
            
            goToUrl(driver, "/programs-tools/reason-for-mammogram.html");
            full(driver, true, savePath, "genentech-forum-2.1");
            
            goToUrl(driver, "/programs-tools/care-manager-multiple-sclerosis-program.html");
            full(driver, true, savePath, "genentech-forum-2.2");
            
            
            goToUrl(driver, "/programs-tools/open-your-eyes-diabetic-blindness-initiative.html");
            full(driver, true, savePath, "genentech-forum-2.3");
            
            goToUrl(driver, "/programs-tools/love-your-colon-colorectal-cancer-screening-program.html");
            full(driver, true, savePath, "genentech-forum-2.4");
            
            goToUrl(driver, "/programs-tools/genentech-care-management-workshops.html");
            full(driver, true, savePath, "genentech-forum-2.5");
            
            goToUrl(driver, "/patient-centered-resources.html");
            full(driver, true, savePath, "genentech-forum-3.0");
            
            goToUrl(driver, "/population-care-peer-insights.html");
            full(driver, true, savePath, "genentech-forum-4.0");
            
            goToUrl(driver, "/population-care-peer-insights/genentech-oncology-institute.html");
            full(driver, true, savePath, "genentech-forum-4.1");
            
            goToUrl(driver, "/advances-in-complex-to-treat-diseases.html");
            full(driver, true, savePath, "genentech-forum-5.0");
            
            goToUrl(driver, "/register-for-genentech-forum-site-updates.html");
            full(driver, true, savePath, "genentech-forum-register");
            
            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("title")).sendKeys("test");
            driver.findElement(By.name("organization")).sendKeys("accend group");
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("primary-phone-number")).sendKeys("4084069201");
            driver.findElement(By.xpath("//*[@id=\"managed-care-reg-form\"]/div[11]/input")).submit();
            Thread.sleep(1500);
            full(driver, true, savePath, "genentech-forum-register-submit");
            
            goToUrl(driver, "/contact-genentech-account-manager.html");
            full(driver, true, savePath, "genentech-forum-contact");
            
            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("title")).sendKeys("test");
            driver.findElement(By.name("organization")).sendKeys("accend group");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("selected")).click();
            driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[6]/div[2]/ul/li[1]")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("primary-phone-number")).sendKeys("4084069201");
            driver.findElement(By.name("my-request")).click();
            driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[12]/input")).submit();
            Thread.sleep(1500);
            full(driver, true, savePath, "genentech-forum-contact-submit");
            
            goToUrl(driver, "/sitemap.html");
            full(driver, true, savePath, "genentech-forum-sitemap");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
    public void mobileAutomationTest(String savePath) {
        WebDriver driver = makeMobileDriver();
        
        try {
            
            goToUrl(driver, ".html");
            visible(driver, false, savePath, "genetech-forum-mobile");
            
            driver.findElement(By.className("navbar-toggle")).click();
            visible(driver, false, savePath, "genetech-forum-mobile-nav");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[1]/a")).click();
            visible(driver, false, savePath, "genetech-forum-mobile-hover-1.0");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[2]/a")).click();
            visible(driver, false, savePath, "genetech-forum-mobile-hover-2.0");
            
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[4]/a")).click();
            visible(driver, false, savePath, "genetech-forum-mobile-hover-3.0");
            
            driver.navigate().refresh();
            full(driver, false, savePath, "genentech-forum-mobile-0.0-slide1");
            
            driver.findElement(By.xpath("//*[@id=\"herocarousel-herocarousel\"]/ol/li[2]")).click();
            full(driver, false, savePath, "genentech-forum-mobile-0.0-slide2");
            
            driver.findElement(By.xpath("//*[@id=\"herocarousel-herocarousel\"]/ol/li[3]")).click();
            full(driver, false, savePath, "genentech-forum-mobile-0.0-slide3");
              
            goToUrl(driver, "/trend-reports.html");
            full(driver, false, savePath, "genentech-forum-mobile-1.0");
            
            goToUrl(driver, "/trend-reports/oncology.html");
            full(driver, false, savePath, "genentech-forum-mobile-1.1");
            
            goToUrl(driver, "/trend-reports/respiratory.html");
            full(driver, false, savePath, "genentech-forum-mobile-1.2");
            
            goToUrl(driver, "/trend-reports/quality.html");
            full(driver, false, savePath, "genentech-forum-mobile-1.3");
            
            goToUrl(driver, "/programs-tools.html");
            full(driver, false, savePath, "genentech-forum-mobile-2.0");
            
            goToUrl(driver, "/programs-tools/reason-for-mammogram.html");
            full(driver, false, savePath, "genentech-forum-mobile-2.1");
            
            goToUrl(driver, "/programs-tools/care-manager-multiple-sclerosis-program.html");
            full(driver, false, savePath, "genentech-forum-mobile-2.2");
            
            
            goToUrl(driver, "/programs-tools/open-your-eyes-diabetic-blindness-initiative.html");
            full(driver, false, savePath, "genentech-forum-mobile-2.3");
            
            goToUrl(driver, "/programs-tools/love-your-colon-colorectal-cancer-screening-program.html");
            full(driver, false, savePath, "genentech-forum-mobile-2.4");
            
            goToUrl(driver, "/programs-tools/genentech-care-management-workshops.html");
            full(driver, false, savePath, "genentech-forum-mobile-2.5");
            
            goToUrl(driver, "/patient-centered-resources.html");
            full(driver, false, savePath, "genentech-forum-mobile-3.0");
            
            goToUrl(driver, "/population-care-peer-insights.html");
            full(driver, false, savePath, "genentech-forum-mobile-4.0");
            
            goToUrl(driver, "/population-care-peer-insights/genentech-oncology-institute.html");
            full(driver, false, savePath, "genentech-forum-mobile-4.1");
            
            goToUrl(driver, "/advances-in-complex-to-treat-diseases.html");
            full(driver, false, savePath, "genentech-forum-mobile-5.0");
            
            goToUrl(driver, "/register-for-genentech-forum-site-updates.html");
            full(driver, false, savePath, "genentech-forum-mobile-register");
            
            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("title")).sendKeys("test");
            driver.findElement(By.name("organization")).sendKeys("accend group");
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("primary-phone-number")).sendKeys("4084069201");
            driver.findElement(By.xpath("//*[@id=\"managed-care-reg-form\"]/div[11]/input")).submit();
            Thread.sleep(2000);
            full(driver, false, savePath, "genentech-forum-mobile-register-submit");
            
            goToUrl(driver, "/contact-genentech-account-manager.html");
            full(driver, false, savePath, "genentech-forum-contact");
            
            driver.findElement(By.name("first-name")).sendKeys("Marwin");
            driver.findElement(By.name("last-name")).sendKeys("Nicolas");
            driver.findElement(By.name("title")).sendKeys("test");
            driver.findElement(By.name("organization")).sendKeys("accend group");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.className("selected")).click();
            driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[6]/div[2]/ul/li[1]")).click();
            driver.findElement(By.name("zip-code-base")).sendKeys("99501");
            driver.findElement(By.name("email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("confirm_email-address")).sendKeys("marwin@accendgroup.com");
            driver.findElement(By.name("primary-phone-number")).sendKeys("4084069201");
            driver.findElement(By.name("my-request")).click();
            driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[12]/input")).submit();
            Thread.sleep(2000);
            full(driver, false, savePath, "genentech-forum-mobile-contact-submit");
            
            goToUrl(driver, "/sitemap.html");
            full(driver, false, savePath, "genentech-forum-mobile-sitemap");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
