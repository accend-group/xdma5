package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.ocrevus.Ocrevus;

@Job(name = "Ocrevus", ID = 21, info = "Automated Screenshots for the Ocrevus page")
@Environment(dev = "", prod = "", stage = "", local = "", authordev = "https://dev-author.aem.gene.com/content/ocrelizumabinfo/en_us")
public class OcrevusJob extends ScreenshotJob {
    public OcrevusJob(){
        setScript(new Ocrevus());
    }
}
