package edu.westga.cs6910.mancala.model;

/**
 * HumanPlayer represents a human player in the game Mancala.
 * 
 * @author	CS6910
 * @version Summer 2016
 */
public class HumanPlayer extends AbstractPlayer {
	private Game theGame;
	
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
		super(name);
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		this.theGame = theGame;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn(int pitChoice) {
		while (this.theGame.getStones(pitChoice) == 0) {
			pitChoice--;
		}
		this.theGame.distributeStonesFrom(pitChoice);

		super.setIsMyTurn(false);
	}
}
