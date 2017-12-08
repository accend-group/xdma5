package com.gene.screenshots.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Log {
    private LinkedList<String> items = new LinkedList<>();
    private String logName = "log";

    public void add(String item){
        items.add(item);
    }

    public void clear(){
        items.clear();
    }

    public Log setLogName(String name){
        logName = name;
        return this;
    }

    public void save(String savePath){
        // store string items names in log file
        try {
            Path file = Paths.get(savePath + "/"  +logName +".txt");
            Files.write(file, items, Charset.forName("UTF-8"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
