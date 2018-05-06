package models;

import views.JPanelGame;

public class Boos{
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int widhtPlayer;
	private int heightPlayer;
	
	public Boos(int width, int height) {
		posX = (int) (Math.random()* width);
		posY = (int) (Math.random()* height);
		this.width = width;
		this.height = height;
		this.widhtPlayer = JPanelGame.SIZE_BOOS;
		this.heightPlayer = JPanelGame.SIZE_BOOS;
	}

	public int getWidhtPlayer() {
		return widhtPlayer;
	}

	public int getHeightPlayer() {
		return heightPlayer;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
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
}