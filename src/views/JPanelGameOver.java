package views;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelGameOver extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelGameOver() {
		setLayout(new FlowLayout());
		add(new JLabel(new ImageIcon(getClass().getResource("/img/GameOver.png"))));
		add(new JLabel(new ImageIcon(getClass().getResource("/img/gameOverText.png"))));
	}
}