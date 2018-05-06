package models;

import java.awt.Rectangle;
import java.util.ArrayList;

public class ManagerGame implements Runnable{
	
	public static final String W_LETTER = "w";
	public static final String S_LETTER = "s";
	public static final String D_LETTER = "d";
	public static final String A_LETTER = "a";
	private Player player;
	private ArrayList<Enemy> enemyList;
	private boolean stop;
	private Thread thread;
	private int sleep;
	private boolean gamePlay;
	private ArrayList<Shooting> shootList;
	private Boos boos;
	private boolean boosActive;
	private boolean victory;

	public ManagerGame(int widthInitial, int heightInitial, int sleep){
		shootList = new ArrayList<>();
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
	
	public void addShooting(Shooting shooting){
		shootList.add(shooting);
	}

	public ArrayList<Shooting> getShootList() {
		return shootList;
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
			for (Shooting shoot : shootList) {
				switch (shoot.getDirection()) {
				case W_LETTER:
					shoot.moveUp();
					break;
				case S_LETTER:
					shoot.moveDown();
					break;
				case D_LETTER:
					shoot.moveRight();
					break;
				case A_LETTER: 
					shoot.moveLeft();
					break;
				}
			}
			verifyGameOver();
			verifyDeadTom();
			verifyShoot();
			verifyBoos();
			verifyDeadBoos();
		}
	}

	private void verifyDeadBoos() {
		if (boos != null) {
			for (Shooting shooting : shootList) {
				Rectangle shoot = new Rectangle(shooting.getPosX(), shooting.getPosY(), shooting.getWidhtShoot(), shooting.getHeightShoot());
				Rectangle b = new Rectangle(boos.getPosX(), boos.getPosY(), boos.getWidhtPlayer(), boos.getHeightPlayer());
				if (shoot.intersects(b)) {
					boos = null;
					victory = true;
					stop = false;
					return;
				}
			}
		}
	}

	public boolean isVictory() {
		return victory;
	}

	private void verifyBoos() {
		if (enemyList.isEmpty()) {
			if (boos == null) {
				if (!boosActive) {
					boos = new Boos(player.getWidth(), player.getHeight());
					boosActive = true;
				}
			}else {
				moveBoosInX(boos);
				moveBoosInY(boos);
			}
		}
	}
	
	public Boos getBoos() {
		return boos;
	}

	private void moveBoosInY(Boos e) {
		if (player.getPositionY() > e.getPosY()) {
			e.setPosY(e.getPosY() + 1);
		}else{
			e.setPosY(e.getPosY() - 1);
		}
	}

	private void moveBoosInX(Boos e) {
		if (player.getPositionX() > e.getPosX()) {
			e.setPosX(e.getPosX() + 1);
		}else{
			e.setPosX(e.getPosX() - 1);
		}
	}

	private void verifyShoot() {
		for (Shooting shoot : shootList) {
			if (shoot.getPosX() < 5 || shoot.getPosY() < 5 || shoot.getPosX() == shoot.getWidth() || shoot.getPosY() == shoot.getHeight()) {
				shootList.remove(shoot);
				return;
			}
		}
	}

	private void verifyDeadTom() {
		for (Enemy enemy : enemyList) {
			Rectangle e = new Rectangle(enemy.getPosX(), enemy.getPosY(), enemy.getWidhtPlayer(), enemy.getHeightPlayer());
			for (Shooting shoot : shootList) {
				Rectangle s = new Rectangle(shoot.getPosX(), shoot.getPosY(), shoot.getWidhtShoot(), shoot.getHeightShoot());
				if (e.intersects(s)) {
					enemyList.remove(enemy);
					shootList.remove(shoot);
					return;
				}
			}
		}
	}

	private void verifyGameOver() {
		Rectangle recPlayer = new Rectangle(player.getPositionX(), player.getPositionY(), player.getWidhtPlayer(), player.getHeightPlayer());
		if (!enemyList.isEmpty()) {
			for (Enemy enemy2 : enemyList) {
				Rectangle recEnemy = new Rectangle(enemy2.getPosX(), enemy2.getPosY(), enemy2.getWidhtPlayer(), enemy2.getHeightPlayer());
				if (recPlayer.intersects(recEnemy)) {
					stop = true;
					gamePlay = false;
				}
			}
		}else{
			if (boos != null) {
				Rectangle b = new Rectangle(boos.getPosX(), boos.getPosY(), boos.getWidhtPlayer(), boos.getHeightPlayer());
				if (recPlayer.intersects(b)) {
					stop = true;
					gamePlay = false;
				}
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

	public void shoot(int width, int height, String direction) {
		addShooting(new Shooting(player.getPositionX(), player.getPositionY(), width, height, direction));
	}
}