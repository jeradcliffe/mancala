package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Testing class to see if we are able to create a game
 * with a set human player and getHumanPlayer()
 * 
 * @author Jacob Radcliffe
 * @version 6/17/16
 *
 */
public class GameWhenGetHumanPlayer {

	/**
	 * Testing to see if we can getHumanPlayer()
	 * name from the Game
	 */
	@Test
	public void testGetHumanPlayerName() {
		Game newGame = new Game();
		assertEquals("Me", newGame.getHumanPlayer().getName());
	}
	
	/**
	 * Testing to see if we can get the Game
	 * that the human player is playing
	 */
	@Test
	public void testGetHumanPlayerGame() {
		Game newGame = new Game();
		assertEquals(newGame, newGame.getHumanPlayer().getGame());
	}

}
