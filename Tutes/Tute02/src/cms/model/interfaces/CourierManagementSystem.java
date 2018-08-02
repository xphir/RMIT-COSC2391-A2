package cms.model.interfaces;

import cms.model.vehicle.Truck;
import cms.model.vehicle.Van;

public interface CourierManagementSystem {

	boolean scheduleJob(double distance, String reg);

	void addVehicle(Truck truck);

	void displayAllVehicles();

	void displayVehicleInfo(String string);

	void addVehicle(Van van);

	void serviceVehicle(String string);

	void displayAllJobs();


}
