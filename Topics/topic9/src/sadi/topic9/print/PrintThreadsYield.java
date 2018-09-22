package sadi.topic9.print;

//refactored by Caspar
public class PrintThreadsYield
{
	public static void main(String args[])
	{
		Thread pT1 = new PrintThread(10000);
		pT1.start();
		Thread pT2 = new PrintThreadYield(20000);
		pT2.start();
		System.out.println("exiting main");
	}
}
