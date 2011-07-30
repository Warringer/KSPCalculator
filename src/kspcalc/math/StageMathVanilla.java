package kspcalc.math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import kspcal.utils.*;


public class StageMathVanilla extends StageMath {
	private HashMap<Parts, Integer> stageParts;	// HashMap containing all vanilla parts and how many times they are in the Stage

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String stage = "";
		Iterator<Entry<Parts, Integer>> i = this.stageParts.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Parts, Integer> part = i.next();
			if (part.getValue() > 0) {
				stage += "  " + part.getValue() + "x " + part.getKey().getName() + "\n";
			}
		}
		stage += this.getStageString();
		return stage;
	}

	/**
	 * @param stageParts
	 */
	public StageMathVanilla(HashMap<Parts, Integer> stageParts, double DWC) {
		super();
		this.stageParts = stageParts;
		// this.DWC = DWC;
		this.doMath();
	}
	
	/**
	 * @return the stageParts
	 */
	public HashMap<Parts, Integer> getStageParts() {
		return stageParts;
	}

	public StageMathVanilla() {
	}
	
	/**
	 * Calculates the Initial and final mass as well as the combined thrust of the stage via iterating over the stageParts HashMap
	 */
	protected void combineParts() {
		Iterator<Entry<Parts, Integer>> i = this.stageParts.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Parts, Integer> part = i.next();
			this.combinedMassI += part.getKey().getMassI() * part.getValue();
			this.combinedMassF += part.getKey().getMassF() * part.getValue();
			this.combinedThrust += part.getKey().getThrust() * part.getValue();
		}
	}
	
	/**
	 * Calculate the Specific Impulse of the Stage
	 */
	protected void calculateSI() {
		try {
			double lftMassI = this.stageParts.get(Parts.LFT) * Parts.LFT.getMassI();
			double lftMassF = this.stageParts.get(Parts.LFT) * Parts.LFT.getMassF();
			double srbMassI = this.stageParts.get(Parts.SRB) * Parts.SRB.getMassI();
			double srbMassF = this.stageParts.get(Parts.SRB) * Parts.SRB.getMassF();
			this.SI = (((lftMassI - lftMassF) / (lftMassI + srbMassI - lftMassF - srbMassF)) * (Parts.LFE.getSI() - Parts.SRB.getSI())) + Parts.SRB.getSI();
		} catch (ArithmeticException e) {
			this.SI = 0;
		}
	}
	
	/**
	 * Checks the Math, if there are only tanks or only engines in the stage (or neither)
	 * Thrust to Weight Ratio, Delta-V and Specific Impulse are set to 0 
	 */
	protected void checkMath() {
		int getTanks = this.stageParts.get(Parts.LFT) + this.stageParts.get(Parts.SRB);
		int getEngines = this.stageParts.get(Parts.LFE) + this.stageParts.get(Parts.SRB);
		if (getTanks <= 0 || getEngines <= 0) {
			this.TWR = 0;
			this.DV = 0;
			this.SI = 0;
		}
	}
}
