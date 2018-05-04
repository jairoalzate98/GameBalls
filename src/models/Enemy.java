package models;

public class Enemy{
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	public Enemy(int width, int height) {
		posX = 0;
		posY = 0;
		this.width = width;
		this.height = height;
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