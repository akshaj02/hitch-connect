import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.*;

public class Driverstats {
    
    public static JFrame frame;
    public static JTextField textfield;
    public static JButton button;
    public static JLabel label;
    public static JButton button1;
    public static String[] userAndPass = new String[2];

    public static boolean find_driver(String full_Name){
        int lineNumber = 0;
        boolean found = false;
        for(int i = 0; i < fileFunctions.numberOfLines("driverInfo.txt"); i++){
            try {
                String line = Files.readAllLines(Paths.get("otherFiles/driverInfo.txt")).get(lineNumber);
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

    public static void createDriverFrame(){

        label = new JLabel("Enter Driver's full name: ");
        label.setFont(new Font("Helvetica", Font.PLAIN, 12));
        label.setBounds(50, 120, 250, 50);

        textfield = new JTextField();
        textfield.setBounds(50, 160, 250, 40);

        button1 = new JButton("Search");
        button1.setBounds(50, 220, 250, 40);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    if(find_driver(textfield.getText())){
                        JOptionPane.showMessageDialog(null, "Driver found: " + userAndPass[0] + " drives a " + userAndPass[1] + " and the car had the following license plate: " + userAndPass[2]);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Driver not found!");
                    }
                    frame.dispose();
                }
            }
        });

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 750);
        frame.setTitle("Hitch Connect: ADMIN ACCESS- DRIVER STATS");
        frame.setLayout(null);
        frame.setResizable(false);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("otherFiles/driverBackground.jpeg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.getRootPane().setDefaultButton(button1);

        frame.add(textfield);
        frame.add(label);
        frame.add(button1);
        frame.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        createDriverFrame();
    }
}
