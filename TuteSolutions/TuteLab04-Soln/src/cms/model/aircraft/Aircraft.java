package cms.model.aircraft;

import cms.model.service.AircraftServiceHistory;
import cms.model.vehicle.AbstractVehicle;

//SADI Tutelab 4 Solution by Caspar
public class Aircraft extends AbstractVehicle
{
	private double averageSpeed;
	// number of flights since last service
	private int flights = 0;

	public Aircraft(String reg, String make, String model, int year, double averageSpeed, int maxFlights,
			double flightHours, double serviceInterval)
	{
		// Aircraft id treated as reg
		super(reg, make, model, year, flightHours);
		// aircraft has extra attribute
		this.averageSpeed = averageSpeed;
		// flightHours is treated as odo (since effectively the same thing)
		serviceHistory = new AircraftServiceHistory(this, maxFlights, serviceInterval);
	}

	// override odo since it is in hours not distance
	@Override
	public void incrementOdo(double distance)
	{
		// increment flying hours and number of flights
		odo += (distance / getAverageSpeed());
		flights++;
	}

	public double getAverageSpeed()
	{
		return averageSpeed;
	}

	public int getFlights()
	{
		return flights;
	}

	public void setFlights(int flights)
	{
		this.flights = flights;
	}

	@Override
	public String toString()
	{
		return String.format("Aircraft: %s, averageSpeed: %.02f\n%s", super.toString(), averageSpeed, serviceHistory
				.toString());
	}
}