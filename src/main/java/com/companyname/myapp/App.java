package com.companyname.myapp;

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
 * Hello world!
 *
 */
public class App
{

    private static String REMOVE_IMSAFETY_SCRIPT;
    static{
        try {
            REMOVE_IMSAFETY_SCRIPT = new Scanner(new File("src/main/java/com/companyname/myapp/javascript/remove_imsafety.js")).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args )
    {
        PDFMaker pdfMaker = new PDFMaker();
        Selenium localBrowser = new Selenium();
        //localBrowser.setRemoteServer("http://0.0.0.0:4444/wd/hub");
        localBrowser.start(false);

        localBrowser.get("https://www.perjeta.com/patient/site-map.html");
        //pdfMaker.addImg(localBrowser.getVisibleScreenshot());

        List<String> links = null;
        try {
            links = (List<String>) localBrowser.runJS(new Scanner(new File("src/main/java/com/companyname/myapp/javascript/get_all_links.js")).useDelimiter("\\Z").next());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (String page : links) {
            localBrowser.get(page);
            //localBrowser.runJS(" document.getElementById('mobile-uh-wrapper').style = 'position:absolute!important;';");

            pdfMaker.addImg(localBrowser.getVisibleScreenshot());
            localBrowser.runJS(REMOVE_IMSAFETY_SCRIPT);
            pdfMaker.addImg(localBrowser.getFullPageScreenshot());
        }

        pdfMaker.createPDF();
        pdfMaker.savePDF("perjetaDesktop.pdf");
        try {
            pdfMaker.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        localBrowser.stop();
    }
}
