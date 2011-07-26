package kspcalc.dialogs;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.*;

import kspcal.utils.Constants;
import kspcalc.Calculator;

public class AboutDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5315537897682844385L;

	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private Component jLabel4;
	private JLabel versionLabel;
	private JLabel jLabel5;
	private JButton OkayButton;
	private AbstractAction OkayAction;
	@SuppressWarnings("unused")
	private Calculator frame;
	private JLabel jLabel6;
	
	public AboutDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setSize(371, 197);
			this.setLayout(null);
			{
				jLabel1 = new JLabel();
				add(jLabel1);
				jLabel1.setText("Kerbal Space Program");
				jLabel1.setBounds(145, 10, 205, 34);
				jLabel1.setFont(new java.awt.Font("Arial",0,20));
			}
			{
				jLabel2 = new JLabel();
				this.add(jLabel2);
				jLabel2.setText("Calculator");
				jLabel2.setBounds(191, 43, 109, 21);
				jLabel2.setFont(new java.awt.Font("Arial",0,20));
			}
			{
				jLabel3 = new JLabel();
				this.add(jLabel3);
				jLabel3.setText("Version:");
				jLabel3.setBounds(157, 77, 64, 15);
			}
			{
				jLabel4 = new JLabel("by:");
				this.add(jLabel4);
				jLabel4.setBounds(157, 99, 55, 15);
			}
			{
				versionLabel = new JLabel();
				this.add(versionLabel);
				this.add(getJLabel5());
				this.add(getOkayButton());
				this.add(getJLabel6());
				versionLabel.setText(Constants.Version);
				versionLabel.setBounds(227, 77, 85, 15);
			}
			this.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private JLabel getJLabel5() {
	if(jLabel5 == null) {
		jLabel5 = new JLabel("Warringer");
		jLabel5.setBounds(227, 99, 85, 15);
	}
	return jLabel5;
}

private JButton getOkayButton() {
	if(OkayButton == null) {
		OkayButton = new JButton("Okay");
		OkayButton.setBounds(203, 134, 44, 22);
		OkayButton.setAction(getOkayAction());
	}
	return OkayButton;
}

private AbstractAction getOkayAction() {
	if(OkayAction == null) {
		OkayAction = new AbstractAction("Okay", null) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 8848019343344314900L;

			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
			}
		};
	}
	return OkayAction;
}

private JLabel getJLabel6() {
	if(jLabel6 == null) {
		jLabel6 = new JLabel(Constants.getIcon());
		jLabel6.setBounds(12, 12, 10, 10);
		jLabel6.setSize(128, 128);
	}
	return jLabel6;
}

}
