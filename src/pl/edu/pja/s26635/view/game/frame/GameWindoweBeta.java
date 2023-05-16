package pl.edu.pja.s26635.view.game.frame;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.view.game.render.MazeRenderer;
import pl.edu.pja.s26635.windows.game.threads.MovingThreads;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameWindoweBeta extends JFrame  {
    private Dino dino;
    private List<Enemy> enemyList;

    public GameWindoweBeta() {
        generateFrame();
    }

    public void generateFrame() {
        JPanel jPanel = new JPanel();

        JTable jTable = new JTable(SizeSelector.getValueX(), SizeSelector.getValueY());
        jTable.setRowHeight(55);
        for (int i = 0; i < SizeSelector.getValueX(); i++) {
            jTable.getColumnModel().getColumn(i).setPreferredWidth(55);
        }
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        //rysowanie pol
        MazeRenderer renderer = new MazeRenderer();

        jTable.setDefaultRenderer(Object.class, renderer);

        jPanel.setLayout(new OverlayLayout(jPanel));

        setSize(800, 800);

        dino = new Dino(50, 50, 5, 6);

//        Enemy enemy2 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.RED, 50, 50);
//        Enemy enemy3 = new Enemy((frame.getWidth() / 2), (frame.getHeight() / 2), dino, Color.YELLOW, 50, 50);

        enemyList = new ArrayList<>();

//        enemyList.add(enemy2);
//        enemyList.add(enemy3);

        MovingThreads movingThreads = new MovingThreads(dino);
        movingThreads.run();
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();

        jPanel.add(jTable);
        jTable.add(dino);

//        jPanel.add(enemy2);
//        jPanel.add(enemy3);
        setContentPane(jPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        jTable.requestFocusInWindow();
    }


}
