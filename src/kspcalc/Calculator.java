package kspcalc;
import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

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
public class Calculator extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3573861286066173188L;

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JTabbedPane jTabbedPane1;
	private CircularOrbitalCalculatorPanel orbitalCalculatorPanel1;
	private HohmannTransferCalculatorPanel hohmannTransferCalculatorPanel1;
	private EllipticOrbitCalculatorPanel ellipticOrbitCalculatorPanel1;
	private LaunchOrbitCalculatorPanel orbitLaunchCalculatorPanel1;
	private OrbitDisplayFrame orbitDisplay;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Calculator inst = new Calculator();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Calculator() {
		super();
		initGUI();
		orbitDisplay = new OrbitDisplayFrame(100, 100);
		orbitDisplay.setLocationRelativeTo(null);
		orbitDisplay.setVisible(false);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("KSP Calculator");
			{
				jTabbedPane1 = new JTabbedPane();
				getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
				jTabbedPane1.setPreferredSize(new java.awt.Dimension(400, 330));
				{
					orbitalCalculatorPanel1 = new CircularOrbitalCalculatorPanel(this);
					jTabbedPane1.addTab("Circular Orbit", null, orbitalCalculatorPanel1, null);
				}
				{
					ellipticOrbitCalculatorPanel1 = new EllipticOrbitCalculatorPanel(this);
					jTabbedPane1.addTab("Elliptic Orbit", null, ellipticOrbitCalculatorPanel1, null);
				}
				{
					hohmannTransferCalculatorPanel1 = new HohmannTransferCalculatorPanel();
					jTabbedPane1.addTab("Hohmann Transfer Orbit", null, hohmannTransferCalculatorPanel1, null);
				}
				{
					orbitLaunchCalculatorPanel1 = new LaunchOrbitCalculatorPanel();
					jTabbedPane1.addTab("Launch Orbit", null, orbitLaunchCalculatorPanel1, null);
				}
			}
			pack();
			this.setSize(480, 385);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void setOrbitDisplay(double apo, double peri) {
		orbitDisplay.setOrbits(apo, peri);
	}

}
