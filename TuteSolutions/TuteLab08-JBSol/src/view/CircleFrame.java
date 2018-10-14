package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import model.CircleModel;

@SuppressWarnings("serial")
public class CircleFrame extends JFrame
{
	private CircleGrid display;
	private StatusBar status;
	private CircleButtons toolbar;

	public CircleFrame(CircleModel model)
	{
		// title
		super("SADI Tutelab 08");

		// create sections
		display = new CircleGrid(model);
		status = new StatusBar(model);
		toolbar = new CircleButtons(model);

		display.setBorder(BorderFactory.createLoweredBevelBorder());

		// add sections
		add(display, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
		add(toolbar, BorderLayout.NORTH);

		// finish setup
		pack();
		setMinimumSize(getSize());
		// centered on screen
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
