package View;

import Controllers.ControlEndGameMessageButton;
import Controllers.ControlNouvellePartie;
import View.MenuItems.NouvellePartie;
import View.MenuItems.TailleGrille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameMessage extends JFrame {
    private JPanel container = new JPanel();
    private JLabel label;
    private TailleGrille tailleGrille;
    private JButton rejouer;

    public EndGameMessage(String textLabel, String title) {
        initFrame(title);
        initLabel(textLabel);
        initTailleGrille();
        initRejouer();

        this.setContentPane(this.container);
    }

    public void initFrame(String title){
        this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.container.setAlignmentX(JLabel.CENTER);
        this.container.setAlignmentY(JLabel.CENTER);
        this.setSize(400, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
    }

    public void initLabel(String textLabel){
        this.label = new JLabel(textLabel);
        this.label.setFont(new Font("Serif", Font.PLAIN, 48));
        this.container.add(this.label);
    }
    public void initTailleGrille(){
        this.tailleGrille = new TailleGrille();
        this.container.add(this.tailleGrille);
    }

    public void initRejouer(){
        this.rejouer = new JButton();
        this.rejouer.setText("Rejouer");
        this.rejouer.addActionListener(new ControlEndGameMessageButton(this.tailleGrille, this));
        this.container.add(this.rejouer);
    }
}
