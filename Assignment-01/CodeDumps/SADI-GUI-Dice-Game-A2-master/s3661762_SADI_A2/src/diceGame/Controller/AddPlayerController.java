package diceGame.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import diceGame.view.*;
import model.SimplePlayer;
import model.interfaces.GameEngine;

public class AddPlayerController implements ActionListener {

	private DiceGameFrame diceGameFrame;
	private GameEngine model;
	private JTextField playerID;
	private JTextField name;
	private JTextField points;

	public AddPlayerController(DiceGameFrame diceGameFrame, GameEngine model, JTextField playerID, JTextField name,
			JTextField points) {
		this.diceGameFrame = diceGameFrame;
		this.model = model;
		this.playerID = playerID;
		this.name = name;
		this.points = points;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * validating that all fields for ID, name and initial Points have been entered,
		 * or else and error message will pop up
		 */
		// TODO Auto-generated method stub
		try {
			if (points.getText().equals("") || name.getText().equals("") || playerID.equals("")) {
				JOptionPane.showMessageDialog(diceGameFrame,
						"Error: Make sure all fields for ID, name and initial points are entered.");
				/* validating that initial points entered is not <=0 */
			} else if (Integer.parseInt(points.getText()) == 0 || Integer.parseInt(points.getText()) < 0) {
				JOptionPane.showMessageDialog(diceGameFrame, "Error: Invalid number of points entered");
			} else {
				SimplePlayer newplayer = new SimplePlayer(playerID.getText(), name.getText(),
						Integer.parseInt(points.getText()));

				System.out.println(newplayer);
				model.addPlayer(newplayer);
				if (e.getSource().equals(diceGameFrame.getOptionsPanel().getButton1())) {
					/*
					 * adding the player to the JComboBox after all validation tests pass
					 * successfully
					 */
					diceGameFrame.getOptionsPanel().getSelectPlayer().addItem(newplayer.getPlayerName());
				}
			}
		} catch (NumberFormatException nfe) {

			JOptionPane.showMessageDialog(diceGameFrame, "Error: Invalid number of points entered");

		}
	}
}
