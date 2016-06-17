package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test class to clarify if a game is 
 * truly over or not
 * 
 * @author Jacob Radcliffe
 * @version 6/16/16
 */
public class GameWhenGetIsGameOver {
	
	/**
	 * Test to see if the game considers
	 * itself  over before it actually starts
	 */
	@Test
	public void testBeforeGameStartsIsNotOver() {
		Game newGame = new Game();
		assertEquals(false, newGame.getIsGameOver());
	}

}
