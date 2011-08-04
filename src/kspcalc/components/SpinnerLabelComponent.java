package kspcalc.components;

import javax.swing.*;
import javax.swing.event.*;


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
public class SpinnerLabelComponent extends JComponent {

	private SpinnerLabelComponent component;
	private JPanel panel;
	private JSpinner spinner;
	private JLabel label;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8862573705449735623L;
	
	public SpinnerLabelComponent(String name) {
		this.component = this;
		panel = new JPanel();
		component.add(panel);
		panel.setSize(250, 25);
		panel.setLayout(null);
		panel.setPreferredSize(new java.awt.Dimension(250, 23));
		label = new JLabel(name);
		label.setToolTipText(name);
		panel.add(label);
		label.setBounds(40, 4, 210, 15);
		{
			spinner = new JSpinner();
			panel.add(spinner);
			SpinnerNumberModel SpinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
			spinner.setModel(SpinnerModel);
			spinner.setBounds(0, 1, 40, 22);
		}
	}
	
	/**
	 * Add a Change Listener to the Component
	 * @param listener
	 */
	public void addChangeListener(ChangeListener listener) {
		spinner.addChangeListener(listener);
	}
	
	/**
	 * @return Value of the Spinner in the Component
	 */
	public int getValue() {
		return (Integer) spinner.getValue();
	}

	/**
	 * Sets the Value of the Spinner in the Component
	 * @param value
	 */
	public void setValue(int value) {
		spinner.setValue(value);
	}
	
}
