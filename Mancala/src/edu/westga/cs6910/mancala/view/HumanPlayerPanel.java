package edu.westga.cs6910.mancala.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.HumanPlayer;


/**
 * Defines the panel that lets the user either roll or hold during
 * 	their turn and that displays the setup of this player's side
 * of the board
 * 
 * @author	Jacob Radcliffe
 * @version Summer 2016
 */
public class HumanPlayerPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 160606L;

	private JPanel pnlChoice;
	private JComboBox<String> pitChoice;
	
	private HumanPlayer theHuman;
	private Game theGame;

	/**
	 * Creates a new HumanPlayerPanel that observes the specified game. 
	 * 
	 * @param		theGame		the model object from which this panel gets its data
	 * 
	 * @requires 	theGame != null
	 * @ensures		theGame.countObservers() = theGame.countObservers()@prev + 1
	 */
	public HumanPlayerPanel(Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		
		this.theGame = theGame;
		this.theGame.addObserver(this);
		this.theHuman = this.theGame.getHumanPlayer();
		
		this.buildPanel();
	}
	
	private void buildPanel() {
		this.setBorder(BorderFactory.createTitledBorder(this.theHuman.getName()));
		this.setPreferredSize(new Dimension(250, 100));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.createUserInteractionArea();

		this.add(Box.createRigidArea(new Dimension(30, 0)));	
		
		for (int index = 0; index < HumanPlayerPanel.this.theGame.getBoardSize() / 2 - 1; index++) {
			this.add(new PitPanel(index, false, this.theGame));
			this.add(Box.createRigidArea(new Dimension(40, 0)));
		}
		
		this.add(Box.createHorizontalGlue());
		this.add(new PitPanel(3, true, this.theGame));
		this.add(Box.createRigidArea(new Dimension(30, 0)));
	}

	private void createUserInteractionArea() {
		this.pnlChoice = new JPanel();
		this.pnlChoice.setPreferredSize(new Dimension(80, 50));
		this.pnlChoice.setBackground(Color.RED);
		
		String[] choices = new String[this.theGame.getBoardSize() / 2];
		choices[0] = "Please select";
		for (int index = 1; index < this.theGame.getBoardSize() / 2; index++) {
			choices[index] = "" + (index - 1);
			
		}
		this.pitChoice = new JComboBox<String>(choices);
		this.pitChoice.setEnabled(false);
		this.pnlChoice.add(this.pitChoice);
		
		JButton btnTakeTurn = new JButton("Take Turn");
		btnTakeTurn.setEnabled(false);
		btnTakeTurn.addActionListener(new TakeTurnListener());
		this.pnlChoice.add(btnTakeTurn);
		
		this.add(this.pnlChoice);
	}

	/** 
	 * Sets whether or not this panel and its components are enabled.
	 * 
	 * @param	enabled		true if this component should be enabled, false otherwise	
	 * @see		javax.swing.JComponent#setEnabled(boolean)
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
	 * Sets this Panel's combo box to the correct list of numbers and 
	 * enables or disables this Panel and it components. Called when the 
	 * observed Game object notifies this Panel that a Player took a turn. 
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
		this.setEnabled(HumanPlayerPanel.this.theHuman.getIsMyTurn());
		
		if (this.theGame.getIsGameOver()) {
			this.setEnabled(false);
		}
	}	
	
	/* 
	 * Defines the listener for rollButton.
	 */
	private class TakeTurnListener implements ActionListener {
		/* 
		 * Tells the Game to have its current player (i.e., the human Player)
		 * take its turn.	
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {		
			if (!HumanPlayerPanel.this.theGame.getIsGameOver()
					&& this.isValidPit()) {
				int pitChoice = HumanPlayerPanel.this.pitChoice.getSelectedIndex() - 1;
				HumanPlayerPanel.this.pitChoice.setSelectedIndex(0);
				HumanPlayerPanel.this.theGame.play(pitChoice);
			} 
		}

		private boolean isValidPit() {
			// TODO: Check to be sure that the user selected a valid pit
			//		 (one that has a pit number with stones inside)
			//		 If it is an invalid pit, show a JOptionPane's message box
			//		 to offer a descriptive error message so that they'll
			//		 know what went wrong and how to fix it

			return true;
		}
	}
}
