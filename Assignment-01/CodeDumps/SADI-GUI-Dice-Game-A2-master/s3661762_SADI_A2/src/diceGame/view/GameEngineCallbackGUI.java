package diceGame.view;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback {
	
	private DiceGameFrame diceFrame;
	private GameEngine gameEngine;
		
	public GameEngineCallbackGUI(DiceGameFrame diceFrame, GameEngine gameEngine) {
		this.diceFrame = diceFrame;
		this.gameEngine=gameEngine;
		
	}
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		diceFrame.getDiceResultsForPlayers(dicePair);
	
	}
	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		diceFrame.getDiceResultsForPlayers(result);
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		diceFrame.getDiceResultsForHouse(dicePair);
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		// TODO Auto-generated method stub
		diceFrame.getDiceResultsForHouse(result);
		//after the house rolls, the updateStatusBar is called on the diceFrame to update the view*/
		diceFrame.updateStatusBar(gameEngine, result);
		
	}

}
