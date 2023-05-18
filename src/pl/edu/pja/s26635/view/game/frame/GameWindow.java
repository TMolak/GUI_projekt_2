package pl.edu.pja.s26635.view.game.frame;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.model.MyTableModel;
import pl.edu.pja.s26635.model.maze.Grass;
import pl.edu.pja.s26635.model.maze.Wall;
import pl.edu.pja.s26635.model.powerups.Apple;
import pl.edu.pja.s26635.view.game.render.DinoRenderer;
import pl.edu.pja.s26635.view.menu.MenuWindow;
import pl.edu.pja.s26635.view.scores.HighScoreModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Random;

public class GameWindow extends JFrame implements KeyListener {
    private Dino dino;
    private HighScoreModel highScoreModel;
    int x = SizeSelector.getValueX();

    int y = SizeSelector.getValueY();

    private int lifes = 3;

    private static int points = 0;


    private JLabel heart1;

    private JLabel heart2;

    private JLabel heart3;

    private int height = 800;

    private int width = 800;
    private JTable table;

    private JLabel score;
    private MyTableModel myTableModel;

    public GameWindow() {
        generateFrame();

        highScoreModel = new HighScoreModel();
    }

    public void generateFrame() {

        JPanel panel = new JPanel(new BorderLayout());
        score = new JLabel();
        heart1 = new JLabel(new ImageIcon("src/graphics/heart.png"));
        heart2 = new JLabel(new ImageIcon("src/graphics/heart.png"));
        heart3 = new JLabel(new ImageIcon("src/graphics/heart.png"));

        JPanel scorePanel = new JPanel();
        scorePanel.add(score);
        scorePanel.add(heart1);
        scorePanel.add(heart2);
        scorePanel.add(heart3);
        panel.add(scorePanel, BorderLayout.NORTH);


        if (x != 0 || y != 0) {
            myTableModel = new MyTableModel(x, y);
        }else{
            myTableModel = new MyTableModel(50, 50);
        }
        table = new JTable(myTableModel);

        int cellSize = Math.min(width / x, height / y);
        table.setRowHeight(cellSize);
        for (int i = 0; i < x; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(cellSize);
        }


        dino = new Dino(cellSize, cellSize, 5, 6);
        Enemy e1 = new Enemy(cellSize, cellSize, 2, 2);
        Enemy e2 = new Enemy(cellSize, cellSize, 5, 7);
        Enemy e3 = new Enemy(cellSize, cellSize, 2, 2);
        Enemy e4 = new Enemy(cellSize, cellSize, 5, 7);

        List<Enemy> enemies = new ArrayList<>();
        enemies.add(e1);
        enemies.add(e2);
        enemies.add(e3);
        enemies.add(e4);


        DinoRenderer renderer = new DinoRenderer(dino, enemies, x, y);

        myTableModel.setValueAt(dino, dino.getRow(), dino.getColumn());
        myTableModel.setValueAt(e1, e1.getRow(), e1.getColumn());
        myTableModel.setValueAt(e2, e2.getRow(), e2.getColumn());


        table.setDefaultRenderer(Object.class, renderer);

        table.setFocusable(true);
        table.addKeyListener(this);
        startEnemies(enemies);
        table.setRequestFocusEnabled(true);
        panel.add(table, BorderLayout.CENTER);
        scorePanel.setBackground(Color.GREEN);
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(table, BorderLayout.CENTER);
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            MenuWindow menuWindow = new MenuWindow();
            dispose();
        }
        int column = dino.getColumn();
        int row = dino.getRow();
        Grass grass = new Grass(dino.getWidth(),dino.getHeight(), row, column);
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (column > 0 && !illegalCell(row, column - 1)) {
                enemyTouch(row, column - 1);
                pointGain(row, column);
                myTableModel.setValueAt(grass, row, column);

                dino.setColumn(column - 1);
                myTableModel.setValueAt(dino, row, column - 1);
                myTableModel.setValueAt(grass, row, column);
                myTableModel.fireTableCellUpdated(row, column);
                myTableModel.fireTableCellUpdated(row, column - 1);
            }
            System.out.println("LEWO");
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (column < table.getColumnCount() - 1 && !illegalCell(row, column + 1)) {
                enemyTouch(row, column + 1);
                pointGain(row, column);
                myTableModel.setValueAt(null, row, column);

                dino.setColumn(column + 1);
                myTableModel.setValueAt(dino, row, column + 1);
                myTableModel.setValueAt(grass, row, column);
                myTableModel.fireTableCellUpdated(row, column);
                myTableModel.fireTableCellUpdated(row, column + 1);
            }
            System.out.println("PRAWO");
        } else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            if (row > 0 && !illegalCell(row - 1, column)) {
                enemyTouch(row - 1, column);
                pointGain(row, column);
                myTableModel.setValueAt(null, row, column);

                dino.setRow(row - 1);
                myTableModel.setValueAt(dino, row - 1, column);
                myTableModel.setValueAt(grass, row, column);
                myTableModel.fireTableCellUpdated(row, column);
                myTableModel.fireTableCellUpdated(row - 1, column);
            }
            System.out.println("GORA");
        } else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (row < table.getRowCount() - 1 && !illegalCell(row + 1, column)) {
                enemyTouch(row + 1, column);
                pointGain(row, column);
                myTableModel.setValueAt(null, row, column);

                dino.setRow(row + 1);
                myTableModel.setValueAt(dino, row + 1, column);
                myTableModel.setValueAt(grass, row, column);
                myTableModel.fireTableCellUpdated(row, column);
                myTableModel.fireTableCellUpdated(row + 1, column);
            }
            System.out.println("DOL");
        }
        score.setText("Score: " + points);
        table.requestFocus();
        table.setFocusable(true);
    }

    public void randomEnemyMove(Enemy enemy) {
        Random random = new Random();
        int row = enemy.getRow();
        int column = enemy.getColumn();
        int direction = random.nextInt(4);

        if (direction == 0) {
            if (row > 0 && !illegalCell(row - 1, column)) {
                myTableModel.setValueAt(null, row, column);
                enemy.setRow(row - 1);
                myTableModel.setValueAt(enemy, row - 1, column);
                myTableModel.fireTableCellUpdated(row, column);

            }
        } else if (direction == 1) {
            if (column < table.getColumnCount() - 1 && !illegalCell(row, column + 1)) {
                myTableModel.setValueAt(null, row, column);
                enemy.setColumn(++column);
                myTableModel.setValueAt(enemy, row, column);
                myTableModel.fireTableCellUpdated(row, column);

            }
        } else if (direction == 2) {
            if (row > 0 && !illegalCell(row - 1, column)) {
                myTableModel.setValueAt(null, row, column);
                enemy.setRow(--row);
                myTableModel.setValueAt(enemy, row, column);
                myTableModel.fireTableCellUpdated(row, column);

            }
        } else if (direction == 3) {
            if (row < table.getRowCount() - 1 && !illegalCell(row + 1, column)) {
                myTableModel.setValueAt(null, row, column);
                enemy.setRow(++row);
                myTableModel.setValueAt(enemy, row, column);
                myTableModel.fireTableCellUpdated(row, column);

            }
        }
    }

    public void startEnemies(List<Enemy> enemyList) {
        synchronized (enemyList) {
            for (Enemy enemy : enemyList) {
                Thread t1 = new Thread(() -> {
                    while (true) {
                        randomEnemyMove(enemy);
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t1.start();
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void pointGain(int row, int column) {
        Object obj = myTableModel.getValueAt(row, column);
        if (obj instanceof Apple) {
            points++;
            score.setText("Score: " + points);
            System.out.println("PUNKT: " + points);
        }
    }

    public boolean illegalCell(int row, int column) {
        Component component = table.getCellRenderer(row, column).getTableCellRendererComponent(table, null, true, true, row, column);
        return component instanceof Wall;

    }

    public boolean enemyTouch(int row, int column) {
        Object obj = myTableModel.getValueAt(row, column);
        if (obj instanceof Enemy) {
            lifes--;
            updateLife();
            return true;
        }
        return false;
    }

    public void updateLife() {
        if (lifes == 2) {
            heart3.setVisible(false);
        } else if (lifes == 1) {
            heart2.setVisible(false);
        } else {
            heart1.setVisible(false);

            String playerName = JOptionPane.showInputDialog(null, "Podaj swoje imię: ");

            String message = "Gracz: " + playerName + " zdobyl/a " + points + " punktow";

            try (FileWriter fw = new FileWriter("src/txtFiles/scores.txt", true)) {
                fw.write(playerName + " " + points + '\n');
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, message, "Koniec gry", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            MenuWindow menuWindow = new MenuWindow();
        }
    }
    public static void addPoints(){
        points++;
    }
}
