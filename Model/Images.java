package Model;

import javax.swing.*;
import java.io.File;
import java.util.Random;

public class Images {
    // CONSTANTS
    private final static String CHEMIN = "/Images";
    private final static File FOLDER = new File(CHEMIN);
    private final static File[] IMAGE_FILES = FOLDER.listFiles();
    private final static int NUMBER_OF_DISPONIBLE_IMAGES = IMAGE_FILES.length;
    private final Random RANDOM = new Random();

    private ImageIcon[] arrayImages;


    /**
     * Create a new intance of {@link Images} with {@nbImage} random picture affected to {@link Images#arrayImages} from {@link Images#FOLDER} using the Durstenfeld shuffle algorithm,
     * Throw an error if {@nbImage} is superior to {@link Images#NUMBER_OF_DISPONIBLE_IMAGES}
     * @param nbImage
     */
    public Images(int nbImage) {
        if (NUMBER_OF_DISPONIBLE_IMAGES < nbImage){
            System.out.println("Not enough images to hold the grid");
        }

        this.arrayImages = new ImageIcon[nbImage];

        /**
         * Index of {@link Images#arrayImages}
         */
        int indexArrayImages = 0;

        for (int lastIndexOf_IMAGE_FILES = NUMBER_OF_DISPONIBLE_IMAGES - 1 ; lastIndexOf_IMAGE_FILES > NUMBER_OF_DISPONIBLE_IMAGES - 1 - nbImage; lastIndexOf_IMAGE_FILES--){

            int randomIndexOf_IMAGE_FILES = RANDOM.nextInt(lastIndexOf_IMAGE_FILES);
            File currentImageFile = IMAGE_FILES[randomIndexOf_IMAGE_FILES];

            this.arrayImages[indexArrayImages] = new ImageIcon(CHEMIN + '/' + currentImageFile.getName());
            indexArrayImages++;

            IMAGE_FILES[randomIndexOf_IMAGE_FILES] = IMAGE_FILES[lastIndexOf_IMAGE_FILES];
            IMAGE_FILES[lastIndexOf_IMAGE_FILES] = currentImageFile;
        }
    }

    public ImageIcon[] getArrayImages() {
        return arrayImages;
    }

    public void setArrayImages(ImageIcon[] arrayImages) {
        this.arrayImages = arrayImages;
    }
}
