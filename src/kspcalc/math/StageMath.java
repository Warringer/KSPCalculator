package kspcalc.math;

import kspcal.utils.Constants;

public abstract class StageMath {
	protected double combinedMassI = 0;			// Combined Initial Mass (before Burnout)
	protected double combinedMassF = 0;			// Combined Final Mass (after Burnout)
	protected double combinedThrust = 0;			// Combined Thrust if the Stage
	protected double DV = 0;						// Delta-V of the Stage 
	protected double SI = 0;						// Specific Impulse
	protected double combinedFuel = 0;			// Fuel reserves of the Stage
	protected double TWR = 0;						// Thrust to Weight ratio
	
	
	protected String getStageString() {
		String stage = "";
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
	
	/**
	 * Calculates the Delta-V of the Stage
	 */
	protected void calculateDV() {
		try {
			this.DV = this.SI * Constants.GRAVITY * Math.log(this.combinedMassI / this.combinedMassF);
		} catch (ArithmeticException e) {
			this.DV = 0;
		}
	}
	
	/**
	 * Calculates the Thrust to Weight Ration of the Stage
	 */
	protected void calculateTWR() {
		try {
			this.TWR = this.combinedThrust / (this.combinedMassI * Constants.GRAVITY);
		} catch (ArithmeticException e) {
			this.TWR = 0;
		}
	}
	
	protected void doMath() {
		this.combineParts();
		this.calculateTWR();
		this.calculateSI();
		this.calculateDV();
		this.checkMath();
	}
	
	protected abstract void combineParts();
	protected abstract void calculateSI();
	protected abstract void checkMath();
	
}
