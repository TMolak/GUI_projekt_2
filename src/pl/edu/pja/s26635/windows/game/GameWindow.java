package pl.edu.pja.s26635.windows.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(){
        generateFrame();
    }

    public void generateFrame(){
        setSize(1000,800);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
