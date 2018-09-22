package sadi.topic9.inventory;

class ReplenishThread extends Thread
{
	private Inventory inventory;
	private int index;

	/*
	 * Constructor takes a reference to Inventory object and the index of the
	 * stock item it will update
	 */
	public ReplenishThread(Inventory inventory, int index)
	{
		// PRE-CONDITION
		assert inventory != null
				&& index <= Inventory.MAX_INVENTORY_INDEX : "check pre-condition inventory != null && index <= Inventory.MAX_INVENTORY_INDEX";

		this.inventory = inventory;
		this.index = index;
	}

	@Override
	public void run()
	{
		while (true)
		{
			// changing the ratio of replenish to withdraw changes the relative
			// number of calls
			// to replenish and withdraw
			int qty = (int) (50 * Math.random()); // qty = 1-50
			inventory.replenish(index, qty);
			try
			{
				Thread.sleep((int) (10 * Math.random())); // sleep 1 - 10 ms
			} catch (InterruptedException ex)
			{
			}
		}
	}
}