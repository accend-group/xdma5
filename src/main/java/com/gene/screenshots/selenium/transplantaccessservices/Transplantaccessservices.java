package com.gene.screenshots.selenium.transplantaccessservices;

import org.openqa.selenium.WebDriver;

import com.gene.screenshots.selenium.SeleniumHeadless;

public class Transplantaccessservices extends SeleniumHeadless {

    public void desktopAutomationTest(String savePath) {
        WebDriver driver = makeDesktopDriver();
    
        try {
            
            goToUrl(driver, "/");
            visible(driver, true, savePath, "visible-home");
            full(driver, true, savePath, "full-home");
            
            goToUrl(driver, "/genentech-transplant-patient-assistance-services-overview");
            full(driver, true, savePath, "gtas");
            
            goToUrl(driver, "/transplant-medicine-reimbursement-process");
            full(driver, true, savePath, "process");
            
            goToUrl(driver, "/valcyte-cellcept-patient-assistance-forms");
            full(driver, true, savePath, "downlodable-forms");
            
            goToUrl(driver, "/myGTASconnection-transplant-medication-support");
            full(driver, true, savePath, "support");
            
            goToUrl(driver, "/valcyte-cellcept-prior-authorization");
            full(driver, true, savePath, "authorization");
            
            goToUrl(driver, "/transplant-patient-benefits-investigation");
            full(driver, true, savePath, "investigation");
            
            goToUrl(driver, "/valcyte-cellcept-appeals-process");
            full(driver, true, savePath, "appeals-process");
            
            goToUrl(driver, "/valcyte-cellcept-copay-cards");
            full(driver, true, savePath, "copay-cards");
            
            goToUrl(driver, "/transplant-copay-assistance-foundations");
            full(driver, true, savePath, "copay-assistance");
            
            goToUrl(driver, "/genentech-access-to-care-foundation");
            full(driver, true, savePath, "access-to-care");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }
    }
}
