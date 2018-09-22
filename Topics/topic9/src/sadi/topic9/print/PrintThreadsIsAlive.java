package sadi.topic9.print;

public class PrintThreadsIsAlive
{
	public static void main(String args[]) throws InterruptedException
	{
		System.out.println("In main before creating threads");

		Thread pT1 = new PrintThread(10000); // First Thread instance
		pT1.start(); // First Thread started
		Thread pT2 = new PrintThread(20000); // Second Thread instance
		pT2.start();

		// wait until threads finish
		// this is CPU intensive so not the best way
		// comment this out to see the difference
		while (pT1.isAlive() || pT2.isAlive())
			;

		// .. could also use join()
		// pT1.join();
		// pT2.join();

		System.out.println("\nThreads have finished");
	}
}
