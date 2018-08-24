package cms.model.interfaces;

// SADI Tutelab 2 Solution by Caspar
// Interface based on requirements of CMSTestHarness.java
public interface CourierManagementSystem
{
	public abstract void addVehicle(Vehicle v);

	public abstract void displayAllJobs();

	public abstract void displayAllVehicles();

	public abstract void displayJobInfo(String jobID);

	public abstract void displayVehicleInfo(String regNo);

	public abstract Job getJob(String jobID);

	public abstract void serviceVehicle(String regNo);

	public abstract Vehicle getVehicle(String regNo);

	public abstract void removeVehicle(String regNo);

	public abstract boolean scheduleJob(double distance, String regNo);
}