package edu.westga.cs6910.mancala.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.westga.cs6910.mancala.model.Game;

/**
 * Defines the panel that displays a pit with its stones
 * 
 * @author	CS6910
 * @version Summer 2016
 */
public class PitPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 160606L;
	
	private JLabel lblPitNumber;
	private JLabel lblNumberOfStones;
	
	private int pitNumber;
	private Game theGame;
	
	/**
	 * Sets up the PitPanel for use
	 * 
	 * @param pitNumber	The number identifying this pit
	 * @param isStore	true if this pit is a store; false otherwise
	 * @param theGame	The Game object that this pit is representing
	 */
	public PitPanel(int pitNumber, boolean isStore, Game theGame) {
		if (pitNumber < 0) {
			throw new IllegalArgumentException("Pit Number cannot be negative");
		}
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		this.pitNumber = pitNumber;
		this.theGame = theGame;
		this.theGame.addObserver(this);
		this.buildPanel(isStore);
	}

	private void buildPanel(boolean isStore) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(100, 100));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		if (isStore) {
			this.lblPitNumber = new JLabel("Store: " + this.pitNumber);
			this.setBackground(Color.LIGHT_GRAY);
		} else {
			this.lblPitNumber = new JLabel("Pit: " + this.pitNumber);
		}
		this.add(this.lblPitNumber);
		
		this.lblNumberOfStones = new JLabel("Stones: 0");
		this.add(this.lblNumberOfStones);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO: Display the current number of stones inside
		//		 this pit
		this.lblNumberOfStones.setText("Stones: " + this.theGame.getStones(this.pitNumber));
	}
}
