package kspcal.utils;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

public class CustomParts {

	private HashMap<CustomPartType, HashMap<String, CustomPart>> parts;
	private ArrayList<String> dirmap;
	
	public CustomParts() {dirmap = new ArrayList<String>();
		parts = new HashMap<CustomPartType, HashMap<String, CustomPart>>();
		for (CustomPartType type: CustomPartType.values()) {
			HashMap<String, CustomPart> typeList = new HashMap<String, CustomPart>();
			parts.put(type, typeList);
		}
		if (KSPConfig.getConfig().hasDirectory()) {
			KSPConfig config = KSPConfig.getConfig();
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
		} else {
			this.loadGenericParts();
		}
	}
	
	private void loadGenericParts() {
		HashMap<String, CustomPart> typeList = new HashMap<String, CustomPart>();
		CustomPart part;
		typeList = parts.get(CustomPartType.PROP);
		part = new CustomPart(2.5, 0.3, 0, 500, 0, CustomPartType.PROP, "FL-T500 Fuel Tank", "FuelTank");
		typeList.put("fuelTank", part);
		part = new CustomPart(2, 2, 200, 0, 8, CustomPartType.PROP, "LV-T30 Liquid Fuel Engine", "LiquidEngine");
		typeList.put("liquidEngine1", part);
		part = new CustomPart(1.8, 0.36, 130, 100, 4, CustomPartType.PROP, "RT-10 Solid Fuel Booster", "SolidRocket");
		typeList.put("solidBooster", part);
		part = new CustomPart(0.9, 0.9, 0, 0, 0, CustomPartType.PROP, "FL-R25 RCS Fuel Tank", "RCSFuelTank");
		typeList.put("rcsTank", part);
		part = new CustomPart(2, 2, 175, 0, 7, CustomPartType.PROP, "LV-T45 Liquid Fuel Engine", "LiquidEngine");
		typeList.put("liquidEngine2", part);
		typeList = parts.get(CustomPartType.CnC);
		part = new CustomPart(1, 1, 0, 0, 0, CustomPartType.CnC, "Command Pod Mk1", "CommandPod");
		typeList.put("mk1pod", part);
		part = new CustomPart(0.8, 0.8, 0, 0, 0, CustomPartType.CnC, "S.A.S Module", "SASModule");
		typeList.put("sasModule", part);
		part = new CustomPart(0.8, 0.8, 0, 0, 0, CustomPartType.CnC, "Advanced S.A.S Module", "SASModule");
		typeList.put("advSASModule", part);
		part = new CustomPart(0.05, 0.05, 0, 0, 0, CustomPartType.CnC, "RV-105 RCS Thruster Block", "RCSModule");
		typeList.put("rcsBlock", part);
		typeList = parts.get(CustomPartType.UTILITY);
		part = new CustomPart(0.3, 0.3, 0, 0, 0, CustomPartType.UTILITY, "Mk16 Parachute", "Parachutes");
		typeList.put("parachuteSingle", part);
		typeList = parts.get(CustomPartType.SaA);
		part = new CustomPart(0.4, 0.4, 0, 0, 0, CustomPartType.SaA, "TT-38K Radial Decoupler", "RadialDecoupler");
		typeList.put("radialDecoupler", part);
		part = new CustomPart(0.8, 0.8, 0, 0, 0, CustomPartType.SaA, "TR-18A Stack Decoupler", "Decoupler");
		typeList.put("stackDecoupler", part);
		part = new CustomPart(0.05, 0.05, 0, 0, 0, CustomPartType.SaA, "AV-T1 Winglet", "Winglet");
		typeList.put("winglet", part);
		part = new CustomPart(0.08, 0.08, 0, 0, 0, CustomPartType.SaA, "AV-R8 Winglet", "Winglet");
		typeList.put("winglet2", part);
		part = new CustomPart(0.8, 0.8, 0, 0, 0, CustomPartType.SaA, "TVR-1180C Mk1 Stack Tri-Coupler", "Strut");
		typeList.put("stackTriCoupler", part);
		part = new CustomPart(0.05, 0.05, 0, 0, 0, CustomPartType.SaA, "EAS-4 Strut Connector", "StrutConnector");
		typeList.put("strutConnector", part);
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
