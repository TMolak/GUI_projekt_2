package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;

public class Dino extends JComponent {

    private int startX = (int) CENTER_ALIGNMENT;
    private int startY = (int) CENTER_ALIGNMENT;
    private int changeX = 5;


    public Dino() {
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

        startX += changeX;

        if (startX + 50 >= getWidth() || startX <= 0) {
            changeX = -changeX;
        }
        g.setColor(Color.GREEN);
        g.fillOval(startX, startY, 50, 50);

    }


}
