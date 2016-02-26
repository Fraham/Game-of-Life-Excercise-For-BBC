package bbc.gameoflifestub;

public class GameOfLife {
	
	private Life currentLife;
	
	private int width;
	private int height;
	
	private int maxGenerations;
	
	private int currentGeneration;
	
	public GameOfLife(int maxGenerations){
		setMaxGenerations(maxGenerations);
	}
	
	public void startGame(){
		for (currentGeneration = 0; currentGeneration < getMaxGenerations(); currentGeneration++){
			printCurrentLife();
			setUpNextGeneration();
		}
	}
	
	public void setUpNextGeneration(){
		Life nextLife = new Life();
		
		for (int i = 1; i <= getWidth(); i++){
			for (int j = 1; j <= getHeight(); j++){
				Cell checkCell = new Cell(i, j);
				
				if(currentLife.isCellAlive(checkCell) && currentLife.cellShouldSurvive(currentLife.getNumberOfNeighbours(checkCell))){
					nextLife.getLiveCells().add(checkCell);
				}
				else if (!currentLife.isCellAlive(checkCell) && currentLife.cellShouldCreated(currentLife.getNumberOfNeighbours(checkCell))){
					nextLife.getLiveCells().add(checkCell);
				}
			}
		}
		setCurrentLife(nextLife);
	}
	
	public void printCurrentLife(){
		System.out.println("Generation: " + (currentGeneration + 1));
		System.out.println(currentLife.getPrintOut(getWidth(), getHeight()));
	}
	
	public void setInitailLife(String initailLife){
		setCurrentLife(Life.decodeInputLifeString(initailLife, this));
	}

	public Life getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(Life currentLife) {
		this.currentLife = currentLife;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width < 1){
			throw new IllegalArgumentException("Number has to be non-negative");
		}
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height < 1){
			throw new IllegalArgumentException("Number has to be non-negative");
		}
		this.height = height;
	}
	
	public int getMaxGenerations() {
		return maxGenerations;
	}

	public void setMaxGenerations(int maxGenerations) {
		if (maxGenerations < 1){
			throw new IllegalArgumentException("Number has to be non-negative");
		}
		this.maxGenerations = maxGenerations;
	}
	
	public boolean equals(Object other){
		GameOfLife otherGameOfLife = (GameOfLife)other;
		return otherGameOfLife.getHeight() == getHeight() && otherGameOfLife.getWidth() == getWidth() && otherGameOfLife.getCurrentLife() == getCurrentLife(); 
	}

	public static void main(String[] args) {
		GameOfLife gameOfLife = new GameOfLife(10);
		gameOfLife.setInitailLife(".*...\n..*..\n***..\n.....\n.....\n.....");
		//gameOfLife.setInitailLife("*****\n*****\n*****\n*****\n*****\n*****\n*****\n*****\n*****\n*****\n*****");
		gameOfLife.startGame();
	}
}
