package kspcalc;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcal.utils.CelestrialBody;
import kspcal.utils.Constants;
import kspcalc.math.BiEllipticTransferOrbit;

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
public class BiEllipticTransferCalculatorPanel extends javax.swing.JPanel {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1740557111198085996L;
	private JTextField lowOrbitField;
	private JTextField pointBField;
	private JTextField highOrbitField;
	private JLabel biInitAfterVelOut;
	private JLabel biInitDVOut;
	private JLabel biInitVelOut;
	private AbstractAction calculateAction;
	private AbstractAction highLowAction;
	private AbstractAction lowHighAction;
	private JRadioButton highLowRadio;
	private JRadioButton lowHighRadio;
	private JRadioButton altKiloRadio;
	private AbstractAction altKiloAction;
	private AbstractAction altMeterAction;
	private JRadioButton altMeterRadio;
	private AbstractAction celeBodyAction;
	private JLabel jLabel1;
	private JComboBox celeBodyBox;
	private AbstractAction showOrbitsAction;
	private JLabel fullTimeOut;
	private JLabel downTimeOut;
	private JLabel upTimeOut;
	private JLabel fullDVOut;
	private JLabel biFinalVelOut;
	private JLabel biFinalDVOut;
	private JLabel biFinalInitVel;
	private JLabel pointBFinalVelOut;
	private JLabel pointBDVOut;
	private JLabel pointBInitVelOut;
	private JButton showOrbitButton;
	private JButton calculateButton;
	
	private boolean kilometer = false;
	private boolean upwards = true;
	private double lowAlt, highAlt, pointBAlt;
	private Calculator frame;

	public BiEllipticTransferCalculatorPanel(Calculator frame) {
		super();
		this.frame = frame;
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(500, 400));
			this.setLayout(null);
			{
				this.addLabel("Lower Orbit", 12, 12, 130, 15);
				this.addLabel("Higher Orbit", 12, 61, 130, 15);
				this.addLabel("Turnover Altitude:", 242, 12, 130, 15);
				this.addLabel("Transfer Direction:", 12, 141, 163, 17);
				this.addLabel("Velocity for Transfer Orbit Injection:", 12, 195, 253, 15);
				this.addLabel("Velocity Change needed at Turnover Point:", 12, 231, 314, 17);
				this.addLabel("Velocity for Target Orbit Injection:", 12, 271, 292, 17);
				this.addLabel("\u0394v needed for Transfer Orbit Maneuver:", 23, 317, 321, 17);
				this.addLabel("Time needed to Turnover Point:", 23, 334, 321, 17);
				this.addLabel("Time needed to Final Orbit Injection:", 23, 351, 321, 17);
				this.addLabel("Time needed for full Transfer Orbit Maneuver:", 23, 368, 321, 17);
			}
			{
				lowOrbitField = new JTextField();
				this.add(lowOrbitField);
				lowOrbitField.setBounds(17, 33, 200, 22);
			}
			{
				highOrbitField = new JTextField();
				this.add(highOrbitField);
				highOrbitField.setBounds(17, 82, 200, 22);
			}
			{
				pointBField = new JTextField();
				this.add(pointBField);
				pointBField.setBounds(248, 33, 200, 22);
			}
			{
				calculateButton = new JButton();
				this.add(calculateButton);
				calculateButton.setText("Calculate");
				calculateButton.setBounds(248, 82, 96, 22);
				calculateButton.setAction(getCalculateAction());
			}
			{
				showOrbitButton = new JButton();
				this.add(showOrbitButton);
				showOrbitButton.setText("Show Orbits");
				showOrbitButton.setBounds(355, 82, 107, 22);
				showOrbitButton.setAction(getShowOrbitsAction());
			}
			{
				altMeterRadio = new JRadioButton();
				this.add(altMeterRadio);
				altMeterRadio.setText("Meter");
				altMeterRadio.setSelected(true);
				altMeterRadio.setBounds(24, 116, 96, 19);
				altMeterRadio.setAction(getAltMeterAction());
			}
			{
				altKiloRadio = new JRadioButton();
				altKiloRadio.setText("Kilometer");
				altKiloRadio.setSelected(false);
				altKiloRadio.setBounds(120, 116, 106, 19);
				altKiloRadio.setAction(getAltKiloAction());
			}
			{
				this.add(altKiloRadio);
				this.add(getLowHighRadio());
				this.add(getHighLowRadio());
				this.add(getBiInitVelOut());
				this.add(getBiInitDVOut());
				this.add(getBiInitAfterVelOut());
				this.add(getPointBInitVelOut());
				this.add(getPointBDVOut());
				this.add(getPointBFinalVelOut());
				this.add(getBiFinalInitVel());
				this.add(getBiFinalDVOut());
				this.add(getBiFinalVelOut());
				this.add(getFullDVOut());
				this.add(getUpTimeOut());
				this.add(getDownTimeOut());
				this.add(getFullTimeOut());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addLabel(String text, int x, int y, int width, int hight) {
		try {
			JLabel jLabel = new JLabel();
			this.add(jLabel);
			this.add(getCeleBodyBox());
			this.add(getJLabel1());
			jLabel.setText(text);
			jLabel.setBounds(x, y, width, hight);
		} catch (NullPointerException e) {}
	}
	
	private AbstractAction getAltMeterAction() {
		if(altMeterAction == null) {
			altMeterAction = new AbstractAction("Meter", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4654409240927814031L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = false;
					altKiloRadio.setSelected(kilometer);
					altMeterRadio.setSelected(!kilometer);
				}
			};
		}
		return altMeterAction;
	}
	
