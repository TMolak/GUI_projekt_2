package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends JComponent {

    private int startX;

    private int startY;

    private int change = 8;

    private int dinoX;

    private int dinoY;

    public Enemy(int max, int min, Dino dino){

        this.dinoX = dino.getStartX();
        this.dinoY = dino.getStartY();

        Random random = new Random();

        this.startX = random.nextInt(max - min) + min;
        this.startY = random.nextInt(max - min) + min;

        Thread runningEnemy = new Thread(new Runnable() {
            @Override
            public void run() {
                repaint();
                try {
                    Thread.sleep(80);
                } catch (Exception e) {

                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);



        g.setColor(Color.RED);
        g.fillOval(this.startX, this.startY, 50, 50);
    }

    public void playerFollow(){

    }
}
