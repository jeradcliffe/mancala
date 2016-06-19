package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * This test class will see if the HumanPlayer is able
 * to retrieve the game that it is playing
 * 
 * @author Jacob Radcliffe
 * @version 6/19/16
 */
public class HumanPlayerWhenGetGame {

	/**
	 * Test to see if a human player is able to 
	 * retrieve the game that it is playing
	 */
	@Test
	public void testHumanGetsGameItsPlaying() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		assertEquals(newGame, human.getGame());
	}

}
