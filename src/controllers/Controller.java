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
	
	public Controller() {
		mainWindow = new MainWindow(this);
		managerGame = new ManagerGame(mainWindow.getSizePanel()[0], mainWindow.getSizePanel()[1], 10);
		mainWindow.setPlayer(managerGame.getPlayer());
		mainWindow.setEnemy(managerGame.getEnemy());
		start();
	}

	private void start() {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerGame.isGamePlay()) {
					count++;
					mainWindow.setLabel(count);
				}else{
					timer.stop();
					mainWindow.gameOver();
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
}