package view;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JPanel;

import model.CircleModel;

@SuppressWarnings("serial")
public class CircleGrid extends JPanel
{

	public CircleGrid(CircleModel model)
	{
		setLayout(new GridLayout(model.getGridY(), model.getGridX(), 15, 7));
		// create labels for each cell
		CircleLabel temp;
		for (int y = 0; y < model.getGridY(); y++)
		{
			for (int x = 0; x < model.getGridX(); x++)
			{
				temp = new CircleLabel(model, new Point(x, y));
				add(temp);
			}
		}
	}

}
