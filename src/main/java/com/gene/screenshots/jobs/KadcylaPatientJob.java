package com.gene.screenshots.jobs;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.kadcyla.patient.KadcylaPatient;

@Job(name = "Kadcyla_Patient", ID = 3, info = "Screenshot automation for Kadcyla Patient")
public class KadcylaPatientJob extends ScreenshotJob {

    public KadcylaPatientJob(){
        super.screenshotCode = new KadcylaPatient();
    }

    @Override
    public void createResult() {
        super.createResult();
    }

    @Override
    public void sendResult(AmazonS3 s3) {
        super.sendResult(s3);
    }
}
