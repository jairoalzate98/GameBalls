package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import models.ManagerGame;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements KeyListener{

	private MainWindow mainWindow;
	private ManagerGame managerGame;
	private Timer timer;
	private int count;
	private int i = 0;
	private Timer autoSave;
	private FileManager fileManager;
	
	public Controller() {
		fileManager = new FileManager();
		int option = JOptionPane.showConfirmDialog(mainWindow, "Quiere restaurar la ultima partida");
		if (option == JOptionPane.YES_OPTION) {
			try {			
				mainWindow = new MainWindow(this);
				managerGame = new ManagerGame(10);
				managerGame.setPlayer(fileManager.readPlayer());
				managerGame.setEnemyList(fileManager.readEnemys());
				managerGame.setBoos(fileManager.readBoos());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}else {
			mainWindow = new MainWindow(this);
			managerGame = new ManagerGame(mainWindow.getSizePanel()[0], mainWindow.getSizePanel()[1], 10);
		}
		mainWindow.setPlayer(managerGame.getPlayer());
		try{
			mainWindow.setEnemy(managerGame.getEnemy());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		mainWindow.setShoot(managerGame.getShootList());
		try{
			mainWindow.setBoos(managerGame.getBoos());			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		start();
		autoSave();
	}

	private void autoSave() {
		autoSave = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					fileManager.writeFileEnemy(managerGame.getEnemy());
					fileManager.writeFilePlayer(managerGame.getPlayer(), managerGame.getSleep());
					fileManager.writeFileBoos(managerGame.getBoos());
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		autoSave.start();
	}

	private void start() {
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerGame.isGamePlay() && !managerGame.isVictory()) {
					if (count == 100) {
						i++;
						count = 0;
						mainWindow.setLabel(i);
					}
					mainWindow.setInformation(managerGame.getPlayer(), managerGame.getEnemy(), managerGame.getShootList(), managerGame.getBoos());
					count++;
				}else{
					if (!managerGame.isGamePlay()) {
						timer.stop();
						mainWindow.gameOver(String.valueOf(i));
						autoSave.stop();
					}else if(managerGame.isVictory()){
						timer.stop();
						mainWindow.victory(String.valueOf(i));
						autoSave.stop();
					}
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