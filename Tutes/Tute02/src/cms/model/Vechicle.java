package cms.model;

public class Vechicle {
	private String RegistrationNumber;
	private String Make;
	private String Model;
	private int Year;
	private double Odometer; //in KM
	private double LastServicePoint; //in KM - the odometer reading at the time the vehicle was last serviced
	private double ServiceInterval; //in KM - The maximum distance a vehicle can travel before it has to be serviced again
	
	public Vechicle(String registrationNumber, String make, String model, int year, double odometer, double serviceInterval) {
		super();
		RegistrationNumber = registrationNumber;
		Make = make;
		Model = model;
		Year = year;
		Odometer = odometer;
		ServiceInterval = serviceInterval;
	}

	
	/**
	 * 
	 * This information is specific to each vehicle, 
	 * and should not be modifiable once the 
	 * initial information is entered.
	 * 
	 */
	
}
