package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.perjeta.hcp.PerjetaHCP;
import com.gene.screenshots.selenium.perjeta.patient.PerjetaPatient;

@Job(name = "Perjeta_Patient", ID = 5, info = "Screenshot automation for Perjeta Patient")
@Environment(local = "http://localhost:4503/content/perjeta/en_us",
dev = "https://dev-perjeta.gene.com",
stage = "https://stage-perjeta.gene.com",
prod = "https://www.perjeta.com")

public class PerjetaPatientJob extends ScreenshotJob{
	 public PerjetaPatientJob() {
		 
		 setScript(new PerjetaPatient());
		 
	    }
}
