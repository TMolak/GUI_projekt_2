package pl.edu.pja.s26635.model;

import javax.swing.*;
import java.awt.*;

public class Wall extends JComponent {

    private int width;

    private int height;

    private int row;

    private int column;


    public Wall(int width, int height, int row, int column) {
        this.width = width;
        this.height = height;
        this.row = row;
        this.column = column;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("src/graphics/wall.png");

        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        g.drawImage(imageIcon.getImage(), x, y, imageWidth, imageHeight, this);
    }
}
