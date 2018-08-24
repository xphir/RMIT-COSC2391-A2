package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& SPECIFICATION FROM PDF &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * 
 * The sole purpose of this class is to support the user interface (view) which in assignment part 1
 * consists of simple console/logging output. Therefore all this class needs to do is log data to the
 * console from the parameters passed to its methods. Apart from implementing the logging (we
 * recommend String.format() here) the main thing is to make sure you call the right method at the 
 * right time! (see below). You should also as much as possible make use the of the overidden
 * toString() methods you will implement in SimplePlayer and PlayingCardImpl since this will
 * simplify the logging!
 * 
 * The only class that will call the GameEngineCallbackImpl methods is the GameEngineImpl 
 * class. For example as the dealPlayer(…) method is executing in a loop it will call the
 * nextCard(…) method on the GameEngineCallbackImpl (via the GameEngineCallback
 * interface). Details of the exact flow and where GameEngineCallback methods should be called are
 * provided in the GameEngineImpl source code and associated Javadoc. 
 * 
 * IMPORTANT: The main thing to watch out for (i.e. “gotcha”) is that this class should not manage any
 * game state or implement any game based functionality which instead belongs in the
 * GameEngineImpl. The core test here is that we should be able to replace your 
 * GameEngineCallbackImpl with our own (which obviously knows nothing about your
 * implementation) and your GameEngineImpl code should still work. This is a true test of 
 * encapsulation and programming using interfaces (i.e. to a specification) and is one of the main
 * objectives of this assignment! 
 * 
 * IF YOU DO NOT FOLLOW THE NOTE ABOVE YOUR CODE WILL NOT EXECUTE PROPERLY
 * WITH OUR TEST HARNESS AND YOU WILL LOSE MARKS! PLEASE DON’T GET CAUGHT OUT ..
 * IF IN DOUBT ASK, WE ARE HAPPY TO HELP :)
 * 
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private final Logger logger = Logger.getLogger(this.getClass().getName());

   public GameEngineCallbackImpl()
   {
      // FINE shows dealing output, INFO only shows result
      logger.setLevel(Level.FINE);
   }

   @Override
   public void nextCard(Player player, PlayingCard card, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	  //TODO SHOULD BE FINE BUT IT DOESNT WORK
      logger.log(Level.INFO, String.format("Card Dealt to %s .. Suit: %s, Value: %s, Score: %d",player.getPlayerName(),card.getSuit(),card.getValue(),card.getScore()));
   }

   @Override
   public void result(Player player, int result, GameEngine engine)
   {
      // final results logged at Level.INFO
      logger.log(Level.INFO, String.format("%s, final result=%d", player, result));
   }

   @Override
   public void bustCard(Player player, PlayingCard card, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	 //TODO SHOULD BE FINE BUT IT DOESNT WORK
      logger.log(Level.INFO, String.format("Card Dealt to %s .. Suit: %s, Value: %s, Score: %d ... YOU BUSTED!",player.getPlayerName(),card.getSuit(),card.getValue(),card.getScore()));
   }
   
   @Override
   public void houseBustCard(PlayingCard card, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	 //TODO SHOULD BE FINE BUT IT DOESNT WORK
      logger.log(Level.INFO, String.format("Card Dealt to House .. Suit: %s, Value: %s, Score: %d ... YOU BUSTED!",card.getSuit(),card.getValue(),card.getScore()));
   }
   
   @Override
   public void houseResult(int result, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	 //TODO SHOULD BE FINE BUT IT DOESNT WORK
      logger.log(Level.INFO, String.format("House, final result=%d",result));
   }
   
   @Override
   public void nextHouseCard(PlayingCard card, GameEngine engine)
   {
      // intermediate results logged at Level.FINE
	 //TODO SHOULD BE FINE BUT IT DOESNT WORK
      logger.log(Level.INFO, String.format("Card Dealt to House .. Suit: %s, Value: %s, Score: %d",card.getSuit(),card.getValue(),card.getScore()));
   }
   
}
