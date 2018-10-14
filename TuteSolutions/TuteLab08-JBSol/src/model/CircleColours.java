package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum CircleColours
{
	BLUE, GREEN, ORANGE, RED, YELLOW;

	private static final String FILE_PREFIX = "img/circle_";
	private static final String FILE_SUFFIX = ".png";

	private final ImageIcon icon;

	CircleColours()
	{
		icon = new ImageIcon(FILE_PREFIX + name().toLowerCase() + FILE_SUFFIX);
	}

	public Icon getIcon()
	{
		return icon;
	}

	public String getDisplayName()
	{
		// BLUE => Blue, etc.
		return name().substring(0, 1) + name().substring(1).toLowerCase();
	}

}
