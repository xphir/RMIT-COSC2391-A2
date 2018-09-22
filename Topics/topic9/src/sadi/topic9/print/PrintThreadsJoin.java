package sadi.topic9.print;

public class PrintThreadsJoin
{
	public static void main(String args[])
	{
		Thread pT1 = new PrintThread(10000);
		pT1.start();
		Thread pT2 = new PrintThreadJoin(20000, pT1);
		pT2.start();
	}
}
