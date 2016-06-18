package edu.westga.cs6910.mancala.model;

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
	
	/**
	 * Creates a new ComputerPlayer with the specified name.
	 * 
	 * @param	theGame	The Game that this player represents
	 * 
	 */
	public ComputerPlayer(Game theGame) {
		super(NAME, theGame);
	}

	
	@Override
	/**
	 * @see AbstractPlayer#takeTurn()
	 */	
	public void takeTurn(int pitChoice) {				
		pitChoice = super.getGame().getBoardSize() - 2;
		while (super.getGame().getStones(pitChoice) == 0) {
			pitChoice--;
		}
		super.getGame().distributeStonesFrom(pitChoice);

		super.setIsMyTurn(false);
	}
}
