package diceGame.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diceGame.Controller.RollPlayerController;
import model.interfaces.GameEngine;

public class RollingDicePlayerPanel extends JPanel {

	private JButton rollPlayer;
	private JTextField dice1;
	private JTextField dice2;
	private JTextField dicePair;

	/*
	 * getters for JTextField for dice1, dice2, and total dice Pair for the player
	 * so they can be easily accessed
	 */
	public JTextField getDice1() {
		return dice1;
	}

	public JTextField getDice2() {
		return dice2;
	}

	public JTextField getDicePair() {
		return dicePair;
	}

	public JButton getRollPlayer() {
		return rollPlayer;
	}

	public RollingDicePlayerPanel(GameEngine gameEngine, DiceGameFrame frame) {
		/*
		 * JLabels and JTextFields for the dice 1, dice2, and total dice pair for the
		 * player are added to the panel
		 */
		setBorder(BorderFactory.createLineBorder(Color.black, 3));

		rollPlayer = new JButton("Roll Player");
		add(rollPlayer);
		RollPlayerController rollPlayerController = new RollPlayerController(frame, gameEngine);
		rollPlayer.addActionListener(rollPlayerController);
		JLabel playerDice1 = new JLabel("Player's Dice 1: ");
		dice1 = new JTextField("", 5);
		JLabel playerDice2 = new JLabel("Player's Dice 2: ");
		dice2 = new JTextField("", 5);
		JLabel totalDicePair = new JLabel("Total: ");
		dicePair = new JTextField("", 5);

		add(playerDice1, BorderLayout.WEST);
		add(dice1, BorderLayout.WEST);
		add(playerDice2, BorderLayout.WEST);
		add(dice2, BorderLayout.WEST);
		add(totalDicePair, BorderLayout.WEST);
		add(dicePair, BorderLayout.WEST);

	}

}
