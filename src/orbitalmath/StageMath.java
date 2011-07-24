package orbitalmath;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import constants.Constants;
import constants.Parts;

public class StageMath {
	private HashMap<Parts, Integer> stageParts;	// HashMap containing all vanilla parts and how many times they are in the Stage
	private double combinedMassI = 0;			// Combined Initial Mass (before Burnout)
	private double combinedMassF = 0;			// Combined Final Mass (after Burnout)
	private double combinedThrust = 0;			// Combined Thrust if the Stage
	private double DV = 0;						// Delta-V of the Stage 
	private double SI = 0;						// Specific Impulse
	private double combinedFuel = 0;			// Fuel reserves of the Stage
	private double TWR = 0;						// Thrust to Weight ratio
	// private double DWC = 0;						// Weight of any stage carried by this one
	

	public static void main(String[] args) {
		HashMap<Parts, Integer> parts = new HashMap<Parts, Integer>();
		parts.put(Parts.CP, 1);
		parts.put(Parts.LFE, 1);
		parts.put(Parts.LFT, 6);
		parts.put(Parts.SRB, 0);
		StageMath math = new StageMath(parts, 0);
		System.out.println(math);
	}

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
		stage += "  Initial Mass:\t\t" + Constants.formatDouble(this.combinedMassI) + " tons\n";
		stage += "  Empty Mass:\t\t" + Constants.formatDouble(this.combinedMassF) + " tons\n";
		if (this.SI > 0) {
			stage += "  Specific Impulse:\t\t" + Constants.formatDouble(this.SI) + " s\n";
		}
		if (this.combinedThrust > 0) {
			stage += "  Thrust:\t\t\t" + Constants.formatDouble(this.combinedThrust) + " kN\n";
		}
		if (this.DV > 0 ) {
			stage += "  \u0394v:\t\t\t" + Constants.formatDouble(this.DV) + " m/s\n";
		}
		if (this.TWR > 0) {
			stage += "  Thrust to Weight Ratio:\t" + Constants.formatDouble(this.TWR) + "";
		}
		return stage;
	}

	/**
	 * @param stageParts
	 */
	public StageMath(HashMap<Parts, Integer> stageParts, double DWC) {
		super();
		this.stageParts = stageParts;
		this.DWC = DWC;
		this.combineParts();
		this.calculateTWR();
		this.calculateSI();
		this.calculateDV();
		this.checkMath();
	}
	
	/**
	 * @return the stageParts
	 */
	public HashMap<Parts, Integer> getStageParts() {
		return stageParts;
	}

	public StageMath() {
	}
	
	/**
	 * Calculates the Initial and final mass as well as the combined thrust of the stage via interating over the stageParts HashMap
	 */
	private void combineParts() {
		Iterator<Entry<Parts, Integer>> i = this.stageParts.entrySet().iterator();
		while (i.hasNext()) {
			Entry<Parts, Integer> part = i.next();
			this.combinedMassI += part.getKey().getMassI() * part.getValue();
			this.combinedMassF += part.getKey().getMassF() * part.getValue();
			this.combinedThrust += part.getKey().getThrust() * part.getValue();
		}
	}
	
	private void calculateTWR() {
		try {
			this.TWR = this.combinedThrust / (this.combinedMassI * Constants.GRAVITY);
		} catch (ArithmeticException e) {
			this.TWR = 0;
		}
	}
	
	private void calculateSI() {
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
	
	private void calculateDV() {
		try {
			this.DV = this.SI * Math.log(this.combinedMassI / this.combinedMassF);
		} catch (ArithmeticException e) {
			this.DV = 0;
		}
	}
	
	private void checkMath() {
		int getTanks = this.stageParts.get(Parts.LFT) + this.stageParts.get(Parts.SRB);
		int getEngines = this.stageParts.get(Parts.LFE) + this.stageParts.get(Parts.SRB);
		if (getTanks <= 0 || getEngines <= 0) {
			this.TWR = 0;
			this.DV = 0;
			this.SI = 0;
		}
	}
	
	/**
	 * @return the combinedMassI
	 */
	public double getCombinedMassI() {
		return combinedMassI;
	}


	/**
	 * @return the combinedMassF
	 */
	public double getCombinedMassF() {
		return combinedMassF;
	}


	/**
	 * @return the combinedThrust
	 */
	public double getCombinedThrust() {
		return combinedThrust;
	}


	/**
	 * @return the combinedDV
	 */
	public double getDV() {
		return DV;
	}


	/**
	 * @return the combinedSI
	 */
	public double getSI() {
		return SI;
	}


	/**
	 * @return the combinedFuel
	 */
	public double getCombinedFuel() {
		return combinedFuel;
	}
	
	/**
	 * @return the tWR
	 */
	public double getTWR() {
		return TWR;
	}
}
