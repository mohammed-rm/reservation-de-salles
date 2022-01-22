package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRooms extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JLabel labCreateRoom;
	private JLabel labDeleteRoom;
	private JLabel labCreateId;
	private JLabel labDeleteId;
	private JButton btnCreate;
	private JButton btnDelete;
	private JTextField textField_1;
	private JTextField textField_2;

	public MenuRooms() {
		labCreateRoom = new JLabel("Create a new room:");
		labDeleteRoom = new JLabel("Remove an existing room:");
		labCreateId = new JLabel("Room ID");
		labDeleteId = new JLabel("Room ID");
		btnCreate = new JButton("Confirm");
		btnDelete = new JButton("Confirm");
		textField_1 = new JTextField();
		textField_2 = new JTextField();
	}
	
	public InternalPanel createPanRooms() {
		InternalPanel usersPan = new InternalPanel();
		usersPan.setLocation(0, 0);
		
		labCreateRoom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labCreateRoom.setBounds(10, 10, 300, 22);
		usersPan.add(labCreateRoom);
		
		labDeleteRoom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labDeleteRoom.setBounds(10, 240, 300, 22);
		usersPan.add(labDeleteRoom);
		
		labCreateId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labCreateId.setBounds(20, 100, 108, 14);
		usersPan.add(labCreateId);

		labDeleteId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labDeleteId.setBounds(20, 320, 108, 14);
		usersPan.add(labDeleteId);
		
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreate.setBackground(new Color(189, 183, 107));
		btnCreate.setBounds(459, 180, 89, 23);
		btnCreate.addActionListener(this);
		usersPan.add(btnCreate);

		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(189, 183, 107));
		btnDelete.setBounds(459, 400, 89, 23);
		btnDelete.addActionListener(this);
		usersPan.add(btnDelete);
		
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(189, 183, 107));
		textField_1.setBounds(108, 98, 96, 20);
		usersPan.add(textField_1);

		textField_2.setBackground(new Color(189, 183, 107));
		textField_2.setBounds(108, 320, 96, 20);
		usersPan.add(textField_2);
		textField_2.setColumns(10);
		
		return usersPan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