	private AbstractAction getAltKiloAction() {
		if(altKiloAction == null) {
			altKiloAction = new AbstractAction("Kilometer", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -2229293775830493519L;

				public void actionPerformed(ActionEvent evt) {
					kilometer = true;
					altKiloRadio.setSelected(kilometer);
					altMeterRadio.setSelected(!kilometer);
				}
			};
		}
		return altKiloAction;
	}
	
	private JRadioButton getLowHighRadio() {
		if(lowHighRadio == null) {
			lowHighRadio = new JRadioButton();
			lowHighRadio.setText("Low Orbit -> High Orbit");
			lowHighRadio.setBounds(24, 164, 202, 22);
			lowHighRadio.setSelected(true);
			lowHighRadio.setAction(getLowHighAction());
		}
		return lowHighRadio;
	}
	
	private JRadioButton getHighLowRadio() {
		if(highLowRadio == null) {
			highLowRadio = new JRadioButton();
			highLowRadio.setText("High Orbit -> Low Orbit");
			highLowRadio.setBounds(238, 164, 210, 22);
			highLowRadio.setSelected(false);
			highLowRadio.setAction(getHighLowAction());
		}
		return highLowRadio;
	}
	
	private AbstractAction getLowHighAction() {
		if(lowHighAction == null) {
			lowHighAction = new AbstractAction("Low Orbit -> High Orbit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 714186624461904746L;

				public void actionPerformed(ActionEvent evt) {
					upwards = true;
					lowHighRadio.setSelected(upwards);
					highLowRadio.setSelected(!upwards);
				}
			};
		}
		return lowHighAction;
	}
	
	private AbstractAction getHighLowAction() {
		if(highLowAction == null) {
			highLowAction = new AbstractAction("High Orbit -> Low Orbit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 4599662409722695445L;

				public void actionPerformed(ActionEvent evt) {
					upwards = false;
					lowHighRadio.setSelected(upwards);
					highLowRadio.setSelected(!upwards);
				}
			};
		}
		return highLowAction;
	}
	
	private AbstractAction getCalculateAction() {
		if(calculateAction == null) {
			calculateAction = new AbstractAction("Calculate", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 360807102025273896L;

				public void actionPerformed(ActionEvent evt) {
					doMath();
				}
				
				private void doMath() {
					lowAlt = Double.parseDouble(lowOrbitField.getText());
					highAlt = Double.parseDouble(highOrbitField.getText());
					pointBAlt = Double.parseDouble(pointBField.getText());
					if (kilometer) {
						lowAlt *= 1000d;
						highAlt *= 1000d;
						pointBAlt *= 1000d;
					}
					BiEllipticTransferOrbit calc = new BiEllipticTransferOrbit(lowAlt, highAlt, pointBAlt, upwards, frame.body);
					biInitVelOut.setText("Initial: " + Constants.formatVel(calc.getInitVel()));
					biInitDVOut.setText("\u0394v: " + Constants.formatVel(calc.getDvInit()));
					biInitAfterVelOut.setText("Final: " + Constants.formatVel(calc.getInjectionVel()));
					pointBInitVelOut.setText("Initial: " + Constants.formatVel(calc.getVelB()));
					pointBDVOut.setText("\u0394v: " + Constants.formatVel(calc.getDvB()));
					pointBFinalVelOut.setText("Final: " + Constants.formatVel(calc.getVelB() + calc.getDvB()));
					biFinalInitVel.setText("Initial: " + Constants.formatVel(calc.getFinalVel()));
					biFinalDVOut.setText("\u0394v: " + Constants.formatVel(calc.getDvExit()));
					biFinalVelOut.setText("Final: " + Constants.formatVel(calc.getOutVel()));
					fullDVOut.setText(Constants.formatVel(calc.getCombinedDV()));
					upTimeOut.setText(Constants.formatPer(calc.getTimeBegin()));
					downTimeOut.setText(Constants.formatPer(calc.getTimeEnd()));
					fullTimeOut.setText(Constants.formatPer(calc.getPeriod()));
				}
			};
		}
		return calculateAction;
	}
		
	private JLabel getBiInitVelOut() {
		if(biInitVelOut == null) {
			biInitVelOut = new JLabel();
			biInitVelOut.setText("Initial: 0.0 m/s");
			biInitVelOut.setBounds(23, 210, 142, 17);
		}
		return biInitVelOut;
	}
	
