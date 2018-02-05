package com.gene.screenshots.selenium.genentech.forum;

import com.gene.screenshots.selenium.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

import java.util.LinkedList;
import java.util.List;

public class GenentechForum extends SeleniumHeadless{

    public List<Thread> desktopAutomationTest() {
        setNumberOfPageVisits(1, true);
        List<Thread> desktopThread = new LinkedList<>();
        desktopThread.add(new Thread( ()-> {
            WebDriver driver = ChromeDriverManager.requestDesktopDriver();

            try {
                Actions action = new Actions(driver);

                goToUrl(driver, ".html");
                visible(driver, true, 0);

                action.moveToElement(driver.findElement(By.linkText("TREND REPORTS"))).build().perform();
                visible(driver, true, 0);

                action.moveToElement(driver.findElement(By.linkText("PROGRAMS & TOOLS"))).build().perform();
                visible(driver, true, 0);

                action.moveToElement(driver.findElement(By.linkText("PEER INSIGHTS"))).build().perform();
                visible(driver, true, 0);

                driver.findElement(By.className("share-a-page-button")).click();
                Thread.sleep(500);
                visible(driver, true, 0);

                driver.findElement(By.name("fname")).sendKeys("Test");
                driver.findElement(By.name("lname")).sendKeys("Test");
                driver.findElement(By.name("to-email-address")).sendKeys("test@gene.com");
                driver.findElement(By.xpath("//*[@id=\"share-a-page-riker-form\"]/div[2]/div/input")).click();
                Thread.sleep(1500);
                visible(driver, true, 0);

                driver.navigate().refresh();
                full(driver, true, 0);

                driver.findElement(By.className("right")).click();
                full(driver, true, 0);

                driver.findElement(By.className("right")).click();
                full(driver, true, 0);

                goToUrl(driver, "/trend-reports.html");
                full(driver, true, 0);

                goToUrl(driver, "/trend-reports/oncology.html");
                full(driver, true, 0);

                goToUrl(driver, "/trend-reports/respiratory.html");
                full(driver, true, 0);

                goToUrl(driver, "/trend-reports/quality.html");
                full(driver, true, 0);

                goToUrl(driver, "/programs-tools.html");
                full(driver, true, 0);

                goToUrl(driver, "/programs-tools/reason-for-mammogram.html");
                full(driver, true, 0);

                goToUrl(driver, "/programs-tools/care-manager-multiple-sclerosis-program.html");
                full(driver, true, 0);


                goToUrl(driver, "/programs-tools/open-your-eyes-diabetic-blindness-initiative.html");
                full(driver, true, 0);

                goToUrl(driver, "/programs-tools/love-your-colon-colorectal-cancer-screening-program.html");
                full(driver, true, 0);

                goToUrl(driver, "/programs-tools/genentech-care-management-workshops.html");
                full(driver, true, 0);

                goToUrl(driver, "/patient-centered-resources.html");
                full(driver, true, 0);

                goToUrl(driver, "/population-care-peer-insights.html");
                full(driver, true, 0);

                goToUrl(driver, "/population-care-peer-insights/genentech-oncology-institute.html");
                full(driver, true, 0);

                goToUrl(driver, "/advances-in-complex-to-treat-diseases.html");
                full(driver, true, 0);

                goToUrl(driver, "/register-for-genentech-forum-site-updates.html");
                full(driver, true, 0);

                driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
                driver.findElement(By.name("last-name")).sendKeys("TestLastName");
                driver.findElement(By.name("title")).sendKeys("Test Title");
                driver.findElement(By.name("organization")).sendKeys("Test Company");
                driver.findElement(By.name("zip-code-base")).sendKeys("99999");
                driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
                driver.findElement(By.xpath("//*[@id=\"managed-care-reg-form\"]/div[11]/input")).submit();
                Thread.sleep(1500);
                full(driver, true, 0);

                goToUrl(driver, "/contact-genentech-account-manager.html");
                full(driver, true, 0);

                driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
                driver.findElement(By.name("last-name")).sendKeys("TestLastName");
                driver.findElement(By.name("title")).sendKeys("Test Title");
                driver.findElement(By.name("organization")).sendKeys("Test Company Name");
                driver.findElement(By.name("city")).sendKeys("CA");
                driver.findElement(By.className("selected")).click();
                driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[6]/div[2]/ul/li[1]")).click();
                driver.findElement(By.name("zip-code-base")).sendKeys("99999");
                driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
                driver.findElement(By.name("my-request")).click();
                driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[12]/input")).submit();
                Thread.sleep(1500);
                full(driver, true, 0);

                goToUrl(driver, "/sitemap.html");
                full(driver, true, 0);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ChromeDriverManager.releaseDesktopDriver(driver);
            }
        }));
        return desktopThread;
    }

