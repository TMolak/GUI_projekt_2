package pl.edu.pja.s26635.windows.menu;

import pl.edu.pja.s26635.windows.game.GameWindow;
import pl.edu.pja.s26635.windows.game.SizeSelector;
import pl.edu.pja.s26635.windows.scores.HighScoresWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    public MenuWindow() {
        generateFrame();
    }

    public void generateFrame() {
        JFrame menuFrame = new JFrame("Menu");

        JButton newGameButton = new JButton("New Game");
        JButton scoresButton = new JButton("High Scores");
        JButton exitButton = new JButton("Exit");

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                GameWindow gameWindow = new GameWindow();
                SizeSelector sizeSelector = new SizeSelector();
            }
        });

        scoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HighScoresWindow highScoresWindow = new HighScoresWindow();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(3, 1));


        jPanel.add(newGameButton);
        jPanel.add(scoresButton);
        jPanel.add(exitButton);

        menuFrame.setLayout(new BorderLayout());
        menuFrame.add(jPanel, BorderLayout.CENTER);

        menuFrame.setSize(800, 600);
        menuFrame.setContentPane(jPanel);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }
}
