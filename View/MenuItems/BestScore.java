package View.MenuItems;

import Controllers.ControlButtonBestScore;

import javax.swing.*;

public class BestScore extends JButton {

    public BestScore() {
        super("Meilleurs Scores");
        this.addActionListener(new ControlButtonBestScore());
    }

}
