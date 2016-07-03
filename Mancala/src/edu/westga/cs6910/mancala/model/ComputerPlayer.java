package edu.westga.cs6910.mancala.model;

import edu.westga.cs6910.mancala.model.strategies.SelectStrategy;

// TODO: Classes ComputerPlayer and HumanPlayer share most of their code.
//		 Refactor their code:
// 		 1. Create abstract base class AbstractPlayer to implement the
//			shared code and define abstract methods for methods without
//			duplicate code. AbstractPlayer should implement interface Player.
//		 2. Have ComputerPlayer and HumanPlayer extend AbstractPlayer to
//		    implement the unshared constructor code and the abstract methods.

/**
 * ComputerPlayer represents a very simple automated player in the game Mancala.
 * It always selects the closest pit for stones to be distributed
 * 
 * @author	Jacob Radcliffe
 * @version	Summer 2016
 */
public class ComputerPlayer extends AbstractPlayer {
	private static final String NAME = "Simple computer";
	private SelectStrategy strategy;
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param	theGame		The Game that this player represents
	 * @param	newStrategy	The strategy that our computer will use
	 */
	public ComputerPlayer(Game theGame, SelectStrategy newStrategy) {
		super(NAME, theGame);
		if (theGame == null) {
			throw new IllegalArgumentException("No game exists for the computer");
		}
		if (newStrategy == null) {
			throw new IllegalArgumentException("No strategy selected for comptuer.");
		}
		this.strategy = newStrategy;
	}

	
	/*
	 * @see AbstractPlayer#takeTurn()
	 */	
	@Override
	public int takeTurn(int pitChoice) {				
		pitChoice = this.strategy.selectPit(super.getGame().getGameBoard());
		int lastPitPlayed = super.getGame().distributeStonesFrom(pitChoice);
		super.setIsMyTurn(false);
		return lastPitPlayed;
	}
	
	/**
	 * This method sets that strategy that our computer player
	 * will use to play the game.
	 * 
	 * @param newStrategy	The new strategy that we want 
	 * 						our computer to use
	 * 
	 * @precondition 		newStrategy != null
	 * @postcondition		newStrategy will determine how computer
	 * 						will play
	 */
	public void setStrategy(SelectStrategy newStrategy) {
		this.strategy = newStrategy;
	}
}
