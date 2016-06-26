package edu.westga.cs6910.mancala.model.strategies;

import java.util.Random;

/**
 * This class will create a Random Strategy for our computer player.
 * 
 * The idea is that the computer will look for a random pit on it's side,
 * see if the pit is empty, if not play the pit, if so, look again.
 * 
 * @author Jacob Radcliffe
 * @version 6/25/16
 */
public class RandomStrategy implements SelectStrategy {
	private Random generator;
	
	/**
	 * Creates a RandomStrategy object with 
	 * a Random generator
	 */
	public RandomStrategy() {
		this.generator = new Random();
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.strategies.SelectStrategy#selectPit(int[])
	 */
	@Override
	public int selectPit(int[] theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Can't select pit. No game board exists");
		}
		
		int pitNumber = this.generator.nextInt(3) + 4;
		while (theGame[pitNumber] <= 0) {
			pitNumber = this.generator.nextInt(3) + 4;
		}
		
		return pitNumber;	
	}

}
