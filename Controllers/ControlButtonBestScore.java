package Controllers;

import Model.BestTimes.BestTimes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlButtonBestScore implements ActionListener {

    private JPanel historic;

    @Override
    public void actionPerformed(ActionEvent e) {
        historic = new BestTimes();
        JOptionPane.showMessageDialog(null, this.historic, "Historique des meilleurs scores", JOptionPane.INFORMATION_MESSAGE);
    }
}
