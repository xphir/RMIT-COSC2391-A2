package cms.model.service;

import cms.model.aircraft.Aircraft;
import cms.model.interfaces.Job;

//SADI Tutelab 3 Solution by Caspar sem 1, 2018
public class AircraftServiceHistory extends AbstractServiceHistory
{
	// maximum flights between services
	private int maxFlights;
	// bidirectional reference back to the aircraft associated with this ServiceHistory
	private Aircraft aircraft;

	// param type enforces that a "Aircraft" ServiceHistory must be associated to a Aircraft
	public AircraftServiceHistory(Aircraft aircraft, int maxFlights, double serviceInterval)
	{
		// flightHours is odo
		super(aircraft, serviceInterval);
		this.aircraft = aircraft;
		this.maxFlights = maxFlights;
	}

	public int getMaxFlights()
	{
		return maxFlights;
	}

	@Override
	public void service()
	{
		// resets last service (hours)
		super.service();
		// additional action for Aircraft
		aircraft.setFlights(0);
	}

	@Override
	public double calculateWearAndTear(Job job) throws ServiceException
	{
		// estimated hours for this job
		double hours = job.getDistance() / aircraft.getAverageSpeed();

		// throw exception if service interval exceeded (total hours or number of flights)
		if (aircraft.getOdo() + hours >= lastService + serviceInterval || aircraft.getFlights() >= getMaxFlights())
			throw new ServiceException();

		// per km + base wear rate from spec
		final double COST_PER_KM = 5.0;
		return getWearRate() + job.getDistance() * COST_PER_KM;
	}

	@Override
	protected double getWearRate()
	{
		// base wear rate from spec
		final double BASE_WEAR_RATE = 30000.0;
		return BASE_WEAR_RATE;
	}

	@Override
	public String toString()
	{
		return String.format("%s\nFlights: %d, MaxFlights: %d", super.toString(), aircraft.getFlights(), maxFlights);
	}
}
