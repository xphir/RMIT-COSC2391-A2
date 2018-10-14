import javax.swing.SwingUtilities;

import model.CircleModel;
import model.CircleModelImpl;
import view.CircleFrame;

public class TuteLab08
{
	public static final int GRID_X = 6, GRID_Y = 4;

	public static void main(String[] args)
	{
		final CircleModel model = new CircleModelImpl(GRID_X, GRID_Y);
		SwingUtilities.invokeLater(() -> new CircleFrame(model));
	}

}
