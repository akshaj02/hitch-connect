package code;

import javax.swing.*;

import java.awt.*;



public class newUserRegistration extends fileFunctions {
    public newUserRegistration() {
        //fileFunctions.writeFile(username, pass);
        JFrame newUser = new JFrame("New User Registration");
        newUser.setSize(400, 400);
        newUser.setLayout(null);
        newUser.setLocationRelativeTo(null);

        JTextField newUserName = new JTextField("Email");
        newUserName.setBounds(100, 100, 200, 30);
        newUserName.setFont(new Font("Helvetica", Font.PLAIN, 14));
        newUserName.setForeground(Color.gray);
        newUserName.setBackground(Color.white);
        newUserName.setBorder(BorderFactory.createLineBorder(Color.white));
        newUser.add(newUserName);
        //action listner for text field clicked
        newUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newUserName.setText("");
                newUserName.setForeground(Color.gray);
            }
        });

        JPasswordField newPassword = new JPasswordField("Password");
        newPassword.setBounds(100, 150, 200, 30);
        newPassword.setFont(new Font("Helvetica", Font.PLAIN, 14));
        newPassword.setForeground(Color.gray);
        newPassword.setBackground(Color.white);
        newPassword.setBorder(BorderFactory.createLineBorder(Color.white));
        newUser.add(newPassword);
        //action listner for password field clicked
        newPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newPassword.setText("");
                newPassword.setForeground(Color.gray);
            }
        });

        fileFunctions.showPassword(newUser, newPassword, 300, 150);

        JButton register = new JButton("Register");
        register.setFont(new Font("Helvetica", Font.BOLD, 14));
        register.setBounds(100, 200, 200, 30);
        register.setBackground(Color.decode("#03A99E"));
        newUser.add(register);

        //action listner for register button clicked
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String newUsername = newUserName.getText();
                String newPass = String.valueOf(newPassword.getPassword());

                if (newUsername.equals("") || newPass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a username and password");
                } else {
                    fileFunctions.writeFile("login.txt", newUsername, newPass);
                    JOptionPane.showMessageDialog(null, "Registration Successful");
                    newUser.dispose();
                }
            }
        });

        newUser.getRootPane().setDefaultButton(register);
        newUser.setVisible(true);

        fileFunctions.setIcon(newUser);
        //newUser.dispose();
            
    }

    public static void main(String[] args) {
        new newUserRegistration();
    }
    
}
