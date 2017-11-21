package com.companyname.myapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        WebDriver driver = new FirefoxDriver();
        System.out.println( "Hello World!" );
        System.out.println("hi");
        driver.close();
    }
}
