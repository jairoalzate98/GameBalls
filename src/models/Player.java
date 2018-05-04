package models;

public class Player {

	private int positionX;
	private int positionY;
	private int widht;
	private int height;
	private int widhtPlayer;
	private int heightPlayer;
	
	public Player(int widht, int height) {
		this.widht = widht;
		this.height = height;
		this.positionX = widht / 2;
		this.positionY = height / 2;
		this.widhtPlayer = 70;
		this.heightPlayer = 70;
	}
	
	public int getWidhtPlayer() {
		return widhtPlayer;
	}

	public int getHeightPlayer() {
		return heightPlayer;
	}

	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	
	public int getWidht() {
		return widht;
	}

	public int getHeight() {
		return height;
	}

	public void moveUp(){
		if (positionY > 0) {
			positionY -= 8;
		}
	}
	
	public void moveDown(){
		if (positionY < (height - 75)) {
			positionY += 8;
		}
	}
	
	public void moveRight(){
		if (positionX < (widht - 50)) {
			positionX += 8;
		}
	}
	
	public void moveLeft(){
		if (positionX > 0) {
			positionX -= 8;
		}
	}
}