package kspcalc.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import kspcal.utils.*;


public class StageMathCustom extends StageMath {
	private HashMap<CustomPartType, HashMap<String, CustomPart>> stageParts;	// HashMap containing all vanilla parts and how many times they are in the Stage

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String stage = "";
		Iterator<Entry<CustomPartType, HashMap<String, CustomPart>>> i = this.stageParts.entrySet().iterator();
		while (i.hasNext()) {
			Iterator<Entry<String, CustomPart>> i2 = i.next().getValue().entrySet().iterator();
			while (i2.hasNext()) {
				Entry<String, CustomPart> part = i2.next();
				if (part.getValue().getNumber() > 0) {
					stage += "  " + part.getValue().getNumber() + "x " + part.getValue().getName() + "\n";
				}
			}
		}
		stage += this.getStageString();
		return stage;
	}

	/**
	 * @param stageParts
	 */
	public StageMathCustom(HashMap<CustomPartType, HashMap<String, CustomPart>> stageParts) {
		super();
		this.stageParts = stageParts;
		// this.DWC = DWC;
		this.doMath();
	}
	
	/**
	 * @return the stageParts
	 */
	public HashMap<CustomPartType, HashMap<String, CustomPart>> getStageParts() {
		return stageParts;
	}

	public StageMathCustom() {
	}
	
	/**
	 * Calculates the Initial and final mass as well as the combined thrust of the stage via iterating over the stageParts HashMap
	 */
	protected void combineParts() {
		Iterator<Entry<CustomPartType, HashMap<String, CustomPart>>> i = this.stageParts.entrySet().iterator();
		while (i.hasNext()) {
			Iterator<Entry<String, CustomPart>> i2 = i.next().getValue().entrySet().iterator();
			while (i2.hasNext()) {
				Entry<String, CustomPart> part = i2.next();
				this.combinedMassI += part.getValue().getMassI() * part.getValue().getNumber();
				this.combinedMassF += part.getValue().getMassF() * part.getValue().getNumber();
				this.combinedThrust += part.getValue().getThrust() * part.getValue().getNumber();
			}
		}
	}
	
	/**
	 * Calculate the Specific Impulse of the Stage
	 */
	protected void calculateSI() {
		HashMap<String, CustomPart> tanksEngines = this.stageParts.get(CustomPartType.PROP);
		double combinedFuelNeed = 0;
		Iterator<Entry<String, CustomPart>> i = tanksEngines.entrySet().iterator();
		while (i.hasNext()) {
			CustomPart part = i.next().getValue();
			combinedFuelNeed += part.getFuelNeed() * part.getMassPerFuel() * part.getNumber();
		}
		try {
			i = tanksEngines.entrySet().iterator();
			double SI = 0;
			while (i.hasNext()) {
				CustomPart part = i.next().getValue();
				SI += part.getProportonalFuelNeed(combinedFuelNeed) * part.getSI();
			}
			this.SI = SI;
		} catch (ArithmeticException e) {
			this.SI = 0;
		}
	}
	
	/**
	 * Checks the Math, if there are only tanks or only engines in the stage (or neither)
	 * Thrust to Weight Ratio, Delta-V and Specific Impulse are set to 0 
	 */
	protected void checkMath() {
		HashMap<String, CustomPart> tanksEngines = this.stageParts.get(CustomPartType.PROP);
		int getTanks = 0;
		int getEngines = 0;
		String[] engines = {"SolidRocket", "LiquidEngine"};
		String[] tanks = {"FuelTank", "SolidRocket"};
		Iterator<Entry<String, CustomPart>> i = tanksEngines.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, CustomPart> part = i.next();
			if (Arrays.asList(engines).contains(part.getValue().getModule())) {
				getEngines += part.getValue().getNumber();
			}
			if (Arrays.asList(tanks).contains(part.getValue().getModule())) {
				getTanks += part.getValue().getNumber();
			}
		}
		if (getTanks <= 0 || getEngines <= 0) {
			this.TWR = 0;
			this.DV = 0;
			this.SI = 0;
		}
	}
}
