package sadi.topic9.print;

public class PrintThreadsSleep
{
	public static void main(String args[])
	{
		Thread pT1 = new PrintThreadSleep(10000, Thread.MAX_PRIORITY, 10050);
		pT1.start();
		Thread pT2 = new PrintThread(20000, Thread.MAX_PRIORITY);
		pT2.start();
	}
}
