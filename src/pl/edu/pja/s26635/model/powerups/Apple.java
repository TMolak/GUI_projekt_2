package pl.edu.pja.s26635.model.powerups;

import javax.swing.*;
import java.awt.*;

public class Apple extends JComponent {
    private int width;


    private int height;

    private int row;

    private int column;


    public Apple(int width, int height, int row, int column) {
        this.width = width;
        this.height = height;
        this.row = row;
        this.column = column;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("src/graphics/apple.png");

        g.drawImage(imageIcon.getImage(), 0, 0, width, height, this);
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
