package kspcal.constants;

public enum Parts {

	Chute(0.3, "Parachute"),
	CP(1, "Command Module"),
	LFT(2.5, 0.3, 0, 0, 500, "Liquid Fuel Tank"),
	LFE(2, 2, 200, 5682, 0, "Liquid Fuel Engine"),
	SRB(1.8, 0.36, 130, 2257, 100, "Solid Fuel Booster"),
	SAS(0.8, "SAS"),
	Radial(0.4, "Radial Decoupler"),
	Stack(0.8, "Stack Decoupler"),
	Tri(0.8, "Tri-Coupler"),
	/*EmptySRB(1.8, "Empty Solid Fuel Booster")//*/;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	private final double massI;
	private final double massF;
	private final double thrust;
	private final double SI;
	private final double fuel;
	private final double massPerFuel;
	private final String name;
	
	/**
	 * @param massI
	 * @param massF
	 * @param thrust
	 * @param sI
	 * @param fuel
	 * @param massPerFuel
	 */
	private Parts(double massI, double massF, double thrust, double sI,
			double fuel, String name) {
		this.massI = massI;
		this.massF = massF;
		this.thrust = thrust;
		this.SI = sI;
		this.fuel = fuel;
		this.massPerFuel = (massI - massF) / fuel;
		this.name = name;
	}

	/**
	 * @param massI
	 */
	private Parts(double mass, String name) {
		this.massI = mass;
		this.massF = mass;
		this.thrust = 0;
		this.SI = 0;
		this.fuel = 0;
		this.massPerFuel = 0;
		this.name = name;
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
