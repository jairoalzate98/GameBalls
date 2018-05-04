package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import models.ManagerGame;
import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private ManagerGame managerGame;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		managerGame = new ManagerGame(mainWindow.getWidth(), mainWindow.getHeight());
		mainWindow.setPlayer(managerGame.getPlayer());
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
		mainWindow.setPlayer(managerGame.getPlayer());
		mainWindow.revalidate();
		mainWindow.repaint();
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
		mainWindow.setPlayer(managerGame.getPlayer());
		mainWindow.revalidate();
		mainWindow.repaint();
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
		mainWindow.setPlayer(managerGame.getPlayer());
		mainWindow.revalidate();
		mainWindow.repaint();
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