package sadi.topic9.print;

//refactored by Caspar
public class RunnableThreads
{
	// assume we already have a non threaded class that does something
	// NOTE: static inner class does not have any special inner class behaviour
	// but they are hidden from the package
	private static class Fibo
	{
		private int first = 1;
		private int second = 1;
		int term = 1;

		public int getNext()
		{
			int val;
			if (term == 1)
				val = 1;
			else
			{
				val = first + second;
				first = second;
				second = val;
			}
			term++;
			return val;
		}
	}

	// now extend it and make it runnable
	private static class RunnableFibo extends Fibo implements Runnable
	{
		@Override
		public void run()
		{
			for (int i = 1; i <= 30; i++)
				System.out.print(" F(" + i + ")=" + getNext());
		}
	}

	public static void main(String args[])
	{
		Thread pT1 = new PrintThread(10000);
		pT1.start();
		Thread fT = new Thread(new RunnableFibo());
		fT.start();
	}
}

// not allowed to have private class that is not an inner class!
//private class Illegal
//{
//	
//}
