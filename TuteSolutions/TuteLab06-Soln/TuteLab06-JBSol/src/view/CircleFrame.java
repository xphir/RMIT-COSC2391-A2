package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CircleFrame extends JFrame
{
	private CircleGrid display;
	private StatusBar status;
	private CircleButtons toolbar;

	public CircleFrame(int gridX, int gridY)
	{
		// title
		super("SADI Tutelab 06");
		
		// create sections
		display = new CircleGrid(gridX, gridY);
		status = new StatusBar();
		toolbar = new CircleButtons();
		
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
