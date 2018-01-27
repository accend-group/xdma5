package com.gene.screenshots.selenium.tnkase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class Tnkase extends SeleniumHeadless {
    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
	
        try {
         
            Actions actions = new Actions(driver);
        
            goToUrl(driver, "/index.jsp");
            visible(driver, true, savePath, "tnkase-home");
            
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[1]/table/tbody/tr[1]/td[3]/a/nobr"))).perform();
            visible(driver, true, savePath, "tnkase-1.0-hover");
            
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[1]/table/tbody/tr[7]/td[3]/a"))).perform();
            visible(driver, true, savePath, "tnkase-3.0-hover");
            
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[1]/table/tbody/tr[1]/td[3]/a/nobr"))).perform();
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='wrapper']/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[1]/table/tbody/tr[10]/td[3]/a"))).perform();
            visible(driver, true, savePath, "tnkase-4.0-hover");
            
            goToUrl(driver, "/index.jsp");
            full(driver, true, savePath, "tnkase-0.0");
            
            goToUrl(driver, "/tnkase-dosing-and-administration");
            full(driver, true, savePath, "tnkase-1.0");
            
            goToUrl(driver, "/tnkase-ami-treatment-kit");
            full(driver, true, savePath, "tnkase-1.1");
            
            goToUrl(driver, "/tnkase-dosing-guidelines");
            full(driver, true, savePath, "tnkase-1.2");
            
            goToUrl(driver, "/tnkase-dosing-administration-and-reconstitution");
            full(driver, true, savePath, "tnkase-1.3");
            
            goToUrl(driver, "/tnkase-molecule-investigation");
            full(driver, true, savePath, "tnkase-2.0");
            
            goToUrl(driver, "/ami-treatment-clinical-trial-data");
            full(driver, true, savePath, "tnkase-3.0");
            
            goToUrl(driver, "/assent-2-clinical-trial");
            full(driver, true, savePath, "tnkase-3.1");
            
            goToUrl(driver, "/tnkase-mortality-rate");
            full(driver, true, savePath, "tnkase-3.2");
            
            goToUrl(driver, "/tnkase-side-effects-intracranial-hemorrhage-and-stroke");
            full(driver, true, savePath, "tnkase-3.3");
            
            goToUrl(driver, "/tnkase-side-effects-major-noncerebral-bleeds-clinical-trial");
            full(driver, true, savePath, "tnkase-3.4");
            
            goToUrl(driver, "/tnkase-blood-transfusions");
            full(driver, true, savePath, "tnkase-3.5");
            
            goToUrl(driver, "/tnkase-heart-attack-survival-rate");
            full(driver, true, savePath, "tnkase-3.6");
            
            goToUrl(driver, "/timi-10b-clinical-trial");
            full(driver, true, savePath, "tnkase-3.7");
            
            goToUrl(driver, "/tnkase-ami-treatment-resources");
            full(driver, true, savePath, "tnkase-4.0");
            
            goToUrl(driver, "/tnkase-replacement-program");
            full(driver, true, savePath, "tnkase-5.0");
            
            goToUrl(driver, "/tnkase-prescribing-information");
            full(driver, true, savePath, "tnkase-6.0");
            
            goToUrl(driver, "/sitemap");
            full(driver, true, savePath, "tnkase-sitemap");
            
            goToUrl(driver, "/tnkase-search-results");
            full(driver, true, savePath, "tnkase-search");
            
            goToUrl(driver, "/tnkase-dosing-card");
            full(driver, true, savePath, "tnkase-dosing-card");
            
            driver.findElement(By.name("firstname")).sendKeys("TestFirstName");
            driver.findElement(By.name("lastname")).sendKeys("TestLastName");
            driver.findElement(By.name("profession")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='wrapper']/table/tbody/tr[3]/td[1]/table/tbody/tr/td[3]/table[2]/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/select/option[2]")).click();
            driver.findElement(By.name("specialty")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='wrapper']/table/tbody/tr[3]/td[1]/table/tbody/tr/td[3]/table[2]/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/select/option[2]")).click();
            driver.findElement(By.name("institution")).sendKeys("Test Institution");
            driver.findElement(By.name("address")).sendKeys("CA");
            driver.findElement(By.name("city")).sendKeys("CA");
            driver.findElement(By.name("state")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='state']/option[2]")).click();
            driver.findElement(By.name("zip")).sendKeys("99999");
            driver.findElement(By.name("area")).sendKeys("800");;
            driver.findElement(By.name("exch")).sendKeys("999");
            driver.findElement(By.name("phone")).sendKeys("9999");
            driver.findElement(By.name("email")).sendKeys("test@genentech.com");
            driver.findElement(By.name("quantity")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id='wrapper']/table/tbody/tr[3]/td[1]/table/tbody/tr/td[3]/table[2]/tbody/tr/td[1]/table/tbody/tr[10]/td[2]/select/option[2]")).click();
            driver.findElement(By.xpath("//*[@id='wrapper']/table/tbody/tr[3]/td[1]/table/tbody/tr/td[3]/table[2]/tbody/tr/td[1]/table/tbody/tr[12]/td/input[1]")).click();
            full(driver, true, savePath, "tnkase-dosing-card-submit");
		 	
		         
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