    public List<Thread> mobileAutomationTest() {
        setNumberOfPageVisits(1, false);
        List<Thread> mobileThead = new LinkedList<>();
        mobileThead.add(new Thread( ()-> {
            WebDriver driver = ChromeDriverManager.requestMobileDriver();

            try {

                goToUrl(driver, ".html");
                visible(driver, false, 0);

                driver.findElement(By.className("navbar-toggle")).click();
                visible(driver, false, 0);

                driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[1]/a")).click();
                visible(driver, false, 0);

                driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[2]/a")).click();
                visible(driver, false, 0);

                driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/nav/div/div[2]/div/ul/li[4]/a")).click();
                visible(driver, false, 0);

                driver.navigate().refresh();
                full(driver, false, 0);

                driver.findElement(By.xpath("//*[@id=\"herocarousel-herocarousel\"]/ol/li[2]")).click();
                full(driver, false, 0);

                driver.findElement(By.xpath("//*[@id=\"herocarousel-herocarousel\"]/ol/li[3]")).click();
                full(driver, false, 0);

                goToUrl(driver, "/trend-reports.html");
                full(driver, false, 0);

                goToUrl(driver, "/trend-reports/oncology.html");
                full(driver, false, 0);

                goToUrl(driver, "/trend-reports/respiratory.html");
                full(driver, false, 0);

                goToUrl(driver, "/trend-reports/quality.html");
                full(driver, false, 0);

                goToUrl(driver, "/programs-tools.html");
                full(driver, false, 0);

                goToUrl(driver, "/programs-tools/reason-for-mammogram.html");
                full(driver, false, 0);

                goToUrl(driver, "/programs-tools/care-manager-multiple-sclerosis-program.html");
                full(driver, false, 0);


                goToUrl(driver, "/programs-tools/open-your-eyes-diabetic-blindness-initiative.html");
                full(driver, false, 0);

                goToUrl(driver, "/programs-tools/love-your-colon-colorectal-cancer-screening-program.html");
                full(driver, false, 0);

                goToUrl(driver, "/programs-tools/genentech-care-management-workshops.html");
                full(driver, false, 0);

                goToUrl(driver, "/patient-centered-resources.html");
                full(driver, false, 0);

                goToUrl(driver, "/population-care-peer-insights.html");
                full(driver, false, 0);

                goToUrl(driver, "/population-care-peer-insights/genentech-oncology-institute.html");
                full(driver, false, 0);

                goToUrl(driver, "/advances-in-complex-to-treat-diseases.html");
                full(driver, false, 0);

                goToUrl(driver, "/register-for-genentech-forum-site-updates.html");
                full(driver, false, 0);

                driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
                driver.findElement(By.name("last-name")).sendKeys("TestLastName");
                driver.findElement(By.name("title")).sendKeys("Test Title");
                driver.findElement(By.name("organization")).sendKeys("Test Company");
                driver.findElement(By.name("zip-code-base")).sendKeys("99999");
                driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
                driver.findElement(By.xpath("//*[@id=\"managed-care-reg-form\"]/div[11]/input")).submit();
                Thread.sleep(2000);
                full(driver, false, 0);

                goToUrl(driver, "/contact-genentech-account-manager.html");
                full(driver, false, 0);

                driver.findElement(By.name("first-name")).sendKeys("TestFirstName");
                driver.findElement(By.name("last-name")).sendKeys("TestLastName");
                driver.findElement(By.name("title")).sendKeys("Test Title");
                driver.findElement(By.name("organization")).sendKeys("Test Company Name");
                driver.findElement(By.name("city")).sendKeys("CA");
                driver.findElement(By.className("selected")).click();
                driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[6]/div[2]/ul/li[1]")).click();
                driver.findElement(By.name("zip-code-base")).sendKeys("99999");
                driver.findElement(By.name("email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("confirm_email-address")).sendKeys("test@genentech.com");
                driver.findElement(By.name("primary-phone-number")).sendKeys("9999999999");
                driver.findElement(By.name("my-request")).click();
                driver.findElement(By.xpath("//*[@id=\"cam-riker-form\"]/div[12]/input")).submit();
                Thread.sleep(2000);
                full(driver, false, 0);

                goToUrl(driver, "/sitemap.html");
                full(driver, false, 0);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ChromeDriverManager.releaseMobileDriver(driver);
            }
        }));
        return mobileThead;
    }

}
