package edu.westga.cs6910.mancala.model.strategies;

/**
 * The purpose of this class is to implement the game-play
 * strategy that has our computer player always select the 
 * first pit on the computer's board that has stones in it.
 * 
 * @author Jacob Radcliffe
 * @version 6/24/16
 */
public class CloseStrategy implements SelectStrategy {

	/**
	 * Default constructor (not used in program)
	 */
	public CloseStrategy() {
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.strategies.SelectStrategy#selectPit()
	 */
	@Override
	public int selectPit(int[] theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Can't select pit. No game board exists");
		}
		
		int pitNumber = theGame.length - 2;
		while (theGame[pitNumber] == 0) {
			pitNumber--;
		}
		
		return pitNumber;
	}

}
