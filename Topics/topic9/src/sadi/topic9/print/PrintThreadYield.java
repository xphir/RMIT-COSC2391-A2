package sadi.topic9.print;

// refactored by Caspar
class PrintThreadYield extends PrintThread
{
	public PrintThreadYield(int val)
	{
		super(val);
	}

	public PrintThreadYield(int val, int priority)
	{
		super(val, priority);
	}

	@Override
	protected void doSomething(int i)
	{
		// doesn't do as much on unloaded multicore system unless we set
		// processor affinity for javaw.exe
		// to use one core (via task manager in Windows)
		// the more we call yield() the bigger difference we see
		//for (int j = 0; j < 10; j++)
		//yield();
	}
}