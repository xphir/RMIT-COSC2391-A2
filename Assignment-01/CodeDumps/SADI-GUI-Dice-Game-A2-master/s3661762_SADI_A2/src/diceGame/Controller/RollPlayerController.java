package diceGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import diceGame.view.DiceGameFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RollPlayerController implements ActionListener {

	private DiceGameFrame diceGameFrame;
	private GameEngine model;

	public RollPlayerController(DiceGameFrame diceGameFrame, GameEngine model) {
		this.diceGameFrame = diceGameFrame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		final int INITIAL_DELAY = 1;
		final int FINAL_DELAY = 1000;
		final int DELAY_INCREMENT = 250;
		new Thread() {

			@Override
			public void run() {
				/*
				 * validating that a player is selected and a bet is placed for them before
				 * rolling for the player.
				 */
				if (diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem() == null) {
					JOptionPane.showMessageDialog(diceGameFrame,
							"Error: Please select a player and place a bet before rolling for Player.");
				}
				for (Player players : model.getAllPlayers()) {
					int bet = players.getBet();
					/* checking if the selected player has placed a bet */
					if (players.getPlayerName()
							.equals(diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem()) && bet == 0) {
						JOptionPane.showMessageDialog(diceGameFrame,
								"Error: Please place a bet for the player that has been selected.");
					}
					/*NOTE - ASSUMPTION MADE: If a player that is selected has rolled once, they are unable to roll again*/
					else if (players.getPlayerName()
							.equals(diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem())
							&& players.getRollResult() != null) {
						JOptionPane.showMessageDialog(diceGameFrame, "Player has already rolled");
					} else if (players.getPlayerName()
							.equals(diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem()) && bet != 0) {
						model.rollPlayer(players, INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);

					}

				}
			}
		}.start();
	}
}
