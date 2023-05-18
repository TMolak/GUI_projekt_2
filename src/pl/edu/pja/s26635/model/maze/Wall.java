package pl.edu.pja.s26635.model.maze;

import javax.swing.*;
import java.awt.*;

public class Wall extends JComponent {

    private int width;

    private int height;

    private int row;

    private int column;


    public Wall(int width, int height) {
        this.width = width;
        this.height = height;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIcon = new ImageIcon("src/graphics/wall.png");

        g.drawImage(imageIcon.getImage(), 0, 0, width, height, this);
    }
}
