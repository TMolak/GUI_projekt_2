package pl.edu.pja.s26635;

import pl.edu.pja.s26635.windows.menu.MenuWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SwingUtilities.invokeLater(()->new MenuWindow());
    }
}