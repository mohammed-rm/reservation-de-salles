package view;

import javax.swing.*;
import java.awt.*;

public class MenuSelection extends Component {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
	private JLabel labLanguage;

	/**
	 * Default constructor
	 */
	public MenuSelection() {
		comboBox = new JComboBox<String>();
		labLanguage = new JLabel("Select a language");
	}

	/**
	 * To create a selection box
	 * 
	 * @return comboBox
	 */
	public JComboBox<String> createCombo() {
		comboBox.setBounds(150, 8, 45, 30);
		comboBox.setBackground(new Color(189, 183, 107));
		comboBox.addItem("Fr");
		comboBox.addItem("En");

		return comboBox;
	}

	/**
	 * To change style
	 * 
	 * @return labLanguage
	 */
	public JLabel createLabel() {
		labLanguage.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labLanguage.setBounds(10, 14, 130, 20);

		return labLanguage;
	}
}
