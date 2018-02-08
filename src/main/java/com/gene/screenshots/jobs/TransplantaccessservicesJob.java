package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.transplantaccessservices.Transplantaccessservices;

@Job(name = "transplantaccessservices", ID = 11, info = "Screenshot automation for transplantaccessservices")
@Environment(local = "http://localhost:8080",
        dev = "https://dev-transplantaccessservices.gene.com",
        stage = "https://stage-transplantaccessservices.gene.com",
        prod = "http://www.transplantaccessservices.com")

public class TransplantaccessservicesJob extends ScreenshotJob{
    public TransplantaccessservicesJob() {
        setScript(new Transplantaccessservices());
    }
}

