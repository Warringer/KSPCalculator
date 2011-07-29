package tests;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import kspcal.utils.CustomParts;
import kspcal.utils.KSPConfig;

public class DirectoryReadTest {

	public static HashMap<String, String> dirmap;
	/**
	 * @param args
	 */
	public static void main (String args[]) {
		KSPConfig config = KSPConfig.getConfig();
		dirmap = new HashMap<String, String>();
		ArrayList<String> partlist = new ArrayList<String>();
		HashMap<String, ArrayList<String>> partslist= new HashMap<String, ArrayList<String>>();
		displayIt(new File(config.getDirectory() + "/Parts"));
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("test.txt"));
			out.write(dirmap.toString());
			Set<Entry<String, String>> set = dirmap.entrySet(); 
			Iterator<Entry<String, String>> i = set.iterator();
			while (i.hasNext()) {
				Map.Entry<String, String> next = (Map.Entry<String, String>)i.next();
				partlist.add(next.getKey());
				Properties properties = new Properties();
				properties.load(new FileInputStream(config.getDirectory() + "/Parts/" + next.getKey() + "/" + next.getValue()));
				out.write(properties.getProperty("name")+ ": " + properties.getProperty("module") + "\n");
				ArrayList<String> list = new ArrayList<String>();
				if (!partslist.containsKey(properties.getProperty("module"))) {
					list.add(properties.getProperty("name"));
					partslist.put(properties.getProperty("module"), list);
				} else {
					list = partslist.get(properties.getProperty("module"));
					list.add(properties.getProperty("name"));
					partslist.put(properties.getProperty("module"), list);
				}
			}
			out.write(partslist.toString()+"\n\n");
			CustomParts test = new CustomParts();
			out.write(test.toString());
			System.out.println(test);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(dirmap);
	}
 
	public static void displayIt(File node){
 
		String file = node.getAbsoluteFile().toString();
		if ( file.contains("cfg") ) {
			String[] dir = node.getParentFile().toString().split("/");
			dirmap.put(dir[dir.length - 1], node.getName());
		}
 
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				displayIt(new File(node, filename));
			}
		}
 
	}

}
