package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * This is a test class to see if we are able to
 * make sure that we a successfully finding out who the 
 * current player is in a game. 
 * 
 * @author Jacob Radcliffe
 * @version 6/17/16
 */
public class GameWhenGetCurrentPlayer {

	/**
	 * Test to see if current player is human
	 */
	@Test
	public void testGetCurrentPlayerShoudlBeHuman() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(human, computer);
		assertEquals(human, newGame.getCurrentPlayer());
	}
	
	/**
	 * Test to see if current player is computer
	 */
	@Test
	public void testGetCurrentPlayerShoudlBeComputer() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(computer, human);
		assertEquals(computer, newGame.getCurrentPlayer());
	}

}
