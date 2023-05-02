package pl.edu.pja.s26635.windows.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(){
        generateFrame();
    }

    public void generateFrame(){
        JFrame frame = new JFrame("Dino Game");

        frame.add(new Dino());
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
