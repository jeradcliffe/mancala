package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Tests when the computer player
 * 
 * 
 * @author Jacob Radcliffe
 * @version 6/19/16
 *
 */
public class ComputePlayerWhenGetGame {

	/**
	 * Test to see if computer player is able to 
	 * to getGame() that is is playing
	 */
	@Test
	public void testComputerGetsGameItsPlaying() {
		Game newGame = new Game();
		ComputerPlayer computer = new ComputerPlayer(newGame);
		assertEquals(newGame, computer.getGame());
	}
}
