package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.interfaces.GameEngine;

//A summary panel which is always visible which shows player names and their current points balance
public class SummaryPanel extends JPanel
{
	private DefaultTableModel infoModel;
	private JTable summaryTable;

	public JTable getSummaryTable()
	{
		return summaryTable;
	}

	public DefaultTableModel getTableModel()
	{
		return infoModel;
	}

	public void addTableRow(String id, String name, int points)
	{
		infoModel.addRow(new Object[] { id, name, points });
	}

	public SummaryPanel(GameEngine gameEngine, CardGameFrame frame)
	{
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		infoModel = new DefaultTableModel();
		infoModel.addColumn("ID");
		infoModel.addColumn("Name");
		infoModel.addColumn("Points");
		summaryTable = new JTable(infoModel);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(summaryTable);
		scrollPane.setPreferredSize(new Dimension(250, 80));

		// Add the scroll pane to this panel.
		add(scrollPane);
	}

}