package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackImpl implements GameEngineCallback {

	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl() {
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.INFO);
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		// intermediate results logged at Level.FINE
		logger.log(Level.INFO, player.getPlayerName() + ": ROLLING " + dicePair.toString());
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		// final results logged at Level.INFO
		logger.log(Level.INFO, player.getPlayerName() + ": " + "*RESULT* " + result.toString());

	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		logger.log(Level.INFO, "House: " + "ROLLING" + dicePair.toString());
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		logger.log(Level.INFO, "House: " + "*RESULT*" + result.toString());
		logPlayerResults(result, gameEngine);
	}

	/* private method that logs the player id, name and their points */
	private void logPlayerResults(DicePair dicePair, GameEngine gameEngine) {
		for (Player aplayer : gameEngine.getAllPlayers()) {
			logger.log(Level.INFO, aplayer.toString());
		}
	}
}