package code;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class confirm {
	public static String name;
	public static String Jlocation;
	public static String destination2;
	public static String id;
	public static String cardNumString;
	public static String drivername;
	public static String make;
	public static String model1;
	public static JLabel discover;
	public static JLabel visa;
	public static JLabel mastercard;
	public static JLabel amex;

	public static ArrayList<String> price1 = new ArrayList<String>();

	public confirm() {
		Font bigFont = new Font("sansserif", Font.BOLD, 20);
		//readFile1("riderInfo.txt");
		JFrame frame = new JFrame("Confirm");
		frame.setSize(1120, 750);

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel j = new JLabel("Confirmation");
		j.setFont(bigFont);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		p.add(j);

		JLabel confirm = new JLabel("Ride Confirmation");
		confirm.setBounds(425, 50, 270, 30);
		confirm.setFont(new Font("Helvetica", Font.BOLD, 30));
		frame.add(confirm);


		JLabel discover = new JLabel(new ImageIcon("otherFiles/discover.png"));
		discover.setBounds(140, 305, 60, 40);
		discover.setVisible(false);
		frame.add(discover);

		JLabel mastercard = new JLabel(new ImageIcon("otherFiles/mastercard.png"));
		mastercard.setBounds(140, 305, 60, 40);
		mastercard.setVisible(false);
		frame.add(mastercard);

		JLabel visa = new JLabel(new ImageIcon("otherFiles/visa.png"));
		visa.setBounds(140, 305, 60, 40);
		visa.setSize(60, 40);
		visa.setVisible(false);
		frame.add(visa);
		
		JLabel amex = new JLabel(new ImageIcon("otherFiles/amex.png"));
		amex.setBounds(140, 305, 60, 40);
		amex.setVisible(false);
		frame.add(amex);
		
		try {
			File myObj = new File("otherFiles/riderInfo.txt"); // creating a file object with this filename
			System.out.println("Attempting to read from file in: " + myObj.getCanonicalPath());
			Scanner inFile = new Scanner(myObj); // notice Scanner is no longer System.in, its now the file we are reading from
			while (inFile.hasNextLine()) { // we can use methods from the Scanner class...
				String info = inFile.nextLine();
				String[] tempinfo = info.split(",");// we�re getting each line of the file and printing
				name = tempinfo[0];
				Jlocation = tempinfo[1];
				destination2 = tempinfo[2];
				id = tempinfo[3];
				String temp[] = id.split("(?!^)");

				cardNumString = temp[12] + temp[13] + temp[14] + temp[15];

				drivername = tempinfo[4];
				make = tempinfo[5];
				model1 = tempinfo[6];
				if (temp[0].equals("3")) {
					amex.setVisible(true);
					discover.setVisible(false);
					mastercard.setVisible(false);
					visa.setVisible(false);

				}
				if (temp[0].equals("4")) {
					visa.setVisible(true);
					discover.setVisible(false);
					mastercard.setVisible(false);
					amex.setVisible(false);

				}
				if (temp[0].equals("5")) {
					mastercard.setVisible(true);
					discover.setVisible(false);
					amex.setVisible(false);
					visa.setVisible(false);
				}
				if (temp[0].equals("6")) {
					discover.setVisible(true);
					mastercard.setVisible(false);
					amex.setVisible(false);
					visa.setVisible(false);
				}
				// price1=tempinfo[7];
			}

			inFile.close();

		} catch (Exception e) { // I specified the type of exception here
			System.out.println("Here is what happened: " + e);
		}

		int i = fileFunctions.numberOfLines("riderInfo.txt") - 1;
		name = fileFunctions.readFile("riderInfo.txt", 0, i);
		Jlocation = fileFunctions.readFile("riderInfo.txt", 1, i);
		destination2 = fileFunctions.readFile("riderInfo.txt", 2, i);
		id = fileFunctions.readFile("riderInfo.txt", 3, i);
		drivername = fileFunctions.readFile("riderInfo.txt", 4, i);
		make = fileFunctions.readFile("riderInfo.txt", 5, i);
		model1 = fileFunctions.readFile("riderInfo.txt", 6, i);
		
		JLabel driver = new JLabel("Username: " + name, SwingConstants.LEFT);
		driver.setBounds(30, 200, 500, 50);
		driver.setFont(new Font("Helvetica", Font.PLAIN, 20));
		driver.setForeground(Color.darkGray);
		frame.add(driver);

		JLabel location = new JLabel("Location: " + Jlocation, SwingConstants.LEFT);
		location.setBounds(30, 250, 250, 50);
		location.setFont(new Font("Helvetica", Font.PLAIN, 20));
		location.setForeground(Color.darkGray);
		frame.add(location);

		JLabel destination = new JLabel("Destination: " + destination2, SwingConstants.LEFT);
		destination.setBounds(750, 200, 250, 50);
		destination.setFont(new Font("Helvetica", Font.PLAIN, 20));
		destination.setForeground(Color.darkGray);
		frame.add(destination);

		JLabel id1 = new JLabel("Paying with: ");
		id1.setBounds(30, 300, 113, 50);
		id1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		id1.setForeground(Color.darkGray);
		frame.add(id1);

		JLabel id2 = new JLabel("ending in " + cardNumString);
		id2.setBounds(210, 300, 200, 50);
		id2.setFont(new Font("Helvetica", Font.PLAIN, 20));
		id2.setForeground(Color.darkGray);
		frame.add(id2);

		JLabel drivername1 = new JLabel("Drivername : " + drivername, SwingConstants.RIGHT);
		drivername1.setBounds(640, 250, 250, 50);
		drivername1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		drivername1.setForeground(Color.darkGray);
		frame.add(drivername1);

		JLabel model = new JLabel("Fare: " + model1, SwingConstants.RIGHT);
		model.setBounds(605, 300, 250, 50);
		model.setFont(new Font("Helvetica", Font.PLAIN, 20));
		model.setForeground(Color.darkGray);
		frame.add(model);

		JLabel make1 = new JLabel("Car model: " + make, SwingConstants.LEFT);
		make1.setBounds(420, 300, 250, 50);
		make1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		make1.setForeground(Color.darkGray);
		frame.add(make1);

		JButton done = new JButton("Done");
		done.setBounds(30, 400, 100, 50);
		done.setFont(new Font("Helvetica", Font.PLAIN, 20));
		done.setForeground(Color.darkGray);
		done.setBackground(Color.white);
		frame.add(done);

		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new pageOne();
			}
		});

		frame.add(p, BorderLayout.PAGE_START);
		frame.add(p1, BorderLayout.CENTER);
		fileFunctions.setIcon(frame);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new confirm();
	}
}
