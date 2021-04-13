package Controllers;

import Model.GridBouton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBouton implements ActionListener {

    private static boolean isThereAnGridButtonRevealed = false;
    private static GridBouton gridButtonAlreadyRevealed;

    private GridBouton gridBouton;
    private boolean isHideImageReveal;

    public ControlBouton(GridBouton gridBouton) {
        this.gridBouton = gridBouton;
        this.isHideImageReveal = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isThereAnGridButtonRevealed) {
            System.out.println(GridBouton.equals(this.gridBouton, gridButtonAlreadyRevealed));
            if (GridBouton.equals(this.gridBouton, gridButtonAlreadyRevealed)){
                revealCurrentGridButton();
                isThereAnGridButtonRevealed = false;
            } else {
                // Decrease Nombre d'essais
                System.out.println("-1");
            }
        } else {
            revealCurrentGridButton();
            gridButtonAlreadyRevealed = this.gridBouton;
            isThereAnGridButtonRevealed = true;
        }

//        if (this.isHideImageReveal) {
//            this.gridBouton.hideRevealedImage();
//            this.isHideImageReveal = false;
//        } else {
//            this.gridBouton.revealHideImage();
//            this.isHideImageReveal = true;
//        }
    }

    public void revealCurrentGridButton(){
        this.gridBouton.setEnabled(false);
        this.gridBouton.revealHideImage();
    }

    public static void setIsThereAnGridButtonRevealedFalse() {
        ControlBouton.isThereAnGridButtonRevealed = false;
    }
}
