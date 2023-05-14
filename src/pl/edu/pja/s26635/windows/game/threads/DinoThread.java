package pl.edu.pja.s26635.windows.game.threads;

import pl.edu.pja.s26635.model.Dino;

public class DinoThread extends Thread{
    private Dino dino;

    public DinoThread(Dino dino){
        this.dino = dino;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(80);
            } catch (Exception e) {

            }
            dino.repaint();
        }
    }
}
