package pl.edu.pja.s26635.view.menu;

import pl.edu.pja.s26635.view.game.frame.SizeSelector;
import pl.edu.pja.s26635.view.scores.HighScoresWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    public MenuWindow() {
        generateFrame();
    }

    public void generateFrame() {

        JButton newGameButton = new JButton("New Game");
        JButton scoresButton = new JButton("High Scores");
        JButton instructionButton = new JButton("Instrukcja");
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
        instructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel jPanel = new JPanel(new GridLayout(3, 3));

        jPanel.add(newGameButton);
        jPanel.add(scoresButton);
        jPanel.add(exitButton);

        add(jPanel);

        setSize(800, 600);
        setContentPane(jPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
