package kspcal.utils;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class PartsConfig {

	private static PartsConfig config;
	private Properties properties;
	private KSPConfig kspConfig;
	private ArrayList<String> dirmap;
	
	private String propName = "KSPParts.cfg";
	
	protected PartsConfig() {
		properties = new Properties();
    	try {
    		properties.load(new FileInputStream(propName));
    	} catch (IOException e) {
    		
    	}
    	kspConfig = KSPConfig.getConfig();
		checkMods();
	}
	
	public static PartsConfig getConfig() {
		if (config == null) {
			config = new PartsConfig();
		}
		return config;
	}
	
	public void saveConfig() {
    	// Write properties file.
    	try {
    	    properties.store(new FileOutputStream(propName), null);
    	} catch (IOException e) {
    	}
    }
	
	private void checkMods() {
		dirmap = new ArrayList<String>();
		traverseDirectory(new File(kspConfig.getDirectory() + "/Parts"));
		Iterator<String> i = dirmap.iterator();
		boolean equal = true;
		try {
			ArrayList<String> dirlist = getMods();
			while (i.hasNext() && equal) {
				if (!dirlist.contains(i.next())) {
					equal = false;
				}
			}
		} catch (NullPointerException e) {
			equal = false;
		}
		if (!equal) {
			setMods(dirmap);
			extractModContents(); 
		}
	}
	
	private void extractModContents() {
		HashMap<String, HashMap<String, String>> modContents = new HashMap<String, HashMap<String, String>>();
		for (String dir : dirmap) {
			HashMap<String, String> modContent = new HashMap<String, String>();
			try{
				Properties properties = new Properties();
				properties.load(new FileInputStream(kspConfig.getDirectory() + "/Parts/" + dir + "/part.cfg"));
				modContent.put("title", properties.getProperty("title"));
				modContent.put("module", properties.getProperty("module"));
				modContent.put("mass", properties.getProperty("mass"));
				modContent.put("category", properties.getProperty("category"));
				modContents.put(dir, modContent);
			} catch (IOException e) {
	    	}
		}
		saveModContents(modContents);
	}
	
	private void saveModContents(
			HashMap<String, HashMap<String, String>> modContents) {
		Set<Entry<String, HashMap<String, String>>> set = modContents.entrySet(); 
		Iterator<Entry<String, HashMap<String, String>>> i = set.iterator();
		while (i.hasNext()) {
			Map.Entry<String, HashMap<String, String>> next = (Map.Entry<String, HashMap<String, String>>) i.next();
			String dir = next.getKey();
			HashMap<String, String> modContent= next.getValue();
			Set<Entry<String, String>> modSet = modContent.entrySet();
			Iterator<Entry<String, String>> i2 = modSet.iterator();
			while (i2.hasNext()) {
				Map.Entry<String, String> next2 = (Map.Entry<String, String>)i2.next();
				setModProperty(dir + "." + next2.getKey(), next2.getValue());
			}
		}
	}
	
	private void setModProperty(String name, String value) {
		
		properties.setProperty("mod." + name, value);
	}

	private void traverseDirectory(File node) {
		String file = node.getAbsoluteFile().toString();
		System.out.println(file);
		if ( file.contains("cfg") ) {
			String[] dir = file.split("/");
			dirmap.add(dir[dir.length - 2]);
		}
 
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				traverseDirectory(new File(node, filename));
			}
		}
	}
	
	public void setMods(ArrayList<String> modList) {
		properties.setProperty("modList", modList.toString());
	}
	
	public ArrayList<String> getMods() throws NullPointerException {
		String modString = properties.getProperty("modList");
		modString = modString.substring(1, modString.length());
		String[] mods = modString.split(", ");
		ArrayList<String> list = new ArrayList<String>();
		Collections.addAll(list, mods);
		return list;
	}
	
}
