package com.gene.screenshots.jobs;

import com.gene.screenshots.Variables;
import com.gene.screenshots.annotations.Job;
import com.gene.screenshots.selenium.OutputResult;
import com.gene.screenshots.selenium.SeleniumHeadless;
import com.gene.screenshots.selenium.accesssolutions.en.*;
import sun.jvm.hotspot.runtime.Threads;

import java.util.LinkedList;
import java.util.List;

import static com.gene.screenshots.EnvironmentType.LOCAL;

@Job(name = "Access Solutions", ID = 3432234, label = "Screenshot automation for Access Solutions.")
public class AccessSolutions implements OutputResult{

    @Override
    public void createResult() {

        // create screenshot code here
    }

    @Override
    public void sendResult(){

        // send screenshots here
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
        if (Variables.getDomain().getType() == LOCAL) // not up on prod, dev, and stage
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
