package View.MenuItems;

import javax.swing.*;

public class TailleGrille extends JPanel {
    private JRadioButton rb3x3 = new JRadioButton("3x3", false);
    private JRadioButton rb4x4 = new JRadioButton("4x4", true);
    private JRadioButton rb5x5 = new JRadioButton("5x5", false);
    private ButtonGroup group = new ButtonGroup();

    public TailleGrille() {
        group.add(rb3x3);
        group.add(rb4x4);
        group.add(rb5x5);

        this.add(rb3x3);
        this.add(rb4x4);
        this.add(rb5x5);
    }

    public int getTailleGrille(){
        if (this.rb3x3.isSelected()) {
            return 3;
        }
        if (this.rb4x4.isSelected()) {
            return 4;
        }
        if (this.rb5x5.isSelected()) {
            return 5;
        }
        return -1;
    }

}
