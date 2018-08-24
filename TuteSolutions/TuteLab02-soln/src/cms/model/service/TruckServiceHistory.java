package cms.model.service;

import cms.model.vehicle.Truck;

//SADI Tutelab 2 Solution by Caspar
public class TruckServiceHistory extends AbstractServiceHistory
{
	private double wearRate;

	// param type enforces that a "Truck" ServiceHistory must be associated to a Truck
	public TruckServiceHistory(Truck truck, double serviceInterval)
	{
		super(truck, serviceInterval);
		final double TONNE_DIVISOR = 1000.0;
		final double COST_PER_TONNE = 0.5;
		wearRate = (truck.getCapacity() / TONNE_DIVISOR) * COST_PER_TONNE;
	}

	@Override
	protected double getWearRate()
	{
		return wearRate;
	}
}
