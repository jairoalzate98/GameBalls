package persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Boos;
import models.Enemy;
import models.Player;

public class FileManager {

	private static final File FILE_ENEMY = new File("src/persistence/enemy.txt");
	private static final File FILE_PLAYER = new File("src/persistence/player.txt");
	private static final File FILE_BOOS = new File("src/persistence/boos.txt");

	public void writeFileEnemy(ArrayList<Enemy> enemys) throws IOException{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_ENEMY));
		for (Enemy enemy : enemys) {
			bufferedWriter.write(enemy.getPosX() + "," + enemy.getPosY() + "," + enemy.getWidhtPlayer() + "," + enemy.getHeightPlayer() + "," + enemy.getWidth() + "," + enemy.getHeight());
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
	
	public void writeFilePlayer(Player player, int sleep) throws IOException{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PLAYER));
		bufferedWriter.write(player.getPositionX() + "," + player.getPositionY() + "," + player.getWidhtPlayer() + "," + player.getHeightPlayer() + "," + player.getWidth() + "," + player.getHeight() + "," + player.getLife() + "," + sleep);
		bufferedWriter.newLine();
		bufferedWriter.close();
	}
	
	public void writeFileBoos(Boos boos) throws IOException{
		if (boos != null) {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_BOOS));
			bufferedWriter.write(boos.getPosX() + "," + boos.getPosY() + "," + boos.getWidhtPlayer() + "," + boos.getHeightPlayer() + "," + boos.getWidth() + "," + boos.getHeight());
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
	}
	
	public ArrayList<Enemy> readEnemys() throws NumberFormatException, IOException{
		ArrayList<Enemy> enemyList = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_ENEMY));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			enemyList.add(new Enemy(Integer.parseInt(information[0]), Integer.parseInt(information[1]), Integer.parseInt(information[4]), Integer.parseInt(information[5]), Integer.parseInt(information[2]), Integer.parseInt(information[3])));
		}
		bufferedReader.close();
		return enemyList;
	}
	
	public Player readPlayer() throws IOException{
		Player player = null;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PLAYER));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			player = new Player(Integer.parseInt(information[0]), Integer.parseInt(information[1]), Integer.parseInt(information[2]), Integer.parseInt(information[3]), Integer.parseInt(information[4]), Integer.parseInt(information[5]), Integer.parseInt(information[6]));
		}
		bufferedReader.close();
		return player;
	}
	
	public Boos readBoos() throws IOException{
		Boos boos = null;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_BOOS));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			boos = new Boos(Integer.parseInt(information[0]), Integer.parseInt(information[1]), Integer.parseInt(information[4]), Integer.parseInt(information[5]), Integer.parseInt(information[2]), Integer.parseInt(information[3]));
		}
		bufferedReader.close();
		return boos;
	}
	
	public int readSleep() throws IOException{
		int sleep = 0;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PLAYER));
		String data = "";
		while ((data = bufferedReader.readLine()) != null) {
			String[] information = data.split(",");
			System.out.println(information.length);
			sleep = Integer.parseInt(information[6]);
		}
		bufferedReader.close();
		return sleep;
	}
}