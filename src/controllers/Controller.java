package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import models.ManagerGame;
import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private ManagerGame managerGame;
	private Timer timer;
	private int count;
	private int i = 0;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		managerGame = new ManagerGame(mainWindow.getSizePanel()[0], mainWindow.getSizePanel()[1], 10);
		mainWindow.setPlayer(managerGame.getPlayer());
		mainWindow.setEnemy(managerGame.getEnemy());
		mainWindow.setShoot(managerGame.getShootList());
		start();
	}

	private void start() {
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerGame.isGamePlay()) {
					if (count == 100) {
						i++;
						count = 0;
						mainWindow.setLabel(i);
					}
					mainWindow.setInformation(managerGame.getPlayer(), managerGame.getEnemy(), managerGame.getShootList());
					count++;
				}else{
					timer.stop();
					mainWindow.gameOver(String.valueOf(i));
				}
			}
		});
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (managerGame.isGamePlay()) {
			if (KeyEvent.VK_UP == e.getKeyCode()) {
				moveUp();
			}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
				moveDown();
			}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				moveRight();
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
				moveLeft();
			}else if(KeyEvent.VK_D == e.getKeyCode()){
				shoot("d");
			}else if(KeyEvent.VK_A == e.getKeyCode()){
				shoot("a");
			}else if(KeyEvent.VK_W == e.getKeyCode()){
				shoot("w");
			}else if(KeyEvent.VK_S == e.getKeyCode()){
				shoot("s");
			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (managerGame.isGamePlay()) {
			if (KeyEvent.VK_UP == e.getKeyCode()) {
				moveUp();
			}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
				moveDown();
			}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				moveRight();
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
				moveLeft();
			}else if(KeyEvent.VK_D == e.getKeyCode()){
				shoot("d");
			}else if(KeyEvent.VK_A == e.getKeyCode()){
				shoot("a");
			}else if(KeyEvent.VK_W == e.getKeyCode()){
				shoot("w");
			}else if(KeyEvent.VK_X == e.getKeyCode()){
				shoot("s");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (managerGame.isGamePlay()) {
			if (KeyEvent.VK_UP == e.getKeyCode()) {
				moveUp();
			}else if(KeyEvent.VK_DOWN == e.getKeyCode()){
				moveDown();
			}else if(KeyEvent.VK_RIGHT == e.getKeyCode()){
				moveRight();
			}else if(KeyEvent.VK_LEFT == e.getKeyCode()){
				moveLeft();
			}else if(KeyEvent.VK_D == e.getKeyCode()){
				shoot(ManagerGame.D_LETTER);
			}else if(KeyEvent.VK_A == e.getKeyCode()){
				shoot(ManagerGame.A_LETTER);
			}else if(KeyEvent.VK_W == e.getKeyCode()){
				shoot(ManagerGame.W_LETTER);
			}else if(KeyEvent.VK_S == e.getKeyCode()){
				shoot(ManagerGame.S_LETTER);
			}
		}
	}

	private void moveLeft() {
		managerGame.moveLeft();
	}

	private void moveRight() {
		managerGame.moveRight();
	}

	private void moveDown() {
		managerGame.moveDown();
	}

	private void moveUp() {
		managerGame.moveUp();
	}
	
	private void shoot(String letter) {
		managerGame.shoot(mainWindow.getSizePanel()[0], mainWindow.getSizePanel()[1], letter);
	}
}