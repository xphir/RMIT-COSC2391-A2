public class Gen<E>
{
	// initialised when class is loaded by JVM
	private static int n = 1;

	// run for each Gen object created
	public Gen()
	{
		n++;
	}

	public void print()
	{
		System.out.println("n is now " + n);
	}
}