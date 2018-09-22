package sadi.topic9.inventory;

import java.util.concurrent.atomic.AtomicIntegerArray;

// class for managing inventory of items
// refactored by Caspar to remove duplication
class AbstractInventory implements Inventory
{
	// protected int stock[]; // current stock levels
	// use AtomicIntegerArray instead for guaranteed thread safety
	// old array code commented and left for reference
	protected AtomicIntegerArray stock;

	/*
	 * Allows the user to specify the number of different items and their
	 * current stock levels
	 */
	public AbstractInventory(int num, int initial)
	{
		// stock = new int[num];
		stock = new AtomicIntegerArray(num);

		for (int i = 0; i < num; i++)
			// stock[i] = initial;
			stock.set(i, initial);
	}

	@Override
	public void replenish(int index, int qty)
	{
		String msg = String.format(
				"Thread Name: %s .. In replenish: Stock index = %d level = %d, qty = %d",
				Thread.currentThread().getName(), index, stock.get(index), qty);
		System.out.println(msg);

		// stock[index] += qty;
		stock.getAndAdd(index, qty);
	}

	@Override
	public void withdraw(int index, int qty) throws InterruptedException
	{
		String msg = String.format(
				"Thread Name: %s .. In withdraw: Stock index = %d level = %d, qty = %d",
				Thread.currentThread().getName(), index, stock.get(index), qty);
		System.out.println(msg);

		// int amount = stock[index] - qty;
		int amount = stock.get(index) - qty;
		if (amount < 0)
		{
			System.out.println("Stock level below 0 = " + amount
					+ " .. EXITING");
			System.exit(1);
		}
		// stock[index] = amount;
		stock.set(index, amount);
	}
}