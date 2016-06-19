package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Tests when the computer player
 * getName() of itself
 * 
 * @author Jacob Radcliffe
 * @version 6/19/16
 *
 */
public class HumanPlayerWhenGetName {

	/**
	 * Test to see if a human player is able to
	 * retrieve its own name
	 */
	@Test
	public void testHumanPlayerGetsName() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		assertEquals("Jake", human.getName());
	}

}
