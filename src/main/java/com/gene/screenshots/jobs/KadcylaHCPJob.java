package com.gene.screenshots.jobs;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;

@Job(name = "Kadcyla_HCP", ID = 2, info = "Screenshot automation for Kadcyla HCP.")


public class KadcylaHCPJob extends ScreenshotJob {

    public KadcylaHCPJob(){
        super.screenshotCode = new KadcylaHCP();
    }
}

