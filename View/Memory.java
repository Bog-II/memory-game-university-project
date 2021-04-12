package View;

import Model.Chrono;
import Model.Grille;

import javax.swing.*;

public class Memory extends JFrame {
    JPanel container = new JPanel();
    Chrono chrono = new Chrono();
    Menu panelMenu = new Menu();
    Grille grille = new Grille(3);


    public Memory() {
        initFrame();

        this.container.add(panelMenu);
        
        this.container.add(chrono);
        this.chrono.run();

        this.container.add(grille);


        setContentPane(this.container);
    }

    public void createMenu(){
    }


    public void initFrame(){
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Projet Swing - S2 - Memory");
    }
}
