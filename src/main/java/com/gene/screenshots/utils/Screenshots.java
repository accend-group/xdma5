package com.gene.screenshots.utils;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshots {

    private Log log;

    public void setLog(Log log){
        this.log = log;
    }

    public void full(WebDriver driver, String path, String screenshotName) throws InterruptedException{
        Thread.sleep(1000);

        Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS,500, true)
                .withName(screenshotName)
                .save(path);
        File outputImg = new File(path + "/" + screenshotName + ".png");
        log.add(outputImg.getAbsolutePath());
    }

    public void visible(WebDriver driver, String path, String screenshotName) {
        try {
            Thread.sleep(1000);
            TakesScreenshot ts =(TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File outputImg = new File( path + "/" + screenshotName+".png");
            FileUtils.copyFile(source, outputImg);
            log.add(outputImg.getAbsolutePath());
        }
        catch (Exception e) {
            System.out.println("Exception while taking visible part screenshot" + e.getMessage());
        }
    }
}
