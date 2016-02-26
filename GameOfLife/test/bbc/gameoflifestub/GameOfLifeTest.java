package bbc.gameoflifestub;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
	
	private GameOfLife testGameOfLife;
	HashSet<Cell> currentSetOfCells;
	Life currentLife;
	
	@Before
	public void setUp(){
		testGameOfLife = new GameOfLife(10);
		testGameOfLife.setHeight(200);
		testGameOfLife.setWidth(100);
		
		currentSetOfCells = new HashSet<Cell>();
		currentSetOfCells.add(new Cell(1,1));
		currentSetOfCells.add(new Cell(2,2));
        currentLife = new Life(currentSetOfCells);
        
        testGameOfLife.setCurrentLife(currentLife);
    }
	
	@Test
	public void testGetCurrentLife(){
		assertEquals(currentLife, testGameOfLife.getCurrentLife());
	}

	@Test
	public void testSetCurrentLife() {
		assertEquals(currentLife, testGameOfLife.getCurrentLife());
	}

	@Test
	public void testGetWidth() {
		assertEquals(100, testGameOfLife.getWidth());
	}

	@Test
	public void testSetWidth() {
		assertEquals(100, testGameOfLife.getWidth());
		testGameOfLife.setWidth(500);
		assertEquals(500, testGameOfLife.getWidth());
		
		try {
			testGameOfLife.setWidth(-100);
		    fail("Should throw IllegalArgumentException for non-postive number.");
		} catch (IllegalArgumentException expectedException) {
		}
	}

	@Test
	public void testGetHeight() {
		assertEquals(200, testGameOfLife.getHeight());
	}

	@Test
	public void testSetHeight() {
		assertEquals(200, testGameOfLife.getHeight());
		testGameOfLife.setHeight(1000);
		assertEquals(1000, testGameOfLife.getHeight());
		
		try {
			testGameOfLife.setHeight(-100);
		    fail("Should throw IllegalArgumentException for non-postive number.");
		} catch (IllegalArgumentException expectedException) {
		}		
	}
	
	@Test
	public void testSetInitailLife() {
		testGameOfLife.setInitailLife("*.\n.*");
		assertEquals(currentLife, testGameOfLife.getCurrentLife());
	}
	
	@Test
	public void testGetMaxGenerations() {
		assertEquals(10, testGameOfLife.getMaxGenerations());
	}

	@Test
	public void testSetMaxGenerations() {
		assertEquals(10, testGameOfLife.getMaxGenerations());
		testGameOfLife.setMaxGenerations(100);
		assertEquals(100, testGameOfLife.getMaxGenerations());
		
		try {
			testGameOfLife.setMaxGenerations(-100);
		    fail("Should throw IllegalArgumentException for non-postive number.");
		} catch (IllegalArgumentException expectedException) {
		}		
	}
	
	@Test
	public void testRunning(){
		// start of running test 1
		GameOfLife testRunningGame = new GameOfLife(3);
		testRunningGame.setInitailLife(".*.\n**.\n...");
		testRunningGame.setUpNextGeneration();
		
		HashSet<Cell> setOfCells = new HashSet<Cell>();
    	setOfCells.add(new Cell(1,1));
    	setOfCells.add(new Cell(1,2));
    	setOfCells.add(new Cell(2,1));
    	setOfCells.add(new Cell(2,2));
        Life life = new Life(setOfCells);
        
        assertEquals(life, testRunningGame.getCurrentLife());
        
        testRunningGame.setUpNextGeneration();
        
        assertEquals(life, testRunningGame.getCurrentLife());
		// end of running test 1
        
		// start of running test 2
        testRunningGame = new GameOfLife(3);
		testRunningGame.setInitailLife("...\n...\n...");
		testRunningGame.setUpNextGeneration();
		
		setOfCells = new HashSet<Cell>();
        life = new Life(setOfCells);
        
        assertEquals(life, testRunningGame.getCurrentLife());
        
        testRunningGame.setUpNextGeneration();
        
        assertEquals(life, testRunningGame.getCurrentLife());
		// end of running test 2
        
		// start of running test 3
        testRunningGame = new GameOfLife(3);
		testRunningGame.setInitailLife(".*.\n..*\n.*.");
		testRunningGame.setUpNextGeneration();
		
		setOfCells = new HashSet<Cell>();
		setOfCells.add(new Cell(2,2));
		setOfCells.add(new Cell(3,2));
        life = new Life(setOfCells);
        
        assertEquals(life, testRunningGame.getCurrentLife());
        
        testRunningGame.setUpNextGeneration();
        
        setOfCells = new HashSet<Cell>();
        life = new Life(setOfCells);
        
        assertEquals(life, testRunningGame.getCurrentLife());
		// end of running test 3
        
		// start of running test 4
        testRunningGame = new GameOfLife(3);
		testRunningGame.setInitailLife(".*.\n*.*\n.*.");
		testRunningGame.setUpNextGeneration();
		
		setOfCells = new HashSet<Cell>();
		setOfCells.add(new Cell(1,2));
		setOfCells.add(new Cell(2,1));
		setOfCells.add(new Cell(2,3));
		setOfCells.add(new Cell(3,2));
        life = new Life(setOfCells);
        
        assertEquals(life, testRunningGame.getCurrentLife());
        
        testRunningGame.setUpNextGeneration();
        
        setOfCells = new HashSet<Cell>();
		setOfCells.add(new Cell(1,2));
		setOfCells.add(new Cell(2,1));
		setOfCells.add(new Cell(2,3));
		setOfCells.add(new Cell(3,2));
        life = new Life(setOfCells);
        
        assertEquals(life, testRunningGame.getCurrentLife());
		// end of running test 4
	}
}
