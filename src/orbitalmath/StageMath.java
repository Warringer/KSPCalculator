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
	private double SI = 0;						// SI ??
	private double combinedFuel = 0;			// Fuel reserves of the Stage
	private double TWR;							// Thrust to Weight ratio
	private double DWC;							// Weight of any stage carried by this one
	

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
		return String
				.format("StageMath [\n\tstageParts=%s, \n\tcombinedMassI=%s, \n\tcombinedMassF=%s, \n\tcombinedThrust=%s, \n\tcombinedDV=%s, \n\tcombinedSI=%s, \n\tcombinedFuel=%s, \n\tTWR=%s, \n\tDWC=%s\n]",
						stageParts, combinedMassI, combinedMassF,
						combinedThrust, DV, SI, combinedFuel,
						TWR, DWC);
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
		this.TWR = this.combinedThrust / (this.combinedMassI * Constants.GRAVITY);
	}
	
	private void calculateSI() {
		try {
			double lftMassI = this.stageParts.get(Parts.LFT) * Parts.LFT.getMassI();
			double lftMassF = this.stageParts.get(Parts.LFT) * Parts.LFT.getMassF();
			double srbMassI = this.stageParts.get(Parts.SRB) * Parts.SRB.getMassI();
			double srbMassF = this.stageParts.get(Parts.SRB) * Parts.SRB.getMassF();
			this.SI = (((lftMassI - lftMassF) / (lftMassI + srbMassI - lftMassF - srbMassF)) * (Parts.LFE.getSI() - Parts.SRB.getSI()))- Parts.SRB.getSI();
		} catch (ArithmeticException e) {
			this.SI = 0;
		}
	}
	
	private void calculateDV() {
		this.DV = this.SI * Math.log(this.combinedMassI - this.combinedMassF);
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
