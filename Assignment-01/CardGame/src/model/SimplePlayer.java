package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {

	// As per
	private String playerId;
	private String playerName;
	private int initialPoints;

	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPlayerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(int bet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getResult() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setResult(int result) {
		// TODO Auto-generated method stub

	}

}
