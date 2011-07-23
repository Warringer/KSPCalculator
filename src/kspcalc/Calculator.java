package kspcalc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.JTabbedPane;

import javax.swing.*;

import javax.help.*;
import javax.help.CSH.DisplayHelpFromSource;

import orbitalmath.Constants;


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
	private JLabel jLabel5;
	private AbstractAction OkayAction;
	private JButton OkayButton;
	private JLabel jLabel4;
	private JLabel versionLabel;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JMenu Help;
	private JDialog AboutDialog;
	private AbstractAction AboutAction;
	private JMenuItem AboutItem;
	private JMenuItem HelpItem;
	private JMenuBar jMenuBar1;
	
	private Calculator frame;

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
		frame = this;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("KSP Calculator");
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.add(Box.createHorizontalGlue());
				{
					Help = new JMenu();
					jMenuBar1.add(Help);
					Help.setText("?");
					Help.setToolTipText("Help Menu");
					{
						HelpItem = startJavaHelp();
						Help.add(HelpItem);
					}
					{
						AboutItem = new JMenuItem();
						Help.add(AboutItem);
						AboutItem.setText("About");
						AboutItem.setAction(getAboutAction());
					}
				}
			}
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
					hohmannTransferCalculatorPanel1 = new HohmannTransferCalculatorPanel(this);
					jTabbedPane1.addTab("Hohmann Transfer Orbit", null, hohmannTransferCalculatorPanel1, null);
				}
				{
					orbitLaunchCalculatorPanel1 = new LaunchOrbitCalculatorPanel();
					jTabbedPane1.addTab("Launch Orbit", null, orbitLaunchCalculatorPanel1, null);
				}
			}
			pack();
			this.setSize(476, 411);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	public void setOrbitDisplay(double apo, double peri, boolean hohmann) {
		orbitDisplay.setOrbits(apo, peri, hohmann);
	}
	
	private AbstractAction getAboutAction() {
		if(AboutAction == null) {
			AboutAction = new AbstractAction("About", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 952771346385077936L;

				public void actionPerformed(ActionEvent evt) {
					frame.getAboutDialog().setVisible(true);
				}
			};
		}
		return AboutAction;
	}
	
	private JDialog getAboutDialog() {
		if(AboutDialog == null) {
			AboutDialog = new JDialog(this);
			AboutDialog.getContentPane().setLayout(null);
			AboutDialog.setPreferredSize(new java.awt.Dimension(268, 195));
			{
				jLabel1 = new JLabel();
				AboutDialog.getContentPane().add(jLabel1);
				jLabel1.setText("Kerbal Space Program");
				jLabel1.setBounds(43, 12, 205, 34);
				jLabel1.setFont(new java.awt.Font("Arial",0,20));
			}
			{
				jLabel2 = new JLabel();
				AboutDialog.getContentPane().add(jLabel2);
				jLabel2.setText("Calculator");
				jLabel2.setBounds(98, 52, 109, 21);
				jLabel2.setFont(new java.awt.Font("Arial",0,20));
			}
			{
				jLabel3 = new JLabel();
				AboutDialog.getContentPane().add(jLabel3);
				jLabel3.setText("Version:");
				jLabel3.setBounds(43, 89, 64, 15);
			}
			{
				jLabel4 = new JLabel();
				AboutDialog.getContentPane().add(jLabel4);
				jLabel4.setText("by:");
				jLabel4.setBounds(43, 110, 55, 15);
			}
			{
				versionLabel = new JLabel();
				AboutDialog.getContentPane().add(versionLabel);
				AboutDialog.getContentPane().add(getJLabel5());
				AboutDialog.getContentPane().add(getOkayButton());
				versionLabel.setText(Constants.Version);
				versionLabel.setBounds(106, 89, 85, 15);
			}
			AboutDialog.setSize(268, 195);
		}
		AboutDialog.setLocationRelativeTo(null);
		return AboutDialog;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Warringer");
			jLabel5.setBounds(106, 110, 85, 15);
		}
		return jLabel5;
	}
	
	private JButton getOkayButton() {
		if(OkayButton == null) {
			OkayButton = new JButton();
			OkayButton.setText("Okay");
			OkayButton.setBounds(106, 137, 44, 22);
			OkayButton.setAction(getOkayAction());
		}
		return OkayButton;
	}
	
	private AbstractAction getOkayAction() {
		if(OkayAction == null) {
			OkayAction = new AbstractAction("Okay", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8848019343344314900L;

				public void actionPerformed(ActionEvent evt) {
					frame.getAboutDialog().setVisible(false);
				}
			};
		}
		return OkayAction;
	}

	private JMenuItem startJavaHelp() {
		JMenuItem mi = null;
		try {
			HelpSet hs = this.getHelpSet("help/help.hs");
			HelpBroker hb = hs.createHelpBroker();
			mi = new JMenuItem("Help");
			DisplayHelpFromSource csh = new CSH.DisplayHelpFromSource(hb);
			mi.addActionListener(csh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mi;
	}
	
	public HelpSet getHelpSet(String helpsetfile) {
	      HelpSet hs = null;
	      ClassLoader cl = this.getClass().getClassLoader();
	      try {
	        URL hsURL = HelpSet.findHelpSet(cl, helpsetfile);
	        hs = new HelpSet(null, hsURL);
	      } catch(Exception ee) {
	        System.out.println("HelpSet: "+ee.getMessage());
	        System.out.println("HelpSet: "+ helpsetfile + " not found");
	      }
	      return hs;
	   }
}
