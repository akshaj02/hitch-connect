package code;

import java.nio.file.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class fileFunctions {
    //file reader method
    public static String readFile(String fileName, int index, int lineNumber) {
        String loginDeets = "";
        String[] userAndPass = new String[2];
        try {
            String line = Files.readAllLines(Paths.get("otherFiles/" + fileName)).get(lineNumber);
            userAndPass = line.split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginDeets = userAndPass[index];
        return loginDeets;
    }

    //file writer method
    public static void writeFile(String fileName, String user, String pass) {
        try {
            Files.write(Paths.get("otherFiles/" + fileName), (user + "," + pass + "\n").getBytes(), 
            StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String user, String location, String destination) {
        try {
            Files.write(Paths.get("otherFiles/" + fileName), (user + "," + location + "," + destination+ ",").getBytes(), 
            StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String fileName, String cardNum, String driverName, String carModel, String fare){
        try {
            Files.write(Paths.get("otherFiles/" + fileName), (cardNum + "," + driverName + "," + carModel + "," + fare + "\n").getBytes(), 
            StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public static void writeFile(String fileName, String driver, String carModel){


    //number of lines in file
    public static int numberOfLines(String fileName) {
        int numberOfLines = 0;
        try {
            numberOfLines = Files.readAllLines(Paths.get("otherFiles/" + fileName)).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfLines;
    }

    //icon for all frames
    public static void setIcon(JFrame frame) {
        ImageIcon icon = new ImageIcon("otherFiles/icon.png");
        frame.setIconImage(icon.getImage());
    }
    
    //show Password
    public static void showPassword(JFrame frame, JPasswordField newPassword, int x, int y) {
        JRadioButton showPassword = new JRadioButton();
        showPassword.setBounds(x, 150, 20, 30);
        //set icon for show password button
        ImageIcon showPasswordIcon = new ImageIcon("otherFiles/showPass1.png");
        showPassword.setIcon(showPasswordIcon);
        showPassword.setOpaque(false);

        frame.add(showPassword);

        // action listner for show password button clicked
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (showPassword.isSelected()) {
                    //System.out.println("button clicked");
                    newPassword.setEchoChar((char) 0);
                    ImageIcon newPasswordIcon = new ImageIcon("otherFiles/stopPass.png");
                    showPassword.setIcon(newPasswordIcon);
                } else {
                    //System.out.println("button not clicked");
                    newPassword.setEchoChar('\u2022');
                    ImageIcon showPasswordIcon = new ImageIcon("otherFiles/showPass1.png");
                    showPassword.setIcon(showPasswordIcon);

                }
            }
        });
    }

}
