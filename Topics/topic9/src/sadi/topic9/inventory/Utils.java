package sadi.topic9.inventory;

import java.util.Scanner;

public class Utils
{
	@SuppressWarnings("resource")
	public static void waitForKeyboardEnter()
	{
		// suppress warning since we don't really wan't to close System.in!
		new Scanner(System.in).nextLine();
	}
}
