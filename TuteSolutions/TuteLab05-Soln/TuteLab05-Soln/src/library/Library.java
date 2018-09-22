package library;

import java.util.ArrayList;
import java.util.List;


// from topic4
public class Library<E extends Media>
{
	private List<E> resources = new ArrayList<E>();

	public void add(E x)
	{
		resources.add(x);
	}

	public E retrieveLast()
	{
		int size = resources.size();
		if (size > 0)
		{
			return resources.get(size - 1);
		}
		return null;
	}

	
	public void print()
	{
		System.out.println("Library: { ");
		for (E e : resources)
		{
			e.print();
		}
		System.out.print(" }");
	}
	
	
}