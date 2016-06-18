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
	
	/**
	 * Test to see if swap() method works via
	 * the play()
	 * 
	 * Start a new game and set it up. 
	 * Computer starts as current player and play() it's turn
	 * Human should now be current player
	 */
	@Test
	public void testGetCurrentPlayerAfterComputerToHumanSwap() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(computer, human);
		newGame.play(6);
		assertEquals(human, newGame.getCurrentPlayer());
	}
	
	/**
	 * Test to see if swap() method works via
	 * the play()
	 * 
	 * Start a new game and set it up. 
	 * Human starts as current player and play() it's turn
	 * Computer should now be current player
	 */
	@Test
	public void testGetCurrentPlayerAfterHumanToComputerSwap() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(human, computer);
		newGame.play(2);
		assertEquals(computer, newGame.getCurrentPlayer());
	}

}
