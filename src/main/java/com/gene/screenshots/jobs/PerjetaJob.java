package com.gene.screenshots.jobs;


import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.perjeta.Perjeta;


@Job(name = "Perjeta", ID = 4, info = "Perjeta mobile code")
public class PerjetaJob extends ScreenshotJob {

    public PerjetaJob(){
        setScript(new Perjeta());
    }


}
