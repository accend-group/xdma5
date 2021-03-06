package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.tnkase.Tnkase;

@Job(name = "Tnkase", ID = 8, info = "Screenshot automation for Tnkase")
@Environment(local = "http://localhost:8080",
		dev = "https://dev-tnkase.gene.com",
		stage = "https://stage-tnkase.gene.com",
		prod = "https://www.tnkase.com")

public class TnkaseJob extends ScreenshotJob{
    public TnkaseJob() {
	    setScript(new Tnkase());
	}
}
