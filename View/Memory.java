package View;

import Model.Chrono;
import Model.EssaisRestant;
import Model.Grille;

import javax.swing.*;
import java.awt.*;

public class Memory extends JFrame {

    public final static int NOMBRE_ESSAIS_DEPART = 5;
    public static boolean isInGame;
    private static Memory selfMemory;

    private JPanel container = new JPanel();
    private Menu panelMenu;
    private Chrono chrono = new Chrono();
    private JPanel bienvenue = new JPanel();
    private Grille grille = new Grille(4);;
    private EssaisRestant essaisRestant = new EssaisRestant(Memory.NOMBRE_ESSAIS_DEPART);

    public Memory() {
        initFrame();
        initMenu();
        initChrono();
        initBienvenue();
        initGrille();
        initEssaisRestants();
        this.setContentPane(this.container);
    }

    public void initFrame(){
        selfMemory = this;
        this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.setSize(600, 550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Projet Swing - S2 - Memory");
    }

    private void initMenu(){
        this.panelMenu = new Menu(this);
        this.container.add(this.panelMenu);
    }

    public void initChrono() {
        this.container.add(chrono);
        this.chrono.setChronoLabelInvisible();
    }

    public void initBienvenue() {
        JLabel bienvenueLabel = new JLabel("Welcome to Memory game");
        bienvenueLabel.setFont(new Font("Serif", Font.PLAIN, 48));
        this.bienvenue.add(bienvenueLabel);
        this.container.add(this.bienvenue);
    }

    public void initGrille() {
        this.container.add(grille);
        this.grille.setVisible(false);
    }

    public void initEssaisRestants() {
        this.container.add(essaisRestant);
        this.essaisRestant.setEssaisRestantLabelInvisible();
    }

    public Chrono getChrono() {
        return this.chrono;
    }

    public Grille getGrille() {
        return this.grille;
    }

    public void startGame(){
        this.chrono.setChronoLabelVisible();
        this.bienvenue.setVisible(false);
        this.grille.setVisible(true);
        this.essaisRestant.setEssaisRestantLabelVisible();
    }

    public static Memory getSelfMemory(){
        return selfMemory;
    }

    public Menu getPanelMenu() {
        return panelMenu;
    }

    public EssaisRestant getEssaisRestant() {
        return essaisRestant;
    }
}