	private JLabel getBiInitDVOut() {
		if(biInitDVOut == null) {
			biInitDVOut = new JLabel();
			biInitDVOut.setText("\u0394v: 0.0 m/s");
			biInitDVOut.setBounds(181, 210, 128, 17);
		}
		return biInitDVOut;
	}
	
	private JLabel getBiInitAfterVelOut() {
		if(biInitAfterVelOut == null) {
			biInitAfterVelOut = new JLabel();
			biInitAfterVelOut.setText("Final: 0.0 m/s");
			biInitAfterVelOut.setBounds(309, 210, 140, 17);
		}
		return biInitAfterVelOut;
	}
	
	private JLabel getPointBInitVelOut() {
		if(pointBInitVelOut == null) {
			pointBInitVelOut = new JLabel();
			pointBInitVelOut.setText("Initial: 0.0 m/s");
			pointBInitVelOut.setBounds(23, 248, 160, 17);
		}
		return pointBInitVelOut;
	}
	
	private JLabel getPointBDVOut() {
		if(pointBDVOut == null) {
			pointBDVOut = new JLabel();
			pointBDVOut.setText("\u0394v: 0.0 m/s");
			pointBDVOut.setBounds(181, 248, 128, 17);
		}
		return pointBDVOut;
	}
	
	private JLabel getPointBFinalVelOut() {
		if(pointBFinalVelOut == null) {
			pointBFinalVelOut = new JLabel();
			pointBFinalVelOut.setText("Final: 0.0 m/s");
			pointBFinalVelOut.setBounds(309, 248, 153, 17);
		}
		return pointBFinalVelOut;
	}
	
	private JLabel getBiFinalInitVel() {
		if(biFinalInitVel == null) {
			biFinalInitVel = new JLabel();
			biFinalInitVel.setText("Initial: 0.0 m/s");
			biFinalInitVel.setBounds(23, 288, 158, 17);
		}
		return biFinalInitVel;
	}
	
	private JLabel getBiFinalDVOut() {
		if(biFinalDVOut == null) {
			biFinalDVOut = new JLabel();
			biFinalDVOut.setText("\u0394v: 0.0 m/s");
			biFinalDVOut.setBounds(181, 288, 128, 17);
		}
		return biFinalDVOut;
	}
	
	private JLabel getBiFinalVelOut() {
		if(biFinalVelOut == null) {
			biFinalVelOut = new JLabel();
			biFinalVelOut.setText("Final: 0.0 m/s");
			biFinalVelOut.setBounds(309, 288, 153, 17);
		}
		return biFinalVelOut;
	}
	
	private JLabel getFullDVOut() {
		if(fullDVOut == null) {
			fullDVOut = new JLabel();
			fullDVOut.setText("0.0 m/s");
			fullDVOut.setBounds(344, 317, 118, 17);
		}
		return fullDVOut;
	}
	
	private JLabel getUpTimeOut() {
		if(upTimeOut == null) {
			upTimeOut = new JLabel();
			upTimeOut.setText("0 minutes");
			upTimeOut.setBounds(344, 336, 118, 17);
		}
		return upTimeOut;
	}
	
	private JLabel getDownTimeOut() {
		if(downTimeOut == null) {
			downTimeOut = new JLabel();
			downTimeOut.setText("0 minutes");
			downTimeOut.setBounds(344, 351, 118, 17);
		}
		return downTimeOut;
	}
	
	private JLabel getFullTimeOut() {
		if(fullTimeOut == null) {
			fullTimeOut = new JLabel();
			fullTimeOut.setText("0 minutes");
			fullTimeOut.setBounds(344, 368, 118, 17);
		}
		return fullTimeOut;
	}
	
	private AbstractAction getShowOrbitsAction() {
		if(showOrbitsAction == null) {
			showOrbitsAction = new AbstractAction("Show Orbits", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -1335687269271059170L;

				public void actionPerformed(ActionEvent evt) {
					frame.setOrbitDisplay(lowAlt / 1000d, highAlt / 1000d, pointBAlt / 1000d, false, upwards);
				}
			};
		}
		return showOrbitsAction;
	}
	
	private JComboBox getCeleBodyBox() {
		if(celeBodyBox == null) {
			ComboBoxModel celeBodyBoxModel = 
				new DefaultComboBoxModel(CelestrialBody.values());
			celeBodyBox = new JComboBox();
			celeBodyBox.setModel(celeBodyBoxModel);
			celeBodyBox.setBounds(276, 112, 125, 27);
			celeBodyBox.setAction(getCeleBodyAction());
		}
		return celeBodyBox;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("over");
			jLabel1.setBounds(232, 117, 38, 17);
		}
		return jLabel1;
	}
	
	private AbstractAction getCeleBodyAction() {
		if(celeBodyAction == null) {
			celeBodyAction = new AbstractAction("", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 8536078752977532826L;

				public void actionPerformed(ActionEvent evt) {
					JComboBox cb = (JComboBox)evt.getSource();
				    CelestrialBody body = (CelestrialBody)cb.getSelectedItem();
				    frame.body = body;
				}
			};
		}
		return celeBodyAction;
	}

}
