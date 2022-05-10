
package code;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class JtableColor extends JFrame {
   private JTable table;
   public static ArrayList<String> name = new ArrayList<String>();
   public static ArrayList<String> model = new ArrayList<String>();
   public static ArrayList<String> price = new ArrayList<String>();

   public static String driverName;
   public static String carModel;
   public static String fare;

   public JtableColor() {

      setTitle("Select your ride option");
      // JTable Headers
      readFile("info.txt");
      String[] columns = new String[] { "Name", "Car Model", "Price" };

      DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
      for (int i = 0; i < name.size(); i++) {
         tableModel.addRow(new Object[] { name.get(i), model.get(i), price.get(i) });
      }

      table = new JTable(tableModel);
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment(JLabel.CENTER);
      for (int k = 0; k < table.getColumnCount(); k++) {
         table.getColumnModel().getColumn(k).setCellRenderer(centerRenderer);
      }
      JLabel l1 = new JLabel("Select your ride option");
      Font bigFont = new Font("sansserif", Font.BOLD, 20);
      Font bigFont3 = new Font("sansserif", Font.PLAIN, 16);
      JButton b = new JButton("Proceed to Payment");
      table.getTableHeader().setFont(bigFont);
      JTableHeader th = table.getTableHeader();
      th.setPreferredSize(new Dimension(100, 100));
      th.setBackground(Color.WHITE);
      th.setBorder(BorderFactory.createLineBorder(Color.BLUE));
      table.setGridColor(Color.BLUE);

      table.setRowHeight(30);
      table.setRowHeight(60);
      b.setBounds(750, 600, 300, 50);
      table.setFont(bigFont3);
      JPanel p1 = new JPanel();
      l1.setFont(bigFont);
      p1.add(l1, BorderLayout.CENTER);
      add(p1, BorderLayout.PAGE_START);
      add(b);
      add(new JScrollPane(table), BorderLayout.CENTER);
      setSize(1120, 750);
      b.addActionListener(new ClickListener());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
      // this.dispose();
   }

   public static void main(String[] args) {
      new JtableColor();
   }

   class ClickListener implements ActionListener { // added this
      int delay = 4700;

      public void actionPerformed(ActionEvent e) {

         int rowno = table.getSelectedRow();
         driverName = table.getValueAt(rowno, 0).toString();
         carModel = table.getValueAt(rowno, 1).toString();
         fare = table.getValueAt(rowno, 2).toString();
         try {
            new payment();
         } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
      }

   }

   public static void writeFile(String fileName, String name, String model, String price) {
      try {
         Files.write(Paths.get("otherFiles/" + fileName), (name + "," + model + "," + price + "\n").getBytes(),
               StandardOpenOption.APPEND);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void readFile(String fileName) {
      try {
         File myObj = new File("otherFiles/info.txt"); // creating a file object with this filename
         System.out.println("Attempting to read from file in: " + myObj.getCanonicalPath());
         Scanner inFile = new Scanner(myObj); // notice Scanner is no longer System.in, its now the file we are reading
                                              // from
         while (inFile.hasNextLine()) { // we can use methods from the Scanner class...
            String info = inFile.nextLine();
            String[] tempinfo = info.split(",");// we�re getting each line of the file and printing
            name.add(tempinfo[0]);
            model.add(tempinfo[1]);
            price.add(tempinfo[2]);
         }
         inFile.close(); // we�re closing the connection to the file

      } catch (Exception e) { // I specified the type of exception here
         System.out.println("Here is what happened: " + e);
      }
   }
}
