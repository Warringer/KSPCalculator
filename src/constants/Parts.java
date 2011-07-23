package constants;

public enum Parts {
	LFT(2.5, 0.3, 0, 0, 500, 0.0044),
	LFE(2, 2, 200, 5682, 0, 0),
	SRB(1.8, 0.36, 130, 2257, 100, 0.0144),
	SAS(0.8),
	CP(1),
	Radial(0.4),
	Stack(0.8),
	Tri(0.8),
	Chute(0.3),
	EmptySRB(1.8);
	
	private final double massI;
	private final double massF;
	private final double thrust;
	private final double SI;
	private final double fuel;
	private final double massPerFuel;
	
	/**
	 * @param massI
	 * @param massF
	 * @param thrust
	 * @param sI
	 * @param fuel
	 * @param massPerFuel
	 */
	private Parts(double massI, double massF, double thrust, double sI,
			double fuel, double massPerFuel) {
		this.massI = massI;
		this.massF = massF;
		this.thrust = thrust;
		this.SI = sI;
		this.fuel = fuel;
		this.massPerFuel = massPerFuel;
	}

	/**
	 * @param massI
	 */
	private Parts(double mass) {
		this.massI = mass;
		this.massF = mass;
		this.thrust = 0;
		this.SI = 0;
		this.fuel = 0;
		this.massPerFuel = 0;
	}

	/**
	 * @return the massI
	 */
	public double getMassI() {
		return massI;
	}

	/**
	 * @return the massF
	 */
	public double getMassF() {
		return massF;
	}

	/**
	 * @return the thrust
	 */
	public double getThrust() {
		return thrust;
	}

	/**
	 * @return the sI
	 */
	public double getSI() {
		return SI;
	}

	/**
	 * @return the fuel
	 */
	public double getFuel() {
		return fuel;
	}

	/**
	 * @return the massPerFuel
	 */
	public double getMassPerFuel() {
		return massPerFuel;
	}
	
}
