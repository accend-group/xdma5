package com.companyname.myapp.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebListenerImpl extends AbstractWebDriverEventListener { //implements WebDriverEventListener {

    private WebDriver driver;

    public WebListenerImpl(WebDriver driver){
        this.driver = driver;
    }

    public void beforeAlertAccept(WebDriver var1){}

    public void afterAlertAccept(WebDriver var1){}

    public void afterAlertDismiss(WebDriver var1){}

    public void beforeAlertDismiss(WebDriver var1){}

    public void beforeNavigateTo(String var1, WebDriver var2){
        System.out.println(var1 + " NAVIGATE BEFORE");
    }

    public void afterNavigateTo(String var1, WebDriver var2){
        System.out.println(var1 + " NAVIGATE AFTER");
    }

    public void beforeNavigateBack(WebDriver var1){}

    public void afterNavigateBack(WebDriver var1){
        System.out.println("back button click!");
    }

    public void beforeNavigateForward(WebDriver var1){}

    public void afterNavigateForward(WebDriver var1){}

    public void beforeNavigateRefresh(WebDriver var1){}

    public void afterNavigateRefresh(WebDriver var1){}

    public void beforeFindBy(By var1, WebElement var2, WebDriver var3){}

    public void afterFindBy(By var1, WebElement var2, WebDriver var3){}

    public void beforeClickOn(WebElement var1, WebDriver var2){}

    public void afterClickOn(WebElement var1, WebDriver var2){}

    public void beforeChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3){}

    public void afterChangeValueOf(WebElement var1, WebDriver var2, CharSequence[] var3){}

    public void beforeScript(String var1, WebDriver var2){}

    public void afterScript(String var1, WebDriver var2){}

    public void onException(Throwable var1, WebDriver var2){}
}
