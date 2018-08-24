package cms.model.vehicle;

import cms.model.service.TruckServiceHistory;

//SADI Tutelab 2 Solution by Caspar
public class Truck extends AbstractVehicle
{
	private int capacity;

	public Truck(String reg, String make, String model, int year, double odo, double serviceInterval, int capacity)
	{
		super(reg, make, model, year, odo);
		// truck has a capacity and a different ServiceHistory
		this.capacity = capacity;
		serviceHistory = new TruckServiceHistory(this, serviceInterval);
	}

	public int getCapacity()
	{
		return capacity;
	}

	@Override
	public String toString()
	{
		return String.format("Truck: %s, Capacity: %dt\nService History: %s", super.toString(), capacity, serviceHistory
				.toString());
	}
}