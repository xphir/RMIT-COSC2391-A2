package sadi.topic9.inventory;

// WORKING class for managing inventory of items
// refactored by Caspar to remove duplication
class InventorySynchronized extends AbstractInventory
{
	public InventorySynchronized(int num, int initial)
	{
		super(num, initial);
	}

	// synchronized with notify() avoids race condition
	public synchronized void replenish(int index, int qty)
	{
		super.replenish(index, qty);
		this.notify();
		// could notifyAll instead but most will go back to sleep straight away
		//this.notifyAll();
	}

	// synchronized with wait() avoids race condition
	public synchronized void withdraw(int index, int qty)
			throws InterruptedException
	{
		// while (stock[index] < qty)
		while (stock.get(index) < qty)
			// efficient, blocks until stock becomes available
			// relinquishes lock so replenish() can proceed
			this.wait();

		super.withdraw(index, qty);
	}
}