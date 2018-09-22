package sadi.topic9.print;

//refactored by Caspar
class PrintThread extends AbstractPrintThread
{
	public PrintThread(int val)
	{
		super(val);
	}

	public PrintThread(int val, int priority)
	{
		super(val, priority);
	}

	// do nothing extra
	@Override
	protected void doSomething(int i)
	{
	}
}