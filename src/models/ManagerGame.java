package models;

import java.awt.Rectangle;
import java.util.ArrayList;

public class ManagerGame implements Runnable{
	
	private Player player;
	private ArrayList<Enemy> enemyList;
	private boolean stop;
	private Thread thread;
	private int sleep;
	private boolean gamePlay;

	public ManagerGame(int widthInitial, int heightInitial, int sleep){
		player = new Player(widthInitial, heightInitial);
		enemyList = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			enemyList.add(new Enemy(widthInitial, heightInitial));
		}
		stop = false;
		gamePlay = true;
		this.sleep = sleep;
		thread = new Thread(this);
		thread.start();
	}

	public ArrayList<Enemy> getEnemy() {
		return enemyList;
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
			for (Enemy enemy : enemyList) {
				moveEnemyInX(enemy);
				moveEnemyInY(enemy);
			}
			verifyGameOver();
		}
	}

	private void verifyGameOver() {
		Rectangle recPlayer = new Rectangle(player.getPositionX(), player.getPositionY(), player.getWidhtPlayer(), player.getHeightPlayer());
		for (Enemy enemy2 : enemyList) {
			Rectangle recEnemy = new Rectangle(enemy2.getPosX(), enemy2.getPosY(), enemy2.getWidhtPlayer(), enemy2.getHeightPlayer());
			if (recPlayer.intersects(recEnemy)) {
				stop = true;
				gamePlay = false;
			}
		}
	}
	
//	public void verifyGameOverTwo(){
//		if(((player.getPositionX() > enemy.getPosX()) && player.getPositionX() < (enemy.getPosX() + enemy.getWidhtPlayer()) || 
//		((player.getPositionX() + player.getWidhtPlayer()) > enemy.getPosX()) && (player.getPositionX() + player.getWidhtPlayer() < 
//				enemy.getPosX() + enemy.getWidhtPlayer())) && 
//					((player.getPositionY() > enemy.getPosY()) && player.getPositionY() < 
//						(enemy.getPosY() + enemy.getHeightPlayer()) || ((player.getPositionY() + player.getHeightPlayer()) > 
//						enemy.getPosY()) && (player.getPositionY() + player.getHeightPlayer() < enemy.getPosY() + enemy.getHeightPlayer()))){
//			stop = true;
//			gamePlay = false;
//		}
//	}

	public boolean isGamePlay() {
		return gamePlay;
	}

	public void setGamePlay(boolean gamePlay) {
		this.gamePlay = gamePlay;
	}

	private void moveEnemyInY(Enemy e) {
		if (player.getPositionY() > e.getPosY()) {
			e.setPosY(e.getPosY() + 1);
		}else{
			e.setPosY(e.getPosY() - 1);
		}
	}

	private void moveEnemyInX(Enemy e) {
		if (player.getPositionX() > e.getPosX()) {
			e.setPosX(e.getPosX() + 1);
		}else{
			e.setPosX(e.getPosX() - 1);
		}
	}
}