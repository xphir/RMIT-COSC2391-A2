package cms.model.vehicle;

import cms.model.Vechicle;

public class Truck extends Vechicle{
	private double loadCapacity;

	public Truck(String registrationNumber, String make, String model, int year, double odometer,
			double serviceInterval, double loadCapacity) {
		super(registrationNumber, make, model, year, odometer, serviceInterval);
		loadCapacity = loadCapacity;
		// TODO Auto-generated constructor stub
	}

	
}
