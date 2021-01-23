package gdimage;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GdImage {

    static public ImageIcon icon;

    static public JFrame frame;
    static public JPanel panel;
    static public JLabel label1;
    static public double schaal;
//    private static Object myCurrentDevice;

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI(String deImageFile) throws IOException {
        //Create and set up the window.
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] schermen = ge.getScreenDevices();
        GraphicsDevice mijnScherm = schermen[0];
        frame = new JFrame("FrameDemo");
        int frameHoogte = mijnScherm.getDisplayMode().getHeight();
        frameHoogte = frameHoogte - 100;
//        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.setUndecorated(true);

        File imageFile = new File(deImageFile);
        Image imageToBeDisplayed = ImageIO.read(imageFile);
        int heightImageToBeDisplayed = imageToBeDisplayed.getHeight(null);
        Image imageVooricon = imageToBeDisplayed.getScaledInstance(-1, frameHoogte, Image.SCALE_FAST);
        GdImage.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GdImage.icon = new ImageIcon(imageVooricon);
        schaal =   frameHoogte / (double) heightImageToBeDisplayed;
        label1 = new JLabel();
        label1.setIcon(icon);
        RegionSelectorListener regionSelectorListener = new RegionSelectorListener(label1, imageFile);
        panel = new JPanel();
        panel.add(label1);
//        panel.getPreferredSize();
        frame.setSize(imageVooricon.getHeight(frame) ,frameHoogte);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    // vullen array met jpgs in dir

                    createAndShowGUI(args[0]);
                } catch (IOException ex) {
                    Logger.getLogger(GdImage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }
}
