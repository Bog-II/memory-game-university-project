package Controllers;

import BestTimes.BestTimes;
import Models.Chrono;
import Models.GridBouton;
import Views.EndGameMessage;
import Views.Memory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControlGridBouton implements ActionListener {

    private Memory memory;
    private Chrono chrono;
    private static GridBouton gridButtonAlreadyRevealed;
    private static boolean isThereAnGridButtonRevealed = false;
    public static int numberOfPairHidden;

    private GridBouton gridBouton;

    private final Timer TIMER = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TIMER.restart();
            TIMER.stop();
            if (Memory.isInGame){
                hideAlreadyRevealedGridButton();
                hideCurrentGridButton();
            }
            Memory.getSelfMemory().setEnabled(true);
        }
    });


    public ControlGridBouton(GridBouton gridBouton) {
        this.gridBouton = gridBouton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isThereAnGridButtonRevealed) {
            revealCurrentGridButton();
            if (GridBouton.equals(this.gridBouton, gridButtonAlreadyRevealed)) {
                numberOfPairHidden--;
                if (numberOfPairHidden == 0) {
                    this.memory = Memory.getSelfMemory();
                    this.chrono = this.memory.getChrono();
                    this.chrono.stop();

                    Float chronoTime = this.chrono.getTimeFloat();
                    String chrono = this.chrono.getTime();
                    new EndGameMessage("Gagné \uD83D\uDC4F", "N'hésiter pas à rejouter", "avec un temps de " + chrono);
                    try {
                        BestTimes.receiveAndTreatNewTime(chronoTime, this.memory.getGrille().gridLength);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            } else {
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

    public static void setNumberOfPairHidden(int numberOfPairHidden) {
        ControlGridBouton.numberOfPairHidden = numberOfPairHidden;
    }

    public static void setIsThereAnGridButtonRevealedFalse() {
        ControlGridBouton.isThereAnGridButtonRevealed = false;
    }
}
