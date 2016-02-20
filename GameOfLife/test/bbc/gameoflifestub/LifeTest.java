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
    	assertTrue(life.cellShouldSurvive(3));
    }
}
