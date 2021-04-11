package Model;

import javax.swing.*;
import java.io.File;

public class Images {
    public ImageIcon[] listeImages;
    private static String CHEMIN = "/Images";

    public Images(int nbImage) {
        this.listeImages = new ImageIcon[nbImage];
        try {
            File folder = new File(CHEMIN);
            int counter = 0;
            for (final File fileEntry : folder.listFiles()) {
                listeImages[counter] = new ImageIcon(CHEMIN + '/' + fileEntry.getName());
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
