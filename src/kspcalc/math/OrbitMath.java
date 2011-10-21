package kspcalc.math;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;

public class OrbitMath {

	protected CelestrialBody body;
	
	public OrbitMath(CelestrialBody body) {
		super();
		this.body = body;
	}

	protected double doEllipseVel(double r, double a) {
		return Math.sqrt((2 * body.getGm() / r) - (body.getGm() / a));
	}

	protected double doCircularOrbitMath(double d) {
		return Math.sqrt(body.getGm() / d);
	}
	
	protected double doEscapeVel(double d) {
		return  Math.sqrt((2d * body.getGm()) / d);
	}

}