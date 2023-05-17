package pl.edu.pja.s26635.model;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private int row;

    private int column;

    public TableModel(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
