package pl.edu.pja.s26635.windows.game.threads;

import pl.edu.pja.s26635.windows.game.Dino;
import pl.edu.pja.s26635.windows.game.Enemy;

import java.util.List;

public class MovingThreads implements Runnable {

    //    private final DinoThread dinoThread;
    private Dino dino;

    private Enemy enemy;
//    private List<Enemy> enemyList;

    public MovingThreads(Dino dino, Enemy enemy) {
        this.enemy = enemy;
        this.dino = dino;
    }

    @Override
    public void run() {
        synchronized (enemy) {
            Thread t2 = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(80);
                    } catch (Exception e) {

                    }
                    dino.repaint();
                }
            });

            Thread t1 = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(80);
                    } catch (Exception e) {

                    }
                    enemy.repaint();
                }
            });
            t1.start();
            t2.start();
        }
    }


}
