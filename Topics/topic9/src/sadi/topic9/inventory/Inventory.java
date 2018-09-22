package sadi.topic9.inventory;

interface Inventory
{
	public static final int MAX_INVENTORY_INDEX = 4; // indices 0-4

	// specify the index of stock item and quantity to be replenished
	public abstract void replenish(int index, int qty);

	// specify the index of stock item and quantity to be withdrawn
	public abstract void withdraw(int index, int qty)
			throws InterruptedException;
}