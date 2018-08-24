package cms.model.vehicle;

import cms.model.interfaces.ServiceHistory;
import cms.model.interfaces.Vehicle;

//SADI Tutelab 2 Solution by Caspar
public abstract class AbstractVehicle implements Vehicle
{
	private String reg;
	private String make;
	private String model;
	private int year;
	protected double odo = 0.0;
	protected ServiceHistory serviceHistory;

	public AbstractVehicle(String reg, String make, String model, int year, double odo)
	{
		this.reg = reg;
		this.make = make;
		this.model = model;
		this.year = year;
		this.odo = odo;
	}

	@Override
	public String getMake()
	{
		return make;
	}

	@Override
	public String getModel()
	{
		return model;
	}

	@Override
	public int getYear()
	{
		return year;
	}

	@Override
	public ServiceHistory getServiceHistory()
	{
		return serviceHistory;
	}

	@Override
	public String getReg()
	{
		return reg;
	}

	@Override
	public double getOdo()
	{
		return odo;
	}

	@Override
	public void incrementOdo(double distance)
	{
		odo += distance;
	}

	// included in Vehicle since CMSTestHarness requires it
	@Override
	public void service()
	{
		// forward to ServiceHistory who has the required data to do this
		serviceHistory.service();
	}

	@Override
	public String toString()
	{
		return String.format("Reg_Number: %s, Make: %s, Model: %s, Year: %d", reg, make, model, year);
	}
}