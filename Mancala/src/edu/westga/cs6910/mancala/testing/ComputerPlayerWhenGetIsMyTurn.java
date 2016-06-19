package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.AbstractPlayer;
import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;

/**
 * Tests when the computer player
 * 
 * 
 * @author Jacob Radcliffe
 * @version 6/19/16
 *
 */
public class ComputerPlayerWhenGetIsMyTurn {

	/**
	 * Set up a new game with the computer player and see if
	 * the setIsMyTurn() will return true when getIsMyTurn()
	 * is called
	 */
	@Test
	public void testAbstractComputersTurnIsTrue() {
		Game newGame = new Game();
		AbstractPlayer computer = new ComputerPlayer(newGame);
		computer.setIsMyTurn(true);
		assertEquals(true, computer.getIsMyTurn());
	}
	

	/**
	 * Test to see if it is the computer's turn after it 
	 * plays one turn (should return false)
	 * 
	 * Note: takeTurn() is used by the play() method.
	 * However, it can still be used independently, but
	 * it wont swap() turns to the other player when
	 * used. Only the play() method will do this.
	 */
	@Test
	public void testAbstractComputersTurnIsFalseAfterTakesTurn() {
		Game newGame = new Game();
		AbstractPlayer human = new HumanPlayer("Jake", newGame);
		AbstractPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(computer, human);
		computer.takeTurn(0);
		assertEquals(false, computer.getIsMyTurn());
	}
	
	/**
	 * Test to see if it is the computer's turn after human 
	 * plays one turn 
	 * 
	 * Note: takeTurn() is used by the play() method.
	 * However, it can still be used independently, but
	 * it wont swap() turns to the other player when
	 * used. Only the play() method will do this.
	 */
	@Test
	public void testAbstractComputersTurnIsTrueAfterHumanPlaysOnce() {
		Game newGame = new Game();
		AbstractPlayer human = new HumanPlayer("Jake", newGame);
		AbstractPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(human, computer);
		newGame.play(0);
		assertEquals(true, computer.getIsMyTurn());
	}
	
	/**
	 * Test to see if it is the computer's turn after computer 
	 * plays one turn 
	 * 
	 * Note: takeTurn() is used by the play() method.
	 * However, it can still be used independently, but
	 * it wont swap() turns to the other player when
	 * used. Only the play() method will do this.
	 */
	@Test
	public void testAbstractComputersTurnFalseAfterComputerPlaysOnce() {
		Game newGame = new Game();
		AbstractPlayer human = new HumanPlayer("Jake", newGame);
		AbstractPlayer computer = new ComputerPlayer(newGame);
		newGame.startNewGame(computer, human);
		newGame.play(0);
		assertEquals(false, computer.getIsMyTurn());
	}

}

