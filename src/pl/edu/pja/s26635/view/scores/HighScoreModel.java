package pl.edu.pja.s26635.view.scores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HighScoreModel extends JPanel {

    private JTable table;
private DefaultTableModel defaultTableModel;

    public HighScoreModel() {

        String[] columnNames = {"Player", "Score"};
        Object[][] scores = {{"Gracz 1", 1000},
                {"Gracz 2", 750}};

        defaultTableModel = new DefaultTableModel(scores, columnNames);

        table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public void getDataAfterGame(String playerName, int score){
        defaultTableModel.addRow(new Object[]{playerName, score});
    }


}
