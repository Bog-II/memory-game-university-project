package Models;


import Controllers.ControlGridBouton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GridBouton extends JButton {

    private ImageIcon hideImage;

    public GridBouton(ImageIcon icon) {
        this.setIcon(Images.DEFAULT_COVER_IMAGE);
        this.setDisabledIcon(icon);
        this.hideImage = icon;
        this.setPreferredSize(new Dimension(75,75));
        this.addActionListener(new ControlGridBouton(this));
        this.setBorder(new LineBorder(Color.BLACK));
    }

    public static boolean equals(GridBouton b1, GridBouton b2) {
        return b1.getHideImage().equals(b2.getHideImage());
    }

    public void revealHideImage() {
        this.setIcon(this.hideImage);
    }

    public void hideRevealedImage() {
        this.setIcon(Images.DEFAULT_COVER_IMAGE);
    }

    public ImageIcon getHideImage() {
        return hideImage;
    }

}
