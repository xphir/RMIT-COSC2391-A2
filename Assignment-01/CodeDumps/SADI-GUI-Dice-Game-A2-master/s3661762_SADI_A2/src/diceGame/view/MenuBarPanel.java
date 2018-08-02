package diceGame.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import diceGame.Controller.ExitController;
import model.interfaces.GameEngine;

public class MenuBarPanel extends JMenuBar {

	private JMenu options;
	private JMenuItem exit;

	/*
	 * MenuBarPanel constructor that creates a menu, Options, and adds menu item, Exit, to the
	 * menu
	 */
	public MenuBarPanel(GameEngine gameEngine, DiceGameFrame frame) {
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		options = new JMenu("Options");
		add(options);
		ExitController exitController = new ExitController(frame, gameEngine);
		options.addSeparator();
		exit = new JMenuItem("Exit");
		exit.addActionListener(exitController);

		options.add(exit);

	}
}
