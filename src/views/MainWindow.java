package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controllers.Controller;
import models.Player;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanelGame jPanelGame;

	public MainWindow(Controller controller) {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		jPanelGame = new JPanelGame();
		add(jPanelGame, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void setPlayer(Player player){
		jPanelGame.setPlayer(player);
	}
}