package models;

public class ManagerGame {
	
	private Player player;

	public ManagerGame(int widthInitial, int heightInitial){
		player = new Player(widthInitial, heightInitial);
	}

	public Player getPlayer() {
		return player;
	}
	
	public void moveUp(){
		player.moveUp();
	}
	
	public void moveDown(){
		player.moveDown();
	}
	
	public void moveLeft(){
		player.moveLeft();
	}
	
	public void moveRight(){
		player.moveRight();
	}
}