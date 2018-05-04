package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controllers.Controller;
import models.Enemy;
import models.Player;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanelGame jPanelGame;
	private JLabel jlTime;

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
		jlTime = new JLabel("0 seg", SwingConstants.CENTER);
		add(jlTime, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void setLabel(int count){
		jlTime.setText(count + " seg");
		revalidate();
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