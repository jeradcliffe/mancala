package edu.westga.cs6910.mancala.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.westga.cs6910.mancala.model.Game;

import java.util.Observable;
import java.util.Observer;

/**
 * Defines the panel that displays the total number of stones in
 * 	each store.  It also displays the winner (or tie) at the end
 * 	of the game
 * 
 * @author	CS 6910
 * @version	Summer 2016
 */
public class GameStatusPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 160606L;

	private JLabel lblMessage;
	private Game theGame;	
	
	/**
	 * Creates a new GameStatusPanel that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this panel gets its data
	 * 
	 * @requires 	theGame != null
	 * @ensures		theGame.countObservers() = theGame.countObservers()@prev + 1
	 */
	public GameStatusPanel(Game theGame)  {
		super();
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		
		this.theGame = theGame;		
		this.theGame.addObserver(this);
		
		this.setBorder(BorderFactory.createTitledBorder("Game info"));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.lblMessage = new JLabel(this.theGame.toString());
		this.add(this.lblMessage);
	}
		
	@Override	
	/**
	 * Sets this Panel's text to show the return value of the Game's
	 * toString() method. Called when the observed Game object notifies
	 * this Panel that a Player took a turn. 
	 * 
	 * @param 	observableObject	not used
	 * @param 	arg					not used
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * @ensures the panel's text displays either the current score
	 * 			or the winner if the game is over.
	 */
	public void update(Observable observableObject, Object arg) {		
		this.lblMessage.setText(this.theGame.toString());
	}
}
