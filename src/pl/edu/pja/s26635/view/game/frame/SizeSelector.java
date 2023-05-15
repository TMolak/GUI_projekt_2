package pl.edu.pja.s26635.view.game.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizeSelector extends JFrame {

    private static int valueX;

    private static int valueY;


    public SizeSelector() {
        super("Size Selector");
        generateFrame();
    }

    public void generateFrame() {

        setLayout(new BorderLayout());

        JLabel labelX = new JLabel("Wartosc x = " + 50);
        JLabel labelY = new JLabel("Wartosc y = " + 50);

        JSlider sliderX = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);
        JSlider sliderY = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);

        sliderX.addChangeListener(n -> {
            valueX = sliderX.getValue();
            labelX.setText("Wartosc x = " + valueX);
        });

        sliderY.setMajorTickSpacing(10);
        sliderY.setMinorTickSpacing(5);
        sliderY.addChangeListener(n -> {
            valueY = sliderY.getValue();
            labelY.setText("Wartosc y = " + valueY);
        });

        JButton startGameButton = new JButton("Start game");

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                GameWindoweBeta gameWindoweBeta = new GameWindoweBeta();
                GameWindow gameWindow = new GameWindow();
            }
        });

        JPanel jPanel = new JPanel(new GridLayout(3, 1));
        jPanel.add(sliderX);
        jPanel.add(labelX);
        jPanel.add(sliderY);
        jPanel.add(labelY);
        jPanel.add(startGameButton);
        getContentPane().add(jPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);

    }

    public static int getValueX() {
        return valueX;
    }

    public static int getValueY() {
        return valueY;
    }
}
