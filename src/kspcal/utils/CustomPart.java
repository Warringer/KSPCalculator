package kspcal.utils;

import java.io.*;
import java.util.Properties;

import kspcalc.components.SpinnerLabelComponent;

public class CustomPart {

	private double massI = 0;
	private double massF = 0;
	private double thrust = 0;
	private double SI = 0;
	private double fuel = 0;
	private double fuelNeed = 0;
	private double massPerFuel = 0;
	private CustomPartType type;
	private String name = "";
	private SpinnerLabelComponent spinner = null;
	private String module = "";
	
	public CustomPart(String partPath) {
		super();
		Properties properties = new Properties();
		try {
			//System.out.println("Custom Part Path: " + partPath);
			properties.load(new FileInputStream(partPath + File.separator + "part.cfg"));
			switch (Integer.parseInt(properties.getProperty("category"))) {
			case 0:
				this.type = CustomPartType.PROP;
				break;
			case 1:
				this.type = CustomPartType.CnC;
				break;
			case 2:
				this.type = CustomPartType.SaA;
				break;
			case 3:
				this.type = CustomPartType.UTILITY;
				break;
			default:
				throw new IOException();
			}
			this.module = properties.getProperty("module");
			this.name = properties.getProperty("title");
			this.massI = Double.parseDouble(properties.getProperty("mass"));
			if (properties.containsKey("dryMass")) {
				this.massF = Double.parseDouble(properties.getProperty("dryMass"));
			} else {
				this.massF = this.massI;
			}
			if (properties.containsKey("fuelConsumption")) {
				this.fuelNeed = Double.parseDouble(properties.getProperty("fuelConsumption"));
			}
			// For fuel tanks
			if (properties.containsKey("fuel")) {
				this.fuel = Double.parseDouble(properties.getProperty("fuel"));
			}
			// For Solid Rocket Boosters
			if (properties.containsKey("internalFuel")) {
				this.fuel = Double.parseDouble(properties.getProperty("internalFuel"));
			}
			// For solid Rocket Boosters or not variable thrusters
			if (properties.containsKey("thrust")) {
				this.thrust = Double.parseDouble(properties.getProperty("thrust"));
			}
			// For variable thrusters
			if (properties.containsKey("maxThrust")) {
				this.thrust = Double.parseDouble(properties.getProperty("maxThrust"));
			}
			if (properties.containsKey("fuelConsumtion")) {
				this.fuelNeed = Double.parseDouble(properties.getProperty("fuelConsumtion"));
			}
			this.doMath();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param massI
	 * @param massF
	 * @param thrust
	 * @param fuel
	 * @param fuelNeed
	 * @param type
	 * @param name
	 * @param spinner
	 * @param module
	 */
	public CustomPart(double massI, double massF, double thrust, double fuel,
			double fuelNeed, CustomPartType type, String name, String module) {
		super();
		this.massI = massI;
		this.massF = massF;
		this.thrust = thrust;
		this.fuel = fuel;
		this.fuelNeed = fuelNeed;
		this.type = type;
		this.name = name;
		this.module = module;
		this.doMath();
	}

	private void doMath() {
		if (this.massI != this.massF) {
			this.massPerFuel = ((this.massI - this.massF) / this.fuel) * 1000;
		} else {
			this.massPerFuel = ((2.5 - 0.3) / 500) * 1000;
		}
		if (this.fuelNeed > 0) {
			this.SI = (this.thrust * 1000) / (Constants.GRAVITY * this.fuelNeed * this.massPerFuel);
		} else {
			this.SI = 0;
		}
	}
	
	public double getProportonalFuelNeed(double combinedFuelNeed) {
		return (this.getNumber() * this.fuelNeed * this.massPerFuel) / combinedFuelNeed;
	}

	/**
	 * @return the massI
	 */
	public double getMassI() {
		return massI;
	}

	/**
	 * @param massI the massI to set
	 */
	public void setMassI(double massI) {
		this.massI = massI;
	}

	/**
	 * @return the massF
	 */
	public double getMassF() {
		return massF;
	}

	/**
	 * @param massF the massF to set
	 */
	public void setMassF(double massF) {
		this.massF = massF;
	}

	/**
	 * @return the thrust
	 */
	public double getThrust() {
		return thrust;
	}

	/**
	 * @param thrust the thrust to set
	 */
	public void setThrust(double thrust) {
		this.thrust = thrust;
	}

	/**
	 * @return the sI
	 */
	public double getSI() {
		return SI;
	}

	/**
	 * @param sI the sI to set
	 */
	public void setSI(double sI) {
		SI = sI;
	}

	/**
	 * @return the fuel
	 */
	public double getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the fuelNeed
	 */
	public double getFuelNeed() {
		return fuelNeed;
	}

	/**
	 * @param fuelNeed the fuelNeed to set
	 */
	public void setFuelNeed(double fuelNeed) {
		this.fuelNeed = fuelNeed;
	}

	/**
	 * @return the massPerFuel
	 */
	public double getMassPerFuel() {
		return massPerFuel;
	}

	/**
	 * @param massPerFuel the massPerFuel to set
	 */
	public void setMassPerFuel(double massPerFuel) {
		this.massPerFuel = massPerFuel;
	}

	/**
	 * @return the type
	 */
	public CustomPartType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(CustomPartType type) {
		this.type = type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("CustomPart [massI=%s, massF=%s, thrust=%s, SI=%s, fuel=%s, fuelNeed=%s, massPerFuel=%s, type=%s, name=%s]",
						massI, massF, thrust, SI, fuel, fuelNeed, massPerFuel,
						type, name);
	}

	/**
	 * @return the spinner
	 */
	public SpinnerLabelComponent getSpinner(int x, int y, String name) {
		if (this.spinner == null) {
			this.spinner = new SpinnerLabelComponent(name);
		}
		this.spinner.setBounds(x, y, 250, 24);
		return this.spinner;
	}

	/**
	 * @param value the value to set
	 */
	public void setNumber(int value) {
		this.spinner.setValue(value);
	}
	
	public int getNumber() {
		return this.spinner.getValue();
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getModule() {
		return module;
	}
	
}
