package views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Boos;
import models.Enemy;
import models.Player;
import models.Shooting;

public class JPanelGame extends JPanel {

	public static final int SIZE_TOM = 90;
	public static final int SIZE_JERRY = 63;
	public static final int SIZE_SHOOT = 40;
	public static final int SIZE_BOOS = 200;
	private static final long serialVersionUID = 1L;
	private ImageIcon jerry = new ImageIcon(getClass().getResource("/img/jerry.png"));
	private ImageIcon tom = new ImageIcon(getClass().getResource("/img/tom.png"));
	private ImageIcon bullet = new ImageIcon(getClass().getResource("/img/bullet.png"));
	private ImageIcon bossImage = new ImageIcon(getClass().getResource("/img/boss.png"));
	private Player player;
	private ArrayList<Enemy> enemy;
	private ArrayList<Shooting> shootingList;
	private Boos boos;
	
	public JPanelGame() {
		setBackground(Color.WHITE);
	}
	
	public void setShootingList(ArrayList<Shooting> shootingList) {
		this.shootingList = shootingList;
	}

	public void setEnemy(ArrayList<Enemy> enemy) {
		this.enemy = enemy;
	}

	public void setPlayer(Player player) {
		this.player = player;
		removeAll();
	}
	
	public void setBoos(Boos boos) {
		this.boos = boos;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawImage(jerry.getImage(), player.getPositionX(), player.getPositionY(), SIZE_JERRY, SIZE_JERRY, this);
		g.drawRect(player.getPositionX(), player.getPositionY(), SIZE_JERRY, SIZE_JERRY);
		for (Enemy enemy2 : enemy) {
			g.drawImage(tom.getImage(), enemy2.getPosX(), enemy2.getPosY(), SIZE_TOM, SIZE_TOM, this);
			g.drawRect(enemy2.getPosX(), enemy2.getPosY(), SIZE_TOM, SIZE_TOM);
		}
		for (Shooting shoot : shootingList) {
			g.drawImage(bullet.getImage(), shoot.getPosX(), shoot.getPosY(), shoot.getWidhtShoot(), shoot.getHeightShoot(), this);
		}
		if (boos != null) {
			g.drawImage(bossImage.getImage(), boos.getPosX(), boos.getPosY(), boos.getWidhtPlayer(), boos.getHeightPlayer(), this);
			g.drawRect(boos.getPosX(), boos.getPosY(), SIZE_BOOS, SIZE_BOOS);
		}
		g.setFont(JPanelGameOver.FONT_UBUNTU);
		g.drawString("Life => " + player.getLife() + "%", 20, 20);
		g.drawRect(20, 40, 120, 40);
		g.setColor(Color.RED);
		g.fillRect(30, 45, player.getLife(), 30);
	}
}