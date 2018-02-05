package com.gene.screenshots.jobs;

import com.gene.screenshots.Variables;
import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.AccessSolutionsBase;
import com.gene.screenshots.selenium.accesssolutions.custom.Patient;

import java.util.LinkedList;
import java.util.List;

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

    protected static List<SeleniumHeadless> createAccessSolutionsTestList() {
        List<SeleniumHeadless> result = new LinkedList<>();

        // patient has its own class that extends AccessSolutionsBase
        result.add(new Patient());

        result.add(new AccessSolutionsBase("Actemra"));
        result.add(new AccessSolutionsBase("Alecensa"));
        result.add(new AccessSolutionsBase("Avastin"));
        result.add(new AccessSolutionsBase("Cotellic"));
        result.add(new AccessSolutionsBase("Erivedge"));
        result.add(new AccessSolutionsBase("Esbriet"));
        result.add(new AccessSolutionsBase("Gazyva"));
        result.add(new AccessSolutionsBase("Hemlibra"));
        result.add(new AccessSolutionsBase("Herceptin"));
        result.add(new AccessSolutionsBase("Kadcyla"));
        result.add(new AccessSolutionsBase("Lucentis"));
        result.add(new AccessSolutionsBase("Ocrevus"));
        // not up on prod, dev, and stage
        // result.add(new AccessSolutionsBase("Pegasys"));

        result.add(new AccessSolutionsBase("Perjeta"));
        result.add(new AccessSolutionsBase("Pulmozyme"));
        result.add(new AccessSolutionsBase("Rituxan/Rituxan-NHL-CLL"));
        result.add(new AccessSolutionsBase("Rituxan/Rituxan-RA"));
        result.add(new AccessSolutionsBase("Rituxan/Rituxan-GPAMPA"));
        result.add(new AccessSolutionsBase("RituxanHycela"));
        result.add(new AccessSolutionsBase("Tarceva"));
        result.add(new AccessSolutionsBase("Tecentriq"));
        result.add(new AccessSolutionsBase("Venclexta"));
        result.add(new AccessSolutionsBase("Xolair"));
        result.add(new AccessSolutionsBase("Zelboraf"));

        return result;
    }
}
