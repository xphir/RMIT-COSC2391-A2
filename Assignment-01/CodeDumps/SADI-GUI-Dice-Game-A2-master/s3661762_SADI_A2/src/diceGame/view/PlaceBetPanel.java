package diceGame.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diceGame.Controller.PlaceBetController;
import model.interfaces.GameEngine;

public class PlaceBetPanel extends JPanel {
	private JButton placeBet;
	private JTextField points;

	/*getters for the JtextField and the placeBet JButton in the placeBetPanel so they can easily be accessed */
	public JTextField getPoints() {
		return points;
	}

	public JButton getPlaceBet() {
		return placeBet;
	}

	public PlaceBetPanel(GameEngine gameEngine, DiceGameFrame frame) {

		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		JLabel enterbettingPoints = new JLabel("Enter Betting Points: ");
		points = new JTextField("50", 5);
		add(enterbettingPoints);
		add(points);
		placeBet = new JButton("Place Bet");
		add(placeBet);
		PlaceBetController placingBet = new PlaceBetController(frame, gameEngine, points);
		placeBet.addActionListener(placingBet);
	}

}
