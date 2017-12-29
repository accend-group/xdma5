package com.gene.screenshots.jobs;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;

@Job(name = "Kadcyla_Patient", ID = 3, info = "Screenshot automation for Kadcyla Patient")
public class KadcylaPatientJob extends ScreenshotJob {

    public KadcylaPatientJob() {
        setScript(new KadcylaPatient());
    }
}

