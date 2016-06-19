package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.AbstractPlayer;
import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Test class to see if we are able to retrieve
 * the abstract player's name when called for
 * 
 * @author Jacob Radcliffe
 * @version 6/19/16
 */
public class AbstractPlayerWhenGetName {
	
	/**
	 * Test to see if a human player is able to 
	 * inherit the AbstractPlayer's ability to getGame()
	 * that it is playing
	 */
	@Test
	public void testAbstractPlayerGetsHumanName() {
		Game newGame = new Game();
		AbstractPlayer human = new HumanPlayer("Jake", newGame);
		assertEquals("Jake", human.getName());
	}
	
	/**
	 * Test to see if computer player is able to 
	 * inherit the AbstractPlayer's ability to getGame()
	 * that is is playing
	 */
	@Test
	public void testAbstractComputerGetsComputerName() {
		Game newGame = new Game();
		AbstractPlayer computer = new ComputerPlayer(newGame);
		assertEquals("Simple computer", computer.getName());
	}

}
