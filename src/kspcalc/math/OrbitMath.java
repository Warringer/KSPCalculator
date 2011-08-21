package kspcalc.math;

import kspcal.utils.Constants;

public class OrbitMath {

	public OrbitMath() {
		super();
	}

	protected double doEllipseVel(double r, double a) {
		return Math.sqrt((2 * Constants.GM / r) - (Constants.GM / a));
	}

	protected double doCircularOrbitMath(double d) {
		return Math.sqrt(Constants.GM / d);
	}
	
	protected double doEscapeVel(double d) {
		return  Math.sqrt((2d * Constants.GM) / d);
	}

}