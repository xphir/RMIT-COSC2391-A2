package model;

import java.util.Collection;
import java.util.Deque;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

/**
 * 
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& SPECIFICATION FROM PDF &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * 
 * This is where the main game functionality is contained. All methods from the client are called through 
 * this class (see footnote). Methods in the supporting classes should only be called from GameEngineImpl.
 * 
 * The main feature of this class that is likely different to previous code you have written is 
 * that the GameEngineImpl does not provide any output of its own (i.e. it SHOULD HAVE NO println() 
 * or log() statements other than for debugging and these should be commented or removed prior to submission). 
 * Instead it calls appropriate methods on the GameEngineCallback as it runs (see below) which is where 
 * all output is logged to the console for assignment part 1. 
 * 
 * This provides a good level of isolation and will allow you to use your GameEngineImpl unchanged 
 * in assignment 2 when we add a graphical AWT/Swing use interface!
 * 
 * NOTE: Your GameEngineImpl must maintain a collection (or array) of Players AND a 
 * collection (or array) of GameEngineCallbacks. When a callback method should be called 
 * this must be done in a loop iterating through all callbacks. Note that each callback receives 
 * the same data so there is no need to distinguish them (i.e. they are all the same and not 
 * player specific). SimpleTestClient.java gives an example for two players and shows it is trivial 
 * to add more (simply increase the array size by adding to the initialiser).  
 * 
 * &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
 * 
 */

public class GameEngineImpl implements GameEngine {

	@Override
	public void dealPlayer(Player player, int delay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealHouse(int delay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Deque<PlayingCard> getShuffledDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	
}