package com.gene.screenshots.selenium.accesssolutions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mobile {
	public static void main(String[] args) throws InterruptedException {
		//TODO Auto-generated method stub

		Map<String, Object> mobile = new HashMap<>();
		mobile.put("width", 320);
		mobile.put("height", 720);
		mobile.put("pixelRatio", 1.0);

		Map<String, Object> mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceMetrics", mobile);
		mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		//chromeOptions.addArguments("disable-infobars");

        chromeOptions.addArguments("--headless");
        //chromeOptions.setHeadless(true);

		WebDriver driver = new ChromeDriver(chromeOptions);
		
		mobileEmulation.put("deviceMetrics", mobile);
		mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
		
		//driver.manage().window().maximize();
		
		// start
		mobile_en.main(args, driver);
		mobile_es.main(args, driver);

		driver.quit();
	}
}
