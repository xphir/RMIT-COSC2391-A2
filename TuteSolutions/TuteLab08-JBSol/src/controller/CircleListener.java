package controller;

import java.awt.Point;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.CircleModel;

public class CircleListener extends MouseAdapter
{
	private final CircleModel model;
	private final Point location;

	public CircleListener(CircleModel model, Point location)
	{
		this.model = model;
		this.location = location;
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// update circle colour
		model.changeCircle(location);
	}

}
