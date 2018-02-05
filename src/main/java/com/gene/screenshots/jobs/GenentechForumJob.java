package com.gene.screenshots.jobs;

import com.gene.screenshots.base.ScreenshotJob;
import com.gene.screenshots.base.annotations.Environment;
import com.gene.screenshots.base.annotations.Job;
import com.gene.screenshots.selenium.genentech.forum.GenentechForum;

@Job(name = "GenentechForum", ID = 9, info = "Screenshot automation for Genentech Forum")
@Environment(local = "http://localhost:4503/content/genentech-forum/en_us",
        dev = "https://dev-genentech-forum.gene.com",
        stage = "https://stage-genentech-forum.gene.com",
        prod = "https://www.genentech-forum.com",
        authorlocal="http://localhost:4502/content/genentech-forum/en_us",
        authordev = "https://dev-author.aem.gene.com/content/managed-care/en_us",
        authorstage="https://stage-author.aem.gene.com/content/managed-care/en_us",
        authorprod="https://author.aem.gene.com/content/managed-care/en_us")

public class GenentechForumJob extends ScreenshotJob{
    
    public GenentechForumJob() {
        setScript(new GenentechForum());
    }
}
