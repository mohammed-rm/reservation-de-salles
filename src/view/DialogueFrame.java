package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DialogueFrame {

	JFrame addFrame;
	JPanel contentPane;
	JLabel lab;

	/**
	 * Default constructor
	 */
	public DialogueFrame() {
		addFrame = new JFrame();
		addFrame.setPreferredSize(new Dimension(400, 180));
		addFrame.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		addFrame.setLocation(screenSize.width / 2 - addFrame.getPreferredSize().width / 2,
				screenSize.height / 2 - addFrame.getPreferredSize().height / 2);
		addFrame.setLayout(null);

	}

	/**
	 * Frame builder to respond when an action is made on a button
	 * 
	 * @param message
	 * @param iconPath
	 */
	public void dialogFrame(String message, String iconPath) {
		contentPane = new JPanel();
		contentPane.setSize(400, 180);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(189, 183, 107));

		lab = new JLabel(message, SwingConstants.CENTER);
		lab.setIcon(IconsResize.getScaledImage(new ImageIcon(ApplicationWindow.class.getResource(iconPath)), 35, 35));
		lab.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lab.setBounds(50, 40, 300, 40);

		contentPane.add(lab);
		addFrame.add(contentPane);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.pack();
		addFrame.setVisible(true);
	}

	/**
	 * Sub frame that pops when a user is added
	 */
	public void dialogFrameAdd() {
		dialogFrame("User Added Succefully!", "/icons/succes.png");
	}

	/**
	 * Sub frame that pops when a user is removed
	 */
	public void dialogFrameRemove() {
		dialogFrame("User Removed Succefully!", "/icons/succes.png");
	}

	/**
	 * Sub frame that pops when a user is removed
	 */
	public void dialogFrameUpdate() {
		dialogFrame("User Info Updated Succefully!", "/icons/succes.png");
	}

	/**
	 * Sub frame that pops when a user already exists in the database
	 */
	public void dialogFrameAddFailed() {
		dialogFrame("This User Already Exists!", "/icons/failure.png");
	}

	/**
	 * Sub frame that pops when a user does not exist in the database
	 */
	public void dialogFrameRemoveFailed() {
		dialogFrame("This User Does Not Exist!", "/icons/failure.png");
	}

	/**
	 * Sub frame that pops when no entry is given
	 */
	public void dialogFrameNoEntry() {
		dialogFrame("No Entry Detected!", "/icons/failure.png");

	}

	/**
	 * Sub frame that pops when an error happened
	 */
	public void dialogFrameError() {
		dialogFrame("An Error Has Occured!", "/icons/failure.png");

	}

}
