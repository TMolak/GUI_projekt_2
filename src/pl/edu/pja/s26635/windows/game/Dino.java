package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Dino extends JComponent implements KeyListener {

//    private int startX;
    private int column;
//    private int startY;
    private int row;

    private int width;

    private int height;

    private int change = 1;


    private boolean leftPress = false;
    private boolean rightPress = false;
    private boolean upPress = false;
    private boolean downPress = false;


    public Dino(int column, int row, int width, int height) {

        this.column = column;
        this.row = row;
        this.width = width;
        this.height = height;

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        changePosition();
        ImageIcon imageIcon = new ImageIcon("src/graphics/dino_walk_1.png");

        g.drawImage(imageIcon.getImage(),this.column, this.row, this);

    }

    public void changePosition() {
        if (leftPress) {
            if (column > 0 && !illegalCell()) {
                column--;
            }
        } else if (rightPress) {
            if (column < getWidth()-1 && !illegalCell()) {
                column++;
            }
        } else if (upPress && !illegalCell()) {
            if (row > 0) {
                row--;
            }
        } else if (downPress && !illegalCell()) {
            if (row < getHeight()-1) {
                row++;
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPress = true;
            rightPress = false;
            upPress = false;
            downPress = false;
            System.out.println("LEWO");
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            leftPress = false;
            rightPress = true;
            upPress = false;
            downPress = false;
            System.out.println("PRAWO");

        } else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            leftPress = false;
            rightPress = false;
            upPress = true;
            downPress = false;
            System.out.println("GORA");

        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
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

    private boolean illegalCell(){
        if ((this.row % 2) == 0 && (this.column%2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getStartColumn() {
        return column;
    }

    public int getStartRow() {
        return column;
    }


}
