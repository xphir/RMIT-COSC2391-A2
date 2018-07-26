package sadi.tutelab1.exercise;

import java.util.Scanner;

// Topic 1 tutelab exercise written by Caspar
// this code lacks cohesion and encapsulation and is a prime example of how NOT to write code that is readable/reusable/extensible!
// i.e. it is poor quality code ;)
//
// TODO: fix it by extracting methods and choosing appropriate use of local variables and parameters
//       consider the use of static variables as well and use printf where appropriate
//
// Ohm's law V=I/R .. https://en.wikipedia.org/wiki/Ohm%27s_law
public class TuteLab01
{
	static double volts[];
	static double amps[];
	static double resistance[];
	static Scanner scanner = new Scanner(System.in);
	static boolean doAgain;
	static double vavg;
	static double vmax;
	static double vmin;
	static double iavg;
	static double imax;
	static double imin;
	static double ravg;
	static double rmax;
	static double rmin;

	public static void main(String[] args)
	{
		volts = new double[3];
		amps = new double[3];
		resistance = new double[3];

		scanner = new Scanner(System.in);

		System.out.println("Enter 3 pairs of V and I");

		doLoop();

		calculateVolts();
		calculateAmps();
		calculateResistance();
		
		System.out.format("V (Volts) .. Avg=%f, Max=%f, Min=%f%n", vavg,vmax,vmin);
		

		System.out.format("I (Amperes) .. Avg=%f, Max=%f, Min=%f%n", iavg,imax,imin);
		

		System.out.format("R (Ohms) .. Avg=%f, Max=%f, Min=%f%n", ravg,rmax,rmin);

		
	}
	



	public static void calculateVolts() {	
		setVavg(getAvg(volts));
		setVmax(getMax(volts));
		setVmin(getMin(volts));
	}
	
	public static void calculateAmps() {
		setIavg(getAvg(amps));
		setImax(getMax(amps));
		setImin(getMin(amps));
	}
	
	public static void calculateResistance() {
		setRavg(getAvg(resistance));
		setRmax(getMax(resistance));
		setRmin(getMin(resistance));
	}
	
	public static void doLoop() {
		
		for (int count = 0; count < 3; count++)
		{
			volts[count] = doSingle("Enter Voltage (V) in volts: ");

			amps[count] = doSingle("Enter Current (I) in amperes: ");

			resistance[count] = volts[count] / amps[count];

			System.out.format("Resistance R is %f ohms\n\n",resistance[count]);
		}
	}
	
	
	public static double doSingle(String printToScreen) {
		doAgain = true;
		double value;
		do
		{
			value = getValue(printToScreen);
		}
		while (doAgain == true);

		return value;
	}
	

	public static double getAvg(double inputArray[] ) {
		double avg = 0;
		double total = 0;
		for (int i = 0; i < inputArray.length; i++)
		{
		     total = total + inputArray[i];
		}
		avg = total / inputArray.length;
		return avg;
	}
	
	public static double getMin(double inputArray[] ) {
		double min = inputArray[0];
		for (int i = 0; i < inputArray.length; i++)
		{
		     if (inputArray[i] < min)
		     {
		      min = inputArray[i];
		     }
		}
		return min;
	}
	
	public static double getMax(double inputArray[] ) {
		double max = inputArray[0];
		for (int i = 0; i < inputArray.length; i++)
		{
		     if (inputArray[i] > max)
		     {
		      max = inputArray[i];
		     }
		}
		return max;
	}
	
	public static double getValue(String printToScreen) {
		double num = 0;
		try
		{
			System.out.print(printToScreen);
			// parseDouble() will "throw" an exception if a number is not
			// entered. Execution then immediately moves to catch block
			num = Double.parseDouble(scanner.nextLine());
			doAgain = false;
		}
		catch (NumberFormatException nfe)
		{
			// we don't really need to do anything here since we will just loop and try again, but could.
		}
		return num;
	}




	public static double getVavg() {
		return vavg;
	}




	public static void setVavg(double vavg) {
		TuteLab01.vavg = vavg;
	}




	public static double getVmax() {
		return vmax;
	}




	public static void setVmax(double vmax) {
		TuteLab01.vmax = vmax;
	}




	public static double getVmin() {
		return vmin;
	}




	public static void setVmin(double vmin) {
		TuteLab01.vmin = vmin;
	}




	public static double getIavg() {
		return iavg;
	}




	public static void setIavg(double iavg) {
		TuteLab01.iavg = iavg;
	}




	public static double getImax() {
		return imax;
	}




	public static void setImax(double imax) {
		TuteLab01.imax = imax;
	}




	public static double getImin() {
		return imin;
	}




	public static void setImin(double imin) {
		TuteLab01.imin = imin;
	}




	public static double getRavg() {
		return ravg;
	}




	public static void setRavg(double ravg) {
		TuteLab01.ravg = ravg;
	}




	public static double getRmax() {
		return rmax;
	}




	public static void setRmax(double rmax) {
		TuteLab01.rmax = rmax;
	}




	public static double getRmin() {
		return rmin;
	}




	public static void setRmin(double rmin) {
		TuteLab01.rmin = rmin;
	}
}
