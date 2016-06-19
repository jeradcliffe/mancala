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
public class ComputerPlayerWhenGetName {
	
	/**
	 * Test to see if computer player is able to 
	 * to getName(), which is a static final
	 * variable set as "Simple computer"
	 */
	@Test
	public void testComputerGetsItsName() {
		Game newGame = new Game();
		ComputerPlayer computer = new ComputerPlayer(newGame);
		assertEquals("Simple computer", computer.getName());
	}
}
