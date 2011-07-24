package constants;

import java.text.DecimalFormat;

public final class Constants {
	
	static DecimalFormat format;
	
	static {
		format = new DecimalFormat("#.###");
	}
	
	// KEarth Radius
	public static final double RADIUS = 600000d;
	
	// BEarth Athmospheric Thickness
	public static final double ATHMOSPHERE = 35000d;
	
	// KEarth Gravity
	public static final double GRAVITY = 9.80665d;
	
	// KEarth GM
	public static final double GM = GRAVITY * RADIUS * RADIUS;
	
	// KEarth Mass
	public static final double MASS = 5.29E+22d;
	
	// KEarth Version
	public static final String Version = "0.8.1";
	
	public static final double square(double d) {
		return d * d;
	}
	
	public static final double cube(double d) {
		return d * d * d;
	}
	
	public static final String formatVel(double d) {
		return format.format(d) + " m/s";
	}
	
	public static final String formatVelKilo(double d) {
		d /= 1000d;
		return format.format(d) + " km/s";
	}
	
	public static final String formatPer(double d) {
		return format.format(d) + " minutes";
	}
	
	public static final String formatMeter(double d) {
		return format.format(d) + " meters";
	}
	
	public static final String formatKilo(double d) {
		return format.format(d) + " kilometer";
	}
	
	public static final String formatDouble(double d) {
		return format.format(d);
	}
}
