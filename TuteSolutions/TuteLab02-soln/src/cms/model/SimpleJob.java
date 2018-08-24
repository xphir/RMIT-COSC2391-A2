package cms.model;

import cms.model.interfaces.Job;
import cms.model.interfaces.Vehicle;
import cms.model.service.ServiceException;

//SADI Tutelab 2 Solution by Caspar
public class SimpleJob implements Job
{
	// used to increment id's
	private static int maxID = 0;

	private String id;
	private double distance;
	private double expense;
	private double profit;
	private double cost;

	public SimpleJob(double distance)
	{
		// quick and dirty ID generation
		this.id = Integer.toString(maxID++);
		this.distance = distance;
	}

	@Override
	public String getID()
	{
		return id;
	}

	@Override
	public double getDistance()
	{
		return distance;
	}

	@Override
	public double getExpense()
	{
		return expense;
	}

	@Override
	public double getProfit()
	{
		return profit;
	}

	@Override
	public double getCost()
	{
		return cost;
	}

	@Override
	public boolean scheduleVehicle(Vehicle vehicle)
	{
		try
		{
			expense = vehicle.getServiceHistory().calculateWearAndTear(this);
		}
		catch (ServiceException e)
		{
			// was not fit for service so return false
			return false;
		}

		final double PROFIT_MARGIN = .50; // +50%
		// calculate financials
		profit = expense * PROFIT_MARGIN;
		cost = expense + profit;
		// update service history for job
		vehicle.incrementOdo(distance);

		return true;
	}

	@Override
	public String toString()
	{
		return String.format("ID: %s, Distance: %.2fkm, Cost: $%.2f, Expense: $%.2f, Profit: $%.2f", id, distance, cost,
				expense, profit);
	}
}