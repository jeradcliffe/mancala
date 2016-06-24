package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;
import edu.westga.cs6910.mancala.model.strategies.CloseStrategy;

/**
 * Test to see is we are successfully able to 
 * see whether or not it is our computer players turn
 * 
 * Note: Due to the void method types of both
 * setIsMyTurn() and takeTurn(), we need to have those
 * used in this test class, followed by the getIsMyTurn()
 * to check for validity
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
	public void testComputersTurnIsTrue() {
		Game newGame = new Game();
		ComputerPlayer computer = new ComputerPlayer(newGame, new CloseStrategy());
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
	public void testComputersTurnIsFalseAfterTakesTurn() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame, new CloseStrategy());
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
	public void testComputersTurnIsTrueAfterHumanPlaysOnce() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame, new CloseStrategy());
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
	public void testComputersTurnFalseAfterComputerPlaysOnce() {
		Game newGame = new Game();
		HumanPlayer human = new HumanPlayer("Jake", newGame);
		ComputerPlayer computer = new ComputerPlayer(newGame, new CloseStrategy());
		newGame.startNewGame(computer, human);
		newGame.play(0);
		assertEquals(false, computer.getIsMyTurn());
	}

}

