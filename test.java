import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.*;
import javax.swing.JPanel;
public class test extends javax.swing.JFrame {
   Image img = Toolkit.getDefaultToolkit().getImage("page.png");
   public test() throws IOException {  
      this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(img, 0, 0, this);

         }
      });

     //Add a new panel for the login password with the location set and add panel
     //there
      JTextField userName = new JTextField(15);
      userName.setBounds(500, 500, 100, 20);
      add(userName);
      JPasswordField password = new JPasswordField(15); 
      add(password);

      
      //pack();
      setSize(755,505);
      setVisible(true);
      setLocationRelativeTo(null);
      setResizable(false);
      //exit
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public static void main(String[] args) throws Exception {
      new test();
   }
}