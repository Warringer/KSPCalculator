package kspcalc.dialogs;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.*;

import kspcal.utils.KSPConfig;


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
public class ConfigDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5034655712719087740L;
	private JTextField KSPDirectoryField;
	private AbstractAction DirectorySelectAction;
	private JButton DirectorySelectButton;
	private JLabel jLabel1;
	private JFileChooser fileChooser;
	private AbstractAction CloseAction;
	private JButton CloseButton;
	private AbstractAction SaveAction;
	private JButton SaveButton;
	private KSPConfig config;

	/**
	* Auto-generated main method to display this JDialog
	*/
	
	
	public ConfigDialog(JFrame frame) {
		super(frame);
		config = KSPConfig.getConfig();
		initGUI();
	}
	
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				{
					jLabel1 = new JLabel();
					getContentPane().add(jLabel1);
					jLabel1.setText("Kerbal Space Program Directory:");
					jLabel1.setBounds(12, 12, 203, 15);
				}
				{
					KSPDirectoryField = new JTextField();
					KSPDirectoryField.setText(config.getDirectory());
					getContentPane().add(KSPDirectoryField);
					KSPDirectoryField.setBounds(12, 33, 154, 22);
					KSPDirectoryField.setEditable(false);
				}
				{
					DirectorySelectButton = new JButton();
					getContentPane().add(DirectorySelectButton);
					getContentPane().add(getSaveButton());
					getContentPane().add(getCloseButton());
					DirectorySelectButton.setText("Select Directory");
					DirectorySelectButton.setBounds(172, 33, 113, 22);
					DirectorySelectButton.setAction(getDirectorySelectAction());
				}
			}
			setSize(400, 300);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AbstractAction getDirectorySelectAction() {
		if(DirectorySelectAction == null) {
			DirectorySelectAction = new AbstractAction("Select Directory", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 6229588700388403938L;

				public void actionPerformed(ActionEvent evt) {
					int returnVal = getFileChooser().showOpenDialog(ConfigDialog.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						KSPDirectoryField.setText(file.getAbsolutePath());
					} else {
						System.out.println("Error: Can't open File dialog");
					}
				}
			};
		}
		return DirectorySelectAction;
	}
	
	private JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (config.hasDirectory()) {
				fileChooser.setSelectedFile(new File(config.getDirectory()));
			}
		}
		return fileChooser;
	}
	
	private JButton getSaveButton() {
		if(SaveButton == null) {
			SaveButton = new JButton();
			SaveButton.setText("Save");
			SaveButton.setBounds(245, 242, 67, 22);
			SaveButton.setAction(getSaveAction());
		}
		return SaveButton;
	}
	
	private AbstractAction getSaveAction() {
		if(SaveAction == null) {
			SaveAction = new AbstractAction("Save", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 6287330824539227085L;

				public void actionPerformed(ActionEvent evt) {
					config.setDirectory(KSPDirectoryField.getText());
					config.saveConfig();
					setVisible(false);
				}
			};
		}
		return SaveAction;
	}
	
	private JButton getCloseButton() {
		if(CloseButton == null) {
			CloseButton = new JButton();
			CloseButton.setText("Close");
			CloseButton.setBounds(323, 242, 64, 22);
			CloseButton.setAction(getCloseAction());
		}
		return CloseButton;
	}
	
	private AbstractAction getCloseAction() {
		if(CloseAction == null) {
			CloseAction = new AbstractAction("Close", null) {
				/**
				 * 
				 */
				private static final long serialVersionUID = -4163822631073168908L;

				public void actionPerformed(ActionEvent evt) {
					setVisible(false);
				}
			};
		}
		return CloseAction;
	}

}
