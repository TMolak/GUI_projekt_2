package pl.edu.pja.s26635.model.powerups;

import javax.swing.*;
import java.awt.*;

public class Apple extends JComponent{
    private int width;

    private boolean collected;

    private ImageIcon imageIcon;
    private int height;

    private int row;

    private int column;


    public Apple(int width, int height, boolean collected) {
        this.width = width;
        this.height = height;
this.collected = collected;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    if (!collected){
        imageIcon = new ImageIcon("src/graphics/point.png");
    }else{
        imageIcon = new ImageIcon("src/graphics/grass2.png");
    }

        int imageWidth = imageIcon.getIconWidth();
        int imageHeight = imageIcon.getIconHeight();

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        g.drawImage(imageIcon.getImage(), x, y, imageWidth, imageHeight, this);
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
