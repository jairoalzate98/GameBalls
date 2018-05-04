package models;

import java.awt.Rectangle;

public class ManagerGame implements Runnable{
	
	private Player player;
	private Enemy enemy;
	private boolean stop;
	private Thread thread;
	private int sleep;
	private boolean gamePlay;

	public ManagerGame(int widthInitial, int heightInitial, int sleep){
		player = new Player(widthInitial, heightInitial);
		enemy = new Enemy(widthInitial, heightInitial);
		stop = false;
		gamePlay = true;
		this.sleep = sleep;
		thread = new Thread(this);
		thread.start();
	}

	public Enemy getEnemy() {
		return enemy;
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

	@Override
	public void run() {
		while(!stop){
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moveEnemyInX();
			moveEnemyInY();
			verifyGameOver();
		}
	}

	private void verifyGameOver() {
		Rectangle recPlayer = new Rectangle(player.getPositionX(), player.getPositionY(), player.getWidhtPlayer(), player.getHeightPlayer());
		Rectangle recEnemy = new Rectangle(enemy.getPosX(), enemy.getPosY(), enemy.getWidhtPlayer(), enemy.getHeightPlayer());
		if (recPlayer.intersects(recEnemy)) {
			stop = true;
			gamePlay = false;
		}
//		if(((player.getPositionX() > enemy.getPosX()) && player.getPositionX() < (enemy.getPosX() + enemy.getWidhtPlayer()) || 
//				((player.getPositionX() + player.getWidhtPlayer()) > enemy.getPosX()) && (player.getPositionX() + player.getWidhtPlayer() < 
//						enemy.getPosX() + enemy.getWidhtPlayer())) && 
//							((player.getPositionY() > enemy.getPosY()) && player.getPositionY() < 
//								(enemy.getPosY() + enemy.getHeightPlayer()) || ((player.getPositionY() + player.getHeightPlayer()) > 
//								enemy.getPosY()) && (player.getPositionY() + player.getHeightPlayer() < enemy.getPosY() + enemy.getHeightPlayer()))){
//			stop = true;
//			gamePlay = false;
//		}
	}

	public boolean isGamePlay() {
		return gamePlay;
	}

	public void setGamePlay(boolean gamePlay) {
		this.gamePlay = gamePlay;
	}

	private void moveEnemyInY() {
		if (player.getPositionY() > enemy.getPosY()) {
			enemy.setPosY(enemy.getPosY() + 1);
		}else{
			enemy.setPosY(enemy.getPosY() - 1);
		}
	}

	private void moveEnemyInX() {
		if (player.getPositionX() > enemy.getPosX()) {
			enemy.setPosX(enemy.getPosX() + 1);
		}else{
			enemy.setPosX(enemy.getPosX() - 1);
		}
	}
}