package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import view.CircleModelObserver;

public class CircleModelImpl implements CircleModel
{
	private final Collection<CircleModelObserver> colourChangeObservers;
	private final Collection<CircleModelObserver> circleChangeObservers;

	private final int gridX;
	private final int gridY;
	private CircleColours[][] circleColour;
	private CircleColours selectedColour;

	public CircleModelImpl(int gridX, int gridY)
	{
		this.gridX = gridX;
		this.gridY = gridY;

		this.circleChangeObservers = new ArrayList<>();
		this.colourChangeObservers = new ArrayList<>();

		this.circleColour = new CircleColours[gridX][gridY];

		CircleColours[] colourList = CircleColours.values();
		Random source = new Random();
		for (int i = 0; i < circleColour.length; i++)
		{
			for (int j = 0; j < circleColour[i].length; j++)
			{
				circleColour[i][j] = colourList[source.nextInt(colourList.length)];
			}
		}

		selectedColour = CircleColours.values()[0];
	}

	@Override
	public int getGridX()
	{
		return gridX;
	}

	@Override
	public int getGridY()
	{
		return gridY;
	}

	@Override
	public void addColourChangeObserver(CircleModelObserver listener)
	{
		colourChangeObservers.add(listener);
	}

	@Override
	public void addCircleChangeObserver(CircleModelObserver listener)
	{
		circleChangeObservers.add(listener);
	}

	@Override
	public void setSelectedColour(CircleColours colour)
	{
		// simulate "long running" operation
		// try
		// {
		// Thread.sleep(5000);
		// } catch (InterruptedException e)
		// {
		// }

		this.selectedColour = colour;

		notifyColour();
	}

	private void notifyColour()
	{
		for (CircleModelObserver circleModelObserver : colourChangeObservers)
		{
			circleModelObserver.colourChanged(this);
		}
	}

	@Override
	public void changeCircle(Point location)
	{
		circleColour[location.x][location.y] = selectedColour;

		notifyCircle(location);
	}

	private void notifyCircle(Point location)
	{
		for (CircleModelObserver circleModelObserver : circleChangeObservers)
		{
			circleModelObserver.circleChanged(this, location);
		}
	}

	@Override
	public CircleColours getSelectedColour()
	{
		return selectedColour;
	}

	@Override
	public CircleColours getCircleColour(Point location)
	{
		return circleColour[location.x][location.y];
	}

}
