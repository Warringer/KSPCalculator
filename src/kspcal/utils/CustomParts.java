package kspcal.utils;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

public class CustomParts {

	private HashMap<CustomPartType, HashMap<String, CustomPart>> parts;
	private ArrayList<String> dirmap;
	
	public CustomParts() {
		KSPConfig config = KSPConfig.getConfig();
		dirmap = new ArrayList<String>();
		parts = new HashMap<CustomPartType, HashMap<String, CustomPart>>();
		for (CustomPartType type: CustomPartType.values()) {
			HashMap<String, CustomPart> typeList = new HashMap<String, CustomPart>();
			parts.put(type, typeList);
		}
		traverseDirectory(new File(config.getDirectory() + File.separator + "Parts"));
		for (String dir: dirmap) {
			CustomPart part = new CustomPart(config.getDirectory() + File.separator+ "Parts" + File.separator + dir);
			HashMap<String, CustomPart> typeList = new HashMap<String, CustomPart>();
			switch (part.getType()) {
			case PROP:
				typeList = parts.get(CustomPartType.PROP);
				break;
			case CnC:
				typeList = parts.get(CustomPartType.CnC);
				break;
			case SaA:
				typeList = parts.get(CustomPartType.SaA);
				break;
			case UTILITY:
				typeList = parts.get(CustomPartType.UTILITY);
				break;
			}
			typeList.put(dir, part);
		}
	}
	
	private void traverseDirectory(File node) {
		String file = node.getAbsoluteFile().toString();
		if ( file.contains("cfg") ) {
			String[] dir = file.split(Pattern.quote(File.separator));
			dirmap.add(dir[dir.length - 2]);
		}
 
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				traverseDirectory(new File(node, filename));
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("CustomParts [parts=%s]", parts);
	}

	/**
	 * @return the parts
	 */
	public HashMap<CustomPartType, HashMap<String, CustomPart>> getParts() {
		return parts;
	}

	/**
	 * @param parts the parts to set
	 */
	public void setParts(HashMap<CustomPartType, HashMap<String, CustomPart>> parts) {
		this.parts = parts;
	}
}
