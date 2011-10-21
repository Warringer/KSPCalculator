package kspcalc;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;


import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcal.utils.Constants;
import kspcalc.math.LaunchOrbit;


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
public class LaunchOrbitCalculatorPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3331779487398827988L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel launchApoVelOut;
	private JLabel launchApoAltOut;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JLabel jLabel7;
	private JLabel launchPerVelOut;
	private JLabel launchPerAltOut;
	private JLabel jLabel6;
	private JButton launchCalculateButton;
	private JTextField launchBurnAngField;
	private JRadioButton launchAltKiloRadio;
	private JRadioButton launchAltMeterRadio;
	private JTextField launchBurnAltField;
	private JTextField launchBurnVelField;

	private boolean kilometer;
	private LaunchOrbitCalculatorPanel panel;
	private JComboBox celestrialBodyCombo;
	private JLabel jLabel11;
	private JLabel jLabel10;
	private AbstractAction launchCalculateAction;
	private AbstractAction launchAltKiloAction;
	private AbstractAction launchAltMeterAction;
	private Calculator frame;

	public LaunchOrbitCalculatorPanel(Calculator frame) {
		super();
		kilometer = false;
		panel = this;
		this.frame = frame;
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(500, 400));
			{
				launchApoVelOut = new JLabel();
				this.add(getCelestrialBodyCombo(), new AnchorConstraint(98, 955, 153, 675, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel11(), new AnchorConstraint(561, 971, 681, 551, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel10(), new AnchorConstraint(101, 683, 151, 541, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(launchApoVelOut, new AnchorConstraint(801, 551, 851, 256, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchApoVelOut.setText("0.0 m/s");
				launchApoVelOut.setPreferredSize(new java.awt.Dimension(118, 15));
			}
			{
				launchApoAltOut = new JLabel();
				this.add(launchApoAltOut, new AnchorConstraint(751, 551, 801, 256, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchApoAltOut.setText("0 m");
				launchApoAltOut.setPreferredSize(new java.awt.Dimension(118, 15));
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9, new AnchorConstraint(801, 256, 851, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel9.setText("Velocity:");
				jLabel9.setPreferredSize(new java.awt.Dimension(78, 15));
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8, new AnchorConstraint(751, 256, 801, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel8.setText("Altitude:");
				jLabel8.setPreferredSize(new java.awt.Dimension(78, 15));
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7, new AnchorConstraint(681, 256, 731, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel7.setText("Apoapsis:");
				jLabel7.setPreferredSize(new java.awt.Dimension(90, 15));
			}
			{
				launchPerVelOut = new JLabel();
				this.add(launchPerVelOut, new AnchorConstraint(608, 551, 658, 256, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchPerVelOut.setText("0.0 m/s");
				launchPerVelOut.setPreferredSize(new java.awt.Dimension(118, 15));
			}
			{
				launchPerAltOut = new JLabel();
				this.add(launchPerAltOut, new AnchorConstraint(561, 551, 611, 256, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchPerAltOut.setText("0 m");
				launchPerAltOut.setPreferredSize(new java.awt.Dimension(118, 15));
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6, new AnchorConstraint(611, 256, 661, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel6.setText("Velocity:");
				jLabel6.setPreferredSize(new java.awt.Dimension(78, 15));
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5, new AnchorConstraint(561, 256, 611, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel5.setText("Altitude:");
				jLabel5.setPreferredSize(new java.awt.Dimension(78, 15));
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4, new AnchorConstraint(491, 256, 541, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel4.setText("Periapsis:");
				jLabel4.setPreferredSize(new java.awt.Dimension(90, 15));
			}
			{
				launchCalculateButton = new JButton();
				this.add(launchCalculateButton, new AnchorConstraint(378, 788, 451, 551, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchCalculateButton.setText("Calculate");
				launchCalculateButton.setPreferredSize(new java.awt.Dimension(95, 22));
				launchCalculateButton.setAction(getLaunchCalculateAction());
			}
			{
				launchBurnAngField = new JTextField();
				this.add(launchBurnAngField, new AnchorConstraint(378, 521, 451, 46, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchBurnAngField.setPreferredSize(new java.awt.Dimension(190, 22));
			}
			{
				launchAltKiloRadio = new JRadioButton();
				this.add(launchAltKiloRadio, new AnchorConstraint(238, 831, 301, 551, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchAltKiloRadio.setText("Kilometer");
				launchAltKiloRadio.setSelected(kilometer);
				launchAltKiloRadio.setPreferredSize(new java.awt.Dimension(112, 19));
				launchAltKiloRadio.setAction(getLaunchAltKiloAction());
			}
			{
				launchAltMeterRadio = new JRadioButton();
				this.add(launchAltMeterRadio, new AnchorConstraint(178, 831, 241, 551, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchAltMeterRadio.setText("Meter");
				launchAltMeterRadio.setSelected(!kilometer);
				launchAltMeterRadio.setPreferredSize(new java.awt.Dimension(112, 19));
				launchAltMeterRadio.setAction(getLaunchAltMeterAction());
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new AnchorConstraint(328, 451, 378, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("Velocity Vector at Burnout:");
			}
			{
				launchBurnAltField = new JTextField();
				this.add(launchBurnAltField, new AnchorConstraint(235, 521, 308, 46, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchBurnAltField.setPreferredSize(new java.awt.Dimension(190, 22));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(185, 338, 235, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("Altitude at Burnout:");
			}
			{
				launchBurnVelField = new JTextField();
				this.add(launchBurnVelField, new AnchorConstraint(91, 526, 165, 46, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				launchBurnVelField.setPreferredSize(new java.awt.Dimension(192, 22));
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(41, 338, 91, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Velocity at Burnout:");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getLaunchAltMeterAction() {
		if(launchAltMeterAction == null) {
			launchAltMeterAction = new AbstractAction("Meter", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -8890729590965801148L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = false;
					panel.launchAltMeterRadio.setSelected(!kilometer);
					panel.launchAltKiloRadio.setSelected(kilometer);
				}
			};
		}
		return launchAltMeterAction;
	}
	
	private AbstractAction getLaunchAltKiloAction() {
		if(launchAltKiloAction == null) {
			launchAltKiloAction = new AbstractAction("Kilometer", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -8674023090630561232L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = true;
					panel.launchAltMeterRadio.setSelected(!kilometer);
					panel.launchAltKiloRadio.setSelected(kilometer);
				}
			};
		}
		return launchAltKiloAction;
	}
	
	private AbstractAction getLaunchCalculateAction() {
		if(launchCalculateAction == null) {
			launchCalculateAction = new AbstractAction("Calculate", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4183366624601945699L;

				public void actionPerformed(ActionEvent evt) {
					doCalculate(panel);
				}

				private void doCalculate(LaunchOrbitCalculatorPanel panel) {
					double launchVel = Double.parseDouble(panel.launchBurnVelField.getText());
					double launchAlt = Double.parseDouble(panel.launchBurnAltField.getText());
					double launchAng = Double.parseDouble(panel.launchBurnAngField.getText());
					if (kilometer) {
						launchAlt *= 1000d;
					}
					LaunchOrbit launch = new LaunchOrbit(launchVel, launchAlt, launchAng, panel.frame.body);
					double launchPerAlt = launch.getLaunchPerAlt();
					double launchApoAlt = launch.getLaunchApoAlt();
					String launchPAlt = Constants.formatAlt(launchPerAlt);
					String launchAAlt = Constants.formatAlt(launchApoAlt);
					panel.launchPerAltOut.setText(launchPAlt);
					panel.launchApoAltOut.setText(launchAAlt);
					panel.launchPerVelOut.setText(Constants.formatVel(launch.getLaunchPerVel()));
					panel.launchApoVelOut.setText(Constants.formatVel(launch.getLaunchApoVel()));
				}
			};
		}
		return launchCalculateAction;
	}
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("m/s");
			jLabel10.setPreferredSize(new java.awt.Dimension(57, 15));
		}
		return jLabel10;
	}
	
	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("Experimental!");
			jLabel11.setPreferredSize(new java.awt.Dimension(168, 36));
			jLabel11.setFont(new java.awt.Font("Andale Mono",0,20));
		}
		return jLabel11;
	}
	
	private JComboBox getCelestrialBodyCombo() {
		if(celestrialBodyCombo == null) {
			ComboBoxModel celestrialBodyComboModel = 
				new DefaultComboBoxModel(
						new String[] { "Item One", "Item Two" });
			celestrialBodyCombo = new JComboBox();
			celestrialBodyCombo.setModel(celestrialBodyComboModel);
			celestrialBodyCombo.setPreferredSize(new java.awt.Dimension(140, 22));
		}
		return celestrialBodyCombo;
	}

}
