package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to check functionality of 
 * distributeStonesFromPit() in the 
 * Game class
 * 
 * @author Jacob Radcliffe
 * @version 7/3/16
 *
 */
public class GameWhenDistributeStonesFromPit {

	/**
	 * Test Game board when computer makes 
	 * first move in a default game board set up
	 * (i.e. one stone in each pit)
	 */
	@Test
	public void testDistributeOneStoneFrom5() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), newGame.getHumanPlayer(), 1);
		int lastPitUsed = newGame.distributeStonesFrom(6);
		assertEquals(7, lastPitUsed);
	}
	
	/**
	 * Test Game board when computer makes 
	 * first move in a game with 4 stones
	 * in each pit
	 */
	@Test
	public void testFourStonesEachPit() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), newGame.getHumanPlayer(), 4);
		int lastPitUsed = newGame.distributeStonesFrom(6);
		assertEquals(2, lastPitUsed);
	}
	
	

}
