package View;

import javax.swing.*;

public class Memory extends JFrame {
    JPanel container = new JPanel();
    
    Chrono chrono = new Chrono();
    JPanel panelMenu = new Menu();

    public Memory() {
        initFrame();

        this.container.add(panelMenu);
        
        this.container.add(chrono);
        this.chrono.run();

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
