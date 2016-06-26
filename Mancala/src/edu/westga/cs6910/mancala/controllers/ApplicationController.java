package edu.westga.cs6910.mancala.controllers;

import edu.westga.cs6910.mancala.model.Game;
import edu.westga.cs6910.mancala.view.Gui;

/**
 * Driver for the application. Creates the GUI in its
 * own thread and shows it.
 * 
 * @author CS6910
 * @version Summer 2016
 */
public class ApplicationController {

	/**
	 * Creates the game and the players, and runs the GUI in its
	 * own thread so it can run independently.
	 * 
	 * @param args	not used
	 * 
	 * @ensures The GUI is visible and running
	 */
	public static void main(String[] args) {		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Gui(new Game());
			}
		});
	}
}
