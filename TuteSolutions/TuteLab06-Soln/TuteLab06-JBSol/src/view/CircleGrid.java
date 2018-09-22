package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CircleColours;

@SuppressWarnings("serial")
public class CircleGrid extends JPanel
{

	public CircleGrid(int gridX, int gridY)
	{
		CircleColours[] colours = CircleColours.values();
		setLayout(new GridLayout(gridY, gridX, 15, 7));
		// create labels for each cell
		for (int i = 0; i < gridX; i++)
		{
			for (int j = 0; j < gridY; j++)
			{
				add(new JLabel(colours[(int) (Math.random() * colours.length)].getIcon()));
			}
		}

	}

}
