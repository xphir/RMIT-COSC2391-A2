package client;

import javax.swing.SwingUtilities;

import diceGame.view.DiceGameFrame;
import diceGame.view.GameEngineCallbackGUI;
import model.GameEngineCallbackImpl;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				/* main method where the gameEngine is passed through the dice game Frame */
				GameEngine gameEngine = new GameEngineImpl();
				DiceGameFrame diceFrame = new DiceGameFrame(gameEngine);

				GameEngineCallback gameEngineCallbackGUI = new GameEngineCallbackGUI(diceFrame, gameEngine);
				GameEngineCallback gameEngineCallback = new GameEngineCallbackImpl();

				/*
				 * new game Engine call back and game Engine call back is added to the
				 * gameEngineCallback arraylist
				 */
				gameEngine.addGameEngineCallback(gameEngineCallbackGUI);
				gameEngine.addGameEngineCallback(gameEngineCallback);
			}

		});
	}

}
