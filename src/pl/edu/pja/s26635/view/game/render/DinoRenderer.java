package pl.edu.pja.s26635.view.game.render;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.model.maze.Wall;
import pl.edu.pja.s26635.model.powerups.Apple;

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

    private boolean[][] visitedCells;

    public DinoRenderer(Dino dino, List<Enemy> enemies, int numRow, int numColumn) {
        this.dino = dino;
        this.enemies = enemies;
        this.numRow = numRow;
        this.numColumn = numColumn;
        this.visitedCells = new boolean[numRow][numColumn];
        dino.addPropertyChangeListener(event -> firePropertyChange("tableCellRenderer", null, null));
        for (Enemy enemy : enemies) {
            enemy.addPropertyChangeListener(event -> firePropertyChange("tableCellRenderer", null, null));
            mazeGeneration();
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setPreferredSize(table.getCellRect(row, column, false).getSize());

        if (value instanceof Dino) {
            dino.setRow(row);
            dino.setColumn(column);
            return dino;
        }else if (enemies.contains(value)) {
            Enemy enemy = (Enemy) value;
            enemy.setRow(row);
            enemy.setColumn(column);
            return enemy;

        }else if (visitedCells[row][column]) {
            return new Apple(table.getWidth() / numColumn, table.getHeight() / numRow, false);
        } else {
            return new Wall(table.getWidth() / numColumn, table.getHeight() / numRow);
        }

    }

    public void mazeGeneration(){
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numColumn; j++) {
                visitedCells[i][j] = false;
            }
        }

        Random rand = new Random();
        int startRow = rand.nextInt(numRow );
        int startColumn = rand.nextInt(numColumn);

        tracking(startRow, startColumn);
    }

    public void tracking(int row, int column){
        visitedCells[row][column] = true;

        List<int []> directionsList = new ArrayList<>();
        directionsList.add(new int[] {-2, 0});
        directionsList.add(new int[] {2, 0});
        directionsList.add(new int[] {0, -2});
        directionsList.add(new int[] {0, 2});
        Collections.shuffle(directionsList);

        for (int[] direction : directionsList){
            int newRow = row + direction[0];
            int newColumn = column + direction[1];

            if (newRow >= 0 && newRow < numRow && newColumn >= 0 && newColumn < numColumn && !visitedCells[newRow][newColumn]){
                int wallRow = row + (newRow - row) / 2;
                int wallColumn = column + (newColumn - column) / 2;
                visitedCells[wallRow][wallColumn] = true;
                tracking(newRow, newColumn);
            }
        }
    }
}
