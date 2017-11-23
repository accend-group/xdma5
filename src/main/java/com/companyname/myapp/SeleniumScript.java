package com.companyname.myapp;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.*;
import com.amazonaws.services.s3.model.ObjectListing;
import com.companyname.myapp.pdf.PDFMaker;
import com.companyname.myapp.selenium.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Selenium script
 *
 */
public class SeleniumScript
{
    // used to set the scroll imsafety link to the bottom
    private static String REMOVE_IMSAFETY_SCRIPT;
    static{
        try {
            REMOVE_IMSAFETY_SCRIPT = new Scanner(new File("src/main/java/com/companyname/myapp/javascript/remove_imsafety.js")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ) {
        // a remote session is doable with setRemoteServer("address-to-server") before the start method is called
        Selenium localBrowser = new Selenium();
        localBrowser.start(true);

        // gets every link on the perjeta site-map page and store the links in a list
        localBrowser.get("https://www.perjeta.com/patient/site-map.html");
        List<String> links = null;
        try {
            links = (List<String>) localBrowser.runJS(new Scanner(new File("src/main/java/com/companyname/myapp/javascript/get_all_links.js")).useDelimiter("\\Z").next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // create images for each page, a visible image then a whole page screenshot
        // mobile
        int i = 0;
        for (String page : links) {
            localBrowser.get(page);
            takeImages(localBrowser, String.valueOf(i));
            i++;
        }
        // desktop
        localBrowser.stop();
        localBrowser.start(false);
        i = 0;
        for (String page : links) {
            localBrowser.get(page);
            takeImages(localBrowser, String.valueOf(i));
            i++;
        }
        localBrowser.stop();
    }

    private static void takeImages(Selenium testBrowser, String imgName){
        testBrowser.saveVisibleScreenshot(imgName);
        testBrowser.runJS(REMOVE_IMSAFETY_SCRIPT);
        testBrowser.saveFullPageScreenshot(imgName);
    }
}
