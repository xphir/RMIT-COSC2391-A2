package cms.model.interfaces;

//SADI Tutelab 2 Solution by Caspar
public interface Vehicle
{
	public abstract String getReg();

	public abstract String getMake();

	public abstract String getModel();

	public abstract int getYear();

	public abstract double getOdo();

	public abstract void incrementOdo(double distance);

	public abstract ServiceHistory getServiceHistory();

	// this is required by CMSTestHarness.java otherwise would only put it in ServiceHistory
	public abstract void service();
}