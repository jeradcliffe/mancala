package edu.westga.cs6910.mancala.model.strategies;

/**
 * The purpose of this new interface is to define the common 
 * interface for all the game-play algorithms for Mancala. 
 * 
 * This interface will define a single method called selectPit()
 * which will:
 * -Accept one parameter, a simple array of ints.This will 
 * 	be the game board which stores the number of stones in 
 * 	each pit.
 * -Returns the pit number selected.
 *  
 * @author Jacob Radcliffe
 * @version 6/24/16
 *
 */
public interface SelectStrategy {
	
	/**
	 * -Accept one parameter, a simple array of ints.This will 
	 * 	be the game board which stores the number of stones in 
	 * 	each pit.
	 * -Returns the pit number selected.
	 * 
	 * @param  theGame		an array of int values that represent
	 * 						the amount of seeds in each pit on the 
	 * 						game board
	 * 
	 * @return pitNumber	the pit number selected
	 * 
	 * @precondition 		theGame != null
	 */
	int selectPit(int[] theGame);
}
