//package pl.edu.pja.s26635.windows.game;
//
//import pl.edu.pja.s26635.windows.game.threads.MovingThreads;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GameLogic extends JPanel{
//
//    private Dino dino;
//
//    private List<Enemy> enemyList;
//
//    public GameLogic(){
//        generateFrame();
//    }
//    public void generateFrame(){
//        JFrame frame = new JFrame("Dino Game");
//        JPanel jPanel = new JPanel();
//
//
//        jPanel.setLayout(new OverlayLayout(jPanel));
//        frame.setSize(1000, 800);
//        dino = new Dino((800 / 2), (getHeight() / 2), 50, 50);
//        Enemy enemy1 = new Enemy((800 / 2), (600 / 2), dino, Color.BLUE, 50, 50);
//        Enemy enemy2 = new Enemy((800 / 2), (600 / 2), dino, Color.RED, 50, 50);
//        Enemy enemy3 = new Enemy((800 / 2), (600 / 2), dino, Color.YELLOW, 50, 50);
//        enemyList = new ArrayList<>();
//        enemyList.add(enemy1);
//        enemyList.add(enemy2);
//        enemyList.add(enemy3);
//
//        Thread movingThread = new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                for (Enemy enemy : enemyList) {
//                    enemy.randomMove();
//                    if (dino.getBounds().intersects(enemy.getBounds())) {
//                        System.out.println("Dino dotknął wroga!");
//                    }
//                }
//                repaint();
//            }
//        });
//        movingThread.start();
//        jPanel.add(dino);
//        jPanel.add(enemy1);
//        jPanel.add(enemy2);
//        jPanel.add(enemy3);
//
//        frame.setContentPane(jPanel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        dino.paintComponent(g);
//        for (Enemy enemy : enemyList) {
//            enemy.paintComponent(g);
//        }
//    }
//
//}
