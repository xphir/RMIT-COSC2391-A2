package sadi.topic9.inventory;

class WithdrawThread extends Thread
{
	private Inventory inventory;
	private int index;

	/*
	 * Constructor takes a reference to Inventory object and the index of the
	 * stock item it will update
	 */
	public WithdrawThread(Inventory inventory, int index)
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
			int qty = (int) (100 * Math.random()); // qty = 1 to 100
			try
			{
				inventory.withdraw(index, qty);
				Thread.sleep((int) (5 * Math.random())); // sleep 1 to 5 ms
			} catch (InterruptedException ex)
			{
			}
		}
	}
}