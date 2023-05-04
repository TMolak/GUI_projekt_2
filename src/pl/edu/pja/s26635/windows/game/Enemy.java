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
    private Color color;

    public Enemy(int maxX, int maxY, Dino dino, Color color) {
        this.color = color;
        this.dinoX = dino.getStartX();
        this.dinoY = dino.getStartY();

        Random random = new Random();

        this.startX = random.nextInt(maxX - 1) + 1;
        this.startY = random.nextInt(maxY - 1) + 1;

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        randomMove();
        g.setColor(color);
        g.fillOval(this.startX, this.startY, 50, 50);
    }

    public synchronized void randomMove() {

        Random random = new Random();
        int direction = random.nextInt(5);
        if (direction == 0) {
            startX -= change;
            if (startX <= 0) {
                startX = 0;
            }
        } else if (direction == 1) {
            startX += change;
            if (startX + 50 >= getWidth()) {
                startX = getWidth() - 50;
            }
        } else if (direction == 2) {
            startY -= change;
            if (startY <= 0) {
                startY = 0;
            }
        } else if (direction == 3) {
            startY += change;
            if (startY + 50 >= getHeight()) {
                startY = getHeight() - 50;
            }
        }
    }
}
