package code;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class location extends JFrame {
    
    static String location;
    static String destination;
    
    public location() throws IOException {
        super("location");
        String[] optionsToChoose = {"Allen","Arlington","Carrollton","Cedar Hill","Coppell","Dallas",
        "Denton","Duncanville","Euless","Flower Mound","Forest Hill","Fort Worth","Frisco",
        "Garland","Grand Praire","Grapevine","Haltom City","Hillsboro","Hurst","Irving",
        "Keller","Lewisville","McKinney","Mesquite","North Richland Hills","Plano","Richardson","Southlake"};
        
        setSize(1120, 750);
        setLayout(null);

        JLabel question = new JLabel("Enter your current location");
        question.setBounds(370, 80, 500, 34);
        question.setFont(new java.awt.Font("Arial", 1, 30));
        question.setForeground(Color.black);
        add(question);

        JTextField currloc = new JTextField();
        currloc.setBounds(290, 140, 240, 34);
        currloc.setFont(new Font("Helvetica", Font.PLAIN, 20));
        //currloc.setBackground(new Color(0, 0, 0, 0));
        currloc.setOpaque(false);
        currloc.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        currloc.setForeground(Color.white);

        add(currloc);

        JComboBox<String> combo = new JComboBox<String>(optionsToChoose);
        combo.setBounds(590, 140, 240, 34);
        combo.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(combo);

        JLabel destination = new JLabel("Enter your destination");
        destination.setBounds(410, 250, 500, 34);
        destination.setFont(new java.awt.Font("Arial", 1, 30));
        destination.setForeground(Color.white);
        add(destination);

        JTextField dtext = new JTextField();
        dtext.setBounds(290, 310, 240, 34);
        dtext.setFont(new Font("Helvetica", Font.PLAIN, 20));
        dtext.setOpaque(false);
        dtext.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        dtext.setForeground(Color.white);
        add(dtext);

        JComboBox<String> combo2 = new JComboBox<String>(optionsToChoose);
        combo2.setBounds(590, 310, 240, 34);
        combo2.setFont(new Font("Helvetica", Font.PLAIN, 20));
        add(combo2);

        JButton search = new JButton("Search for rides");
        search.setFont(new java.awt.Font("Arial", 1, 24));
        search.setBounds(430, 450, 250, 40);
        search.setBackground(Color.decode("#03A99E"));
        search.setForeground(Color.white);
        add(search);

        // actionlistener for button pressed
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // get text from combobox
                String location = combo.getSelectedItem().toString();
                String destination = combo2.getSelectedItem().toString();
                System.out.println(location);
                System.out.println(destination);
                fileFunctions.writeFile("riderInfo.txt", pageOne.username, location, destination);

                try {
                    loading.loadingSFR();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        getRootPane().setDefaultButton(search);

        JLabel bgPic = new JLabel(new ImageIcon("otherFiles/popo2.png"));
        bgPic.setBounds(0, 0, 1106, 728);
        add(bgPic);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) throws Exception {
        new location();
    }
}