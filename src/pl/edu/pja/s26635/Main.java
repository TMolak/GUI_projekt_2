package pl.edu.pja.s26635;

import pl.edu.pja.s26635.view.game.frame.GameWindow;
import pl.edu.pja.s26635.view.menu.MenuWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        SwingUtilities.invokeLater(()->new MenuWindow());
//        SwingUtilities.invokeLater(()->new GameBoard());
        SwingUtilities.invokeLater(() -> new GameWindow());
    }
}