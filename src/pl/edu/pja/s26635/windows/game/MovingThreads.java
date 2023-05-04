//package pl.edu.pja.s26635.windows.game;
//
//import java.util.List;
//
//public class MovingThreads implements Runnable {
//    private Dino dino;
//    private List<Enemy> enemyList;
//
//    public MovingThreads(Dino dino, List<Enemy> enemyList) {
//        this.dino = dino;
//        this.enemyList = enemyList;
//    }
//
//    @Override
//    public void run() {
//        Thread t1 = new Thread(() -> {
//            dino.runningDino();
//        });
//        Thread t2 = new Thread(enemyList.get(0)::runningEnemy);
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//
//        }
//
//
//    }
//}
