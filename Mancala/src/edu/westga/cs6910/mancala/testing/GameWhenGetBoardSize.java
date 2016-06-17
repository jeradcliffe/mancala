package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test to see if we can set up a Game
 * with the correct board size
 * 
 * @author Jacob Radcliffe
 * @version 6/16/16
 */
public class GameWhenGetBoardSize {

	/**
	 * Tests to see if we truly 
	 * get a board with a size of 8
	 */
	@Test
	public void testNewGameShouldHaveBoardSize8() {
		Game newGame = new Game();
		assertEquals(8, newGame.getBoardSize());
	} 

}
