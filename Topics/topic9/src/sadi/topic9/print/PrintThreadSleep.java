package sadi.topic9.print;

//refactored by Caspar
class PrintThreadSleep extends AbstractPrintThread
{
	private int sleepAtNum;

	public PrintThreadSleep(int val)
	{
		super(val);
	}

	public PrintThreadSleep(int val, int priority)
	{
		super(val, priority);
	}

	public PrintThreadSleep(int val, int priority, int sleepAtNum)
	{
		this(val, priority);
		this.sleepAtNum = sleepAtNum;
	}

	@Override
	protected void doSomething(int i)
	{
		// this method is called by the superclass (it is a template method)
		try
		{
			if (i == sleepAtNum)
				Thread.sleep(100);
		} catch (InterruptedException ex)
		{
		}
	}
}