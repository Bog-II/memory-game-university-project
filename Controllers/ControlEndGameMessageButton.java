package Controllers;

import Models.Chrono;
import Models.Grille;
import Views.Memory;
import Views.MenuItems.TailleGrille;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlEndGameMessageButton implements ActionListener {

    /**
     * Static Constants attributs
     */
    private static final Memory MEMORY = Memory.getSelfMemory();
    private static final Chrono CHRONO = MEMORY.getChrono();
    private static final Grille GRILLE = MEMORY.getGrille();

    private TailleGrille tailleGrille;
    private JFrame frame;

    public ControlEndGameMessageButton(TailleGrille tailleGrille, JFrame frame) {
        this.tailleGrille = tailleGrille;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MEMORY.getEssaisRestant().setNombreEssaisRestant(Memory.NOMBRE_ESSAIS_DEPART);
        GRILLE.newGrille(getTailleGrille());
        ControlGridBouton.setIsThereAnGridButtonRevealedFalse();
        CHRONO.restart();
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    public int getTailleGrille() {
        return this.tailleGrille.getTailleGrille();
    }
}
