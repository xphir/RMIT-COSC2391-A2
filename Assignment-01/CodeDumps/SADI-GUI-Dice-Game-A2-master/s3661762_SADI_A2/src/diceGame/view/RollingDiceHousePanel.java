package diceGame.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import diceGame.Controller.RollHouseController;
import model.interfaces.GameEngine;

public class RollingDiceHousePanel extends JPanel {

	private JButton rollHouse;
	private JTextField dice1;
	private JTextField dice2;
	private JTextField dicePair;

	/*
	 * getters for JTextField for dice1, dice2, and total dice Pair for the House so
	 * they can be easily accessed
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

	public RollingDiceHousePanel(GameEngine gameEngine, DiceGameFrame frame) {
		/*
		 * JLabels and JTextFields for the dice 1, dice2, and total dice pair for the
		 * house are added to the panel
		 */
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		rollHouse = new JButton("Roll House");
		add(rollHouse);
		RollHouseController rollHouseController = new RollHouseController(frame, gameEngine);
		rollHouse.addActionListener(rollHouseController);
		JLabel HouseDice1 = new JLabel("House's Dice 1: ");
		dice1 = new JTextField("", 5);
		JLabel HouseDice2 = new JLabel("House's Dice 2: ");
		dice2 = new JTextField("", 5);
		JLabel totalDicePair = new JLabel("Total: ");
		dicePair = new JTextField("", 5);
		add(HouseDice1, BorderLayout.WEST);
		add(dice1, BorderLayout.WEST);
		add(HouseDice2, BorderLayout.WEST);
		add(dice2, BorderLayout.WEST);
		add(totalDicePair, BorderLayout.WEST);
		add(dicePair, BorderLayout.WEST);
	}

}
