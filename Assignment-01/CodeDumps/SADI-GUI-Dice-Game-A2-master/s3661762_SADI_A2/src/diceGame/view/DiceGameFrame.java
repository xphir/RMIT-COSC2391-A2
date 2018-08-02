package diceGame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class DiceGameFrame extends JFrame {

	private MenuBarPanel menuBar;
	private AddPlayerToolBarPanel optionsPanel;
	private PlaceBetPanel bettingPanel;
	private RollingDicePlayerPanel rollDicePanel;
	private RollingDiceHousePanel rollingDiceHousePanel;
	private StatusBarPanel statusBarPanel;
	private GameEngine gameEngine;

	/* getter methods for my tool Bar, panels and status Bar */
	public AddPlayerToolBarPanel getOptionsPanel() {
		return optionsPanel;
	}

	public PlaceBetPanel getBettingPanel() {
		return bettingPanel;
	}

	public RollingDicePlayerPanel getRollDicePlayerPanel() {
		return rollDicePanel;
	}

	public RollingDiceHousePanel getRollingDiceHousePanel() {
		return rollingDiceHousePanel;
	}

	public StatusBarPanel getStatusBarPanel() {
		return statusBarPanel;
	}

	/* diceGameFrame constructor which adds my components to the frame */
	public DiceGameFrame(GameEngine gameEngine) {
		super("SADI Dice Game");
		this.gameEngine = gameEngine;

		optionsPanel = new AddPlayerToolBarPanel(gameEngine, this);
		menuBar = new MenuBarPanel(gameEngine, this);

		this.setLayout(new GridLayout(5, 1));
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setJMenuBar(menuBar);
		add(optionsPanel, BorderLayout.NORTH);

		rollDicePanel = new RollingDicePlayerPanel(gameEngine, this);
		rollingDiceHousePanel = new RollingDiceHousePanel(gameEngine, this);
		bettingPanel = new PlaceBetPanel(gameEngine, this);
		statusBarPanel = new StatusBarPanel(gameEngine, this);

		add(bettingPanel);
		add(rollDicePanel);
		add(rollingDiceHousePanel);
		add(statusBarPanel);

		rollDicePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		setVisible(true);
		/* pack my frame to get rid of unnecessary space */
		pack();

	}

	/*
	 * my method to set the text of the JTextfield for dice1, dice2, and total for
	 * the player when they roll and is called in the GameEngineCallbackGUI in the
	 * intermediateResult and result methods for players and takes a DicePair object
	 * as its parameter
	 */
	public void getDiceResultsForPlayers(DicePair dicePair) {
		for (Player players : gameEngine.getAllPlayers()) {
			if (players.getPlayerName().equals(getOptionsPanel().getSelectPlayer().getSelectedItem())) {
				int sumOfDicePair = dicePair.getDice1() + dicePair.getDice2();
				getRollDicePlayerPanel().getDice1().setText(Integer.toString(dicePair.getDice1()));
				getRollDicePlayerPanel().getDice2().setText(Integer.toString(dicePair.getDice2()));
				getRollDicePlayerPanel().getDicePair().setText(Integer.toString(sumOfDicePair));
			}
		}
	}

	/*
	 * my method to set the text of the JTextfield for dice1, dice2, and total for
	 * the House when it rolls and is called in the GameEngineCallbackGUI in the
	 * intermediateResult and result methods for the House and takes a DicePair
	 * object as its parameter
	 */
	public void getDiceResultsForHouse(DicePair dicePair) {
		int sumOfDicePair = dicePair.getDice1() + dicePair.getDice2();
		getRollingDiceHousePanel().getDice1().setText(Integer.toString(dicePair.getDice1()));
		getRollingDiceHousePanel().getDice2().setText(Integer.toString(dicePair.getDice2()));
		getRollingDiceHousePanel().getDicePair().setText(Integer.toString(sumOfDicePair));
	}

	/*
	 * my method that updates the betting points of the players who have rolled for
	 * the round
	 */
	public void updateStatusBar(GameEngine gameEngine, DicePair dicePair) {
		for (Player players : gameEngine.getAllPlayers()) {
			if (players.getBet() != 0 && players.getRollResult() != null) {
				getStatusBarPanel().getStatusLabel()
						.setText((players.getPlayerName() + " updated Points:" + players.getPoints()) + " "
								+ getStatusBarPanel().getStatusLabel().getText());

			}

		}

	}

}
