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

        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        g.drawImage(imageIcon.getImage(), x, y, imageWidth, imageHeight, this);
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
