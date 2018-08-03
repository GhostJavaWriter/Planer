package com.nadtsalov.dayplaner;

import java.io.*;
import java.util.Properties;

public class Config {

    private String configFilename =
            System.getProperty("user.home") + File.separator + "planerConfig.properties";

    public void openConfig(){

        Properties props = new Properties();
        try {
            FileInputStream input = new FileInputStream(configFilename);
            props.load(input);
            input.close();
        } catch(Exception ignore) { }
        try {
            File file = new File(props.getProperty("dir"));
            new OpenTask().openTask(file);
        }catch (NullPointerException ignore){ }

    }
    public void saveConfig(File fileDir) {
        //save directory of saved file in config
        String configFilename =
                System.getProperty("user.home") + File.separator + "planerConfig.properties";
        Properties props = new Properties();
        props.setProperty("dir", fileDir.toString());

        try {
            FileOutputStream output = new FileOutputStream(configFilename);
            props.store(output, "Saved directory");
            output.close();
        } catch(Exception ignore) { }
    }
}
