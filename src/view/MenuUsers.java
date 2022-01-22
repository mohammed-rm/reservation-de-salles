package view;

import controller.DAO.UserDAO;
import controller.HibernateUtils;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class MenuUsers extends JPanel implements ActionListener {
    JLabel labCreateUser;
    JLabel labDeleteUser;
    JLabel labUpdateUser;
    JLabel labCreateId;
    JLabel labDeleteId;
    JLabel labUpdateId;
    JLabel labCreateFirstName;
    JLabel labDeleteFirstName;
    JLabel labUpdateFirstName;
    JLabel labCreateLastName;
    JLabel labDeleteLastName;
    JLabel labUpdateLastName;
    JLabel labNewFirstName;
    JLabel labNewLastName;

    JButton btnCreate;
    JButton btnDelete;
    JButton btnUpdate;

    JTextField textField_1;
    JTextField textField_2;
    JTextField textField_3;
    JTextField textField_4;
    JTextField textField_5;
    JTextField textField_6;
    JTextField textField_7;
    JTextField textField_8;
    JTextField textField_9;
    JTextField textField_10;
    JTextField textField_11;

    /**
     * Class constructor
     */
    public MenuUsers() {
        labCreateUser = new JLabel("Create a new user:");
        labDeleteUser = new JLabel("Delete an existing user:");
        labUpdateUser = new JLabel("Update first name or last name:");
        labCreateId = new JLabel("User ID");
        labDeleteId = new JLabel("User ID");
        labUpdateId = new JLabel("User ID");
        labCreateFirstName = new JLabel("First Name");
        labDeleteFirstName = new JLabel("First Name");
        labUpdateFirstName = new JLabel("First Name");
        labCreateLastName = new JLabel("Last Name");
        labDeleteLastName = new JLabel("Last Name");
        labUpdateLastName = new JLabel("Last Name");
        labNewFirstName = new JLabel("To");
        labNewLastName = new JLabel("To");
        btnCreate = new JButton("Confirm");
        btnDelete = new JButton("Confirm");
        btnUpdate = new JButton("Confirm");
        textField_1 = new JTextField();
        textField_2 = new JTextField();
        textField_3 = new JTextField();
        textField_4 = new JTextField();
        textField_5 = new JTextField();
        textField_6 = new JTextField();
        textField_7 = new JTextField();
        textField_8 = new JTextField();
        textField_9 = new JTextField();
        textField_10 = new JTextField();
        textField_11 = new JTextField();

    }

    /**
     * Method to build the users section
     *
     * @return homePan
     */
    public InternalPanel createPanUsers() {
        InternalPanel usersPan = new InternalPanel();

        usersPan.setLocation(0, 0);
        labCreateUser.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labCreateUser.setBounds(10, 10, 150, 22);
        usersPan.add(labCreateUser);

        labDeleteUser.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labDeleteUser.setBounds(10, 180, 197, 22);
        usersPan.add(labDeleteUser);

        labUpdateUser.setFont(new Font("Times New Roman", Font.BOLD, 18));
        labUpdateUser.setBounds(10, 350, 250, 22);
        usersPan.add(labUpdateUser);

        labCreateId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labCreateId.setBounds(20, 40, 108, 14);
        usersPan.add(labCreateId);

        labDeleteId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labDeleteId.setBounds(20, 210, 108, 14);
        usersPan.add(labDeleteId);

        labUpdateId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labUpdateId.setBounds(20, 380, 108, 14);
        usersPan.add(labUpdateId);

        labCreateFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labCreateFirstName.setBounds(20, 80, 108, 14);
        usersPan.add(labCreateFirstName);

        labDeleteFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labDeleteFirstName.setBounds(20, 250, 108, 14);
        usersPan.add(labDeleteFirstName);

        labUpdateFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labUpdateFirstName.setBounds(20, 420, 108, 14);
        usersPan.add(labUpdateFirstName);

        labCreateLastName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labCreateLastName.setBounds(20, 120, 108, 14);
        usersPan.add(labCreateLastName);

        labDeleteLastName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labDeleteLastName.setBounds(20, 290, 108, 14);
        usersPan.add(labDeleteLastName);

        labUpdateLastName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labUpdateLastName.setBounds(20, 460, 108, 14);
        usersPan.add(labUpdateLastName);

        labNewFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labNewFirstName.setBounds(240, 420, 26, 14);
        usersPan.add(labNewFirstName);

        labNewLastName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        labNewLastName.setBounds(240, 460, 26, 14);
        usersPan.add(labNewLastName);

        btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnCreate.setBackground(new Color(189, 183, 107));
        btnCreate.setBounds(459, 120, 89, 23);
        btnCreate.addActionListener(this);
        usersPan.add(btnCreate);

        btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnDelete.setBackground(new Color(189, 183, 107));
        btnDelete.setBounds(459, 290, 89, 23);
        btnDelete.addActionListener(this);
        usersPan.add(btnDelete);

        btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnUpdate.setBackground(new Color(189, 183, 107));
        btnUpdate.setBounds(459, 460, 89, 23);
        btnUpdate.addActionListener(this);
        usersPan.add(btnUpdate);

        textField_1.setColumns(10);
        textField_1.setBackground(new Color(189, 183, 107));
        textField_1.setBounds(108, 38, 96, 20);
        usersPan.add(textField_1);

        textField_2.setBackground(new Color(189, 183, 107));
        textField_2.setBounds(108, 78, 96, 20);
        usersPan.add(textField_2);
        textField_2.setColumns(10);

        textField_3.setColumns(10);
        textField_3.setBackground(new Color(189, 183, 107));
        textField_3.setBounds(108, 118, 96, 20);
        usersPan.add(textField_3);

        textField_4.setColumns(10);
        textField_4.setBackground(new Color(189, 183, 107));
        textField_4.setBounds(108, 208, 96, 20);
        usersPan.add(textField_4);

        textField_5.setColumns(10);
        textField_5.setBackground(new Color(189, 183, 107));
        textField_5.setBounds(108, 248, 96, 20);
        usersPan.add(textField_5);

        textField_6.setColumns(10);
        textField_6.setBackground(new Color(189, 183, 107));
        textField_6.setBounds(108, 288, 96, 20);
        usersPan.add(textField_6);

        textField_7.setColumns(10);
        textField_7.setBackground(new Color(189, 183, 107));
        textField_7.setBounds(108, 378, 96, 20);
        usersPan.add(textField_7);

        textField_8.setColumns(10);
        textField_8.setBackground(new Color(189, 183, 107));
        textField_8.setBounds(108, 418, 96, 20);
        usersPan.add(textField_8);

        textField_9.setColumns(10);
        textField_9.setBackground(new Color(189, 183, 107));
        textField_9.setBounds(108, 458, 96, 20);
        usersPan.add(textField_9);

        textField_10.setColumns(10);
        textField_10.setBackground(new Color(189, 183, 107));
        textField_10.setBounds(276, 418, 96, 20);
        usersPan.add(textField_10);

        textField_11.setColumns(10);
        textField_11.setBackground(new Color(189, 183, 107));
        textField_11.setBounds(276, 458, 96, 20);
        usersPan.add(textField_11);

        return usersPan;
    }

    /**
     * Action to buttons
     *
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        HibernateUtils.init();
        UserDAO user = new UserDAO();
        DialogueFrame frame = new DialogueFrame();
        Object source = event.getSource();
        String inputId = "";
        String inputFName = "";
        String inputLName = "";
        String inputNewFName = "";
        String inputNewLName = "";
        int resultId;

        // If Confirm creation is clicked
        if (source == btnCreate) {
            try {
                // When an entry is given
                if (textField_1.getText().length() != 0 && textField_2.getText().length() != 0
                        && textField_3.getText().length() != 0) {
                    inputId = textField_1.getText();
                    inputFName = textField_2.getText();
                    inputLName = textField_3.getText();
                    boolean isNumber = Pattern.matches("[0-9]+", inputId);
                    boolean isFName = Pattern.matches("[a-zA-Z]+", inputFName);
                    boolean isLName = Pattern.matches("[a-zA-Z]+", inputFName);
                    // There is a valid entry
                    if (isNumber && isFName && isLName) {
                        resultId = Integer.parseInt(inputId);
                        if ((resultId >= 0)) {
                            User us = new User();
                            us.setIdUser(resultId);
                            us.setFirstName(inputFName);
                            us.setLastName(inputLName);
                            user.create(us);
                            frame.dialogFrameAdd();
                            HibernateUtils.close();
                        } else {
                            frame.dialogFrameAddFailed();
                        }
                    } else {
                        frame.dialogFrameError();
                    }
                } else {
                    frame.dialogFrameNoEntry();
                }
            } catch (Exception e) {
                frame.dialogFrameAddFailed();
            }
        }

        // If Confirm delete is clicked
        else if (source == btnDelete) {
            try {
                // When an entry is given
                if (textField_4.getText().length() != 0 && textField_5.getText().length() != 0
                        && textField_6.getText().length() != 0) {
                    inputId = textField_4.getText();
                    inputFName = textField_5.getText();
                    inputLName = textField_6.getText();
                    boolean isNumber = Pattern.matches("[0-9]+", inputId);
                    boolean isFName = Pattern.matches("[a-zA-Z]+", inputFName);
                    boolean isLName = Pattern.matches("[a-zA-Z]+", inputFName);
                    // There is a valid entry
                    if (isNumber && isFName && isLName) {
                        resultId = Integer.parseInt(inputId);
                        if ((resultId >= 0)) {
                            User us = new User();
                            us.setIdUser(resultId);
                            us.setFirstName(inputFName);
                            us.setLastName(inputLName);
                            user.delete(us);
                            frame.dialogFrameRemove();
                            HibernateUtils.close();
                        } else {
                            frame.dialogFrameRemoveFailed();
                        }
                    } else {
                        frame.dialogFrameError();
                    }
                } else {
                    frame.dialogFrameNoEntry();
                }
            } catch (Exception e) {
                frame.dialogFrameRemove();
            }
        }

        // If Confirm update is clicked
        else if (source == btnUpdate) {
            try {
                // When an entry is given
                if (textField_7.getText().length() != 0 && textField_8.getText().length() != 0
                        && textField_9.getText().length() != 0) {
                    inputId = textField_7.getText();
                    inputFName = textField_8.getText();
                    inputLName = textField_9.getText();
                    inputNewFName = textField_10.getText();
                    inputNewLName = textField_11.getText();
                    boolean isNumber = Pattern.matches("[0-9]+", inputId);
                    boolean isFName = Pattern.matches("[a-zA-Z]+", inputFName);
                    boolean isLName = Pattern.matches("[a-zA-Z]+", inputFName);
                    // There is a valid entry
                    if (isNumber && isFName && isLName) {
                        resultId = Integer.parseInt(inputId);
                        if ((resultId >= 0)) {
                            if (inputNewFName.length() != 0 && inputNewLName.length() == 0
                                    && Pattern.matches("[a-zA-Z]+", inputNewFName)) {
                                User us = new User();
                                us.setIdUser(resultId);
                                us.setFirstName(inputNewFName);
                                us.setLastName(inputLName);
                                user.update(us);
                                frame.dialogFrameUpdate();
                                HibernateUtils.close();
                            } else if (inputNewFName.length() == 0 && inputNewLName.length() != 0
                                    && Pattern.matches("[a-zA-Z]+", inputNewLName)) {
                                User us = new User();
                                us.setIdUser(resultId);
                                us.setFirstName(inputFName);
                                us.setLastName(inputNewLName);
                                user.update(us);
                                frame.dialogFrameUpdate();
                            } else if (inputNewFName.length() != 0 && inputNewLName.length() != 0
                                    && Pattern.matches("[a-zA-Z]+", inputNewFName)
                                    && Pattern.matches("[a-zA-Z]+", inputNewLName)) {
                                User us = new User();
                                us.setIdUser(resultId);
                                us.setFirstName(inputNewFName);
                                us.setLastName(inputNewLName);
                                user.update(us);
                                frame.dialogFrameUpdate();
                                HibernateUtils.close();
                            }
                        } else {
                            frame.dialogFrameError();
                        }
                    } else {
                        frame.dialogFrameError();
                    }
                } else {
                    frame.dialogFrameNoEntry();
                }
            } catch (Exception e) {
                frame.dialogFrameError();
            }
        }

    }
}
