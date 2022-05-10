package code;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class driverPage {
    public driverPage() {
        JFrame frame = new JFrame("Driver");
        frame.setSize(1120, 750);
        frame.setLayout(null);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel j = new JLabel("Driver");
        j.setFont(new Font("Helvetica", Font.BOLD, 30));
        j.setBounds(510, 50, 100, 30);
        frame.add(j);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        //Baki sab add karde yash bhai bhai bhai


    }

    public static void main(String[] args) {
        new driverPage();
    }
    
}
