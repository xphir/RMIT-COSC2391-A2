package view;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import controller.ButtonListener;
import model.CircleColours;
import model.CircleModel;

@SuppressWarnings("serial")
public class CircleButtons extends JToolBar
{
	private JToggleButton[] buttons;
	private ButtonGroup group;

	public CircleButtons(CircleModel model)
	{
		CircleColours[] colours = CircleColours.values();

		buttons = new JToggleButton[colours.length];
		group = new ButtonGroup();

		add(Box.createHorizontalGlue());
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JToggleButton(colours[i].getIcon());
			
			buttons[i].addActionListener(new ButtonListener(model, colours[i]));
			group.add(buttons[i]);
			add(buttons[i]);
		}
		add(Box.createHorizontalGlue());
		setFloatable(false);

		// select blue button after GUI has finished being set up
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				buttons[0].doClick();
			}
		});
	}
}
