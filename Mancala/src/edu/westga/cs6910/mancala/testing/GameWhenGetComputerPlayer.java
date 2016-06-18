package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test class to see if we can accurately
 * identify the computer that is playing the Game
 * 
 * @author Jacob Radcliffe
 * @version 6/17/16
 */
public class GameWhenGetComputerPlayer {

	/**
	 * Testing to see if we can getComputerPlayer()
	 * name from the Game
	 */
	@Test
	public void testGetComputerPlayerName() {
		Game newGame = new Game();
		assertEquals("Simple computer", newGame.getComputerPlayer().getName());
	}
	
	/**
	 * Testing to see if we can get the Game
	 * that the computer player is playing
	 */
	@Test
	public void testGetComputerPlayerGame() {
		Game newGame = new Game();
		assertEquals(newGame, newGame.getComputerPlayer().getGame());
	}

}
