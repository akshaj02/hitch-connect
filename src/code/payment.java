import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class payment {

    static String cardNumberString;
    static String cardNameString;
    static String expiryMonthString;
    static String expiryYearString;
    static String cardExpMonthexpiryMonthString;
    static String cardCvvString;
    static String[] temp;

    static boolean isRememberMe = false;

    public payment() throws IOException {

        JFrame frame = new JFrame("Payment");
        frame.setSize(1120, 750);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel discover = new JLabel(new ImageIcon("otherFiles/discover.png"));
        discover.setBounds(700, 250, 60, 40);
        discover.setVisible(false);
        frame.add(discover);

        JLabel mastercard = new JLabel(new ImageIcon("otherFiles/mastercard.png"));
        mastercard.setBounds(700, 250, 60, 40);
        mastercard.setVisible(false);
        frame.add(mastercard);

        JLabel visa = new JLabel(new ImageIcon("otherFiles/visa.png"));
        visa.setBounds(700, 250, 60, 40);
        visa.setSize(60, 40);
        visa.setVisible(false);
        frame.add(visa);

        JLabel amex = new JLabel(new ImageIcon("otherFiles/amex.png"));
        amex.setBounds(700, 250, 60, 40);
        amex.setVisible(false);
        frame.add(amex);

        JLabel text = new JLabel("Enter your payment details");
        text.setBounds(360, 50, 400, 50);
        text.setFont(new Font("Helvetica", Font.BOLD, 30));
        text.setForeground(Color.darkGray);
        frame.add(text);

        JTextField cardNumber = new JTextField("Card Number");
        cardNumber.setBounds(325, 250, 450, 50);
        cardNumber.setFont(new Font("Helvetica", Font.PLAIN, 20));
        cardNumber.setForeground(Color.darkGray);
        cardNumber.setColumns(16);
        cardNumber.setOpaque(false);
        cardNumber.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        frame.add(cardNumber);
        // action listner for text field clicked
        cardNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardNumber.setText("");
                cardNumber.setForeground(Color.darkGray);
            }
        });
        cardNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (cardNumber.getText().length() >= 16) {// limit to 3 characters
                    e.consume();
                } else {
                    cardNumberString = cardNumber.getText();
                }

            }
        });

        JTextField cardName = new JTextField("Name On Card");
        cardName.setBounds(325, 325, 450, 50);
        cardName.setFont(new Font("Helvetica", Font.PLAIN, 20));
        cardName.setForeground(Color.darkGray);
        cardName.setOpaque(false);
        cardName.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        frame.add(cardName);
        // action listner for text field clicked
        cardName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardName.setText("");
                cardName.setForeground(Color.darkGray);
                cardNumberString = cardNumber.getText();
                String[] temp = cardNumberString.split("(?!^)");
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
            }
        });
        cardName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (cardName.getText().length() >= 100) {// limit to 3 characters
                    e.consume();
                } else {
                    cardNameString = cardName.getText();
                }

            }
        });

        JTextField expiryMonth = new JTextField("MM");
        expiryMonth.setBounds(325, 400, 35, 50);
        expiryMonth.setFont(new Font("Helvetica", Font.PLAIN, 20));
        expiryMonth.setForeground(Color.darkGray);
        expiryMonth.setOpaque(false);
        expiryMonth.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        frame.add(expiryMonth);
        // action listner for text field clicked
        expiryMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiryMonth.setText("");
                expiryMonth.setForeground(Color.darkGray);

            }
        });
        expiryMonth.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (expiryMonth.getText().length() >= 2) {// limit to 3 characters
                    e.consume();
                } else {
                    expiryMonthString = expiryMonth.getText();
                }

            }
        });

        JLabel slash = new JLabel("/");
        slash.setBounds(370, 400, 10, 50);
        slash.setFont(new Font("Helvetica", Font.PLAIN, 30));
        slash.setForeground(Color.darkGray);
        frame.add(slash);

        JTextField expiryYear = new JTextField("YYYY");
        expiryYear.setBounds(385, 400, 57, 50);
        expiryYear.setFont(new Font("Helvetica", Font.PLAIN, 20));
        expiryYear.setForeground(Color.darkGray);
        expiryYear.setOpaque(false);
        expiryYear.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        frame.add(expiryYear);
        // action listner for text field clicked
        expiryYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiryYear.setText("");
                expiryYear.setForeground(Color.darkGray);

            }
        });
        expiryYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (expiryYear.getText().length() >= 4) {// limit to 3 characters
                    e.consume();
                } else {
                    expiryYearString = expiryYear.getText();
                }

            }
        });

        JPasswordField cvv = new JPasswordField("CVV");
        cvv.setBounds(595, 400, 180, 50);
        cvv.setFont(new Font("Helvetica", Font.PLAIN, 20));
        cvv.setForeground(Color.darkGray);
        cvv.setOpaque(false);
        cvv.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        frame.add(cvv);
        // action listner for password field clicked
        cvv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cvv.setText("");
                cvv.setForeground(Color.darkGray);
            }
        });


        
        // checkbox for remember me
        JCheckBox rememberMe = new JCheckBox("Remember my card");
        rememberMe.setBounds(325, 475, 200, 50);
        rememberMe.setFont(new Font("Helvetica", Font.PLAIN, 20));
        rememberMe.setForeground(Color.darkGray);
        rememberMe.setOpaque(false);
        frame.add(rememberMe);

        // action listener for remember me
        rememberMe.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e) {
                if (rememberMe.isSelected()) {
                    cardNameString = cardName.getText();
                    cardNumberString = cardNumber.getText();
                    cardCvvString = String.valueOf(cvv.getPassword());
                    String month = expiryMonth.getText();
                    String year = expiryYear.getText();
                    cardExpMonthexpiryMonthString = month + "/" + year;
                    fileFunctions.writeFile("card.txt", cardNumberString, cardExpMonthexpiryMonthString, cardCvvString,
                            cardNameString);
                } else {
                    isRememberMe = false;
                }
            }
        });
        // cvv.addKeyListener(new KeyAdapter() {
        //     @Override
        //     public void keyTyped(KeyEvent e) {
        //         if (((CharSequence) cvv).length() >= 3) {// limit to 3 characters
        //             e.consume();
        //         } else {
        //             expiryYearString = cvv.getText();
        //         }

        //     }
        // });

        // button for payment
        JButton payment = new JButton("Proceed");
        payment.setBounds(470, 600, 180, 50);
        payment.setFont(new Font("Helvetica", Font.PLAIN, 20));
        payment.setForeground(Color.white);
        payment.setBackground(Color.darkGray);
        // payment.setOpaque(true);
        payment.setBorder(BorderFactory.createLineBorder(Color.decode("#03A99E")));
        // payment.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.darkGray));
        frame.add(payment);

        // action listener for payment button
        payment.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    loading.loadingPP();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                // exit the program
                // if (cardNumberString.length() == 0 && cardNameString.length() == 0
                // && cardExpMonthexpiryMonthString.length() == 1 && cardCvvString.length() ==
                // 0) {
                // JOptionPane.showMessageDialog(null, "Please fill all the fields");
                // } else {
                // if (cardNumberString.length() < 16) {
                // JOptionPane.showMessageDialog(null, "Please enter a valid card number");
                // } else {
                // if (cardCvvString.length() < 3) {
                // JOptionPane.showMessageDialog(null, "Please enter a valid CVV");
                // } else {
                // if (cardExpMonthexpiryMonthString.length() < 6) {
                // JOptionPane.showMessageDialog(null, "Please enter a valid expiry date");
                // } else {
                // if (cardNameString.length() == 0) {
                // JOptionPane.showMessageDialog(null, "Please enter a valid card name");
                // } else {
                // // JOptionPane.showMessageDialog(null, "Payment Successful");
                // // new HomePage();
                // }
                // }
                // }
                // }
                // }
            }
        });

        JLabel background = new JLabel(new ImageIcon("otherFiles/paymentBg.png"));
        background.setBounds(-8, 0, 1120, 750);
        background.setVisible(true);
        frame.add(background);

        fileFunctions.setIcon(frame);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new payment();
    }

}
