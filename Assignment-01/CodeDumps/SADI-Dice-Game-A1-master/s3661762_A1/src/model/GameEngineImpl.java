package model;

import java.util.*;
import java.util.Collection;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine {
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();

	@Override
	public boolean placeBet(Player player, int bet) {
		if (player.placeBet(bet) == true) {
			return true;
		}
		return false;
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		/* creating a dicePair object */
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		DicePairImpl resultDice = new DicePairImpl(dice1, dice2, NUM_FACES);
		do {
			DicePairImpl dice = roll();
			try {
				Thread.sleep(initialDelay);
			} catch (InterruptedException e) {

			}
			initialDelay += delayIncrement;
			for (GameEngineCallback g : gameEngineCallbacks) {
				g.intermediateResult(player, dice, this);
			}
		} while (initialDelay < finalDelay);
		for (GameEngineCallback g : gameEngineCallbacks) {
			g.result(player, resultDice, this);
			player.setRollResult(resultDice);
		}
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		int sumOfDicePair = 0;
		do {
			DicePairImpl dice = roll();
			sumOfDicePair = dice1 + dice2;
			try {
				Thread.sleep(initialDelay);
			} catch (InterruptedException e) {

			}
			initialDelay += delayIncrement;
			for (GameEngineCallback g : gameEngineCallbacks) {
				g.intermediateHouseResult(dice, this);
			}
		} while (initialDelay < finalDelay);
		/*
		 * calling my check Winner private method which will pass the sum of the dice
		 * pair and calculator the winner and loser
		 */
		checkWinner(sumOfDicePair);
		DicePairImpl resultDice = new DicePairImpl(dice1, dice2, NUM_FACES);
		for (GameEngineCallback g : gameEngineCallbacks) {
			g.houseResult(resultDice, this);
		}
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player aplayer : players) {
			if (aplayer.getPlayerId().equals(id))
				return aplayer;
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		for (Player aplayer : players) {
			if (player == aplayer) {
				players.remove(aplayer);
				return true;
			}
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		for (GameEngineCallback aGameEngineCallback : gameEngineCallbacks) {
			if (gameEngineCallback == aGameEngineCallback) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		List<Player> immutablePlayerLists = Collections.unmodifiableList(players);
		return immutablePlayerLists;
	}

	/*
	 * a private method that checks/compares the rest of the player to the house and
	 * sets the points according to the comparison
	 */
	private void checkWinner(int total) {
		for (Player aPlayer : players) {
			int sumOfDicePairOfPlayer = 0;
			sumOfDicePairOfPlayer = aPlayer.getRollResult().getDice1() + aPlayer.getRollResult().getDice2();
			if (sumOfDicePairOfPlayer > total) {
				int points = aPlayer.getPoints() + aPlayer.getBet();
				aPlayer.setPoints(points);
			} else if (sumOfDicePairOfPlayer < total) {
				int points = aPlayer.getPoints() - aPlayer.getBet();
				aPlayer.setPoints(points);
			} else if (sumOfDicePairOfPlayer == total) {
				int points = aPlayer.getPoints();
				aPlayer.setPoints(points);
			}
		}
	}

	/*
	 * method that reduces creates a new dicePair object and is used to refactor the
	 * code
	 */
	private DicePairImpl roll() {
		int dice1 = (int) (Math.random() * 6) + 1;
		int dice2 = (int) (Math.random() * 6) + 1;
		DicePairImpl dice = new DicePairImpl(dice1, dice2, NUM_FACES);
		return dice;
	}

}
