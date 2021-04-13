package Model;

import View.Memory;

import javax.swing.*;
import java.awt.*;

public class EssaisRestant extends JPanel {

    private int nombreEssaisRestant;
    private JLabel essaisRestantLabel;

    public EssaisRestant(int nombreEssaisRestant) {
        this.setLayout(new GridBagLayout());
        this.nombreEssaisRestant = nombreEssaisRestant;
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

    public void setEssaisRestantLabelInvisible(){
        this.essaisRestantLabel.setVisible(false);
    }

    public void setEssaisRestantLabelVisible(){
        this.essaisRestantLabel.setVisible(true);
    }
}
