package kspcal.utils;

import java.io.*;
import java.util.Properties;

public class KSPConfig {

    private Properties properties;
    
    private String propName = "KSPConfig.cfg";
    
    public KSPConfig() {
    	properties = new Properties();
    	try {
    		properties.load(new FileInputStream(propName));
    	} catch (IOException e) {
    		
    	}
    }
    
    public void saveConfig() {
    	// Write properties file.
    	try {
    	    properties.store(new FileOutputStream(propName), null);
    	} catch (IOException e) {
    	}
    }
    
    public void setDirectory(String dir) {
    	properties.setProperty("directory", dir);
    }
    
    public String getDirectory() {
    	return properties.getProperty("directory");
    }
}
