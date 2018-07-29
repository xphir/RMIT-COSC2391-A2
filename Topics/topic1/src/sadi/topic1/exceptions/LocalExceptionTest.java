package sadi.topic1.exceptions;

public class LocalExceptionTest
{
	private static void numberTest(int num)
	{
		boolean valid = false;

		try
		{
			if (num < 0 || num > 9)
				throw new RangeException("out of range");
			else
				valid = true;
		}
		// specialised exceptions must come first (otherwise the asbtract
		// exception will always get caught)
		catch (RangeException e)
		{
			System.err.println(e.getMessage());
		}
		// catch any other unexpected exception
		catch (Exception ex)
		{
			// nothing much we can do so just print a stack trace and continue
			ex.printStackTrace();
		} finally
		{
			System.out.println("always do this");
		}

		if (valid)
			System.out.println("valid data");
	}

	public static void main(String args[])
	{
		numberTest(5);
		numberTest(12);
		numberTest(0);
		numberTest(-1);
	}
}
