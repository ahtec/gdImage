package imagesJPanel;

import java.awt.Point;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;

import javax.swing.JPanel;

class DrawPanel extends JPanel {

    private Toolkit tk = Toolkit.getDefaultToolkit();
    private Image icon;
    private Color background;
    private Point[] objects;
    private Point[] deltas;

    public DrawPanel(Color background, int objectCount) {

//  	try{
//   	  System.out.println((new File(".")).getCanonicalPath()+
//  	  		System.getProperty("file.separator")+
//  	  		"images"+
//  	  		System.getProperty("file.separator")+"hotdog.gif");
//  	  } catch (Exception IO) {} 
        try {
            icon = tk.getImage((new File(".")).getCanonicalPath()
                    + System.getProperty("file.separator")
                    + "images"
                    + System.getProperty("file.separator") + "hotdog.gif");
        } catch (Exception IO) {
        }
        BufferedImage image = null;
        File f = null;

        try {
            f = new File("/Users/gerard/Pictures/annDoetsFineArt/website/Egg.png");
//             image = new BufferedImage();
     
            
            image = ImageIO.read(f);
            
//  	  icon = tk.getImage(f);
        } catch (Exception IO) {
        }

//        /Users/gerard/Pictures/annDoetsFineArt/website/Egg.png
        this.background = background;
        objects = new Point[objectCount];
        deltas = new Point[objectCount];

        //Choose random coordinate (in 500x500 panel) and motions
        for (int i = 0; i < objectCount; i++) {
            objects[i] = new Point((int) (Math.random() * 300 + 100),
                    (int) (Math.random() * 300 + 100));
            deltas[i] = new Point((int) (Math.random() * 5 - 3),
                    (int) (Math.random() * 5 - 3));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        setBackground(background);

        //Display all the hot dogs and then update their coordinates
        ///  for the next display
        for (int i = 0; i < objects.length; i++) {
            //g.fillRect(objects[i].x,objects[i].y,50,50);
            g.drawImage(icon, objects[i].x, objects[i].y, 50, 50, null);
            objects[i].x += deltas[i].x;
            objects[i].y += deltas[i].y;
        }
    }

}
