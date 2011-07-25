package kspcalc.math;

import kspcal.constants.Constants;

public class LaunchOrbit {
	private double launchBurnVel;	// Burnout Velocity
	private double launchBurnAlt;	// Burnout Altitude
	private double launchBurnAng;	// Burnout Angle
	private double launchPerAlt;	// Perigee Altitide
	private double launchPerVel;	// Perigee Velocity
	private double launchApoAlt;	// Apogee Altitude
	private double launchApoVel;	// Apogee Velocity
	private double c, a;
	
	/**
	 * @param launchBurnVel
	 * @param launchBurnAlt
	 * @param launchBurnAng
	 */
	public LaunchOrbit(double launchBurnVel, double launchBurnAlt,
			double launchBurnAng) {
		super();
		this.launchBurnVel = launchBurnVel;
		this.launchBurnAlt = launchBurnAlt +Constants.RADIUS;
		this.launchBurnAng = launchBurnAng;
		this.doMath();
	}
	
	private void doMath() {
		this.doHelpers();
		this.doAlts();
	}
	
	private void doHelpers() {
		this.c = (2d * Constants.GM) / (this.launchBurnAlt * this.launchBurnVel * this.launchBurnVel);
		this.a = this.launchApoAlt + this.launchPerAlt;
	}
	
	private void doAlts() {
		double rpri1 = ( -this.c + Math.sqrt(Constants.square(this.c) - 4d * (1d - this.c) * (- Constants.square(Math.sin(this.launchBurnAng))))) / (2d * (1d - this.c));
		double rpri2 = ( -this.c - Math.sqrt(Constants.square(this.c) - 4d * (1d - this.c) * (- Constants.square(Math.sin(this.launchBurnAng))))) / (2d * (1d - this.c));
		if (rpri1 > rpri2) {
			this.launchPerAlt = rpri2 * this.launchBurnAlt;
			this.launchApoAlt = rpri1 * this.launchBurnAlt;
		} else {
			this.launchPerAlt = rpri1 * this.launchBurnAlt;
			this.launchApoAlt = rpri2 * this.launchBurnAlt;
		}
	}
	
	@SuppressWarnings("unused")
	private void doVels() {
		this.launchPerVel = Math.sqrt((2d * Constants.GM * this.launchApoAlt) / (this.launchPerAlt * this.a));
		this.launchApoVel = Math.sqrt((2d * Constants.GM * this.launchPerAlt) / (this.launchApoAlt * this.a));
	}

	/**
	 * @return the launchPerAlt
	 */
	public double getLaunchPerAlt() {
		return launchPerAlt;
	}

	/**
	 * @return the launchPerVel
	 */
	public double getLaunchPerVel() {
		return launchPerVel;
	}

	/**
	 * @return the launchApoAlt
	 */
	public double getLaunchApoAlt() {
		return launchApoAlt;
	}

	/**
	 * @return the launchApoVel
	 */
	public double getLaunchApoVel() {
		return launchApoVel;
	}
	
	
}
