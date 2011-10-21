package kspcalc.math;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;

public class CircularOrbit extends OrbitMath {

	private double Alt;	// Orbital Altitude
	private double Vel;	// Orbital Velocity
	private double Per;	// Orbital Period
	private double escVel;	// Escape Velocity
	
	
	
	public CircularOrbit(double alt, CelestrialBody body) {
		super(body);
		Alt = alt + body.getRadius();
		this.doMath();
	}
	
	/**
	 * Does the Math!
	 */
	private void doMath() {
		this.orbitalVelocity();
		this.orbitalPeriod();
		this.escapeVelocity();
	};
	
	/**
	 * Calculate the orbital velocity
	 */
	private void orbitalVelocity() {
		this.Vel = this.doCircularOrbitMath(Alt);
	}
	
	/** 
	 * Calculates the orbital period
	 */
	private void orbitalPeriod() {
		this.Per = 2d * Math.PI * (Alt) / (Vel * 60d);
	}
	
	/**
	 * Calculates the escape velocity
	 */
	private void escapeVelocity() {
		this.escVel = Math.sqrt((2 * body.getGm()) / Alt);
	}
	
	
	/**
	 * @return the alt
	 */
	public double getAlt() {
		return Alt;
	}
	/**
	 * @param alt the alt to set
	 */
	public void setAlt(double alt) {
		Alt = alt + body.getRadius();
		this.doMath();
	}
	/**
	 * @return the vel
	 */
	public double getVel() {
		return Vel;
	}
	/**
	 * @return the per
	 */
	public double getPer() {
		return Per;
	}
	/**
	 * @return the escVel
	 */
	public double getEscVel() {
		return escVel;
	}
	
}
