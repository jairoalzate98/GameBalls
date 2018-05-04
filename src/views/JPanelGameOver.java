package views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelGameOver extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelGameOver() {
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon(getClass().getResource("/img/GameOver.png")).getImage(), (getWidth() / 2) - 75, 50, 150, 300, this);
		g.drawImage(new ImageIcon(getClass().getResource("/img/gameOverText.png")).getImage(), (getWidth() / 2) - 100, (getHeight() / 2) + 100, 200, 100, this);
	}
}