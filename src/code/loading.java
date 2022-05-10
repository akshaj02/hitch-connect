package code;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

import java.awt.event.*;
// import java.io.IOException;

public class loading {
    public static void loadingSFR() throws IOException {
        int delay;
        JLabel bgPic;
        JLabel loading;
        JFrame frame = new JFrame();
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(0);
        bar.setBounds(0, 700, 1110, 20);
        // bar.setStringPainted(true);
        bar.setFont(new Font("Serif", Font.BOLD, 25));
        bar.setForeground(Color.decode("#03A99E"));
        bar.setBackground(Color.white);
        frame.add(bar);
        loading = new JLabel("Searching for Rides...");
        loading.setBounds(310, 630, 800, 60);
        loading.setFont(new Font("Poppins", Font.BOLD, 50));
        loading.setForeground(Color.black);
        frame.add(loading);
        bgPic = new JLabel(new ImageIcon("otherFiles/carload3.gif"));
        bgPic.setBounds(0, 0, 1120, 750);
        frame.add(bgPic);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 750);
        // frame.setLayout(null);
        // frame.setLayout(new FlowLayout());
        fileFunctions.setIcon(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        delay = 5000;

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // new location();
                frame.dispose();
                new JtableColor(); //ABBAS PART OF THE CODE
            }
        };
        Timer myTimer = new Timer(delay, taskPerformer);
        myTimer.start();
        myTimer.setRepeats(false);

        bar.setString("Done! :)");
    }

    public static void loadingPP() throws IOException {
        JLabel bgPic;
        JLabel loading;
        JFrame frame = new JFrame();
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(0);
        bar.setBounds(0, 700, 1110, 20);
        // bar.setStringPainted(true);
        bar.setFont(new Font("Serif", Font.BOLD, 25));
        bar.setForeground(Color.decode("#03A99E"));
        bar.setBackground(Color.white);
        frame.add(bar);
        // Add a label for payment processing
        loading = new JLabel("Processing Payment...");
        loading.setBounds(310, 630, 700, 60);
        loading.setFont(new Font("Poppins", Font.BOLD, 50));
        loading.setForeground(Color.black);
        frame.add(loading);
        bgPic = new JLabel(new ImageIcon("otherFiles/payloading.gif"));
        bgPic.setBounds(0, 0, 1120, 750);
        frame.add(bgPic);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 750);
        // frame.setLayout(null);
        // frame.setLayout(new FlowLayout());
        fileFunctions.setIcon(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        int delay = 4700;
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // new location();
                frame.dispose();
                new confirm();
            }
        };
        Timer myTimer = new Timer(delay, taskPerformer);
        myTimer.start();
        myTimer.setRepeats(false);

        bar.setString("Done! :)");
        //Exits the program
    }
}