/**
 * 
 */
package orbitalmath;

/**
 * @author warringer
 *
 */
public class HohmannTransferOrbit {

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
			boolean upwards) {
		super();
		this.lowOrbit = lowOrbit + Constants.RADIUS;
		this.highOrbit = highOrbit + Constants.RADIUS;
		this.upwards = upwards;
		this.doMath();
	}
	
	private void doMath() {
		this.doAtx();
		this.doPeroid();
		this.doCircularOrbits();
		this.doOrbit();
	}
	
	private void doAtx() {
		this.atx = (this.highOrbit + this.lowOrbit) / 2d;
	}
	
	private void doPeroid() {
		this.period = 2d * Math.PI * Math.sqrt(Constants.cube(this.atx) / Constants.GM) / 60d;
	}
	
	private void doOrbit() {
		if (this.upwards) {
			this.doOrbitUp();
		} else {
			this.doOrbitDown();
		}
	}
	
	private void doOrbitUp() {
		this.hohVelInjection = Math.sqrt(Constants.GM * ((2d / (this.lowOrbit)) - (1d / this.atx)));
		this.hohVelFinal = Math.sqrt(Constants.GM * ((2d / (this.highOrbit)) - (1d / this.atx)));
		this.dvInit = Math.abs(this.hohVelInjection - this.velLow);
		this.dvExit = Math.abs(this.hohVelFinal - this.velHigh);
	}
	
	private void doOrbitDown() {
		this.hohVelInjection = Math.sqrt(Constants.GM * ((2d / (this.highOrbit)) - (1d / this.atx)));
		this.hohVelFinal = Math.sqrt(Constants.GM * ((2d / (this.lowOrbit)) - (1d / this.atx)));
		this.dvInit = Math.abs(this.hohVelInjection - this.velHigh);
		this.dvExit = Math.abs(this.hohVelFinal - this.velLow);
	}
	
	private void doCircularOrbits() {
		this.velHigh = this.doCircularOrbitMath(this.highOrbit);
		this.velLow = this.doCircularOrbitMath(this.lowOrbit);
	}
	
	private double doCircularOrbitMath(double d) {
		return Math.sqrt(Constants.GM / d);
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
