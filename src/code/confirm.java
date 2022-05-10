import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class confirm {
	public static String driver1;
	public static String destination;
	public static String destination2;
	public static String id;
	public static String drivername;
	public static String make;
	public static String model1;

	public static ArrayList<String> price1 = new ArrayList<String>();

	public confirm() {
		Font bigFont = new Font("sansserif", Font.BOLD, 20);
		readFile1("riderInfo.txt");
		JFrame frame = new JFrame("Confirm");
		frame.setSize(1120, 750);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel j = new JLabel("Confirmation");
		j.setFont(bigFont);
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		p.add(j);

		JLabel driver = new JLabel("Driverid: " + driver1, SwingConstants.LEFT);
		driver.setBounds(30, 200, 250, 50);
		driver.setFont(new Font("Helvetica", Font.PLAIN, 20));
		driver.setForeground(Color.darkGray);
		frame.add(driver);

		JLabel destination1 = new JLabel("Destination : " + destination,
				SwingConstants.LEFT);
		destination1.setBounds(30, 250, 250, 50);
		destination1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		destination1.setForeground(Color.darkGray);
		frame.add(destination1);

		JLabel destination = new JLabel("Destination : " + destination2,
				SwingConstants.LEFT);
		destination.setBounds(750, 200, 250, 50);
		destination.setFont(new Font("Helvetica", Font.PLAIN, 20));
		destination.setForeground(Color.darkGray);
		frame.add(destination);

		JLabel id1 = new JLabel("id : " + id,
				SwingConstants.LEFT);
		id1.setBounds(30, 300, 250, 50);
		id1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		id1.setForeground(Color.darkGray);
		frame.add(id1);

		JLabel drivername1 = new JLabel("Drivername : " + drivername,
				SwingConstants.RIGHT);
		drivername1.setBounds(640, 250, 250, 50);
		drivername1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		drivername1.setForeground(Color.darkGray);
		frame.add(drivername1);
		JLabel model = new JLabel("Model : " + model1,
				SwingConstants.RIGHT);
		model.setBounds(605, 300, 250, 50);
		model.setFont(new Font("Helvetica", Font.PLAIN, 20));
		model.setForeground(Color.darkGray);
		frame.add(model);

		JLabel make1 = new JLabel("make : " + make,
				SwingConstants.LEFT);
		make1.setBounds(420, 300, 250, 50);
		make1.setFont(new Font("Helvetica", Font.PLAIN, 20));
		make1.setForeground(Color.darkGray);
		frame.add(make1);

		frame.add(p, BorderLayout.PAGE_START);
		frame.add(p1, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		new confirm();
	}

	public static void readFile1(String fileName) {

		try {
			File myObj = new File(fileName); // creating a file object with this filename
			System.out.println("Attempting to read from file in: " + myObj.getCanonicalPath());
			Scanner inFile = new Scanner(myObj); // notice Scanner is no longer System.in, its now the file we are
													// reading from
			while (inFile.hasNextLine()) { // we can use methods from the Scanner class...
				String info = inFile.nextLine();
				String[] tempinfo = info.split(",");// we�re getting each line of the file and printing
				driver1 = tempinfo[0];
				destination = tempinfo[1];
				destination2 = tempinfo[2];
				id = tempinfo[3];
				drivername = tempinfo[4];
				make = tempinfo[5];
				model1 = tempinfo[6];
				// price1=tempinfo[7];
			}

			inFile.close(); // we�re closing the connection to the file

		} catch (Exception e) { // I specified the type of exception here
			System.out.println("Here is what happened: " + e);
		}
	}
}
