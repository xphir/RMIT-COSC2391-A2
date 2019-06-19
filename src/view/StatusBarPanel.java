package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

public class StatusBarPanel extends JPanel {

	private JLabel statusLabel;

	public JLabel getStatusLabel() {
		return statusLabel;
	}


	/*
	 * status bar for updating the betting points of the players after the House
	 * rolls
	 */
	public StatusBarPanel(GameEngine gameEngine, CardGameFrame frame) {
		setBorder(BorderFactory.createLineBorder(Color.black, 1));

		statusLabel = new JLabel("STATUS BAR", JLabel.LEFT);

		add(statusLabel);

	}
}
