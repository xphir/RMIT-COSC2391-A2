package cms.model.vehicle;

import cms.model.service.VanServiceHistory;

//SADI Tutelab 2 Solution by Caspar
public class Van extends AbstractVehicle
{
	public Van(String reg, String make, String model, int year, double odo, double serviceInterval)
	{
		super(reg, make, model, year, odo);
		// van differs only on its ServiceHistory
		serviceHistory = new VanServiceHistory(this, odo, serviceInterval);
	}

	@Override
	public String toString()
	{
		return String.format("Van: %s\n%s", super.toString(), serviceHistory.toString());
	}
}