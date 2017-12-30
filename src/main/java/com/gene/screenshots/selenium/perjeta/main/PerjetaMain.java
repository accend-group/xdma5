package com.gene.screenshots.selenium.perjeta.main;

import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;


public class PerjetaMain extends SeleniumHeadless{
	public void desktopAutomationTest(String savePath) {
		// mvn compile exec:java -Dexec.cleanupDaemonThreads=false "-Dexec.args=jobtype=5 environment=local pdfbreakpoint=true"
		WebDriver driver = makeDesktopDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 try {

			goToUrl(driver, "/patient.html");
			visible(driver, true, savePath, "patient-home");
			
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.xpath("//*[@id=\"safety_reference_cal_1329084969\"]/div/div/div/p[10]/a")).click();
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, true, savePath, "patient-thirdpartysite");
			
			goToUrl(driver, "/patient.html");
			Thread.sleep(1000);
			full(driver, true, savePath,  "patient-0.0");
			
			goToUrl(driver, "/hcp.html");
			Thread.sleep(1000);
			visible(driver, true, savePath, "hcp-modal");
			
			driver.findElement(By.xpath("/html/body/section[2]/div[4]/div/footer/a[2]")).click();
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"safety_reference_cal_1329084969\"]/div/div/div/p[2]/a")).click();
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, true, savePath, "hcp-thirdpartysite");
			
			goToUrl(driver, "/hcp.html");
			driver.findElement(By.xpath("/html/body/section[2]/div[4]/div/footer/a[2]")).click();
			Thread.sleep(1000);
			visible(driver, true, savePath, "hcp-home");
			
			Thread.sleep(1000);
			full(driver, true, savePath,  "hcp-1.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath,  "hcp-2.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath,  "hcp-3.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath,  "hcp-4.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[5]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, true, savePath,  "hcp-5.0");
			
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
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 try {
			goToUrl(driver, "/patient.html");
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-home");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]/i[1]")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-navigation");
			
			goToUrl(driver, "/patient.html");
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"safety_reference_cal_1329084969\"]/div/div/div/p[10]/a")).click();
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, false, savePath, "patient-thirdpartysite");
			
			goToUrl(driver, "/patient.html");
			Thread.sleep(1000);
			full(driver, false, savePath, "patient-0.0");
			
			goToUrl(driver, "/hcp.html");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-modal");
			
			driver.findElement(By.xpath("/html/body/section[2]/div[4]/div/footer/a[2]")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-home");
			
			driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/div[1]/a[2]/i[1]")).click();
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-navigation");
			
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"safety_reference_cal_1329084969\"]/div/div/div/p[2]/a")).click();
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(1000);
			visible(driver, false, savePath, "hcp-thirdpartysite");
			
			goToUrl(driver, "/hcp.html");
			driver.findElement(By.xpath("/html/body/section[2]/div[4]/div/footer/a[2]")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-1.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[1]/header/h1")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-2.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[2]/header/h1")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-3.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[3]/header/h1")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-4.0");
			
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[4]/header/h1")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/html/body/main/section[3]/div[1]/div[2]/div/div[2]/section[5]/header/h1")).click();
			Thread.sleep(1000);
			full(driver, false, savePath, "hcp-5.0");
		
		 }catch (Exception e) {
	        e.printStackTrace();
		 } finally {
	        driver.close();
	        driver.quit();
		}
	}
}
