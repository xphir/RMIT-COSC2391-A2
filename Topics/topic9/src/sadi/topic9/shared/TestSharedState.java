package sadi.topic9.shared;

//example by Caspar to show multiple threads executing on a single object
//sem 1, 2015
public class TestSharedState
{
	public static void main(String args[]) throws Exception
	{
		final SharedObject sharedObject = new SharedObject();

		// run two threads on same object
		new Thread()
		{
			@Override
			public void run()
			{
				sharedObject.setState(true);
			}
		}.start();

		new Thread()
		{
			@Override
			public void run()
			{
				sharedObject.setState(false);
			}
		}.start();

		System.out.println("In main After Thread Creation");
	}
}
