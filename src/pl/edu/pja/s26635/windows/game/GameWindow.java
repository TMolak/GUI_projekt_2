package pl.edu.pja.s26635.windows.game;

import pl.edu.pja.s26635.windows.game.threads.DinoThread;
import pl.edu.pja.s26635.windows.game.threads.MovingThreads;

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
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new OverlayLayout(jPanel));
        frame.setSize(1000, 800);


        Dino dino = new Dino((frame.getWidth() / 2), (frame.getHeight() / 2));
        Enemy enemy1 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.BLUE);
        Enemy enemy2 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.RED);
        List<Enemy> enemyList = new ArrayList<>();

        enemyList.add(enemy1);
        enemyList.add(enemy2);

        MovingThreads movingThreads = new MovingThreads(dino, enemy1);
        movingThreads.run();


        jPanel.add(dino);
        jPanel.add(enemy1);
        jPanel.add(enemy2);
        jPanel.add(new Component() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.PINK);
                g.fillOval(300, 200, 40, 40);
            }
        });
        frame.setContentPane(jPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
