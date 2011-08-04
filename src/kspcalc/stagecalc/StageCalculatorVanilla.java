package kspcalc.stagecalc;
import java.awt.Dimension;
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
	private JLabel twrOut;
	private JLabel dvOut;
	private JLabel siOut;
	private JLabel thrustOut;
	private JLabel massFOut;
	private JLabel massIOut;
	private ChangeListener SpinnerListener;
	private StageMathVanilla stage;
	private int stageIndex = -1;
	private String name = "Vanilla";

	private HashMap<Parts, SpinnerLabelComponent> spinners;

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
			this.setPreferredSize(new java.awt.Dimension(500, 400));
			this.setLayout(null);
			this.setSize(425, 300);
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
			populateLabels();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void populateLabels() {
		this.getLabel("Stage Parts:", 12, 12);
		this.getLabel("Stage Weight:", 234, 36);
		this.getLabel("before Burnout:", 242, 54);
		this.getLabel("after Burnout:", 242, 85);
		massIOut = this.getLabel("0.0 tons", 254, 72);
		massFOut = this.getLabel("0.0 tons", 254, 106);
		this.getLabel("Thrust:", 234, 127);
		thrustOut = this.getLabel("0 kNewton", 310, 127);
		this.getLabel("Specific Impulse:", 234, 148);
		siOut =this.getLabel("0 s", 310, 163);
		this.getLabel("Delta-v:", 234, 184);
		dvOut = this.getLabel("0.0 m/s", 310, 184);
		this.getLabel("Thrust to Weight Ratio:", 234, 205);
		twrOut = this.getLabel("0.0", 310, 227);
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
	
	private JLabel getLabel(String text, int x, int y) {
		JLabel label = new JLabel();
		this.add(label);
		label.setText(text);
		label.setBounds(x, y, 150, 15);
		return label;
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
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public Dimension getPrefferedSize() {
		// TODO Auto-generated method stub
		return this.getSize();
	}

}
