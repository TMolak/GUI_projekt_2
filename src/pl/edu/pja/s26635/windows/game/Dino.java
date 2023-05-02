package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Dino extends JComponent implements KeyListener {

    private int startX;
    private int startY;
    private int change = 5;

    private boolean leftPress = false;
    private boolean rightPress = false;
    private boolean upPress = false;
    private boolean downPress = false;


    public Dino(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
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
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        changePosition();

        g.setColor(Color.GREEN);
        g.fillOval(this.startX, this.startY, 50, 50);

    }

    public void changePosition() {
        if (leftPress) {
            startX -= change;
            if (startX <= 0){
                startX = 0;
            }
        } else if (rightPress) {
            startX += change;
            if (startX + 50  >= getWidth()){
                startX = getWidth()-50;
            }
        } else if (upPress) {
            startY -= change;
            if (startY <= 0){
                startY = 0;
            }
        } else if (downPress) {
            startY += change;
            if (startY + 50 >= getHeight()){
                startY = getHeight() - 50;
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPress = true;
            rightPress = false;
            upPress = false;
            downPress = false;
            System.out.println("LEWO");
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            leftPress = false;
            rightPress = true;
            upPress = false;
            downPress = false;
            System.out.println("PRAWO");

        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            leftPress = false;
            rightPress = false;
            upPress = true;
            downPress = false;
            System.out.println("GORA");

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            leftPress = false;
            rightPress = false;
            upPress = false;
            downPress = true;
            System.out.println("DOL");

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
