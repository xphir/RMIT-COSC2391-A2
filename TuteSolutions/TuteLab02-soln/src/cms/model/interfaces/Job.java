package cms.model.interfaces;

//SADI Tutelab 2 Solution by Caspar
public interface Job
{
	public abstract double getDistance();

	public abstract double getExpense();

	public abstract double getProfit();

	public abstract double getCost();

	public abstract String getID();

	public abstract boolean scheduleVehicle(Vehicle vehicle);
}