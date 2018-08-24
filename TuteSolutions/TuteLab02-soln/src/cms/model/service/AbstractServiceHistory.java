package cms.model.service;

import cms.model.interfaces.Job;
import cms.model.interfaces.ServiceHistory;
import cms.model.interfaces.Vehicle;

//SADI Tutelab 2 Solution by Caspar
public abstract class AbstractServiceHistory implements ServiceHistory
{
	// could have made protected accessors but just keeping it simple
	// since is a fairly trivial class
	protected double lastService = 0.0;
	protected double serviceInterval = 0.0;
	protected Vehicle vehicle;

	public AbstractServiceHistory(Vehicle vehicle, double serviceInterval)
	{
		this.serviceInterval = serviceInterval;
		this.vehicle = vehicle;
	}

	@Override
	public double getLastService()
	{
		return lastService;
	}

	@Override
	public double getServiceInterval()
	{
		return serviceInterval;
	}

	// this is a "template" method 
	// it uses the implemented "primitive" method getWearRate() of subclasses!
	@Override
	public double calculateWearAndTear(Job job) throws ServiceException
	{
		// throw exception if service interval exceeded
		if (vehicle.getOdo() + job.getDistance() >= lastService + serviceInterval)
			throw new ServiceException();

		return job.getDistance() * getWearRate();
	}

	@Override
	public void service()
	{
		lastService = vehicle.getOdo();
	}

	// this is currently the only difference point of subclasses
	// overridden and used by the "template" method calculateWearAndTear() above
	protected abstract double getWearRate();

	@Override
	public String toString()
	{
		return String.format("Odometer: %.02fkm, Last Service: %.02fkm, Service Interval: %.02fkm", vehicle.getOdo(),
				lastService, serviceInterval);
	}
}