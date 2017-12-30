package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.perjeta.hcp.PerjetaHCP;

@Job(name = "Perjeta_HCP", ID = 7, info = "Screenshot automation for Perjeta HCP")
public class PerjetaHCPJob extends ScreenshotJob {

	    public PerjetaHCPJob(){
	        super.screenshotCode = new PerjetaHCP();
	    }
}
