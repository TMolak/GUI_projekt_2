package pl.edu.pja.s26635.view.game.render;

import pl.edu.pja.s26635.model.Dino;
import pl.edu.pja.s26635.model.Enemy;
import pl.edu.pja.s26635.model.Grass;
import pl.edu.pja.s26635.model.Wall;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.List;

public class DinoRenderer extends DefaultTableCellRenderer {

    private Dino dino;

//    private List enemies;
    private Enemy enemy;
    private int numRow;
    private int numColumn;

    public DinoRenderer(Dino dino, Enemy enemy, int numRow, int numColumn) {
        this.dino = dino;
//        this.enemies = enemies;
        this.enemy = enemy;
        this.numRow = numRow;
        this.numColumn = numColumn;

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
        }
        if (value instanceof Enemy){
            return enemy;
        }
        if ((row % 2) == 0 && (column % 2) == 0) {
            component = new Wall(table.getWidth() / numColumn, table.getHeight() / numRow, row, column);
        } else if (row == 0 || row == numRow - 1 || column == 0 || column == numColumn - 1) {
            component = new Wall(table.getWidth() / numColumn, table.getHeight() / numRow, row, column);
        } else {
            component = new Grass(table.getWidth() / numColumn, table.getHeight() / numRow, row, column);
        }


        return component;
    }
}
