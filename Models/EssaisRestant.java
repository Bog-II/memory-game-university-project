package Models;

import Views.EndGameMessage;
import Views.Memory;

import javax.swing.*;
import java.awt.*;

public class EssaisRestant extends JPanel {

    private int nombreEssaisRestant;
    private JLabel essaisRestantLabel;
    private Memory memory;

    public EssaisRestant(int nombreEssaisRestant) {
        this.setLayout(new GridBagLayout());
        this.nombreEssaisRestant = nombreEssaisRestant;
        this.essaisRestantLabel = new JLabel("Essais restants : " + Integer.toString(this.nombreEssaisRestant));
        this.add(this.essaisRestantLabel);
    }

    public void decrease(){
        this.nombreEssaisRestant -= 1;
        this.essaisRestantLabel.setText("Essais restants : " + Integer.toString(this.nombreEssaisRestant));

        if (this.nombreEssaisRestant == 0){
            // The player Lost
            this.memory = Memory.getSelfMemory();
            this.memory.getChrono().stop();
            this.memory.getGrille().setEnabled(false);
            Memory.isInGame = false;
            new EndGameMessage("Perdu \uD83D\uDE2D", "Ne perdez pas espoir");
        }
    }

    public int getNombreEssaisRestant() {
        return nombreEssaisRestant;
    }

    public void setNombreEssaisRestant(int nombreEssaisRestant) {
        this.nombreEssaisRestant = nombreEssaisRestant;
        this.essaisRestantLabel.setText("Essais restants : " + Integer.toString(nombreEssaisRestant));
    }

    public void setEssaisRestantLabelInvisible(){
        this.essaisRestantLabel.setVisible(false);
    }

    public void setEssaisRestantLabelVisible(){
        this.essaisRestantLabel.setVisible(true);
    }


}
