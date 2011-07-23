package kspcalc;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class OrbitDisplayFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4172621582959938549L;
	private OrbitDisplay orbitDisplay1;
	private double apoAlt;
	private double perAlt;
	private OrbitDisplayFrame frame;

	public OrbitDisplayFrame(double apoAlt, double perAlt) {
		super();
		this.apoAlt = apoAlt;
		this.perAlt = perAlt;
		this.frame = this;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					System.out.println("this.windowClosed, event="+evt);
					//TODO add your code for this.windowClosed
					frame.setVisible(false);
				}
			});

			{
				orbitDisplay1 = new OrbitDisplay(500, 500, (int) this.apoAlt, (int) this.perAlt);
				getContentPane().add(orbitDisplay1, BorderLayout.CENTER);
			}
			pack();
			setSize(500, 500);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void setOrbits(double apo, double peri, boolean hohmann) {
		orbitDisplay1.setAlts((int) apo, (int) peri, hohmann);
		this.setVisible(true);
	}

}
