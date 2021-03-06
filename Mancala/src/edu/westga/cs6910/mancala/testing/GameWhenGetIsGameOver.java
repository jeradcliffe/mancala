package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;
import edu.westga.cs6910.mancala.model.strategies.CloseStrategy;

/**
 * Test class to clarify if a game is 
 * truly over or not
 * 
 * @author Jacob Radcliffe
 * @version 6/16/16
 */
public class GameWhenGetIsGameOver {
	
	/**
	 * Test to see if the game considers
	 * itself  over before it actually starts
	 */
	@Test
	public void testBeforeGameStartsIsNotOver() {
		Game newGame = new Game();
		assertEquals(false, newGame.getIsGameOver());
	}
	
	/**
	 * Test to see if the game considers
	 * itself over after it starts
	 */
	@Test
	public void testWhenGameFirstStartsIsNotOver() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame, new CloseStrategy());
		newGame.startNewGame(human, computer, 1);
		assertEquals(false, newGame.getIsGameOver());
	}
	
	/**
	 * Test to see if game is truly over
	 * after all pits are played
	 */
	@Test
	public void testWhenGameHasFinished() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame, new CloseStrategy());
		newGame.startNewGame(human, computer, 1);
		for (int index = 0; index <= newGame.getBoardSize() - 1; index++) {
			newGame.play(index);
		}
		assertEquals(true, newGame.getIsGameOver());
	}
}
