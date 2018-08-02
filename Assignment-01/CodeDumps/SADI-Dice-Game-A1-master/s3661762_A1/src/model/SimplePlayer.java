package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	private String playerID;
	private String playerName;
	private int initialPoints;
	private int bet;
	private DicePair rollResult;
	
	/*constructor for the player that takes in a player ID, player name and initial points*/
		public SimplePlayer(String playerID, String playerName, int initialPoints) 
		{
			this.playerID=playerID;
			this.playerName=playerName;
			this.initialPoints=initialPoints;
		}
		/*getters and setters*/
		@Override
		public String getPlayerName() 
		{
			return playerName;
		}
		
		@Override
		public void setPlayerName(String playerName) 
		{
			this.playerName=playerName;
		}
		
		@Override
		public int getPoints() 
		{
			return initialPoints;
		}
		
		@Override
		public void setPoints(int points) 
		{
			this.initialPoints=points;
		}
		
		@Override
		public String getPlayerId() 
		{
			return playerID;
		}
		
		@Override
		public boolean placeBet(int bet) 
		{
			/*checking if the bet placed is less than or equal to the initial points of player*/
			if (bet<=initialPoints) 
			{
				this.bet=bet;
				return true;
			}
			else 
			{
				return false;
			}
		}
		
		@Override
		public int getBet()
		{
			return bet;
		}
		
		@Override
		public DicePair getRollResult() 
		{
			return rollResult; 
		}
		
		@Override
		public void setRollResult(DicePair rollResult) {
			this.rollResult = rollResult;
		}
		
		@Override
		/*toString method that prints the details of the player*/
		public String toString() 
		{
			String stringFormat2 = String.format("Player: Id=%s, name=%s, points=%d", getPlayerId(),getPlayerName(),getPoints());
			return stringFormat2;
		}

	}
