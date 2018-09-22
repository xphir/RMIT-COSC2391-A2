package sadi.topic7.observer;

import java.util.Observable;
import java.util.Observer;

class EventObserver implements Observer
{
	@Override
	public void update(Observable obj, Object arg)
	{
		System.out.println("\nReceived Response: " + arg);
	}
}
