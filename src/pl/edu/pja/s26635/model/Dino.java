package pl.edu.pja.s26635.model;

import javax.swing.*;
import java.awt.*;


public class Dino extends JComponent{


    private int width;

    private int height;


    public Dino(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("src/graphics/dino_walk_1.png");

        g.drawImage(imageIcon.getImage(), 0,0, width, height, this);
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
