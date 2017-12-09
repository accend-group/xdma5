package com.gene.screenshots.selenium.accesssolutions;

import com.gene.screenshots.Variables;

import java.io.IOException;


/** Creates screenshots of desktop and mobile pages from ES and EN
 *
 *  Arguments:
 *
 *  savePath - where all the images and log files will be placed at.
 *  chromedriverPath - path to chromedriver, true, optional defaults to latest chromedriver
 *
 */



public class Accesssolution {

	public static void main(String[] args) throws InterruptedException, IOException {

        String savePath = Variables.getSavePath();
		desktop.main(new String[]{savePath + "/desktop"});
		mobile.main(new String[]{savePath + "/mobile"});


	}
}