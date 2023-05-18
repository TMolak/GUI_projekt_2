package pl.edu.pja.s26635.view.scores;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class HighScoreModel extends JPanel implements Serializable {

    private JTable table;
    private DefaultTableModel defaultTableModel;

    public HighScoreModel() {

        String[] columnNames = {"Player", "Score"};
        Object[][] scores = {};

        defaultTableModel = new DefaultTableModel(scores, columnNames);
        scoresFromFile("src/txtFiles/scores.txt");
        table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public void scoresFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] l = line.split(" ");
                if (l.length == 2) {
                    String playerName = l[0].trim();
                    int score = Integer.parseInt(l[1].trim());
                    defaultTableModel.addRow(new Object[]{playerName, score});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
