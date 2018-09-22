package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CardGameFrame;

public class PlayerDealController implements ActionListener {
	private CardGameFrame cardGameFrame;
	private GameEngine model;

	public PlayerDealController(CardGameFrame cardGameFrame, GameEngine model) {
		this.cardGameFrame = cardGameFrame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		final int DELAY = 1;

		new Thread() {

			@Override
			public void run() {
				// Validating that a player is selected and a bet is placed for them before
				// rolling for the player.
				if (cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem() == null) {
					JOptionPane.showMessageDialog(cardGameFrame,
							"Error: Please select a player and place a bet before dealing a hand for the Player.");
				}
				// Run through all the players
				for (Player player : model.getAllPlayers()) {
					int bet = player.getBet();
					// Check if the selected player has placed a bet
					if (player.getPlayerName().equals(cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem()) && bet == 0) {
						//if not be it placed, give an error
						JOptionPane.showMessageDialog(cardGameFrame, "Error: Please place a bet for the player that has been selected.");
					}
					else if (player.getPlayerName().equals(cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem()) && player.getResult() != 0) {
						//Check if player has played a hand
						JOptionPane.showMessageDialog(cardGameFrame, "Player has already played a hand");
					} else if (player.getPlayerName().equals(cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem()) && bet != 0) {
						model.dealPlayer(player, DELAY);
					}

				}
			}
		}.start();
	}
}
