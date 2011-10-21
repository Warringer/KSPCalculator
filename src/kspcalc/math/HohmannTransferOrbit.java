/**
 * 
 */
package kspcalc.math;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;

/**
 * @author warringer
 *
 */
public class HohmannTransferOrbit extends OrbitMath {

	private double lowOrbit;	// Lower Orbit for Transfer Orbit
	private double highOrbit;	// Higher Orbit for Transfer Orbit
	
	private double hohVelInjection;		// Transfer Orbit Injection Velocity
	private double hohVelFinal;			// Transfer Orbit Ejection Velocity
	private double velHigh;				// High Orbit Velocity
	private double velLow;				// Low Orbit Velocity
	private double dvInit;				// Transfer Orbit Injection Delta-v
	private double dvExit;				// Transfer Orbit Ejection Delta-v
	private double period;  			// Transfer Orbit Period
	private boolean upwards;			// Transfer Orbit Direction, true = upwards, false = downwards
	private double atx;					// Transfer Orbit semi-major axis
	
	public HohmannTransferOrbit(double lowOrbit, double highOrbit,
			boolean upwards, CelestrialBody body) {
		super(body);
		this.lowOrbit = lowOrbit + body.getRadius();
		this.highOrbit = highOrbit + body.getRadius();
		this.upwards = upwards;
		this.doMath();
	}
	
	/**
	 * Does the Math!
	 */
	private void doMath() {
		this.doAtx();
		this.doPeroid();
		this.doCircularOrbits();
		this.doOrbit();
	}
	
	/**
	 * Calculates the Semi-Major axis of the Transfer Ellipse
	 */
	private void doAtx() {
		this.atx = (this.highOrbit + this.lowOrbit) / 2d;
	}
	
	/**
	 * Calculates the orbital period
	 */
	private void doPeroid() {
		this.period = 2d * Math.PI * Math.sqrt(Constants.cube(this.atx) / body.getGm()) / 60d;
	}
	
	/** 
	 * Calculates the Orbit
	 */
	private void doOrbit() {
		if (this.upwards) {
			this.doOrbitUp();
		} else {
			this.doOrbitDown();
		}
	}
	
	/**
	 * Calculates the Orbit when going from lower to higher orbit
	 */
	private void doOrbitUp() {
		this.hohVelInjection = Math.sqrt(body.getGm() * ((2d / (this.lowOrbit)) - (1d / this.atx)));
		this.hohVelFinal = Math.sqrt(body.getGm() * ((2d / (this.highOrbit)) - (1d / this.atx)));
		this.dvInit = Math.abs(this.hohVelInjection - this.velLow);
		this.dvExit = Math.abs(this.hohVelFinal - this.velHigh);
	}
	
	/**
	 * Calculates the Orbit when going from higher to lower orbit
	 */
	private void doOrbitDown() {
		this.hohVelInjection = Math.sqrt(body.getGm()* ((2d / (this.highOrbit)) - (1d / this.atx)));
		this.hohVelFinal = Math.sqrt(body.getGm() * ((2d / (this.lowOrbit)) - (1d / this.atx)));
		this.dvInit = Math.abs(this.hohVelInjection - this.velHigh);
		this.dvExit = Math.abs(this.hohVelFinal - this.velLow);
	}
	
	/**
	 * Calculate the Circular Orbit Velocities
	 */
	private void doCircularOrbits() {
		this.velHigh = this.doCircularOrbitMath(this.highOrbit);
		this.velLow = this.doCircularOrbitMath(this.lowOrbit);
	}
	
	/**
	 * @return the lowOrbit
	 */
	public double getLowOrbit() {
		return lowOrbit;
	}
	/**
	 * @param lowOrbit the lowOrbit to set
	 */
	public void setLowOrbit(double lowOrbit) {
		this.lowOrbit = lowOrbit;
	}
	/**
	 * @return the highOrbit
	 */
	public double getHighOrbit() {
		return highOrbit;
	}
	/**
	 * @param highOrbit the highOrbit to set
	 */
	public void setHighOrbit(double highOrbit) {
		this.highOrbit = highOrbit;
	}
	/**
	 * @return the velInit
	 */
	public double getHohVelInjection() {
		return this.hohVelInjection;
	}
	/**
	 * @return the velExit
	 */
	public double getHohVelExit() {
		return this.hohVelFinal;
	}
	/**
	 * @return the dVInit
	 */
	public double getDVInit() {
		return this.dvInit;
	}
	/**
	 * @return the dVExit
	 */
	public double getDVExit() {
		return this.dvExit;
	}
	/**
	 * @return the period
	 */
	public double getPeriod() {
		return this.period;
	}
	
	public double getHalfPeriod() {
		return this.period / 2d;
	}
	
	public double getInitVel() {
		if (this.upwards) {
			return this.velLow;
		}
		return this.velHigh;
	}
	
	public double getFinalVel() {
		if (this.upwards) {
			return this.velHigh;
		}
		return this.velLow;
	}
}
