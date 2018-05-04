package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelGameOver extends JPanel {

	public static final Font FONT_UBUNTU = new Font("Ubuntu", Font.BOLD, 27);
	private static final long serialVersionUID = 1L;
	private String seconds;

	public JPanelGameOver() {
		setBackground(Color.WHITE);
	}

	public void setSeconds(String seconds) {
		this.seconds = seconds;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon(getClass().getResource("/img/GameOver.png")).getImage(), (getWidth() / 2) - 75, 50, 150, 300, this);
		g.drawImage(new ImageIcon(getClass().getResource("/img/gameOverText.png")).getImage(), (getWidth() / 2) - 100, (getHeight() / 2) + 100, 200, 100, this);
		g.setFont(FONT_UBUNTU);
		g.setColor(Color.BLACK);
		g.drawString(seconds + " Segundos", (getWidth() / 2) - 75, getHeight() - 60);
		repaint();
	}
}