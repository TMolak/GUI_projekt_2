package pl.edu.pja.s26635.view.game.render;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.model.maze.Grass;
import pl.edu.pja.s26635.model.maze.Wall;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;


public class DinoRenderer extends DefaultTableCellRenderer {

    private Dino dino;

    private List<Enemy> enemies;
//    private Enemy enemy;
    private int numRow;
    private int numColumn;

    public DinoRenderer(Dino dino, List<Enemy> enemies, int numRow, int numColumn) {
        this.dino = dino;
        this.enemies = enemies;
        this.numRow = numRow;
        this.numColumn = numColumn;
        dino.addPropertyChangeListener(evt -> firePropertyChange("tableCellRenderer", null, null));
        for (Enemy enemy : enemies) {
            enemy.addPropertyChangeListener(evt -> firePropertyChange("tableCellRenderer", null, null));
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
        }else if ((row % 2) == 0 && (column % 2) == 0) {
            component = new Wall(table.getWidth() / numColumn, table.getHeight() / numRow, row, column);
        } else if (row == 0 || row == numRow - 1 || column == 0 || column == numColumn - 1) {
            component = new Wall(table.getWidth() / numColumn, table.getHeight() / numRow, row, column);
        } else {
            component = new Grass(table.getWidth() / numColumn, table.getHeight() / numRow, row, column);
        }
        return component;
    }
}
