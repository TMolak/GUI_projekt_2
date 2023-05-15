package pl.edu.pja.s26635.windows.game.threads;

import javax.swing.*;

public class TestThread implements Runnable{
    private JPanel jPanel;

    public TestThread(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jPanel.repaint();
        }
    }
}
