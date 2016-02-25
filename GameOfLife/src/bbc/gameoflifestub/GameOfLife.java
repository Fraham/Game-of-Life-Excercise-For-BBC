package bbc.gameoflifestub;

public class GameOfLife {
	
	private Life currentLife;
	private Life nextLife;
	
	private int width;
	private int height;
	
	public GameOfLife(){
		
	}
	
	public void startGame(){
		
	}
	
	public void printCurrentLife(){
		System.out.println(currentLife.getPrintOut());
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

	public static void main(String[] args){
		GameOfLife gameOfLife = new GameOfLife();
		gameOfLife.startGame();
	}
}
