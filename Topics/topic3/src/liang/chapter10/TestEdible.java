package liang.chapter10;

public class TestEdible
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Animal[] animals =
		{ new Tiger(), new Chicken() };
		Edible[] edibles =
		{ new Chicken(), new Apple() };
		int cal = Edible.CALORIES;
		for (int i = 0; i < edibles.length; i++)
			showObject(edibles[i]);
	}

	public static void showObject(Edible object)
	{
		// if (object instanceof Edible)
		System.out.println(object.howToEat());
	}
}

class Fruit implements Edible
{
	public String howToEat()
	{
		return "Eat it fresh";
	}
}

class Apple extends Fruit
{
	public String howToEat()
	{
		return "Make apple cider";
	}
}

class Orange extends Fruit
{
	public String howToEat()
	{
		return "Make orange juice";
	}
}

class Animal
{
	static final int DEFAULT_WEIGHT = 5;
}

@SuppressWarnings("rawtypes")
class Chicken extends Animal implements Edible, Comparable
{
	int weight;

	public Chicken()
	{
		weight = DEFAULT_WEIGHT;
	}

	public Chicken(int weight)
	{
		this.weight = weight;
	}

	public String howToEat()
	{
		return "Fry it";
	}

	public int compareTo(Object o)
	{
		return weight - ((Chicken) o).weight;
	}
}

class Tiger extends Animal
{
}
