package diceGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import diceGame.view.DiceGameFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlaceBetController implements ActionListener {
	private DiceGameFrame diceGameFrame;
	private GameEngine model;
	private JTextField bettingPoints;

	public PlaceBetController(DiceGameFrame diceGameFrame, GameEngine model, JTextField bettingPoints) {
		this.diceGameFrame = diceGameFrame;
		this.model = model;
		this.bettingPoints = bettingPoints;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			/*
			 * validating that the betting points entered are not less than 0 or greater
			 * than the initial number of points entered by the user
			 */
			if (Integer.parseInt(bettingPoints.getText()) <= 0 || Integer.parseInt(bettingPoints.getText()) > Integer
					.parseInt(diceGameFrame.getOptionsPanel().getPoints().getText())) {
				JOptionPane.showMessageDialog(diceGameFrame,
						"Error: Betting points must be greater than 0 and less than Initial Points");
				/*
				 * Checking that the a player is selected before a bet is placed by the user
				 */

			} else if (diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(diceGameFrame, "Error: Please select a player before placing a bet");
			} else {
				/*
				 * iterates through all the players and if a player is selected, place a bet for
				 * them
				 */
				for (Player players : model.getAllPlayers()) {

					if (players.getPlayerName()
							.equals(diceGameFrame.getOptionsPanel().getSelectPlayer().getSelectedItem())) {
						model.placeBet(players, Integer.parseInt(bettingPoints.getText()));
						System.out.println(players.getBet());
						JOptionPane.showMessageDialog(diceGameFrame,
								"Bet has been placed for " + players.getPlayerName());
						diceGameFrame.getStatusBarPanel().getStatusLabel().setText("");
					}
				}
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(diceGameFrame, "Error: Invalid betting points entered");
		}
	}

}
