package kspcalc.math;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;

public class LaunchOrbit extends OrbitMath {
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
			double launchBurnAng, CelestrialBody body) {
		super(body);
		this.launchBurnVel = launchBurnVel;
		this.launchBurnAlt = launchBurnAlt + body.getRadius();
		this.launchBurnAng = launchBurnAng * (Math.PI / 180);
		this.doMath();
	}
	
	/**
	 * Does the Math.
	 */
	private void doMath() {
		this.c = (2d * body.getGm()) / (this.launchBurnAlt * this.launchBurnVel * this.launchBurnVel);
		this.doAlts();
		this.a = this.launchApoAlt + this.launchPerAlt;
		this.doVels();
	}
	
	/**
	 * Calculates the Perigee and Apogee Altitudes
	 * Based on Formulas from http://www.braeunig.us/space/orbmech.htm#launch
	 */
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
	
	/**
	 * Calculates the Velocities at Perigee and Apogee
	 */
	private void doVels() {
		this.launchPerVel = Math.sqrt((2d * body.getGm() * this.launchApoAlt) / (this.launchPerAlt * this.a));
		this.launchApoVel = Math.sqrt((2d * body.getGm() * this.launchPerAlt) / (this.launchApoAlt * this.a));
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
		return launchApoAlt - body.getRadius();
	}

	/**
	 * @return the launchApoVel
	 */
	public double getLaunchApoVel() {
		return launchApoVel - body.getRadius();
	}
	
	
}
