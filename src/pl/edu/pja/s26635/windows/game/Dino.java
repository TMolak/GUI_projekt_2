package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;

public class Dino extends JComponent {

    private int startX;
    private int startY;
    private int changeX = 5;


    public Dino(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;

        Thread runningDino = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });
        runningDino.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.startX += changeX;

        if (startX + 50 >= getWidth() || startX <= 0) {
            changeX = -changeX;
        }
        g.setColor(Color.GREEN);
        g.fillOval(this.startX, this.startY, 50, 50);

    }


}
