package pl.edu.pja.s26635.controller;

import pl.edu.pja.s26635.model.Dino;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DinoController implements KeyListener {

    private Dino dino;

    private int change = 4;

    private int column;
    private int row;

    private JTable table;

    private boolean leftPress = false;
    private boolean rightPress = false;
    private boolean upPress = false;
    private boolean downPress = false;


    public DinoController(Dino dino, int change, int row, int column, JTable table) {
        this.dino = dino;
        this.change = change;
        this.column = column;
        this.row = row;
        this.table = table;
    }

    public KeyListener positionChange() {
        if (leftPress) {
            if (column > 0) {
                column--;
            }
        } else if (rightPress) {
            if (column < table.getColumnCount() - 1) {
                column++;
            }
        } else if (upPress) {
            if (row > 0) {
                row--;
            }
        } else if (downPress) {
            if (row < table.getRowCount() - 1) {
                row++;
            }
        }
        dino.repaint();
        return null;
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

}
