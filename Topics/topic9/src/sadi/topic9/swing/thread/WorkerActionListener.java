package sadi.topic9.swing.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WorkerActionListener implements ActionListener
{
	private WorkerFrame workerFrame;
	SimpleSwingWorker task;

	public WorkerActionListener(WorkerFrame workerFrame)
	{
		task = new SimpleSwingWorker(workerFrame);
		this.workerFrame = workerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// uncomment to hang UI
		// Utilities.wait5secs();

		// create new instance since can only execute once

		// optional, used for the progress bar only
		task.addPropertyChangeListener(new PropertyChangeListener()
		{
			// propertyChange called on AWT thread
			public void propertyChange(PropertyChangeEvent evt)
			{
				if ("progress".equals(evt.getPropertyName()))
					workerFrame.setProgress((Integer) evt.getNewValue());
			}
		});

		task.execute();
	}
}
