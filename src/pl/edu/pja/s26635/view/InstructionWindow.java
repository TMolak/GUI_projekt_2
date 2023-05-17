package pl.edu.pja.s26635.view;

import pl.edu.pja.s26635.view.scores.HighScoreModel;

import javax.swing.*;

public class InstructionWindow extends JFrame {


    public InstructionWindow(){
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
