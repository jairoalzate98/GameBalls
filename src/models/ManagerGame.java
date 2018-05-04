package models;

public class ManagerGame implements Runnable{
	
	private Player player;
	private Enemy enemy;
	private boolean stop;
	private Thread thread;
	private int sleep;

	public ManagerGame(int widthInitial, int heightInitial, int sleep){
		player = new Player(widthInitial, heightInitial);
		enemy = new Enemy(widthInitial, heightInitial);
		stop = false;
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
		}
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