package models;

public class Enemy{
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int widhtPlayer;
	private int heightPlayer;
	
	public Enemy(int width, int height) {
		posX = (int) (Math.random()* width);
		posY = (int) (Math.random()* height);
		this.width = width;
		this.height = height;
		this.widhtPlayer = 100;
		this.heightPlayer = 100;
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