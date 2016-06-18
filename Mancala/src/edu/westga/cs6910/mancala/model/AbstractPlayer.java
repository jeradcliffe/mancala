package edu.westga.cs6910.mancala.model;

/**
 * This abstract class will implement the shared code
 * and define the abstract methods for the methods without 
 * duplicate code in the ComputerPlayer and HumanPlayer classes.
 * 
 * It will also implement the Player interface.
 * 
 * @author Jacob Radcliffe
 * @version 6/12/16
 *
 */
public abstract class AbstractPlayer implements Player {
	private boolean isMyTurn;
	private String name;
	private Game theGame;
	
	/**
	 * Creates an AbstractPlayer a specified name
	 * 
	 * @param	name	this Player's name
	 * @param   theGame	the Game this Player is playing
	 * 
	 * @requires	name != null
	 * 				theGame != null
	 */
	public AbstractPlayer(String name, Game theGame) {
		if (name == null) {
			throw new IllegalArgumentException("Invalid player name");
		}
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid game object");
		}
		this.name = name;
		this.theGame = theGame;
	}
	
	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.Player#getIsMyTurn()
	 */
	@Override
	public boolean getIsMyTurn() {
		return this.isMyTurn;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.Player#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.Player#setIsMyTurn(boolean)
	 */
	@Override
	public void setIsMyTurn(boolean isMyTurn) {
		this.isMyTurn = isMyTurn;
	}

	/* (non-Javadoc)
	 * @see edu.westga.cs6910.mancala.model.Player#takeTurn(int)
	 */
	@Override
	public abstract void takeTurn(int pitChoice);
	
	/**
	 * This method will return the Game object of the 
	 * Abstract Player
	 * 
	 * @return this.theGame reference
	 */
	public Game getGame() {
		return this.theGame;
	}
}
