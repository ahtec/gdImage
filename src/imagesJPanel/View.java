
package imagesJPanel;



import java.awt.Color;

import javax.swing.JFrame;


class View extends JFrame {

  public void build (Color background, int objectCount)
  {
    setSize(500,500);
    setContentPane(new DrawPanel(background, objectCount));
  }

}
