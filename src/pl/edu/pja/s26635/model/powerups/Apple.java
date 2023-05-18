package pl.edu.pja.s26635.model.powerups;

import javax.swing.*;
import java.awt.*;

public class Apple extends JComponent {
    private int width;

    private ImageIcon imageIcon;
    private int height;

    private int row;

    private int column;


    public Apple(int width, int height, ImageIcon imageIcon) {
        this.width = width;
        this.height = height;
        this.imageIcon = imageIcon;

    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(imageIcon.getImage(), width, height, this);
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
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
