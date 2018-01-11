package com.gene.screenshots.jobs;

import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;

@Job(name = "Kadcyla_Patient", ID = 3, info = "Screenshot automation for Kadcyla Patient")
@Environment(local = "http://localhost:4503/content/kadcyla/en_us",
        dev = "https://dev-kadcyla.gene.com",
        stage = "https://stage-kadcyla.gene.com",
        prod = "https://www.kadcyla.com",
        authorlocal = "http://localhost:4502/content/kadcyla/en_us",
        authordev = "https://dev-author.aem.gene.com/content/kadcyla/en_us",
        authorprod = "https://author.aem.gene.com/content/kadcyla/en_us",
        authorstage =  "http://stage-author.aem.gene.com/content/kadcyla/en_us")

public class KadcylaPatientJob extends ScreenshotJob {

    public KadcylaPatientJob() {
        setScript(new KadcylaPatient());
    }
}

