package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controllers.Controller;
import models.Enemy;
import models.Player;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanelGame jPanelGame;

	public MainWindow(Controller controller) {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setIconImage(new ImageIcon(getClass().getResource("/img/ball.png")).getImage());
		jPanelGame = new JPanelGame();
		jPanelGame.setFocusable(true);
		jPanelGame.addKeyListener(controller);
		add(jPanelGame, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void setPlayer(Player player){
		jPanelGame.setPlayer(player);
	}
	
	public int[] getSizePanel(){
		return new int[]{getWidth(), getHeight()};
	}

	public void setEnemy(Enemy enemy) {
		jPanelGame.setEnemy(enemy);
	}
}