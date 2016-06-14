package edu.westga.cs6910.mancala.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.Player;

/**
 * Defines a GUI for the Pig game.
 *  
 * @author	Jacob Radcliffe
 * @version	Summer 2016
 */
public class Gui {
	private JFrame theFrame;
	private Container contentPane;	
	
	private JPanel pnlHumanPlayer;
	private JPanel pnlComputerPlayer;
	private JPanel pnlGameInfo;
	private JPanel pnlChooseFirstPlayer;
	
	private Game theGame;	
	
	/**
	 * Creates a Gui object to provide the view for the specified
	 * Game model object.
	 * 
	 * @param		theGame		the domain model object representing the Pig game
	 * 
	 * @requires	theGame != null
	 * @ensures		the GUI is displayed
	 */
	public Gui(Game theGame) {
		if (theGame == null) {
			throw new IllegalArgumentException("Invalid Game object");
		}
		
		this.theGame = theGame;
		this.createAndShowGUI();
	}

	private void createAndShowGUI() {
		this.theFrame = new JFrame("Simple Mancala");
		
		this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.theFrame.setLayout(new BorderLayout());
				
		this.contentPane = this.theFrame.getContentPane();
		this.buildContentPane();

		this.theFrame.setMinimumSize(new Dimension(800, 200));
		this.theFrame.pack();
		this.theFrame.setLocationRelativeTo(null);
		this.theFrame.setVisible(true);
	}

	private void buildContentPane() {
		this.pnlChooseFirstPlayer = new NewGamePanel(this.theGame);
		this.contentPane.add(this.pnlChooseFirstPlayer, BorderLayout.WEST);
		
		this.pnlHumanPlayer = new HumanPlayerPanel(this.theGame);
		this.contentPane.add(this.pnlHumanPlayer, BorderLayout.SOUTH);
		this.pnlHumanPlayer.setEnabled(false);
		
		this.pnlGameInfo = new GameStatusPanel(this.theGame);
		this.contentPane.add(this.pnlGameInfo, BorderLayout.CENTER);
		
		this.pnlComputerPlayer = new ComputerPlayerPanel(this.theGame);
		this.contentPane.add(this.pnlComputerPlayer, BorderLayout.NORTH);
		this.pnlComputerPlayer.setEnabled(false);
		
		// TODO: 1. Instantiate this.pnlHumanPlayer, add it to
		//			the content pane at the bottom, and disable it.	
		//		 2. Instantiate this.pnlGameInfo and add it to
		//			the content pane in the middle.		
		//		 3. Instantiate this.pnlComputerPlayer, add it to
		//			the content pane at the top, and disable it.	

	}

	/*
	 * Defines the panel in which the user selects which Player plays first.
	 */
	private final class NewGamePanel extends JPanel {
		private static final long serialVersionUID = 140604L;
		
		private JRadioButton radHumanPlayer;
		private JRadioButton radComputerPlayer;
		
		private Game theGame;
		private Player theHuman;
		private Player theComputer;

		private NewGamePanel(Game theGame) {
			if (theGame == null) {
				throw new IllegalArgumentException("Invalid Game object");
			}
			
			this.theGame = theGame;
			
			this.theHuman = this.theGame.getHumanPlayer();
			this.theComputer = this.theGame.getComputerPlayer();		
			
			this.buildPanel();
		}
		
		private void buildPanel() {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setPreferredSize(new Dimension(200, 75));
			this.setBorder(BorderFactory.createTitledBorder("Select first player"));	
			
			this.radHumanPlayer = new JRadioButton("Human first");	
			this.radHumanPlayer.addActionListener(new HumanFirstListener());
			
			// TODO: Instantiate this.radComputerPlayer and add 
			//		 ComputerFirstListener as its action listener.
			this.radComputerPlayer = new JRadioButton("Computer first");
			this.radComputerPlayer.addActionListener(new ComputerFirstListener());
			
			// TODO: Create a ButtonGroup and add the 2 radio buttons to it.
			ButtonGroup group = new ButtonGroup();
			group.add(this.radHumanPlayer);
			group.add(this.radComputerPlayer);
	
			// TODO: Add the 2 radio buttons to this panel.
			this.add(this.radComputerPlayer);			
			this.add(this.radHumanPlayer);
		}
		
		/* 
		 * Defines the listener for cyberPlayerButton.
		 */		
		private class ComputerFirstListener implements ActionListener {
			
			@Override
			/** 
			 * Enables the CyberPlayerPanel and starts a new game. 
			 * Event handler for a click in the cyberPlayerButton.
			 */
			
			public void actionPerformed(ActionEvent eventObject) {
				NewGamePanel.this.theComputer.setIsMyTurn(true);
				NewGamePanel.this.theHuman.setIsMyTurn(false);	
				Gui.this.pnlComputerPlayer.setEnabled(true);
				Gui.this.theGame.startNewGame(NewGamePanel.this.theComputer, NewGamePanel.this.theHuman);
				
				NewGamePanel.this.radHumanPlayer.setEnabled(false);
				NewGamePanel.this.radComputerPlayer.setEnabled(false);
			}
		}

		
		/* 
		 * Defines the listener for humanPlayerButton.
		 */	
		private class HumanFirstListener implements ActionListener {

			/* 
			 * Event handler for a click in the radHumanPlayer.			 
			 * Enables the HumanPlayerPanel and starts a new game. 
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO: Set the player objects so the human is noted as playing
				//		 and the computer is not.				
				// 		Enable pnlHumanPlayer and start a game
				//		with theHuman as the first player.
				NewGamePanel.this.theHuman.setIsMyTurn(true);
				NewGamePanel.this.theComputer.setIsMyTurn(false);
				Gui.this.pnlHumanPlayer.setEnabled(true);
				Gui.this.theGame.startNewGame(NewGamePanel.this.theHuman, NewGamePanel.this.theComputer);
				
				NewGamePanel.this.radHumanPlayer.setEnabled(false);
				NewGamePanel.this.radComputerPlayer.setEnabled(false);
			}
		}
	}
}
