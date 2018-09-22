package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum CircleColours
{
	BLUE("img/circle_blue.png"), GREEN("img/circle_green.png"), ORANGE("img/circle_orange.png"), RED(
			"img/circle_red.png"), YELLOW("img/circle_yellow.png");
	private final ImageIcon icon;

	CircleColours(String filename)
	{
		icon = new ImageIcon(filename);
	}

	public Icon getIcon()
	{
		return icon;
	}

}
