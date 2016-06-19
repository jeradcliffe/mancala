package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.AbstractPlayer;
import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * This test class will see if the AbstractPlayer is able
 * to retrieve the game that it is playing
 * 
 * @author Jacob Radcliffe
 * @version 6/19/16
 */
public class AbstractPlayerWhenGetGame {

	/**
	 * Test to see if a human player is able to 
	 * inherit the AbstractPlayer's ability to getGame()
	 * that it is playing
	 */
	@Test
	public void testAbstractHumanGetsGameItsPlaying() {
		Game newGame = new Game();
		AbstractPlayer human = new HumanPlayer("Jake", newGame);
		assertEquals(newGame, human.getGame());
	}
	
	/**
	 * Test to see if computer player is able to 
	 * inherit the AbstractPlayer's ability to getGame()
	 * that is is playing
	 */
	@Test
	public void testAbstractComputerGetsGameItsPlaying() {
		Game newGame = new Game();
		AbstractPlayer computer = new ComputerPlayer(newGame);
		assertEquals(newGame, computer.getGame());
	}

}
