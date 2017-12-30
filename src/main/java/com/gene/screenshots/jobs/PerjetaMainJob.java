package com.gene.screenshots.jobs;

import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.perjeta.main.PerjetaMain;

@Job(name = "Perjeta_Main", ID = 5, info = "Screenshot automation for Perjeta Main")
public class PerjetaMainJob extends ScreenshotJob {
	
    public PerjetaMainJob() {
        super.screenshotCode = new PerjetaMain();
    }
}
