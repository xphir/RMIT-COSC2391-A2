package mvc.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import mvc.view.factory.ImageIconFactory;

public class CirclePanel extends JPanel
{
	public static final int NUM_VIEWS = 16;

	public CirclePanel()
	{
		setLayout(new GridLayout((int) Math.sqrt(NUM_VIEWS), (int) Math.sqrt(NUM_VIEWS)));

		for (int i = 0; i < NUM_VIEWS; i++)
			// add the new button to the frame (just generate a pseudo-random color using modulus '%' operator)
			add(new CircleView(i % ImageIconFactory.NUM_COLORS));
	}
}
