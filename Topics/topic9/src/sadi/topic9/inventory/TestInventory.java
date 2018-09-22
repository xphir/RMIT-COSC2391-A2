package sadi.topic9.inventory;

// refactored by Caspar
public class TestInventory
{
	public static void main(String args[])
	{
		new TestInventory();
	}

	public TestInventory()
	{
		// checking pre-condition with assertion
		try
		{

			// Creating an inventory of 5 stock items all with 100 stock level
			// uncomment only one inv declaration to test working and non working
			// versions

			//Inventory inv = new InventoryWithRaceCondition(5, 100);
			//Inventory inv = new InventoryDeadlock(5, 100);
			Inventory inv = new InventorySynchronized(5, 100);
			//Inventory inv = new InventorySynchronizedBlock(5, 100);
			//Inventory inv = new InventoryLocks(5, 100);
			// We create i threads for withdrawing
			// and i threads for replenishing

			for (int i = 0; i < 10; i++)
				new ReplenishThread(inv, i % (Inventory.MAX_INVENTORY_INDEX
						+ 1)).start();

			for (int i = 0; i < 10; i++)
				new WithdrawThread(inv, i % (Inventory.MAX_INVENTORY_INDEX + 1))
						.start();
		} catch (AssertionError e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}
}
