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
	
	public static void main(String[] args){
		
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
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
