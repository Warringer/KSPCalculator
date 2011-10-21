package kspcalc.graphics;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;



public class OrbitDisplay extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6153638887419472697L;
	
	private int windowWidth;
	private int windowHeight;
	private int zoom;						
	private int planetSize;					// Planetary Size
	private int lowAtmosphereThickness;		// Lower Athomsphere Thickness
	private int upAtmosphereThickness;		// Upper Athomsphere Thickness
	private int apogeeAlt;					// Apogee Altitude
	private int perigeeAlt;					// Perigee Altitude
	private int a, b;						// Axis of the Orbit
	private boolean hohmann;				// Hohmann Transfer Orbit?
	private boolean up;						// Direction of the Hohmann Orbit
	private OrbitalGraphics og;				// Orbital Graphics helper class
	private int biorb;						// Bi Orbital Max Altitude
	private int[] aBiorb, bBiorb;			// Axis of BiOrbital Ellipses
	private CelestrialBody body;

	
	/**
	 * 
	 */
	public OrbitDisplay(int width, int height, int apo, int peri, int biorb, CelestrialBody body) {
		super();
		this.body = body;
		this.og = new OrbitalGraphics(height, width);
		this.planetSize = (int) (body.getRadius() / 1000d);
		this.lowAtmosphereThickness =  (int) (body.getLowAthmos() / 1000d);
		this.upAtmosphereThickness = (int) (body.getHighAthmos() / 1000d);
		this.windowHeight = height;
		this.windowWidth = width;
		this.zoom = 2;
		this.apogeeAlt = apo + this.planetSize;
		this.perigeeAlt = peri + this.planetSize;
		this.hohmann = false;
		this.biorb = biorb + this.planetSize;
		if (biorb > 0) {
			this.aBiorb = new int[2];
			this.bBiorb = new int[2];
		}
		this.calcOrbit();
	}

	public void setAlts(int apo, int peri, boolean hohmann, boolean up, int biorb, CelestrialBody body) {
		this.zoom = 2;
		this.body = body;
		this.planetSize = (int) (body.getRadius() / 1000d);
		this.lowAtmosphereThickness =  (int) (body.getLowAthmos() / 1000d);
		this.upAtmosphereThickness = (int) (body.getHighAthmos() / 1000d);
		this.apogeeAlt = apo + this.planetSize;
		this.perigeeAlt = peri + this.planetSize;
		this.hohmann = hohmann;
		this.up = up;
		this.biorb = biorb + this.planetSize;
		if (biorb > 0) {
			this.aBiorb = new int[2];
			this.bBiorb = new int[2];
		}
		this.calcOrbit();
		this.repaint();
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
	 * @return the lowatmosphereThickness
	 */
	public int getLowAtmosphereThickness() {
		return lowAtmosphereThickness;
	}

	/**
	 * @param atmosphereThickness the atmosphereThickness to set
	 */
	public void setLowAtmosphereThickness(int atmosphereThickness) {
		this.lowAtmosphereThickness = atmosphereThickness;
	}

	/**
	 * @param atmosphereThickness the atmosphereThickness to set
	 */
	public void setUpAtmosphereThickness(int atmosphereThickness) {
		this.upAtmosphereThickness = atmosphereThickness;
	}
	
	/**
	 * @return the lowatmosphereThickness
	 */
	public int getUpAtmosphereThickness() {
		return upAtmosphereThickness;
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
		if (this.biorb <= this.planetSize) {
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
		} else {
			this.aBiorb[0] = (this.biorb + this.perigeeAlt) / 2;
			this.aBiorb[1] = (this.biorb + this.apogeeAlt) / 2;
			this.bBiorb[0] = (int) Math.sqrt(this.biorb * this.perigeeAlt);
			this.bBiorb[1] = (int) Math.sqrt(this.apogeeAlt * this.biorb);
			while ((this.biorb + this.windowWidth) / (this.zoom) > this.windowWidth / 2) {
				this.zoom++;
			}
		}
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
		if (body.hasAthmos()) {
			ig.setColor(new Color(126, 250, 250, 128));
			og.filledCircle(this.windowWidth / 2, this.windowHeight / 2, this.planetSize + this.lowAtmosphereThickness + this.upAtmosphereThickness , this.zoom, ig);
			ig.setColor(new Color(90, 214, 214, 128));
			og.filledCircle(this.windowWidth / 2, this.windowHeight / 2, this.planetSize + this.lowAtmosphereThickness , this.zoom, ig);
		}
		
		// Paint Planet
		ig.setColor(new Color(83, 83, 252));
		og.filledCircle(this.windowWidth / 2, this.windowHeight / 2, this.planetSize , this.zoom, ig);
		
		ig.setColor(Color.black);
		// Paint Circular Orbits for the Transfer Orbit
		if (this.hohmann) {
			this.paintHohmannChange(ig);
		} else if (this.biorb > this.planetSize) {
			this.paintBiEllipticChange(ig);
		} else {
			// Paint Orbit
			if (this.apogeeAlt == this.perigeeAlt) {
				og.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.a , this.zoom, ig);
			} else {
				og.drawEllipse(this.windowWidth / 2, this.windowHeight / 2, this.a, this.b , this.zoom, ig);
			}
		}
		
		ig.drawString("Zoom Factor: " + this.zoom + "x", 5, this.windowHeight - 30);
		
		g.drawImage(image, 0, 0, this);
	}
	
	private void paintHohmannChange(Graphics2D g) {
		if (this.up) {
			g.setColor(Color.red);
		} else {
			g.setColor(Color.green);
		}
		og.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.apogeeAlt , this.zoom, g);
		if (this.up) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.red);
		}
		og.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.perigeeAlt , this.zoom, g);
		g.setColor(Color.gray);
    	og.drawTransferEllipse(this.windowWidth / 2, this.windowHeight / 2, this.a, this.b, this.up, this.zoom, g);
    	g.setColor(Color.black);
    	int dir = 50;
    	if (!this.up) {
    		dir *= -1;
    	}
    	og.drawDVArrow(dir, this.perigeeAlt, zoom ,g);
    	og.drawDVArrow(dir * -1, -this.apogeeAlt, zoom, g);
	}
	
	private void paintBiEllipticChange(Graphics2D g) {
		if (!this.up) {
			g.setColor(Color.red);
		} else {
			g.setColor(Color.green);
		}
		og.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.apogeeAlt, this.zoom, g);
		if (!this.up) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.red);
		}
		og.drawCircle(this.windowWidth / 2, this.windowHeight / 2, this.perigeeAlt, this.zoom, g);
		g.setColor(Color.gray);
		og.drawHelpCircle(this.windowWidth / 2, this.windowHeight / 2, this.biorb, this.zoom, g);
		g.setColor(Color.darkGray);
		og.drawTransferEllipse(this.windowWidth / 2, this.windowHeight / 2, this.aBiorb[0], this.bBiorb[0], !this.up, zoom, g);
		g.setColor(Color.lightGray);
		og.drawTransferEllipse(this.windowWidth / 2, this.windowHeight / 2, this.aBiorb[1], this.bBiorb[1], this.up, zoom, g);
		g.setColor(Color.black);
		int dirinit = 50;
		int dirchange = dirinit;
		int dirfinal = dirinit * -1;
    	if (this.up) {
    		dirinit *= -1;
    		dirchange *= -1;
    		dirfinal *= -1; 
    	}
    	og.drawDVArrow(dirinit, this.perigeeAlt, zoom ,g);
    	og.drawDVArrow(dirfinal, this.apogeeAlt, zoom, g);
    	og.drawDVArrow(dirchange, -this.biorb, zoom, g);
	}
	
}
