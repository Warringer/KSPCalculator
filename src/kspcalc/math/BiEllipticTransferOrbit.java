package kspcalc.math;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;

public class BiEllipticTransferOrbit extends OrbitMath {

	private double lowOrbit;	// Lower Orbit for Transfer Orbit
	private double highOrbit;	// Higher Orbit for Transfer Orbit
	private double pointB;		// Transfer Point
	
	private double injectionVel;		// Transfer Orbit Injection Velocity
	private double finalVel;			// Transfer Orbit Ejection Velocity
	private double velHigh;				// High Orbit Velocity
	private double velB;				// Point B Velocity
	private double velLow;				// Low Orbit Velocity
	private double dvInit;				// Transfer Orbit Injection Delta-v
	private double dvB;					// Transfer Point B Delta-v
	private double dvExit;				// Transfer Orbit Ejection Delta-v
	private double timeBegin, timeEnd;	// Transfer Times 
	private double period;  			// Transfer Orbit Period
	private boolean upwards;			// Transfer Orbit Direction, true = upwards, false = downwards
	
	private HohmannTransferOrbit up, down;
	
	/**
	 * @param lowOrbit
	 * @param highOrbit
	 * @param pointB
	 */
	public BiEllipticTransferOrbit(double lowOrbit, double highOrbit,
			double pointB, boolean upwards, CelestrialBody body) {
		super(body);
		this.upwards = upwards;
		if (upwards) {
			this.up = new HohmannTransferOrbit(this.lowOrbit, this.pointB, true, body);
			this.down = new HohmannTransferOrbit(this.highOrbit, this.pointB, false, body);
		} else {
			this.up = new HohmannTransferOrbit(this.highOrbit, this.pointB, true, body);
			this.down = new HohmannTransferOrbit(this.lowOrbit, this.pointB, false, body);
		}
		this.doMath();
	}
	
	private void doMath() {
		this.doTimes();
		this.doCircularOrbits();
		this.doDV();
	}
	
	private void doTimes() {
		this.timeBegin = this.up.getHalfPeriod();
		this.timeEnd = this.down.getHalfPeriod();
		this.period = this.timeBegin + this.timeEnd;
	}
	
	private void doDV() {
		this.injectionVel = this.up.getHohVelInjection();
		this.finalVel = this.down.getHohVelExit();
		this.velB = this.up.getHohVelExit();
		this.dvInit = this.up.getDVInit();
		this.dvExit = this.down.getDVExit();
		this.dvB = Math.abs(this.velB - this.down.getHohVelInjection());
	}
	
	/**
	 * Calculate the Circular Orbit Velocities
	 */
	private void doCircularOrbits() {
		this.velHigh = this.doCircularOrbitMath(this.highOrbit);
		this.velLow = this.doCircularOrbitMath(this.lowOrbit);
	}
	
	/**
	 * @return the hohVelInjection
	 */
	public double getInjectionVel() {
		return injectionVel;
	}
	/**
	 * @return the hohVelFinal
	 */
	public double getFinalVel() {
		return finalVel;
	}
	/**
	 * @return the velHigh
	 */
	public double getVelHigh() {
		return velHigh;
	}
	/**
	 * @return the velB
	 */
	public double getVelB() {
		return velB;
	}
	/**
	 * @return the velLow
	 */
	public double getVelLow() {
		return velLow;
	}
	/**
	 * @return the dvInit
	 */
	public double getDvInit() {
		return dvInit;
	}
	/**
	 * @return the dvB
	 */
	public double getDvB() {
		return dvB;
	}
	/**
	 * @return the dvExit
	 */
	public double getDvExit() {
		return dvExit;
	}
	/**
	 * @return the timeBegin
	 */
	public double getTimeBegin() {
		return timeBegin;
	}
	/**
	 * @return the timeEnd
	 */
	public double getTimeEnd() {
		return timeEnd;
	}
	/**
	 * @return the period
	 */
	public double getPeriod() {
		return period;
	}
	
	public double getInitVel() {
		if (upwards) {
			return this.velLow;
		}
		return this.velHigh;
	}
	
	public double getOutVel() {
		if (upwards) {
			return this.velHigh;
		}
		return this.velLow;
	}
	
	public double getCombinedDV() {
		return Math.abs(this.dvB) + Math.abs(this.dvExit) + this.dvInit;
	}
	
}
