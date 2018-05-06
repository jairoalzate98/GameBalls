package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controllers.Controller;
import models.Boos;
import models.Enemy;
import models.Player;
import models.Shooting;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanelGame jPanelGame;
	private JLabel jlTime;
	private JPanelGameOver jPanelGameOver;

	public MainWindow(Controller controller) {
		setTitle("Tom y Jerry");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		setIconImage(new ImageIcon(getClass().getResource("/img/icono.png")).getImage());
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

	public void setEnemy(ArrayList<Enemy> enemy) {
		jPanelGame.setEnemy(enemy);
	}
	
	public void setShoot(ArrayList<Shooting> shoots){
		jPanelGame.setShootingList(shoots);
	}
	
	public void gameOver(String count){
		remove(jPanelGame);
		remove(jlTime);
		jPanelGameOver = new JPanelGameOver();
		jPanelGameOver.setSeconds(count);
		add(jPanelGameOver, BorderLayout.CENTER);
		revalidate();
		repaint();
	}

	public void setInformation(Player player, ArrayList<Enemy> enemy, ArrayList<Shooting> shootList, Boos boos) {
		jPanelGame.setPlayer(player);
		jPanelGame.setEnemy(enemy);
		jPanelGame.setShootingList(shootList);
		jPanelGame.setBoos(boos);
		jPanelGame.repaint();
	}
	
	public void setBoos(Boos boos){
		jPanelGame.setBoos(boos);
	}
}