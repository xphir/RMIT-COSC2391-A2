package cms.model.service;

import cms.model.vehicle.Van;

//SADI Tutelab 2 Solution by Caspar
public class VanServiceHistory extends AbstractServiceHistory
{
	// param type enforces that a "Van" ServiceHistory must be associated to a Van
	// (although we currently don't actually do anything Van specific)
	public VanServiceHistory(Van van, double odo, double serviceInterval)
	{
		super(van, serviceInterval);
	}

	@Override
	protected double getWearRate()
	{
		final double WEAR_RATE = 0.6; // 60c cents per km
		return WEAR_RATE;
	}
}
