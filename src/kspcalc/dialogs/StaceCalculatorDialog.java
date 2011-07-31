package kspcalc.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcal.utils.Constants;
import kspcalc.StagingCalculatorPanel;
import kspcalc.stagecalc.*;


public class StaceCalculatorDialog extends javax.swing.JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6145548439966601426L;
	
	private StagingCalculatorPanel panel;
	private AbstractAction abstractAction1;
	private JButton jButton1;
	
	public StaceCalculatorDialog(JFrame frame, StagingCalculatorPanel panel, String title) {
		super(frame);
		this.panel = panel;
		initGUI(title);
	}
	
	private void initGUI(String title) {
		try {
			this.setLayout(null);
			this.setSize(454, 350);
			try {
				ImageIcon icon = Constants.getIcon();
				this.setIconImage(icon.getImage());
			} catch (NullPointerException e) {}
			this.setTitle("KSP Calculator - "+ title);
			{
				panel.setStageCalculator1(StageCalculator.getStageCalculator());
				this.getContentPane().add((JPanel) panel.getStageCalculator1(), "Center");
				((JComponent) panel.getStageCalculator1()).setPreferredSize(new java.awt.Dimension(400, 300));
				((JComponent) panel.getStageCalculator1()).setBounds(0, 0, 444, 306);
				{
					jButton1 = new JButton();
					((JComponent) panel.getStageCalculator1()).add(jButton1);
					jButton1.setText("Save Stage");
					jButton1.setBounds(230, 261, 105, 22);
					jButton1.setAction(getAbstractAction1());
				}
				
			}
		this.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("Save Stage", null) {
			/**
			 * 
			 */
				private static final long serialVersionUID = -4132919434271482884L;

				public void actionPerformed(ActionEvent evt) {
					if (panel.getStageCalculator1().getStageIndex() == -1) {
						panel.getStageList().add(panel.getStageCalculator1().getStage());
					} else {
						panel.getStageList().set(panel.getStageCalculator1().getStageIndex(), panel.getStageCalculator1().getStage());
					}
					panel.setStagePane();
					panel.getStageDialog().setVisible(false);
					panel.setStageDialog(null);
				}
			};
		}
		return abstractAction1;
	}

}
