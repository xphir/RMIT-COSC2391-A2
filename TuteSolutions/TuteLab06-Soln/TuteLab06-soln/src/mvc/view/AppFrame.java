package mvc.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AppFrame extends JFrame
{
	private AppFrame()
	{
		super("AWT/Swing Tutelab Exercises");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(new CircleToolBar(), BorderLayout.NORTH);
		add(new CirclePanel(), BorderLayout.CENTER);
		add(new StatusBarPanel(), BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		new AppFrame();
	}
}