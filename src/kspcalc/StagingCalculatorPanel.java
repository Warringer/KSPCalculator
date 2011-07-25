package kspcalc;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.*;

import kspcal.constants.Constants;
import kspcalc.math.StageMath;




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
public class StagingCalculatorPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3507249344197244600L;
	private JButton jButton1;
	private AbstractAction abstractAction1;
	private StageCalculator stageCalculator1;
	private JDialog StageDialog;
	private AbstractAction addStageAction;
	private JButton addStageButton;
	
	private StagingCalculatorPanel panel;
	private AbstractAction cancelAction;
	private AbstractAction editAction;
	private JButton cancelButton;
	private JButton editButton;
	private JLabel jLabel5;
	private JComboBox stageComboBox;
	private JDialog editStageDialog;
	private AbstractAction editStageAction;
	private JButton editStageButton;
	private AbstractAction removeStageAction;
	private JButton removeStageButton;
	private JLabel twrOut;
	private JLabel jLabel4;
	private JLabel dvOut;
	private JLabel jLabel3;
	private JLabel emptyWeightOut;
	private JTextPane StagePane;
	private JLabel jLabel2;
	private JLabel liftoffWeightOut;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private ArrayList<StageMath> stageList;

	public StagingCalculatorPanel() {
		super();
		this.panel = this;
		this.setSize(425, 300);
		this.stageList = new ArrayList<StageMath>();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(425, 300));
			this.setLayout(null);
			{
				addStageButton = new JButton();
				this.add(addStageButton);
				this.add(getJScrollPane1());
				this.add(getJLabel1());
				this.add(getLiftoffWeightOut());
				this.add(getJLabel2());
				this.add(getEmptyWeightOut());
				this.add(getJLabel3());
				this.add(getDvOut());
				this.add(getJLabel4());
				this.add(getTwrOut());
				this.add(getRemoveStageButton());
				this.add(getEditStageButton());
				addStageButton.setText("Add Stage");
				addStageButton.setBounds(12, 215, 134, 22);
				addStageButton.setAction(getAddStageAction());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getAddStageAction() {
		if(addStageAction == null) {
			addStageAction = new AbstractAction("Add Stage", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -8815680798550047202L;

				public void actionPerformed(ActionEvent evt) {
					panel.getStageDialog("Add Stage").setVisible(true);
				}
			};
		}
		return addStageAction;
	}
	
	private JDialog getStageDialog(String title) {
		if(StageDialog == null) {
			StageDialog = new JDialog();
			StageDialog.setPreferredSize(new java.awt.Dimension(454, 336));
			StageDialog.getContentPane().setLayout(null);
			StageDialog.setSize(454, 336);
			try {
				ImageIcon icon = Constants.getIcon();
				StageDialog.setIconImage(icon.getImage());
			} catch (NullPointerException e) {}
			StageDialog.setTitle("KSP Calculator - "+ title);
			{
				stageCalculator1 = new StageCalculator();
				StageDialog.getContentPane().add(stageCalculator1, "Center");
				stageCalculator1.setPreferredSize(new java.awt.Dimension(400, 300));
				stageCalculator1.setBounds(0, 0, 444, 306);
				{
					jButton1 = new JButton();
					stageCalculator1.add(jButton1);
					jButton1.setText("Add Stage");
					jButton1.setBounds(230, 261, 105, 22);
					jButton1.setAction(getAbstractAction1());
				}
				
			}
		}
		StageDialog.setLocationRelativeTo(null);
		return StageDialog;
	}
	
	private AbstractAction getAbstractAction1() {
		if(abstractAction1 == null) {
			abstractAction1 = new AbstractAction("Add Stage", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4132919434271482884L;

				public void actionPerformed(ActionEvent evt) {
					if (panel.stageCalculator1.getStageIndex() == -1) {
						panel.stageList.add(panel.stageCalculator1.getStage());
					} else {
						panel.stageList.set(panel.stageCalculator1.getStageIndex(), panel.stageCalculator1.getStage());
					}
					panel.setStagePane();
					panel.StageDialog.setVisible(false);
					panel.StageDialog = null;
				}
			};
		}
		return abstractAction1;
	}
	
	private JTextPane getStagePane() {
		if(StagePane == null) {
			StagePane = new JTextPane();
			StagePane.setBounds(12, 12, 216, 276);
			StagePane.setEditable(false); 
		}
		return StagePane;
	}

	private void setStagePane() {
		int i = 0;
		double fullMass = 0d;
		double dryMass = 0d;
		double deltaV = 0d;
		double twr = 0d;
		double massNextStage = 0d;
		String stageContent = "";
		for (StageMath stage : stageList) {
			stageContent += "Stage " + i + ":\n" + stage.toString() + "\n";
			massNextStage = fullMass;
			fullMass += stage.getCombinedMassI();
			dryMass += stage.getCombinedMassF();
			deltaV += stage.getSI() * Math.log(fullMass / (massNextStage + stage.getCombinedMassF()));
			i++;
			twr = stage.getCombinedThrust() / ( fullMass * Constants.GRAVITY);
		}
		this.StagePane.setText(stageContent);
		this.liftoffWeightOut.setText(Constants.formatDouble(fullMass) + " tons");
		this.emptyWeightOut.setText(Constants.formatDouble(dryMass) + " tons");
		this.dvOut.setText(Constants.formatVel(deltaV));
		this.twrOut.setText(Constants.formatDouble(twr));
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(12, 12, 408, 197);
			getJScrollPane1().getHorizontalScrollBar().setEnabled(false);
			jScrollPane1.setViewportView(getStagePane());
		}
		return jScrollPane1;
	}
	
	private JLabel getJLabel1() {
		if(jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Liftoff Weight:");
			jLabel1.setBounds(163, 218, 114, 15);
		}
		return jLabel1;
	}
	
	private JLabel getLiftoffWeightOut() {
		if(liftoffWeightOut == null) {
			liftoffWeightOut = new JLabel();
			liftoffWeightOut.setText("0 tons");
			liftoffWeightOut.setBounds(323, 218, 90, 15);
		}
		return liftoffWeightOut;
	}
	
	private JLabel getJLabel2() {
		if(jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Empty Weight:");
			jLabel2.setBounds(163, 239, 114, 15);
		}
		return jLabel2;
	}
	
	private JLabel getEmptyWeightOut() {
		if(emptyWeightOut == null) {
			emptyWeightOut = new JLabel();
			emptyWeightOut.setText("0 tons");
			emptyWeightOut.setBounds(323, 239, 90, 15);
		}
		return emptyWeightOut;
	}
	
	private JLabel getJLabel3() {
		if(jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Total \u0394v:");
			jLabel3.setBounds(163, 260, 114, 15);
		}
		return jLabel3;
	}
	
	private JLabel getDvOut() {
		if(dvOut == null) {
			dvOut = new JLabel();
			dvOut.setText("0 m/s");
			dvOut.setBounds(323, 260, 90, 15);
		}
		return dvOut;
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Thrust to Weight Ratio:");
			jLabel4.setBounds(163, 281, 154, 15);
		}
		return jLabel4;
	}
	
	private JLabel getTwrOut() {
		if(twrOut == null) {
			twrOut = new JLabel();
			twrOut.setText("0");
			twrOut.setBounds(323, 281, 90, 15);
		}
		return twrOut;
	}
	
	private JButton getRemoveStageButton() {
		if(removeStageButton == null) {
			removeStageButton = new JButton();
			removeStageButton.setText("Remove Last Stage");
			removeStageButton.setBounds(12, 242, 134, 22);
			removeStageButton.setAction(getRemoveStageAction());
		}
		return removeStageButton;
	}
	
	private AbstractAction getRemoveStageAction() {
		if(removeStageAction == null) {
			removeStageAction = new AbstractAction("Remove Last Stage", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -7229035775932312561L;

				public void actionPerformed(ActionEvent evt) {
					panel.stageList.remove(panel.stageList.size() - 1);
					panel.setStagePane();
				}
			};
		}
		return removeStageAction;
	}
	
	private JButton getEditStageButton() {
		if(editStageButton == null) {
			editStageButton = new JButton();
			editStageButton.setText("Edit Stage");
			editStageButton.setBounds(12, 269, 134, 22);
			editStageButton.setAction(getEditStageAction());
		}
		return editStageButton;
	}
	
	private AbstractAction getEditStageAction() {
		if(editStageAction == null) {
			editStageAction = new AbstractAction("Edit Stage", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1343452345321423L;

				public void actionPerformed(ActionEvent evt) {
					panel.getEditStageDialog().setVisible(true);
				}
			};
		}
		return editStageAction;
	}
	
	private JDialog getEditStageDialog() {
		if(editStageDialog == null) {
			editStageDialog = new JDialog();
			editStageDialog.getContentPane().setLayout(null);
			editStageDialog.getContentPane().add(getJLabel5());
			editStageDialog.getContentPane().add(getStageComboBox());
			editStageDialog.getContentPane().add(getEditButton());
			editStageDialog.getContentPane().add(getCancelButton());
			editStageDialog.setSize(204, 129);
		}
		editStageDialog.setLocationRelativeTo(null);
		return editStageDialog;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Select Stage:");
			jLabel5.setBounds(12, 12, 124, 15);
		}
		return jLabel5;
	}
	
	private JComboBox getStageComboBox() {
		if(stageComboBox == null) {
			String[] stages = new String[stageList.size()];
			for (Integer i = 0; i < stageList.size(); i++) {
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
					panel.getEditStageDialog().setVisible(false);
					panel.getStageDialog("Edit Stage").setVisible(true);
					int stage = panel.stageComboBox.getSelectedIndex();
					panel.stageCalculator1.setStageCalculator(stageList.get(stage).getStageParts(), stage);
					panel.editStageDialog = null;
					panel.stageComboBox = null;
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
					panel.getEditStageDialog().setVisible(false);
					panel.editStageDialog = null;
					panel.stageComboBox = null;
				}
			};
		}
		return cancelAction;
	}
}
