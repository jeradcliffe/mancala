package edu.westga.cs6910.mancala.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import edu.westga.cs6910.mancala.model.ComputerPlayer;
import edu.westga.cs6910.mancala.model.Game;

/**
 * Defines the panel that lets the user tell the computer player to
 * take its turn and that displays the setup of this player's side
 * of the board
 * 
 * @author	Jacob Radcliffe
 * @version	Summer 2016
 */
public class ComputerPlayerPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 160606L;
	
	private Game theGame;
	private ComputerPlayer theComputer;

	/**
	 * Creates a new ComputerPlayerPanel that observes the specified game. 
	 * 
	 * @param theGame	the model object from which this panel gets its data
	 * 
	 * @requires 	theGame != null
	 * @ensures		theGame.countObservers() = theGame.countObservers()@prev + 1
	 */
	public ComputerPlayerPanel(Game theGame) {
		super();
		
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		this.theGame = theGame;
		
		// TODO: Add this object as an observer of this.theGame.
		//       See http://tinyurl.com/javaObserverPattern
		this.theGame.addObserver(this);
		
		this.theComputer = this.theGame.getComputerPlayer();
		
		this.buildPanel();
	}
	
	private void buildPanel() {
		// TODO: Using the other panel classes as a model, build this panel.

	}

	/** 
	 * Sets whether or not this panel and its components are enabled.
	 * 
	 * @param  enabled true if this component should be enabled, false otherwise	
	 * @see javax.swing.JComponent#setEnabled(boolean)
	 * 
	 * @ensures enabled() == enabled &&		<br />
	 * 			for each Component c in getComponents(), c.enabled() == enabled
	 */
	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		
		for (Component aComponent: this.getComponents()) {
			aComponent.setEnabled(enabled);
			if (aComponent instanceof JPanel) {
				JPanel innerPanel = (JPanel) aComponent;
				for (Component bComponent: innerPanel.getComponents()) {
					bComponent.setEnabled(enabled);
				}
			}
		}
	}

	/**
	 * Sets this Panel's members to display the status of this player's side
	 * 	of the board.  It also enables the components when it is their turn
	 * 	(components are disabled otherwise)
	 * 
	 * @param arg0	not used
	 * @param arg1	not used
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * 
	 * @ensures the panel's text is changed && isEnabled() == !isEnabled@prev
	 */
	@Override
	public void update(Observable arg0, Object arg1) {	
		// TODO: Check to see if it is theComputer's turn.  If so
		//		 enable the components, otherwise disable them



		if (this.theGame.getIsGameOver()) {
			this.setEnabled(false);
		}
	}
	
	/* 
	 * Defines the listener for takeTurnButton.
	 */
	private class TakeTurnListener implements ActionListener {
		/* 
		 * Tells the Game to have its current player (i.e., the computer Player)
		 * take its turn.	
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO: if the game isn't finished: 
			//		 - Tell theGame to play a move.  Because this is
			//		   the computer playing, just pass -1 as the 
			//		   pit number

		}
	}
}
