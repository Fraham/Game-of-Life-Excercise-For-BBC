package bbc.gameoflifestub;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
	
	private GameOfLife testGameOfLife;
	HashSet<Cell> currentSetOfCells;
	HashSet<Cell> nextSetOfCells;
	Life currentLife;
	Life nextLife;
	
	@Before
	public void setUp(){
		testGameOfLife = new GameOfLife();
		testGameOfLife.setHeight(200);
		testGameOfLife.setWidth(100);
		
		currentSetOfCells = new HashSet<Cell>();
		currentSetOfCells.add(new Cell(1,1));
		currentSetOfCells.add(new Cell(2,2));
        currentLife = new Life(currentSetOfCells);
        
        nextSetOfCells = new HashSet<Cell>();
        nextSetOfCells.add(new Cell(2,1));
        nextSetOfCells.add(new Cell(1,2));
        nextLife = new Life(nextSetOfCells);
        
        testGameOfLife.setCurrentLife(currentLife);
        testGameOfLife.setNextLife(nextLife);
    }
	
	@Test
	public void testGetCurrentLife(){
		assertEquals(currentLife, testGameOfLife.getCurrentLife());
		assertNotSame(nextLife, testGameOfLife.getCurrentLife());
	}

	@Test
	public void testSetCurrentLife() {
		assertEquals(currentLife, testGameOfLife.getCurrentLife());
		testGameOfLife.setCurrentLife(nextLife);
		assertEquals(nextLife, testGameOfLife.getCurrentLife());
	}

	@Test
	public void testGetNextLife() {
		assertEquals(nextLife, testGameOfLife.getNextLife());
		assertNotSame(currentLife, testGameOfLife.getNextLife());
	}

	@Test
	public void testSetNextLife() {
		assertEquals(nextLife, testGameOfLife.getNextLife());
		testGameOfLife.setNextLife(currentLife);
		assertEquals(currentLife, testGameOfLife.getNextLife());
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
}
