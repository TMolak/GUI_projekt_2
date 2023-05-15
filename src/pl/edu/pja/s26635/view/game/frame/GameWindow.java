package pl.edu.pja.s26635.view.game.frame;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.view.game.render.DinoRenderer;
import pl.edu.pja.s26635.view.game.render.MazeRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {
    Dino dino;
    JTable table;
    DefaultTableModel tableModel;
    public GameWindow() {
        generateFrame();
    }

    public void generateFrame() {
        tableModel = new DefaultTableModel(SizeSelector.getValueX(), SizeSelector.getValueY());
//        tableModel = new DefaultTableModel(10, 10);
        table = new JTable(tableModel);

        table.setRowHeight(55);
        for (int i = 0; i < SizeSelector.getValueX(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(55);
        }
        dino = new Dino(40, 40, 4, 6);
        DinoRenderer renderer = new DinoRenderer(dino);
        MazeRenderer mazeRenderer = new MazeRenderer();

        tableModel.setValueAt(dino, dino.getRow(), dino.getColumn());
        table.setDefaultRenderer(Object.class, renderer);
        table.setDefaultRenderer(Object.class, mazeRenderer);

        table.setFocusable(true);
        table.addKeyListener(this);
        table.setRequestFocusEnabled(true);

        setContentPane(table);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int column = dino.getColumn();
        int row = dino.getRow();
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (column > 0) {
                tableModel.setValueAt(null, row, column);
                dino.setColumn(--column);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("LEWO");
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (column < table.getColumnCount() - 1) {
                tableModel.setValueAt(null, row, column);
                dino.setColumn(++column);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("PRAWO");

        } else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            if (row > 0) {
                tableModel.setValueAt(null, row, column);
                dino.setRow(--row);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("GORA");

        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (row < table.getRowCount() - 1) {
                tableModel.setValueAt(null, row, column);
                dino.setRow(++row);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("DOL");

        }

    }
//
//    public boolean illegalCell(){
//        if ()
//    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
