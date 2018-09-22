package mvc.view;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import mvc.view.factory.ImageIconFactory;

public class CircleToolBar extends JToolBar
{
	private AbstractButton[] buttons = new AbstractButton[ImageIconFactory.NUM_COLORS];
	private ButtonGroup group = new ButtonGroup();

	public CircleToolBar()
	{
		// loop through all the colors
		for (int i = 0; i < ImageIconFactory.NUM_COLORS; i++)
		{
			// create button with an image from the factory class
			buttons[i] = new JToggleButton(ImageIconFactory.getImageIcon(i));
			// set border style
			buttons[i].setBorder(BorderFactory.createRaisedBevelBorder());
			// set the first button as the default selection
			if (i == 0)
				buttons[i].setSelected(true);

			// add buttons to group for radio behaviour
			group.add(buttons[i]);
			// add button to toolbar
			add(buttons[i]);
		}
	}
}
