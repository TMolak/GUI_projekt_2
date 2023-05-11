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
        JPanel jPanel = new JPanel();

        JTable jTable = new JTable(SizeSelector.getValueX(), SizeSelector.getValueY());
        jTable.setRowHeight(30);
        for (int i = 0; i < SizeSelector.getValueX(); i++) {
            jTable.getColumnModel().getColumn(i).setPreferredWidth(30);
        }
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //rysowanie pol
        CustomCellRenderer test = new CustomCellRenderer();
        jTable.setDefaultRenderer(Object.class, test);

        jPanel.setLayout(new OverlayLayout(jPanel));

        setSize(800, 800);


        dino = new Dino((3), (4), 50, 50);
        Enemy enemy1 = new Enemy((getWidth() / 2), (getHeight() / 2), dino, Color.BLUE, 50, 50);
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
        setContentPane(jPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }


}
