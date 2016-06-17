package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;
/**
 * This class is used to test the creation
 * of a Game object
 * 
 * @author Jacob Radcliffe
 * @version 6/16/16
 */
public class GameWhenCreateGame {
	
	/**
	 * This test will produce a game
	 * with no score
	 */
	@Test
	public void testShouldProduceGameWithNoScore() {
		Game newGame = new Game();
		assertEquals("<html><body>Me: 0<br>Simple computer: 0<br>"
				+ "</body></html>", newGame.toString()); 
	}

}
