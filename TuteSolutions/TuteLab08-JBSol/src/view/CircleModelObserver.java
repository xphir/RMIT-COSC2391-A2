package view;

import java.awt.Point;

import model.CircleModel;

public interface CircleModelObserver
{
	public abstract void colourChanged(CircleModel model);

	public abstract void circleChanged(CircleModel model, Point location);
}
