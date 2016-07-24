package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.cs6910.mancala.model.strategies.AdvancedStrategy;

/**
 * This is a test class to test our method that will 
 * allow our computer player to select the pit which 
 * will result in their last stone being placed in
 * the store on their side.
 * 
 * ALL GAME BOARDS SIZE 10
 * 
 * @author Jacob Radcliffe
 * @version 7/13/16
 */
public class AdvancedStrategyTryToSelectPitToEndInStoreBoardSize10 {
	private AdvancedStrategy theStrategy;
	
	/**
	 * Initializes our strategy so that each method will
	 * use the same object during testing.
	 * 
	 * @throws java.lang.Exception if unable to construct
	 * 		   a strategy
	 */
	@Before
	public void setUp() throws Exception {
		this.theStrategy = new AdvancedStrategy();
	}

//Tests for isolating the correct number of stones needed in individual pit
	/**
	 * Test for the situation where only the pit
	 *  closest to the store has a stone
	 */
	@Test
	public void testShouldReturnClosestPit() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have 2 stones
	 * two pits from the store, and no other stones on
	 * the board.
	 */
	@Test
	public void testShouldReturnPitTwoAwayFromStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 2, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 0
	 * 
	 * Should pick third closest pit to store.
	 */
	@Test
	public void testReturnThirdClosestToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 3, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 4
	 * 
	 * Should pick third closest pit to store.
	 */
	@Test
	public void testReturnFourthClosestToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 4, 0, 0, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
//Waterfall tests (i.e. for each step further away from store, add one stone)
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 1
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 0
	 * 
	 * Should pick second closest pit to store.
	 */
	@Test
	public void testReturnFirstPitWhenFirstPit1StoneSecondPit2Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 2, 1, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 0
	 * 
	 * Should pick second closest pit to store.
	 */
	@Test
	public void testReturnSecondClosestPitWhenSecondPit2StonesThirdPit3Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 3, 2, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 4
	 * 
	 * Should pick fourth closest pit to store.
	 */
	@Test
	public void testReturnSecondClosestPitWhenThirdPit3StonesFourthPit4Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 4, 3, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}

	/**
	 * Test for the situation where you have:
	 * Closest Pit: 1
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 4
	 * 
	 * Should pick closest pit to store.
	 */
	@Test
	public void testReturnClosestPitWhenClosest1StoneSecondPit2StonesThirdPit3StonesFourthPit4Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 4, 3, 2, 1, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
//Methods to test equal amounts of stones in each pit
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 1
	 * Second Closest Pit: 1 
	 * Third Closest Pit: 1
	 * Fourth Closest Pit: 1
	 * 
	 * Should pick pit closest to store.
	 */
	@Test
	public void testReturnClosestPitIfAllPitsHave1Stone() {
		int[] theBoard = {0, 0, 0, 0, 0, 1, 1, 1, 1, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 2
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 2
	 * Fourth Closest Pit: 2
	 * 
	 * Should pick pit second closest to store.
	 */
	@Test
	public void testReturnSecondClosestPitIfAllPitsHave2Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 2, 2, 2, 2, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 3
	 * Second Closest Pit: 3 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 3
	 * 
	 * Should pick pit third closest to store.
	 */
	@Test
	public void testReturnThirdClosestPitIfAllPitsHave3Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 3, 3, 3, 3, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 4
	 * Second Closest Pit: 4 
	 * Third Closest Pit: 4
	 * Fourth Closest Pit: 4
	 * 
	 * Should pick pit fourth closest to store.
	 */
	@Test
	public void testReturnSecondClosestPitIfAllPitsHave4Stones() {
		int[] theBoard = {0, 0, 0, 0, 0, 4, 4, 4, 4, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
//Default Close method tests (only used when pit may not be selected due to inability to place last stone in pit)
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 2
	 * Second Closest Pit: 1 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 7
	 * 
	 * Should pick pit closest to store.
	 */
	@Test
	public void testReturnClosestPitIfAllPitsCantFinishInStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 7, 4, 1, 3, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
}