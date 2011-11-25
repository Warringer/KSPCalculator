package kspcal.utils;

public enum CelestrialBody {
	
	KEarth(600d, 35d, 35d, 5.29E+22d ,9.80665d, "KEarth"),
	Mun(200, 0, 0, 9.760e+20, 1.628, "Mun"),
	Sun(6.54e+04, 0, 0, 1.756567e+28, 27.94, "Kerbol");
	
	private double radius;
	private double lowAthmos;
	private double highAthmos;
	private double mass;
	private double gravity;
	private String name;
	
	/**
	 * @param radius
	 * @param lowAthmos
	 * @param highAthmos
	 * @param mass
	 * @param gravity
	 * @param gm
	 */
	private CelestrialBody(double radius, double lowAthmos, double highAthmos,
			double mass, double gravity, String name) {
		this.radius = radius * 1000;
		this.lowAthmos = lowAthmos * 1000;
		this.highAthmos = highAthmos * 1000;
		this.mass = mass;
		this.gravity = gravity;
		this.name = name;
	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	public boolean hasAthmos() {
		return (lowAthmos > 0);
	}
	/**
	 * @return the lowAthmos
	 */
	public double getLowAthmos() {
		return lowAthmos;
	}
	/**
	 * @return the highAthmos
	 */
	public double getHighAthmos() {
		return highAthmos;
	}
	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}
	/**
	 * @return the gravity
	 */
	public double getGravity() {
		return gravity;
	}
	/**
	 * @return the gm
	 */
	public double getGm() {
		return gravity * radius * radius;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return this.name;
	}

}
