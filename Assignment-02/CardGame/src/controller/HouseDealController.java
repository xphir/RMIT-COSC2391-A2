package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CardGameFrame;

//House deals (automatically after all players have bet/dealt) .. each card is shown in real-time as it is dealt

public class HouseDealController implements ActionListener
{
	private CardGameFrame cardGameFrame;
	private GameEngine model;

	public HouseDealController(CardGameFrame cardGameFrame, GameEngine model)
	{
		this.cardGameFrame = cardGameFrame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		final int DELAY = 1;

		new Thread()
		{

			@Override
			public void run()
			{
				/*
				 * validating that the player is selected and bet is placed for that
				 * player before rolling for the house
				 */
				if (cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem() == null)
				{
					JOptionPane.showMessageDialog(cardGameFrame, "Error: Please select a player and place a bet before rolling for the house");
				}
				for (Player players : model.getAllPlayers())
				{
					try
					{
						//THINGS
						int dice1 = Integer.parseInt(cardGameFrame.getPlayerDealPanel().getCard1().getText());
						int dice2 = Integer.parseInt(cardGameFrame.getPlayerDealPanel().getCard2().getText());
						int bet = players.getBet();
						
						//rolls for the house after checking that a player is selected, they have placed a bet and have rolled
						
						if (players.getPlayerName().equals(cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem()) && bet != 0 && dice1 != 0 && dice2 != 0)
						{
							model.dealHouse(DELAY);

							for (Player player : model.getAllPlayers())
							{
								player.placeBet(0);
							}

						}
					}
					catch (NumberFormatException nfe)
					{
						/*
						 * checks if a player is selected before rolling for the house
						 */
						if (players.getPlayerName().equals(cardGameFrame.getPlayerPanel().getSelectPlayer().getSelectedItem()))
						{
							JOptionPane.showMessageDialog(cardGameFrame, "Error: Please roll for the selected player before rolling for the house");
						}
					}
				}

			}

		}.start();

	}
}
