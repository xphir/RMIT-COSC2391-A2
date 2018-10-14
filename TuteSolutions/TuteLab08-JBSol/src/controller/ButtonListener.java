package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.CircleColours;
import model.CircleModel;

public class ButtonListener implements ActionListener
{
	private CircleModel model;
	private CircleColours colour;

	public ButtonListener(CircleModel model, CircleColours colour)
	{
		this.model = model;
		this.colour = colour;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// switch threads for any "long running" operations
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				model.setSelectedColour(colour);
			}
		}).start();

	}

}
