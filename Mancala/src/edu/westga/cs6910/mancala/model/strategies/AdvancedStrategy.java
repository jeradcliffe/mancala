package edu.westga.cs6910.mancala.model.strategies;

/**
 * The will produce a class with an advanced strategy 
 * for our computer player. 
 * 
 * @author Jacob Radcliffe
 * @version 7/13/16
 */
public class AdvancedStrategy implements SelectStrategy {

	/**
	 *Constructor of our advanced strategy 
	 */
	public AdvancedStrategy() {
	}

	/**
	 * Override of the selectPit method in Strategies Interface.
	 * 
	 * 1-Check to see if we can play a pit that will allow us to go again
	 * 2-Check to see if we can play a pit that will allow us to take
	 *   our opponent's seeds
	 * 3-Neither works? Uses CloseStrategy to select pit closest to store
	 * 
	 * @see edu.westga.cs6910.mancala.model.strategies.SelectStrategy#selectPit(int[])
	 */
	@Override
	public int selectPit(int[] theBoard) {
		int closestPit = theBoard.length - 2;
		
		
		for (int index = 0; index < theBoard.length / 2; index++) {
			if (theBoard[closestPit - index] == index + 1) {
				return closestPit - index;
			}
		}
		
		
		for (int index = closestPit; index >= theBoard.length / 2; index--) {
			
			if (theBoard[index] > 0
					&& this.ableToSteal(index,
					this.getLastPitPlayed(index, theBoard),
					this.getOppositePit(this.getLastPitPlayed(index, theBoard), theBoard), 
					theBoard)) {
				return index;
			}
		}
		
		return this.selectClosestPitWithStones(theBoard);
		
	}
	

	
//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Determines if player is able to take the stones from 
	 * the pit on the opposite side of the board. 
	 * 
	 * @param lastPitPlayed		The last pit that a seed was laid in
	 * @param pitOpposite		The pit on the opposite side of the board
	 * 							of the last played pit
	 * @param theBoard			The board used to play our game of Mancala
	 * 
	 * @precondition 			lastPitPlayed and pitOpposite must be 
	 * 							from on	game board	
	 * 							theBoard != null

	 * @return ableToSteal		true if you can take seeds from opposite pit
	 */
	private boolean ableToSteal(int originalPitPlayed, int lastPitPlayed, int pitOpposite, int[] theBoard) {
		if (theBoard == null) {
			throw new IllegalArgumentException("No board can be used. Does not exist.");
		}
		if (originalPitPlayed < 0 || originalPitPlayed > theBoard.length - 1) {
			throw new IllegalArgumentException("Pit number must be on board");
		}
		if (lastPitPlayed < 0 || lastPitPlayed > theBoard.length - 1) {
			throw new IllegalArgumentException("Pit number must be on board");
		}
		if (pitOpposite < 0) {
			throw new IllegalArgumentException("Opposite pit may not be negative.");
		}
		
		boolean ableToSteal = false; 
		int computerStore = theBoard.length - 1;
		
		if (originalPitPlayed == lastPitPlayed && theBoard[lastPitPlayed] == theBoard.length - 1) {
			ableToSteal = true;
		} else if (lastPitPlayed < theBoard.length / 2 - 1) {
			ableToSteal = false;
		} else if (theBoard[lastPitPlayed] == 0 && theBoard[pitOpposite] > 0 && lastPitPlayed != computerStore) {
			ableToSteal = true;
		}
		return ableToSteal;
	}
	
	/**
	 * Mock the distribution of stones from the given pit
	 * number so that the last stone given out will fall in 
	 * our last pit played. Return the last pit played.
	 * 
	 * @param pitNumber		The pit number where the stones
	 * 						are to be taken
	 * @param theBoard		The board used to play our game of Mancala
	 * 
	 * @precondition 		pitNumber must be on the board
	 * 						theBoard != null
	 * 
	 * @return currentPit	The pit currently having a seed
	 * 						placed in it
	 */
	public int getLastPitPlayed(int pitNumber, int[] theBoard) {
		if (theBoard == null) {
			throw new IllegalArgumentException("No board can be used. Does not exist.");
		}
		if (pitNumber < 0 || pitNumber > theBoard.length - 1) {
			throw new IllegalArgumentException("Can't get last pit played. Pit number is not on board on board");
		}
		
		int stonesFromPit = theBoard[pitNumber];
		
		int currentPit = pitNumber;
		for (int index = 0; index < stonesFromPit; index++) {
			
			if (currentPit == theBoard.length / 2 - 2) {
				currentPit += 2;
			} else if (currentPit < theBoard.length - 1) {
				currentPit++;
			} else {
				currentPit = 0;
			}
		}
		return currentPit;
	}
	
	/**
	 * Gets the pit opposite of the of the pit that is selected
	 * 
	 * @param pitNumber		The pit number we want the pit opposite of
	 * @param theBoard		The board used for our game of Mancala
	 * 
	 * @precondition 		pitNumber must be on the board
	 * 						theBoard != null
	 * 
	 * @return oppositePit	The pit opposite of the pit originally entered
	 * 						as our parameter	
	 */
	private int getOppositePit(int pitNumber, int[] theBoard) {
		if (theBoard == null) {
			throw new IllegalArgumentException("No board can be used. Does not exist.");
		}
		if (pitNumber < 0 || pitNumber > theBoard.length - 1) {
			throw new IllegalArgumentException("Can't get opposite pit. Original pit number is not on computer's side.");
		}
		
		int humanStore = theBoard.length / 2 - 1;
		int computerStore = theBoard.length - 1;
		int oppositePit = -1;
		
		
		if (pitNumber == computerStore) {
			oppositePit = humanStore;
		} else if (pitNumber == humanStore) {
			oppositePit = computerStore;
		} else {
			int closestPitToStore = theBoard.length - 2; 
			oppositePit = closestPitToStore - pitNumber;
		}
		
		return oppositePit;
	}
	
	
	/**
	 * Private helper method for select pit that
	 * will serve as a fall back plan in case we don't
	 * have a pit to choose that would get our last 
	 * seed into the computer's store. 
	 * 
	 * Uses the CloseStrategy
	 * 
	 * @return closestPit the pit closest to the store 
	 * 					  with stones in it
	 */
	private int selectClosestPitWithStones(int[] theBoard) {
		return new CloseStrategy().selectPit(theBoard);
	}
}
	 

