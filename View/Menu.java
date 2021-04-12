package View;

import View.MenuItems.BestScore;
import View.MenuItems.NouvellePartie;
import View.MenuItems.TailleGrille;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private final BestScore BEST_SCORE_BUTTON = new BestScore();
    private final NouvellePartie NOUVELLE_PARTIE_BUTTON = new NouvellePartie();
    private final TailleGrille TAILLE_GRILLE_PANEL = new TailleGrille();

    public Menu() {
        this.add(BEST_SCORE_BUTTON);
        this.add(Box.createHorizontalStrut(24));
        this.add(NOUVELLE_PARTIE_BUTTON);
        this.add(Box.createHorizontalStrut(24));
        this.add(TAILLE_GRILLE_PANEL);

        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
