package models;

import views.JPanelGame;

public class Shooting {

	private int posX;
	private int posY;
	private int widhtShoot;
	private int heightShoot;
	private int width;
	private int height;
	private boolean active;
	private String direction;
	
	public Shooting(int posX, int posY, int width, int height, String direction) {
		this.posX = posX;
		this.posY = posY;
		this.widhtShoot = JPanelGame.SIZE_SHOOT;
		this.heightShoot = JPanelGame.SIZE_SHOOT;
		this.width = width;
		this.height = height;
		this.direction = direction;
		active = true;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public int getWidhtShoot() {
		return widhtShoot;
	}
	
	public int getHeightShoot() {
		return heightShoot;
	}
	
	public void moveUp(){
		if (posY > 0) {
			posY -= 4;
		}
	}
	
	public void moveDown(){
		if (posY < height) {
			posY += 4;
		}
	}
	
	public void moveRight(){
		if (posX < width) {
			posX += 4;
		}
	}
	
	public void moveLeft(){
		if (posX > 0) {
			posX -= 4;
		}
	}

	public boolean isActive() {
		return active;
	}

	public String getDirection() {
		return direction;
	}
}