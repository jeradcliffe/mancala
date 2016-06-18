package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

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
	 * from the Game
	 */
	@Test
	public void testGetHumanPlayer() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Frank", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(human, computer);
		assertEquals(human, newGame.getHumanPlayer());
	}

}
