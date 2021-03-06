package bbc.gameoflifestub;

import java.util.Set;
import java.util.HashSet;

public class Life {

	private Set<Cell> liveCells;

	public Life(Set<Cell> initialLiveCells)
    {
		this.liveCells = initialLiveCells;
	}
	
	public Life(){
		liveCells = new HashSet<Cell>();
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
    
    public int getNumberOfNeighbours(Cell cell){    	
    	return getNumberOfNeighbours(cell.getX(), cell.getY());
    }
    
    public int getNumberOfNeighbours(int x, int y){
    	int count = 0;
    	
    	for(int i = -1; i < 2; i++){
    		for(int j = -1; j < 2; j++){
        		if (liveCells.contains(new Cell(x + i, y + j)) && !(i == 0 && j == 0)){
        			count++;
        		}
        	}
    	}
    	
    	return count;
    }
    
    public boolean isCellAlive(int x, int y){
    	return isCellAlive(new Cell(x, y));
    }
    
    public boolean isCellAlive(Cell cell){
    	return liveCells.contains(cell);
    }

	public static Life decodeInputLifeString(String inputString, GameOfLife gameOfLife) throws IllegalArgumentException {
		if (inputString != null && inputString.length() > 0){
			int currentX = 0;
			int currentY = 1;
			
			int firstWidth = -1;
			
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
			    	
			    	if (firstWidth == -1){
			    		firstWidth = currentX;
			    	}
			    	
			    	if(currentX != firstWidth){
			    		throw new IllegalArgumentException("Width differs from previous.");
			    	}
			    	
			    	currentX = 0;
			    }
			    else{
			    	throw new IllegalArgumentException("Unknown character.");
			    }
			}
			
			if(currentX != firstWidth - 1){
	    		throw new IllegalArgumentException("Width differs from previous.");
	    	}
					
			gameOfLife.setHeight(currentY);
			gameOfLife.setWidth(firstWidth - 1);
			
			return new Life(newCells);
		}
		else{
			throw new IllegalArgumentException("Input string needs to be set or greater length then zero.");
		}
	}
	
	public String getPrintOut(int width, int height){
		StringBuilder newString = new StringBuilder("");
		for(int i = 1; i <= height; i++){
			for(int j = 1; j <= width; j++){
				newString.append(new Cell(j, i).getCharacter(this));
			}
			if (height != i)
			{
				newString.append('\n');
			}
		}
		
		return newString.toString();
	}
	
	public boolean equals(Object other){
		Life otherLife = (Life)other;
		return otherLife.getLiveCells().equals(getLiveCells()); 
	}
}
