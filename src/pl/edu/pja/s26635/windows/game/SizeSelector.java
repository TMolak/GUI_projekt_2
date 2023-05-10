package pl.edu.pja.s26635.windows.game;

import javax.swing.*;
import java.awt.*;

public class SizeSelector extends JFrame {

    private int valueX;

    private int valueY;


    public SizeSelector(){
        super("Size Selector");
        generateFrame();
    }

    public void generateFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel labelX = new JLabel();
        JLabel labelY = new JLabel();

        JSlider sliderX = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);
        JSlider sliderY = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);

        sliderX.setMajorTickSpacing(10);
        sliderX.setMinorTickSpacing(5);
        sliderX.addChangeListener(n ->{
           valueX = sliderX.getValue();
            labelX.setText("Wartosc x = "+ valueX);
        });

        sliderY.setMajorTickSpacing(10);
        sliderY.setMinorTickSpacing(5);
        sliderY.addChangeListener(n ->{
            valueY = sliderY.getValue();
            labelY.setText("Wartosc y = "+ valueY);
        });

        JPanel jPanel = new JPanel(new GridLayout(3, 1));
        jPanel.add(sliderX);
        jPanel.add(labelX);
        jPanel.add(sliderY);
        jPanel.add(labelY);

        getContentPane().add(jPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
}
