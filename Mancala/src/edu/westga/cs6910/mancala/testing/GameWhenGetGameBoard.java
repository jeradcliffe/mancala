package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Test to see if we are able to extract the 
 * values of each array index in the Game
 * via the getGameBoard() method
 * 
 * @author Jacob Radcliffe
 * @version 6/18/16
 */
public class GameWhenGetGameBoard {

	/**
	 * Start a new game and see if values match 
	 * in each index of the array.
	 */
	@Test
	public void testGetGameBoardWhenStartNewGame() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(human, computer);
		
		int[] expected = new int[]{1, 1, 1, 0, 1, 1, 1, 0};
		int differencesCounter = 0;
		for (int index = 0; index < newGame.getBoardSize(); index++) {
			if (expected[index] != newGame.getGameBoard()[index]) {
				differencesCounter++;
			}
		}
		assertEquals(0, differencesCounter);
	}
	
	/**
	 * Start a new game and see if values match 
	 * in each index of the array after one play 
	 * on index 1
	 */
	@Test
	public void testGetGameBoardAfterPlayPitOne() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(human, computer);
		newGame.play(0);
		
		int[] expected = new int[]{0, 2, 1, 0, 1, 1, 1, 0};
		int differencesCounter = 0;
		for (int index = 0; index < newGame.getBoardSize(); index++) {
			if (expected[index] != newGame.getGameBoard()[index]) {
				differencesCounter++;
			}
		}
		assertEquals(0, differencesCounter);
	}

}
