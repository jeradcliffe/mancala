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
public class AdvancedStrategyTryToStealHumanStonesFromBoardSize8 {
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

//CPU plays pit 6	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 7 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas7StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 0, 0, 0, 0, 0, 7, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 7 stones in pit 6
	 * 				1 stone  in pit 4
	 */
	@Test
	public void testComputerReturnsPit6WhenHas7StonesAnd4Has1GettingHumanStonesPit0() {
		int[] theBoard = {1, 1, 1, 0, 1, 0, 7, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 6 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas6StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 1, 0, 0, 0, 0, 6, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 6 stones in pit 6
	 * Computer has 1 stone in pit 4
	 */
	@Test
	public void testComputerReturnsPit6WhenHas6And1InPit4StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 1, 0, 0, 1, 0, 6, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}	
	
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 5 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit6WhenHas5StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 0, 1, 0, 0, 0, 5, 0};
		assertEquals(6, this.theStrategy.selectPit(theBoard));
	}
	
	
//CPS plays pit 5
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 7 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas7StonesGettingHumanStonesPit1() {
		int[] theBoard = {0, 1, 0, 0, 0, 7, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 7 stones in pit 5
	 * 				2 stones in pit 4
	 */
	@Test
	public void testComputerReturnsPit5WhenHas7StonesIn5And2In4GettingHumanStonesPit1() {
		int[] theBoard = {1, 1, 0, 0, 2, 7, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 6 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas6StonesGettingHumanStonesPit0() {
		
		
		int[] theBoard = {0, 0, 1, 0, 0, 6, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}

	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 1 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit5WhenHas1StonesGettingHumanStonesPit2() {
		int[] theBoard = {1, 0, 0, 0, 0, 1, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 1 stones in pit 5
	 * Computer has 2 stones in pit 4
	 */
	@Test
	public void testComputerReturnsPit5WhenHas1StonesIn5And2In4GettingHumanStonesPit2() {
		int[] theBoard = {1, 0, 0, 0, 2, 1, 0, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 6 stones in pit 5
	 * 				2 stones in pit 6
	 */
	@Test
	public void testComputerReturnsPit5WhenHas6StonesIn5And2In6GettingHumanStonesPit1() {
		int[] theBoard = {1, 1, 1, 0, 0, 6, 2, 0};
		assertEquals(5, this.theStrategy.selectPit(theBoard));
	}
	
//CPU plays pit 4
	/**
	 * Human has 1 stone in pit 2
	 * 
	 * Computer has 7 stones in pit 4
	 */
	@Test
	public void testComputerReturnsPit4WhenHas7StonesGettingHumanStonesPit2() {
		int[] theBoard = {0, 0, 1, 0, 7, 0, 0, 0};
		assertEquals(4, this.theStrategy.selectPit(theBoard));
	}

	/**
	 * Human has 1 stone in pit 1
	 * 
	 * Computer has 1 stones in pit 4
	 */
	@Test
	public void testComputerReturnsPit4WhenHas1StonesGettingHumanStonesPit1() {
		int[] theBoard = {0, 1, 0, 0, 1, 0, 0, 0};
		assertEquals(4, this.theStrategy.selectPit(theBoard));
	}
	

	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 2 stones in pit 4
	 */
	@Test
	public void testComputerReturnsPit4WhenHas2StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 0, 0, 0, 2, 0, 0, 0};
		assertEquals(4, this.theStrategy.selectPit(theBoard));
	}
	
	/**
	 * Human has 1 stone in pit 0
	 * 
	 * Computer has 2 stones in pit 4
	 * 				6 stones in pit 5
	 */
	@Test
	public void testComputerReturnsPit4WhenHas2StonesAnd5Has6StonesGettingHumanStonesPit0() {
		int[] theBoard = {1, 1, 1, 0, 2, 6, 0, 0};
		assertEquals(4, this.theStrategy.selectPit(theBoard));
	}
	

}
