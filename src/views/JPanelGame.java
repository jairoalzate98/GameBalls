package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Enemy;
import models.Player;

public class JPanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon jerry = new ImageIcon(getClass().getResource("/img/jerry.png"));
	private ImageIcon tom = new ImageIcon(getClass().getResource("/img/tom.png"));
	private Player player;
	private ArrayList<Enemy> enemy;
	
	public JPanelGame() {
		setBackground(Color.WHITE);
	}
	
	public void setEnemy(ArrayList<Enemy> enemy) {
		this.enemy = enemy;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Override
	public void paint(Graphics g) {
		removeAll();
		super.paint(g);
		g.drawImage(jerry.getImage(), player.getPositionX(), player.getPositionY(), 70, 70, this);
		g.drawRect(player.getPositionX(), player.getPositionY(), 70, 70);
		for (Enemy enemy2 : enemy) {
			g.drawImage(tom.getImage(), enemy2.getPosX(), enemy2.getPosY(), 100, 100, this);
			g.drawRect(enemy2.getPosX(), enemy2.getPosY(), 100, 100);
		}
		repaint();
	}
}