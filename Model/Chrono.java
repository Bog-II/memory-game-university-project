package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class Chrono extends JPanel implements ActionListener {
    // CONSTANTS
    private final Timer TIMER = new Timer(100, this);

    // VARIABLES
    private float time = 0;
    private JLabel chronoLabel = new JLabel();


    public Chrono() {
        this.setLayout(new GridBagLayout());
        this.add(chronoLabel);
    }

    public void start() {
        this.TIMER.start();
    }

    public void restart() {
        this.time = 0;
        this.TIMER.restart();
    }

    public void stop() {
        this.TIMER.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.time += 0.1;
        DecimalFormat decimalFormat = new DecimalFormat("#######0.0");
        String format = decimalFormat.format(time);
        this.chronoLabel.setText("Temps : " + format);
    }
}
