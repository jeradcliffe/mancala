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
 * ALL GAME BOARDS SIZE 12
 * 
 * @author Jacob Radcliffe
 * @version 7/13/16
 */
public class AdvancedStrategyTryToSelectPitToEndInStoreBoardSize12 {
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
	 * Test for the situation where you have:
	 * Closest Pit: 1
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 0
	 * Fifth Closest Pit: 0
	 * 
	 * Should pick closest pit to store.
	 */
	@Test
	public void testReturnClosestPitToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0};
		assertEquals(10, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 0
	 * Fifth Closest Pit: 0
	 * 
	 * Should pick second closest pit to store.
	 */
	@Test
	public void testReturnSecondClosestToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0};
		assertEquals(9, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 0
	 * Fifth Closest Pit: 0
	 * 
	 * Should pick third closest pit to store.
	 */
	@Test
	public void testReturnThirdClosestToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 4
	 * Fifth Closest Pit: 0
	 * 
	 * Should pick fourth closest pit to store.
	 */
	@Test
	public void testReturnFourthClosestToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 0
	 * Fifth Closest Pit: 5
	 * 
	 * Should pick fifth closest pit to store.
	 */
	@Test
	public void testReturnFifthClosestToStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
//Waterfall tests (i.e. for each step further away from store, add one stone)
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 1
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 4
	 * Fifth Closest Pit: 5
	 * 
	 * Should pick closest pit to store.
	 */
	@Test
	public void testReturnClosestPitWhenAllCouldGetReachStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 5, 4, 3, 2, 1, 0};
		assertEquals(10, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 4
	 * Fifth Closest Pit: 5
	 * 
	 * Should pick second closest pit to store.
	 */
	@Test
	public void testReturnSecondClosestPitWhenAllCouldGetReachStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 5, 4, 3, 2, 0, 0};
		assertEquals(9, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 4
	 * Fifth Closest Pit: 5
	 * 
	 * Should pick third closest pit to store.
	 */
	@Test
	public void testReturnThirdClosestPitWhenAllCouldGetReachStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 5, 4, 3, 0, 0, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 0
	 * Second Closest Pit: 0 
	 * Third Closest Pit: 0
	 * Fourth Closest Pit: 4
	 * Fifth Closest Pit: 5
	 * 
	 * Should pick fourth closest pit to store.
	 */
	@Test
	public void testReturnFourthClosestPitWhenAllCouldGetReachStore() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 5, 4, 0, 0, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
//Methods to test equal amounts of stones in each pit
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 1
	 * Second Closest Pit: 1 
	 * Third Closest Pit: 1
	 * Fourth Closest Pit: 1
	 * Fifth Closest Pit: 1
	 * 
	 * Should pick closest pit to store.
	 */
	@Test
	public void testReturnClosestPitWhenAllPitsHave1() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0};
		assertEquals(10, this.theStrategy.selectPit(theBoard));
	}

	/**
	 * Test for the situation where you have:
	 * Closest Pit: 2
	 * Second Closest Pit: 2 
	 * Third Closest Pit: 2
	 * Fourth Closest Pit: 2
	 * Fifth Closest Pit: 2
	 * 
	 * Should pick second closest pit to store.
	 */
	@Test
	public void testReturnSecondClosestPitWhenAllPitsHave2() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0};
		assertEquals(9, this.theStrategy.selectPit(theBoard));
	}

	/**
	 * Test for the situation where you have:
	 * Closest Pit: 3
	 * Second Closest Pit: 3 
	 * Third Closest Pit: 3
	 * Fourth Closest Pit: 3
	 * Fifth Closest Pit: 3
	 * 
	 * Should pick third closest pit to store.
	 */
	@Test
	public void testReturnThirdClosestPitWhenAllPitsHave3() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 4
	 * Second Closest Pit: 4 
	 * Third Closest Pit: 4
	 * Fourth Closest Pit: 4
	 * Fifth Closest Pit: 4
	 * 
	 * Should pick fourth closest pit to store.
	 */
	@Test
	public void testReturnFourthClosestPitWhenAllPitsHave4() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Test for the situation where you have:
	 * Closest Pit: 5
	 * Second Closest Pit: 5 
	 * Third Closest Pit: 5
	 * Fourth Closest Pit: 5
	 * Fifth Closest Pit: 5
	 * 
	 * Should pick fifth closest pit to store.
	 */
	@Test
	public void testReturnFifthClosestPitWhenAllPitsHave5() {
		int[] theBoard = {0, 0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
}
