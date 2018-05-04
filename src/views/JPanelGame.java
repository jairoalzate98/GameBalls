package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Enemy;
import models.Player;

public class JPanelGame extends JPanel {

	public static final int SIZE_TOM = 90;
	public static final int SIZE_JERRY = 63;
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
		g.drawImage(jerry.getImage(), player.getPositionX(), player.getPositionY(), SIZE_JERRY, SIZE_JERRY, this);
		g.drawRect(player.getPositionX(), player.getPositionY(), SIZE_JERRY, SIZE_JERRY);
		for (Enemy enemy2 : enemy) {
			g.drawImage(tom.getImage(), enemy2.getPosX(), enemy2.getPosY(), SIZE_TOM, SIZE_TOM, this);
			g.drawRect(enemy2.getPosX(), enemy2.getPosY(), SIZE_TOM, SIZE_TOM);
		}
		repaint();
	}
}