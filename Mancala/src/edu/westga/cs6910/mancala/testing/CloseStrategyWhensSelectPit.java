package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.strategies.CloseStrategy;

/**
 * This class tests the selectPit() from CloseStrategy class
 * 
 * @author Jacob Radcliffe
 * @version 6/24/16
 */
public class CloseStrategyWhensSelectPit {
	
	/**
	 * Test a normally (new game) set up game board
	 * -Each pit has one stone besides stores
	 * 
	 * Return pit 6
	 */
	@Test
	public void testReturnPit6() {
		int[] gameBoard = new int[]{1, 1, 1, 0, 1, 1, 1, 0};
		assertEquals(6, new CloseStrategy().selectPit(gameBoard));
	}
	
	/**
	 * Pit 6 empty
	 * 
	 * Returns pit 5
	 */
	@Test
	public void testReturnPit5() {
		int[] gameBoard = new int[]{1, 1, 1, 0, 1, 1, 0, 1};
		assertEquals(5, new CloseStrategy().selectPit(gameBoard));
	}
	
	/**
	 * Pit 6 and 5 empty
	 * 
	 * Returns pit 4
	 */
	@Test
	public void testReturnPit4() {
		int[] gameBoard = new int[]{1, 1, 1, 0, 1, 0, 0, 1};
		assertEquals(4, new CloseStrategy().selectPit(gameBoard));
	}

}
