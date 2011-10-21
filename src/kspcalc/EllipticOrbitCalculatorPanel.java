package kspcalc;

import com.cloudgarden.layout.*;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import javax.swing.*;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;
import kspcal.utils.EllipticOrbitCalcType;
import kspcalc.math.EllipticOrbit;


/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class EllipticOrbitCalculatorPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6255829529415243617L;
	private JRadioButton perAltApoAltRadio;
	private JRadioButton perVelPerAltRadio;
	private JTextField secondValueField;
	private AbstractAction doCalculateAction;
	private AbstractAction valueKiloAction;
	private AbstractAction valueMeterAction;
	private AbstractAction apoAltApoVelAction;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private AbstractAction perVelPerAltAction;
	private AbstractAction perVelApoVelAction;
	private AbstractAction perAltApoAltAction;
	private JLabel orbPerOut;
	private JLabel apoVelOut;
	private JLabel apoAltOut;
	private JLabel perVelOut;
	private JLabel perAltOut;
	private JLabel jLabel6;
	private JLabel jLabel2;
	private JButton doCalculateButton;
	private JRadioButton valueKiloRadio;
	private JRadioButton valueMeterRadio;
	private JLabel secondValueLabel;
	private JTextField firstValueField;
	private JLabel firstValueLabel;
	private JRadioButton apoAltApoVelRadio;
	private JRadioButton perVelApoVelRadio;
	private JLabel jLabel1;

	private EllipticOrbitCalculatorPanel panel;
	private AbstractAction celeBodyAction;
	private JLabel jLabel11;
	private JComboBox celeBodyBox;
	private JLabel jLabel10;
	private AbstractAction closeAction1;
	private JButton closeButton;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JDialog NotifyWindow;
	private AbstractAction showOrbitAction;
	private JButton showOrbitButton;
	private JLabel eOut;
	private JLabel jLabel7;
	private EllipticOrbitCalcType inputType;
	private boolean kilometer;
	private Calculator frame;
	private double apo, peri;

	public EllipticOrbitCalculatorPanel(Calculator frame) {
		super();
		initGUI();
		this.kilometer = false;
		this.panel = this;
		this.frame = frame;
		this.inputType = EllipticOrbitCalcType.PERALT_APOALT;
	}

	private void initGUI() {
		try {
			this.setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(500, 400));
			{
				orbPerOut = new JLabel();
				this.add(orbPerOut, new AnchorConstraint(931,613,981,371,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				orbPerOut.setText("0 minutes");
				orbPerOut.setBounds(148, 279, 222, 15);
			}
			{
				apoVelOut = new JLabel();
				this.add(apoVelOut, new AnchorConstraint(861,613,911,371,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				apoVelOut.setText("0.0 m/s");
				apoVelOut.setBounds(148, 258, 125, 15);
			}
			{
				apoAltOut = new JLabel();
				this.add(apoAltOut, new AnchorConstraint(791,613,841,371,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				apoAltOut.setText("0 meter");
				apoAltOut.setBounds(148, 237, 125, 15);
			}
			{
				perVelOut = new JLabel();
				this.add(perVelOut, new AnchorConstraint(721,613,771,371,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				perVelOut.setText("0.0 m/s");
				perVelOut.setBounds(148, 216, 125, 15);
			}
			{
				perAltOut = new JLabel();
				this.add(perAltOut, new AnchorConstraint(651,613,701,371,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				perAltOut.setText("0 meter");
				perAltOut.setBounds(148, 195, 125, 15);
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6, new AnchorConstraint(931,341,981,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jLabel6.setText("Orbital Period:");
				jLabel6.setPreferredSize(new java.awt.Dimension(124, 15));
				jLabel6.setBounds(12, 279, 124, 15);
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5, new AnchorConstraint(861,291,911,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jLabel5.setText("Apogee Velocity:");
				jLabel5.setBounds(12, 258, 104, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4, new AnchorConstraint(791,341,841,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jLabel4.setText("Apogee Altitude:");
				jLabel4.setPreferredSize(new java.awt.Dimension(124, 15));
				jLabel4.setBounds(12, 237, 124, 15);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3, new AnchorConstraint(721,341,771,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jLabel3.setText("Perigee Velocity:");
				jLabel3.setPreferredSize(new java.awt.Dimension(124, 15));
				jLabel3.setBounds(12, 216, 124, 15);
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(651,341,701,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("Perigee Altitude:");
				jLabel2.setPreferredSize(new java.awt.Dimension(124, 15));
				jLabel2.setBounds(12, 195, 124, 15);
			}
			{
				doCalculateButton = new JButton();
				this.add(doCalculateButton, new AnchorConstraint(555,856,628,613,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				doCalculateButton.setText("Calculate");
				doCalculateButton.setAction(getDoCalculateAction());
				doCalculateButton.setBounds(273, 166, 97, 22);
			}
			{
				valueKiloRadio = new JRadioButton();
				this.add(valueKiloRadio, new AnchorConstraint(558,601,621,291,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				valueKiloRadio.setText("Kilometer");
				valueKiloRadio
						.setPreferredSize(new java.awt.Dimension(124, 19));
				valueKiloRadio.setAction(getValueKiloAction());
				valueKiloRadio.setBounds(116, 167, 124, 19);
			}
			{
				valueMeterRadio = new JRadioButton();
				this.add(valueMeterRadio, new AnchorConstraint(558,291,621,61,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				valueMeterRadio.setText("Meter");
				valueMeterRadio
						.setPreferredSize(new java.awt.Dimension(92, 19));
				valueMeterRadio.setAction(getValueMeterAction());
				valueMeterRadio.setSelected(true);
				valueMeterRadio.setBounds(24, 167, 92, 19);
			}
			{
				secondValueField = new JTextField();
				this.add(secondValueField, new AnchorConstraint(465,886,538,473,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				secondValueField.setPreferredSize(new java.awt.Dimension(165,
						22));
				secondValueField.setBounds(189, 139, 165, 22);
			}
			{
				secondValueLabel = new JLabel();
				this.add(secondValueLabel, new AnchorConstraint(418,733,468,473,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				secondValueLabel.setText("Apogee Altitude:");
				secondValueLabel.setBounds(189, 125, 104, 15);
			}
			{
				firstValueField = new JTextField();
				this.add(firstValueField, new AnchorConstraint(465,443,538,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				firstValueField
						.setPreferredSize(new java.awt.Dimension(165, 22));
				firstValueField.setBounds(12, 139, 165, 22);
			}
			{
				firstValueLabel = new JLabel();
				this.add(firstValueLabel, new AnchorConstraint(418,291,468,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				firstValueLabel.setText("Perigee Altitude:");
				firstValueLabel.setBounds(12, 125, 104, 15);
			}
			{
				apoAltApoVelRadio = new JRadioButton();
				this.add(apoAltApoVelRadio, new AnchorConstraint(325,771,388,61,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				apoAltApoVelRadio
						.setText("Apogee Altitude and Apogee Velocity");
				apoAltApoVelRadio.setPreferredSize(new java.awt.Dimension(284,
						19));
				apoAltApoVelRadio.setAction(getApoAltApoVelAction());
				apoAltApoVelRadio.setBounds(24, 97, 284, 19);
			}
			{
				perVelPerAltRadio = new JRadioButton();
				this.add(perVelPerAltRadio, new AnchorConstraint(251,771,315,61,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				perVelPerAltRadio
						.setText("Perigee Altitude and Perigee Velocity");
				perVelPerAltRadio.setPreferredSize(new java.awt.Dimension(284,
						19));
				perVelPerAltRadio.setAction(getPerVelPerAltAction());
				perVelPerAltRadio.setBounds(24, 75, 284, 19);
			}
			{
				perVelApoVelRadio = new JRadioButton();
				this.add(perVelApoVelRadio, new AnchorConstraint(178,771,241,61,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				perVelApoVelRadio
						.setText("Perigee Velocity and Apogee Velocity");
				perVelApoVelRadio.setPreferredSize(new java.awt.Dimension(284,
						19));
				perVelApoVelRadio.setEnabled(false);
				perVelApoVelRadio.setBounds(24, 53, 284, 19);
				// perVelApoVelRadio.setAction(getPerVelApoVelAction());
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(41,236,91,31,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Input Values:");
				jLabel1.setBounds(12, 12, 82, 15);
			}
			{
				perAltApoAltRadio = new JRadioButton();
				this.add(perAltApoAltRadio, new AnchorConstraint(105,771,168,61,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL,AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel7());
				this.add(getEOut());
				this.add(getShowOrbitButton());
				this.add(getCeleBodyBox());
				this.add(getJLabel11());
				perAltApoAltRadio
						.setText("Perigee Altitude and Apogee Altitude");
				perAltApoAltRadio.setPreferredSize(new java.awt.Dimension(284,
						19));
				perAltApoAltRadio.setAction(getPerAltApoAltAction());
				perAltApoAltRadio.setSelected(true);
				perAltApoAltRadio.setBounds(24, 31, 284, 19);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AbstractAction getPerAltApoAltAction() {
		if (perAltApoAltAction == null) {
			perAltApoAltAction = new AbstractAction(
					"Perigee Altitude and Apogee Altitude", null) {
				/**
						 * 
						 */
						private static final long serialVersionUID = 1605874413640858383L;

				public void actionPerformed(ActionEvent evt) {
					panel.inputType = EllipticOrbitCalcType.PERALT_APOALT;
					panel.perAltApoAltRadio.setSelected(true);
					panel.perVelApoVelRadio.setSelected(false);
					panel.perVelPerAltRadio.setSelected(false);
					panel.apoAltApoVelRadio.setSelected(false);
					panel.firstValueLabel.setText("Perigee Altitude:");
					panel.secondValueLabel.setText("Apogee Altitude:");
				}
			};
		}
		return perAltApoAltAction;
	}

	@SuppressWarnings("unused")
	private AbstractAction getPerVelApoVelAction() {
		if (perVelApoVelAction == null) {
			perVelApoVelAction = new AbstractAction(
					"Perigee Velocity and Apogee Velocity", null) {
				/**
						 * 
						 */
						private static final long serialVersionUID = 3634027877217505960L;

				public void actionPerformed(ActionEvent evt) {
					panel.inputType = EllipticOrbitCalcType.PERVEL_APOVEL;
					panel.perAltApoAltRadio.setSelected(false);
					panel.perVelApoVelRadio.setSelected(true);
					panel.perVelPerAltRadio.setSelected(false);
					panel.apoAltApoVelRadio.setSelected(false);
					panel.firstValueLabel.setText("Perigee Velocity:");
					panel.secondValueLabel.setText("Apogee Velocity:");
				}
			};
		}
		return perVelApoVelAction;
	}

	private AbstractAction getPerVelPerAltAction() {
		if (perVelPerAltAction == null) {
			perVelPerAltAction = new AbstractAction(
					"Perigee Altitude and Perigee Velocity", null) {
				/**
						 * 
						 */
						private static final long serialVersionUID = 6384382425413899994L;

				public void actionPerformed(ActionEvent evt) {
					panel.inputType = EllipticOrbitCalcType.PERALT_PERVEL;
					panel.perAltApoAltRadio.setSelected(false);
					panel.perVelApoVelRadio.setSelected(false);
					panel.perVelPerAltRadio.setSelected(true);
					panel.apoAltApoVelRadio.setSelected(false);
					panel.firstValueLabel.setText("Perigee Altitude:");
					panel.secondValueLabel.setText("Perigee Velocity:");
				}
			};
		}
		return perVelPerAltAction;
	}

	private AbstractAction getApoAltApoVelAction() {
		if (apoAltApoVelAction == null) {
			apoAltApoVelAction = new AbstractAction(
					"Apogee Altitude and Apogee Velocity", null) {
				/**
						 * 
						 */
						private static final long serialVersionUID = -4753274785233976560L;

				public void actionPerformed(ActionEvent evt) {
					panel.inputType = EllipticOrbitCalcType.APOALT_APOVEL;
					panel.perAltApoAltRadio.setSelected(false);
					panel.perVelApoVelRadio.setSelected(false);
					panel.perVelPerAltRadio.setSelected(false);
					panel.apoAltApoVelRadio.setSelected(true);
					panel.firstValueLabel.setText("Apogee Altitude:");
					panel.secondValueLabel.setText("Apogee Velocity:");
				}
			};
		}
		return apoAltApoVelAction;
	}

	private AbstractAction getValueMeterAction() {
		if (valueMeterAction == null) {
			valueMeterAction = new AbstractAction("Meter", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 6773316082003415359L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = false;
					panel.valueMeterRadio.setSelected(!kilometer);
					panel.valueKiloRadio.setSelected(kilometer);
				}
			};
		}
		return valueMeterAction;
	}

	private AbstractAction getValueKiloAction() {
		if (valueKiloAction == null) {
			valueKiloAction = new AbstractAction("Kilometer", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 6258549315317747903L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = true;
					panel.valueMeterRadio.setSelected(!kilometer);
					panel.valueKiloRadio.setSelected(kilometer);
				}
			};
		}
		return valueKiloAction;
	}

	private AbstractAction getDoCalculateAction() {
		if (doCalculateAction == null) {
			doCalculateAction = new AbstractAction("Calculate", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1731613934812916868L;

				public void actionPerformed(ActionEvent evt) {
					doMath(panel);
				}
				
				private void doMath(EllipticOrbitCalculatorPanel panel) {
					double firstValue = Double.parseDouble(panel.firstValueField.getText());
					double secondValue = Double.parseDouble(panel.secondValueField.getText());
					if (panel.kilometer) {
						switch (panel.inputType) {
						case PERALT_APOALT:
							firstValue *= 1000d;
							secondValue *= 1000d;
							break;
						case PERALT_PERVEL:
						case APOALT_APOVEL:
							firstValue *= 1000d;
							break;
						default:
							break;
						}
					}
					EllipticOrbit elliptic = new EllipticOrbit(firstValue, secondValue, panel.inputType, frame.body);
					if (elliptic.isElliptic()) {
						double perAlt = elliptic.getPerAlt() - frame.body.getRadius();
						double apoAlt = elliptic.getApoAlt() - frame.body.getRadius();
						String perAltOut = Constants.formatMeter(perAlt);
						String apoAltOut = Constants.formatMeter(apoAlt);
						panel.apo = apoAlt;
						panel.peri = perAlt;
						if (kilometer) {
							perAlt /= 1000d;
							apoAlt /= 1000d;
							perAltOut = Constants.formatKilo(perAlt);
							apoAltOut = Constants.formatKilo(apoAlt);
						}
						panel.perAltOut.setText(perAltOut);
						panel.apoAltOut.setText(apoAltOut);
						panel.perVelOut.setText(Constants.formatVel(elliptic.getPerVel()));
						panel.apoVelOut.setText(Constants.formatVel(elliptic.getApoVel()));
						panel.orbPerOut.setText(Constants.formatPer(elliptic.getPeriod()));
						panel.eOut.setText(Constants.formatDouble(elliptic.getE()));
					} else if (elliptic.isHyperbolic()) {
						showNotifyWindow(elliptic, "hyperbolic");
					} else if (elliptic.isParabolic()) {
						showNotifyWindow(elliptic, "parabolic");
					} else if (elliptic.isCircular()) {
						showNotifyWindow(elliptic, "circular");
					}
				}

				private void showNotifyWindow(EllipticOrbit elliptic, String type) {
					getNotifyWindow().setVisible(true);
					jLabel9.setText(type + " with an eccentricity of:");
					jLabel10.setText(Constants.formatDouble(elliptic.getE()));
				}
			};
		}
		return doCalculateAction;
	}
	
	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Orbital Eccentricity:");
			jLabel7.setBounds(12, 300, 136, 15);
		}
		return jLabel7;
	}
	
	private JLabel getEOut() {
		if(eOut == null) {
			eOut = new JLabel();
			eOut.setText("0");
			eOut.setBounds(148, 300, 44, 15);
		}
		return eOut;
	}
	
	private JButton getShowOrbitButton() {
		if(showOrbitButton == null) {
			showOrbitButton = new JButton();
			showOrbitButton.setText("Show Orbit");
			showOrbitButton.setBounds(273, 199, 97, 22);
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
				private static final long serialVersionUID = -8143578416492442782L;

				public void actionPerformed(ActionEvent evt) {
					panel.frame.setOrbitDisplay(panel.apo / 1000d, panel.peri / 1000d, 0, false, false);
				}
			};
		}
		return showOrbitAction;
	}
	
	private JDialog getNotifyWindow() {
		if(NotifyWindow == null) {
			NotifyWindow = new JDialog();
			NotifyWindow.getContentPane().setLayout(null);
			NotifyWindow.setPreferredSize(new java.awt.Dimension(271, 138));
			NotifyWindow.getContentPane().add(getJLabel8());
			NotifyWindow.getContentPane().add(getJLabel9());
			NotifyWindow.getContentPane().add(getCloseButton());
			NotifyWindow.getContentPane().add(getJLabel10());
			NotifyWindow.setLocationRelativeTo(null);
			NotifyWindow.setSize(271, 138);
		}
		return NotifyWindow;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("The Trajectory you have entered is");
			jLabel8.setBounds(12, 12, 245, 15);
		}
		return jLabel8;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("hyperbolic with an eccentricity of:");
			jLabel9.setBounds(12, 33, 233, 15);
		}
		return jLabel9;
	}
	
	private JButton getCloseButton() {
		if(closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("Close");
			closeButton.setBounds(179, 79, 67, 22);
			closeButton.setAction(getCloseAction1());
		}
		return closeButton;
	}
	
	private AbstractAction getCloseAction1() {
		if(closeAction1 == null) {
			closeAction1 = new AbstractAction("Close", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent evt) {
					getNotifyWindow().setVisible(false);
				}
			};
		}
		return closeAction1;
	}
	
	private JLabel getJLabel10() {
		if(jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setText("0");
			jLabel10.setBounds(12, 54, 209, 15);
		}
		return jLabel10;
	}
	
	private JComboBox getCeleBodyBox() {
		if(celeBodyBox == null) {
			ComboBoxModel celeBodyBoxModel = 
				new DefaultComboBoxModel(CelestrialBody.values());
			celeBodyBox = new JComboBox();
			celeBodyBox.setModel(celeBodyBoxModel);
			celeBodyBox.setBounds(325, 95, 133, 21);
			celeBodyBox.setAction(getCeleBodyAction());
		}
		return celeBodyBox;
	}
	
	private JLabel getJLabel11() {
		if(jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setText("over");
			jLabel11.setBounds(325, 75, 37, 15);
		}
		return jLabel11;
	}
	
	private AbstractAction getCeleBodyAction() {
		if(celeBodyAction == null) {
			celeBodyAction = new AbstractAction("", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1808855715905633293L;

				public void actionPerformed(ActionEvent evt) {
					JComboBox cb = (JComboBox)evt.getSource();
				    CelestrialBody body = (CelestrialBody)cb.getSelectedItem();
				    panel.frame.body = body;
				}
			};
		}
		return celeBodyAction;
	}

}
