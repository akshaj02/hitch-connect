package code;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Customerstats {
    
    public static JFrame frame;
    public static JLabel label;
    public static JButton button1;
    public static JTextField textfield;
    public static String[] userAndPass = new String[2];

    public static boolean find_driver(String full_Name){
        int lineNumber = 0;
        boolean found = false;
        for(int i = 0; i < fileFunctions.numberOfLines("customer.txt"); i++){
            try {
                String line = Files.readAllLines(Paths.get("otherFiles/customer.txt")).get(lineNumber);
                if(line.contains(full_Name)){
                    userAndPass = line.split(",");
                    found = true;
                    break;
                }
                else{
                    lineNumber++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return found;
    }
    public static void createCustomerFrame(){

        label = new JLabel("Enter Customer's full name: ");
        label.setFont(new Font("Helvetica", Font.PLAIN, 12));
        label.setBounds(450, 120, 250, 50);

        textfield = new JTextField();
        textfield.setBounds(450, 160, 250, 40);

        button1 = new JButton("Search");
        button1.setBounds(450, 220, 250, 40);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    if(find_driver(textfield.getText())){
                        JOptionPane.showMessageDialog(null, "Customer found: " + userAndPass[0] + " 's email address is " + userAndPass[1] + " and the customer's phone number is " + userAndPass[2]);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Customer not found!");
                    }
                }
            }
        });

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 750);
        frame.setTitle("Hitch Connect: ADMIN ACCESS");
        frame.setLayout(null);
        frame.setResizable(false);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("otherFiles/rider.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.add(textfield);
        frame.add(label);
        frame.add(button1);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
