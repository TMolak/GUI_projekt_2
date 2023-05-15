package pl.edu.pja.s26635.view.game;

import pl.edu.pja.s26635.model.Dino;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class DinoRenderer extends DefaultTableCellRenderer {

    private Dino dino;

    public DinoRenderer(Dino dino) {
        this.dino = dino;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof Dino) {
            dino.setRow(row);
            dino.setColumn(column);
            return dino;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
