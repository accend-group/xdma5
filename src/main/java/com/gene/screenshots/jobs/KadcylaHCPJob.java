package com.gene.screenshots.jobs;

import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.kadcyla.hcp.KadcylaHCP;

@Job(name = "Kadcyla_HCP", ID = 2, info = "Screenshot automation for Kadcyla HCP.")
@Environment(local = "http://localhost:4503/content/kadcyla/en_us",
        dev = "https://dev-kadcyla.gene.com",
        stage = "https://stage-kadcyla.gene.com",
        prod = "https://www.kadcyla.com",
        authorlocal = "http://localhost:4502/content/kadcyla/en_us",
        authordev = "https://dev-author.aem.gene.com",
        authorprod = "https://author.aem.gene.com",
        authorstage =  "http://stage-author.aem.gene.com")
public class KadcylaHCPJob extends ScreenshotJob {

    public KadcylaHCPJob(){
        setScript(new KadcylaHCP());
    }
}

