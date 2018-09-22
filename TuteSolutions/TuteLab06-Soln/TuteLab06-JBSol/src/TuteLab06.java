import javax.swing.SwingUtilities;

import view.CircleFrame;

public class TuteLab06
{
	private static final int GRID_X = 6, GRID_Y = 4;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(() -> new CircleFrame(GRID_X, GRID_Y));
	}

}
