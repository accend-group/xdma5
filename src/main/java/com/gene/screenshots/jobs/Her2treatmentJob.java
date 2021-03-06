package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.her2treatment.Her2treatment;

@Job(name = "Her2treatment", ID = 7, info = "Screenshot automation for Her2treatment")
@Environment(local = "http://localhost:4503/content/her2treatment/en_us",
        dev = "https://dev-her2treatment.gene.com",
        stage = "https://stage-her2treatment.gene.com",
        prod = "https://www.her2treatment.com",
        authorlocal="http://localhost:4502/content/her2treatment/en_us",
        authordev = "https://dev-author.aem.gene.com/content/her2treatment/en_us",
        authorstage="https://stage-author.aem.gene.com/content/her2treatment/en_us",
        authorprod="https://author.aem.gene.com/content/her2treatment/en_us")

public class Her2treatmentJob extends ScreenshotJob{
	
    public Her2treatmentJob() {
        setScript(new Her2treatment());
	}
}
