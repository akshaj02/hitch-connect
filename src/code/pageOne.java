package code;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class pageOne extends JFrame {

    static String username;
    static String pass;
    static JButton button;
    static JButton registerButton;
    static JTextField userName;
    static JPasswordField password;

    public pageOne() {
        super("Hitch Connect");
        setSize(1120, 750);

        setLayout(null);

        JTextField userName = new JTextField("Email");
        userName.setBounds(800, 375, 200, 30);
        userName.setFont(new Font("Helvetica", Font.PLAIN, 14));
        userName.setForeground(Color.gray);
        userName.setBackground(Color.white);
        userName.setBorder(BorderFactory.createLineBorder(Color.white));
        add(userName);
        // action listner for text field clicked
        userName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userName.setText("");
                userName.setForeground(Color.gray);
            }
        });

        JPasswordField password = new JPasswordField("Password");
        password.setBounds(800, 425, 200, 30);
        password.setFont(new Font("Helvetica", Font.PLAIN, 14));
        password.setForeground(Color.gray);
        password.setBackground(Color.white);
        password.setBorder(BorderFactory.createLineBorder(Color.white));
        add(password);
        // action listner for password field clicked
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                password.setText("");
                password.setForeground(Color.gray);
            }
        });

        JRadioButton showPassword = new JRadioButton();
        showPassword.setBounds(1000, 425, 20, 30);
        //set icon for show password button
        ImageIcon showPasswordIcon = new ImageIcon("otherFiles/showPass1.png");
        showPassword.setIcon(showPasswordIcon);
        showPassword.setOpaque(false);

        add(showPassword);

        // action listner for show password button clicked
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (showPassword.isSelected()) {
                    password.setEchoChar((char) 0);
                    ImageIcon showPasswordIcon = new ImageIcon("otherFiles/stopPass.png");
                    showPassword.setIcon(showPasswordIcon);
                } else {
                    password.setEchoChar('\u2022');
                    ImageIcon showPasswordIcon = new ImageIcon("otherFiles/showPass1.png");
                    showPassword.setIcon(showPasswordIcon);
                }
            }
        });

        JButton button = new JButton("Sign in");
        button.setFont(new Font("Helvetica", Font.BOLD, 14));
        button.setBounds(800, 475, 200, 30);
        button.setBackground(Color.decode("#03A99E"));
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#03A99E")));
        button.setForeground(Color.white);
        add(button);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        registerButton.setForeground(Color.white);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#03A99E")));
        registerButton.setBounds(800, 525, 200, 30);
        registerButton.setBackground(Color.decode("#03A99E"));
        add(registerButton);

        JLabel bgPic = new JLabel(new ImageIcon("otherFiles/page.png"));
        bgPic.setBounds(0, 0, 1100, 700);
        add(bgPic);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // action listner for button clicked
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username = userName.getText();
                pass = String.valueOf(password.getPassword());

                boolean loginSuccessUser = false;
                boolean adminSuccess = false;
                boolean loginSuccessDriver = false;
                for (int i = 0; i < fileFunctions.numberOfLines("login.txt"); i++) {
                    if ((username.equals("adminAk") && pass.equals("adminAk")) || 
                        (username.equals("adminYash") && pass.equals("adminYash")) || 
                        (username.equals("adminSomil") && pass.equals("adminSomil")) ||
                        (username.equals("adminAz") && pass.equals("adminAz")) ||
                        (username.equals("adminAs") && pass.equals("adminAs"))) {
                        //System.out.println(fileFunctions.readFile("login.txt", 0, i) + " " + fileFunctions.readFile("login.txt", 1, i));
                        adminSuccess = true;
                        new AdminPage();

                        break;
                    }
                    if (fileFunctions.readFile("login.txt", 0, i).equals(username)
                            && fileFunctions.readFile("login.txt", 1, i).equals(pass)) {
                        // new pageTwo();

                        String email = fileFunctions.readFile("login.txt", 0, i);
                        String[] temp = email.split("@");
                        if(temp[1].equals("hitchconnect.com")){
                            loginSuccessDriver = true;
                        }
                        loginSuccessUser = true;
                        break;
                    } 
                    else{
                        loginSuccessUser = false;
                    }
                }

                if (loginSuccessUser && !adminSuccess && !loginSuccessDriver) {
                    // JOptionPane.showMessageDialog(null, "Welcome " + username);
                    try {
                        new location();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
                if (adminSuccess && !loginSuccessUser && !loginSuccessDriver) {
                    // JOptionPane.showMessageDialog(null, "Welcome Admin");
                    new AdminPage();
                } 
                if (loginSuccessDriver && !adminSuccess && loginSuccessUser) {
                    new driverPage();
                }
                if(!loginSuccessUser && !adminSuccess && !loginSuccessDriver){ 

                    JOptionPane.showMessageDialog(null, "Username or password incorrect");
                    userName.setText("");
                    password.setText("");
                }

                if (username.equals("") || pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter a username and password");
                }
            }
        });

        getRootPane().setDefaultButton(button);

        // action listner for register button clicked
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new newUserRegistration();
            }
        });

        fileFunctions.setIcon(this);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new pageOne();
    }

}
