package bbc.gameoflifestub;

import java.util.Set;

public class Life {

	private Set<Cell> liveCells;

	public Life(Set<Cell> initialLiveCells)
    {
		this.liveCells = initialLiveCells;
	}
	
    // Read-only access to the game state
    public Set<Cell> getLiveCells()
    {
        return this.liveCells;
    }

    public boolean cellShouldSurvive(int numNeighbours)
    {
    	// the cell an only survive if there is either 2 or 3 neighours
        return numNeighbours == 2 || numNeighbours == 3 ? true : false;
    }
    
    public boolean cellShouldCreated(int numNeighbours)
    {
    	// the cell an only be created if there is 3 neighours
        return numNeighbours == 3 ? true : false;
    }

	public static Set<Cell> decodeInputLifeString(String string) {
		throw new UnsupportedOperationException();
	}
}
