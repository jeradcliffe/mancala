package edu.westga.cs6910.mancala.model.strategies;

/**
 * The purpose of this strategy is to have the computer
 * player always pick the farthest pit from its store
 * 
 * @author Jacob Radcliffe
 * @version 6/25/16
 *
 */
public class FarStrategy implements SelectStrategy {

	/**
	 * Default contructor
	 */
	public FarStrategy() {
		
	}
	
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.strategies.SelectStrategy#selectPit(int[])
	 */
	@Override
	public int selectPit(int[] theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Can't select pit. No game board exists");
		}
		
		int pitNumber = theGame.length / 2;
		while (theGame[pitNumber] <= 0  && pitNumber <= theGame.length - 2) {
			pitNumber++;
		}
		
		return pitNumber;
	}

}
