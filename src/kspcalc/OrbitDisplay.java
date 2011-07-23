package kspcalc;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import constants.Constants;


public class OrbitDisplay extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6153638887419472697L;
	
	private int windowWidth;
	private int windowHeight;
	private int zoom;						
	private int planetSize;					// Planetary Size
	private int atmosphereThickness;		// Athomsphere Thickness 
	private int apogeeAlt;					// Apogee Altitude
	private int perigeeAlt;					// Perigee Altitude
	private int a, b;						// Axis of the Orbit
	private boolean hohmann;				// Hohmann Transfer Orbit?

	
	/**
	 * 
	 */
	public OrbitDisplay(int width, int height, int apo, int peri) {
		super();
		this.planetSize = (int) (Constants.RADIUS / 1000d);
		this.atmosphereThickness =  (int) (Constants.ATHMOSPHERE / 1000d);
		this.windowHeight = height;
		this.windowWidth = width;
		this.zoom = 2;
		this.apogeeAlt = apo + this.planetSize;
		this.perigeeAlt = peri + this.planetSize;
		this.hohmann = false;
		this.calcOrbit();
	}

	public void setAlts(int apo, int peri, boolean hohmann) {
		this.zoom = 2;
		this.apogeeAlt = apo + this.planetSize;
		this.perigeeAlt = peri + this.planetSize;
		this.hohmann = hohmann;
		this.calcOrbit();
	}

	/**
	 * @return the windowWidth
	 */
	public int getWindowWidth() {
		return windowWidth;
	}



	/**
	 * @param windowWidth the windowWidth to set
	 */
	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}



	/**
	 * @return the windowHeight
	 */
	public int getWindowHeight() {
		return windowHeight;
	}



	/**
	 * @param windowHeight the windowHeight to set
	 */
	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}



	/**
	 * @return the zoom
	 */
	public int getZoom() {
		return zoom;
	}



	/**
	 * @param zoom the zoom to set
	 */
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}



	/**
	 * @return the planetSize
	 */
	public int getPlanetSize() {
		return planetSize;
	}



	/**
	 * @param planetSize the planetSize to set
	 */
	public void setPlanetSize(int planetSize) {
		this.planetSize = planetSize;
	}



	/**
	 * @return the atmosphereThickness
	 */
	public int getAtmosphereThickness() {
		return atmosphereThickness;
	}



	/**
	 * @param atmosphereThickness the atmosphereThickness to set
	 */
	public void setAtmosphereThickness(int atmosphereThickness) {
		this.atmosphereThickness = atmosphereThickness;
	}



	/**
	 * @return the apogeeAlt
	 */
	public int getApogeeAlt() {
		return apogeeAlt;
	}



	/**
	 * @param apogeeAlt the apogeeAlt to set
	 */
	public void setApogeeAlt(int apogeeAlt) {
		this.apogeeAlt = apogeeAlt;
	}



	/**
	 * @return the perigeeAlt
	 */
	public int getPerigeeAlt() {
		return perigeeAlt;
	}



	/**
	 * @param perigeeAlt the perigeeAlt to set
	 */
	public void setPerigeeAlt(int perigeeAlt) {
		this.perigeeAlt = perigeeAlt;
	}
	
	public void calcOrbit() {
		if (this.apogeeAlt == this.perigeeAlt) {
			this.a = this.apogeeAlt;
			this.b = this.apogeeAlt;
		} else {
			this.a = (this.apogeeAlt + this.perigeeAlt) / 2;
			this.b = (int) Math.sqrt(this.apogeeAlt * this.perigeeAlt);
		}
		while ((this.apogeeAlt + this.windowWidth) / (this.zoom) > this.windowWidth / 2) {
			this.zoom++;
		}
		System.out.println("Apogee: " + apogeeAlt + ", Perigee: "+ perigeeAlt);
		System.out.println("a: " + a + ", b: " + b + ", zoom: " + zoom);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g1) {
		// TODO Auto-generated method stub
		Graphics2D g = (Graphics2D) g1;
	    BufferedImage image = // Create an off-screen image
	    new BufferedImage(this.windowWidth, this.windowHeight, BufferedImage.TYPE_INT_RGB);
	    Graphics2D ig = image.createGraphics();
		
		ig.setColor(Color.white);
		ig.fillRect(0, 0, this.windowWidth, this.windowHeight);
		
		ig.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
		        RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Paint Athmosphere
		ig.setColor(Color.cyan);
		this.filledCircle(this.windowWidth / 2, this.windowHeight / 2, (this.planetSize + this.atmosphereThickness) / this.zoom, ig);
		
		// Paint Planet
		ig.setColor(Color.blue);
		this.filledCircle(this.windowWidth / 2, this.windowHeight / 2, this.planetSize / this.zoom, ig);
		
		// Paint Orbit
		if (this.hohmann) {
			ig.setColor(Color.red);
		} else {
			ig.setColor(Color.black);
		}
		if (this.apogeeAlt == this.perigeeAlt) {
			this.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.a / this.zoom, ig);
		} else {
			this.drawEllipse(this.windowWidth / 2, this.windowHeight / 2, this.a / this.zoom, this.b / this.zoom , ig);
		}
		
		// Paint Circular Orbits for the Hohmann Transfer Orbit
		if (this.hohmann) {
			ig.setColor(Color.black);
			this.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.apogeeAlt / this.zoom, ig);
			this.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.perigeeAlt / this.zoom, ig);
		}
		
		ig.drawString("Zoom Factor: " + this.zoom + "x", 5, this.windowHeight - 30);
		
		g.drawImage(image, 0, 0, this);
	}
	
	private void drawCircle(int x, int y, int radius, Graphics2D g) {
		g.drawOval(x - radius, y - radius, radius*2, radius*2);
	}
	
	private void filledCircle(int x, int y, int radius, Graphics2D g) {
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	private void drawEllipse(int x, int y, int a, int b, Graphics2D g) {
		int f = (int) Math.sqrt((a*a) - (b*b));
		g.drawOval(x - a + f, y - b, a * 2, b * 2);
		System.out.println("x: " + x + ", y: " + y);
		System.out.println("a: "+ a + ", b: " + b + ", f: " + f);
	}
	
}
