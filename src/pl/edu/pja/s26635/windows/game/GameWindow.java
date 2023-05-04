package pl.edu.pja.s26635.windows.game;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        generateFrame();
    }

    public void generateFrame() {
        JFrame frame = new JFrame("Dino Game");

        frame.setSize(1000, 800);

        Dino dino = new Dino((frame.getWidth() / 2), (frame.getHeight() / 2));
        Enemy enemy1 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino);
        Enemy enemy2 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino);

        frame.add(dino);
        frame.add(enemy1);
        frame.add(enemy2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
