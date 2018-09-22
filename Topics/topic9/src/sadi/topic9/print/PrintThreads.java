package sadi.topic9.print;

//refactored by Caspar
public class PrintThreads
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("In Main Before Thread Creation");
		Thread pT1 = new PrintThread(10000); // First Thread instance
		pT1.start(); // First Thread started
		Thread pT2 = new PrintThread(20000); // Second Thread instance
		pT2.start(); // Second Thread started
		// PrintThread pT3 = new PrintThread(50000);
		// pT3.start();
		System.out.println("In main After Thread Creation");
	}
}
