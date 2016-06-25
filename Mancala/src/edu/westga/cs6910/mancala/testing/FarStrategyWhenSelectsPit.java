package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.strategies.FarStrategy;

/**
 * This class tests the selectPit() from FarStrategy class
 * 
 * @author Jacob Radcliffe
 * @version 6/25/16
 */
public class FarStrategyWhenSelectsPit {


	/**
	 * Test a normally (new game) set up game board
	 * -Each pit has one stone besides stores
	 * 
	 * Return pit 4
	 */
	@Test
	public void testNewGameSelectFarthestPitFromStore() {
		int[] gameBoard = new int[]{1, 1, 1, 0, 1, 1, 1, 0};
		assertEquals(4, new FarStrategy().selectPit(gameBoard));
	}
	

	/**
	 * Pit 4 empty
	 * 
	 * Return pit 5
	 */
	@Test
	public void testSelectPitWhenPit4Empty() {
		int[] gameBoard = new int[]{1, 1, 1, 0, 0, 2, 1, 0};
		assertEquals(5, new FarStrategy().selectPit(gameBoard));
	}
	
	/**
	 * All pits empty (compute side of game)
	 * except Pit 6
	 * 
	 * Return pit 6
	 */
	@Test
	public void testSelectPitWhenAllPitsEmptyExcept6() {
		int[] gameBoard = new int[]{1, 1, 1, 0, 0, 0, 2, 0};
		assertEquals(6, new FarStrategy().selectPit(gameBoard));
	}

}
