/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdimageV2;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;


public class Application {

    public static void main(String[] args) {
        File startFile = new File(args[0]);
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
//                    System.out.println(fileInDir);
//                    System.out.println(extension);
                    fileVector.addElement(fileInDir);
                }
            }

            }
            View view = new View();
            File inputFile = (File) fileVector.get(0);
            view.build(  inputFile);
            view.pack();
            view.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error");            // if any error occurs
            e.printStackTrace();
        }
    }

}
