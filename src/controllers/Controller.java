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
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}