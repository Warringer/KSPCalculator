package kspcalc;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import kspcal.utils.*;
import kspcalc.dialogs.*;
import kspcalc.math.*;
import kspcalc.stagecalc.*;




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
	private StageCalc stageCalculator1;
	private JDialog StageDialog;
	private AbstractAction addStageAction;
	private JButton addStageButton;
	
	private StagingCalculatorPanel panel;

	private EditStageDialog editStageDialog;
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
	private Calculator frame;

	public StagingCalculatorPanel(Calculator frame) {
		super();
		this.panel = this;
		this.frame = frame;
		this.setSize(425, 350);
		this.stageList = new ArrayList<StageMath>();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setPreferredSize(new java.awt.Dimension(500, 400));
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
	
	public JDialog getStageDialog(String title) {
		if(StageDialog == null) {
			StageDialog = new StageCalculatorDialog(frame, panel, title);
		}
		return StageDialog;
	}
	
	private JTextPane getStagePane() {
		if(StagePane == null) {
			StagePane = new JTextPane();
			StagePane.setBounds(12, 12, 216, 276);
			StagePane.setEditable(false); 
		}
		return StagePane;
	}

	public void setStagePane() {
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
	
	private JDialog getEditStageDialog() {
		if(editStageDialog == null) {
			editStageDialog = new EditStageDialog(frame, this);
		}
		return editStageDialog;
	}
	
	private JButton getEditStageButton() {
		if(editStageButton == null) {
			editStageButton = new JButton();
			editStageButton.setText("Edit Stage");
			editStageButton.setBounds(12, 269, 134, 22);
			editStageButton.setAction(getEditStageAction());
			editStageButton.setEnabled(false);
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
	

	/**
	 * @param editStageDialog the editStageDialog to set
	 */
	public void setEditStageDialog(EditStageDialog editStageDialog) {
		this.editStageDialog = editStageDialog;
	}

	/**
	 * @return the stageList
	 */
	public ArrayList<StageMath> getStageList() {
		return stageList;
	}

	public void setStageCalculator1(StageCalc stageCalculator1) {
		this.stageCalculator1 = stageCalculator1;
	}

	public StageCalc getStageCalculator1() {
		return stageCalculator1;
	}

	public void setStageDialog(JDialog stageDialog) {
		StageDialog = stageDialog;
	}

	public JDialog getStageDialog() {
		return StageDialog;
	}
}
