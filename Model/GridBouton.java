package Model;


import Controllers.ControlBouton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GridBouton extends JButton {
    private ImageIcon icon;

    public GridBouton(ImageIcon icon) {
        super(icon);
        this.icon = icon;
        this.setPreferredSize(new Dimension(50,50));
        this.addActionListener(new ControlBouton());
        this.setBorder(new LineBorder(Color.BLACK));
    }

    public static boolean equals(GridBouton b1, GridBouton b2){
        return b1.getIcon().equals(b2.getIcon());
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
