package com.gene.screenshots.selenium.kadcyla.hcp;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gene.screenshots.Variables;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;
import com.gene.screenshots.utils.Screenshots;


public class KadcylaHCP {

    private static Screenshots screenshots;

    public static void setScreenshots(Screenshots screenshots){
        KadcylaHCP.screenshots = screenshots;
    }

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
        desktop.setScreenshots(screenshots);
		desktop.automation(Variables.getSavePath() + "/desktop/kadcylaHCP");
		mobile.setScreenshots(screenshots);
		mobile.automation( Variables.getSavePath() + "/mobile/kadycylaHCP");
	}
}
