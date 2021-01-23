/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdimageV2;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gerard
 */
class View extends JFrame implements KeyListener {

    static public ImageIcon titleIcon;
    static public JFrame frame;
    static public JPanel panel;
    static public JLabel label1;
    //Instance Variables
    //For title icon and size/positioning of JFrame
    private final Toolkit tk = Toolkit.getDefaultToolkit();
    private final Dimension screen = tk.getScreenSize();

    void build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void build(File imageFilenaam) {
//        try {
//            setTitle(imageFilenaam.getAbsolutePath());
//
//            //Title icon
//            Image titleIcon;
//            titleIcon = tk.getImage(imageFilenaam.getCanonicalPath());
////        setIconImage(titleIcon);
//            System.out.println(imageFilenaam);
////1/2 Screen Height/Width, Positioned in the Middle
//            setSize(screen.width / 2, screen.height / 2);
//            setLocation(screen.width / 4, screen.height / 4);
//            label1 = new JLabel();
////        label1.setBounds(0, 0, titleIcon.getWidth(), titleIcon.getHeight());
////        label1.setIcon(titleIcon);
////        RegionSelectorListener regionSelectorListener = new RegionSelectorListener(label1, imageFile);
//            panel = new JPanel();
////        panel.setLayout(null);
//            panel.add(label1);
//            panel.getPreferredSize();
////        panel.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
//            this.add(panel);
//            this.getContentPane().add(label1);
////frame.addMouseListener(new RegionSelectorListener()){
//
////    };
////Display the window.
//            this.pack();
//            this.setVisible(true);
//
////        this.setVisible(true);
//        } catch (IOException ex) {
//            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @Override
    public void keyTyped(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("\nKey Event = " + e);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void build(File imageFilenaam) {

        try {
            setTitle(imageFilenaam.getAbsolutePath());

            //Title icon
            Image currentImage;
            currentImage = tk.getImage(imageFilenaam.getCanonicalPath());
            setIconImage(currentImage);
            System.out.println(imageFilenaam);
//1/2 Screen Height/Width, Positioned in the Middle
            setSize(screen.width / 2, screen.height / 2);
            setLocation(screen.width / 4, screen.height / 4);
            label1 = new JLabel();
//        label1.setBounds(0, 0, titleIcon.getWidth(), titleIcon.getHeight());
//        label1.setIcon(titleIcon);
//        RegionSelectorListener regionSelectorListener = new RegionSelectorListener(label1, imageFile);
            panel = new JPanel();
//        panel.setLayout(null);
//        panel.add(currentImage);
//        panel.getPreferredSize();
//        panel.setBounds(0, 0,icon.getIconWidth(),icon.getIconHeight());
//        this.add(panel);
//        this.getContentPane().add(label1);
//frame.addMouseListener(new RegionSelectorListener()){

//    };
//Display the window.
            this.pack();
            this.setVisible(true);

//        this.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
