package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;
import view.CardGameFrame;

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
		
	public GameEngineCallbackGUI(CardGameFrame cardFrame, GameEngine gameEngine) {
		this.cardFrame = cardFrame;
		this.gameEngine = gameEngine;	
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine)
	{
		cardFrame.setCardResult(card);
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine)
	{
		//+1 for each hand played
		cardFrame.getDealHandPanel().setPlayerDealCount(cardFrame.getDealHandPanel().getPlayerDealCount()+1);
	}

	@Override
	public void result(Player player, int result, GameEngine engine)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void houseResult(int result, GameEngine engine)
	{
		//Set the delt hands to 0
		cardFrame.getDealHandPanel().setPlayerDealCount(0);
		//Update the summary table fields
		cardFrame.updateSummaryTable();
	}


}
