package pl.edu.pja.s26635.windows.menu;

import pl.edu.pja.s26635.windows.game.GameWindow;
import pl.edu.pja.s26635.windows.scores.HighScoresWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    public MenuWindow() {
        generateFrame();
    }
    public void generateFrame(){

        JButton newGameButton = new JButton("New Game");
        JButton scoresButton = new JButton("High Scores");
        JButton exitButton = new JButton("Exit");

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameWindow gameWindow = new GameWindow();
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

        jPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        jPanel.add(newGameButton);
        jPanel.add(scoresButton);
        jPanel.add(exitButton);


        add(jPanel);

        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
