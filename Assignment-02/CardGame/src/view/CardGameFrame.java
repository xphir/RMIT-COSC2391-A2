package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.interfaces.PlayingCard;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class CardGameFrame extends JFrame
{

	private GameEngine gameEngine;
	private AddPlayerPanel playerPanel;
	private MenuBarPanel menuBarPanel;
	private PlaceBetPanel placeBetPanel;
	private PlayerCardPanel playerCardPanel;
	private StatusBarPanel statusBarPanel;
	private SummaryPanel summaryPanel;
	private DealHandPanel dealHandPanel;

	public AddPlayerPanel getPlayerPanel()
	{
		return playerPanel;
	}

	public GameEngine getGameEngine()
	{
		return gameEngine;
	}

	public MenuBarPanel getMenuBarPanel()
	{
		return menuBarPanel;
	}

	public PlaceBetPanel getPlaceBetPanel()
	{
		return placeBetPanel;
	}

	public PlayerCardPanel getPlayerCardPanel()
	{
		return playerCardPanel;
	}

	public StatusBarPanel getStatusBarPanel()
	{
		return statusBarPanel;
	}

	public SummaryPanel getSummaryPanel()
	{
		return summaryPanel;
	}

	public DealHandPanel getDealHandPanel()
	{
		return dealHandPanel;
	}

	public CardGameFrame(GameEngine gameEngine)
	{
		super("SADI Card Game");
		this.gameEngine = gameEngine;

		menuBarPanel = new MenuBarPanel(gameEngine, this);

		setJMenuBar(menuBarPanel);

		this.setLayout(new GridLayout(6, 1));
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		playerPanel = new AddPlayerPanel(gameEngine, this);

		add(playerPanel, BorderLayout.NORTH);

		dealHandPanel = new DealHandPanel(gameEngine, this);
		playerCardPanel = new PlayerCardPanel(gameEngine, this);
		placeBetPanel = new PlaceBetPanel(gameEngine, this);
		summaryPanel = new SummaryPanel(gameEngine, this);
		statusBarPanel = new StatusBarPanel(gameEngine, this);

		add(playerPanel);
		add(placeBetPanel);
		add(dealHandPanel);
		add(playerCardPanel);
		add(summaryPanel);
		add(statusBarPanel);

		statusBarPanel.getStatusLabel().setText("Application has started");
		playerCardPanel.getCurrentCard().setText("No Cards Delt");

		setVisible(true);
		/* pack my frame to get rid of unnecessary space */
		pack();
	}

	public void setCardResult(PlayingCard card)
	{
		for (Player player : gameEngine.getAllPlayers())
		{
			if (player.getPlayerName().equals(getPlayerPanel().getSelectPlayer().getSelectedItem()))
			{
				getPlayerCardPanel().getCurrentCard().setText(card.toString());
			}
		}
		setSummary();
	}

	public void setStatusBar(String input)
	{
		getStatusBarPanel().getStatusLabel().setText(input);
	}

	public void setSummary()
	{

	}

	public void updateSummaryTable()
	{
		for (Player player : gameEngine.getAllPlayers())
		{
			for (int row = 0; row < getSummaryPanel().getTableModel().getRowCount(); row++)
			{
				if (player.getPlayerId() == getSummaryPanel().getTableModel().getValueAt(row, 0))
				{
					getSummaryPanel().getTableModel().setValueAt(player.getPoints(), row, 2);
				}
				else {
					//NO MATCH
				}

			}
		}

	}
	
}
