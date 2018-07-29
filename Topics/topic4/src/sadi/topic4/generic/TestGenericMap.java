package sadi.topic4.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestGenericMap
{
	public static void main(String[] args)
	{
		String one = new String("one");
		String two = new String("one");

		System.out.println(one == two);
		// Map map = new TreeMap();
		Map<String, Account> map = new HashMap<String, Account>();

		map.put("account1", new Account("account1", "S123", 130.0));
		map.put("account2", new Account("account2", "S124", 90.0));
		// will cause a compile error due to type mismatch
		//		map.put(new Integer(1234), new Account("account3", "S126", 220.0));
		//		map.put("string", new String("account3"));
		Account acc = map.get("account1");
		System.out.println(acc.getName());
		System.out.println("Entries in Hashmap");
		displayMap(map);
	}

	//	public static void displayMap(Map<String, Account> m)
	//	{
	//		Set<String> keySet = m.keySet();
	//		Iterator<String> iterator = keySet.iterator();
	//		while (iterator.hasNext())
	//		{
	//			String key = iterator.next();
	//			System.out.println(key + ":" + m.get(key));
	//		}
	//	}

	// can do it with a generic utility method
	public static <K, V> void displayMap(Map<K, V> m)
	{
		Set<K> keySet = m.keySet();
		Iterator<K> iterator = keySet.iterator();
		while (iterator.hasNext())
		{
			K key = iterator.next();
			System.out.println(key + ":" + m.get(key));
		}
	}
}
