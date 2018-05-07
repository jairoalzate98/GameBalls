package persistence;

import java.io.BufferedWriter;
import java.io.File;
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
			bufferedWriter.write(enemy.getPosX() + "," + enemy.getPosY() + ";" + enemy.getWidhtPlayer() + ";" + enemy.getHeightPlayer() + ";" + enemy.getWidth() + ";" + enemy.getHeight());
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}
	
	public void writeFilePlayer(Player player) throws IOException{
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_BOOS));
		bufferedWriter.write(player.getPositionX() + "," + player.getPositionY() + ";" + player.getWidhtPlayer() + ";" + player.getHeightPlayer() + ";" + player.getWidth() + ";" + player.getHeight() + ";" + player.getLife());
		bufferedWriter.newLine();
		bufferedWriter.close();
	}
	
	public void writeFileBoos(Boos boos) throws IOException{
		if (boos != null) {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PLAYER));
			bufferedWriter.write(boos.getPosX() + "," + boos.getPosY() + ";" + boos.getWidhtPlayer() + ";" + boos.getHeightPlayer() + ";" + boos.getWidth() + ";" + boos.getHeight());
			bufferedWriter.newLine();
			bufferedWriter.close();
		}
	}
}