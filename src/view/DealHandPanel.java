package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.DealAllController;
import controller.DealPlayerController;
import model.interfaces.GameEngine;

public class DealHandPanel extends JPanel
{
	private JButton dealPlayer;
	private JButton dealAll;
	private int playerDealCount;
	
	public JButton getDealPlayer()
	{
		return dealPlayer;
	}
	
	public int getPlayerDealCount()
	{
		return playerDealCount;
	}
	
	public void setPlayerDealCount(int input)
	{
		playerDealCount = input;
	}

	public DealHandPanel(GameEngine gameEngine, CardGameFrame frame)
	{
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		DealAllController dealAllController = new DealAllController(frame, gameEngine);
		DealPlayerController dealPlayerController = new DealPlayerController(frame, gameEngine);
		dealPlayer = new JButton("Deal Player");
		add(dealPlayer);
		dealPlayer.addActionListener(dealPlayerController);
		
		dealAll = new JButton("Deal All");
		add(dealAll);
		dealAll.addActionListener(dealAllController);
		
	}
}
