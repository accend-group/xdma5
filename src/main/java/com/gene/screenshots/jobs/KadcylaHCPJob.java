package com.gene.screenshots.jobs;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;

@Job(name = "Kadcyla_HCP", ID = 2, info = "Screenshot automation for Kadcyla HCP.")
@Environment(dev = "https://dev-kadcyla.gene.com",
        prod = "https://www.kadcyla.com",
        stage = "https://stage-kadcyla.gene.com",
        local = "http://localhost:4503/content/kadcyla/en_us")

public class KadcylaHCPJob extends ScreenshotJob {

    @Override
    public void createResult() {
        screenshotTest = new KadcylaHCP();
        super.createResult();
    }

    @Override
    public void sendResult(AmazonS3 s3) {
        super.sendResult(s3);
    }
}

