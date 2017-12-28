package com.gene.screenshots.selenium.perjeta.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class PerjetaMain extends SeleniumHeadless{
	public void desktopAutomationTest(String savePath) {
		
		WebDriver driver = makeDesktopDriver();
		
		 try {

			goToUrl(driver, "/patient.html");
			visible(driver, true, savePath, "patient-home");
			full(driver, true, savePath,  "patient-0.0");
			
			driver.findElement(By.xpath("//*[@id=\\\"safety_reference_cal_1329084969\\\"]/div/div/div/p[10]/a")).click();
			visible(driver, true, savePath, "patient-thirdpartysite");
			
			goToUrl(driver, "/hcp.html");
			visible(driver, true, savePath, "hcp-modal");
			
			driver.findElement(By.xpath("/html/body/section[2]/div[4]/div/footer/a[2]")).click();
			visible(driver, true, savePath, "HCP-home");
			full(driver, true, savePath,  "hcp-1.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header/h1")).click();
			full(driver, true, savePath,  "hcp-2.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header/h1")).click();
			full(driver, true, savePath,  "hcp-3.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header/h1")).click();
			full(driver, true, savePath,  "hcp-4.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[5]/header/h1")).click();
			full(driver, true, savePath,  "hcp-5.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[1]/header/h1")).click();
			driver.findElement(By.xpath("//*[@id=\\\"safety_reference_cal_1329084969\\\"]/div/div/div/p[2]/a")).click();
			visible(driver, true, savePath, "hcp-thirdpartysite");
			
		 }catch (Exception e) {
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
			 driver.get("http://localhost:4503/content/perjeta/en_us/patient.html");
			visible(driver, false, savePath, "patient-home");
			full(driver, false, savePath, "patient-0.0");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]/i[1]")).click();
			visible(driver, false, savePath, "patient-navigation");
			
			driver.get("http://localhost:4503/content/perjeta/en_us/patient.html");
			driver.findElement(By.xpath("//*[@id=\"safety_reference_cal_1329084969\"]/div/div/div/p[10]/a")).click();
			visible(driver, false, savePath, "patient-thirdpartysite");
			
			driver.get("http://localhost:4503/content/perjeta/en_us/hcp.html");
			visible(driver, false, savePath, "hcp-modal");
			
			driver.findElement(By.xpath("/html/body/section[2]/div[4]/div/footer/a[2]")).click();
			visible(driver, false, savePath, "hcp-home");
			full(driver, false, savePath, "hcp-1.0");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]/i[1]")).click();
			visible(driver, true, savePath, "hcp-navigation");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]/i[2]")).click();
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[1]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header/h1")).click();
			full(driver, false, savePath, "hcp-2.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header/h1")).click();
			full(driver, false, savePath, "hcp-3.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header/h1")).click();
			full(driver, false, savePath, "hcp-4.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header/h1")).click();
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[5]/header/h1")).click();
			full(driver, false, savePath, "hcp-5.0");
			
			driver.findElement(By.xpath("//*[@id=\"safety_reference_cal_1329084969\"]/div/div/div/p[2]/a")).click();
			visible(driver, false, savePath, "hcp-thirdpartysite");
		 }catch (Exception e) {
	        e.printStackTrace();
		 } finally {
	        driver.close();
	        driver.quit();
		}
	}
}
