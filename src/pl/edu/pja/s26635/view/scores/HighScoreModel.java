package pl.edu.pja.s26635.view.scores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HighScoreModel extends JPanel {

    private JTable table;

    public HighScoreModel() {
        String[] columnNames = {"Player", "Score"};
        Object[][] scores = {{"Gracz 1", 1000},
                {"Gracz 2", 750}};

        DefaultTableModel defaultTableModel = new DefaultTableModel(scores, columnNames);

        table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

 }
