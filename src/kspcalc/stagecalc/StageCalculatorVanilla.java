package kspcalc.stagecalc;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.event.*;

import kspcal.utils.Constants;
import kspcal.utils.Parts;
import kspcalc.components.SpinnerLabelComponent;
import kspcalc.math.StageMathVanilla;



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
public class StageCalculatorVanilla extends javax.swing.JPanel implements StageCalc{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1360305272816831155L;
	private JLabel jLabel1;
	private JLabel jLabel14;
	private JLabel jLabel13;
	private JLabel jLabel12;
	private JLabel twrOut;
	private JLabel jLabel18;
	private JLabel dvOut;
	private JLabel jLabel17;
	private JLabel siOut;
	private JLabel jLabel16;
	private JLabel thrustOut;
	private JLabel jLabel15;
	private HashMap<Parts, SpinnerLabelComponent> spinners;

	private JLabel massFOut;
	private JLabel massIOut;
	
	private static StageCalc panel;
	private ChangeListener SpinnerListener;
	private StageMathVanilla stage;
	private int stageIndex = -1;

	public StageCalculatorVanilla() {
		super();
		this.stage = new StageMathVanilla();
		initGUI();
	}
	
	public void setStageCalculator(HashMap<Parts, Integer> stageParts, int stage) {
		for (Parts part : Parts.values()) {
			this.spinners.get(part).setValue(stageParts.get(part));
		}
		this.setStageIndex(stage);
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(425, 300));
			this.setLayout(null);
			this.setSize(425, 300);
			{
				jLabel1 = new JLabel();
				this.add(jLabel1);
				jLabel1.setText("Stage Parts:");
				jLabel1.setBounds(12, 12, 109, 15);
			}
			// Setup the Spinners dynamically
			spinners = new HashMap<Parts, SpinnerLabelComponent>();
			int y = 25;
			for (Parts part : Parts.values()) {
				SpinnerLabelComponent spinner = getSpinnerLabelComponent(24, y, part.getName());
				this.add(spinner);
				spinners.put(part, spinner);
				spinner.addChangeListener(getSpinnerListener());
				y += 25;
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
					doMath();
				}
			};
		}
		return SpinnerListener;
	}
	
	public void doMath() {
		HashMap<Parts, Integer> parts = new HashMap<Parts, Integer>();
		for (Parts part : Parts.values()) {
			parts.put(part, this.spinners.get(part).getValue());
		}
		StageMathVanilla calc = new StageMathVanilla(parts, 0);
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
	
	private SpinnerLabelComponent getSpinnerLabelComponent(int x, int y, String name) {
		SpinnerLabelComponent spinner = new SpinnerLabelComponent(name);
		spinner.setBounds(x, y, 250, 24);
		return spinner;
	}
	
	/**
	 * @return the stage
	 */
	public StageMathVanilla getStage() {
		return stage;
	}

}
