package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy extends JComponent {

    private int startX;

    private int startY;

    private int width;

    private int height;
    private int currentDirection = 0;
    private int change = 8;

    private int dinoX;

    private int dinoY;
    private Color color;

    public Enemy(int maxX, int maxY, Dino dino, Color color, int width, int height) {
        this.color = color;
        this.dinoX = dino.getStartX();
        this.dinoY = dino.getStartY();
        this.width = width;
        this.height = height;
        Random random = new Random();

        this.startX = random.nextInt(maxX - 1) + 1;
        this.startY = random.nextInt(maxY - 1) + 1;

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        randomMove();
        g.setColor(color);
        g.fillOval(this.startX, this.startY, width, height);
    }

    public void randomMove() {

        Random random = new Random();
        int direction = random.nextInt(10);
        if (direction == 0 || direction == 1) {
            currentDirection = random.nextInt(4);
        }
        if (currentDirection == 1) {
            startX -= change;
            if (startX <= 0) {
                startX = 0;
            }
        } else if (currentDirection == 2) {
            startX += change;
            if (startX + 50 >= getWidth()) {
                startX = getWidth() - 50;
            }
        } else if (currentDirection == 3) {
            startY -= change;
            if (startY <= 0) {
                startY = 0;
            }
        } else if (currentDirection == 4) {
            startY += change;
            if (startY + 50 >= getHeight()) {
                startY = getHeight() - 50;
            }
        }
    }
}
