package Controllers;

import Model.Chrono;
import Model.Grille;
import View.Memory;
import View.MenuItems.TailleGrille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNouvellePartie implements ActionListener {

    /**
     * Static Constants attributs
     */
    private static final Memory MEMORY = Memory.getSelfMemory();
    private static final Chrono CHRONO = MEMORY.getChrono();
    private static final Grille GRILLE = MEMORY.getGrille();

    private TailleGrille tailleGrille;
    private boolean launchGameForFirstTime = true;

    public ControlNouvellePartie() { }

    public ControlNouvellePartie(TailleGrille tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (launchGameForFirstTime) {
            MEMORY.startGame();
            launchGameForFirstTime = false;
        }
        MEMORY.getEssaisRestant().setNombreEssaisRestant(Memory.NOMBRE_ESSAIS_DEPART);
        GRILLE.newGrille(getTailleGrille());
        ControlGridBouton.setIsThereAnGridButtonRevealedFalse();
        CHRONO.restart();
    }

    public int getTailleGrille() {
        return this.tailleGrille.getTailleGrille();
    }
}
