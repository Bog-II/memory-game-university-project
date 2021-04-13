package View;

import Model.Chrono;
import Model.EssaisRestant;
import Model.Grille;

import javax.swing.*;

public class Memory extends JFrame {
    private JPanel container = new JPanel();
    private Chrono chrono = new Chrono();
    private Menu panelMenu;
    private Grille grille = new Grille(4);
    private EssaisRestant essaisRestant = new EssaisRestant();

    public Memory() {

        initFrame();
        initMenu();
        initChrono();

        this.container.add(grille);
        System.out.println(this.grille);
        this.container.add(essaisRestant);

        this.setContentPane(this.container);
    }

    public void initFrame(){
        this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.setSize(600, 500);
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
        this.chrono.restart();
    }

    public Chrono getChrono() {
        return this.chrono;
    }

    public Grille getGrille() {
        return this.grille;
    }

}
