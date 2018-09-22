package sadi.topic9.print;

//refactored by Caspar
public abstract class AbstractPrintThread extends Thread
{
	protected int initial;

	public AbstractPrintThread(int val)
	{
		super();
		initial = val;
	}

	public AbstractPrintThread(int val, int priority)
	{
		this(val);
		setPriority(priority);
	}

	@Override
	public void run() // overriding the run method
	{
		for (int i = initial; i <= initial + 100; i++)
		{
			System.out.print(" " + i);

			// line break .. but all threads write to same console so doesn't
			// work that well :P
			if ((i % 9) == 0)
				System.out.println();

			// this is a utility (template) method we can override
			doSomething(i);
		}
	}

	// default is to do nothing
	protected abstract void doSomething(int i);
}