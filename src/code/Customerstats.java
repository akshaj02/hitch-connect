import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class Customerstats {
    
    public static JFrame frame;
    public static void createCustomerFrame(){

        frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1120, 750);
        frame.setTitle("Hitch Connect: ADMIN ACCESS");
        frame.setLayout(null);
        frame.setResizable(false);
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\somil\\Desktop\\Project\\Pictures\\driverBackground.jpeg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);

    }
}
