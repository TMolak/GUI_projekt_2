package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWindow extends JFrame {


    public GameWindow() {
        generateFrame();
    }

    public void generateFrame() {
        JFrame frame = new JFrame("Dino Game");
        frame.setSize(1000, 800);

        Dino dino = new Dino((frame.getWidth() / 2), (frame.getHeight() / 2));
        Enemy enemy1 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.BLUE);
        Enemy enemy2 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.RED);
        List<Enemy> enemyList = new ArrayList<>();

        enemyList.add(enemy1);
        enemyList.add(enemy2);


        frame.add(dino);
        frame.add(enemy1);
        frame.add(enemy2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

//        MovingThreads movingThreads = new MovingThreads(dino, enemyList);
//        synchronized (dino){
//            movingThreads.run();
//        }
    }
}
