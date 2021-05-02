package Views;

import Controllers.ControlEndGameMessageButton;
import Views.MenuItems.TailleGrille;

import javax.swing.*;
import java.awt.*;

public class EndGameMessage extends JFrame {
    private JPanel container = new JPanel();
    private JPanel labelPanel = new JPanel();
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

    public EndGameMessage(String textLabel, String title, String additionalTextBelowLabel) {
        this(textLabel, title);
        this.labelPanel.add(new JLabel(additionalTextBelowLabel));
    }

    public void initFrame(String title){
        this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.container.setAlignmentX(JLabel.CENTER);
        this.container.setAlignmentY(JLabel.CENTER);
        this.setSize(400, 250);
        this.setVisible(true);
        this.setTitle(title);
    }

    public void initLabel(String textLabel){
        this.label = new JLabel(textLabel);
        this.label.setFont(new Font("Serif", Font.PLAIN, 48));
        this.labelPanel.setLayout(new BoxLayout(this.labelPanel, BoxLayout.Y_AXIS));
        this.labelPanel.add(this.label);
        this.container.add(this.labelPanel);
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
