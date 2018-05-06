package models;

import views.JPanelGame;

public class Player {

	private int positionX;
	private int positionY;
	private int widhtPlayer;
	private int heightPlayer;
	private int width;
	private int height;
	private int life;
	
	public Player(int width, int height) {
		this.width = width;
		this.height = height;
		this.positionX = (int) (Math.random()* width );
		this.positionY = (int) (Math.random()* (height - 40));
		this.widhtPlayer = JPanelGame.SIZE_JERRY;
		this.heightPlayer = JPanelGame.SIZE_JERRY;
		life = 100;
	}
	
	public int getLife() {
		return life;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setLifeTom() {
		life -= 20; 
	}

	public void setLifeBoos() {
		life -= 40; 
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
		if (positionX < (width - 50)) {
			positionX += 8;
		}
	}
	
	public void moveLeft(){
		if (positionX > 0) {
			positionX -= 8;
		}
	}
}