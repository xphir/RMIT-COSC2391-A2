package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.CardGameFrame;

public class DealAllController implements ActionListener
{
	private CardGameFrame cardGameFrame;
	private GameEngine model;
	
	

	public DealAllController(CardGameFrame cardGameFrame, GameEngine model)
	{
		this.cardGameFrame = cardGameFrame;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String statusMessage;
		final int DELAY = 1000;

		new Thread()
		{

			@Override
			public void run()
			{
				// Run through all the players
				for (Player player : model.getAllPlayers())
				{
					int bet = player.getBet();
					if (bet == 0)
					{
						String statusMessage = String.format("Placing automated bet of 25 points for %s", player.getPlayerName());
						cardGameFrame.getStatusBarPanel().getStatusLabel().setText(statusMessage);
						model.placeBet(player, 25);
					}
					model.dealPlayer(player, DELAY);
				}
				if(model.getAllPlayers().size() == cardGameFrame.getDealHandPanel().getPlayerDealCount())
				{
					model.dealHouse(DELAY);
				}
			}
		}.start();
	}
}