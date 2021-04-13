package Controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButtonBestScore implements ActionListener {

    private JPanel historic = new JPanel();

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, this.historic, "Historique des meilleurs scores", JOptionPane.INFORMATION_MESSAGE);
    }
}
