package imageApp;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

public class ImageApp extends Frame {

    Image image;
    static Vector filesInDirectory;

    public static void main(String[] args) {
        filesInDirectory = getFilesInDirectory(args[0]);
        for (int j = 0; j < filesInDirectory.size(); j++) {
            String arg;
            File f = (File) filesInDirectory.elementAt(j);
            arg = f.getAbsolutePath();

            try {
                ImageApp app = new ImageApp(arg);
            } catch (IOException ex) {
                Logger.getLogger(ImageApp.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public ImageApp(String filenaam) throws IOException {
        super("ImageApp");
        setBackground(Color.white);
        // Use Toolkit to load image file
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        image = toolkit.getImage(filenaam);

//     int dimh = image.getHeight();
//     int dimw = image.getWidth();
        Dimension dim = new Dimension(getImageDim(filenaam));
        addWindowListener(new WindowEventHandler());
        pack();
//  setSize(400,400);
        setSize(dim);
        show();
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    class WindowEventHandler extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private Dimension getImageDim(final String path) throws IOException {
        Dimension result = null;
        String suffix = this.getFileSuffix(path);
        Iterator<ImageReader> iter = ImageIO.getImageReadersBySuffix(suffix);
        if (iter.hasNext()) {
            ImageReader reader = iter.next();
//            try {
            ImageInputStream stream = new FileImageInputStream(new File(path));
            reader.setInput(stream);
            int width = reader.getWidth(reader.getMinIndex());
            int height = reader.getHeight(reader.getMinIndex());
            result = new Dimension(width, height);
//            } catch (IOException e) {
//                System.out.println("imageApp.ImageApp.log()");
//            log(e.getMessage());
//            } finally {
//                reader.dispose();
        }
//        } 

//            System.out.println("imageApp.ImageApp.log()" + suffix);
//        }
        return result;
    }

    private String getFileSuffix(final String path) {
        String result = null;
        if (path != null) {
            result = "";
            if (path.lastIndexOf('.') != -1) {
                result = path.substring(path.lastIndexOf('.'));
                if (result.startsWith(".")) {
                    result = result.substring(1);
                }
            }
        }
        return result;
    }

    static Vector getFilesInDirectory(String erin) {
//        Vector eruit = new Vector();
        File startFile = new File(erin);
        File startDirFile = startFile.getParentFile();
        Vector fileVector = new Vector();
//        System.out.println(startDirFile);
        File folder = new File(startDirFile.getAbsolutePath());
        File[] listOfFiles = folder.listFiles();

//        for (File file : listOfFiles) {
//            if (file.isFile()) {
//                System.out.println(file.getName());
//            }
//        }
        try {
            // for each name in the path array
            for (File fileInDir : listOfFiles) {
                if (fileInDir.isFile()) {
                    String extension = fileInDir.getName().substring(fileInDir.getName().lastIndexOf("."));
                    if (extension.toLowerCase().contains(".png")) {
                        System.out.println(fileInDir);
//                    System.out.println(extension);
                        fileVector.addElement(fileInDir);
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("Error");            // if any error occurs
            e.printStackTrace();
        }

        return fileVector;

    }

}
