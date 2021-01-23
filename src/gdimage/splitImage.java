/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author gerard
 */
public class splitImage {

    void doe(File erin, int halveHoogte) {
        boolean successMakeOrgDir = false;
//        GdImage.schaal;
        double doubleHalveHoogte = halveHoogte / GdImage.schaal;
        halveHoogte = (int) Math.round(doubleHalveHoogte) ;
        System.out.println("splitspunt "+ halveHoogte);        
        try {
//            int halveHoogte;
//            halveHoogte = source.getHeight() / 2;
//            float q = ((float) source.getHeight()) / source.getWidth();
//            if (q > 1.2) {
//            if (source.getHeight() / source.getWidth() > 1.2) {  // check op being portait
//                fileNameNoExtension fne = new fileNameNoExtension();

//            final BufferedImage source = ImageIO.read(new File("/Users/gerard/Pictures/ArtOfHendrik/openstal_173.jpg"));
            final BufferedImage source = ImageIO.read(erin);
            int idx = 1;
            int resthoogte = source.getHeight() - halveHoogte;
//            int resthoogte = source.getHeight() - halveHoogte;
            String erinExtension = getExtension(erin.getName());

            String pathName = erin.getCanonicalPath();
//            ImageIO.write(source.getSubimage(0, 0, source.getWidth(), halveHoogte), "JPG", new File(fileNameNoExtension.stripExtension(erin.getCanonicalPath()) + "P" + idx++ + getExtension(erin.getCanonicalPath())));
//            ImageIO.write(source.getSubimage(0, halveHoogte, source.getWidth(), halveHoogte), "JPG", new File(erin.getCanonicalPath() + idx++ + ".JPG"));
            ImageIO.write(source.getSubimage(0, 0, source.getWidth(), halveHoogte), erinExtension, new File(erin.getCanonicalPath() + idx++ + "." + erinExtension));
            ImageIO.write(source.getSubimage(0, halveHoogte, source.getWidth(), resthoogte), erinExtension, new File(erin.getCanonicalPath() + idx++ + "." + erinExtension));
            System.out.println(pathName);
// moving orgfile naar dir ../org
            File fdir = erin.getParentFile();
            File forgdirFile = new File(fdir.getAbsolutePath() + "/org");
            if (!forgdirFile.isDirectory()) {
                successMakeOrgDir = forgdirFile.mkdirs();
                if (!successMakeOrgDir) {
                    System.out.println("Kan org subdirectory niet aanmaken " + forgdirFile.getAbsolutePath());
                }
            }
            if (forgdirFile.isDirectory()) {
                File fileNaarOrg = new File(forgdirFile.getAbsolutePath(), erin.getName());
                boolean success = erin.renameTo(fileNaarOrg);
                if (!success) {
                    System.out.println("moving was not successfully from  " + erin.getAbsolutePath() + " to " + fileNaarOrg.getAbsolutePath());
                }
            }

        } catch (IOException e) {

        }
    }

    public static String getExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return "";
        } else {
            index++;
            return fileName.substring(index);
        }
    }

}
