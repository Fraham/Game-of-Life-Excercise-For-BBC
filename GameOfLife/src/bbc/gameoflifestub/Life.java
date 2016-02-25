package bbc.gameoflifestub;

import java.util.Set;
import java.util.HashSet;

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
    	// the cell an only survive if there is either 2 or 3 neighbours
        return numNeighbours == 2 || numNeighbours == 3 ? true : false;
    }
    
    public boolean cellShouldCreated(int numNeighbours)
    {
    	// the cell an only be created if there is 3 neighbours
        return numNeighbours == 3 ? true : false;
    }

	public static Set<Cell> decodeInputLifeString(String inputString, GameOfLife gameOfLife) {
		int currentX = 0;
		int currentY = 1;
		
		Set<Cell> newCells = new HashSet<Cell>();
		
		for (int i = 0; i < inputString.length(); i++){
		    char character = inputString.charAt(i);
		    
		    currentX++;
		    
		    if (character == '.'){
		    	//dead cell, do nothing
		    }
		    else if (character == '*'){
		    	newCells.add(new Cell(currentX, currentY));
		    }
		    else if (character == '\n'){
		    	currentY++;
		    	currentX = 0;
		    }
		}
				
		gameOfLife.setHeight(currentX);
		gameOfLife.setWidth(currentY);
		
		return newCells;
	}
	
	public String getPrintOut(){
		return null;
	}
}
