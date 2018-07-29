package sadi.tutelab1.solution;

import java.util.Scanner;

public class ScannerUtils
{
	// this is a good example of a static general purpose reusable utility method
	// so we make it static and put it in a separate class
	public static double nextDoubleValidated(String prompt)
	{
		// We don't want to close System.in otherwise we won't be able to input any more!
		// so we just suppress the warning
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		double num = 0.0;
		boolean doAgain = true;
		do
		{
			System.out.print(prompt);
			if (scanner.hasNextDouble())
			{
				num = scanner.nextDouble();
				doAgain = false;
			}
			else
				scanner.nextLine();
		}
		while (doAgain == true);

		return num;
	}
}
