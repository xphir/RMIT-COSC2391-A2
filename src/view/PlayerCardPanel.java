package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DealPlayerController;
import model.interfaces.GameEngine;

public class PlayerCardPanel extends JPanel
{
	private JLabel currentCard;
	private JLabel currentCardLabel;
	
	public JLabel getCurrentCard() {
		return currentCard;
	}

	public PlayerCardPanel(GameEngine gameEngine, CardGameFrame frame)
	{
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.setLayout(new FlowLayout());
		
		currentCardLabel = new JLabel("Players Current Card: ");
		currentCard = new JLabel("None");
		
		add(currentCardLabel, BorderLayout.WEST);
		add(currentCard, BorderLayout.WEST);
	}

}
