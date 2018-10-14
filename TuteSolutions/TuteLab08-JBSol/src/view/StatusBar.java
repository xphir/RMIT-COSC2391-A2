package view;

import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import model.CircleColours;
import model.CircleModel;

@SuppressWarnings("serial")
public class StatusBar extends JPanel implements CircleModelObserver
{
	private JLabel status1;
	private JLabel status2;
	private JLabel status3;

	public StatusBar(CircleModel model)
	{
		status1 = new JLabel("status 1", SwingConstants.LEFT);
		status2 = new JLabel("status 2", SwingConstants.CENTER);
		status3 = new JLabel("status 3", SwingConstants.RIGHT);
		Border border = BorderFactory.createRaisedBevelBorder();
		status1.setBorder(border);
		status2.setBorder(border);
		status3.setBorder(border);

		setLayout(new GridLayout(1, 3));
		// add three labels
		add(status1);
		add(status2);
		add(status3);

		model.addColourChangeObserver(this);
	}

	@Override
	public void colourChanged(CircleModel model)
	{
		// isEDT can be used to check whether the current thread is the EDT
		// System.out.println(SwingUtilities.isEventDispatchThread());

		// updates to the GUI !!MUST!! be done on the EDT
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				setStatus(model.getSelectedColour());
			}
		});
	}

	private void setStatus(CircleColours colour)
	{
		status1.setText(colour.getDisplayName() + " selected");
	}

	@Override
	public void circleChanged(CircleModel model, Point location)
	{
		// is not a circle
	}

}
