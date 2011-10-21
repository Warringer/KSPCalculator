package kspcalc;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;



import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;
import kspcalc.math.*;

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
public class CircularOrbitalCalculatorPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7149412324769277050L;
	private JLabel jLabel1;
	private JRadioButton orbAltMeterRadio;
	private JRadioButton orbAltKiloRadio;
	private AbstractAction orbCalcAction;
	private AbstractAction orbAltKiloAction;
	private AbstractAction orbAltMeterAction;
	private JButton orbCalcButton;
	private JLabel escVelOut;
	private JLabel orbPerOut;
	private JLabel orbVelOut;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JTextField orbAltField;
	private Calculator frame;
	private double alt;

	private boolean kilometer;
	private CircularOrbitalCalculatorPanel panel;
	private JLabel jLabel5;
	private AbstractAction celestrialBodyAction;
	private JComboBox celestrialBodySelector;
	private AbstractAction showOrbitAction;
	private JButton showOrbitButton;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
		
	public CircularOrbitalCalculatorPanel(Calculator frame) {
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
				orbCalcButton = new JButton();
				this.add(getJLabel5(), new AnchorConstraint(111, 669, 148, 595, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJComboBox1(), new AnchorConstraint(91, 977, 166, 669, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getShowOrbitButton(), new AnchorConstraint(601, 363, 673, 25, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(orbCalcButton, new AnchorConstraint(498, 273, 573, 25, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				orbCalcButton.setText("Calculate");
				orbCalcButton.setPreferredSize(new java.awt.Dimension(124, 30));
				orbCalcButton.setAction(getOrbCalcAction());
			}
			{
				escVelOut = new JLabel();
				this.add(escVelOut, new AnchorConstraint(418, 668, 468, 353, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				escVelOut.setText("0.0 m/s");
				escVelOut.setPreferredSize(new java.awt.Dimension(126, 15));
			}
			{
				orbPerOut = new JLabel();
				this.add(orbPerOut, new AnchorConstraint(348, 861, 398, 353, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				orbPerOut.setText("0 minutes");
				orbPerOut.setPreferredSize(new java.awt.Dimension(203, 15));
			}
			{
				orbVelOut = new JLabel();
				this.add(orbVelOut, new AnchorConstraint(278, 668, 328, 353, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				orbVelOut.setText("0.0 m/s");
				orbVelOut.setPreferredSize(new java.awt.Dimension(126, 15));
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4, new AnchorConstraint(418, 353, 468, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel4.setText("Escape Velocity:");
				jLabel4.setPreferredSize(new java.awt.Dimension(129, 15));
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new AnchorConstraint(348, 353, 398, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("Orbital Period:");
				jLabel3.setPreferredSize(new java.awt.Dimension(129, 15));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(278, 353, 328, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("Orbital Velocity:");
				jLabel2.setPreferredSize(new java.awt.Dimension(129, 15));
			}
			{
				orbAltKiloRadio = new JRadioButton();
				this.add(orbAltKiloRadio, new AnchorConstraint(185, 441, 248, 251, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				orbAltKiloRadio.setText("Kilometer");
				orbAltKiloRadio.setAction(getOrbAltKiloAction());
			}
			{
				orbAltMeterRadio = new JRadioButton();
				this.add(orbAltMeterRadio, new AnchorConstraint(185, 238, 248, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				orbAltMeterRadio.setText("Meter");
				orbAltMeterRadio.setSelected(true);
				orbAltMeterRadio.setPreferredSize(new java.awt.Dimension(83, 19));
				orbAltMeterRadio.setAction(getOrbAltMeterAction());
			}
			{
				orbAltField = new JTextField();
				this.add(orbAltField, new AnchorConstraint(91, 583, 165, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				orbAltField.setPreferredSize(new java.awt.Dimension(221, 22));
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(41, 151, 91, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Altitude");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CircularOrbitalCalculatorPanel getOrbitalCalculatorPanel() {
		return this;
	}
	
	private AbstractAction getOrbAltMeterAction() {
		if(orbAltMeterAction == null) {
			orbAltMeterAction = new AbstractAction("Meter", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -6665771504918256601L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = false;
					panel.orbAltKiloRadio.setSelected(false);
					panel.orbAltMeterRadio.setSelected(true);
				}
			};
		}
		return orbAltMeterAction;
	}
	
	private AbstractAction getOrbAltKiloAction() {
		if(orbAltKiloAction == null) {
			orbAltKiloAction = new AbstractAction("Kilometer", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -5749079440738610369L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = true;
					panel.orbAltMeterRadio.setSelected(false);
					panel.orbAltKiloRadio.setSelected(true);
				}
			};
		}
		return orbAltKiloAction;
	}
	
	private AbstractAction getOrbCalcAction() {
		if(orbCalcAction == null) {
			orbCalcAction = new AbstractAction("Calculate", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 4147532202976542388L;

				public void actionPerformed(ActionEvent evt) {
					doCalculate(panel);
				}

				private void doCalculate(CircularOrbitalCalculatorPanel panel) {
					// TODO Auto-generated method stub
					try {
						double altitude = Double.parseDouble(panel.orbAltField.getText());
						if (panel.kilometer) { 
							altitude *= 1000d;
						}
						CircularOrbit cirOrb = new CircularOrbit(altitude, panel.frame.body);
						panel.alt = altitude;
						panel.orbVelOut.setText(Constants.formatVel(cirOrb.getVel()));
						panel.orbPerOut.setText(Constants.formatPer(cirOrb.getPer()));
						panel.escVelOut.setText(Constants.formatVel(cirOrb.getEscVel()));
					} catch (NumberFormatException e) {
						
					}
				}
			};
		}
		return orbCalcAction;
	}
	
	private JButton getShowOrbitButton() {
		if(showOrbitButton == null) {
			showOrbitButton = new JButton();
			showOrbitButton.setText("Show Orbit");
			showOrbitButton.setPreferredSize(new java.awt.Dimension(169, 29));
			showOrbitButton.setAction(getShowOrbitAction());
		}
		return showOrbitButton;
	}
	
	private AbstractAction getShowOrbitAction() {
		if(showOrbitAction == null) {
			showOrbitAction = new AbstractAction("Show Orbit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 6732813570592548674L;

				public void actionPerformed(ActionEvent evt) {
					panel.frame.setOrbitDisplay(panel.alt / 1000d, panel.alt / 1000d, 0, false, false);
				}
			};
		}
		return showOrbitAction;
	}
	
	private JComboBox getJComboBox1() {
		if(celestrialBodySelector == null) {
			ComboBoxModel jComboBox1Model = 
				new DefaultComboBoxModel(CelestrialBody.values());
			celestrialBodySelector = new JComboBox();
			celestrialBodySelector.setModel(jComboBox1Model);
			celestrialBodySelector.setPreferredSize(new java.awt.Dimension(154, 30));
			celestrialBodySelector.setAction(getCelestrialBodyAction());
		}
		return celestrialBodySelector;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("over");
			jLabel5.setPreferredSize(new java.awt.Dimension(37, 15));
		}
		return jLabel5;
	}
	
	private AbstractAction getCelestrialBodyAction() {
		if(celestrialBodyAction == null) {
			celestrialBodyAction = new AbstractAction("", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8368840134494145941L;

				public void actionPerformed(ActionEvent evt) {
					JComboBox cb = (JComboBox)evt.getSource();
				    CelestrialBody body = (CelestrialBody)cb.getSelectedItem();
				    panel.frame.body = body;
				}
			};
		}
		return celestrialBodyAction;
	}

}
