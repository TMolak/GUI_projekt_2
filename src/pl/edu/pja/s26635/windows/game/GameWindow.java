package pl.edu.pja.s26635.windows.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(){
        generateFrame();
    }

    public void generateFrame(){
        JFrame frame = new JFrame("Dino Game");


        frame.setSize(1000,800);

        frame.add(new Dino((frame.getWidth()/2), (frame.getHeight()/2)));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
