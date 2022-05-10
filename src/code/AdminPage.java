package code;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class AdminPage {

    private JFrame frame;
    private JPanel panel;
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private ImageIcon image;
    public AdminPage() {
        
        //buttons
        button1 = new JButton("Driver Stats");
        button1.setBounds(25, 60, 250, 40);
        button1.setBackground(Color.decode("#03A99E"));
        button1.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF")));
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (e.getSource() == button1) {
                Driverstats.createDriverFrame();
               }
            }
         });

        button2 = new JButton("Rider Stats");
        button2.setBounds(25, 150, 250, 40);
        button2.setBackground(Color.decode("#03A99E"));
        button2.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF")));
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (e.getSource() == button2) {
                Customerstats.createCustomerFrame();
               }
            }
         });

        //labels
        label1 = new JLabel("SELECT ACTION: ");
        label1.setFont(new Font("Helvetica", Font.PLAIN, 16));
        label1.setForeground(Color.decode("#FFFFFF"));
        label1.setBounds(515, 260, 180, 40);

        label2 = new JLabel("WELCOME ADMIN!");
        label2.setFont(new Font("Helvetica", Font.PLAIN, 60));
        label2.setBounds(340, 30, 650, 150);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        panel.setBounds(430, 250, 300, 350);
        // panel.border(Color.BLACK);

        frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 750);
        frame.setTitle("Hitch Connect: ADMIN ACCESS");
        frame.setLayout(null);
        frame.setResizable(false);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("otherFiles/adminPage.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(label1);
        frame.add(panel);
        frame.add(label2);

        panel.add(button1);
        panel.add(button2);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        image = new ImageIcon("otherFiles/adminLogo.png");     
        frame.setIconImage(image.getImage());
    }
    
    
}
