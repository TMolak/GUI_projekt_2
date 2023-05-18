package pl.edu.pja.s26635.view.scores;

import javax.swing.*;


public class HighScoresWindow extends JFrame {
    public HighScoresWindow(){
        generateFrame();
    }

    public void generateFrame(){
        HighScoreModel highScoreModel = new HighScoreModel();
        add(highScoreModel);

        setSize(1000,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
