package Controllers;

import Model.Chrono;
import Model.Grille;
import View.Memory;
import View.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNouvellePartie implements ActionListener {

    /**
     * Static Constants attributs
     */
    private static final Memory MEMORY = Memory.getSelfMemory();
    private static final Chrono CHRONO = MEMORY.getChrono();
    private static final Grille GRILLE = MEMORY.getGrille();

    private Menu menu;
    private boolean launchGameForFirstTime = true;

    public ControlNouvellePartie() { }

    public ControlNouvellePartie(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (launchGameForFirstTime) {
            MEMORY.startGame();
            launchGameForFirstTime = false;
        }
        GRILLE.newGrille(getTailleGrille());
        ControlBouton.setIsThereAnGridButtonRevealedFalse();
        CHRONO.restart();
    }

    public int getTailleGrille() {
        return this.menu.getTailleGrillePanel().getTailleGrille();
    }
}
