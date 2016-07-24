package edu.westga.cs6910.mancala.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.westga.cs6910.mancala.model.strategies.AdvancedStrategy;

/**
 * This test class will help the computer player select the
 * right pit to play in the case it wants to steal its 
 * opponent's (the human's) stones. 
 * 
 * @author Jacob Radcliffe
 * @version 7/14/16
 */
public class AdvancedStrategyTryToStealHumanStonesFromBoardSize10 {
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

	
//CPU plays 8	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 9 stones in pit 8
	 */
	@Test
	public void testComputerReturnsPit8WhenHas9StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 0, 0, 0, 0, 0, 0, 0, 9, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 8 stones in pit 8
	 */
	@Test
	public void testComputerReturnsPit8WhenHas8StonesGettingHumanStonesPit1() {
		int[] theBoard = {0, 1, 0, 0, 0, 0, 0, 0, 8, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 7 stones in pit 8
	 */
	@Test
	public void testComputerReturnsPit8WhenHas7StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 0, 1, 0, 0, 0, 0, 0, 7, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 3
	 * 
	 * Computer has 6 stones in pit 8
	 */
	@Test
	public void testComputerReturnsPit8WhenHas6StonesGettingHumanStonesPit3() {
		int[] theBoard = {0, 0, 0, 1, 0, 0, 0, 0, 6, 0};
		assertEquals(8, this.theStrategy.selectPit(theBoard));
	}
	
//CPU plays 7
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 9 stones in pit 7
	 */
	@Test
	public void testComputerReturnsPit7WhenHas9StonesGettingHumanStonesPit1() {
		int[] theBoard = {0, 1, 0, 0, 0, 0, 0, 9, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 8 stones in pit 7
	 */
	@Test
	public void testComputerReturnsPit7WhenHas8StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 0, 1, 0, 0, 0, 0, 8, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 3
	 * 
	 * Computer has 7 stones in pit 7
	 */
	@Test
	public void testComputerReturnsPit7WhenHas7StonesGettingHumanStonesPit3() {
		int[] theBoard = {0, 0, 0, 1, 0, 0, 0, 7, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 1 stones in pit 7
	 */
	@Test
	public void testComputerReturnsPit7WhenHas1StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 0, 0, 0, 0, 0, 0, 1, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}

//CPU plays 6
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 9 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas9StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 0, 1, 0, 0, 0, 9, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 3
	 * 
	 * Computer has 8 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas8StonesGettingHumanStonesPit3() {
		int[] theBoard = {0, 0, 0, 1, 0, 0, 8, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 2 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas2StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 0, 0, 0, 0, 0, 2, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 1 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas1StonesGettingHumanStonesPit1() {
		int[] theBoard = {0, 1, 0, 0, 0, 0, 1, 0, 0, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
//CPU plays 5
	/**
	 * Human has 1 stone in pit 3
	 * 
	 * Computer has 9 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas9StonesGettingHumanStonesPit3() {
		int[] theBoard = {1, 1, 1, 1, 0, 9, 0, 0, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in all pits
	 * 
	 * Computer has 9 stones in pit 5
	 * 				4 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit5WhenHas9StonesAnd4In6GettingHumanStonesPit3() {
		int[] theBoard = {1, 1, 1, 1, 0, 9, 4, 0, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in all pits
	 * 
	 * Computer has 9 stones in pit 5
	 * 			    7 stones in pit 7
	 */
	@Test
	public void testComputerReturnsPit5WhenHas9StonesAnd7In7GettingHumanStonesPit3() {
		int[] theBoard = {1, 1, 1, 1, 0, 9, 0, 7, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in all pits
	 * 
	 * Computer has 9 stones in pit 5
	 * 			    1 stone  in pit 7
	 */
	@Test
	public void testComputerReturnsPit5WhenHas9StonesAnd1In7GettingHumanStonesPit3() {
		int[] theBoard = {1, 1, 1, 1, 0, 9, 0, 1, 0, 0};
		assertEquals(7, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 3 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas3StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 1, 1, 1, 0, 3, 0, 0, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 2 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas2StonesGettingHumanStonesPit1() {
		int[] theBoard = {1, 1, 1, 1, 0, 2, 0, 0, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 1 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas1StonesGettingHumanStonesPit2() {
		int[] theBoard = {1, 1, 1, 1, 0, 1, 0, 0, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
}
