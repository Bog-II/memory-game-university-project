package BestTimes;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class BestTimes extends JPanel {
    /**
     * Only the three best times are stored in ascending order into BestTimesXXXX.txt text file.
     */
    private static final String BEST_TIMES_THREE_NAME = "BestTimes/BestTimesThree.txt";
    private static final String BEST_TIMES_FOUR_NAME = "BestTimes/BestTimesFour.txt";
    private static final String BEST_TIMES_FIVE_NAME = "BestTimes/BestTimesFive.txt";
    private static final int NUMBER_OF_BEST_TIME_PER_CATEGORY = 3;

    private JPanel containerBestTime;
    private JPanel bestTimesThreePanel = new JPanel();
    private JPanel bestTimesFourPanel = new JPanel();
    private JPanel bestTimesFivePanel = new JPanel();


    public BestTimes() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Best Times");
        title.setFont(new Font("Serif", Font.PLAIN, 48));
        this.add(title);

        initContainerBestTime();
    }

    public static void receiveAndTreatNewTime(Float time, int categoryGrid) throws IOException {
        String timeString = Float.toString(time);
        String lineToWrite = "";
        String pathFile = getFileNameByCategoryGrid(categoryGrid);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            for (int i = 0; i < NUMBER_OF_BEST_TIME_PER_CATEGORY; i++) {
                String readedString = reader.readLine();
                if (readedString == null){
                    lineToWrite += timeString;
                    break;
                }

                Float timeReadedString = Float.parseFloat(readedString);
                if (timeReadedString < time){
                    lineToWrite += readedString + "\n";
                } else {
                    lineToWrite += timeString + "\n";
                    timeString = readedString;
                    time = timeReadedString;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong to read " + pathFile);
            System.out.println(e);
        }


        if (!lineToWrite.equals("")){
            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFile), "utf-8"));
                writer.write(lineToWrite);
                writer.close();
            } catch (IOException ex) {
                System.out.println("Something went wrong to write " + pathFile);
            }
        }
    }
    
    public void initContainerBestTime(){
        GridLayout containerLayout = new GridLayout(1, 3);
        containerLayout.setHgap(10);
        containerLayout.setVgap(10);

        this.containerBestTime = new JPanel(containerLayout);
//        this.containerBestTime.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.showBestScores();
        this.containerBestTime.add(this.bestTimesThreePanel);
        this.containerBestTime.add(bestTimesFourPanel);
        this.containerBestTime.add(bestTimesFivePanel);
        this.add(containerBestTime);
    }

    public static String getFileNameByCategoryGrid(int categoryGrid){
        return switch (categoryGrid) {
            case 3 -> BEST_TIMES_THREE_NAME;
            case 4 -> BEST_TIMES_FOUR_NAME;
            case 5 -> BEST_TIMES_FIVE_NAME;
            default -> "Something went Wrong";
        };
    }

    public void showBestScores(){
        this.initInnerPanel();
        addTimesToPanel(BEST_TIMES_THREE_NAME, this.bestTimesThreePanel, new JLabel("3x3"));
        addTimesToPanel(BEST_TIMES_FOUR_NAME, this.bestTimesFourPanel, new JLabel("4x4"));
        addTimesToPanel(BEST_TIMES_FIVE_NAME, this.bestTimesFivePanel, new JLabel("5x5"));
    }

    public void initInnerPanel(){
        this.bestTimesThreePanel.setLayout(new BoxLayout(this.bestTimesThreePanel, BoxLayout.Y_AXIS));
        this.bestTimesFourPanel.setLayout(new BoxLayout(this.bestTimesFourPanel, BoxLayout.Y_AXIS));
        this.bestTimesFivePanel.setLayout(new BoxLayout(this.bestTimesFivePanel, BoxLayout.Y_AXIS));
    }

    public void addTimesToPanel(String path, JPanel panel, JLabel title){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            title.setFont(new Font("SansSerif", Font.BOLD, 24));
            panel.add(title);

            for (int i = 0; i < NUMBER_OF_BEST_TIME_PER_CATEGORY; i++) {
                String readedString = reader.readLine();
                if (readedString == null){
                    break;
                }
                JLabel time = new JLabel(readedString);
                time.setFont(new Font("SansSerif", Font.PLAIN, 16));
                panel.add(time);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong to read " + path);
            System.out.println(e);
        }
    }

}
