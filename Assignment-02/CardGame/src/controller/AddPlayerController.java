package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.CardGameFrame;

import model.SimplePlayer;
import model.interfaces.GameEngine;

//Add players (including name and initial betting points balance)
public class AddPlayerController implements ActionListener
{
	private CardGameFrame cardGameFrame;
	private GameEngine model;

	private int playerID = 0;
	private JTextField name;
	private JTextField points;

	public AddPlayerController(CardGameFrame cardGameFrame, GameEngine model, JTextField name, JTextField points)
	{
		this.cardGameFrame = cardGameFrame;
		this.model = model;
		this.name = name;
		this.points = points;

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if (points.getText().equals("") || name.getText().equals(""))
			{
				JOptionPane.showMessageDialog(cardGameFrame, "Error: Make sure all fields for Name and initial points are entered.");
				/* validating that initial points entered is not <=0 */
			}
			else if (Integer.parseInt(points.getText()) == 0 || Integer.parseInt(points.getText()) < 0)
			{
				JOptionPane.showMessageDialog(cardGameFrame, "Error: Invalid number of points entered");
			}
			else
			{
				// Add player
				++playerID;
				SimplePlayer newplayer = new SimplePlayer(Integer.toString(playerID), name.getText(), Integer.parseInt(points.getText()));
				System.out.println(newplayer);
				model.addPlayer(newplayer);
				// Update Player List
				if (e.getSource().equals(cardGameFrame.getPlayerPanel().getButton1()))
				{
					// adding the player to the JComboBox after all validation tests
					// pass successfully
					cardGameFrame.getPlayerPanel().getSelectPlayer().addItem(newplayer.getPlayerName());
					// Update Summary Panel
					cardGameFrame.getSummaryPanel().addTableRow(newplayer.getPlayerId(), newplayer.getPlayerName(), newplayer.getPoints());
				}

				
			}
		}
		catch (NumberFormatException nfe)
		{

			JOptionPane.showMessageDialog(cardGameFrame, "Error: Invalid number of points entered");

		}
	}
}
