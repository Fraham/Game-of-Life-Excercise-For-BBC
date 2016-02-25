package bbc.gameoflifestub;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {
	
	private GameOfLife testGameOfLife;
	HashSet<Cell> currentSetOfCells;
	HashSet<Cell> nextSetOfCells;
	
	@Before
	public void setUp(){
		testGameOfLife = new GameOfLife();
		testGameOfLife.setHeight(100);
		testGameOfLife.setWidth(100);
		
		currentSetOfCells = new HashSet<Cell>();
		currentSetOfCells.add(new Cell(1,1));
		currentSetOfCells.add(new Cell(2,2));
        Life currentLife = new Life(currentSetOfCells);
        
        nextSetOfCells = new HashSet<Cell>();
        nextSetOfCells.add(new Cell(2,1));
        nextSetOfCells.add(new Cell(1,2));
        Life nextLife = new Life(nextSetOfCells);
        
        testGameOfLife.setCurrentLife(currentLife);
        testGameOfLife.setNextLife(nextLife);
    }
	
	@Test
	public void testGetCurrentLife(){
		
	}

	@Test
	public void testSetCurrentLife() {
		
	}

	@Test
	public void testGetNextLife() {
		
	}

	@Test
	public void testSetNextLife() {
		
	}

	@Test
	public void testGetWidth() {
		
	}

	@Test
	public void testSetWidth() {
		
	}

	@Test
	public void testGetHeight() {
		
	}

	@Test
	public void testSetHeight() {
		
	}
}
