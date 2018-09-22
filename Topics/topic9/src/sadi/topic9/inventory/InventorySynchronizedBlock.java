package sadi.topic9.inventory;

// WORKING class for managing inventory of items
// refactored by Caspar to remove duplication
class InventorySynchronizedBlock extends AbstractInventory
{
	// use a seperate lock object but could use 'this'
	private Object lock = new Object();

	public InventorySynchronizedBlock(int num, int initial)
	{
		super(num, initial);
	}

	// synchronized block with notify() avoids race condition
	public void replenish(int index, int qty)
	{
		synchronized (lock)
		{
			super.replenish(index, qty);
			lock.notify();
		}
	}

	// synchronized block with wait() avoids race condition
	public void withdraw(int index, int qty) throws InterruptedException
	{
		// could synchronize on 'this' as well
		synchronized (lock)
		{
			// efficient, blocks until stock become available
			// (and relinquishes lock so replenish() can
			// proceed)
			// while (stock[index] < qty)
			while (stock.get(index) < qty)
				lock.wait();
			super.withdraw(index, qty);
		}
	}
}