package View;

import Controllers.ControlNouvellePartie;
import View.MenuItems.BestScore;
import View.MenuItems.NouvellePartie;
import View.MenuItems.TailleGrille;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private NouvellePartie nouvellePartieButton;
    private BestScore bestScoreButton = new BestScore();
    private TailleGrille tailleGrillePanel = new TailleGrille();

    public Menu(Memory memory) {

        this.nouvellePartieButton = new NouvellePartie(new ControlNouvellePartie(this));

        this.add(bestScoreButton);
        this.add(Box.createHorizontalStrut(24));
        this.add(nouvellePartieButton);
        this.add(Box.createHorizontalStrut(24));
        this.add(tailleGrillePanel);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public TailleGrille getTailleGrillePanel() {
        return tailleGrillePanel;
    }
}
