package kspcalc.graphics;

import java.awt.*;
import java.awt.geom.*;

import kspcal.utils.CelestrialBody;

public class OrbitalGraphics {
	private int windowHeight;
	private int windowWidth;
	
	/**
	 * @param windowHeight
	 * @param windowWidtht
	 */
	public OrbitalGraphics(int windowHeight, int windowWidth) {
		super();
		this.windowHeight = windowHeight;
		this.windowWidth = windowWidth;
	}

	public void drawCircle(int x, int y, int radius, int zoom, Graphics2D g) {
		radius /= zoom;
		g.drawOval(x - radius, y - radius, radius*2, radius*2);
		//g.drawOval(x - radius, y - radius, 10, 10);
	}
	
	public void filledCircle(int x, int y, int radius, int zoom, Graphics2D g) {
		radius /= zoom;
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

	public void drawEllipse(int x, int y, int a, int b, int zoom, Graphics2D g) {
		int f = (int) Math.sqrt((a*a) - (b*b));			// Get the focus point of the Ellipse
		g.drawOval(x - ((a - f) / zoom), y - (b / zoom), a * 2 / zoom, b * 2 / zoom);
		/*g.drawOval(x - ((a - f) / zoom), y - (b / zoom), 10, 10);
		System.out.println("a=" + a + " ; b=" + b + " ; x=" + x + " ; y=" + y + " ; f=" + f);
		System.out.println((x - ((a - f) / zoom)) + " " + (y - (b / zoom)) + " " +  a * 2 / zoom +" "+ b * 2 / zoom);//*/
	}
	
	public void drawTransferEllipse(int x, int y, int a, int b, boolean up, int zoom, Graphics2D g) {
		int f = (int) Math.sqrt((a*a) - (b*b));
		Arc2D arc = new Arc2D.Double();
		if (up) {
			arc.setArc(x - ((a - f) / zoom), y - (b / zoom), a * 2 / zoom, b * 2 / zoom, 0, -180, Arc2D.OPEN);
		} else {
			arc.setArc(x - ((a - f) / zoom), y - (b / zoom), a * 2 / zoom, b * 2 / zoom, 0, 180, Arc2D.OPEN); 
		}
		g.draw(arc);
		float dash1[] = {10.0f};
		float filled[] = {1f};
		g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
		this.drawEllipse(windowWidth / 2, windowHeight / 2, a, b, zoom, g);
		g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, filled, 0.0f));
	}
	
	public void drawHelpCircle(int x, int y, int radius, int zoom, Graphics2D g) {
		float dash1[] = {10.0f};
		float filled[] = {1f};
		g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
		this.drawCircle(x, y, radius, zoom, g);
		g.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, filled, 0.0f));
	}

	public void drawDVArrow(int i, int apogeeAlt, int zoom, Graphics2D g) {
		int x = windowWidth / 2 - (apogeeAlt / zoom);
		int y = windowHeight / 2; 
		this.drawArrow(x, y, x, y + i, g);
	}
	
	/**
	 * Draws an arrow on the given Graphics2D context
	 * @param g The Graphics2D context to draw on
	 * @param x The x location of the "tail" of the arrow
	 * @param y The y location of the "tail" of the arrow
	 * @param xx The x location of the "head" of the arrow
	 * @param yy The y location of the "head" of the arrow
	 */
	public void drawArrow(int x, int y, int xx, int yy, Graphics2D g)
	{
		float arrowWidth = 6.0f ;
		float theta = 0.423f ;
		int[] xPoints = new int[ 3 ] ;
		int[] yPoints = new int[ 3 ] ;
		float[] vecLine = new float[ 2 ] ;
		float[] vecLeft = new float[ 2 ] ;
		float fLength;
		float th;
		float ta;
		float baseX, baseY ;

		xPoints[ 0 ] = xx ;
		yPoints[ 0 ] = yy ;

		// build the line vector
		vecLine[ 0 ] = (float)xPoints[ 0 ] - x ;
		vecLine[ 1 ] = (float)yPoints[ 0 ] - y ;

		// build the arrow base vector - normal to the line
		vecLeft[ 0 ] = -vecLine[ 1 ] ;
		vecLeft[ 1 ] = vecLine[ 0 ] ;

		// setup length parameters
		fLength = (float)Math.sqrt( vecLine[0] * vecLine[0] + vecLine[1] * vecLine[1] ) ;
		th = arrowWidth / ( 2.0f * fLength ) ;
		ta = arrowWidth / ( 2.0f * ( (float)Math.tan( theta ) / 2.0f ) * fLength ) ;

		// find the base of the arrow
		baseX = ( (float)xPoints[ 0 ] - ta * vecLine[0]);
		baseY = ( (float)yPoints[ 0 ] - ta * vecLine[1]);

		// build the points on the sides of the arrow
		xPoints[ 1 ] = (int)( baseX + th * vecLeft[0] );
		yPoints[ 1 ] = (int)( baseY + th * vecLeft[1] );
		xPoints[ 2 ] = (int)( baseX - th * vecLeft[0] );
		yPoints[ 2 ] = (int)( baseY - th * vecLeft[1] );

		g.drawLine( x, y, (int)baseX, (int)baseY ) ;
		g.fillPolygon( xPoints, yPoints, 3 ) ;
	}
	
}
