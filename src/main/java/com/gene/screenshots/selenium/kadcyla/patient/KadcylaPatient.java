package com.gene.screenshots.selenium.kadcyla.patient;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gene.screenshots.Variables;
import com.gene.screenshots.utils.Screenshots;

public class KadcylaPatient {

    private static Screenshots screenshots;

    public static void setScreenshots(Screenshots screenshots){
        KadcylaPatient.screenshots = screenshots;
    }

	public static void main(String[] args) throws InterruptedException, IOException {

        desktop.setScreenshots(screenshots);
		desktop.automation(Variables.getSavePath() + "/desktop/kadcylaPatient");
        mobile.setScreenshots(screenshots);
		mobile.automation(Variables.getSavePath() + "/mobile/kadcylaPatient");

	}
}
