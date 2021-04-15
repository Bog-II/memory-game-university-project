package Model;

import Controllers.ControlGridBouton;
import View.Memory;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Grille extends JPanel {
    private final Random RANDOM = new Random();

    public int gridLength;
    private boolean isGridLengthEven;
    private int numberOfDistinctImageInGrid;
    private Images images;
    private ImageIcon[] distinctImages;
    private ImageIcon[] gridImages;

    public Grille(int gridLength) {
        this.gridLength = gridLength;
        this.isGridLengthEven = gridLength % 2 == 0;
        initImages(gridLength);
        addImagesToGrid();
        this.setLayout(new GridLayout(gridLength, gridLength, 40 / gridLength, 40 / gridLength));
    }

    public void initImages(int gridLength){
        if (this.isGridLengthEven){
            this.numberOfDistinctImageInGrid = gridLength * gridLength / 2;
        } else {
            this.numberOfDistinctImageInGrid = gridLength * gridLength / 2 + 1;
        }

        this.images = new Images(this.numberOfDistinctImageInGrid);
        this.distinctImages = this.images.getArrayImages();
        this.gridImages = new ImageIcon[gridLength * gridLength];

        for (int i = 0; i < distinctImages.length; i++) {
            this.gridImages[i] = this.distinctImages[i];
        }

        for (int i = distinctImages.length, distinctIndex = 0; i < gridImages.length; i++, distinctIndex++) {
            this.gridImages[i] = this.distinctImages[distinctIndex];
        }

        /**
         * Shuffle {@link #gridImages} using Durstenfeld shuffle algorithm
         */
        for (int lastIndex = gridImages.length - 1; lastIndex > 0; lastIndex--){
            // Random index between [0 and {lastIndex}]
            int randomIndexOfArrayImages = RANDOM.nextInt(lastIndex);

            ImageIcon tempImageIcon = gridImages[randomIndexOfArrayImages];
            gridImages[randomIndexOfArrayImages] = gridImages[lastIndex];
            gridImages[lastIndex] = tempImageIcon;
        }
    }

    public void addImagesToGrid(){
        for (ImageIcon gridImage : this.gridImages) {
            this.add(new GridBouton(gridImage));
        }
    }

    public void newGrille(int newGridLength){
        this.gridLength = newGridLength;
        this.removeAll();
        this.isGridLengthEven = newGridLength % 2 == 0;
        initImages(newGridLength);
        addImagesToGrid();
        this.setLayout(new GridLayout(newGridLength, newGridLength, 40 / newGridLength, 40 / newGridLength));
        ControlGridBouton.setNumberOfPairHidden((isGridLengthEven) ? this.numberOfDistinctImageInGrid : this.numberOfDistinctImageInGrid - 1);
        this.setEnabled(true);
        Memory.isInGame = true;
    }

    @Override
    public void setEnabled(boolean bool){
        for (Component childrenComponentPanel : this.getComponents()) {
            childrenComponentPanel.setEnabled(bool);
        }
    }
}
