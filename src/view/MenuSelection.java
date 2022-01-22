package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSelection extends JPanel implements ActionListener {

    private final JLabel labCreateRes;
    private final JLabel labCreateDate;
    private final JLabel labFrom;
    private final JLabel labTo;
    private final JTextField textField_1;
    private final JTextField textField_2;
    private final JButton btnChoose;
    private DefaultTableModel model;
    private JTable table;
    private JTableHeader header;
    private JScrollPane scroll_table;
    private final JComponent labAvailable;

    public MenuSelection() {
        labCreateRes = new JLabel("Create a new Reservation:");
        labAvailable = new JLabel("Available Rooms");
        labCreateDate = new JLabel("Date");
        labFrom = new JLabel("From");
        labTo = new JLabel("To");
        textField_1 = new JTextField();
        textField_2 = new JTextField();
        btnChoose = new JButton("Choose");
    }

    public InternalPanel createPanSelection() {
        InternalPanel usersPan = new InternalPanel();
        usersPan.setLocation(0, 0);

        labCreateRes.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labCreateRes.setBounds(10, 10, 300, 22);
        usersPan.add(labCreateRes);

        labAvailable.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labAvailable.setBounds(10, 150, 300, 22);
        usersPan.add(labAvailable);

        labCreateDate.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labCreateDate.setBounds(10, 50, 197, 22);
        usersPan.add(labCreateDate);

        labFrom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labFrom.setBounds(100, 50, 100, 22);
        usersPan.add(labFrom);

        labTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labTo.setBounds(330, 50, 100, 22);
        usersPan.add(labTo);

        textField_1.setColumns(10);
        textField_1.setBackground(new Color(189, 183, 107));
        textField_1.setBounds(140, 50, 96, 20);
        usersPan.add(textField_1);

        textField_2.setBackground(new Color(189, 183, 107));
        textField_2.setBounds(360, 50, 96, 20);
        usersPan.add(textField_2);
        textField_2.setColumns(10);

        btnChoose.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnChoose.setBackground(new Color(189, 183, 107));
        btnChoose.setBounds(459, 120, 89, 23);
        btnChoose.addActionListener(this);
        usersPan.add(btnChoose);

        table = new JTable();
        model = new DefaultTableModel(30, 3);
        table.setModel(model);
        table.getColumnModel().getColumn(0).setHeaderValue("Room Id");
        table.getColumnModel().getColumn(1).setHeaderValue("Begin Time");
        table.getColumnModel().getColumn(2).setHeaderValue("End Time");
        table.getTableHeader().resizeAndRepaint();
        header = table.getTableHeader();
        header.setBackground(new Color(200, 150, 110));
        scroll_table = new JScrollPane(table);
        scroll_table.setBounds(5, 180, 570, 350);
        table.setBackground((new Color(189, 183, 107)));
        scroll_table.setVisible(true);
        usersPan.add(scroll_table);

        return usersPan;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
