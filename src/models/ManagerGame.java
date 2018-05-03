package models;

public class ManagerGame {
	
	private Player player;

	public ManagerGame(int widthInitial, int heightInitial){
		player = new Player(widthInitial / 2, heightInitial / 2);
	}

	public Player getPlayer() {
		return player;
	}
}
