package com.gene.screenshots.jobs;

import java.util.LinkedList;
import java.util.List;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.AccessSolutionsBaseHCP;
import com.gene.screenshots.selenium.accesssolutions.custom.Patient;

@Job(name = "Access_Solutions_HCP", ID = 12, info = "Screenshot automation for Access Solutions HCP.")
@Environment(local = "http://localhost:4503/content/accesssolutions-site/en_us",
        dev = "https://dev-genentech-access.gene.com",
        stage = "https://stage-genentech-access.gene.com",
        prod = "https://www.genentech-access.com",
        authorlocal = "http://localhost:4502/content/accesssolutions-site/en_us",
        authordev = "https://dev-author.aem.gene.com/content/accesssolutions-site/en_us",
        authorprod = "https://author.aem.gene.com/content/accesssolutions-site/en_us",
        authorstage =  "https://stage-author.aem.gene.com/content/accesssolutions-site/en_us")

public class AccessSolutionsHCPJob extends ScreenshotJob {

    public AccessSolutionsHCPJob() {
        setScripts(AccessSolutionsJob.createAccessSolutionsTestListHCP());
    }
}

