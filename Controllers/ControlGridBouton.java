package Controllers;

import Model.GridBouton;
import View.Memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlGridBouton implements ActionListener {

    private static GridBouton gridButtonAlreadyRevealed;
    private static boolean isThereAnGridButtonRevealed = false;

    private final Timer TIMER = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            hideCurrentGridButton();
            hideAlreadyRevealedGridButton();
            TIMER.restart();
            TIMER.stop();
            Memory.getSelfMemory().setEnabled(true);
        }
    });

    private GridBouton gridBouton;

    public ControlGridBouton(GridBouton gridBouton) {
        this.gridBouton = gridBouton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isThereAnGridButtonRevealed) {
            revealCurrentGridButton();
            if (!GridBouton.equals(this.gridBouton, gridButtonAlreadyRevealed)) {
                Memory.getSelfMemory().setEnabled(false);
                TIMER.start();
                Memory.getSelfMemory().getEssaisRestant().decrease();
            }
            isThereAnGridButtonRevealed = false;
        } else {
            revealCurrentGridButton();
            gridButtonAlreadyRevealed = this.gridBouton;
            isThereAnGridButtonRevealed = true;
        }
    }

    public void revealCurrentGridButton() {
        this.gridBouton.setEnabled(false);
        this.gridBouton.revealHideImage();
    }

    public void hideCurrentGridButton() {
        this.gridBouton.setEnabled(true);
        this.gridBouton.hideRevealedImage();
    }

    public void hideAlreadyRevealedGridButton() {
        gridButtonAlreadyRevealed.setEnabled(true);
        gridButtonAlreadyRevealed.hideRevealedImage();
        gridButtonAlreadyRevealed = null;
    }

    public static void setIsThereAnGridButtonRevealedFalse() {
        ControlGridBouton.isThereAnGridButtonRevealed = false;
    }
}
