package edu.westga.cs6910.mancala.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.glass.events.KeyEvent;
import java.io.File;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.model.Player;
import edu.westga.cs6910.mancala.model.strategies.AdvancedStrategy;
import edu.westga.cs6910.mancala.model.strategies.CloseStrategy;
import edu.westga.cs6910.mancala.model.strategies.FarStrategy;
import edu.westga.cs6910.mancala.model.strategies.RandomStrategy;

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
		this.buildMenuBar();

		this.theFrame.setMinimumSize(new Dimension(800, 200));
		this.theFrame.pack();
		this.theFrame.setLocationRelativeTo(null);
		this.theFrame.setVisible(true);
		this.theFrame.setResizable(false);
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
	}

//////////////////MenuBar Build////////////////////////////////////////////
	/**
	 * Builds the menu bar for our GUI:
	 * 1)File > Exit
	 * 2)Settings > Computer Player > 3 Strategies
	 */
	private void buildMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		menuBar.add(this.buildFileMenu());
		menuBar.add(this.buildSettingsMenu());
		menuBar.add(this.buildHelpMenu());
		
		this.theFrame.setJMenuBar(menuBar);
	}

///////////////////////////Builds the File Menu/////////////////////////////
	/**
	 * Builds a File menu with an exit option
	 */
	private JMenu buildFileMenu() {
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		file.add(this.buildNewGameItem());
		file.add(this.buildExitItem());
		return file;
	}
	
	/**
	 * Builds the New Game option for the File menu
	 */
	private JMenuItem buildNewGameItem() {
		JMenuItem newGameItem = new JMenuItem("New Game");
		
		newGameItem.setMnemonic(KeyEvent.VK_N);
		
		newGameItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_N, ActionEvent.ALT_MASK));
		
		newGameItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Gui.this.theFrame.setVisible(false);
						new Gui(new Game());
					}
				});
			}
		});
		return newGameItem;
	}	
	
	/**
	 * Builds the Exit option of the File menu
	 */
	private JMenuItem buildExitItem() {
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setMnemonic(KeyEvent.VK_X);
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_X, ActionEvent.ALT_MASK));
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		return exitMenuItem;
	}
	


/////////////////////////Builds the Settings Menu/////////////////////////////////
	/**
	 * Builds a Settings menu for menu bar with:
	 * 
	 * -Computer Player option opens up a pop up menu with:
	 * 		1)Close (closest seed to store moves)
	 * 		2)Far (farthest seed from store moves)
	 * 		3)Random (randomly picks a seed to move)
	 * 
	 */
	private JMenu buildSettingsMenu() {
		JMenu settings = new JMenu("Settings");
		settings.setMnemonic(KeyEvent.VK_S);
		
		JMenu computerPlayerSubmenu = new JMenu("Computer Player");
		computerPlayerSubmenu.setMnemonic(KeyEvent.VK_P);
		
		settings.add(computerPlayerSubmenu);
		computerPlayerSubmenu.add(this.buildCloseItem());
		computerPlayerSubmenu.add(this.buildFarItem());
		computerPlayerSubmenu.add(this.buildRandomItem());
		computerPlayerSubmenu.add(this.buildAdvancedItem());
		
		return settings;
	}


//////////////All of our strategies for the Settings Menu////////////////////////////
	/**
	 * Builds our close item for our menu
	 * 
	 * @return closeItem	JMenuItem for CloseStrategy
	 */
	private JMenuItem buildCloseItem() {
		JMenuItem closeItem = new JMenuItem("Close");
		
		closeItem.setMnemonic(KeyEvent.VK_C);
		
		closeItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.ALT_MASK));
		closeItem.setToolTipText("Computer always picks closest pit.");
		closeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gui.this.theGame.getComputerPlayer().setStrategy(new CloseStrategy());
			}
		});	
		return closeItem;
	}
	
	/**
	 * Builds our far item for our menu
	 * 
	 * @return farItem	JMenuItem for FarStrategy
	 */
	private JMenuItem buildFarItem() {
		JMenuItem farItem = new JMenuItem("Far");
		
		farItem.setMnemonic(KeyEvent.VK_A);
		
		farItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_A, ActionEvent.ALT_MASK));
		farItem.setToolTipText("Computer always picks farthest pit.");
		farItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gui.this.theGame.getComputerPlayer().setStrategy(new FarStrategy());
			}
		});	
		return farItem;
	}
	
	/**
	 * Builds our random item for our menu
	 * 
	 * @return randomItem	JMenuItem that allows computer
	 * 						to use random strategy
	 */
	private JMenuItem buildRandomItem() {
		JMenuItem randomItem = new JMenuItem("Random");
		
		randomItem.setMnemonic(KeyEvent.VK_R);
		
		randomItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_R, ActionEvent.ALT_MASK));
		randomItem.setToolTipText("Computer always picks random pit.");
		randomItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gui.this.theGame.getComputerPlayer().setStrategy(new RandomStrategy());
			}
		});
		
		return randomItem;
	}
	
	/**
	 * Builds our advanced item for our menu
	 * 
	 * @return advanced		JMenuItem that allows computer
	 * 						to use advanced strategy
	 */
	private JMenuItem buildAdvancedItem() {
		JMenuItem advancedItem = new JMenuItem("Advanced");
		
		advancedItem.setMnemonic(KeyEvent.VK_D);
		
		advancedItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_D, ActionEvent.ALT_MASK));
		advancedItem.setToolTipText("Computer always picks best possible pit.");
		advancedItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Gui.this.theGame.getComputerPlayer().setStrategy(new AdvancedStrategy());
			}
		});
		
		return advancedItem;
	}

