package com.gene.screenshots.jobs;

import java.util.LinkedList;
import java.util.List;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.es.Actemra;
import com.gene.screenshots.selenium.accesssolutions.es.Alecensa;
import com.gene.screenshots.selenium.accesssolutions.es.Avastin;
import com.gene.screenshots.selenium.accesssolutions.es.Cotellic;
import com.gene.screenshots.selenium.accesssolutions.es.Erivedge;
import com.gene.screenshots.selenium.accesssolutions.es.Esbriet;
import com.gene.screenshots.selenium.accesssolutions.es.Gazyva;
import com.gene.screenshots.selenium.accesssolutions.es.Hemlibra;
import com.gene.screenshots.selenium.accesssolutions.es.Herceptin;
import com.gene.screenshots.selenium.accesssolutions.es.Kadcyla;
import com.gene.screenshots.selenium.accesssolutions.es.Lucentis;
import com.gene.screenshots.selenium.accesssolutions.es.Ocrevus;
import com.gene.screenshots.selenium.accesssolutions.es.Patient;
import com.gene.screenshots.selenium.accesssolutions.es.Perjeta;
import com.gene.screenshots.selenium.accesssolutions.es.Pulmozyme;
import com.gene.screenshots.selenium.accesssolutions.es.RituxanGPAMPA;
import com.gene.screenshots.selenium.accesssolutions.es.RituxanHycela;
import com.gene.screenshots.selenium.accesssolutions.es.RituxanNHLCLL;
import com.gene.screenshots.selenium.accesssolutions.es.RituxanRA;
import com.gene.screenshots.selenium.accesssolutions.es.Tarceva;
import com.gene.screenshots.selenium.accesssolutions.es.Tecentriq;
import com.gene.screenshots.selenium.accesssolutions.es.Venclexta;
import com.gene.screenshots.selenium.accesssolutions.es.Xolair;
import com.gene.screenshots.selenium.accesssolutions.es.Zelboraf;

@Job(name = "Access_Solutions_ES", ID = 10, info = "Screenshot automation for Access Solutions Spanish.")
@Environment(local = "http://localhost:4503/content/accesssolutions-site/es",
        dev = "",
        stage = "",
        prod = "",
        authorlocal = "http://localhost:4502/content/accesssolutions-site/es",
        authordev = "https://dev-author.aem.gene.com/content/accesssolutions-site/es")

        // not up
        //authorprod = "https://author.aem.gene.com/content/accesssolutions-site/es",
        //authorstage =  "https://stage-author.aem.gene.com/content/accesssolutions-site/es")

public class AccessSolutionsSpanishJob extends ScreenshotJob {

    public AccessSolutionsSpanishJob() {
        setScripts(createAccessSolutionsTestList());
    }

    private static List<SeleniumHeadless> createAccessSolutionsTestList() {
        List<SeleniumHeadless> result = new LinkedList<>();
        result.add(new Actemra());
        result.add(new Alecensa());
        result.add(new Avastin());
        result.add(new Cotellic());
        result.add(new Erivedge());
        result.add(new Esbriet());
        result.add(new Gazyva());
        result.add(new Hemlibra());
        result.add(new Herceptin());
        result.add(new Kadcyla());
        result.add(new Lucentis());
        result.add(new Ocrevus());
        result.add(new Patient());
        result.add(new Perjeta());
        result.add(new Pulmozyme());
        result.add(new RituxanGPAMPA());
        result.add(new RituxanNHLCLL());
        result.add(new RituxanRA());
        result.add(new RituxanHycela());
        result.add(new Tarceva());
        result.add(new Tecentriq());
        result.add(new Venclexta());
        result.add(new Xolair());
        result.add(new Zelboraf());
        return result;
    }
}


