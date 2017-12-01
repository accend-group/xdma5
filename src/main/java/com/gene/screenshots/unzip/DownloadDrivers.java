package com.gene.screenshots.unzip;

import com.google.gson.JsonObject;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

// downloads correct chrome driver and gecko driver, 64bit only for now except windows chrome driver
public class DownloadDrivers {

    public static void main(String[] args) {

        String OS = System.getProperty("os.name").toLowerCase();
        System.out.println(OS);
        String userOS = null;
        if(OS.contains("win"))
            userOS = "win";
        if(OS.contains("mac"))
            userOS = "mac";
        if(userOS == null)
            userOS = "linux";

        // download chrome driver
        try {
            URL url = new URL("https://chromedriver.storage.googleapis.com/LATEST_RELEASE");
            Scanner s = new Scanner(url.openStream());
            String chromeVersion = s.nextLine();

            String filename = "chromedriver_" + userOS + (userOS.contains("win") ? "32.zip" : "64.zip");
            String chromeDriverDownloadURL = "https://chromedriver.storage.googleapis.com/" + chromeVersion + "/" + filename;
            System.out.println(chromeDriverDownloadURL);
            downloadFromURL(chromeDriverDownloadURL, "zip");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // download gecko driver
        String geckReleaseURL = "https://api.github.com/repos/mozilla/geckodriver/releases/latest";
        try {
            JSONObject json = new JSONObject(IOUtils.toString(new URL(geckReleaseURL), Charset.forName("UTF-8")));
            JSONArray assets = json.getJSONArray("assets");
            for(Object item : assets) {
                JSONObject geckoOS = new JSONObject(item.toString());
                String name = geckoOS.getString("name");
                if(name.contains(userOS)) {
                    String downloadURL = geckoOS.getString("browser_download_url");
                    System.out.println(downloadURL);
                    // windows drivers are zip files
                    downloadFromURL(downloadURL, userOS.contains("win") ? "zip" : "tar.gz");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // downloads content in zip/tar.gz
    private static void downloadFromURL(String url, String type){
        try {
            InputStream zipStream = null;
            HttpsURLConnection con = (HttpsURLConnection) new URL(url).openConnection();
            if(con.getResponseCode() == HttpURLConnection.HTTP_OK)
                zipStream = con.getInputStream();
            if(zipStream == null){
                System.out.println("Error: issue with stream!");
                System.exit(1);
            }

            ArchiveInputStream ais = type.contains("gz") ? new TarArchiveInputStream(new GZIPInputStream(zipStream)): new ArchiveStreamFactory().createArchiveInputStream(type, zipStream);
            ArchiveEntry zipFiles = ais.getNextEntry();
            while(zipFiles != null){
                File outputFile = new File(".", zipFiles.getName());

                // set permission only to current user
                if(!outputFile.setExecutable(true, true)){
                    System.out.println("Error: can't sent permissions!");
                    //System.exit(1);
                }

                OutputStream os = new FileOutputStream(outputFile);

                IOUtils.copy(ais, os);
                os.close();
                zipFiles = ais.getNextEntry();
            }
            ais.close();
            zipStream.close();

            //Files.copy(zipStream, Paths.get(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
