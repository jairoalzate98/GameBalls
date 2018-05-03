package views;

import javax.swing.JFrame;

import controllers.Controller;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainWindow(Controller controller) {
		setTitle("Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
}