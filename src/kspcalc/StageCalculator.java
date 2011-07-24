package kspcalc;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.event.*;

import orbitalmath.StageMath;

import constants.Constants;
import constants.Parts;

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
public class StageCalculator extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1360305272816831155L;
	private JLabel jLabel1;
	private JSpinner ChuteSpinner;
	private JLabel jLabel4;
	private JSpinner LFESpinner;
	private JLabel jLabel5;
	private JSpinner TriSpinner;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel jLabel11;
	private JSpinner SASSpinner;
	private JLabel jLabel10;
	private JSpinner eSFBSpinner;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JSpinner RadialSpinner;
	private JLabel jLabel7;
	private JSpinner StackSpinner;
	private JLabel twrOut;
	private JLabel jLabel18;
	private JLabel dvOut;
	private JLabel jLabel17;
	private JLabel siOut;
	private JLabel jLabel16;
	private JLabel thrustOut;
	private JLabel jLabel15;
	/**
	 * @return the stage
	 */
	public StageMath getStage() {
		return stage;
	}

	private JLabel massFOut;
	private JLabel massIOut;
	private JLabel jLabel6;
	private JSpinner SRBSpinner;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JSpinner LFTSpinner;
	private JSpinner CPSpinner;
	
	private StageCalculator panel;
	private ChangeListener SpinnerListener;
	private StageMath stage;
	private int stageIndex = -1;

	public StageCalculator() {
		super();
		this.panel = this;
		this.stage = new StageMath();
		initGUI();
	}
	
	public void setStageCalculator(HashMap<Parts, Integer> stageParts, int stage) {
		this.LFTSpinner.setValue(stageParts.get(Parts.LFT));
		this.LFESpinner.setValue(stageParts.get(Parts.LFE));
		this.SRBSpinner.setValue(stageParts.get(Parts.SRB));
		this.SASSpinner.setValue(stageParts.get(Parts.SAS));
		this.CPSpinner.setValue(stageParts.get(Parts.CP));
		this.RadialSpinner.setValue(stageParts.get(Parts.Radial));
		this.StackSpinner.setValue(stageParts.get(Parts.Stack));
		this.TriSpinner.setValue(stageParts.get(Parts.Tri));
		this.ChuteSpinner.setValue(stageParts.get(Parts.Chute));
		this.eSFBSpinner.setValue(stageParts.get(Parts.EmptySRB));
		this.setStageIndex(stage);
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(425, 300));
			this.setLayout(null);
			this.setSize(425, 300);
			Integer value = new Integer(0); 
			Integer min = new Integer(0);
			Integer max = new Integer(100); 
			Integer step = new Integer(1);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("Stage Parts:");
				jLabel1.setBounds(12, 12, 109, 15);
			}
			{
				SpinnerNumberModel ChuteSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				ChuteSpinner = new JSpinner();
				this.add(ChuteSpinner);
				ChuteSpinner.setModel(ChuteSpinnerModel);
				ChuteSpinner.setBounds(24, 33, 40, 22);
				ChuteSpinner.addChangeListener(getSpinnerListener());
			}
			{
				SpinnerNumberModel CPSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				CPSpinner = new JSpinner();
				this.add(CPSpinner);
				CPSpinner.setModel(CPSpinnerModel);
				CPSpinner.setBounds(24, 55, 40, 22);
				CPSpinner.addChangeListener(getSpinnerListener());
			}
			{
				SpinnerNumberModel LFTSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				LFTSpinner = new JSpinner();
				this.add(LFTSpinner);
				LFTSpinner.setModel(LFTSpinnerModel);
				LFTSpinner.setBounds(24, 77, 40, 22);
				LFTSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("Parachutes");
				jLabel2.setBounds(70, 36, 125, 15);
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("Command Modules");
				jLabel3.setBounds(70, 58, 125, 15);
			}
			{
				jLabel4 = new JLabel();
				this.add(jLabel4);
				jLabel4.setText("Liquid Fuel Tanks");
				jLabel4.setBounds(70, 80, 125, 15);
			}
			{
				SpinnerNumberModel LFESpinnerModel = new SpinnerNumberModel(value, min, max, step);
				LFESpinner = new JSpinner();
				this.add(LFESpinner);
				LFESpinner.setModel(LFESpinnerModel);
				LFESpinner.setBounds(24, 99, 40, 22);
				LFESpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel5 = new JLabel();
				this.add(jLabel5);
				jLabel5.setText("Liquid Fuel Engines");
				jLabel5.setBounds(70, 102, 125, 15);
			}
			{
				SpinnerNumberModel SRBSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				SRBSpinner = new JSpinner();
				this.add(SRBSpinner);
				SRBSpinner.setModel(SRBSpinnerModel);
				SRBSpinner.setBounds(24, 121, 40, 22);
				SRBSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel6 = new JLabel();
				this.add(jLabel6);
				jLabel6.setText("Solid Fuel Booster");
				jLabel6.setBounds(70, 124, 125, 15);
			}
			{
				SpinnerNumberModel StackSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				StackSpinner = new JSpinner();
				this.add(StackSpinner);
				StackSpinner.setModel(StackSpinnerModel);
				StackSpinner.setBounds(24, 145, 40, 22);
				StackSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel7 = new JLabel();
				this.add(jLabel7);
				jLabel7.setText("Stack Decouplers");
				jLabel7.setBounds(70, 148, 125, 15);
			}
			{
				SpinnerNumberModel RadialSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				RadialSpinner = new JSpinner();
				this.add(RadialSpinner);
				RadialSpinner.setModel(RadialSpinnerModel);
				RadialSpinner.setBounds(24, 169, 40, 22);
				RadialSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel8 = new JLabel();
				this.add(jLabel8);
				jLabel8.setText("Radial Decouplers");
				jLabel8.setBounds(70, 172, 125, 15);
			}
			{
				SpinnerNumberModel TriSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				TriSpinner = new JSpinner();
				this.add(TriSpinner);
				TriSpinner.setModel(TriSpinnerModel);
				TriSpinner.setBounds(24, 193, 40, 22);
				TriSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel9 = new JLabel();
				this.add(jLabel9);
				jLabel9.setText("Tri Coupler");
				jLabel9.setBounds(70, 196, 125, 15);
			}
			{
				SpinnerNumberModel eSFBSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				eSFBSpinner = new JSpinner();
				this.add(eSFBSpinner);
				eSFBSpinner.setModel(eSFBSpinnerModel);
				eSFBSpinner.setBounds(24, 215, 40, 22);
				eSFBSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel10 = new JLabel();
				this.add(jLabel10);
				jLabel10.setText("Empty Booster");
				jLabel10.setBounds(70, 218, 125, 15);
			}
			{
				SpinnerNumberModel SASSpinnerModel = new SpinnerNumberModel(value, min, max, step);
				SASSpinner = new JSpinner();
				this.add(SASSpinner);
				SASSpinner.setModel(SASSpinnerModel);
				SASSpinner.setBounds(24, 239, 40, 22);
				SASSpinner.addChangeListener(getSpinnerListener());
			}
			{
				jLabel11 = new JLabel();
				this.add(jLabel11);
				jLabel11.setText("SAS Modules");
				jLabel11.setBounds(70, 242, 125, 15);
			}
			{
				jLabel12 = new JLabel();
				this.add(jLabel12);
				jLabel12.setText("Stage Weight:");
				jLabel12.setBounds(234, 36, 108, 15);
			}
			{
				jLabel13 = new JLabel();
				this.add(jLabel13);
				jLabel13.setText("before Burnout:");
				jLabel13.setBounds(242, 54, 107, 15);
			}
			{
				jLabel14 = new JLabel();
				this.add(jLabel14);
				jLabel14.setText("after Burnout:");
				jLabel14.setBounds(242, 85, 107, 15);
			}
			{
				massIOut = new JLabel();
				this.add(massIOut);
				massIOut.setText("0.0 tons");
				massIOut.setBounds(254, 72, 89, 15);
			}
			{
				massFOut = new JLabel();
				this.add(massFOut);
				massFOut.setText("0.0 tons");
				massFOut.setBounds(254, 106, 89, 15);
			}
			{
				jLabel15 = new JLabel();
				this.add(jLabel15);
				jLabel15.setText("Thrust:");
				jLabel15.setBounds(234, 127, 76, 15);
			}
			{
				thrustOut = new JLabel();
				this.add(thrustOut);
				thrustOut.setText("0 kNewton");
				thrustOut.setBounds(310, 127, 93, 15);
			}
			{
				jLabel16 = new JLabel();
				this.add(jLabel16);
				jLabel16.setText("Specific Impulse:");
				jLabel16.setBounds(234, 148, 115, 15);
			}
			{
				siOut = new JLabel();
				this.add(siOut);
				siOut.setText("0 s");
				siOut.setBounds(310, 163, 93, 15);
			}
			{
				jLabel17 = new JLabel();
				this.add(jLabel17);
				jLabel17.setText("Delta-v:");
				jLabel17.setBounds(234, 184, 76, 15);
			}
			{
				dvOut = new JLabel();
				this.add(dvOut);
				dvOut.setText("0.0 m/s");
				dvOut.setBounds(310, 184, 93, 15);
			}
			{
				jLabel18 = new JLabel();
				this.add(jLabel18);
				jLabel18.setText("Thrust to Weight Ratio:");
				jLabel18.setBounds(234, 205, 144, 15);
			}
			{
				twrOut = new JLabel();
				this.add(twrOut);
				twrOut.setText("0.0");
				twrOut.setBounds(310, 227, 93, 15);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ChangeListener getSpinnerListener() {
		if (SpinnerListener == null) {
			SpinnerListener = new ChangeListener() {
				public void stateChanged(ChangeEvent evt) {
					panel.doMath();
				}
			};
		}
		return SpinnerListener;
	}
	
	private void doMath() {
		HashMap<Parts, Integer> parts = new HashMap<Parts, Integer>();
		parts.put(Parts.LFT, (Integer) this.LFTSpinner.getValue());
		parts.put(Parts.LFE, (Integer) this.LFESpinner.getValue());
		parts.put(Parts.SRB, (Integer) this.SRBSpinner.getValue());
		parts.put(Parts.SAS, (Integer) this.SASSpinner.getValue());
		parts.put(Parts.CP, (Integer) this.CPSpinner.getValue());
		parts.put(Parts.Radial, (Integer) this.RadialSpinner.getValue());
		parts.put(Parts.Stack, (Integer) this.StackSpinner.getValue());
		parts.put(Parts.Tri, (Integer) this.TriSpinner.getValue());
		parts.put(Parts.Chute, (Integer) this.ChuteSpinner.getValue());
		parts.put(Parts.EmptySRB, (Integer) this.eSFBSpinner.getValue());
		StageMath calc = new StageMath(parts, 0);
		this.massFOut.setText(Constants.formatDouble(calc.getCombinedMassF()) + " tons");
		this.massIOut.setText(Constants.formatDouble(calc.getCombinedMassI()) + " tons");
		this.thrustOut.setText(Constants.formatDouble(calc.getCombinedThrust()) + " kN");
		this.siOut.setText(Constants.formatDouble(calc.getSI()) + " s");
		this.twrOut.setText(Constants.formatDouble(calc.getTWR()));
		if (calc.getDV() > 10000d) {
			this.dvOut.setText(Constants.formatVelKilo(calc.getDV()));
		} else {
			this.dvOut.setText(Constants.formatVel(calc.getDV()));
		}
		this.stage = calc;
	}

	public void setStageIndex(int stageIndex) {
		this.stageIndex = stageIndex;
	}

	public int getStageIndex() {
		return stageIndex;
	}

}
