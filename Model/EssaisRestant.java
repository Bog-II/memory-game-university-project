package Model;

import javax.swing.*;
import java.awt.*;

public class EssaisRestant extends JPanel {
    private int nombreEssaisRestant;
    private JLabel essaisRestantLabel;

    public EssaisRestant() {
        this.setLayout(new GridBagLayout());
        this.nombreEssaisRestant = 3;
        this.essaisRestantLabel = new JLabel("Essais restants : " + Integer.toString(this.nombreEssaisRestant));
        this.add(this.essaisRestantLabel);
    }

    public void decrease(){
        this.nombreEssaisRestant -= 1;
        this.essaisRestantLabel.setText("Essais restants : " + Integer.toString(this.nombreEssaisRestant));
    }

    public int getNombreEssaisRestant() {
        return nombreEssaisRestant;
    }
}
