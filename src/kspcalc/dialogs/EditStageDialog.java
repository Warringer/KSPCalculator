package kspcalc.dialogs;

import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcalc.*;
import kspcalc.stagecalc.*;

public class EditStageDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1264351967992302520L;
	/**
	* Auto-generated main method to display this JDialog
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				EditStageDialog inst = new EditStageDialog(frame);
				inst.setVisible(true);
			}
		});
	}//*/

	private JLabel jLabel5;
	private JButton editButton;
	private JButton cancelButton;
	private AbstractAction editAction;
	private AbstractAction cancelAction;
	
	private StagingCalculatorPanel panel;
	private EditStageDialog dialog;
	private JComboBox stageComboBox;
	
	public EditStageDialog(JFrame frame, StagingCalculatorPanel panel) {
		super(frame);
		this.dialog = this;
		this.panel = panel;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(null);
			this.add(getJLabel5());
			this.add(getStageComboBox());
			this.add(getEditButton());
			this.add(getCancelButton());
			this.setSize(204, 129);
			this.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Select Stage:");
			jLabel5.setBounds(12, 12, 124, 15);
		}
		return jLabel5;
	}
	
	private JButton getEditButton() {
		if(editButton == null) {
			editButton = new JButton();
			editButton.setText("Edit");
			editButton.setBounds(12, 66, 83, 22);
			editButton.setAction(getEditAction());
		}
		return editButton;
	}
	
	private JButton getCancelButton() {
		if(cancelButton == null) {
			cancelButton = new JButton();
			cancelButton.setText("Cancel");
			cancelButton.setBounds(100, 66, 83, 22);
			cancelButton.setAction(getCancelAction());
		}
		return cancelButton;
	}
	
	private AbstractAction getEditAction() {
		if(editAction == null) {
			editAction = new AbstractAction("Edit", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -7431497483798199041L;

				public void actionPerformed(ActionEvent evt) {
					dialog.setVisible(false);
					panel.getStageDialog("Edit Stage").setVisible(true);
					int stage = dialog.stageComboBox.getSelectedIndex();
					if (panel.getStageCalculator1().getName() == "Vanilla") {
						panel.getStageCalculator1().setStageCalculator(panel.getStageList().get(stage).getStageParts(), stage);
					}
					panel.setEditStageDialog(null);
					dialog.stageComboBox = null;
				}
			};
		}
		return editAction;
	}
	
	private AbstractAction getCancelAction() {
		if(cancelAction == null) {
			
			cancelAction = new AbstractAction("Cancel", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -6894155429284458140L;

				public void actionPerformed(ActionEvent evt) {
					dialog.setVisible(false);
					panel.setEditStageDialog(null);
					dialog.stageComboBox = null;
				}
			};
		}
		return cancelAction;
	}
	
	private JComboBox getStageComboBox() {
		if(stageComboBox == null) {
			String[] stages = new String[panel.getStageList().size()];
			for (Integer i = 0; i < panel.getStageList().size(); i++) {
				stages[i] = "Stage " + i;
			}
			ComboBoxModel stageComboBoxModel = 
				new DefaultComboBoxModel( stages );
			stageComboBox = new JComboBox();
			stageComboBox.setModel(stageComboBoxModel);
			stageComboBox.setBounds(12, 33, 174, 22);
		}
		return stageComboBox;
	}

}
