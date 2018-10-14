package model;

import java.awt.Point;

import view.CircleModelObserver;

public interface CircleModel
{
	public abstract int getGridY();

	public abstract int getGridX();

	public abstract void addColourChangeObserver(CircleModelObserver listener);

	public abstract void addCircleChangeObserver(CircleModelObserver listener);

	public abstract void setSelectedColour(CircleColours colour);

	public abstract void changeCircle(Point location);

	public abstract CircleColours getSelectedColour();

	public abstract CircleColours getCircleColour(Point location);
}
