package kspcalc.math;

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
	private double[] a;					// Transfer Orbit semi-major axis
	
	/**
	 * @param lowOrbit
	 * @param highOrbit
	 * @param pointB
	 */
	public BiEllipticTransferOrbit(double lowOrbit, double highOrbit,
			double pointB, boolean upwards) {
		super();
		this.lowOrbit = lowOrbit + Constants.RADIUS;
		this.highOrbit = highOrbit + Constants.RADIUS;
		this.pointB = pointB + Constants.RADIUS;
		this.upwards = upwards;
		this.doMath();
	}
	
	private void doMath() {
		this.doA();
		this.doTimes();
		this.doCircularOrbits();
		this.doDV();
	}
	
	private void doA() {
		this.a = new double[2];
		this.a[0] = (this.lowOrbit + this.pointB) / 2;
		this.a[1] = (this.highOrbit + this.pointB) / 2;
	}
	
	private void doTimes() {
		this.timeBegin = Math.PI * Math.sqrt(Constants.cube(this.a[0]) / Constants.GM);
		this.timeEnd = Math.PI * Math.sqrt(Constants.cube(this.a[1]) / Constants.GM);
		this.period = this.timeBegin + this.timeEnd;
	}
	
	private void doDV() {
		if (this.upwards) {
			this.doDVup();
		} else {
			this.doDVdown();
		}
	}
	
	private void doDVup() {
		this.injectionVel = doEllipseVel(lowOrbit, a[0]);
		this.finalVel = doEllipseVel(highOrbit, a[1]);
		this.dvB = doEllipseVel(pointB, a[0]) - doEllipseVel(pointB, a[1]);
		this.dvInit = this.injectionVel - this.velLow;
		this.dvExit = this.velHigh - this.finalVel;
	}
	
	private void doDVdown() {
		this.injectionVel = doEllipseVel(highOrbit, a[1]);
		this.finalVel = doEllipseVel(lowOrbit, a[0]);
		this.dvB = doEllipseVel(pointB, a[1]) - doEllipseVel(pointB, a[0]);
		this.dvInit = this.injectionVel - this.velHigh;
		this.dvExit = this.velLow - this.finalVel;
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
	
}
