package com.gene.screenshots.unzip;

import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

// downloads correct chrome driver and gecko driver
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
            String chromeURL = "https://chromedriver.storage.googleapis.com/" + chromeVersion + "/chromedriver_" + userOS + "64.zip";
            System.out.println(chromeURL);
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
                if(name.contains(userOS))
                    System.out.println(geckoOS.getString("browser_download_url"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
