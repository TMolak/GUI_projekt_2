package pl.edu.pja.s26635.windows.game.model;

import pl.edu.pja.s26635.model.Dino;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if ((row % 2) == 0 && (column % 2) == 0) {
            component.setBackground(Color.RED);
        } else {
            component.setBackground(table.getBackground());
        }
        if (value instanceof Dino) {

            return (Component) value;
        }

        return component;

    }

}
