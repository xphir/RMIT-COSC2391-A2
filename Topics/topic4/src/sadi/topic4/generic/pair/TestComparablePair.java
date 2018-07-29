package sadi.topic4.generic.pair;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import sadi.topic4.generic.Customer;

// refactored by Caspar
public class TestComparablePair
{
	public static void main(String args[])
	{
		ComparablePair<String> pair1 = new ComparablePair<String>("10+5", "20+5");
		ComparablePair<String> pair2 = new ComparablePair<String>("15", "25");

		SortedSet<ComparablePair<String>> pairSet = new TreeSet<ComparablePair<String>>();
		pairSet.add(pair1);
		pairSet.add(pair2);

		// log the pairs
		for (ComparablePair<String> pair : pairSet)
			System.out.println(pair);

		System.out.printf("Comparing pairs (true)=%b\n", pair1.compareTo(pair1) == 0 ? true : false);
		System.out.printf("Comparing pairs (false)=%b\n", pair1.compareTo(pair2) == 0 ? true : false);

		ComparablePair<Customer> pair3 = new ComparablePair<Customer>(new Customer(), new Customer());

		System.out.println("Max is " + pair3.max());

		// some advanced code I was working on .. can ignore for now!
		//testLambdaComparison();
	}

	@SuppressWarnings("unused")
	private static void testLambdaComparison()
	{
		SortedSet<ComparablePair<String>> pairSet = new TreeSet<ComparablePair<String>>(
				new Comparator<ComparablePair<String>>()
				{

					@Override
					public int compare(ComparablePair<String> pair1, ComparablePair<String> pair2)
					{
						return pair1.compareTo(pair2);
					}

				});

		Comparator<ComparablePair<String>> comparator = (pair1, pair2) -> pair1.compareTo(pair2);

		SortedSet<ComparablePair<String>> lambdaSet = new TreeSet<ComparablePair<String>>(comparator);

	}
}
