package sadi.topic9.inventory;

// DEADLOCKED class for managing inventory of items
// refactored by Caspar to remove duplication
class InventoryDeadlock extends AbstractInventory
{
	public InventoryDeadlock(int num, int initial)
	{
		super(num, initial);
	}

	// synchronized without wait/notify causes a deadlock
	public void replenish(int index, int qty)
	{
		super.replenish(index, qty);
	}

	// synchronized without wait/notify causes a deadlock
	public synchronized void withdraw(int index, int qty)
			throws InterruptedException
	{
		// this will deadlock since replenish method cannot enter
		// synchronized method once we are already in this synchronized withdraw
		// method in a tight loop

		// while (stock[index] < qty)
		while (stock.get(index) < qty)
			;

		super.withdraw(index, qty);
	}
}