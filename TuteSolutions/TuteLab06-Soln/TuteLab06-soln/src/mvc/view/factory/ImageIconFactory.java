package mvc.view.factory;

import java.io.File;

import javax.swing.ImageIcon;

// This is a simple solution to get an ImageIcon but not very efficient/elegant, see if you can do better!
public class ImageIconFactory
{
	private static final String[] FILE_STRINGS = new String[] { "circle_blue.png", "circle_green.png",
			"circle_orange.png", "circle_red.png", "circle_yellow.png" };

	public static final int NUM_COLORS = FILE_STRINGS.length;

	public static ImageIcon getImageIcon(int i)
	{
		return new ImageIcon(String.format("images%s%s", File.separator, FILE_STRINGS[i]));
	}
}
