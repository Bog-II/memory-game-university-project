package View;

import Controllers.ControlNouvellePartie;
import View.MenuItems.BestScore;
import View.MenuItems.NouvellePartie;
import View.MenuItems.TailleGrille;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    private Memory memory;
    private NouvellePartie nouvellePartieButton;
    private BestScore bestScoreButton = new BestScore();
    private TailleGrille tailleGrillePanel = new TailleGrille();

    public Menu(Memory memory) {

        initMemory(memory);

        this.add(bestScoreButton);
        this.add(Box.createHorizontalStrut(24));
        this.add(nouvellePartieButton);
        this.add(Box.createHorizontalStrut(24));
        this.add(tailleGrillePanel);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void initMemory(Memory memory){
        this.memory = memory;
        this.nouvellePartieButton = new NouvellePartie(new ControlNouvellePartie(this.memory, this));
    }

    public TailleGrille getTailleGrillePanel() {
        return tailleGrillePanel;
    }
}
