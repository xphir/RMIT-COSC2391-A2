public class StaticGenerics
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		// Gen.n == 1
		
		Gen<Object> myObjects = new Gen<Object>();
		// Gen.n == 2
		
		Gen<String> myStrings = new Gen<String>();
		// Gen.n == 3
		
		Gen<Integer> myInts = new Gen<Integer>();
		// Gen.n == 4
		
		myInts.print();
	}
}