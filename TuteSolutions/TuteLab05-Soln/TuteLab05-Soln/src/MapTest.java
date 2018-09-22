import java.util.HashMap;
import java.util.Map;

public class MapTest
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{
		// Hash map that maps employee number to accounts   	
		Map accountsMap = new HashMap();
		accountsMap.put("E123", "Charles");
		accountsMap.put("E174", "Matt");
		accountsMap.put("E542", "Brendan");
		accountsMap.put("E174", "Tobin");
		// calls AbstractMap.toString()
		System.out.println(accountsMap);
	}
}