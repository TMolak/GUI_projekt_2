package pl.edu.pja.s26635.view.game.frame;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.view.game.render.DinoRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameWindow extends JFrame implements KeyListener {
    Dino dino;
    JTable table;
    DefaultTableModel tableModel;

    public GameWindow() {
        generateFrame();
    }

    public void generateFrame() {
        tableModel = new DefaultTableModel(SizeSelector.getValueX(), SizeSelector.getValueY());
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setRowHeight(55);
        for (int i = 0; i < SizeSelector.getValueX(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(55);
        }
        dino = new Dino(40, 40, 5, 6);

        Enemy e1 = new Enemy(40, 40, 2, 2, Color.BLUE);
        Enemy e2 = new Enemy(40, 40, 3, 3, Color.ORANGE);

        DinoRenderer renderer = new DinoRenderer(dino, e1, SizeSelector.getValueX(), SizeSelector.getValueY());

        tableModel.setValueAt(dino, dino.getRow(), dino.getColumn());

        tableModel.setValueAt(e1, e1.getRow(), e1.getColumn());
        tableModel.setValueAt(e2, e2.getRow(), e2.getColumn());


        table.setDefaultRenderer(Object.class, renderer);

        table.setFocusable(true);
        table.addKeyListener(this);
        startEnemy(e1);
        startEnemy(e2);
        table.setRequestFocusEnabled(true);
        table.setBackground(Color.BLACK);
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
            if (column > 0 && !illegalCell(row, column - 1)) {
                tableModel.setValueAt(null, row, column);
                dino.setColumn(--column);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("LEWO");
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (column < table.getColumnCount() - 1 && !illegalCell(row, column + 1)) {
                tableModel.setValueAt(null, row, column);
                dino.setColumn(++column);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("PRAWO");

        } else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            if (row > 0 && !illegalCell(row - 1, column)) {
                tableModel.setValueAt(null, row, column);
                dino.setRow(--row);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("GORA");

        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (row < table.getRowCount() - 1 && !illegalCell(row + 1, column)) {
                tableModel.setValueAt(null, row, column);
                dino.setRow(++row);
                tableModel.setValueAt(dino, row, column);
            }
            System.out.println("DOL");

        }

    }
    public void randomEnemyMove(Enemy enemy) {
        Random random = new Random();
        int row = enemy.getRow();
        int column = enemy.getColumn();
        int direction = random.nextInt(4);

        if (direction == 0) {
            if (row > 0 && !illegalCell(row - 1, column)) {
                tableModel.setValueAt(null, row, column);
                enemy.setRow(row - 1);
                tableModel.setValueAt(enemy, row - 1, column);
            }
        }else if(direction ==1){
            if (column < table.getColumnCount() - 1 && !illegalCell(row, column + 1)) {
                tableModel.setValueAt(null, row, column);
                enemy.setColumn(++column);
                tableModel.setValueAt(enemy, row, column);
            }
        }else if (direction == 2){
            if (row > 0 && !illegalCell(row - 1, column)) {
                tableModel.setValueAt(null, row, column);
                enemy.setRow(--row);
                tableModel.setValueAt(enemy, row, column);
            }

        }else if (direction == 3){
            if (row < table.getRowCount() - 1 && !illegalCell(row + 1, column)) {
                tableModel.setValueAt(null, row, column);
                enemy.setRow(++row);
                tableModel.setValueAt(enemy, row, column);
            }
        }
    }

    public void startEnemy(Enemy enemy){
        Thread t1 = new Thread(()->{
           while(true){
               randomEnemyMove(enemy);
               try{
                   Thread.sleep(800);
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
        });
        t1.start();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public boolean illegalCell(int row, int column) {
        Component component = table.getCellRenderer(row, column).getTableCellRendererComponent(table, null, true, true, row, column);
        Color color = component.getBackground();
        return color.equals(Color.RED);
    }

}
