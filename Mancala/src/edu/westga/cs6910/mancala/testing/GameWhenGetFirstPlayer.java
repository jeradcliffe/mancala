package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;


/**
 * Returns the first player to have played the game
 * 
 * @author Jacob Radcliffe
 * @version 7/3/16
 */
public class GameWhenGetFirstPlayer {

	/**
	 * Start a new game with computer as first player.
	 * See if computer shows as first player to have played.
	 */
	@Test
	public void testComputerFirstPlayer() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), newGame.getHumanPlayer());
		assertEquals(newGame.getComputerPlayer(), newGame.getFirstPlayer());
	}
	
	/**
	 * Start a new game with human as first player.
	 * See if human shows as first player to have played.
	 */
	@Test
	public void testHumanFirstPlayer() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getHumanPlayer(), newGame.getComputerPlayer());
		assertEquals(newGame.getHumanPlayer(), newGame.getFirstPlayer());
	}

}
