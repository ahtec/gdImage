/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdimage;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RegionSelectorListener extends MouseAdapter {

    final JLabel label;
    splitImage si = new splitImage();
    private File inputFile;

    public RegionSelectorListener(JLabel theLabel, File erin) {
        this.label = theLabel;
        theLabel.addMouseListener(this);
        this.inputFile = erin;
    }
    Point origin = null;

    public void mouseClicked(MouseEvent event) {
        origin = event.getPoint(); //set it.
        
        int height = event.getY();
        System.out.println("Selected Y is: " + origin.y);
        si.doe(inputFile, origin.y);
//        GdImage.icon = new ImageIcon("/Users/gerard/Pictures/ArtOfHendrik/openstal_174.jpg");
////        GdImage.panel.removeAll();
//        GdImage.label1.setIcon(GdImage.icon);
//        GdImage.frame.pack();
//        GdImage.frame.setVisible(true);
        GdImage.frame.dispose();
                
                
//                frame.getContentPane().removeAll();
//        GdImage.class
        //        if (origin == null) { //If the first corner is not set...
//            int width  = event.getX() ;
//        Component come = event.getComponent();
//        System.out.println(come.getClass().toString());
//        JLabel label = (JLabel) come;
//        label.get

//            System.out.println("Selected X is: "+ origin.x);
//        } else { //if the first corner is already set...
            //calculate width/height substracting from origin
//            int width = event.getX() - origin.x;
//            int height = event.getY() - origin.y;
//
//            //output the results (replace this)
//            System.out.println("Selected X is: "+ origin.x);
//            System.out.println("Selected Y is: "+ origin.y);
//            System.out.println("Selected width is: "+ width);
//            System.out.println("Selected height is: "+ height);
        
    }

}
