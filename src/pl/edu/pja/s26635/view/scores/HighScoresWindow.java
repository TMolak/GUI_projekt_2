package pl.edu.pja.s26635.view.scores;

import pl.edu.pja.s26635.view.menu.MenuWindow;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class HighScoresWindow extends JFrame implements KeyListener {
    public HighScoresWindow(){
        generateFrame();
    }

    public void generateFrame(){
        HighScoreModel highScoreModel = new HighScoreModel();
        add(highScoreModel);


        setSize(1000,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        highScoreModel.addKeyListener(this);
        highScoreModel.setFocusable(true);
        highScoreModel.requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()){
            MenuWindow menuWindow = new MenuWindow();
            dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
