package kspcalc.dialogs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcal.utils.Constants;
import kspcalc.StagingCalculatorPanel;
import kspcalc.stagecalc.*;


public class StageCalculatorDialog extends javax.swing.JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6145548439966601426L;
	
	private StagingCalculatorPanel panel;
	private AbstractAction abstractAction1;
	private JButton jButton1;
	
	public StageCalculatorDialog(JFrame frame, StagingCalculatorPanel panel, String title) {
		super(frame);
		this.panel = panel;
		initGUI(title);
	}
	
	private void initGUI(String title) {
		try {
			Dimension size = new Dimension();
			this.setLayout(null);
			try {
				ImageIcon icon = Constants.getIcon();
				this.setIconImage(icon.getImage());
			} catch (NullPointerException e) {}
			this.setTitle("KSP Calculator - "+ title);
			{
				panel.setStageCalculator1(new StageCalculator());
				this.getContentPane().add((JPanel) panel.getStageCalculator1(), "Center");
				size = panel.getStageCalculator1().getPrefferedSize();
				((JComponent) panel.getStageCalculator1()).setPreferredSize(size);
				{
					jButton1 = new JButton();
					((JComponent) panel.getStageCalculator1()).add(jButton1);
					jButton1.setText("Save Stage");
					if (size.width > 350) {
						jButton1.setBounds(350, 261, 105, 22);
					} else {
						jButton1.setBounds(250, 261, 105, 22); 
					}
					jButton1.setAction(getAbstractAction1());
				}
				
			}
			this.setSize(size);
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
