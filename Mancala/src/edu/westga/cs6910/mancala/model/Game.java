package edu.westga.cs6910.mancala.model;

import java.util.Observable;

/**
 * Game represents a Mancala game.
 * @author	Jacob Radcliffe
 * @version	Summer 2016
 */
public class Game extends Observable {
	private int[] theBoard;
	
	private Player currentPlayer;
	private Player otherPlayer;

	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;
	
	private Player theWinner;
	private boolean isGameOver;

	/**
	 * Creates a Mancala Game with the specified Players
	 * 
	 */
	public Game() {
		this.theHuman = new HumanPlayer("Me", this);
		this.theComputer = new ComputerPlayer(this);
		
		this.currentPlayer = null;
		this.otherPlayer = null;

		this.theBoard = new int[8];
	}

	/**
	 * Distributes the stones located in pitNumber
	 * 	to all subsequent pits, one at a time in 
	 * 	counter-clockwise order
	 * 
	 * @param pitNumber	The pit number where the stones
	 * 					are to be taken
	 */
	public void distributeStonesFrom(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}
		// TODO: Take the stones currently located in the
		//		 pit specified and distribute them, one at
		//		 a time into each pit (including stores)
		//		 in counter-clockwise order
		int stonesFromPit = this.getStones(pitNumber);
		this.theBoard[pitNumber] = 0;
		for (int index = 1; index <= stonesFromPit; index++) {
			this.theBoard[pitNumber + index] += 1;
		}
	}

	/**
	 * Returns the number of slots (pits and stores) on the board
	 * 
	 * @return	The number of slots on the board
	 */
	public int getBoardSize() {
		return this.theBoard.length;
	}
	
	/**
	 * Returns the computer Player object.
	 * 
	 * @return the computer Player
	 */
	public ComputerPlayer getComputerPlayer() {
		return this.theComputer;
	}
	
	/**
	 * Returns the Player whose turn it is.
	 * 
	 * @return	the current Player
	 */
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	/**
	 * Returns the human Player object.
	 * 
	 * @return the human Player
	 */
	public HumanPlayer getHumanPlayer() {
		return this.theHuman;
	}
	
	/**
	 * Returns whether the game has completed yet or not
	 * 
	 * @return	true iff the game is over; false otherwise
	 */
	public boolean getIsGameOver() {
		return this.isGameOver;
	}

	/**
	 * Returns the number of stones in the specified pit
	 * 
	 * @param pitNumber	The pit location that is potentially
	 * 					holding stones
	 * @return	The number of stones in the specified pit
	 */
	public int getStones(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}
		return this.theBoard[pitNumber];
	}
	
	/**
	 * Conducts a move in the game, allowing the appropriate Player to
	 * take a turn. Has no effect if the game is over.
	 * 
	 * @param	pitChoice	The pit number where the stones will
	 * 						be taken from
	 * 
	 * @requires	!isGameOver()
	 * 
	 * @ensures		!whoseTurn().equals(whoseTurn()@prev)
	 */
	public void play(int pitChoice) {
		this.currentPlayer.takeTurn(pitChoice);
		
		Player winner = this.getFinisher();
		if (winner != null) {
			this.finishGame(winner);
		} else {
			this.swapWhoseTurn();
		}
				
		this.setChanged();
		this.notifyObservers();
	}

	private Player getFinisher() {
		int humanStoneCount = 0;
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			humanStoneCount += this.theBoard[index];
		}
		if (humanStoneCount == 0) {
			return this.theHuman;
		}
		
		int computerStoneCount = 0;
		for (int index = this.theBoard.length / 2; index < this.theBoard.length - 1; index++) {
			computerStoneCount += this.theBoard[index];
		}
		if (computerStoneCount == 0) {
			return this.theComputer;
		}
		return null;		
	}
	
	private void finishGame(Player finisher) {
		int humanStore = this.theBoard.length / 2 - 1;
		int computerStore = this.theBoard.length - 1;
		if (finisher.equals(this.theHuman)) {
			int storeIndex = humanStore;
			for (int index = this.theBoard.length / 2; index < this.theBoard.length - 1; index++) {
				this.theBoard[storeIndex] += this.theBoard[index];
				this.theBoard[index] = 0;
			}
		} else {
			int storeIndex = computerStore;
			for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
				this.theBoard[storeIndex] += this.theBoard[index];
				this.theBoard[index] = 0;
			}
		}
		if (this.theBoard[humanStore] > this.theBoard[computerStore]) {
			this.theWinner = this.theHuman;
		} else if (this.theBoard[computerStore] > this.theBoard[humanStore]) {
			this.theWinner = this.theComputer;
		}
		this.isGameOver = true;
	}
	
	/**
	 * Returns a copy of the game board keeping track
	 * 	of the number of stones in each pit
	 * 
	 * @return	The game board
	 */
	public int[] getGameBoard() {
		return this.theBoard.clone();
	}
	
	/**
	 * Sets up the board such that there is exactly 1 stone
	 * 	in each pit
	 */
	private void resetBoard() {
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			this.theBoard[index] = 1;
			this.theBoard[index + this.theBoard.length / 2] = 1;
		}
	}

	/**
	 * Initializes the game for play.
	 * 
	 * @param firstPlayer 	the Player who takes the first turn
	 * @param secondPlayer	the Player who takes the second turn
	 * 
	 * @require 			firstPlayer != null && 
	 * 						secondPlayer != null &&
	 * 						!firstPlayer.equals(secondPlayer)
	 * 
	 * @ensures 			whoseTurn().equals(firstPlayer)
	 */
	public void startNewGame(Player firstPlayer, Player secondPlayer) {
		this.currentPlayer = firstPlayer;
		this.otherPlayer = secondPlayer;
			
		this.resetBoard();
		
		this.setChanged();
		this.notifyObservers();
	}

	private void swapWhoseTurn() {
		// TODO: Swap the players so that the other player becomes 
		//       the current player and vice versa. Be sure to set 
		//		 the player objects such that they know whose turn
		//		 it is now that the positions have swapped
		if (!this.currentPlayer.getIsMyTurn()) {
			Player holder = this.getCurrentPlayer();
			this.currentPlayer = this.otherPlayer;
			this.otherPlayer = holder;
			this.currentPlayer.setIsMyTurn(true);
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Returns a String showing the current score, or, if
	 * the game is over, the name of the winner.
	 * 
	 * @return a String representation of this Game
	 */
	public String toString() {	
		String result = "<html><body>"; 
		result += this.theHuman.getName() + ": " 
				+ this.theBoard[this.theBoard.length / 2 - 1] + "<br>";
		result += this.theComputer.getName() + ": " 
				+ this.theBoard[this.theBoard.length - 1] + "<br>";
		if (this.isGameOver && this.theWinner != null) {
			result += this.theWinner.getName() + " wins";
		} else if (this.isGameOver && this.theWinner == null) {
			result += "Tie game";
		}

		result += "</body></html>";
		return result;
	}
}
