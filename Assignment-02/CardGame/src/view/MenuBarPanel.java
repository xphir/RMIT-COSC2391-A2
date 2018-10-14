package view;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.ExitController;
import model.interfaces.GameEngine;

public class MenuBarPanel extends JMenuBar {

	private JMenu options;
	private JMenuItem exit;

	/*
	 * MenuBarPanel constructor that creates a menu, Options, and adds menu item, Exit, to the
	 * menu
	 */
	public MenuBarPanel(GameEngine gameEngine, CardGameFrame frame) {
		options = new JMenu("Options");

		options = new JMenu("Options");
		options.setMnemonic(KeyEvent.VK_F);
		add(options);
		
		ExitController exitController = new ExitController(frame, gameEngine);
		options.addSeparator();
		
		exit = new JMenuItem("Exit", KeyEvent.VK_X);
		exit.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.ALT_MASK));
		exit.addActionListener(exitController);
		options.add(exit);

}
}