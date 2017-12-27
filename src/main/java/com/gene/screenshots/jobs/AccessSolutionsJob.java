package com.gene.screenshots.jobs;

import com.amazonaws.services.s3.AmazonS3;
import com.gene.screenshots.Variables;
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

@Job(name = "Access_Solutions", ID = 1, info = "Screenshot automation for Access Solutions.")
public class AccessSolutionsJob extends ScreenshotJob {

    private  List<SeleniumHeadless> brands = createAccessSolutionsTestList();;

    @Override
    public void createResult() {
        //creates screenshots and pdfs
        for(SeleniumHeadless geneAccessBrand : brands)
           createThreads(geneAccessBrand);
    }

    @Override
    public void sendResult(AmazonS3 s3){

        sendZipToS3(s3, brands, getJobName(), savePath + "/zips");
    }

    // custom zip file creation
    private static void sendZipToS3(AmazonS3 s3, List<SeleniumHeadless> tests, String zipName, String zipPath) {


        String fileNames[] = new String[ SeleniumHeadless.isIfSinglePDF()  ? tests.size() : (tests.size() * 2)];

        for (int i = 0, j = 0; i < fileNames.length; j++)
            if (SeleniumHeadless.isIfSinglePDF())
                fileNames[i++] = tests.get(j).getClass().getSimpleName() + ".pdf";
            else {
                fileNames[i++] = "desktop_" + tests.get(j).getClass().getSimpleName() + ".pdf";
                fileNames[i++] = "mobile_" + tests.get(j).getClass().getSimpleName() + ".pdf";
            }
        createZip(fileNames, zipName, zipPath);

        System.out.println("Sending " + zipName + ".zip...");
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            s3.putObject(Variables.getBucketName(),
                    String.format("%s-%s-%s.zip", zipName, Variables.getDomain().getType(), date),
                    new File(zipPath + "/" + zipName + ".zip"));
            System.out.println("pdf sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
