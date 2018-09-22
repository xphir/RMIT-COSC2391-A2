package sadi.topic9.print;

//refactored by Caspar
public class PrintThreadsPriority
{
	public static void main(String args[])
	{
		// second param is priority
		Thread pT1 = new PrintThread(10000, Thread.NORM_PRIORITY);
		pT1.start();
		Thread pT2 = new PrintThread(20000, Thread.MAX_PRIORITY);
		pT2.start();
	}
}
