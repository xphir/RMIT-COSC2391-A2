package sadi.topic9.inventory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// WORKING class for managing inventory of items using java.util.concurrent.locks functionality
// written by Caspar 
class InventoryLocks extends AbstractInventory
{
	// use an explicit lock instead of synchronized methods
	private volatile ReentrantLock lock = new ReentrantLock();
	// this replaces the Object.wait() and notify() methods
	private volatile Condition condition = lock.newCondition();

	public InventoryLocks(int num, int initial)
	{
		super(num, initial);
	}

	// compare with InventorySynchronized class
	public void replenish(int index, int qty)
	{
		lock.lock();
		try
		{
			super.replenish(index, qty);
			condition.signal();
			// could signalAll instead but most will go back to sleep straight away
			//condition.signalAll();
		} finally
		{
			lock.unlock();
		}
	}

	// compare with InventorySynchronized class
	public void withdraw(int index, int qty) throws InterruptedException
	{
		lock.lock();
		try
		{
			while (stock.get(index) < qty)
				condition.await();

			super.withdraw(index, qty);
		} finally
		{
			lock.unlock();
		}
	}
}