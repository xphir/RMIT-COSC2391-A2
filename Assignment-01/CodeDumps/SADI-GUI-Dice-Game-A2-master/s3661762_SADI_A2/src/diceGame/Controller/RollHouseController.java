package diceGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import diceGame.view.DiceGameFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RollHouseController implements ActionListener {
	private DiceGameFrame diceGameFrame;
	private GameEngine model;

	public RollHouseController(DiceGameFrame diceGameFrame, GameEngine model) {
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
				 * validating that the player is selected and bet is placed for that player
				 * before rolling for the house
				 */
				if (diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem() == null) {
					JOptionPane.showMessageDialog(diceGameFrame,
							"Error: Please select a player and place a bet before rolling for the house");
				}
				for (Player players : model.getAllPlayers()) {
					try {

						int dice1 = Integer.parseInt(diceGameFrame.getRollDicePlayerPanel().getDice1().getText());
						int dice2 = Integer.parseInt(diceGameFrame.getRollDicePlayerPanel().getDice2().getText());
						int bet = players.getBet();
						/*
						 * rolls for the house after checking that a player is selected, they have
						 * placed a bet and have rolled
						 */
						if (players.getPlayerName()
								.equals(diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem()) && bet != 0
								&& dice1 != 0 && dice2 != 0) {
							model.rollHouse(INITIAL_DELAY, FINAL_DELAY, DELAY_INCREMENT);

							for (Player player : model.getAllPlayers()) {
								player.placeBet(0);
							}

						}
					} catch (NumberFormatException nfe) {
						/* checks if a player is selected before rolling for the house */
						if (players.getPlayerName()
								.equals(diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem())) {
							JOptionPane.showMessageDialog(diceGameFrame,
									"Error: Please roll for the selected player before rolling for the house");
						}
					}
				}

			}

		}.start();

	}

}
