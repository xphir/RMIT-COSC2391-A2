package sadi.tutelab1.exercise;

public class Power {
	private double volts;
	private double amps;
	private double resistance;
	
	public Power(double volts, double amps, double resistance) {
		super();
		this.volts = volts;
		this.amps = amps;
		this.resistance = resistance;
	}

	public double getVolts() {
		return volts;
	}

	public void setVolts(double volts) {
		this.volts = volts;
	}

	public double getAmps() {
		return amps;
	}

	public void setAmps(double amps) {
		this.amps = amps;
	}

	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
	}
	
	
}
