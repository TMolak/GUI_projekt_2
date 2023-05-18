package pl.edu.pja.s26635.view.game.render;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.model.maze.Grass;
import pl.edu.pja.s26635.model.maze.Wall;
import pl.edu.pja.s26635.model.powerups.Apple;
import pl.edu.pja.s26635.view.game.frame.GameWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class DinoRenderer extends DefaultTableCellRenderer{

    private Dino dino;

    private List<Enemy> enemies;
//    private Enemy enemy;
    private int numRow;
    private int numColumn;

    private boolean[][] cells;

    private Random random = new Random();

    public DinoRenderer(Dino dino, List<Enemy> enemies, int numRow, int numColumn) {
        this.dino = dino;
        this.enemies = enemies;
        this.numRow = numRow;
        this.numColumn = numColumn;
        this.cells = new boolean[numRow][numColumn];
        dino.addPropertyChangeListener(event -> firePropertyChange("tableCellRenderer", null, null));
        for (Enemy enemy : enemies) {
            enemy.addPropertyChangeListener(event -> firePropertyChange("tableCellRenderer", null, null));
        }
        mazeGeneration();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setPreferredSize(table.getCellRect(row, column, false).getSize());
        Apple apple = new Apple(dino.getWidth(), dino.getHeight(), row, column);
        Grass grass = new Grass(dino.getWidth(),dino.getHeight(), row, column);
        Wall wall = new Wall(dino.getWidth(), dino.getHeight());
        if (value instanceof Dino) {
            dino.setRow(row);
            dino.setColumn(column);
            return dino;
        }else if (enemies.contains(value)) {
            Enemy enemy = (Enemy) value;
            enemy.setRow(row);
            enemy.setColumn(column);
            return enemy;
        }else if (cells[row][column]) {
            if (value instanceof Apple){
                apple.setRow(row);
                apple.setColumn(column);
                return apple;
            }else if (value instanceof Grass){
                GameWindow.addPoints();
                grass.setRow(row);
                grass.setColumn(column);
                return grass;
            }
        } else if (random.nextInt(10) <= 6){
            return wall;
        }else{
            return wall;
        }
        return apple;
    }

    public void mazeGeneration(){
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numColumn; j++) {
                cells[i][j] = false;
            }
        }

        Random rand = new Random();
        int startRow = rand.nextInt(numRow );
        int startColumn = rand.nextInt(numColumn);

        tracking(startRow, startColumn);
    }

    public void tracking(int row, int column){
        cells[row][column] = true;

        List<int []> directionsList = new ArrayList<>();
        directionsList.add(new int[] {-2, 0});
        directionsList.add(new int[] {2, 0});
        directionsList.add(new int[] {0, -2});
        directionsList.add(new int[] {0, 2});
        Collections.shuffle(directionsList);

        for (int[] direction : directionsList){
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if (newRow >= 0 && newRow < numRow && newColumn >= 0 && newColumn < numColumn && !cells[newRow][newColumn]){
                int wallRow = row + (newRow - row) / 2;
                int wallColumn = column + (newColumn - column) / 2;
                cells[wallRow][wallColumn] = true;
                tracking(newRow, newColumn);
            }
        }
    }
}
