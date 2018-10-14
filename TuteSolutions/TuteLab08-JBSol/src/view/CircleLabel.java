package view;

import java.awt.Point;

import javax.swing.JLabel;

import controller.CircleListener;
import model.CircleColours;
import model.CircleModel;

@SuppressWarnings("serial")
public class CircleLabel extends JLabel implements CircleModelObserver
{
	/**
	 * Location of circle in grid
	 */
	private final Point location;

	public CircleLabel(CircleModel model, Point location)
	{
		this.location = location;

		setAlignmentX(CENTER_ALIGNMENT);
		setAlignmentY(CENTER_ALIGNMENT);

		this.addMouseListener(new CircleListener(model, location));
		model.addCircleChangeObserver(this);
		setColour(model.getCircleColour(this.location));
	}

	public void setColour(CircleColours colour)
	{
		setIcon(colour.getIcon());
	}

	@Override
	public void colourChanged(CircleModel model)
	{
		// circles don't change when buttons are selected
	}

	@Override
	public void circleChanged(CircleModel model, Point location)
	{
		// only update if this circle changed
		if (this.location.equals(location))
		{
			setColour(model.getCircleColour(this.location));
		}
	}
}
