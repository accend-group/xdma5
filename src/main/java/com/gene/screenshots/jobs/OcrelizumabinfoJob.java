package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.ocrevus.Ocrelizumabinfo;

@Job(name = "OcrelizumabInfo", ID = 21, info = "Automated Screenshots for the Ocrelizumb info page")
@Environment(dev = "",
        prod = "https://www.ocrelizumabinfo.com",
        stage = "",
        local = "http://localhost:4503/content/ocrelizumabinfo/en_us",
        authordev = "https://dev-author.aem.gene.com/content/ocrelizumabinfo/en_us",
        authorstage = "https://stage-author.aem.gene.com/content/ocrelizumabinfo/en_us",
        authorprod = "https://author.aem.gene.com/content/ocrelizumabinfo/en_us",
        authorlocal= "http://localhost:4502/content/ocrelizumabinfo/en_us")
public class OcrelizumabinfoJob extends ScreenshotJob {
    public OcrelizumabinfoJob(){
        setScript(new Ocrelizumabinfo());
    }
}
