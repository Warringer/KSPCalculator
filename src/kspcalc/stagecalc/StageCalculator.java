package kspcalc.stagecalc;

import java.awt.Dimension;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.event.*;

import kspcal.utils.*;
import kspcalc.components.SpinnerLabelComponent;
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
public class StageCalculator extends javax.swing.JPanel implements StageCalc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6096969178422238375L;
	private JLabel twrOut;
	private JLabel dvOut;
	private JLabel siOut;
	private JLabel thrustOut;
	private JTabbedPane jTabbedPane1;
	private JLabel massFOut;
	private JLabel massIOut;
	private ChangeListener SpinnerListener;
	private StageMathCustom stage;
	private int stageIndex = -1;
	private String name = "Custom";
	
	private CustomParts stageParts;

	
	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new StageCalculator());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public StageCalculator() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(525, 650));
			this.setLayout(null);
			this.setSize(500, 650);
			this.add(getJTabbedPane1());
			stageParts = new CustomParts();
			Iterator<Entry<CustomPartType, HashMap<String, CustomPart>>> i = this.stageParts.getParts().entrySet().iterator();
			while (i.hasNext()) {
				Entry<CustomPartType, HashMap<String, CustomPart>> pane = i.next();
				Iterator<Entry<String, CustomPart>> i2 = pane.getValue().entrySet().iterator();
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setPreferredSize(new java.awt.Dimension(214, 258));
				int y = 0;
				int j = 1;
				int k = 1;
				while (i2.hasNext()) {
					Entry<String, CustomPart> partEntry = i2.next();
					CustomPart part = partEntry.getValue();
					SpinnerLabelComponent spinner = part.getSpinner(0, y, part.getName());
					spinner.addChangeListener(getSpinnerListener());
					panel.add(spinner);
					y += 25;
					if (j > 20) {
						jTabbedPane1.addTab(pane.getKey().getName() + " " + k, null, panel, pane.getKey().getFullName());
						k++;
						j = 0;
						y = 0;
						panel = new JPanel();
						panel.setLayout(null);
						panel.setPreferredSize(new java.awt.Dimension(214, 258));
					}
					j++;
				}
				jTabbedPane1.addTab(pane.getKey().getName() + " " + k, null, panel, pane.getKey().getFullName());
			}
			this.populateLabels();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void populateLabels() {
		this.getLabel("Stage Parts:", 12, 12);
		this.getLabel("Stage Weight:", 334, 36);
		this.getLabel("before Burnout:", 342, 54);
		this.getLabel("after Burnout:", 342, 85);
		massIOut = this.getLabel("0.0 tons", 354, 72);
		massFOut = this.getLabel("0.0 tons", 354, 106);
		this.getLabel("Thrust:", 334, 127);
		thrustOut = this.getLabel("0 kNewton", 410, 127);
		this.getLabel("Specific Impulse:", 334, 148);
		siOut =this.getLabel("0 s", 410, 163);
		this.getLabel("Delta-v:", 334, 184);
		dvOut = this.getLabel("0.0 m/s", 410, 184);
		this.getLabel("Thrust to Weight Ratio:", 334, 205);
		twrOut = this.getLabel("0.0", 410, 227);
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

	@Override
	public void doMath() {
		StageMathCustom calc = new StageMathCustom(stageParts.getParts());
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

	@Override
	public int getStageIndex() {
		// TODO Auto-generated method stub
		return stageIndex;
	}

	@Override
	public StageMath getStage() {
		// TODO Auto-generated method stub
		return stage;
	}
	
	private JTabbedPane getJTabbedPane1() {
		if(jTabbedPane1 == null) {
			jTabbedPane1 = new JTabbedPane();
			jTabbedPane1.setBounds(12, 30, 314, 608);
		}
		return jTabbedPane1;
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
