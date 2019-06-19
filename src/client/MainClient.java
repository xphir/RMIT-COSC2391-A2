package client;

import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.CardGameFrame;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

public class MainClient {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				/* main method where the gameEngine is passed through the dice game Frame */
				GameEngine gameEngine = new GameEngineImpl();
				CardGameFrame cardFrame = new CardGameFrame(gameEngine);

				gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
				gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(cardFrame, gameEngine));

				/*
				 * new game Engine call back and game Engine call back is added to the
				 * gameEngineCallback arraylist
				 */
			}

		});
	}
}
