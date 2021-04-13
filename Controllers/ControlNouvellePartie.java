package Controllers;

import Model.Chrono;
import Model.Grille;
import View.Memory;
import View.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNouvellePartie implements ActionListener {

    private Memory memory;
    private Chrono chrono;
    private Grille grille;
    private Menu menu;

    public ControlNouvellePartie(Memory memory, Menu menu) {
        this.memory = memory;
        this.grille = memory.getGrille();
        this.chrono = memory.getChrono();
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.grille.newGrille(getTailleGrille());
        this.chrono.restart();
    }

    public int getTailleGrille(){
        return this.menu.getTailleGrillePanel().getTailleGrille();
    }
}
