package sadi.topic9.shared;

public class SharedObject
{
	// access this from two threads and show that this attribute is shared
	// between threads
	private boolean state;

	public boolean isState()
	{
		return state;
	}

	public void setState(boolean paramState)
	{
		boolean localState = paramState;
		this.state = paramState;

		// check then act
		if (!state)
			// do something
			;

		System.out.println("thread: " + Thread.currentThread().getId()
				+ ", paramState=" + paramState);
		System.out.println("thread: " + Thread.currentThread().getId()
				+ ", localState=" + localState);
		System.out.println("thread: " + Thread.currentThread().getId()
				+ ", this.state=" + this.state);
	}
}