/////////////////////////Builds the help menu/////////////////////////////////////////
	/**
	 * Builds a help menu to add to our menu bar
	 * 
	 * @return helpMenu	JMenuItem that allows us to 
	 * 					go to the Mancala website that 
	 * 					will tell our users how to play 
	 * 					the app.
	 */
	private JMenuItem buildHelpMenu() {
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		JMenuItem howToPlay = new JMenuItem("How To Play");
		howToPlay.setMnemonic(KeyEvent.VK_I);
		howToPlay.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_I, ActionEvent.ALT_MASK));
		howToPlay.setToolTipText("Help page opens in default browser.");
		howToPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					File htmlFile = new File("MancalaWeb/appPage.html");
				    Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Website not found.", "404 Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		helpMenu.add(howToPlay);
		return helpMenu;
	}

///////////////////////NewGamePanel Class Implementation////////////////////////////////

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
			
			this.radComputerPlayer = new JRadioButton("Computer first");
			this.radComputerPlayer.addActionListener(new ComputerFirstListener());
			
			ButtonGroup group = new ButtonGroup();
			group.add(this.radHumanPlayer);
			group.add(this.radComputerPlayer);
	
			this.add(this.radComputerPlayer);			
			this.add(this.radHumanPlayer);
		}
		
		/* 
		 * Defines the listener for cyberPlayerButton.
		 */		
		private class ComputerFirstListener implements ActionListener {
			
			/** 
			 * Enables the CyberPlayerPanel and starts a new game. 
			 * Event handler for a click in the cyberPlayerButton.
			 */
			@Override
			public void actionPerformed(ActionEvent eventObject) {
				NewGamePanel.this.theComputer.setIsMyTurn(true);
				NewGamePanel.this.theHuman.setIsMyTurn(false);	
				
			    try {
					String[] seedOptions = { "1", "2", "3", "4"};
					String input = (String) JOptionPane.showInputDialog(null, "Choose number of seeds per pit.",
					    "Seed selection", JOptionPane.QUESTION_MESSAGE, null, seedOptions, seedOptions[0]); 
					if (input == null) {
						input = "1";
					}
					int seedsPerPit = Integer.parseInt(input);
					Gui.this.pnlComputerPlayer.setEnabled(true);
					Gui.this.theGame.startNewGame(NewGamePanel.this.theComputer, NewGamePanel.this.theHuman, seedsPerPit);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
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
				NewGamePanel.this.theHuman.setIsMyTurn(true);
				NewGamePanel.this.theComputer.setIsMyTurn(false);
				
			    try {
					String[] seedOptions = { "1", "2", "3", "4"};
					String input = (String) JOptionPane.showInputDialog(null, "Choose number of seeds per pit.",
					    "Seed selection", JOptionPane.QUESTION_MESSAGE, null, seedOptions, seedOptions[0]); 
					if (input == null) {
						input = "1";
					}
					int seedsPerPit = Integer.parseInt(input);
					Gui.this.pnlHumanPlayer.setEnabled(true);
					Gui.this.theGame.startNewGame(NewGamePanel.this.theHuman, NewGamePanel.this.theComputer, seedsPerPit);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			    
				NewGamePanel.this.radHumanPlayer.setEnabled(false);
			    NewGamePanel.this.radComputerPlayer.setEnabled(false);
			}
		}
	}
}
