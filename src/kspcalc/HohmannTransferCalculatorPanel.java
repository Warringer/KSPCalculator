package kspcalc;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;


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
public class HohmannTransferCalculatorPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2591503225964357765L;
	private JLabel jLabel2;
	private AbstractAction hohAltMeterAction;
	private AbstractAction hohAltKiloAction;
	private JRadioButton hohAltKiloRadio;
	private JRadioButton hohAltMeterRadio;
	private JTextField hohHiOrbAltField;
	private JLabel jLabel1;
	private JTextField hohLoOrbAltField;
	private JLabel hohTransFinalVel;
	private AbstractAction showOrbitAction;
	private JButton showOrbitButton;
	private JLabel hohTransInitVel;
	private JLabel hohTransTimeOut;
	private JLabel jLabel8;
	private JLabel hohTransPerOut;
	private JLabel jLabel7;
	private JLabel hohDVSumOut;
	private JLabel jLabel6;
	private JLabel hohTargetInjDVOut;
	private JLabel hohTransInjDVOut;
	private JLabel jLabel5;
	private AbstractAction hohCalcAction;
	private JButton hohCalcButton;
	private JLabel hohTargetInjVelOut;
	private JLabel hohTransInjVelOut;
	private JLabel jLabel4;
	private AbstractAction hohHiLoTransAction;
	private AbstractAction hohLoHiTransAction;
	private JRadioButton hohHiLoTransRadio;
	private JRadioButton hohLoHiTransRadio;
	private JLabel jLabel3;
	
	private HohmannTransferCalculatorPanel panel;	// This Panel!
	private AbstractAction celeBodyAction;
	private JLabel jLabel9;
	private JComboBox celeBodyBox;
	private Calculator frame;	// Display Frame
	private boolean kilometer;	// Altitude in Kilometers?
	private boolean upwards;	// Transfer Orbit direction?
	private double apo, peri;	// Orbit Parameters 
	
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
		
	public HohmannTransferCalculatorPanel(Calculator frame) {
		super();
		this.panel = this;
		this.kilometer = false;
		this.upwards = true;
		this.frame = frame;
		this.initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			this.setPreferredSize(new java.awt.Dimension(500, 400));
			{
				hohAltKiloRadio = new JRadioButton();
				this.add(getJLabel9(), new AnchorConstraint(111, 573, 148, 497, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getCeleBodyBox(), new AnchorConstraint(91, 891, 166, 597, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getShowOrbitButton(), new AnchorConstraint(325, 776, 398, 533, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTransFinalVel(), new AnchorConstraint(728, 971, 775, 668, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTransInitVel(), new AnchorConstraint(581, 348, 631, 58, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTransTimeOut(), new AnchorConstraint(921, 958, 971, 551, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel8(), new AnchorConstraint(921, 536, 971, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTransPerOut(), new AnchorConstraint(871, 958, 921, 551, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel7(), new AnchorConstraint(875, 448, 925, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohDVSumOut(), new AnchorConstraint(825, 958, 875, 718, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel6(), new AnchorConstraint(825, 718, 875, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTargetInjDVOut(), new AnchorConstraint(728, 631, 778, 371, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTransInjDVOut(), new AnchorConstraint(581, 623, 631, 363, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohCalcButton(), new AnchorConstraint(235, 776, 308, 533, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTargetInjVelOut(), new AnchorConstraint(728, 363, 778, 61, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel5(), new AnchorConstraint(670, 552, 718, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohTransInjVelOut(), new AnchorConstraint(581, 971, 631, 668, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel4(), new AnchorConstraint(515, 581, 565, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohHiLoTransRadio(), new AnchorConstraint(451, 703, 515, 393, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getHohLoHiTransRadio(), new AnchorConstraint(451, 363, 515, 53, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(getJLabel3(), new AnchorConstraint(401, 363, 451, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				this.add(hohAltKiloRadio, new AnchorConstraint(328, 481, 391, 226, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				hohAltKiloRadio.setText("Kilometer");
				hohAltKiloRadio.setSelected(kilometer);
				hohAltKiloRadio.setPreferredSize(new java.awt.Dimension(102, 19));
				hohAltKiloRadio.setAction(getHohAltKiloAction());
			}
			{
				hohAltMeterRadio = new JRadioButton();
				this.add(hohAltMeterRadio, new AnchorConstraint(328, 228, 391, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				hohAltMeterRadio.setText("Meter");
				hohAltMeterRadio.setSelected(!kilometer);
				hohAltMeterRadio.setPreferredSize(new java.awt.Dimension(79, 19));
				hohAltMeterRadio.setAction(getHohAltMeterAction());
			}
			{
				hohHiOrbAltField = new JTextField();
				this.add(hohHiOrbAltField, new AnchorConstraint(235, 488, 308, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				hohHiOrbAltField.setPreferredSize(new java.awt.Dimension(183, 22));
			}
			{
				jLabel1 = new JLabel();
				this.add(jLabel1, new AnchorConstraint(185, 228, 235, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel1.setText("Higher Orbit:");
			}
			{
				hohLoOrbAltField = new JTextField();
				this.add(hohLoOrbAltField, new AnchorConstraint(91, 488, 165, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				hohLoOrbAltField.setPreferredSize(new java.awt.Dimension(183, 22));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2, new AnchorConstraint(41, 233, 91, 31, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jLabel2.setText("Lower Orbit:");
				jLabel2.setPreferredSize(new java.awt.Dimension(81, 15));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getHohAltMeterAction() {
		if(hohAltMeterAction == null) {
			hohAltMeterAction = new AbstractAction("Meter", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -68933737118367719L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = false;
					panel.hohAltMeterRadio.setSelected(true);
					panel.hohAltKiloRadio.setSelected(false);
				}
			};
		}
		return hohAltMeterAction;
	}
	
	private AbstractAction getHohAltKiloAction() {
		if(hohAltKiloAction == null) {
			hohAltKiloAction = new AbstractAction("Kilometer", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4356401245683323302L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = true;
					panel.hohAltMeterRadio.setSelected(false);
					panel.hohAltKiloRadio.setSelected(true);
				}
			};
		}
		return hohAltKiloAction;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Transfer Direction:");
			jLabel3.setPreferredSize(new java.awt.Dimension(133, 15));
		}
		return jLabel3;
	}
	
	private JRadioButton getHohLoHiTransRadio() {
		if(hohLoHiTransRadio == null) {
			hohLoHiTransRadio = new JRadioButton();
			hohLoHiTransRadio.setText("Low to High Orbit");
			hohLoHiTransRadio.setSelected(upwards);
			hohLoHiTransRadio.setAction(getHohLoHiTransAction());
			hohLoHiTransRadio.setPreferredSize(new java.awt.Dimension(124, 19));
		}
		return hohLoHiTransRadio;
	}
	
	private JRadioButton getHohHiLoTransRadio() {
		if(hohHiLoTransRadio == null) {
			hohHiLoTransRadio = new JRadioButton();
			hohHiLoTransRadio.setText("High to Low Orbit");
			hohHiLoTransRadio.setSelected(!upwards);
			hohHiLoTransRadio.setAction(getHohHiLoTransAction());
			hohHiLoTransRadio.setPreferredSize(new java.awt.Dimension(124, 19));
		}
		return hohHiLoTransRadio;
	}
	
	private AbstractAction getHohLoHiTransAction() {
		if(hohLoHiTransAction == null) {
			hohLoHiTransAction = new AbstractAction("Low to High Orbit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 9199185198005113008L;

				public void actionPerformed(ActionEvent evt) {
					upwards = true;
					panel.hohLoHiTransRadio.setSelected(true);
					panel.hohHiLoTransRadio.setSelected(false);
				}
			};
		}
		return hohLoHiTransAction;
	}
	
	private AbstractAction getHohHiLoTransAction() {
		if(hohHiLoTransAction == null) {
			hohHiLoTransAction = new AbstractAction("High to Low Orbit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -2761211921937924229L;

				public void actionPerformed(ActionEvent evt) {
					upwards = false;
					panel.hohLoHiTransRadio.setSelected(false);
					panel.hohHiLoTransRadio.setSelected(true);
				}
			};
		}
		return hohHiLoTransAction;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Velocity for Transfer Orbit Injection:");
			jLabel4.setPreferredSize(new java.awt.Dimension(220, 15));
		}
		return jLabel4;
	}
	
	private JLabel getHohTransInjVelOut() {
		if(hohTransInjVelOut == null) {
			hohTransInjVelOut = new JLabel();
			hohTransInjVelOut.setText("Final: 0.0 m/s");
			hohTransInjVelOut.setPreferredSize(new java.awt.Dimension(121, 15));
		}
		return hohTransInjVelOut;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Velocity for Target Orbit Injection:");
			jLabel5.setPreferredSize(new java.awt.Dimension(209, 16));
		}
		return jLabel5;
	}
	
	private JLabel getHohTargetInjVelOut() {
		if(hohTargetInjVelOut == null) {
			hohTargetInjVelOut = new JLabel();
			hohTargetInjVelOut.setText("Initial: 0.0 m/s");
			hohTargetInjVelOut.setPreferredSize(new java.awt.Dimension(121, 15));
		}
		return hohTargetInjVelOut;
	}
	
	private JButton getHohCalcButton() {
		if(hohCalcButton == null) {
			hohCalcButton = new JButton();
			hohCalcButton.setText("Calculate");
			hohCalcButton.setPreferredSize(new java.awt.Dimension(97, 22));
			hohCalcButton.setAction(getHohCalcAction());
		}
		return hohCalcButton;
	}
	
	private AbstractAction getHohCalcAction() {
		if(hohCalcAction == null) {
			hohCalcAction = new AbstractAction("Calcuate", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 3255363562930262390L;

				public void actionPerformed(ActionEvent evt) {
					doCalculate(panel);
				}
				
				private void doCalculate(HohmannTransferCalculatorPanel panel) {
					// TODO Auto-generated method stub
					try {
						double loAltitude = Double.parseDouble(panel.hohLoOrbAltField.getText());
						double hiAltitude = Double.parseDouble(panel.hohHiOrbAltField.getText());
						if (panel.kilometer) { 
							loAltitude *= 1000d;
							hiAltitude *= 1000d;
						}
						panel.apo = hiAltitude;
						panel.peri = loAltitude;
						HohmannTransferOrbit hohmann = new HohmannTransferOrbit(loAltitude, hiAltitude, panel.upwards, frame.body);
						panel.hohTransInjVelOut.setText("Final: " + Constants.formatVel(hohmann.getHohVelInjection()));
						panel.hohTargetInjVelOut.setText("Initial: " + Constants.formatVel(hohmann.getHohVelExit()));
						panel.hohTransInjDVOut.setText("\u0394v: " + Constants.formatVel(hohmann.getDVInit()));
						panel.hohTargetInjDVOut.setText("\u0394v: " + Constants.formatVel(hohmann.getDVExit()));
						panel.hohDVSumOut.setText(Constants.formatVel((hohmann.getDVInit() + hohmann.getDVExit())));
						panel.hohTransPerOut.setText(Constants.formatPer((hohmann.getPeriod())));
						panel.hohTransTimeOut.setText(Constants.formatPer(hohmann.getHalfPeriod()));
						panel.hohTransInitVel.setText("Initial: " + Constants.formatVel(hohmann.getInitVel()));
						panel.hohTransFinalVel.setText("Final: " + Constants.formatVel(hohmann.getFinalVel()));
					} catch (NumberFormatException e) {
						
					}
				}
			};
		}
		return hohCalcAction;
	}
	
	private JLabel getHohTransInjDVOut() {
		if(hohTransInjDVOut == null) {
			hohTransInjDVOut = new JLabel();
			hohTransInjDVOut.setText("\u0394v: 0.0 m/s");
			hohTransInjDVOut.setPreferredSize(new java.awt.Dimension(104, 15));
		}
		return hohTransInjDVOut;
	}
	
	private JLabel getHohTargetInjDVOut() {
		if(hohTargetInjDVOut == null) {
			hohTargetInjDVOut = new JLabel();
			hohTargetInjDVOut.setText("\u0394v: 0.0 m/s");
			hohTargetInjDVOut.setPreferredSize(new java.awt.Dimension(104, 15));
		}
		return hohTargetInjDVOut;
	}
	
	private JLabel getJLabel6() {
		if(jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("\u0394v needed for Transfer Orbit Manouver:");
		}
		return jLabel6;
	}
	
	private JLabel getHohDVSumOut() {
		if(hohDVSumOut == null) {
			hohDVSumOut = new JLabel();
			hohDVSumOut.setText("0.0 m/s");
			hohDVSumOut.setPreferredSize(new java.awt.Dimension(96, 15));
		}
		return hohDVSumOut;
	}
	
	private JLabel getJLabel7() {
		if(jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Transfer Orbit Period:");
			jLabel7.setPreferredSize(new java.awt.Dimension(167, 15));
		}
		return jLabel7;
	}
	
	private JLabel getHohTransPerOut() {
		if(hohTransPerOut == null) {
			hohTransPerOut = new JLabel();
			hohTransPerOut.setText("0 minutes");
			hohTransPerOut.setPreferredSize(new java.awt.Dimension(163, 15));
		}
		return hohTransPerOut;
	}
	
	private JLabel getJLabel8() {
		if(jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setText("Hohmann Transfer Orbit Time:");
			jLabel8.setPreferredSize(new java.awt.Dimension(202, 15));
		}
		return jLabel8;
	}
	
	private JLabel getHohTransTimeOut() {
		if(hohTransTimeOut == null) {
			hohTransTimeOut = new JLabel();
			hohTransTimeOut.setText("0 minutes");
			hohTransTimeOut.setPreferredSize(new java.awt.Dimension(163, 15));
		}
		return hohTransTimeOut;
	}
	
	private JLabel getHohTransInitVel() {
		if(hohTransInitVel == null) {
			hohTransInitVel = new JLabel();
			hohTransInitVel.setText("Initial: 0.0 m/s");
			hohTransInitVel.setPreferredSize(new java.awt.Dimension(116, 15));
		}
		return hohTransInitVel;
	}
	
	private JLabel getHohTransFinalVel() {
		if(hohTransFinalVel == null) {
			hohTransFinalVel = new JLabel();
			hohTransFinalVel.setText("Final: 0.0m/s");
			hohTransFinalVel.setPreferredSize(new java.awt.Dimension(121, 14));
		}
		return hohTransFinalVel;
	}
	
	private JButton getShowOrbitButton() {
		if(showOrbitButton == null) {
			showOrbitButton = new JButton();
			showOrbitButton.setText("Show Orbits");
			showOrbitButton.setPreferredSize(new java.awt.Dimension(97, 22));
			showOrbitButton.setAction(getShowOrbitAction());
		}
		return showOrbitButton;
	}
	
	private AbstractAction getShowOrbitAction() {
		if(showOrbitAction == null) {
			showOrbitAction = new AbstractAction("Show Orbits", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8829065951929157204L;

				public void actionPerformed(ActionEvent evt) {
					panel.frame.setOrbitDisplay(panel.apo / 1000d, panel.peri / 1000d, 0, true, upwards);
				}
			};
		}
		return showOrbitAction;
	}
	
	private JComboBox getCeleBodyBox() {
		if(celeBodyBox == null) {
			ComboBoxModel celeBodyBoxModel = 
				new DefaultComboBoxModel(CelestrialBody.values());
			celeBodyBox = new JComboBox();
			celeBodyBox.setModel(celeBodyBoxModel);
			celeBodyBox.setPreferredSize(new java.awt.Dimension(147, 30));
			celeBodyBox.setAction(getCeleBodyAction());
		}
		return celeBodyBox;
	}
	
	private JLabel getJLabel9() {
		if(jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setText("over");
			jLabel9.setPreferredSize(new java.awt.Dimension(38, 15));
		}
		return jLabel9;
	}
	
	private AbstractAction getCeleBodyAction() {
		if(celeBodyAction == null) {
			celeBodyAction = new AbstractAction("", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 3685535265492283506L;

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
