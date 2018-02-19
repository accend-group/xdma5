package com.gene.screenshots.jobs;


import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;


@Job(name = "Access_Solutions_ES", ID = 10, info = "Screenshot automation for Access Solutions Spanish.")
@Environment(local = "http://localhost:4503/content/accesssolutions-site/es",
        dev = "https://dev-genentech-access.gene.com/es",
        stage = "https://stage-genentech-access.gene.com/es",
        prod = "https://www.genentech-access.com/es",
        authorlocal = "http://localhost:4502/content/accesssolutions-site/es",
        authordev = "https://dev-author.aem.gene.com/content/accesssolutions-site/es",
        authorprod = "https://author.aem.gene.com/content/accesssolutions-site/es",
        authorstage =  "https://stage-author.aem.gene.com/content/accesssolutions-site/es")
public class AccessSolutionsSpanishJob extends ScreenshotJob {

    public AccessSolutionsSpanishJob() {
        setScripts(AccessSolutionsJob.createAccessSolutionsTestList());
    }


}


