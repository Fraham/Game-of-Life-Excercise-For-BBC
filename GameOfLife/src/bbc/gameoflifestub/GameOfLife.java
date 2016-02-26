package bbc.gameoflifestub;

public class GameOfLife {
	
	private Life currentLife;
	private Life nextLife;
	
	private int width;
	private int height;
	
	private int maxGenerations;
	
	public GameOfLife(int maxGenerations){
		setMaxGenerations(maxGenerations);
	}
	
	public void startGame(){
		for (int i = 0; i < getMaxGenerations(); i++){
			printCurrentLife();
			setUpNextGeneration();
		}
	}
	
	public void setUpNextGeneration(){
		
	}
	
	public void printCurrentLife(){
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

	public Life getNextLife() {
		return nextLife;
	}

	public void setNextLife(Life nextLife) {
		this.nextLife = nextLife;
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
		gameOfLife.setInitailLife("*.\n.*");
		gameOfLife.startGame();
	}
}
