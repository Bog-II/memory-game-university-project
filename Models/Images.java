package Models;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class Images {

    // CONSTANTS
    public final static int WIDTH_IMAGE = 70;
    public final static int HEIGHT_IMAGE = 70;
    public final static ImageIcon DEFAULT_COVER_IMAGE = redimensionIconImage(WIDTH_IMAGE, HEIGHT_IMAGE, new ImageIcon("projet-swing-s2/Model/Images/visibility.png"));
    private final static String CHEMIN = "projet-swing-s2/Model/Images/Flag";
    private final static File FOLDER = new File(CHEMIN);
    private final static File[] IMAGE_FILES = FOLDER.listFiles();
    private final static int NUMBER_OF_DISPONIBLE_IMAGES = IMAGE_FILES.length;
    private final Random RANDOM = new Random();

    private ImageIcon[] arrayImages;


    /**
     * Create a new intance of {@link Ressources.Images} with {@nbImage} random picture affected to {@link Ressources.Images#arrayImages} from {@link Ressources.Images#FOLDER} using the Durstenfeld shuffle algorithm,
     * Throw an error if {@nbImage} is superior to {@link Ressources.Images#NUMBER_OF_DISPONIBLE_IMAGES}
     *
     * @param nbImage
     */
    public Images(int nbImage) {

        if (NUMBER_OF_DISPONIBLE_IMAGES < nbImage) {
            System.out.println("Not enough images to hold the grid");
        }

        this.arrayImages = new ImageIcon[nbImage];

        /**
         * Index of {@link arrayImages}
         */
        int indexArrayImages = 0;
        for (int lastIndex = NUMBER_OF_DISPONIBLE_IMAGES - 1; lastIndex > NUMBER_OF_DISPONIBLE_IMAGES - 1 - nbImage; lastIndex--) {

            int randomIndexOf_IMAGE_FILES = RANDOM.nextInt(lastIndex);
            File currentImageFile = IMAGE_FILES[randomIndexOf_IMAGE_FILES];
            ImageIcon currentImage = new ImageIcon(CHEMIN + '/' + currentImageFile.getName());
            ImageIcon newImageIcon = redimensionIconImage(WIDTH_IMAGE, HEIGHT_IMAGE, currentImage);

            this.arrayImages[indexArrayImages] = newImageIcon;
            indexArrayImages++;

            IMAGE_FILES[randomIndexOf_IMAGE_FILES] = IMAGE_FILES[lastIndex];
            IMAGE_FILES[lastIndex] = currentImageFile;
        }
    }

    public static ImageIcon redimensionIconImage(int width, int heigh, ImageIcon imageIconToResize) {
        Image image = imageIconToResize.getImage();
        Image newImage = image.getScaledInstance(width, heigh, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImage);
    }

    public ImageIcon[] getArrayImages() {
        return arrayImages;
    }

    public void setArrayImages(ImageIcon[] arrayImages) {
        this.arrayImages = arrayImages;
    }


}
