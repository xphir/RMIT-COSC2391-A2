package view;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/*
 *  As part of your new implementation you must write a GameEngineCallbackGUI class that is added to the 
 *  GameEngine via the existing addGameEngineCallback() method. This class will be responsible for managing 
 *  all of the graphical updates as the game is played. NOTE: this class should not actually implement 
 *  the UI functionality but instead for cohesion it should call methods on other classes, especially the view. 
 *  To state another way, it must be the entry point for any UI code resulting from game play, in order to 
 *  avoid coupling between the GameEngine and the UI which is counter to the original specification.
 * 
 */
public class GameEngineCallbackGUI implements GameEngineCallback {

	private CardGameFrame cardFrame;
	private GameEngine gameEngine;
	
	public GameEngineCallbackGUI(CardGameFrame diceFrame, GameEngine gameEngine) {
		this.cardFrame = cardFrame;
		this.gameEngine=gameEngine;
	}
	
	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		// TODO Auto-generated method stub

	}

}
