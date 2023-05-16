package pl.edu.pja.s26635.model;

import javax.swing.*;
import java.awt.*;


public class Dino extends JComponent{


    private int width;

    private int height;

    private int column;

    private int row;


    public Dino(int width, int height, int column, int row) {
        this.width = width;
        this.height = height;
        this.column = column;
        this.row = row;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("src/graphics/dino_walk_1.png");

        g.drawImage(imageIcon.getImage(), 0,0, width, height, this);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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

}
