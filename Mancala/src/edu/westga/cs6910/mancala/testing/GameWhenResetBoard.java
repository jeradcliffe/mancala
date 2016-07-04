package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Test class to see if game board is properly reset
 * 
 * @author Jacob Radcliffe
 * @version 7/3/16
 */
public class GameWhenResetBoard {
	/**
	 * Test to see if the game board is set up 
	 * by default to have 1 stone in each pit
	 * 
	 * This is an indirect test because startNewGame()
	 * calls upon reset with a default of 1 stone per
	 * pit
	 */
	@Test
	public void testDefaultGameBoardOneStonePerPit() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), newGame.getHumanPlayer());
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
	 * Test to see if the game board is set up 
	 * to have four stones in each pit
	 */
	@Test
	public void testFourStonesPerPit() {
		Game newGame = new Game();
		newGame.startNewGame(newGame.getComputerPlayer(), newGame.getHumanPlayer());
		newGame.resetBoard(4);
		int[] expected = new int[]{4, 4, 4, 0, 4, 4, 4, 0};
		int differencesCounter = 0;
		for (int index = 0; index < newGame.getBoardSize(); index++) {
			if (expected[index] != newGame.getGameBoard()[index]) {
				differencesCounter++;
			}
		}
		assertEquals(0, differencesCounter);
	}

}
