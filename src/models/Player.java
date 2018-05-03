package models;

public class Player {

	private int positionX;
	private int positionY;
	
	public Player(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	
	public void moveUp(){
		positionY--;
	}
	
	public void moveDown(){
		positionY++;
	}
	
	public void moveRight(){
		positionX++;
	}
	
	public void moveLeft(){
		positionX--;
	}
}