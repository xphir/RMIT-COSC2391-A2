package sadi.topic9.print;

//refactored by Caspar
class PrintThreadJoin extends AbstractPrintThread
{
	private Thread otherThread;

	public PrintThreadJoin(int val)
	{
		super(val);
	}

	public PrintThreadJoin(int val, Thread otherThread)
	{
		this(val);
		this.otherThread = otherThread;
	}

	@Override
	protected void doSomething(int i)
	{
		// this method is called by the superclass (it is a template method)
		// after 50 iterations stop and wait for the other thread to finish
		try
		{
			if (i == initial + 50)
				otherThread.join();
		} catch (InterruptedException ex)
		{
		}
	}
}