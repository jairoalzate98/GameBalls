package views;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Player;

public class JPanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player;
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon(getClass().getResource("/img/ball.png")).getImage(), player.getPositionX(), player.getPositionY(), 40, 40, this);
	}
}