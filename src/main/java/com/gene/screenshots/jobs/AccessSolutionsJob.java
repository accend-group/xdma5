package com.gene.screenshots.jobs;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.Variables;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.en.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.gene.screenshots.EnvironmentType.LOCAL;

@Job(name = "Access_Solutions", ID = 1, info = "Screenshot automation for Access Solutions English.")
@Environment(local = "http://localhost:4503/content/accesssolutions-site/en_us",
        dev = "https://dev-genentech-access.gene.com",
        stage = "https://stage-genentech-access.gene.com",
        prod = "https://www.genentech-access.com",
        authorlocal = "http://localhost:4502/content/accesssolutions-site/en_us",
        authordev = "https://dev-author.aem.gene.com/content/accesssolutions-site/en_us",
        authorprod = "https://author.aem.gene.com/content/accesssolutions-site/en_us",
        authorstage =  "https://stage-author.aem.gene.com/content/accesssolutions-site/en_us")
public class AccessSolutionsJob extends ScreenshotJob {

    public AccessSolutionsJob(){
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
        if (Variables.getEnvironmentType() == LOCAL) // not up on prod, dev, and stage
            result.add(new Pegasys());
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
