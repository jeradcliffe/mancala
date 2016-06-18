package edu.westga.cs6910.mancala.model;

/**
 * HumanPlayer represents a human player in the game Mancala.
 * 
 * @author	CS6910
 * @version Summer 2016
 */
public class HumanPlayer extends AbstractPlayer {
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param 	name	this Player's name
	 * @param	theGame	The Game that this player represents
	 * 
	 * @requires	name != null
	 * @ensure		name().equals(name) && getTotal() == 0
	 */
	public HumanPlayer(String name, Game theGame) {
		super(name, theGame);
	}

	@Override
	/**
	 * @see AbstractPlayer#takeTurn()
	 */
	public void takeTurn(int pitChoice) {
		while (super.getGame().getStones(pitChoice) == 0) {
			pitChoice--;
		}
		super.getGame().distributeStonesFrom(pitChoice);

		super.setIsMyTurn(false);
	}
}
