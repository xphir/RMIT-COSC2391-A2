package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import model.interfaces.PlayingCard;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class CardGameFrame extends JFrame {

	private AddPlayerPanel playerPanel;
	private GameEngine gameEngine;
	private HouseDealPanel houseDealPanel;
	private MenuBarPanel menuBarPanel;
	private PlaceBetPanel placeBetPanel;
	private PlayerDealPanel playerDealPanel;
	private StatusBarPanel statusBarPanel;
	
	public AddPlayerPanel getPlayerPanel() {
		return playerPanel;
	}
	public GameEngine getGameEngine() {
		return gameEngine;
	}
	public HouseDealPanel getHouseDealPanel() {
		return houseDealPanel;
	}
	public MenuBarPanel getMenuBarPanel() {
		return menuBarPanel;
	}
	public PlaceBetPanel getPlaceBetPanel() {
		return placeBetPanel;
	}
	public PlayerDealPanel getPlayerDealPanel() {
		return playerDealPanel;
	}
	public StatusBarPanel getStatusBarPanel() {
		return statusBarPanel;
	}
	
	public CardGameFrame(GameEngine gameEngine) {
		super("SADI Card Game");
		this.gameEngine = gameEngine;
		
		playerPanel = new AddPlayerPanel(gameEngine, this);
		menuBarPanel = new MenuBarPanel(gameEngine, this);

		this.setLayout(new GridLayout(5, 1));
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setJMenuBar(menuBarPanel);
		add(playerPanel, BorderLayout.NORTH);

		houseDealPanel = new HouseDealPanel(gameEngine, this);
		playerDealPanel = new PlayerDealPanel(gameEngine, this);
		placeBetPanel = new PlaceBetPanel(gameEngine, this);
		statusBarPanel = new StatusBarPanel(gameEngine, this);

		add(placeBetPanel);
		add(playerDealPanel);
		add(houseDealPanel);
		add(statusBarPanel);

		playerDealPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		setVisible(true);
		/* pack my frame to get rid of unnecessary space */
		pack();
	}
}
