package com.gene.screenshots.selenium.accesssolutions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class desktop {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-infobars");
		options.addArguments("--headless");


		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().setSize(new Dimension(1600, 1200));
		//driver.manage().window().maximize();
		
		// start
		desktop_en.main(args, driver);
		desktop_es.main(args, driver);
		
		driver.quit();
	}
}
