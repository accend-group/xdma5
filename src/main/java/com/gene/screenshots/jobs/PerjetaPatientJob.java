package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.perjeta.patient.PerjetaPatient;

@Job(name = "Perjeta_Patient", ID = 5, info = "Screenshot automation for Perjeta Patient")
public class PerjetaPatientJob extends ScreenshotJob{
	 public PerjetaPatientJob() {
	        super.screenshotCode = new PerjetaPatient();
	    }
}
