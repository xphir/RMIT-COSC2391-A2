package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.AddPlayerController;
import model.interfaces.GameEngine;

//Add players (including name and initial betting points balance)
public class AddPlayerPanel extends JToolBar {

	//public static final int NUM_VIEWS = 4;
	private JButton addPlayerButton;

	private JComboBox<String> selectPlayer;
	private JTextField points;
	private JTextField id;
	private JTextField enterName;
	
	/*
	 * getters for the JTextFields, JComboBox and JButton in my options tool bar so
	 * they can easily be accessed
	 */
	public JTextField getId() {
		return id;
	}

	public JTextField getEnterName() {
		return enterName;
	}

	public JTextField getPoints() {
		return points;
	}

	public JComboBox<String> getSelectPlayer() {
		return selectPlayer;
	}

	public JButton getAddPlayerButtom() {
		return addPlayerButton;
	}

	public AddPlayerPanel(GameEngine gameEngine, CardGameFrame frame) {
		selectPlayer = new JComboBox<>();
		selectPlayer.setPrototypeDisplayValue("XXXXXXXXXXXXXXXX");
		this.setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		JLabel name = new JLabel("Enter Name: ");
		enterName = new JTextField("John Snow");
		add(name);
		add(enterName);
		add(enterName, BorderLayout.WEST);
		JLabel initialPoints = new JLabel("Enter Initial Points: ");
		points = new JTextField("1000");
		add(initialPoints);
		add(points, BorderLayout.CENTER);
		AddPlayerController addPlayer = new AddPlayerController(frame, gameEngine, enterName, points);
		addPlayerButton = new JButton("Add Player");
		addPlayerButton.addActionListener(addPlayer);
		add(addPlayerButton);
		add(selectPlayer);
	}
	

}
