package sadi.topic9.inventory;

// BROKEN class for managing inventory of items - causes race condition and fails 
// refactored by Caspar to remove duplication
class InventoryWithRaceCondition extends AbstractInventory
{
	public InventoryWithRaceCondition(int num, int initial)
	{
		super(num, initial);
	}

	// not synchronized causes race condition
	public void replenish(int index, int qty)
	{
		super.replenish(index, qty);
	}

	// not synchronized causes race condition
	public void withdraw(int index, int qty) throws InterruptedException
	{
		// race condition (unsynchronized check-then-act)
		// while (stock[index] < qty)
		while (stock.get(index) < qty)
			; // inefficient loop to wait until stock becomes available (check)

		// act (which is dependent on the above check i.e. there is enough
		// stock)
		// but by the time we do the withdraw() another thread could win the
		// race and take the stock first therefore stock level goes below 0
		super.withdraw(index, qty);
	}
}