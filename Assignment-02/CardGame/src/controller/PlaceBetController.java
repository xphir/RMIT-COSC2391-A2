package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CardGameFrame;

//Place a bet (per player) and display an error message for invalid bets
public class PlaceBetController implements ActionListener
{
	private CardGameFrame cardGameFrame;
	private GameEngine model;
	private JTextField bettingPoints;

	public PlaceBetController(CardGameFrame cardGameFrame, GameEngine model, JTextField bettingPoints)
	{
		this.cardGameFrame = cardGameFrame;
		this.model = model;
		this.bettingPoints = bettingPoints;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			/*
			 * validating that the betting points entered are not less than 0 or
			 * greater than the initial number of points entered by the user
			 */
			if (Integer.parseInt(bettingPoints.getText()) <= 0 || Integer.parseInt(bettingPoints.getText()) > Integer.parseInt(cardGameFrame.getPlayerPanel().getPoints().getText()))
			{
				JOptionPane.showMessageDialog(cardGameFrame, "Error: Betting points must be greater than 0 and less than Initial Points");
				/*
				 * Checking that the a player is selected before a bet is placed by
				 * the user
				 */

			}
			else if (cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem() == null)
			{
				JOptionPane.showMessageDialog(cardGameFrame, "Error: Please select a player before placing a bet");
			}
			else
			{
				/*
				 * iterates through all the players and if a player is selected,
				 * place a bet for them
				 */
				for (Player players : model.getAllPlayers())
				{

					if (players.getPlayerName().equals(cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem()))
					{
						model.placeBet(players, Integer.parseInt(bettingPoints.getText()));
						System.out.println(players.getBet());
						JOptionPane.showMessageDialog(cardGameFrame, "Bet has been placed for " + players.getPlayerName());
						cardGameFrame.getStatusBarPanel().getStatusLabel().setText("");
					}
				}
			}
		}
		catch (NumberFormatException nfe)
		{
			JOptionPane.showMessageDialog(cardGameFrame, "Error: Invalid betting points entered");
		}
	}
}
