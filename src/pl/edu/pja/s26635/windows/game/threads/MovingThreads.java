package pl.edu.pja.s26635.windows.game.threads;

import pl.edu.pja.s26635.model.Dino;


public class MovingThreads implements Runnable {

    private Dino dino;

//    private Enemy enemy;


    public MovingThreads(Dino dino) {
//        this.enemy = enemy;
        this.dino = dino;

    }

    @Override
    public void run() {
        synchronized (dino) {

            Thread t2 = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(80);

                    } catch (Exception e) {

                    }
                    dino.repaint();
                }
            });

//            Thread t1 = new Thread(() -> {
//                while (true) {
//                    try {
//                        Thread.sleep(80);
//                    } catch (Exception e) {
//
//                    }
//                    enemy.repaint();
//                }
//            });

//            t1.start();
            t2.start();
        }
    }


}
