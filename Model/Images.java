package Model;

import javax.swing.*;
import java.io.File;
import java.util.Objects;

public class Images {
    // CONSTANTS
    private final static String CHEMIN = "/Images";
    private final static File FOLDER = new File(CHEMIN);
    private final static int  NUMBER_OF_DISPONIBLE_IMAGES = Objects.requireNonNull(FOLDER.list()).length;

    private ImageIcon[] listeImages;
    private boolean[] listImagesReturned;


    public Images(int nbImage) {
        this.listeImages = new ImageIcon[nbImage];
        try {
            int counter = 0;
            for (final File fileEntry : Objects.requireNonNull(FOLDER.listFiles())) {
                listeImages[counter] = new ImageIcon(CHEMIN + '/' + fileEntry.getName());
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon[] getListeImages() {
        return listeImages;
    }

    public void setListeImages(ImageIcon[] listeImages) {
        this.listeImages = listeImages;
    }

    public boolean[] getListImagesReturned() {
        return listImagesReturned;
    }

    public void setListImagesReturned(boolean[] listImagesReturned) {
        this.listImagesReturned = listImagesReturned;
    }
}
