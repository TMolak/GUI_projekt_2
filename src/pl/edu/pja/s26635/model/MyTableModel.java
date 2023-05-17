package pl.edu.pja.s26635.model;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

    private int row;

    private int column;

    private Object[][] obj;

    public MyTableModel(int row, int column) {
        this.row = row;
        this.column = column;
        this.obj = new Object[row][column];
    }

    @Override
    public int getRowCount() {
        return row;
    }

    @Override
    public int getColumnCount() {
        return column;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return obj[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        obj[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(row, column);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
