package pl.edu.pja.s26635.windows.game;

import pl.edu.pja.s26635.windows.game.model.CustomCellRenderer;
import pl.edu.pja.s26635.windows.game.threads.MovingThreads;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameWindow extends JFrame {
    private Dino dino;
    private List<Enemy> enemyList;

    public GameWindow() {
        generateFrame();
    }

    public void generateFrame() {
        JFrame frame = new JFrame("Dino Game");
        JPanel jPanel = new JPanel();

        JTable jTable = new JTable(SizeSelector.getValueX(), SizeSelector.getValueY());
        jTable.setRowHeight(10);
        for (int i = 0; i < SizeSelector.getValueX(); i++) {
            jTable.getColumnModel().getColumn(i).setPreferredWidth(10);
        }
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //rysowanie pol
        CustomCellRenderer test = new CustomCellRenderer();
        jTable.setDefaultRenderer(Object.class, test);

        jPanel.setLayout(new OverlayLayout(jPanel));

        frame.setSize(800, 800);


        dino = new Dino((frame.getWidth() / 2), (frame.getHeight() / 2), 100, 100);
        Enemy enemy1 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.BLUE, 50, 50);
//        Enemy enemy2 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.RED, 50, 50);
//        Enemy enemy3 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.YELLOW, 50, 50);

        enemyList = new ArrayList<>();

        enemyList.add(enemy1);
//        enemyList.add(enemy2);
//        enemyList.add(enemy3);

        MovingThreads movingThreads = new MovingThreads(dino, enemy1);

        movingThreads.run();

        jPanel.add(dino);
        jPanel.add(enemy1);
//        jPanel.add(enemy2);
//        jPanel.add(enemy3);
        jPanel.add(jTable);
        frame.setContentPane(jPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
