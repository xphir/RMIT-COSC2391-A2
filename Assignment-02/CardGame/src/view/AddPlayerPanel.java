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

	public static final int NUM_VIEWS = 4;
	private JButton button1;
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

	public JButton getButton1() {
		return button1;
	}

	public AddPlayerPanel(GameEngine gameEngine, CardGameFrame frame) {

		selectPlayer = new JComboBox<>();
		this.setLayout(new FlowLayout());
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		JLabel enterID = new JLabel("Enter ID: ");
		id = new JTextField("001");
		add(enterID);
		add(id);
		JLabel name = new JLabel("Enter Name: ");
		enterName = new JTextField("John Snow");
		add(name);
		add(enterName);
		add(enterName, BorderLayout.WEST);
		JLabel initialPoints = new JLabel("Enter Initial Points: ");
		points = new JTextField("1000");
		add(initialPoints);
		add(points, BorderLayout.CENTER);
		AddPlayerController addPlayer = new AddPlayerController(frame, gameEngine, id, enterName, points);
		button1 = new JButton("Add Player");
		button1.addActionListener(addPlayer);
		add(button1);
		add(selectPlayer);

	}

}
