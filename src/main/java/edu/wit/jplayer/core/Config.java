package edu.wit.jplayer.core;

import java.io.*;
import java.util.Properties;

public class Config {
    private final File configPath = new File(System.getProperty("user.home") + File.separator + ".jplayer");
    private final File configFile = new File(File.separator + configPath + "config.properties");
    private final Properties properties = new Properties();


    public Config() {
        configPath.mkdirs();
    }

    public void read(){
        try (FileInputStream in = new FileInputStream(configFile)){
            properties.loadFromXML(in);
        } catch (IOException e) {
            System.out.println("Expected on first run.");
            e.printStackTrace();
        }
    }

    public void save(){
        try (OutputStream out = new FileOutputStream(configFile)) {
            properties.storeToXML(out, "JPlayer configuration.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}