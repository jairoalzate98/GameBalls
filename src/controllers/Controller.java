package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import models.ManagerGame;
import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private ManagerGame managerGame;
	private Timer timer;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		managerGame = new ManagerGame(mainWindow.getSizePanel()[0], mainWindow.getSizePanel()[1], 20);
		mainWindow.setPlayer(managerGame.getPlayer());
		mainWindow.setEnemy(managerGame.getEnemy());
	}

	public Timer getTimer() {
		return timer;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()) == "Arriba") {
			moveUp();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Abajo"){
			moveDown();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Derecha"){
			moveRight();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Izquierda"){
			moveLeft();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()) == "Arriba") {
			moveUp();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Abajo"){
			moveDown();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Derecha"){
			moveRight();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Izquierda"){
			moveLeft();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (KeyEvent.getKeyText(e.getKeyCode()) == "Arriba") {
			moveUp();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Abajo"){
			moveDown();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Derecha"){
			moveRight();
		}else if(KeyEvent.getKeyText(e.getKeyCode()) == "Izquierda"){
			moveLeft();
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