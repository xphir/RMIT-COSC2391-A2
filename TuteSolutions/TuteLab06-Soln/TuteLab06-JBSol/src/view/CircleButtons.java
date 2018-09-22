package view;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import model.CircleColours;

@SuppressWarnings("serial")
public class CircleButtons extends JToolBar
{
	private JToggleButton[] buttons;
	private ButtonGroup group;

	public CircleButtons()
	{
		CircleColours[] colours = CircleColours.values();
		
		buttons = new JToggleButton[colours.length];
		group = new ButtonGroup();

		add(Box.createHorizontalGlue());
		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i] = new JToggleButton(colours[i].getIcon());
			group.add(buttons[i]);
			add(buttons[i]);
		}
		add(Box.createHorizontalGlue());
		setFloatable(false);
	}
}
