package sadi.tutelab1.solution;

// Caspar's Topic 1 tutelab solution
// 
// All variables are encapsulated as locals or passed as parameters
// All methods and constructor are private and encapsulated in this class
// Code repetition is removed through small helper methods
// Length dependency on input/arrays is removed
// 
// Ohm's law V=I/R .. https://en.wikipedia.org/wiki/Ohm%27s_law
public class TuteLab01
{
	// use a constant for the input size for future flexibility
	private static final int NUM_INPUTS = 3;

	public static void main(String[] args)
	{
		// instantiate the class to remove static references 
		// [which are best used for real static functions such as y=sin(x)]
		new TuteLab01();
	}

	// I do the main work in the constructor since this is basically a single use class
	// but could extract into a separate worker method if preferred
	private TuteLab01()
	{
		// keep arrays local and pass where necessary
		double volts[] = new double[NUM_INPUTS];
		double amps[] = new double[NUM_INPUTS];
		double resistance[] = new double[NUM_INPUTS];

		System.out.printf("Enter %d pairs of V and I\n", NUM_INPUTS);

		for (int i = 0; i < NUM_INPUTS; i++)
		{
			// we put the input method in a separate class since it is general purpose/reusable
			volts[i] = ScannerUtils.nextDoubleValidated("Enter Voltage (V) in volts: ");
			amps[i] = ScannerUtils.nextDoubleValidated("Enter Current (I) in amperes: ");
			resistance[i] = volts[i] / amps[i];
			System.out.printf("Resistance (R) is %.2f ohms\n\n", resistance[i]);
		}

		// print the summary info (note the code reuse by passing the relevant array)
		printSummary("V (Volts)", volts);
		printSummary("I (Amperes)", amps);
		printSummary("R (Resistance)", resistance);
	}

	// helper methods to calculate avg, min and max without length dependency
	// these could go in an external class as static methods since they are reusable but can be private for this example
	private double calcArrayAvg(double[] array)
	{
		double sum = 0.0;
		for (double next : array)
			sum += next;
		// no length dependency
		return sum / array.length;
	}

	private double calcArrayMax(double[] array)
	{
		// the first number will be more (unless it is already Double.MIN_VALUE) to get us started
		double max = Double.MIN_VALUE;
		// for each loop
		for (double next : array)
			if (next > max)
				max = next;
		return max;
	}

	private double calcArrayMin(double[] array)
	{
		// the first number will be less (unless it is already Double.MAX_VALUE) to get us started
		double min = Double.MAX_VALUE;
		// for each loop
		for (double next : array)
			// use ternary operator instead of if this time :)
			min = (next < min) ? next : min;
		return min;
	}

	// this little helper method prints our stats with no code repetition :)
	private void printSummary(String label, double[] array)
	{
		// no unnecessary variables just call the function and display its output via printf!
		System.out.printf("%s .. Avg=%.2f, Max=%.2f, Min=%.2f\n", label, calcArrayAvg(array), calcArrayMax(array),
				calcArrayMin(array));
	}
}
