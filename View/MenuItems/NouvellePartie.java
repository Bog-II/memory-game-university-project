package View.MenuItems;

import Controllers.ControlNouvellePartie;

import javax.swing.*;

public class NouvellePartie extends JButton {

    private ControlNouvellePartie controlNouvellePartie;

    public NouvellePartie(ControlNouvellePartie controlNouvellePartie) {
        super("Nouvelle Partie");
        this.controlNouvellePartie = controlNouvellePartie;
        this.addActionListener(this.controlNouvellePartie);
    }
}
