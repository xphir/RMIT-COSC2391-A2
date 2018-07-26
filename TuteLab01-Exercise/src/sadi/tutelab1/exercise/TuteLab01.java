package sadi.tutelab1.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sadi.tutelab00.part2.Course;

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
	static boolean doAgain;

	static Scanner scanner = new Scanner(System.in);

	static double volts[];
	static double amps[];
	static double resistance[];

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
		Power[] resultsArray = new Power[3];
		
		
		volts = new double[3];
		amps = new double[3];
		resistance = new double[3];

		scanner = new Scanner(System.in);

		System.out.println("Enter 3 pairs of V and I");

		resultsArray = doLoop(resultsArray);
		
		for (int count = 0; count < 3; count++)
		
		double vavg;
		vavg = getAvg(resultsArray);
		
		calculateVolts(resultsArray);
		calculateAmps(resultsArray);
		calculateResistance(resultsArray);
		
		printResult("V (Volts)", vavg, vmax, vmin);
		printResult("I (Amperes)", iavg, imax, imin);
		printResult("R (Ohms)", iavg, imax, imin);
		
	}
	
	public static void printResult(String title, double avg, double max, double min) {
		System.out.format("%s .. Avg= %.2f, Max= %.2f, Min= %.2f%n", title, avg, max, min);
	}


	public static double calculateVolts(Power[] inputArray) {	
		getAvg(volts);
		getMax(volts);
		getMin(volts);
	}
	
	public static double calculateAmps(Power[] inputArray) {
		setIavg(getAvg(amps));
		setImax(getMax(amps));
		setImin(getMin(amps));
	}
	
	public static double calculateResistance(Power[] inputArray) {
		setRavg(getAvg(resistance));
		setRmax(getMax(resistance));
		setRmin(getMin(resistance));
	}
	
	public static Power[] doLoop(Power[] inputArray) {
		for (int count = 0; count < 3; count++)
		{

			
			double voltageResult;
			double ampsResult;
			double resistanceResult;
			
			voltageResult = doSingle("Enter Voltage (V) in volts: ");
			
			ampsResult = doSingle("Enter Current (I) in amperes: ");

			resistanceResult = volts[count] / amps[count];

			System.out.format("Resistance R is %f ohms\n\n",resistance[count]);
			
			inputArray[count] = new Power(voltageResult, ampsResult, resistanceResult);
			
		}
		return inputArray;
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
}
