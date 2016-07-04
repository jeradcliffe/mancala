package edu.westga.cs6910.mancala.model;

import java.util.Observable;

import javax.swing.JOptionPane;

import edu.westga.cs6910.mancala.model.strategies.CloseStrategy;

/**
 * Game represents a Mancala game.
 * 
 * @author	Jacob Radcliffe
 * @version	Summer 2016
 */
public class Game extends Observable {
	private int[] theBoard;
	
	private Player firstPlayer;
	private Player currentPlayer;
	private Player otherPlayer;

	private HumanPlayer theHuman;
	private ComputerPlayer theComputer;
	
	private Player theWinner;
	private boolean isGameOver;

	/**
	 * Creates a Mancala Game with the specified Players
	 */
	public Game() {
		this.theHuman = new HumanPlayer("Me", this);
		this.theComputer = new ComputerPlayer(this, new CloseStrategy());
		
		this.firstPlayer = null;
		this.currentPlayer = null;
		this.otherPlayer = null;

		this.theBoard = new int[8];
	}

	/**
	 * Distributes the stones located in pitNumber
	 * to all subsequent pits, one at a time in 
	 * counter-clockwise order
	 * 
	 * @param pitNumber		The pit number where the stones
	 * 						are to be taken
	 * 
	 * @return currentPit	The pit currently having a seed
	 * 						placed in it
	 */
	public int distributeStonesFrom(int pitNumber) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit number cannot be negative");
		}
		// TODO: Take the stones currently located in the
		//		 pit specified and distribute them, one at
		//		 a time into each pit (including stores)
		//		 in counter-clockwise order
		int stonesFromPit = this.getStones(pitNumber);
		this.theBoard[pitNumber] = 0;
		
		int currentPit = pitNumber;
		
		for (int index = 0; index < stonesFromPit; index++) {
			if (currentPit < 7) {
				currentPit++;
				this.theBoard[currentPit] += 1;
			} else {
				currentPit = 0;
				this.theBoard[currentPit] += 1;
			}
		}
		return currentPit;
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
	 * Returns the first player to have played
	 * the game
	 * 
	 * @return the first player
	 */
	public Player getFirstPlayer() {
		return this.firstPlayer;
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
	 * Returns a copy of the game board keeping track
	 * 	of the number of stones in each pit
	 * 
	 * @return	The game board
	 */
	public int[] getGameBoard() {
		return this.theBoard.clone();
	}
//////////////End of getters and setters, begin play experience//////////////////////
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
		int lastPitPlayed = this.currentPlayer.takeTurn(pitChoice);
		
		this.takeOpponentsStones(lastPitPlayed);
		
		Player winner = this.getFinisher();
		if (winner != null) {
			this.finishGame(winner);
		} else if (this.currentPlayer == this.getComputerPlayer() && lastPitPlayed == this.getBoardSize() - 1) {
			this.currentPlayer.setIsMyTurn(true);
			JOptionPane.showMessageDialog(null, "Computer's last stone placed in store. \n Computer plays again.");
		} else if (this.currentPlayer == this.getHumanPlayer() && lastPitPlayed == this.getBoardSize() / 2 - 1) {
			this.currentPlayer.setIsMyTurn(true);	
			JOptionPane.showMessageDialog(null, "Your last stone placed in store. \n You get to play again.");
		} else {
			this.swapWhoseTurn();
			this.currentPlayer.setIsMyTurn(true);
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

/////////////////Methods that deal with starting and resetting the game/////////////////////////
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
		this.firstPlayer = firstPlayer;
		this.currentPlayer = firstPlayer;
		this.otherPlayer = secondPlayer;
			
		this.resetBoard(1);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Sets up the board such that there is exactly 1 stone
	 * 	in each pit
	 * 
	 * @param stonesPerPit 	the number of stones to add into each pit
	 * 
	 * @precondition 		0 < stonesPerPit <=4
	 */
	private void resetBoard(int stonesPerPit) {
		if (stonesPerPit < 0 && stonesPerPit > 4) {
			throw new IllegalArgumentException("Number of stones may not be negative and must be less than 4.");
		}
		
		for (int index = 0; index < this.theBoard.length / 2 - 1; index++) {
			this.theBoard[index] = stonesPerPit;
			this.theBoard[index + this.theBoard.length / 2] = stonesPerPit;
		}
		this.theBoard[this.theBoard.length / 2 - 1] = 0;
		this.theBoard[this.theBoard.length - 1] = 0;
		
		this.setChanged();
		this.notifyObservers();
	}

/////////////////////Methods to steal opponents seeds when playing last seed in empty pit//////////////////	
	/**
	 * If the last stone you place is in an empty pit on your side of the board, 
	 * you will capture (move to your store) any stones in the corresponding pit 
	 * on the opposite side of the board
	 * 
	 * @param lastPitPlayed		The last pit that a seed was laid in
	 * 
	 * @precondition 			lastPitPlayed must be one from the 
	 * 							game board
	 */
	private void takeOpponentsStones(int lastPitPlayed) {
		if (lastPitPlayed < 0 || lastPitPlayed > 7) {
			throw new IllegalArgumentException("Pit number must be on board");
		}
		
		int humanStore = this.theBoard.length / 2 - 1;
		int computerStore = this.theBoard.length - 1;
		
		if (lastPitPlayed == 0 && this.currentPlayer == this.theHuman && this.ableToSteal(lastPitPlayed, 6)) {
			this.putOppositePitsInStore(lastPitPlayed, 6, humanStore);
		} else if (lastPitPlayed == 1 && this.currentPlayer == this.theHuman && this.ableToSteal(lastPitPlayed, 5)) {
			this.putOppositePitsInStore(lastPitPlayed, 5, humanStore);
		} else if (lastPitPlayed == 2 && this.currentPlayer == this.theHuman && this.ableToSteal(lastPitPlayed, 4)) {
			this.putOppositePitsInStore(lastPitPlayed, 4, humanStore);
		} else if (lastPitPlayed == 4 && this.currentPlayer == this.theComputer && this.ableToSteal(lastPitPlayed, 2)) {
			this.putOppositePitsInStore(lastPitPlayed, 2, computerStore);
		} else if (lastPitPlayed == 5 && this.currentPlayer == this.theComputer && this.ableToSteal(lastPitPlayed, 1)) {
			this.putOppositePitsInStore(lastPitPlayed, 1, computerStore);
		} else if (lastPitPlayed == 6 && this.currentPlayer == this.theComputer && this.ableToSteal(lastPitPlayed, 0)) {
			this.putOppositePitsInStore(lastPitPlayed, 0, computerStore);
		}
	}
	
	/**
	 * Determines if player is able to take the stones from 
	 * the pit on the opposite side of the board. 
	 * 
	 * @param lastPitPlayed		The last pit that a seed was laid in
	 * @param pitOpposite		The pit on the opposite side of the board
	 * 							of the last played pit
	 * 
	 * @precondition 			lastPitPlayed must be one from the 
	 * 							game board	

	 * @return ableToSteal		true if you can take seeds from opposite pit
	 */
	private boolean ableToSteal(int lastPitPlayed, int pitOpposite) {
		if (lastPitPlayed < 0 || lastPitPlayed > 7) {
			throw new IllegalArgumentException("Pit number must be on board");
		}
		if (pitOpposite < 0 || pitOpposite > 7) {
			throw new IllegalArgumentException("Opposit pit number must be on board");
		}
		
		boolean ableToSteal = false; 
		if (this.theBoard[lastPitPlayed] == 1 && this.theBoard[pitOpposite] > 0) {
			return true;
		}
		return ableToSteal;
	}
	
	/**
	 * 
	 * @param lastPitPlayed		The last pit that a seed was laid in
	 * @param pitOpposite		The pit on the opposite side of the board
	 * 							of the last played pit
	 * @param store				The store where the combined seeds should be placed
	 * 
	 * @precondition 			lastPitPlayed must be on board
	 * 							pitOpposite must be on board
	 * 							store must computer's or human's last pit on their side
	 */
	private void putOppositePitsInStore(int lastPitPlayed, int pitOpposite, int store) {
		if (lastPitPlayed < 0 || lastPitPlayed > 7) {
			throw new IllegalArgumentException("Pit number must be on board");
		}
		if (pitOpposite < 0 || pitOpposite > 7) {
			throw new IllegalArgumentException("Opposit pit number must be on board");
		}
		
		this.theBoard[store] +=  this.getStones(lastPitPlayed) + this.getStones(pitOpposite);
		this.theBoard[lastPitPlayed] = 0;
		this.theBoard[pitOpposite] = 0;
		
		if (this.currentPlayer == this.theHuman) {
			JOptionPane.showMessageDialog(null, "Human takes stones from opposite pit.");
		} else if (this.currentPlayer == this.theComputer) {
			JOptionPane.showMessageDialog(null, "Computer takes stones from opposite pit.");
		}
	}
	
/////////////////////////////////To String////////////////////////////////////////////////	
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
