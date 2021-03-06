package bbc.gameoflifestub;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
	
public class LifeTest {

	protected Set<Cell> setOfCells;
	protected Life life;
	
	@Before
	public void setUp(){
    	setOfCells = new HashSet<Cell>();
    	setOfCells.add(new Cell(1,1));
    	setOfCells.add(new Cell(2,2));
        life = new Life(setOfCells);
    }
	
	@Test
	public void testInitialisation()
	{
		assertEquals(2, life.getLiveCells().size());
	}

    @Test
    public void testUnderPopulation()
    {
        assertFalse(life.cellShouldSurvive(0));
        assertFalse(life.cellShouldSurvive(1));
    }
    
    @Test
    public void testOverPopulation()
    {
        assertFalse(life.cellShouldSurvive(4));
        assertFalse(life.cellShouldSurvive(5));
        assertFalse(life.cellShouldSurvive(6));
        assertFalse(life.cellShouldSurvive(7));
        assertFalse(life.cellShouldSurvive(8));
    }
    
    @Test
    public void testSurvival()
    {
    	assertTrue(life.cellShouldSurvive(2));
    	assertTrue(life.cellShouldSurvive(3));
    }
    
    @Test
    public void testCreation()
    {
    	assertTrue(life.cellShouldCreated(3));
    }
    
    @Test
    public void testNotCreation()
    {        
    	assertFalse(life.cellShouldCreated(0));
    	assertFalse(life.cellShouldCreated(1));
    	assertFalse(life.cellShouldCreated(2));
    	assertFalse(life.cellShouldCreated(4));
    	assertFalse(life.cellShouldCreated(5));
    	assertFalse(life.cellShouldCreated(6));
    	assertFalse(life.cellShouldCreated(7));
    	assertFalse(life.cellShouldCreated(8));
    }
    
    @Test
    public void testDecodeInputLifeString()
    {
    	assertEquals(life, Life.decodeInputLifeString("*.\n.*", new GameOfLife(10)));
    	
    	assertNotSame(life, Life.decodeInputLifeString(".*\n*.", new GameOfLife(10)));
    	
    	try {
    		Life.decodeInputLifeString("..........\n*.", new GameOfLife(10));
		    fail("Should throw IllegalArgumentException for wrong different width value.");
		} catch (IllegalArgumentException expectedException) {
		}
    	
    	try {
    		Life.decodeInputLifeString("", new GameOfLife(10));
		    fail("Should throw IllegalArgumentException for length zero string");
		} catch (IllegalArgumentException expectedException) {
		}
    	
    	try {
    		Life.decodeInputLifeString(null, new GameOfLife(10));
		    fail("Should throw IllegalArgumentException for null string");
		} catch (IllegalArgumentException expectedException) {
		}
    	
    	try {
    		Life.decodeInputLifeString("*c\n.*", new GameOfLife(10));
		    fail("Should throw IllegalArgumentException for unknown character");
		} catch (IllegalArgumentException expectedException) {
		}
    }
    
    @Test
    public void testGetPrintOut()
    {
    	assertEquals("*.\n.*", life.getPrintOut(2, 2));
    }
    
    @Test
    public void testGetNumberOfNeighbours()
    {
    	assertEquals(2, life.getNumberOfNeighbours(1, 2));
    	assertEquals(2, life.getNumberOfNeighbours(2, 1));
    	assertEquals(1, life.getNumberOfNeighbours(1, 1));
    	assertEquals(1, life.getNumberOfNeighbours(2, 2));
    }
    
    @Test
    public void testIsCellAlive()
    {
    	assertTrue(life.isCellAlive(new Cell(1,1)));
    	assertTrue(life.isCellAlive(new Cell(2,2)));
    	assertFalse(life.isCellAlive(new Cell(1,2)));
    	assertFalse(life.isCellAlive(new Cell(2,1)));
    	
    	assertTrue(life.isCellAlive(1,1));
    	assertTrue(life.isCellAlive(2,2));
    	assertFalse(life.isCellAlive(1,2));
    	assertFalse(life.isCellAlive(2,1));
    }
}
