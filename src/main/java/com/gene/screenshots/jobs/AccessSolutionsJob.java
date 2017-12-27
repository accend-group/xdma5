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

    private  List<SeleniumHeadless> brands;

    @Override
    public void createResult() {
        //creates screenshots and pdfs
        brands = createAccessSolutionsTestList();
        for (SeleniumHeadless accessTest : brands)
            createThreads(accessTest);
    }

    @Override
    public void sendResult(AmazonS3 s3){
        sendZipToS3(s3, brands, "access_solutions", savePath + "/zips");
    }

    private static void sendZipToS3(AmazonS3 s3, List<SeleniumHeadless> tests, String zipName, String zipPath){

        final int BUFFER = 8192;
        String pdfPaths = Variables.getPdfOutputPath();

        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream( zipPath + "/" + zipName + ".zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];

            String files[] = new String[tests.size()];
            for(int i = 0; i < tests.size(); ++i)
                files[i] = pdfPaths + "/" + tests.get(i).getClass().getSimpleName() + ".pdf";
            for (int i=0; i<files.length; i++) {
                FileInputStream fi = new FileInputStream(files[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(files[i]);
                out.putNextEntry(entry);
                int count;
                while((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

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
