package Model;

import javax.swing.*;
import java.io.File;
import java.util.Random;

public class Images {

    // CONSTANTS
    private final static String CHEMIN = "projet-swing-s2/Model/Images";
    private final static File FOLDER = new File(CHEMIN);
    private final static File[] IMAGE_FILES = FOLDER.listFiles();
    private final static int NUMBER_OF_DISPONIBLE_IMAGES = IMAGE_FILES.length;
    private final Random RANDOM = new Random();

    private ImageIcon[] arrayImages;


    /**
     * Create a new intance of {@link Images} with {@nbImage} random picture affected to {@link Images#arrayImages} from {@link Images#FOLDER} using the Durstenfeld shuffle algorithm,
     * Throw an error if {@nbImage} is superior to {@link Images#NUMBER_OF_DISPONIBLE_IMAGES}
     *
     * @param nbImage
     */
    public Images(int nbImage) {

        if (NUMBER_OF_DISPONIBLE_IMAGES < nbImage) {
            System.out.println("Not enough images to hold the grid");
        }

        this.arrayImages = new ImageIcon[nbImage];

        /**
         * Index of {@link Images#arrayImages}
         */
        int indexArrayImages = 0;

        for (int lastIndex = NUMBER_OF_DISPONIBLE_IMAGES - 1; lastIndex > NUMBER_OF_DISPONIBLE_IMAGES - 1 - nbImage; lastIndex--) {

            int randomIndexOf_IMAGE_FILES = RANDOM.nextInt(lastIndex);
            File currentImageFile = IMAGE_FILES[randomIndexOf_IMAGE_FILES];

            this.arrayImages[indexArrayImages] = new ImageIcon(CHEMIN + '/' + currentImageFile.getName());
            indexArrayImages++;

            IMAGE_FILES[randomIndexOf_IMAGE_FILES] = IMAGE_FILES[lastIndex];
            IMAGE_FILES[lastIndex] = currentImageFile;
        }
    }

    public ImageIcon[] getArrayImages() {
        return arrayImages;
    }

//    public void showArrayImages() {
//        for (ImageIcon image : this.arrayImages) {
//            System.out.println(image);
//        }
//    }

    public void setArrayImages(ImageIcon[] arrayImages) {
        this.arrayImages = arrayImages;
    }
}
