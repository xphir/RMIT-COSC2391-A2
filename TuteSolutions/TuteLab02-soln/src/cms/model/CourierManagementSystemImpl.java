package cms.model;

import java.util.HashMap;
import java.util.Map;

import cms.model.interfaces.CourierManagementSystem;
import cms.model.interfaces.Job;
import cms.model.interfaces.Vehicle;

// SADI Tutelab 2 Solution by Caspar
// Note how most of the work is done by the Vehicle and Job class hierarchies
public class CourierManagementSystemImpl implements CourierManagementSystem
{
	private Map<String, Job> jobs = new HashMap<String, Job>();
	private Map<String, Vehicle> vehicles = new HashMap<String, Vehicle>();

	@Override
	public void addVehicle(Vehicle v)
	{
		vehicles.put(v.getReg(), v);
	}

	@Override
	public void displayAllJobs()
	{
		for (Job j : jobs.values())
			System.out.println(j);
	}

	@Override
	public void displayAllVehicles()
	{
		for (Vehicle v : vehicles.values())
			System.out.println(v);
	}

	@Override
	public void displayJobInfo(String jobID)
	{
		Job j = getJob(jobID);
		if (j != null)
			System.out.println(j);
	}

	@Override
	public void displayVehicleInfo(String regNo)
	{
		Vehicle v = getVehicle(regNo);
		if (v != null)
			System.out.println(v);
	}

	@Override
	public Job getJob(String jobID)
	{
		return jobs.get(jobID);
	}

	@Override
	public void serviceVehicle(String regNo)
	{
		Vehicle toService = getVehicle(regNo);
		if (toService != null)
			toService.service();
	}

	@Override
	public Vehicle getVehicle(String regNo)
	{
		return vehicles.get(regNo);
	}

	@Override
	public void removeVehicle(String regNo)
	{
		vehicles.remove(regNo);
	}

	@Override
	public boolean scheduleJob(double distance, String regNo)
	{
		Job job = new SimpleJob(distance);
		boolean scheduled = job.scheduleVehicle(getVehicle(regNo));
		if (scheduled)
			jobs.put(job.getID(), job);
		// forward to Job to do the work
		return scheduled;
	}
}