package Model;

import javax.swing.*;

public class Essaies extends JPanel {
    private int numberEssaies;

    public Essaies() {
        this.numberEssaies = 3;
    }

    public void decrease(){
        this.numberEssaies -= 1;
    }
}
